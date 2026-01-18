package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Verwaltet den Eingabestrom.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class DateiLesen
{
    FileInputStream in;

    /**
     * Setzt den Startzustand.
     */
    DateiLesen()
    {
        in = null;
    }

    /**
     * öffnet den Eingabestrom für den angegebenen Namen.
     *
     * @param name Dateiname
     *
     * @return wahr, wenn die Datei gelesen werden kann
     */
    boolean Oeffnen(String name)
    {
        try
        {
            in = new FileInputStream(name);
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
     * Holt das nächste Paket von Bytes hexadezimal codiert.
     *
     * @return Paket hexadezimal uder null bei Dateiende.
     */
    String PaketLesen()
    {
        byte[] paket;
        int b;
        char[] res;
        int anzahl;
        paket = new byte[20];
        try
        {
            anzahl = in.read(paket);
            if (anzahl < 0)
            {
                return null;
            }
            else
            {
                res = new char[paket.length * 2];
                for (int index = 0; index < anzahl; index++)
                {
                    b = paket[index];
                    if (b < 0)
                    {
                        b += 256;
                    }
                    res[index * 2] = Character.forDigit(b / 16, 16);
                    res[index * 2 + 1] = Character.forDigit(b % 16, 16);
                }
                return new String(res, 0, anzahl * 2);
            }
        }
        catch (IOException e)
        {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
            return null;
        }
    }

    /**
     * Schließt den Eingabestrom.
     */
    void Schliessen()
    {
        try
        {
            in.close();
            in = null;
        }
        catch (IOException e)
        {
        }
    }
}
