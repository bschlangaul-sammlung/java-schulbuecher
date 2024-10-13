/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 * @version 1.0
 */
class Knoten
{
    /**
     * Verwaltung des nachfolgenden Knoten in der Warteschlange. */
    private Knoten nachfolger;

    /**
     * Verwaltung der Daten */
    private Patient daten;

    /**
     * Konstruktor des Knoten
     * @param dNeu Datenelement
     */
    Knoten(Patient dneu)
    {
        daten = dneu;
        nachfolger  = null;
    }

    /**
     * Konstruktor des Knoten
     * @param dNeu Datenelement
     * @param kNeu neuer Nachfolger
     */
    Knoten(Patient dNeu, Knoten kNeu)
    {
        daten = dNeu;
        nachfolger  = kNeu;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
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
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten EinfügenVor(Patient dneu, Patient d_vergleich)
    {
        if (daten != d_vergleich)
        {
            if(nachfolger != null)
            {
                nachfolger = nachfolger.EinfügenVor(dneu, d_vergleich);
            }
            else
            {
                HintenEinfügen(dneu);
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
     * Fügt ein Datenelement sortiert in die Liste ein
     * @param dneu neues Datenelement
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten SortiertEinfügen(Patient dneu)
    {
        if (daten.IstKleinerAls(dneu))
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.SortiertEinfügen(dneu);
            }
            else
            {
                HintenEinfügen(dneu);
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
     * Sucht ein Datenelement mit einem bestimmten Schlüssel in der Liste
     * @param gesuchterWert Zeichenkette, die als Schlüssel gefunden werden soll.
     * @return das gesuchte Datenelement
     */
    Patient Suchen(String gesuchterWert)
    {
        if (daten.SchlüsselIstGleich(gesuchterWert))
        {
            return daten;
        }
        else
        {
            if (nachfolger != null)
            {
                return nachfolger.Suchen(gesuchterWert);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * Bestimmt die Länge der restlichen Liste ab dem aktuellen Knoten
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
            return nachfolger.RestlängeGeben()+1;
        }
    }

    /**
     * Nachfolger des Knoten setzen
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Knoten nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Knoten aus.
     * @return Nachfolger
     */
    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt das Datenelement zurück
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
        if (nachfolger != null)
        {
            nachfolger.InformationAusgeben();
        }
    }

    /**
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus der Liste
     * @param dvergleich gesuchtes Datenelement
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten KnotenEntfernen(Patient dvergleich)
    {
        if (daten == dvergleich)
        {
            return nachfolger;
        }
        else
        {
            if (nachfolger != null)
            {
                nachfolger=nachfolger.KnotenEntfernen(dvergleich);
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
     * @return hinterstes Datenelement
     */
    Patient EndeGeben()
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
     * @return bisheriger letzter Knoten
     */
    Knoten EndeEntfernen()
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
}
