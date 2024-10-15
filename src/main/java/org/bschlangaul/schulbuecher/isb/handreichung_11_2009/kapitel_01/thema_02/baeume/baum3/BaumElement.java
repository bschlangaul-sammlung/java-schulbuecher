package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum3;

/**
 * Beschreibt ein allgemeines Element des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
abstract class BaumElement
{
    /**
     * Der Konstruktor ist aus Dokumentationsgründen vorhanden
     */
    BaumElement()
    {
        // keine spezielle Aufgabe
    }

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     *
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *     null: sonst
     */
    abstract DatenElement Suchen(DatenElement wert);

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    abstract BaumElement Einfuegen(DatenElement wert);
}
