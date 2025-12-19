package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_d.erzeuger_verbraucher;

import java.util.Random;

/**
 * Verbraucher von Kisten.
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Verbraucher extends Thread
{
    /** Die Produktionszeit pro Kiste in Millisekunden */
    private int zeit;

    /** Der Zwischenspeicher */
    private Speicher speicher;

    /** Zufallsgenerator für die unterschiedlichen Zeiten zum Einlagern **/
    private Random zufallsgenerator;

    /**
     * Konstruktor für Objekte der Klasse Verbraucher
     *
     * @param zeitNeu Ablagezeit für die Kisten
     * @param speicherNeu der Speicher, aus dem geholt werden soll
     */
    Verbraucher(int zeitNeu, Speicher speicherNeu)
    {
        zeit = zeitNeu;
        speicher = speicherNeu;
        zufallsgenerator = new Random();
    }

    /**
     * Die Arbeitsmethode des Threads
     */
    @Override
    public void run()
    {
        while (true)
        {
            Kiste kNeu = speicher.Holen();
            Einlagern(kNeu);
        }
    }

    /**
     * Lagert Kisten in der gegebenen Zeit ein.
     *
     * @param kisteNeu die zu lagernde Kiste
     */
    void Einlagern(Kiste kisteNeu)
    {
        long akt, ende;
        akt = System.currentTimeMillis();
        ende = akt + zeit / 2 + zufallsgenerator.nextInt(zeit);
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
        System.out.println("Kiste Nummer " + kisteNeu.KistennummerGeben()
                + " eingelagert.");
    }
}
