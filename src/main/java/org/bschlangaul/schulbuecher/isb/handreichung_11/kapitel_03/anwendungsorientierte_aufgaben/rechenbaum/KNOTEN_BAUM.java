package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

/**
 * Verwaltet einen Knoten des Baums.
 *
 * @author ISB-Arbeitskreis
 *
 * @version 1.0
 */
class KNOTEN_BAUM extends BAUMELEMENT
{
    /** Referenz auf den linken Nachfolger */
    private BAUMELEMENT linkerNachfolger;

    /** Referenz auf den rechten Nachfolger */
    private BAUMELEMENT rechterNachfolger;

    /** Referenz auf das Datenelement */
    private DATENELEMENT daten;

    /**
     * Erzeugt einen Knoten mit den dem angegebenen Datenelement.
     *
     * @param d Referenz auf das verwaltete Datenelement
     */
    KNOTEN_BAUM(DATENELEMENT d)
    {
        super();
        linkerNachfolger = new ABSCHLUSS_BAUM();
        rechterNachfolger = new ABSCHLUSS_BAUM();
        daten = d;
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param b Referenz auf das einzufügende Datenelement
     */
    void LinksEinfuegen(BAUM b)
    {
        linkerNachfolger = b.WurzelGeben();
    }

    void RechtsEinfuegen(BAUM b)
    {
        rechterNachfolger = b.WurzelGeben();
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
