package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.woerterbuch;

/**
 * Beschreibt das Abschlusselement des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class ABSCHLUSS extends BAUMELEMENT
{
    /**
     * In der Klasse ABSCHLUSS fallen keine speziellen Initialisierungen an.
     */
    ABSCHLUSS()
    {
        super();
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
        return null;
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    BAUMELEMENT Einfuegen(DATENELEMENT wert)
    {
        return new KNOTEN(wert);
    }

    /**
     * Durchläft den Baum in Preorder
     */
    void PreOrder()
    {
    }

    /**
     * Durchläft den Baum in Inorder
     */
    void InOrder()
    {
    }

    /**
     * Durchläft den Baum in Postorder
     */
    void PostOrder()
    {
    }
}
