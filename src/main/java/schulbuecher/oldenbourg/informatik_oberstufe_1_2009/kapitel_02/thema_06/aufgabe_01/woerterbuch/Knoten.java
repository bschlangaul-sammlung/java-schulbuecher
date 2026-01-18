package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch;

/**
 * Beschreibung der Klasse KNOTEN
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Knoten extends ListenElement
{
    /**
     * Datenelement des Knotens
     */
    private DatenElement daten;

    /**
     * Verwaltung des nachfolgenden Knoten in der Warteschlange.
     */
    private ListenElement nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param d neues Datenelement
     * @param l Nachfolger des Knotens
     */
    public Knoten(DatenElement d, ListenElement l)
    {
        daten = d;
        nachfolger = l;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    public Knoten HintenEinfuegen(DatenElement dneu)
    {
        nachfolger = nachfolger.HintenEinfuegen(dneu);
        return this;
    }

    /**
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    public Knoten EinfuegenVor(DatenElement dneu, DatenElement d_vergleich)
    {
        if (daten == d_vergleich)
        {
            Knoten kneu;
            kneu = new Knoten(dneu, this);
            return kneu;
        }
        else
        {
            nachfolger = nachfolger.EinfuegenVor(dneu, d_vergleich);
            return this;
        }
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    public Knoten SortiertEinfuegen(DatenElement dneu)
    {
        if (daten.IstKleinerAls(dneu))
        {
            nachfolger = nachfolger.SortiertEinfuegen(dneu);
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
    public ListenElement KnotenEntfernen(DatenElement dvergleich)
    {
        if (daten == dvergleich)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.KnotenEntfernen(dvergleich);
            return this;
        }
    }

    /**
     * Gibt das Datenelement des letzten Knotens aus
     *
     * @param d Vorgänger gibt Referenz auf sein Datenelement mit.
     *
     * @return hinterstes Datenelement
     */
    public DatenElement EndeGeben(DatenElement d)
    {
        return nachfolger.EndeGeben(daten);
    }

    /**
     * Gibt den letzten Knoten aus und entfernt ihn aus der Liste
     *
     * @return bisheriger letzter Knoten
     */
    public ListenElement EndeEntfernen(DatenElement d)
    {
        if (daten == d)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.EndeEntfernen(d);
            return this;
        }
    }

    /**
     * Gibt Information über das Datenelement und den Nachfolger des Knotens
     * aus.
     */
    public void InformationAusgeben()
    {
        daten.InformationAusgeben();
        nachfolger.InformationAusgeben();
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert Schlüssel vom Typ String
     *
     * @return gesuchtes Datenelement
     */
    public DatenElement Suchen(String vergleichswert)
    {
        if (daten.SchluesselIstGleich(vergleichswert))
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(vergleichswert);
        }
    }

    /**
     * Gibt die Länge der Restliste aus
     *
     * @return Länge der Restliste
     */
    public int RestlaengeGeben()
    {
        return nachfolger.RestlaengeGeben() + 1;
    }

    /**
     * Gibt eine Referenz auf das Datenelement aus
     *
     * @return Datenelement
     */
    public DatenElement DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    public ListenElement NachfolgerGeben()
    {
        return nachfolger;
    }
}
