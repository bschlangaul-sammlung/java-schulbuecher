package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Stellt die Operationen auf der Verbindung zur Verfügung
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Verbindung
{
    private InputStream in;

    private OutputStream out;

    private Socket socket;

    /**
     * Legt die Ein- und Ausgabeströme an.
     *
     * @param socket Der (Netzwerk-)socket für dei Verbindung
     */
    Verbindung(Socket socket)
    {
        try
        {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            this.socket = socket;
        }
        catch (Exception ex)
        {
            System.out.println("\u00DCbertragungsfehler: " + ex);
            in = null;
            out = null;
        }
    }

    /**
     * Liest eine Zeile aus dem Eingabestrom
     *
     * @return Zeileninhalt
     */
    String ZeileLesen()
    {
        char[] chars;
        int pos;
        char ch;
        chars = new char[100];
        pos = 0;
        try
        {
            do
            {
                do
                {
                    ch = (char) in.read();
                }
                while (ch == '\n');
                chars[pos] = ch;
                pos += 1;
            }
            while (chars[pos - 1] != '\r');
        }
        catch (IOException ioex)
        {
            System.out.println("\u00DCbertragungsfehler: " + ioex);
            pos += 1;
        }
        return new String(chars, 0, pos - 1);
    }

    /**
     * Sendet den Text und schließt mit &lt;cr&gt; ab.
     *
     * @param zeile Zu bertragender Text
     */
    void ZeileSenden(String zeile)
    {
        try
        {
            // out. writeChars (zeile + "\r\n");
            for (int i = 0; i < zeile.length(); i++)
            {
                out.write((int) zeile.charAt(i));
            }
            out.write((int) '\r');
            out.write((int) '\n');
            out.flush();
        }
        catch (IOException ioex)
        {
            System.out.println("\u00DCbertragungsfehler: " + ioex);
        }
    }

    /**
     * Schließt die Verbindung.
     */
    void Schliessen()
    {
        try
        {
            socket.close();
        }
        catch (IOException ioex)
        {
            System.out.println("Fehler beim Verbindungsabbau: " + ioex);
        }
    }
}
