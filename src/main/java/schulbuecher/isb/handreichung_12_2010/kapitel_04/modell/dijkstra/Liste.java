package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Liste von Knoteninformationen mit speziellen Methoden.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Liste
{
    /**
     * Der Startknoten der Liste
     */
    private ListenElement anfang;

    /**
     * Legt eine leere Liste an.
     */
    Liste()
    {
        anfang = new Abschluss();
    }

    /**
     * Fügt ein Datenelement vorn in die Liste ein.
     *
     * @param daten Referenz auf die Einzufügende Knoteninformation
     */
    void Einfuegen(KnotenInfo daten)
    {
        anfang = new Knoten(daten, anfang);
    }

    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    KnotenInfo AnfangGeben()
    {
        return anfang.AnfangGeben();
    }

    /**
     * Sucht den Knnoten mit der angegebenen Nummer.
     *
     * @param nummer Nummer des Knotens
     *
     * @return Konoteninformation
     */
    KnotenInfo KnotenSuchen(int nummer)
    {
        return anfang.KnotenSuchen(nummer);
    }

    /**
     * Sucht den Knnoten mit der kleinsten Weglänge.
     *
     * @return Knoteninformation
     */
    KnotenInfo MinimumSuchen()
    {
        return anfang.MinimumSuchen(null);
    }

    /**
     * Löscht den Knoten für das gegebene Datenelement
     *
     * @param daten Datenelement, dess Knoten gelöscht werden soll
     */
    void KnotenEntfernen(KnotenInfo daten)
    {
        anfang = anfang.KnotenEntfernen(daten);
    }
}
