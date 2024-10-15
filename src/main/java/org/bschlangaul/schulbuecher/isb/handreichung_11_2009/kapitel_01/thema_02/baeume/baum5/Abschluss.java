package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum5;

/**
 * Beschreibt das Abschlusselement des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Abschluss extends BaumElement
{
    /**
     * In der Klasse ABSCHLUSS fallen keine speziellen Initialisierungen an.
     */
    Abschluss()
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
    DatenElement Suchen(DatenElement wert)
    {
        return null;
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    BaumElement Einfuegen(DatenElement wert)
    {
        return new Knoten(wert);
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
    BaumElement Entfernen(DatenElement wert)
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
    protected BaumElement AnfuegenRechts(BaumElement teil)
    {
        return teil;
    }
}
