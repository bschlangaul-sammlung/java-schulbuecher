package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.baum;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Beschreibt ein Abschlusselement des Baums.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Abschluss extends BaumElement
{
    /**
     * Für das Anlegen des Abschlusses brauchts nichts getan zu werden.
     */
    Abschluss()
    {
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der neue Nachfolger für das Vorgängerelement
     */
    BaumElement Einfuegen(DatenElement neu)
    {
        return new Knoten(neu, this, this);
    }

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel. Das
     * Datenelement ist in diesem Fall sicher nicht im Baum vorhanden.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return null
     */
    DatenElement Suchen(DatenElement schluessel)
    {
        return null;
    }
}
