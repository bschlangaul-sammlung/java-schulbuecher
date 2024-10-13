package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.liste;

import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.DATENELEMENT;

/**
 * Beschreibt einen Knoten der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    /* Referenz auf das Datenelement */
    private DATENELEMENT daten;

    /* Referenz auf den Nachfolgerknoten */
    private LISTENELEMENT nachfolger;

    /**
     * Legt einen neuen Knoten mit gegebenem Datenelement und gegebenem
     * Nachfolger an.
     *
     * @param d Referenz auf das von diesem Knoten verwaltete Datenelement
     * @param nf Referenz auf das Nachfolgerelement
     */
    KNOTEN(DATENELEMENT d, LISTENELEMENT nf)
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
    LISTENELEMENT Einfuegen(DATENELEMENT neu)
    {
        if (neu.Vergleichen(daten) > 0)
        {
            nachfolger = nachfolger.Einfuegen(neu);
            return this;
        }
        else
        {
            return new KNOTEN(neu, this);
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
    DATENELEMENT Suchen(DATENELEMENT schluessel)
    {
        LISTE.ZaehlerErhoehen();
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
