package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

/**
 * Verwaltet den Baum als Ganzes.
 *
 * @author Albert Wiedemann
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

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     *
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *     null: sonst
     */
    DATENELEMENT Suchen(DATENELEMENT wert)
    {
        return wurzel.Suchen(wert);
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    void Einfuegen(DATENELEMENT wert)
    {
        wurzel = wurzel.Einfuegen(wert);
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
