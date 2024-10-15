package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.zusaetzliches_projekt_02.maximale_clientanzahl_liste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Serverimplementierung, Auslagerung der Clientprozesse in einen Thread<br/>
 * Dieser Server lässt nur eine bestimmte Anzahl an Clients zu. Der Zugriff auf
 * die Ressourde clientanzahl ist <b>noch nicht synchronisiert!</b>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class SERVERZ4
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
     * die maximal mögliche Anzahl an Clients
     */
    private static int maximaleclientanzahl = 2;

    /**
     * Liste der serverseitigen Prozesse, die über die Clientverbindung
     * kommunizieren.
     */
    private ArrayList<CLIENTPROZESSZ1> clientprozesse = new ArrayList<CLIENTPROZESSZ1>();

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public SERVERZ4() throws IOException
    {
        ServerStarten();
        while (true)
        {// wartet immer auf neue Clientverbindungen
            AufNeuenClientWarten();
        }
    }

    /**
     * wartet auf eine neue Verbindung und lagert diese, falls möglich, in einen
     * Thread aus.<br/>
     * Ist die maximal mögliche Anzahl der Verbindungen erreicht, so wird die
     * Clientverbindung kurzzeitig hergestellt um das Stoppsignal
     * Server[stopClient] für den Client zu senden.
     */
    private void AufNeuenClientWarten() throws IOException
    {
        System.out.println("warte auf Client, hoere auf Port " + port);
        Socket clientSocket = serverSocket.accept(); // warten auf die
                                                     // Verbindung
        ClientProzessHinzufuegen(clientSocket);
    }

    /**
     * fügt einen Clientprozess falls die maximale Clientanzahl noch nicht
     * erreicht ist. Ist die maximal mögliche Anzahl der Verbindungen erreicht,
     * so wird die Clientverbindung kurzzeitig hergestellt um das Stoppsignal
     * Server[stopClient] für den Client zu senden. In dieser Version
     * <b>synchronisiert!</b>
     *
     * @param clientSocket der Socket über den der Clientprozess kommunizieren
     *     soll
     */
    private synchronized void ClientProzessHinzufuegen(Socket clientSocket)
            throws IOException
    {
        if (clientprozesse.size() < maximaleclientanzahl)
        {
            CLIENTPROZESSZ1 clientprozess = new CLIENTPROZESSZ1(clientSocket,
                    this, "");
            clientprozess.start();
            clientprozesse.add(clientprozess);
            System.out.println(clientprozesse.size() + " Verbindung(en)");
        }
        else
        {
            new CLIENTPROZESSZ1(clientSocket, this, "toomuchclients");
            System.out.println(
                    "zu viele Verbindungen, Clientverbindung wird zurueckgesetzt");
        }
    }

    /**
     * entfernt einen Clientprozess aus der Liste der Clientprozesse <b>In
     * dieser Version synchronisiert!</b>
     *
     * @param clientprozess der Clientprozess, der aus der Liste entfernt werden
     *     soll.
     */
    public synchronized void ClientProzessEntfernen(
            CLIENTPROZESSZ1 clientprozess)
    {
        clientprozesse.remove(clientprozess);
        System.out.println("Clientverbindung beendet ");
        System.out.println(clientprozesse.size() + " Verbindung(en)");
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
            new SERVERZ4();
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
