package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum5;

/**
 * Beschreibt ein allgemeines Element des Baums.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
abstract class BaumElement
{
    /**
     * Der Konstruktor ist aus Dokumentationsgründen vorhanden
     */
    BaumElement()
    {
        // keine spezielle Aufgabe
    }

    /**
     * Sucht im Baum nach dem gegebenen Datenelelement.
     *
     * @param wert Referenz auf ein Datenelement mit dem Vergleichswert
     *
     * @return Referenz auf das Datenelement, wenn der Wert gefunden wurde<br>
     *     null: sonst
     */
    abstract DatenElement Suchen(DatenElement wert);

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    abstract BaumElement Einfuegen(DatenElement wert);

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

    /**
     * Entfernt den Knoten mit der Referenz auf das Datenelement mit dem
     * gegebenen Schlüssel.
     *
     * @param wert Referenz auf ein Datenelement mit dem Schlüsselwert
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    abstract BaumElement Entfernen(DatenElement wert);

    /**
     * Fügt den angegebenen Teilbaum an der am weitesten rechts stehenden Stelle
     * ein.
     *
     * @param teil der Anzufügende Teilbaum
     *
     * @return der (neue) Nachfolger des Aufrufers
     */
    abstract protected BaumElement AnfuegenRechts(BaumElement teil);
}
