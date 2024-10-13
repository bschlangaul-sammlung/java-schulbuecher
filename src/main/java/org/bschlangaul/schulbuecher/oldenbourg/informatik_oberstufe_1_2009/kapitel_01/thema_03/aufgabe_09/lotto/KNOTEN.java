package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Beschreibung der Klasse KNOTEN
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class KNOTEN
{
    /** Datenelement des Knotens */
    private DATENELEMENT daten;

    /** Verwaltung des nachfolgenden Knoten in der Warteschlange. */
    private KNOTEN nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param d neues Datenelement
     * @param k Nachfolger des Knotens
     */
    KNOTEN(DATENELEMENT d, KNOTEN k)
    {
        daten = d;
        nachfolger = k;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfuegen(DATENELEMENT dneu)
    {
        if (nachfolger != null)
        {
            nachfolger.HintenEinfuegen(dneu);
        }
        else
        {
            KNOTEN kneu;
            kneu = new KNOTEN(dneu, null);
            nachfolger = kneu;
        }
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    KNOTEN SortiertEinfuegen(DATENELEMENT dneu)
    {
        if (daten.IstKleinerAls(dneu))
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.SortiertEinfuegen(dneu);
            }
            else
            {
                HintenEinfuegen(dneu);
            }
            return this;
        }
        else
        {
            KNOTEN kneu;
            kneu = new KNOTEN(dneu, this);
            return kneu;
        }
    }

    /**
     * Gibt Information über das Datenelement und den Nachfolger des Knotens
     * aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
        if (nachfolger != null)
        {
            nachfolger.InformationAusgeben();
        }
    }
}
