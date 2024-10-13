package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_05.mehrclients_parallel;

import java.net.*;
import java.io.*;

/**
 * Serverimplementierung, Auslagerung der Clientprozesse in einen Thread<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class SERVER3
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung des
     * Servers
     */
    private ServerSocket serverSocket = null;

    /** Portnummer des Ports, auf dem die Verbindungen etabliert sind */
    private int port;

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public SERVER3() throws IOException
    {
        ServerStarten();
        while (true)
        {// wartet immer auf neue Clientverbindungen
            AufNeuenClientWarten();
        }
    }

    /**
     * wartet auf eine neue Verbindung und lagert diese einen Thread aus
     */
    private void AufNeuenClientWarten() throws IOException
    {
        System.out.println("warte auf Client, hoere auf Port " + port);
        Socket clientSocket = serverSocket.accept(); // warten auf die
                                                     // Verbindung
        CLIENTPROZESS clientprozess = new CLIENTPROZESS(clientSocket);
        clientprozess.start();
        System.out.println("Clientprozess gestartet...");
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
        port = Integer.parseInt(tastatur.readLine());
        serverSocket = new ServerSocket(port);
        System.out.println("Server gestartet...");
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
            new SERVER3();
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
