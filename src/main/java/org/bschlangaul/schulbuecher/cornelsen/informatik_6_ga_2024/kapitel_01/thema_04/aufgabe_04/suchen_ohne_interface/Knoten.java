package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_04.aufgabe_04.suchen_ohne_interface;

/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Knoten
{
    /**
     * Verwaltung des nachfolgenden Knoten in der Liste.
     */
    private Knoten nachfolger;

    /**
     * Verwaltung der Daten
     */
    private Patient daten;

    /**
     * Konstruktor des Knoten
     *
     * @param dneu Datenelement
     */
    Knoten(Patient dneu)
    {
        daten = dneu;
        nachfolger = null;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    void HintenEinfügen(Patient dneu)
    {
        if (nachfolger != null)
        {
            nachfolger.HintenEinfügen(dneu);
        }
        else
        {
            Knoten kneu;
            kneu = new Knoten(dneu);
            nachfolger = kneu;
        }
    }

    /**
     * Bestimmt die Länge der restlichen Liste ab dem aktuellen Knoten
     *
     * @return Länge der restlichen Liste
     */
    int RestlängeGeben()
    {
        if (nachfolger == null)
        {
            return 1;
        }
        else
        {
            return nachfolger.RestlängeGeben() + 1;
        }
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüssel in der Liste
     *
     * @param gesuchterWert Zeichenkette, die als Schlüssel gefunden werden
     *     soll.
     *
     * @return das gesuchte Datenelement
     */
    Patient Suchen(String gesuchterWert)
    {
        if (nachfolger != null)
        {
            if (daten.SchlüsselIstGleich(gesuchterWert))
            {
                return daten;
            }
            else
            {
                return nachfolger.Suchen(gesuchterWert);
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Nachfolger des Knoten setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Knoten nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knoten aus.
     *
     * @return Nachfolger
     */
    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt das Datenelement zurück
     *
     * @return Datenelement
     */
    Patient DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt Information über das Datenelement aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
    }
}
