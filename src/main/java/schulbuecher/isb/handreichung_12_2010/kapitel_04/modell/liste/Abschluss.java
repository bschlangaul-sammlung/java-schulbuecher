package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.liste;

import schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Beschreibt ein Abschlusselement der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Abschluss extends ListenElement
{
    /**
     * Für das Anlegen des Abschlusses brauchts nichts getan zu werden.
     */
    Abschluss()
    {
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der neue Nachfolger für das Vorgängerelement
     */
    ListenElement Einfuegen(DatenElement neu)
    {
        return new Knoten(neu, this);
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
    DatenElement Suchen(DatenElement schluessel)
    {
        return null;
    }
}
