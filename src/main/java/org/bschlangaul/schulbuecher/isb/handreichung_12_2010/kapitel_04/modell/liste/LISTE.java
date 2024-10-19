package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.liste;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Eine sortierte Liste nach Standardimplementierung.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class LISTE
{
    /**
     * Referenz auf das erste Element der Liste.
     */
    private LISTENELEMENT anfang;

    /**
     * Zähler für die Anzahl der Vergleiche
     */
    private static int zaehler;

    /**
     * Legt eine leere Liste an.
     */
    public LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     */
    public void Einfuegen(DatenElement neu)
    {
        anfang = anfang.Einfuegen(neu);
    }

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return das gefundene Datenelement oder null
     */
    public DatenElement Suchen(DatenElement schluessel)
    {
        zaehler = 0;
        return anfang.Suchen(schluessel);
    }

    /**
     * Erhöht den Zähler um 1.
     */
    static void ZaehlerErhoehen()
    {
        zaehler += 1;
    }

    /**
     * Meldet den Zählerstand.
     *
     * @return Zählerstand
     */
    public static int ZaehlerGeben()
    {
        return zaehler;
    }
}
