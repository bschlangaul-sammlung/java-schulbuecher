package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.zusaetzliches_projekt_03.platzbuchung_mit_maxclientanzahl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * serverseitig laufender Prozess pro Clientverbindung zur Bearbeitung der
 * Kommunikation bei der PLATZBUCHUNG2<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class CLIENTPROZESSZ2 extends Thread
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung des
     * Clients
     */
    private Socket clientSocket = null;

    /**
     * Schreibkanal zum Client
     */
    private PrintWriter zumClient = null;

    /**
     * Lesekanal vom Client
     */
    private BufferedReader vomClient = null;

    /**
     * Referenz auf die Klasse, die das Zustandsdiagramm des Servers
     * implementiert
     */
    private PLATZBUCHUNG2 serververhalten;

    /**
     * Botschaft von Client zum Server
     */
    private String clientBotschaft = null;

    /**
     * Botschaft vom Server zum Client
     */
    private String serverAntwort = null;

    /**
     * Referenz auf den Server,<br/>
     * wird in der Methode ClientVerbindungStarten() gebraucht weil das
     * Serververhalten eine Referenz auf den Server benötigt.
     */
    SERVERZ5 server;

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
    public CLIENTPROZESSZ2(Socket clientSocket, SERVERZ5 server,
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
        serververhalten = new PLATZBUCHUNG2(this.server);
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
        System.out.println("Clientverbindung beendet");
    }

    /**
     * liest die Nachrichten vom Client, ermittelt die Antwort unter Verwendung
     * der Klasse PLATZBUCHUNG2 und schickt die Anwort zum Client.
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
