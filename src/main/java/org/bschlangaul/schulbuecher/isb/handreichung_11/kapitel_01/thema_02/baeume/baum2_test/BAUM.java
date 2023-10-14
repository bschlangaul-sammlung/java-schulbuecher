package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum2_test;

/**
 * Verwaltet den Baum als Ganzes.
 *
 * @author Arbeitskreis
 * @version 1.0
 */
class BAUM
{
    /** Referenz auf die Wurzel des Baums */
    private KNOTEN wurzel;

    /**
     * Legt einen leeren Baum an.
     */
    BAUM()
    {
        wurzel = null;
    }

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *         null: sonst
     */
    DATENELEMENT Suchen(DATENELEMENT wert)
    {
        if (wurzel == null)
        {
            return null;
        }
        else
        {
            return wurzel.Suchen(wert);
        }
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    void Einfuegen(DATENELEMENT wert)
    {
        if (wurzel == null)
        {
            wurzel = new KNOTEN(wert);
        }
        else
        {
            wurzel.Einfuegen(wert);
        }
    }
}
