package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04a;

/**
 * Beschreibt den Erzeuger.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Erzeuger extends Thread
{
    /** Die Produktionszeit pro Kiste */
    private int zeit;

    /** Der Zwischenspeicher */
    private Speicher speicher;

    /** Laufende Nummer der produzierten Kisten */
    private int nummer;

    /**
     * Legt die Konstruktionszeit fest
     *
     * @param z die Konstruktionszeit
     * @param s der Zwischenspeicher
     */
    Erzeuger(int z, Speicher s)
    {
        zeit = z;
        speicher = s;
        nummer = 0;
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    public void run()
    {
        while (true)
        {
            speicher.Ablegen(Produzieren());
        }
    }

    /**
     * Produziert Kisten in der gegebenen Zeit.
     */
    Kiste Produzieren()
    {
        long akt, ende;
        akt = System.currentTimeMillis();
        ende = akt + zeit;
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
        nummer = nummer + 1;
        System.out.println("Kiste Nummer " + nummer + " produziert.");
        return new Kiste(nummer);
    }
}
