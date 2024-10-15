package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.liste;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DATENELEMENT;

/**
 * Beschreibt ein Abschlusselement der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Für das Anlegen des Abschlusses brauchts nichts getan zu werden.
     */
    ABSCHLUSS()
    {
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der neue Nachfolger für das Vorgängerelement
     */
    LISTENELEMENT Einfuegen(DATENELEMENT neu)
    {
        return new KNOTEN(neu, this);
    }

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel. Das
     * Datenelement ist in diesem Fall sicher nicht in der Liste vorhanden.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return null
     */
    DATENELEMENT Suchen(DATENELEMENT schluessel)
    {
        return null;
    }
}
