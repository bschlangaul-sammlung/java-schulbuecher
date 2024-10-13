package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

/**
 * Implementierung eines Zählers gemäß dem Entwurfsmuster Singleton
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Zaehler
{
    private static Zaehler z = new Zaehler();

    private static int i;

    /**
     * Konstruktor Setzt den Wert der Zählvariable auf 0.
     */
    private Zaehler()
    {
        i = 0;
    }

    /**
     * Klassenmethode zur Erhöhung des Zählers um 1.
     */
    static void ZaehlerInkrementieren()
    {
        i++;
    }

    /**
     * Klassenmethode zum Zurücksetzen des Zählers auf 0.
     */
    static void ZaehlerZuruecksetzen()
    {
        i = 0;
    }

    /**
     * Klassenmethode zum Ausgeben des Wertes des Zählers.
     */
    static int ZaehlerGeben()
    {
        return i;
    }
}
