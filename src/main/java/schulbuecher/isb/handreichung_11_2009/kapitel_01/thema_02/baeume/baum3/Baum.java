package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum3;

/**
 * Verwaltet den Baum als Ganzes.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Baum
{
    /**
     * Referenz auf die Wurzel des Baums
     */
    private BaumElement wurzel;

    /**
     * Legt einen leeren Baum an.
     */
    Baum()
    {
        wurzel = new Abschluss();
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
        return wurzel.Suchen(wert);
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param wert Referenz auf das einzufügende Datenelement
     */
    void Einfuegen(DatenElement wert)
    {
        wurzel = wurzel.Einfuegen(wert);
    }
}
