package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum3;

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
     */
    BaumElement Einfuegen(DatenElement wert)
    {
        return new Knoten(wert);
    }
}
