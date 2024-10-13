package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_10.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Implementierung eines Chatservers, Auslagerung der Clientprozesse in einen
 * Thread<br/>
 * <b>Jeder</b> Zugriff auf die Liste clientprozesse muss snychronisiert sein.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class CHATSERVER
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
    private static int maximaleclientanzahl = 10;

    /**
     * Liste der serverseitigen Prozesse, die über die Clientverbindung
     * kommunizieren.
     */
    private ArrayList<CLIENTPROZESS> clientprozesse = new ArrayList<CLIENTPROZESS>();

    /**
     * Konstruktor des Servers
     *
     * @exception IOException eine Ausnahme tritt auf falls:<br/>
     *     - der Server nicht gestartet werden kann (weil beispielsweise der
     *     Port nicht frei ist)<br/>
     *     - die Clientverbindung gestört bzw. unterbrochen wurde.
     */
    public CHATSERVER(String[] args) throws IOException
    {
        ServerStarten();
        while (true)
        {// Server laeuft und laeuft
            AufNeuenClientWarten();
        }
    }

    /**
     * Port abfragen und den Serversocket erzeugen
     */
    private void ServerStarten() throws IOException
    {
        System.out.println("Port eingeben: ");
        BufferedReader tastatur = new BufferedReader(
                new InputStreamReader(System.in));
        // Server Socket erzeugen
        port = Integer.parseInt(tastatur.readLine());
        serverSocket = new ServerSocket(port);
        System.out.println("Chatserver gestartet...");
    }

    /**
     * wartet auf eine eingehende Clientverbindung und erzeugt für diese eine
     * Verbindung
     */
    private void AufNeuenClientWarten() throws IOException
    {
        System.out.println("warte auf Client, hoere auf Port " + port);
        Socket clientSocket = serverSocket.accept(); // warten auf die
                                                     // Verbindung
        ClientVerbindungAufbauen(clientSocket);
    }

    /**
     * baut eine Verbindung zum Client auf, um dessen Namen zu erfragen. falls
     * die maximale Anzahl der zulässigen Verbindungen erreicht ist, wird die
     * Verbindung nur kurzzeitig aufgebaut, um das Stoppsignal für den Client zu
     * senden
     *
     * @param clientSocket der Socket des Clients
     */
    private synchronized void ClientVerbindungAufbauen(Socket clientSocket)
            throws IOException
    {
        if (clientprozesse.size() < maximaleclientanzahl)
        {
            CLIENTPROZESS clientprozess = new CLIENTPROZESS(clientSocket, this,
                    "");
            clientprozess.start();
            System.out.println("neuer Client will sich anmelden / "
                    + clientprozesse.size() + " User angemeldet");
        }
        else
        {
            new CLIENTPROZESS(clientSocket, this, "toomuchclients");
            System.out.println(
                    "zu viele Verbindungen, Clientverbindung wird zurückgesetzt");
        }
    }

    /**
     * fügt den clientprozess zur Liste der Clientprozesse hinzu und
     * benachrichtigt alle Chatteilnehmer falls die maximale Anzahl der
     * zulässigen Verbindungen erreicht ist, gibt ist der Rückgabewert false und
     * der clientprozess wird beendet
     *
     * @param clientprozess der Clientprozess, der hinzugefügt werden soll
     *
     * @return true bei Erfolg, wird false zurückgegeben, so wird der
     *     Clientprozess beendet.
     */
    public synchronized boolean ClientProzessHinzufuegen(
            CLIENTPROZESS clientprozess)
    {
        if (clientprozesse.size() < maximaleclientanzahl)
        {
            clientprozesse.add(clientprozess);
            AnAlleSenden(
                    clientprozess.SpitznameHolen() + " hat den Raum betreten.");
            System.out.println(
                    clientprozess.SpitznameHolen() + " hat den Raum betreten.");
            System.out.println(clientprozesse.size() + " Verbindungen / "
                    + clientprozesse.size() + " User angemeldet");
            return true;
        }
        else
        {
            // clientprozess.ClientVerbindungBeenden();
            System.out.println(
                    "zu viele Verbindungen, Clientverbindung wird zurückgesetzt");
            return false;
        }
    }

    /**
     * entfernt den clientprozess von der Liste der Clientprozesse und
     * benachrichtigt alle Chatteilnehmer
     *
     * @param clientprozess der Clientprozess, der entfernt werden soll.
     */
    public synchronized void ClientProzessEntfernen(CLIENTPROZESS clientprozess)
    {
        if (clientprozesse.remove(clientprozess))
        {
            AnAlleSenden(clientprozess.SpitznameHolen()
                    + " hat den Raum verlassen.");
            System.out.println(clientprozess.SpitznameHolen()
                    + " hat den Raum verlassen.");
        }
        System.out.println(clientprozesse.size() + " Verbindungen / "
                + clientprozesse.size() + " User angemeldet");
    }

    /**
     * ermittelt über den Spitznamen den zugehörigen Clientprozess
     *
     * @return CLIENTPROZESS clientprozess oder null, falls kein Clientprozess
     *     mit einem solchen Spitznamen gefunden wurde.
     */
    private synchronized CLIENTPROZESS ClientProzessGeben(String spitzname)
    {
        for (CLIENTPROZESS clientprozess : clientprozesse)
        {
            if (spitzname.equals(clientprozess.SpitznameHolen()))
            {
                return clientprozess;
            }
        }
        return null;
    }

    /**
     * prüft ob der Spitzname bereits vorhanden ist.
     *
     * @return true, falls Spitzname vorhanden
     */
    public synchronized boolean SpitznameVorhanden(String spitzname)
    {
        return (ClientProzessGeben(spitzname) != null);
    }

    /**
     * sendet den String nachricht an clientprozess
     *
     * @param clientprozess der Empfänger der Nachricht
     * @param nachricht der Text der Nachricht
     */
    public void PrivateNachrichtSenden(CLIENTPROZESS clientprozess,
            String nachricht)
    {
        clientprozess.Senden(nachricht);
    }

    /**
     * versucht den String nachricht an den clientprozess mit dem angegeben
     * Spitznamen zu senden, falls kein Clientprozess mit einem solchen Namen
     * vorhanden ist gibt die funktion false zurück
     *
     * @return boolean gibt an, ob die Nachricht versandt werden konnte.
     */
    public boolean PrivateNachrichtSenden(String spitzname, String nachricht)
    {
        CLIENTPROZESS clientprozess = ClientProzessGeben(spitzname);
        if (clientprozess != null)
        {
            PrivateNachrichtSenden(clientprozess, nachricht);
            return true;
        }
        return false;
    }

    /**
     * sendet den String nachricht an alle clientprozesse der Liste
     *
     * @param nachricht die Nachricht, die an alle Chatteilnehmer geschickt
     *     wird.
     */
    public void AnAlleSenden(String nachricht)
    {
        for (CLIENTPROZESS clientprozess : clientprozesse)
        {
            clientprozess.Senden(nachricht);
        }
    }

    /**
     * Hauptprogramm zum Erzeugen des Serverobjekts
     *
     * @param args keine Parameter beim Programmaufruf erforderlich
     */
    public static void main(String[] args) throws IOException
    {
        new CHATSERVER(args);
    }
}
