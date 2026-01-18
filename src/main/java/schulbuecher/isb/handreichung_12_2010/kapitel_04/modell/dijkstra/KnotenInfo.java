package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Knoteninformation für Dijkstra-Algorithmus.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class KnotenInfo
{
    /**
     * Knotennummer
     */
    int nummer;

    /**
     * Vorgängerknoten für Wegangabe
     */
    private int vorgaenger;

    /**
     * Weglänge bis zu diesem Knoten
     */
    private int laenge;

    /**
     * Belegt die Attribute vor.
     *
     * @param n Nummer des Knotens
     */
    KnotenInfo(int n)
    {
        nummer = n;
        vorgaenger = -1;
        laenge = 0;
    }

    /**
     * Meldet die Nummer des Knotens.
     *
     * @return Knotennummer
     */
    int NummerGeben()
    {
        return nummer;
    }

    /**
     * Setzt den Vorgängerknoten.
     *
     * @param vorgNeu neuer Vorgänger
     */
    void VorgaengerSetzen(int vorgNeu)
    {
        vorgaenger = vorgNeu;
    }

    /**
     * Meldet den Vorgängerknoten.
     *
     * @return der Vorgänger
     */
    int VorgaengerGeben()
    {
        return vorgaenger;
    }

    /**
     * Setzt die Weglänge.
     *
     * @param laengeNeu neue Weglänge
     */
    void LaengeSetzen(int laengeNeu)
    {
        laenge = laengeNeu;
    }

    /**
     * Meldet die Weglänge.
     *
     * @return die Weglänge
     */
    int LaengeGeben()
    {
        return laenge;
    }

    /**
     * Vergleicht die angegebene Nummer mit der Nummer des Knotens.
     *
     * @param nummer Vergleichsnummer
     *
     * @return true, wenn der Knoten die angegebene Nummer hat
     */
    boolean IstKnoten(int nummer)
    {
        return this.nummer == nummer;
    }

    /**
     * Vergleicht die Länge mit einem anderen Knoten.
     *
     * @return true, wenn die eigene Länge kleiner ist als die des
     *     Vergleichsknotens
     */
    boolean IstKleiner(KnotenInfo k)
    {
        return laenge < k.laenge;
    }
}
