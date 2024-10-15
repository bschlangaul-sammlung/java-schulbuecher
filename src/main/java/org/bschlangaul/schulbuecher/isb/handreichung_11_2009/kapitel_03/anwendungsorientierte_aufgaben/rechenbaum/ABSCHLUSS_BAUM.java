package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

/**
 * Beschreibt das Abschlusselement des Baums.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHLUSS_BAUM extends BAUMELEMENT
{
    /**
     * In der Klasse ABSCHLUSS fallen keine speziellen Initialisierungen an.
     */
    ABSCHLUSS_BAUM()
    {
        super();
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param b Referenz auf das einzufügende Datenelement
     */
    void LinksEinfuegen(BAUM b)
    {
    }

    void RechtsEinfuegen(BAUM b)
    {
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

    /**
     * Entfernt den Knoten mit der Referenz auf das Datenelement mit dem
     * gegebenen Schlüssel.
     *
     * @param wert Referenz auf ein Datenelement mit dem Schlüsselwert
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    BAUMELEMENT Entfernen(DATENELEMENT wert)
    {
        System.out.print("Der zu entfernende Wert wurde nicht gefunden: ");
        wert.Ausgeben();
        return this;
    }

    /**
     * Fügt den angegebenen Teilbaum an der am weitesten rechts stehenden Stelle
     * ein.
     *
     * @param teil der Anzufügende Teilbaum
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    protected BAUMELEMENT AnfuegenRechts(BAUMELEMENT teil)
    {
        return teil;
    }
}
