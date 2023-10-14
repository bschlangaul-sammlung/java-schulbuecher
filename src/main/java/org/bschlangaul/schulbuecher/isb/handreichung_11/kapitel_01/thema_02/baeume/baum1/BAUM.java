package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum1;

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
     * Legt einen Baum mit angegebener Wurzel an. Dieser Konstruktor ist nur zu Testzwecken
     * vorhanden.
     *
     * @param w Referenz auf den Wurzelknoten
     */
    BAUM(KNOTEN w)
    {
        wurzel = w;
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
}
