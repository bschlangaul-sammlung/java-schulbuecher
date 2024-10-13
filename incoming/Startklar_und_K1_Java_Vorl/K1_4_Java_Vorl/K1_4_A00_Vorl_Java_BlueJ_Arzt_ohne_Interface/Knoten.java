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
     * Fügt ein Datenelement am Ende der Liste ein
     * @param dneu neues Datenelement
     */
    void HintenEinfügen(Patient dneu)
    {
        if(nachfolger != null)
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
    }
}
