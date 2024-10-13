package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum1;

/**
 * Verwaltet einen Knoten des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Knoten
{
    /** Referenz auf den linken Nachfolger */
    private Knoten linkerNachfolger;

    /** Referenz auf den rechten Nachfolger */
    private Knoten rechterNachfolger;

    /** Referenz auf das Datenelement */
    private DatenElement daten;

    /**
     * Erzeugt einen Knoten mit den dem angegebenen Datenelement.
     *
     * @param d Referenz auf das verwaltete Datenelement
     */
    Knoten(DatenElement d)
    {
        linkerNachfolger = null;
        rechterNachfolger = null;
        daten = d;
    }

    /**
     * Erzeugt einen Knoten mit den dem angegebenen Datenelement und den
     * gegebenen Nachfolgern. Dieser Konstruktor ist nur zu Testzwecken
     * vorhanden.
     *
     * @param d Referenz auf das verwaltete Datenelement
     * @param lnf linker Nachfolger
     * @param rnf rechter Nachfolger
     */
    Knoten(DatenElement d, Knoten lnf, Knoten rnf)
    {
        linkerNachfolger = lnf;
        rechterNachfolger = rnf;
        daten = d;
    }

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     *
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *     null: sonst
     */
    DatenElement Suchen(DatenElement wert)
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
