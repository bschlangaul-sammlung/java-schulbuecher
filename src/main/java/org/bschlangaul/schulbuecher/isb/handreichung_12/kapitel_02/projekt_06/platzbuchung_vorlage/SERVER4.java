package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_06.platzbuchung_vorlage;

import java.net.*;
import java.io.*;

/**
 * Serverimplementierung, Auslagerung der Clientprozesse in einen Thread<br/>
 * Vorlage für die Aufgabe 2 des Kapitels 2.3.3<br/>
 * Die Stellen, an denen eine Quelltextergänzung notwendig ist, sind mit
 * "Quelltextergänzung" gekennzeichnet.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class SERVER4
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung des
     * Servers
     */
    private ServerSocket serverSocket = null;

    /** Portnummer des Ports, auf dem die Verbindungen etabliert sind */
    private int port;

    /** speichert die aktuelle Anzahl der noch vorhandenen Plätze */
    private int plaetzevorhanden = 3;

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public SERVER4() throws IOException
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
        CLIENTPROZESS2 clientprozess = new CLIENTPROZESS2(clientSocket, this);
        clientprozess.start();
        System.out.println("Clientprozess gestartet...");
    }

    /**
     * gibt die Anzahl der noch verfügbaren Plätze zurück
     *
     * @return Anzahl der verfügbaren Plätze
     */
    public int PlaetzeVerfuegbar()
    {
        // Quellcodeergänzung
        return 0;
    }

    /**
     * die angegebene Anzahl an Plätzen buchen
     *
     * @param anzahl, die Anzahl der zu buchenden Plätze
     *
     * @return gibt false zurück, falls die Buchung aus Platzmangel nicht
     *     durchgeführt werden konnte
     */
    public boolean PlaetzeBuchen(int anzahl)
    {
        // Quellcodeergänzung
        return false;
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
    public static void main(String[] args) throws IOException
    {
        try
        {
            new SERVER4();
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
