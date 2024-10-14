package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_14.lotto;

/**
 * Klasse zur Verwaltung der Lottozahlen
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Lotto
{
    private Liste l;

    /**
     * Konstruktor der Klasse Lotto erzeugt eine leere Liste
     */
    Lotto()
    {
        l = new Liste();
    }

    /**
     * Einfügen einer neuen Zahl
     *
     * @param i einzufügende int-Zahl
     */
    void Einfügen(int i)
    {
        l.SortiertEinfügen(i);
    }

    /**
     * Ausgabe aller Zahlen über die Konsole
     */
    void Ausgeben()
    {
        l.InformationAusgeben();
    }
}
