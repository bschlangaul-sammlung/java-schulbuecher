package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum3_test;

/**
 * Beschreibt ein allgemeines Element des Baums.
 *
 * @author Arbeitskreis
 * @version 1.0
 */
abstract class BAUMELEMENT
{
    /**
     * Der Konstruktor ist aus Dokumentationsgründen vorhanden
     */
    BAUMELEMENT()
    {
        // keine spezielle Aufgabe
    }

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *         null: sonst
     */
    abstract DATENELEMENT Suchen(DATENELEMENT wert);

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    abstract BAUMELEMENT Einfuegen(DATENELEMENT wert);
}
