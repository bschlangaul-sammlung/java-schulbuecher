package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_04b;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Einfacher Server, der alle Zeichen spiegelt.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Server
{
    /**
     * Endeangabe
     */
    private boolean beendenEmpfangen;

    /**
     * Liste mit den aktuellen Klienten
     */
    private ArrayList<ClientThread> angemeldet;

    /**
     * Der Serversocket
     */
    ServerSocket server;

    /**
     * Besetzt die Attribute vor.
     */
    Server()
    {
        beendenEmpfangen = false;
        angemeldet = new ArrayList<ClientThread>();
    }

    /**
     * Führt die eigentliche Arbeit aus.
     */
    void Arbeiten()
    {
        Socket anruf;
        ClientThread neu;
        try
        {
            server = new ServerSocket(54000);
            do
            {
                anruf = server.accept();
                neu = new ClientThread(anruf, this);
                angemeldet.add(neu);
                neu.start();
            }
            while (!beendenEmpfangen);
        }
        catch (Exception e)
        {
            if (!beendenEmpfangen)
            {
                System.out.println("Allgemeiner Fehler: " + e);
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    /**
     * Gibt die Zeichen zur Ausgabe an alle Threads weiter.
     *
     * @param zeichen die auszugebenden Zeichen
     * @param anzahl Anzahl der auszugebenden Zeichen
     */
    void Ausgeben(int[] zeichen, int anzahl)
    {
        for (ClientThread c : angemeldet)
        {
            c.Ausgeben(zeichen, anzahl);
        }
    }

    /**
     * Meldet einen Clientthread vom Geschehen ab.
     *
     * @param thread der abzumeldende thread
     */
    void Abmelden(ClientThread thread)
    {
        angemeldet.remove(thread);
    }

    /**
     * Setzt die Endemarkierung.
     */
    void BeendenSetzen()
    {
        beendenEmpfangen = true;
        try
        {
            server.close();
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Startmethode, um Server als Programm betreiben zu können.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Server().Arbeiten();
    }
}
