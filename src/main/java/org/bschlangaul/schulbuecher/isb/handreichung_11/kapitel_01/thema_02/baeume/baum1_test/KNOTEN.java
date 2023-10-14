package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum1_test;

/**
 * Verwaltet einen Knoten des Baums.
 *
 * @author Arbeitskreis
 * @version 1.0
 */
class KNOTEN
{
    /** Referenz auf den linken Nachfolger */
    private KNOTEN linkerNachfolger;
    /** Referenz auf den rechten Nachfolger */
    private KNOTEN rechterNachfolger;
    /** Referenz auf das Datenelement */
    private DATENELEMENT daten;

    /**
     * Erzeugt einen Knoten mit den dem angegebenen Datenelement.
     *
     * @param d Referenz auf das verwaltete Datenelement
     */
    KNOTEN(DATENELEMENT d)
    {
        linkerNachfolger = null;
        rechterNachfolger = null;
        daten = d;
    }

    /**
     * Erzeugt einen Knoten mit den dem angegebenen Datenelement und den gegebenen Nachfolgern.
     * Dieser Konstruktor ist nur zu Testzwecken vorhanden.
     *
     * @param d Referenz auf das verwaltete Datenelement
     * @param lnf linker Nachfolger
     * @param rnf rechter Nachfolger
     */
    KNOTEN(DATENELEMENT d, KNOTEN lnf, KNOTEN rnf)
    {
        linkerNachfolger = lnf;
        rechterNachfolger = rnf;
        daten = d;
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
        if (daten.Vergleichen(wert) == 0)
        {
            return daten;
        }
        else
        {
            if (daten.Vergleichen(wert) < 0)
            {
                if (rechterNachfolger == null)
                {
                    return null;
                }
                else
                {
                    return rechterNachfolger.Suchen(wert);
                }
            }
            else
            {
                if (linkerNachfolger == null)
                {
                    return null;
                }
                else
                {
                    return linkerNachfolger.Suchen(wert);
                }
            }
        }
    }
}
