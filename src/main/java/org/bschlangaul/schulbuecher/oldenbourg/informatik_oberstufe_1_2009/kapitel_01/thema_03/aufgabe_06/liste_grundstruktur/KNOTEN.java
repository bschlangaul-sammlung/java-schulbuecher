package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_06.liste_grundstruktur;

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
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    KNOTEN EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
    {
        if (daten != d_vergleich)
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.EinfuegenVor(dneu, d_vergleich);
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
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus
     * der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    KNOTEN KnotenEntfernen(DATENELEMENT dvergleich)
    {
        if (daten == dvergleich)
        {
            return nachfolger;
        }
        else
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.KnotenEntfernen(dvergleich);
                return this;
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * Gibt das Datenelement des letzten Knotens aus
     *
     * @return hinterstes Datenelement
     */
    DATENELEMENT EndeGeben()
    {
        if (nachfolger == null)
        {
            return daten;
        }
        else
        {
            return nachfolger.EndeGeben();
        }
    }

    /**
     * Gibt den letzten Knoten aus und entfernt ihn aus der Liste
     *
     * @return bisheriger letzter Knoten
     */
    KNOTEN EndeEntfernen()
    {
        if (nachfolger == null)
        {
            return null;
        }
        else
        {
            nachfolger = nachfolger.EndeEntfernen();
            return this;
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

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert Schlüssel vom Typ String
     *
     * @return gesuchtes Datenelement
     */
    DATENELEMENT Suchen(String vergleichswert)
    {
        if (daten.SchluesselIstGleich(vergleichswert))
        {
            return daten;
        }
        else
        {
            if (nachfolger != null)
            {
                return nachfolger.Suchen(vergleichswert);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * Gibt die Länge der Restliste aus
     *
     * @return Länge der Restliste
     */
    int RestlaengeGeben()
    {
        if (nachfolger == null)
        {
            return 1;
        }
        else
        {
            return nachfolger.RestlaengeGeben() + 1;
        }
    }

    /**
     * Gibt eine Referenz auf das Datenelement aus
     *
     * @return Datenelement
     */
    DATENELEMENT DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    KNOTEN NachfolgerGeben()
    {
        return nachfolger;
    }
}
