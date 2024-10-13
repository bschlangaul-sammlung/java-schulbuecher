package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Klasse zur Verwaltung der Lottozahlen
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class LOTTO
{
    private LISTE l;

    /**
     * Konstruktor der Klasse LOTTO erzeugt eine leere Liste
     */
    LOTTO()
    {
        l = new LISTE();
    }

    /**
     * Einfügen einer neuen Zahl
     *
     * @param i einzufügende int-Zahl
     */
    void Einfuegen(int i)
    {
        ZAHL zahl;
        zahl = new ZAHL(i);
        l.SortiertEinfuegen(zahl);
    }

    /**
     * Ausgabe aller Zahlen über die Konsole
     */
    void Ausgeben()
    {
        l.InformationAusgeben();
    }
}
