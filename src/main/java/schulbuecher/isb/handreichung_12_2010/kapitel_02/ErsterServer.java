package schulbuecher.isb.handreichung_12_2010.kapitel_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Erste Serverimplementierung, keine Parallelität
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class ErsterServer
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung des
     * Servers
     */
    private ServerSocket serverSocket = null;

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
    private ServerVerhalten serverVerhalten;

    /**
     * Botschaft von Client zum Server
     */
    private String clientBotschaft = null;

    /**
     * Botschaft vom Server zum Client
     */
    private String serverAntwort = null;

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public ErsterServer(ServerVerhalten serverVerhalten) throws IOException
    {
        this.serverVerhalten = serverVerhalten;
        ServerStarten();
        ClientVerbindungStarten(); // auf Client warten und verbinden
        do
        {// lesen und antworten
            clientBotschaft = vomClient.readLine();
            serverAntwort = serverVerhalten.HoleAntwort(clientBotschaft);
            zumClient.println(serverAntwort);
        }
        while (!serverAntwort.equals("Auf Wiedersehen!"));
        ClientVerbindungBeenden();
        ServerStoppen();
    }

    /**
     * fragt den Port ab und erzeugt den Serversocket
     */
    private void ServerStarten() throws IOException
    {
        System.out.println("Port eingeben: ");
        BufferedReader tastatur = new BufferedReader(
                new InputStreamReader(System.in));
        // Server Socket erzeugen
        serverSocket = new ServerSocket(Integer.parseInt(tastatur.readLine()));
        System.out.println("Server gestartet...");
    }

    /**
     * schließt den Serversocket
     */
    private void ServerStoppen() throws IOException
    {
        serverSocket.close();
        System.out.println("Server gestoppt...");
    }

    /**
     * wartet auf eine Clientverbindung warten und erzeugt die nötigen Lese- und
     * Schreibobjekte nach dem eine Verbindung hergestellt wurde
     */
    private void ClientVerbindungStarten() throws IOException
    {
        clientSocket = serverSocket.accept(); // warten auf die Verbindung
        zumClient = new PrintWriter(clientSocket.getOutputStream(), true);
        vomClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        // Begrueßung
        serverAntwort = serverVerhalten.HoleAntwort("");
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
}
