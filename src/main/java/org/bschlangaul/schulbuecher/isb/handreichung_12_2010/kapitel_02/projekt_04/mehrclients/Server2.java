package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_04.mehrclients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serverimplementierung mit Möglichkeit zum Beenden der Clientverbindung<br/>
 * Lösung der Aufgabe 1 des Kapitels 2.3.3<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Server2
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
    private WetterVerhalten2 serververhalten;

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
    public Server2() throws IOException
    {
        ServerStarten();
        ClientVerbindungStarten(); // auf Client warten und verbinden
        do
        {// lesen und antworten
            clientBotschaft = vomClient.readLine();
            serverAntwort = serververhalten.HoleAntwort(clientBotschaft);
            zumClient.println(serverAntwort);
            if (serverAntwort.startsWith("Server[stopClient]:"))
            {
                ClientVerbindungBeenden(); // Verbindung schließen
                ClientVerbindungStarten(); // auf neue Verbindung warten
            }
        }
        while (!serverAntwort.startsWith("Server[stopServer]:"));
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
     * wartet auf eine Clientverbindung und erzeugt die nötigen Lese- und
     * Schreibobjekte nach dem eine Verbindung hergestellt wurde
     */
    private void ClientVerbindungStarten() throws IOException
    {
        clientSocket = serverSocket.accept(); // warten auf die Verbindung
        zumClient = new PrintWriter(clientSocket.getOutputStream(), true);
        vomClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        // Protokoll-Klasse zur Ermittlung der Serverantworten
        serververhalten = new WetterVerhalten2();
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
     * Hauptprogramm zum Erzeugen des Serverobjekts
     *
     * @param args keine Parameter beim Programmaufruf erforderlich
     */
    public static void main(String[] args)
    {
        try
        {
            new Server2();
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
