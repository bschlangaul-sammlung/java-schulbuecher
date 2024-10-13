package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_07.buchungssimulation;

import java.net.*;
import java.io.*;

/**
 * serverseitig laufender Prozess je Client zur Bearbeitung der Kommunikation
 * einer Clientverbindung bei der Platzbuchung<br/>
 * Vorlage für die Aufgabe 2 des Kapitels 2.3.3<br/>
 * Die Stellen, an denen eine Quelltextergänzung notwendig ist, sind mit
 * "Quelltextergänzung" gekennzeichnet.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class CLIENTPROZESS2 extends Thread
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
    private PLATZBUCHUNG serververhalten;

    /** Botschaft von Client zum Server */
    private String clientBotschaft = null;

    /** Botschaft vom Server zum Client */
    private String serverAntwort = null;

    /**
     * Referenz auf den Server,<br/>
     * wird in der Methode ClientVerbindungStarten() gebraucht weil das
     * Serververhalten eine Referenz auf den Server benötigt.
     */
    SERVER5 server;

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
     */
    public CLIENTPROZESS2(Socket clientSocket, SERVER5 server)
            throws IOException
    {
        this.clientSocket = clientSocket;
        this.server = server;
        ClientVerbindungStarten();
    }

    /**
     * wartet auf eine Clientverbindung und erzeugt die nötigen Lese- und
     * Schreibobjekte nach dem eine Verbindung hergestellt wurde
     */
    private void ClientVerbindungStarten() throws IOException
    {
        zumClient = new PrintWriter(clientSocket.getOutputStream(), true);
        vomClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        // Protokoll-Klasse zur Ermittlung der Serverantworten
        serververhalten = new PLATZBUCHUNG(this.server);
        // Begrüßung
        serverAntwort = serververhalten.HoleAntwort("");
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
