package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Verwaltet einen Knoten der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Knoten extends ListenElement
{
    /**
     * Der Nachfolger des Knoten
     */
    private ListenElement nachfolger;

    /**
     * Das Datenelement des Knoten
     */
    private KnotenInfo daten;

    /**
     * Belegt Nachfolger und Datenelement.
     *
     * @param daten das zu verwaltende Datenelement
     * @param nachfolger der Nachfolgerknoten
     */
    Knoten(KnotenInfo daten, ListenElement nachfolger)
    {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    KnotenInfo AnfangGeben()
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
    KnotenInfo KnotenSuchen(int nummer)
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
    KnotenInfo MinimumSuchen(KnotenInfo akt)
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
    ListenElement KnotenEntfernen(KnotenInfo daten)
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
