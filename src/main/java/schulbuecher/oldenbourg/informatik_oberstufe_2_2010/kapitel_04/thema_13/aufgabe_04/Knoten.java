package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

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
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    Knoten SortiertEinfuegen(DatenElement dneu)
    {
        if (daten.SchluesselIstGroesser(dneu.SchluesselGeben()))
        {
            Knoten kneu;
            kneu = new Knoten(dneu, this);
            return kneu;
        }
        else
        {
            if (nachfolger != null)
            {
                nachfolger = nachfolger.SortiertEinfuegen(dneu);
            }
            else
            {
                Knoten kneu;
                kneu = new Knoten(dneu, null);
                nachfolger = kneu;
            }
            return this;
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
    DatenElement Suchen(int vergleichswert)
    {
        Zaehler.ZaehlerInkrementieren();
        if (daten.SchluesselIstGleich(vergleichswert))
        {
            Zaehler.ZaehlerInkrementieren();
            return daten;
        }
        else
        {
            Zaehler.ZaehlerInkrementieren();
            if (nachfolger != null)
            {
                Zaehler.ZaehlerInkrementieren();
                return nachfolger.Suchen(vergleichswert);
            }
            else
            {
                Zaehler.ZaehlerInkrementieren();
                return null;
            }
        }
    }
}
