package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_07.buchungssimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serverimplementierung, Auslagerung der Clientprozesse in einen Thread<br/>
 * Der Zugriff auf die Ressource plaetzevorhanden ist <b>nicht
 * synchronisiert</b>! Zur Simulation wird ein Platzkontigent immer wieder
 * aufgefüllt.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Server5
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
     * dieses Platzkontignent wird immer wieder aufgefüllt
     */
    private static int platzkontingent = 10;

    /**
     * Beim Abbruch der Simulation durch überbuchung wird Tastatureingabe
     * erwartet
     */
    private BufferedReader tastatur;

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public Server5() throws IOException
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
        ClientProzess2 clientprozess = new ClientProzess2(clientSocket, this);
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
        boolean plaetzebuchbar = (anzahl <= plaetzevorhanden);
        try
        {// das Ermitteln, ob Plaetze buchbar sind brauche etwas Zeit ...
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (InterruptedException e)
        {
            System.err.println("Fehler in der Serververabeitung.");
        }
        if (plaetzebuchbar)
        {
            plaetzevorhanden = plaetzevorhanden - anzahl;
            System.out.println(plaetzevorhanden + " Plaetze vorhanden.");
            if (plaetzevorhanden < 0)
            {
                System.out.println("\u00DCberbuchung ! Beenden mit Return...");
                try
                {
                    tastatur.read();
                    System.exit(0);
                }
                catch (Exception e)
                {
                    System.err.println("Fehler in der Serververabeitung.");
                }
            }
            if (plaetzevorhanden == 0)
            {
                plaetzevorhanden = platzkontingent;
            }
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
        tastatur = new BufferedReader(new InputStreamReader(System.in));
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
            new Server5();
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
