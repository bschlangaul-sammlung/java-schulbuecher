package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Stellt einfache Eingabemethoden zur Verfügung
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Eingabe
{
    BufferedReader in;

    /**
     * Erzeugt das Leseobjekt aus dem Standardeingabestrom.
     */
    Eingabe()
    {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Liest eine Textzeile als Eingabe.
     *
     * @param text Anforderungstext
     */
    String TextLesen(String text)
    {
        System.out.println(text);
        System.out.print(">");
        try
        {
            return in.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Eingabefehler");
            return "";
        }
    }
}
