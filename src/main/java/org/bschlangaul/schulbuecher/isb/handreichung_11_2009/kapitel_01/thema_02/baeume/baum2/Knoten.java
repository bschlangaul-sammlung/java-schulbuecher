package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum2;

/**
 * Verwaltet einen Knoten des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Knoten
{
    /**
     * Referenz auf den linken Nachfolger
     */
    private Knoten linkerNachfolger;

    /**
     * Referenz auf den rechten Nachfolger
     */
    private Knoten rechterNachfolger;

    /**
     * Referenz auf das Datenelement
     */
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

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    void Einfuegen(DatenElement wert)
    {
        if (daten.Vergleichen(wert) == 0)
        {
            System.out.print("Das Datenelement ist schon vorhanden: ");
            wert.Ausgeben();
        }
        else
        {
            if (daten.Vergleichen(wert) < 0)
            {
                if (rechterNachfolger == null)
                {
                    rechterNachfolger = new Knoten(wert);
                }
                else
                {
                    rechterNachfolger.Einfuegen(wert);
                }
            }
            else
            {
                if (linkerNachfolger == null)
                {
                    linkerNachfolger = new Knoten(wert);
                }
                else
                {
                    linkerNachfolger.Einfuegen(wert);
                }
            }
        }
    }
}
