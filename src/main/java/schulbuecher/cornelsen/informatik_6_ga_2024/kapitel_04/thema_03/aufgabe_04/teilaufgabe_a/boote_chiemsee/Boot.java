package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_04.teilaufgabe_a.boote_chiemsee;

import java.util.Random;

/**
 * Boot auf dem Chiemsee
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Boot extends Thread
{
    /** Id des Boots */
    int kennzeichen;

    /** verwaltet die Liegeplätze */
    Stegverwaltung steg;

    /** Zufallsgenerator für die Fahr- und Liegezeiten */
    Random zufallsgenerator;

    /**
     * Konstruktor für Objekte der Klasse Boot
     *
     * @param kennzeichenNeu Id des Boots
     * @param stegNeu Verwaltung für dsen Steg
     */
    Boot(int kennzeichenNeu, Stegverwaltung stegNeu)
    {
        kennzeichen = kennzeichenNeu;
        steg = stegNeu;
        zufallsgenerator = new Random();
    }

    /**
     * Ein Boot wiederholt folgende Aktionen: - zufällige Zeit auf dem See
     * herumfahren - Platz am Steg reservieren - zufällige Zeit am Steg liegen -
     * Platz wieder freigeben
     */
    @Override
    public void run()
    {
        while (true)
        {
            /*
             * Damit der Fehler schnell entsteht, wurden die Wartezeiten jeweils
             * auskommentiert
             */

            // try { Thread.sleep(zufallsgenerator.nextInt(100)); } // auf dem
            // See herumfahren
            // catch (InterruptedException e) { }
            steg.PlatzReservieren(this);

            // try { Thread.sleep(zufallsgenerator.nextInt(300)); } // liegen
            // ...
            // catch (InterruptedException e) { }
            steg.PlatzFreigeben(this);
        }
    }

    /**
     * Liefert das Kennzeichen des Boots.
     *
     * @return Kennzeichen
     */
    int KennzeichenGeben()
    {
        return kennzeichen;
    }
}
