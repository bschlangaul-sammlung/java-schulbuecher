package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

/**
 * Schnittstelle für die verwalteten Datenelemente.
 *
 * @author ISB-Arbeitskreis
 *
 * @version 1.0
 */
interface DATENELEMENT
{
    /**
     * Vergleicht das vorhandene Datenelement mit dem übergebenen.
     *
     * @param wert der Vergleichswert
     *
     * @return Boolscher Wert<br>
     *
     */
    boolean Vergleichen(DATENELEMENT wert);

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    void Ausgeben();
}
