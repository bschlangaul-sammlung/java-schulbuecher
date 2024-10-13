package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_18.nachtraeglich_sortieren;

/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Knoten extends Listenelement
{
    /**
     * Verwaltung der Daten
     */
    private Patient daten;

    /**
     * Verwaltung des nachfolgenden Knotens in der Liste
     */
    private Listenelement nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param dNeu Datenelement
     * @param lNeu neuer Nachfolger
     */
    Knoten(Patient dNeu, Listenelement lNeu)
    {
        daten = dNeu;
        nachfolger = lNeu;
    }

    /**
     * Gibt die Länge zurück.
     *
     * @return Länge
     */
    @Override
    int RestlängeGeben()
    {
        return nachfolger.RestlängeGeben() + 1;
    }

    /**
     * Gibt das Datenelement des letzten Knoten zurück
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return gibt das Datenelement zurück, das von hinten kommt
     */
    @Override
    Patient EndeGeben(Patient dNeu)
    {
        return nachfolger.EndeGeben(daten);
    }

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param dNeu übergebenes Datenelement
     *
     * @return falls dies der betroffene Knoten ist, dann den Nachfolger, sonst
     *     sich selbst
     */
    @Override
    Listenelement KnotenEntfernen(Patient dNeu)
    {
        if (daten == dNeu)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.KnotenEntfernen(dNeu);
            return this;
        }
    }

    /**
     * Gibt das Datenelement zurück
     *
     * @return daten
     */
    @Override
    Patient DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt den Nachfolger zurück
     *
     * @return nachfolger
     */
    @Override
    Listenelement NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus
     */
    @Override
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
        nachfolger.InformationAusgeben();
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param dNeu neues Datenelement
     *
     * @return (bisheriger) Knoten als neuer Nachfolger
     */
    @Override
    Knoten HintenEinfügen(Patient dNeu)
    {
        nachfolger = nachfolger.HintenEinfügen(dNeu);
        return this;
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param dNeu neues Datenelement
     * @param dVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als Nachfolger für den alten Vorgänger
     */
    @Override
    Knoten EinfügenVor(Patient dNeu, Patient dVergleich)
    {
        if (daten == dVergleich)
        {
            return new Knoten(dNeu, this);
        }
        else
        {
            nachfolger = nachfolger.EinfügenVor(dNeu, dVergleich);
            return this;
        }
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    @Override
    Patient Suchen(String schlüssel)
    {
        if (daten.SchlüsselIstGleich(schlüssel))
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(schlüssel);
        }
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param dNeu neues Datenelement
     *
     * @return Knoten als ggf. neuer Nachfolger für den Vorgänger
     */
    @Override
    Knoten SortiertEinfügen(Patient dNeu)
    {
        if (daten.IstKleinerAls(dNeu))
        {
            nachfolger = nachfolger.SortiertEinfügen(dNeu);
            return this;
        }
        else
        {
            return new Knoten(dNeu, this);
        }
    }

}
