package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Allgemeines Element der Knoteninfoliste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
abstract class ListenElement
{
    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    abstract KnotenInfo AnfangGeben();

    /**
     * Sucht den Knnoten mit der angegebenen Nummer.
     *
     * @param nummer Nummer des Knotens
     *
     * @return Konoteninformation
     */
    abstract KnotenInfo KnotenSuchen(int nummer);

    /**
     * Sucht den Knnoten mit der kleinsten Weglänge.
     *
     * @param akt aktuelles Minimum
     *
     * @return Konoteninformation
     */
    abstract KnotenInfo MinimumSuchen(KnotenInfo akt);

    /**
     * Löscht den Knoten für das gegebene Datenelement
     *
     * @param daten Datenelement, dess Knoten gelöscht werden soll
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    abstract ListenElement KnotenEntfernen(KnotenInfo daten);
}
