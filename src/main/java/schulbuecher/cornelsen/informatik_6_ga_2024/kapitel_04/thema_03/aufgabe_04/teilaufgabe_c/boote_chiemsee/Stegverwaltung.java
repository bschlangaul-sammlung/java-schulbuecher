package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_04.teilaufgabe_c.boote_chiemsee;

import java.util.ArrayList;

/**
 * Verwaltung eines Stegs am Chiemsee
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Stegverwaltung
{
    /**
     * Boote, die angelegt haben
     */
    ArrayList<Boot> boote;

    /**
     * Anzahl der Boote, die angelegt haben
     */
    int bootanzahl;

    /**
     * Hilfsvariable, die einen entstandenen Fehler anzeigt
     */
    boolean fehler;

    /**
     * Konstruktor für Objekte der Klasse Steg
     */
    Stegverwaltung()
    {
        boote = new ArrayList<Boot>();
        bootanzahl = 0;
        fehler = false;
    }

    /**
     * Ein Boot reserviert einen Liegeplatz.
     *
     * @param bootAn das Boot, das anlegen will
     */
    synchronized void PlatzReservieren(Boot bootAn)
    {
        while (bootanzahl >= 10)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        boote.add(bootAn);
        bootanzahl += 1;

        if (bootanzahl > 10)
        {
            fehler = true;
        }

        System.out.println("Boot " + bootAn.KennzeichenGeben()
                + " angelegt --> Boote am Steg: " + bootanzahl);
    }

    /**
     * Ein Boot verlässt den Steg und gibt den Liegeplatz frei.
     *
     * @param bootAb das Boot, das ablegen will
     */
    synchronized void PlatzFreigeben(Boot bootAb)
    {
        boote.remove(bootAb);
        bootanzahl -= 1;

        if (bootanzahl < 0)
        {
            fehler = true;
        }

        System.out.println("Boot " + bootAb.KennzeichenGeben()
                + " abgelegt --> Boote am Steg: " + bootanzahl);
        notifyAll();
    }
}
