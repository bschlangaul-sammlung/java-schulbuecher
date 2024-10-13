package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

/**
 * Verwaltet den Ausgabestrom.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.io.*;

class DateiSchreiben
{
    FileOutputStream out;

    /**
     * Setzt den Startzustand.
     */
    DateiSchreiben()
    {
        out = null;
    }

    /**
     * öffnet den Ausgabestrom für den angegebenen Namen.
     *
     * @param name Dateiname
     *
     * @return wahr, wenn die Datei geschrieben werden kann
     */
    boolean Oeffnen(String name)
    {
        try
        {
            out = new FileOutputStream(name);
            return true;
        }
        catch (FileNotFoundException e)
        {
            System.out
                    .println("Fehler beimffnen der Datei: " + e.getMessage());
            return false;
        }
    }

    /**
     * Schreibt das nächste Paket von Bytes hexadezimal codiert.
     *
     * @param text das Paket hexadezimal dargestellt.
     */
    void PaketSchreiben(String text)
    {
        byte[] paket;
        int b;
        paket = new byte[text.length() / 2];
        try
        {
            for (int index = 0; index < paket.length; index++)
            {
                b = Character.digit(text.charAt(index * 2), 16) * 16
                        + Character.digit(text.charAt(index * 2 + 1), 16);
                if (b > 127)
                {
                    b -= 256;
                }
                paket[index] = (byte) b;
            }
            out.write(paket);
        }
        catch (IOException e)
        {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    /**
     * Schließt den Ausgabestrom.
     */
    void Schliessen()
    {
        try
        {
            out.close();
            out = null;
        }
        catch (IOException e)
        {
        }
    }
}
