package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.dijkstra;

/**
 * Allgemeines Element der Knoteninfoliste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
abstract class LISTENELEMENT
{
    /**
     * Gibt die Knoteninformation des ersten Elements der Liste.
     *
     * @return Knoteninformation
     */
    abstract KNOTENINFO AnfangGeben();

    /**
     * Sucht den Knnoten mit der angegebenen Nummer.
     *
     * @param nummer Nummer des Knotens
     *
     * @return Konoteninformation
     */
    abstract KNOTENINFO KnotenSuchen(int nummer);

    /**
     * Sucht den Knnoten mit der kleinsten Weglänge.
     *
     * @param akt aktuelles Minimum
     *
     * @return Konoteninformation
     */
    abstract KNOTENINFO MinimumSuchen(KNOTENINFO akt);

    /**
     * Löscht den Knoten für das gegebene Datenelement
     *
     * @param daten Datenelement, dess Knoten gelöscht werden soll
     *
     * @return (neuer) Nachfolger des Vorgängers
     */
    abstract LISTENELEMENT KnotenEntfernen(KNOTENINFO daten);
}
