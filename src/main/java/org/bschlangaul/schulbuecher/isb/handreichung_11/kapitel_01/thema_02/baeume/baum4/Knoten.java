package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum4;

/**
 * Verwaltet einen Knoten des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Knoten extends BaumElement
{
    /**
     * Referenz auf den linken Nachfolger
     */
    private BaumElement linkerNachfolger;

    /**
     * Referenz auf den rechten Nachfolger
     */
    private BaumElement rechterNachfolger;

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
        super();
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();
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
                return rechterNachfolger.Suchen(wert);
            }
            else
            {
                return linkerNachfolger.Suchen(wert);
            }
        }
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    BaumElement Einfuegen(DatenElement wert)
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
                rechterNachfolger = rechterNachfolger.Einfuegen(wert);
            }
            else
            {
                linkerNachfolger = linkerNachfolger.Einfuegen(wert);
            }
        }
        return this;
    }

    /**
     * Durchläft den Baum in Preorder
     */
    void PreOrder()
    {
        daten.Ausgeben();
        linkerNachfolger.PreOrder();
        rechterNachfolger.PreOrder();
    }

    /**
     * Durchläft den Baum in Inorder
     */
    void InOrder()
    {
        linkerNachfolger.InOrder();
        daten.Ausgeben();
        rechterNachfolger.InOrder();
    }

    /**
     * Durchläft den Baum in Postorder
     */
    void PostOrder()
    {
        linkerNachfolger.PostOrder();
        rechterNachfolger.PostOrder();
        daten.Ausgeben();
    }
}
