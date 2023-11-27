package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum4_test;

/**
 * Schnittstelle für die verwalteten Datenelemente.
 *
 * @author Arbeitskreis
 * @version 1.0
 */
interface DATENELEMENT
{
    /**
     * Vergleicht das vorhandene Datenelement mit dem übergebenen.
     *
     * @param wert der Vergleichswert
     * @return -1: das aktuelle Element ist kleiner als das
     *         Vergleichselement<br>
     *         0: das aktuelle Elelemt hat den gleichen Wert wie das
     *         Vergleichselement<br>
     *         1: das aktuelle Element ist grö&szlig;er als das
     *         Vergleichselement
     */
    int Vergleichen(DATENELEMENT wert);

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    void Ausgeben();
}
