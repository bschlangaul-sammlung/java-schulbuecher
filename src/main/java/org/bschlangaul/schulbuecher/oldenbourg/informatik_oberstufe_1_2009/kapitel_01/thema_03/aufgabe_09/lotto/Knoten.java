package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Beschreibung der Klasse KNOTEN
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Knoten
{
    /**
     * Datenelement des Knotens
     */
    private DatenElement daten;

    /**
     * Verwaltung des nachfolgenden Knoten in der Warteschlange.
     */
    private Knoten nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param d neues Datenelement
     * @param k Nachfolger des Knotens
     */
    Knoten(DatenElement d, Knoten k)
    {
        daten = d;
        nachfolger = k;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfuegen(DatenElement dneu)
    {
        if (nachfolger != null)
        {
            nachfolger.HintenEinfuegen(dneu);
        }
        else
        {
            Knoten kneu;
            kneu = new Knoten(dneu, null);
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
    Knoten SortiertEinfuegen(DatenElement dneu)
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
            Knoten kneu;
            kneu = new Knoten(dneu, this);
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
