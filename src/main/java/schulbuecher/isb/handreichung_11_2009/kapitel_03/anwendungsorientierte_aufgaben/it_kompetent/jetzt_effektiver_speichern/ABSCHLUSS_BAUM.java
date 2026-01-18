package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

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
        return new KNOTEN_BAUM(wert);
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
