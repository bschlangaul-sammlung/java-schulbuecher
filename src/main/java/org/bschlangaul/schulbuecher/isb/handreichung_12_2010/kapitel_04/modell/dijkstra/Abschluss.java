package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.dijkstra;

/**
 * Beschreibt das Abschlusselement der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Abschluss extends ListenElement
{
    /**
     * Constructor for objects of class ABSCHLUSS
     */
    Abschluss()
    {
        super();
    }

    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    KnotenInfo AnfangGeben()
    {
        return null;
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
        return null;
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
        return akt;
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
        return this;
    }
}
