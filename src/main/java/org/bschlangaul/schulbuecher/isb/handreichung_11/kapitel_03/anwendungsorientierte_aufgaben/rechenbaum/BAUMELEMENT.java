package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

/**
 * Beschreibt ein allgemeines Element des Baums.
 *
 * @author ISB-Arbeitskreis
 * @version 1.0
 */
abstract class BAUMELEMENT
{
    /**
     * Der Konstruktor ist aus Dokumentationsgründen vorhanden
     */
    BAUMELEMENT()
    {
        // keine spezielle Aufgabe
    }

    /**
     * ...
     *
     * @param wert Referenz auf die Wurzel des einzufuegenden Baumes
     */
    abstract void LinksEinfuegen(BAUM b);

    abstract void RechtsEinfuegen(BAUM b);

    /**
     * Durchläft den Baum in Preorder
     */
    abstract void PreOrder();

    /**
     * Durchläft den Baum in Inorder
     */
    abstract void InOrder();

    /**
     * Durchläft den Baum in Postorder
     */
    abstract void PostOrder();
}
