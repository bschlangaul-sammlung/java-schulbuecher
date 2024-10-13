package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.zusaetzliches_projekt_01.maximaleclient_anzahl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * serverseitig laufender Prozess je Client zur Bearbeitung der Kommunikation
 * einer Clientverbindung<br/>
 * über die Startbotschaft, die im Konstruktor übergeben wird, kann das Senden
 * des Stoppsignals für den Client veranlasst werden.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class CLIENTPROZESSZ1 extends Thread
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung des
     * Clients
     */
    private Socket clientSocket = null;

    /** Schreibkanal zum Client */
    private PrintWriter zumClient = null;

    /** Lesekanal vom Client */
    private BufferedReader vomClient = null;

    /**
     * Referenz auf die Klasse, die das Zustandsdiagramm des Servers
     * implementiert
     */
    private WETTERVERHALTENZ2 serververhalten;

    /** Botschaft von Client zum Server */
    private String clientBotschaft = null;

    /** Botschaft vom Server zum Client */
    private String serverAntwort = null;

    /**
     * Referenz auf den Server,<br/>
     * wird zum Beenden des Clientprozesses gebraucht um die Methode
     * ClientProzessEntfernen() des Servers aufzurufen.
     */
    private SERVERZ3 server;

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
    public CLIENTPROZESSZ1(Socket clientSocket, SERVERZ3 server,
            String startbotschaft) throws IOException
    {
        this.clientSocket = clientSocket;
        this.server = server;
        ClientVerbindungStarten(startbotschaft);
    }

    /**
     * wartet auf eine Clientverbindung und erzeugt die nötigen Lese- und
     * Schreibobjekte nach dem eine Verbindung hergestellt wurde
     */
    private void ClientVerbindungStarten(String startbotschaft)
            throws IOException
    {
        zumClient = new PrintWriter(clientSocket.getOutputStream(), true);
        vomClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        // Protokoll-Klasse zur Ermittlung der Serverantworten
        serververhalten = new WETTERVERHALTENZ2();
        // Begrüßung
        serverAntwort = serververhalten.HoleAntwort(startbotschaft);
        zumClient.println(serverAntwort);
        System.out.println("Client verbunden");
    }

    /**
     * beendet die Clientverbindung
     */
    private void ClientVerbindungBeenden() throws IOException
    {
        zumClient.close();
        vomClient.close();
        clientSocket.close();
        server.ClientProzessEntfernen(this);
        System.out.println("Clientverbindung beendet");
    }

    /**
     * liest die Nachrichten vom Client, ermittelt die Antwort unter Verwendung
     * der Klasse WETTERVERHALTEN2 und schickt die Anwort zum Client.
     */
    @Override
    public void run()
    {
        try
        {
            do
            {// lesen und antworten
                clientBotschaft = vomClient.readLine();
                serverAntwort = serververhalten.HoleAntwort(clientBotschaft);
                zumClient.println(serverAntwort);
            }
            while (!serverAntwort.startsWith("Server[stopClient]:"));
            ClientVerbindungBeenden();
        }
        catch (IOException e)
        {
            System.out.println("Fehler im Clientprozess");
        }
    }
}
