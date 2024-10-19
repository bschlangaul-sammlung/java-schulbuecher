package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.baum;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Beschreibt einen Knoten des Baums.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Knoten extends BaumElement
{
    /**
     * Referenz auf das Datenelement
     */
    private DatenElement daten;

    /**
     * Referenz auf den linken Nachfolgerknoten (mit den kleineren Werten)
     */
    private BaumElement linksnachfolger;

    /*
     * Referenz auf den rechten Nachfolgerknoten (mit den größeren Werten)
     */
    private BaumElement rechtsnachfolger;

    /**
     * Legt einen neuen Knoten mit gegebenem Datenelement und gegebenen
     * Nachfolgern an.
     *
     * @param d Referenz auf das von diesem Knoten verwaltete Datenelement
     * @param lnf Referenz auf das linke Nachfolgerelement
     * @param rnf Referenz auf das rechte Nachfolgerelement
     */
    Knoten(DatenElement d, BaumElement lnf, BaumElement rnf)
    {
        daten = d;
        linksnachfolger = lnf;
        rechtsnachfolger = rnf;
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der (neue) Nachfolger für das Vorgängerelement
     */
    BaumElement Einfuegen(DatenElement neu)
    {
        if (neu.Vergleichen(daten) > 0)
        {
            rechtsnachfolger = rechtsnachfolger.Einfuegen(neu);
        }
        else
        {
            linksnachfolger = linksnachfolger.Einfuegen(neu);
        }
        return this;
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
        int vergleich;
        Baum.ZaehlerErhoehen();
        vergleich = schluessel.Vergleichen(daten);
        if (vergleich == 0)
        {
            return daten;
        }
        else if (vergleich < 0)
        {
            return linksnachfolger.Suchen(schluessel);
        }
        else
        {
            return rechtsnachfolger.Suchen(schluessel);
        }
    }
}
