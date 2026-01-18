package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_03a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
     * Führt die eigentliche Arbeit aus.
     */
    void arbeite()
    {
        try
        {
            ServerSocket server = new ServerSocket(54000);
            Socket anruf = server.accept();
            InputStream in = anruf.getInputStream();
            OutputStream out = anruf.getOutputStream();
            do
            {
                int zeichen = in.read();
                if (zeichen < 0)
                    break;
                out.write(zeichen);
            }
            while (true);
            anruf.close();
            server.close();
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Startmethode, um Server als Programm betreiben zu können.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Server().arbeite();
    }
}
