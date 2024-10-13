package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_03b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Client für den einfachen Server.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Client
{
    /**
     * Führt die eigentliche Arbeit aus.
     *
     * @param host der Host, mit dem verbunden werden soll.
     * @param port der Port, auf dem der Server lauscht.
     */
    void verbinde(String host, int port)
    {
        try
        {
            Socket anruf = new Socket(host, port);
            InputStream in = anruf.getInputStream();
            OutputStream out = anruf.getOutputStream();
            System.out.println("Verbindung aufgebaut");
            do
            {
                int zeichen = System.in.read();
                if (zeichen < 0)
                    break;
                out.write(zeichen);
                while (in.available() > 0)
                {
                    System.out.write(in.read());
                }
            }
            while (true);
            anruf.close();
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Client().verbinde("localhost", 54000);
    }
}
