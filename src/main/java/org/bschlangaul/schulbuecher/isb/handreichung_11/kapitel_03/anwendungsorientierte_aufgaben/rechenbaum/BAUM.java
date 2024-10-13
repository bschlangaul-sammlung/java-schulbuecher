package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

/**
 * Verwaltet den Baum als Ganzes.
 *
 * @author ISB-Arbeitskreis
 *
 * @version 1.0
 */
class BAUM
{
    /** Referenz auf die Wurzel des Baums */
    private BAUMELEMENT wurzel;

    /**
     * Legt einen leeren Baum an.
     */
    BAUM()
    {
        wurzel = new ABSCHLUSS_BAUM();
    }

    BAUM(ZEICHEN z)
    {
        wurzel = new KNOTEN_BAUM(z);
    }

    /**
     * gibt die Wurzel, also den entsprechenden Knoten, zurück
     */
    BAUMELEMENT WurzelGeben()
    {
        return wurzel;
    }

    /**
     * Fügt einen Baum als linken Nachfolger der Wurzel ein Der Wert darf noch
     * nicht vorkommen
     *
     * @param b Referenz auf einen Baum b, eigentlich Referenz auf die Wurzel
     *     des Baumes
     */
    void LinksEinfuegen(BAUM b)
    {
        wurzel.LinksEinfuegen(b);
    }

    /**
     * Fügt einen Baum als rechter Nachfolger der Wurzel ein Der Wert darf noch
     * nicht vorkommen
     *
     * @param b Referenz auf einen Baum b, eigentlich Referenz auf die Wurzel
     *     des Baumes
     */
    void RechtsEinfuegen(BAUM b)
    {
        wurzel.RechtsEinfuegen(b);
    }

    /**
     * Durchläft den Baum in Preorder
     */
    void PreOrder()
    {
        wurzel.PreOrder();
    }

    /**
     * Durchläft den Baum in Inorder
     */
    void InOrder()
    {
        wurzel.InOrder();
    }

    /**
     * Durchläft den Baum in Postorder
     */
    void PostOrder()
    {
        wurzel.PostOrder();
    }
}
