package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.liste;

import schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Beschreibt einen Knoten der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Knoten extends ListenElement
{
    /**
     * Referenz auf das Datenelement
     */
    private DatenElement daten;

    /**
     * Referenz auf den Nachfolgerknoten
     */
    private ListenElement nachfolger;

    /**
     * Legt einen neuen Knoten mit gegebenem Datenelement und gegebenem
     * Nachfolger an.
     *
     * @param d Referenz auf das von diesem Knoten verwaltete Datenelement
     * @param nf Referenz auf das Nachfolgerelement
     */
    Knoten(DatenElement d, ListenElement nf)
    {
        daten = d;
        nachfolger = nf;
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der (neue) Nachfolger für das Vorgängerelement
     */
    ListenElement Einfuegen(DatenElement neu)
    {
        if (neu.Vergleichen(daten) > 0)
        {
            nachfolger = nachfolger.Einfuegen(neu);
            return this;
        }
        else
        {
            return new Knoten(neu, this);
        }
    }

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return das gefundene Datenelement oder null
     */
    DatenElement Suchen(DatenElement schluessel)
    {
        Liste.ZaehlerErhoehen();
        if (schluessel.Vergleichen(daten) == 0)
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(schluessel);
        }
    }
}
