package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

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
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten EinfuegenVor(DatenElement dneu, DatenElement d_vergleich)
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
            Knoten kneu;
            kneu = new Knoten(dneu, this);
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
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus
     * der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten KnotenEntfernen(DatenElement dvergleich)
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
    DatenElement EndeGeben()
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
    DatenElement Suchen(String vergleichswert)
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
    DatenElement DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Entfernt alle Knoten ab einem bestimmten Knoten
     *
     * @param s Schlüssel in der Form "x,y"
     * @param gefunden gibt an, ob der Knoten bereits weiter vorne gefunden
     *     wurde
     *
     * @return Rückmeldung über den neuen Nachfolger
     */
    Knoten KnotenAbHierEntfernen(String s, boolean gefunden)
    {
        if (gefunden)
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.KnotenAbHierEntfernen(s, true);
            }
            Zelle zelle;
            zelle = (Zelle) daten;
            zelle.FeldFreigeben();
            return null;
        }
        else
        {
            if (daten.SchluesselIstGleich(s))
            {
                gefunden = true;
                Zelle zelle;
                zelle = (Zelle) daten;
                zelle.FeldFreigeben();
                if (nachfolger != null)
                {
                    nachfolger = nachfolger.KnotenAbHierEntfernen(s, gefunden);
                }
                return null;
            }
            else
            {
                if (nachfolger != null)
                {
                    nachfolger = nachfolger.KnotenAbHierEntfernen(s, gefunden);
                }
                return this;
            }
        }
    }
}
