package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Verwaltet einen Knoten der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    /* der Nachfolger des Knoten */
    private LISTENELEMENT nachfolger;

    /* das Datenelement des Knoten */
    private KNOTENINFO daten;

    /**
     * Belegt Nachfolger und Datenelement.
     *
     * @param daten das zu verwaltende Datenelement
     * @param nachfolger der Nachfolgerknoten
     */
    KNOTEN(KNOTENINFO daten, LISTENELEMENT nachfolger)
    {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    KNOTENINFO AnfangGeben()
    {
        return daten;
    }

    /**
     * Sucht den Knnoten mit der angegebenen Nummer.
     *
     * @param nummer Nummer des Knotens
     *
     * @return Konoteninformation
     */
    KNOTENINFO KnotenSuchen(int nummer)
    {
        if (daten.IstKnoten(nummer))
        {
            return daten;
        }
        else
        {
            return nachfolger.KnotenSuchen(nummer);
        }
    }

    /**
     * Sucht den Knnoten mit der kleinsten Weglänge.
     *
     * @param akt aktuelles Minimum
     *
     * @return Konoteninformation
     */
    KNOTENINFO MinimumSuchen(KNOTENINFO akt)
    {
        if ((akt == null) || daten.IstKleiner(akt))
        {
            return nachfolger.MinimumSuchen(daten);
        }
        else
        {
            return nachfolger.MinimumSuchen(akt);
        }
    }

    /**
     * Löscht den Knoten für das gegebene Datenelement
     *
     * @param daten Datenelement, dess Knoten gelöscht werden soll
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    LISTENELEMENT KnotenEntfernen(KNOTENINFO daten)
    {
        if (this.daten == daten)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.KnotenEntfernen(daten);
            return this;
        }
    }
}
