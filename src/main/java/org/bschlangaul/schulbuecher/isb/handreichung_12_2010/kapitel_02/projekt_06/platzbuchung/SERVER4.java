package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_06.platzbuchung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serverimplementierung, Auslagerung der Clientprozesse in einen Thread<br/>
 * Lösung für die Aufgabe 2 des Kapitels 2.3.3<br/>
 * Der Zugriff auf die Ressource plaetzevorhanden ist <b>nicht
 * synchronisiert</b>!
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

    /**
     * Portnummer des Ports, auf dem die Verbindungen etabliert sind
     */
    private int port;

    /**
     * speichert die aktuelle Anzahl der noch vorhandenen Plätze
     */
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
        return plaetzevorhanden;
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
        if (anzahl <= plaetzevorhanden)
        {
            plaetzevorhanden = plaetzevorhanden - anzahl;
            System.out.println(plaetzevorhanden + " Plaetze vorhanden.");
            return true;
        }
        else
        {
            return false;
        }
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