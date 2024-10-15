package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04c;

import java.util.Random;

/**
 * Beschreibt den Verbraucher.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Verbraucher extends Thread
{
    /**
     * Die mittlere Einlagerzeit pro Kiste
     */
    private int zeit;

    /**
     * Der Zwischenspeicher
     */
    private Speicher speicher;

    /**
     * Zufallsgenerator für die Einlagerzeit.
     */
    private Random ran;

    /**
     * Legt die mittlere Einlagerzeit fest
     *
     * @param z die Einlagerzeit
     * @param s der Zwischenspeicher
     */
    Verbraucher(int z, Speicher s)
    {
        zeit = z;
        speicher = s;
        ran = new Random();
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    public void run()
    {
        while (true)
        {
            Einlagern(speicher.Holen());
        }
    }

    /**
     * Lagert Kisten in der gegebenen Zeit.
     */
    void Einlagern(Kiste kiste)
    {
        long akt, ende;
        akt = System.currentTimeMillis();
        ende = akt + zeit / 2 + ran.nextInt(zeit);
        while (akt < ende)
        {
            try
            {
                wait(ende - akt);
            }
            catch (Exception e)
            {
            }
            akt = System.currentTimeMillis();
        }
        System.out.println(
                "Kiste Nummer " + kiste.KistennummerGeben() + " eingelagert.");
    }
}
