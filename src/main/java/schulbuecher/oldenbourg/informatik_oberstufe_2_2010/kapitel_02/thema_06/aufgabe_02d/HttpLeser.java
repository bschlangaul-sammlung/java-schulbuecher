package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_02d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Abrufen einer Webseite.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class HttpLeser
{
    /**
     * Fordert die Seite an und gibt sie ins Terminalfenster aus.
     *
     * @param host der Host, auf dem der Server läuft
     * @param pfad Dateiname mit Pfad, gegebenenfalls auch mit Parametern
     */
    void fordereAn(String host, String pfad)
    {
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        String zeile;
        try
        {
            socket = new Socket(host, 80);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), false);
            out.println("GET " + pfad + " HTTP/1.1");
            out.println("Host: " + host);
            out.println();
            out.flush();
            do
            {
                zeile = in.readLine();
                if (zeile == null)
                    break;
                System.out.println(zeile);
            }
            while (true);
            in.close();
            out.close();
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new HttpLeser().fordereAn("example.com", "/");
    }
}
