package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_10.chatserver;

import java.net.*;
import java.io.*;

/**
 * serverseitig laufender Prozess je Client zur Bearbeitung der Kommunikation
 * einer Clientverbindung<br/>
 * - über die Startbotschaft, die im Konstruktor übergeben wird, kann das Senden
 * des Stoppsignals für den Client veranlasst werden.<br/>
 * - das frühere Serververhalten ist in diese Klasse integriert.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class CLIENTPROZESS extends Thread
{
    /** Referenz auf den Server */
    private CHATSERVER server;

    /** Socket des Clients */
    private Socket clientSocket = null;

    /** Datenstrom zum Client */
    private PrintWriter zumClient = null;

    /** Datenstrom vom Client */
    private BufferedReader vomClient = null;

    /** Spitzname des Clients, muss einmalig sein! */
    private String spitzname;

    /** Konstante für den Zustand Wartend des Threads */
    private static final int wartend = 0;

    /**
     * Konstante für den Zustand angemeldet (in der clientprozessliste des
     * Servers aufgenommen) des Threads
     */
    private static final int angemeldet = 1;

    /** speichert den aktuellen Zustand des Clientprozesses */
    private int zustand = wartend;

    /**
     * Konstruktor des Clientprozesses
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br />
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br />
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     *
     * @param clientSocket die Socketverbindung, über die die Kommunikation
     *     stattfindet.
     * @param server Referenz auf den Server, wird beim Beenden des Prozesses
     *     benötigt.
     * @param startbotschaft ist die Startbotschaft gleich "toomuchclients" so
     *     wird das Clientstopsignal gesendet.
     */
    public CLIENTPROZESS(Socket clientSocket, CHATSERVER server,
            String startbotschaft) throws IOException
    {
        this.clientSocket = clientSocket;
        this.server = server;
        ClientVerbindungStarten(startbotschaft);
    }

    /**
     * Verbindung herstellen, falls die Startbotschaft "toomuchclients" lautet,
     * wird das Beendensignal an den Client gesendet! der Thread wird in diesem
     * Fall nicht vom Server gestartet und braucht deshalb auch nicht beendet
     * werden.
     *
     * @param startbotschaft
     */
    public void ClientVerbindungStarten(String startbotschaft)
            throws IOException
    {
        zumClient = new PrintWriter(clientSocket.getOutputStream(), true);
        vomClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        EingabeVerarbeiten(startbotschaft);
    }

    /**
     * Implementierung des Zustandsdiagramms des Prozesses
     *
     * @param textvomclient der zu verarbeitende Text
     *
     * @return false, falls der Client beendet werden soll.
     */
    private boolean EingabeVerarbeiten(String textvomclient)
    {
        String ausgabe = null;
        if (textvomclient.equalsIgnoreCase("beenden"))
        {
            // Server[stopClient]: zu Beginn der Nachricht beendet den Client.
            ausgabe = "Server[stopClient]: Auf Wiedersehen!";
            server.PrivateNachrichtSenden(this, ausgabe);
            return false; // beendet clientprozess
        }
        if (textvomclient.equalsIgnoreCase("toomuchclients"))
        {// Thread laeuft noch nicht.
            ausgabe = "Server[stopClient]: maximale Anzahl der Verbindungen erreicht!";
            server.PrivateNachrichtSenden(this, ausgabe);
            return false; // beendet clientprozess
        }
        switch (zustand)
        {
        case wartend:
            if (textvomclient.equalsIgnoreCase(""))
            {
                ausgabe = "Server bereit, bitte geben Sie Ihren Namen ein!";
            }
            else
            {
                // hier prüfen, ob Name bereits existiert.
                if (server.SpitznameVorhanden(textvomclient))
                {
                    ausgabe = "Server: " + textvomclient
                            + " ist als Name nicht moeglich, bitte geben Sie einen anderen Namen ein:";
                    zustand = wartend;
                }
                else
                {
                    spitzname = textvomclient;
                    // hier prüfen, ob evtl. maximale Clientanzahl erreicht ist!
                    if (server.ClientProzessHinzufuegen(this))
                    {
                        ausgabe = "Server: Hallo " + textvomclient + "!";
                        zustand = angemeldet;
                    }
                    else
                    {
                        ausgabe = "Server[stopClient]: Auf Wiedersehen!";
                        server.PrivateNachrichtSenden(this, ausgabe);
                        return false; // beendet clientprozess
                    }
                }
            }
            server.PrivateNachrichtSenden(this, ausgabe);
            break;

        case angemeldet:
            ausgabe = spitzname + ": " + textvomclient;
            server.AnAlleSenden(ausgabe);
            break;
        }
        return true;
    }

    /**
     * gibt den Spitznamen des Chatters zurück
     *
     * @return der Wert des Attributs spitzname
     */
    public String SpitznameHolen()
    {
        return this.spitzname;
    }

    /**
     * Nachricht an den zugehörigen Client senden.
     *
     * @param nachricht der Text der Nachricht
     */
    public void Senden(String nachricht)
    {// wird vom Server aufgerufen.
        zumClient.println(nachricht);
    }

    /**
     * beendet die Clientverbindung
     */
    private void ClientVerbindungBeenden() throws IOException
    {
        zumClient.close();
        vomClient.close();
        server.ClientProzessEntfernen(this);
    }

    /**
     * liest die Nachrichten vom Client, ermittelt die Antwort schickt die
     * Antwort zum Client.
     */
    @Override
    public void run()
    {
        String clientBotschaft = null; // Botschaft von Client zum Server
        try
        {
            do
            {// lesen und antworten
                clientBotschaft = vomClient.readLine();
            }
            while (EingabeVerarbeiten(clientBotschaft));
            ClientVerbindungBeenden();
        }
        catch (IOException e)
        {
            System.out.println("Fehler im Clientprozess");
        }
    }
}
