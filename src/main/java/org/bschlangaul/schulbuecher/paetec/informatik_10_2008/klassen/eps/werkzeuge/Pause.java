package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge;

/**
 * Die Klasse Pause stellt Dienste zum Warten bereit.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Pause
{
    /**
     * Wartet die angegebene Anzahl an Sekunden
     */
    public static void warten(int sekunden)
    {
        msWarten(sekunden * 1000);
    }

    /**
     * Wartet die angegebene Anzahl an Millisekunden
     */
    public static void msWarten(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
        }
    }
}
