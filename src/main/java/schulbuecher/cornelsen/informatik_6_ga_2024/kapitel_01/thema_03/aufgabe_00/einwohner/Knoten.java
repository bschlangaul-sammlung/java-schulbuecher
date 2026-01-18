package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_00.einwohner;

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
     * Verwaltung des nachfolgenden Knoten in der Warteschlange.
     */
    private Knoten nachfolger;

    /**
     * Verwaltung der Daten des Bürgers
     */
    private Buerger bürger;

    /**
     * Konstruktor des Knoten
     *
     * @param bürgerNeu verwalteter Bürger
     */
    Knoten(Buerger bürgerNeu)
    {
        nachfolger = null;
        bürger = bürgerNeu;
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
     * Gibt den Bürger zurück
     *
     * @return Bürger
     */
    Buerger DatenelementGeben()
    {
        return bürger;
    }

    /**
     * Gibt Information über den Bürger aus.
     */
    void InformationAusgeben()
    {
        bürger.InformationAusgeben();
    }
}
