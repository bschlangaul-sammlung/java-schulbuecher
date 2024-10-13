package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_14.lotto;

/**
 * Beschreibung der Klasse Knoten
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Knoten extends Listenelement
{
    /** Verwaltung der Daten */
    private int i;

    /** Verwaltung des nachfolgenden Knotens in der Liste */
    private Listenelement nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param zahlNeu Datenelement
     * @param lNeu neuer Nachfolger
     */
    Knoten(int zahlNeu, Listenelement lNeu)
    {
        i = zahlNeu;
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
     * @param zahlNeu übergebenes Datenelement
     *
     * @return gibt das Datenelement zurück, das von hinten kommt
     */
    @Override
    int EndeGeben(int zahlNeu)
    {
        return nachfolger.EndeGeben(i);
    }

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param zahlNeu übergebenes Datenelement
     *
     * @return falls dies der betroffene Knoten ist, dann den Nachfolger, sonst
     *     sich selbst
     */
    @Override
    Listenelement KnotenEntfernen(int zahlNeu)
    {
        if (i == zahlNeu)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.KnotenEntfernen(zahlNeu);
            return this;
        }
    }

    /**
     * Gibt das Datenelement zurück
     *
     * @return i
     */
    @Override
    int ZahlGeben()
    {
        return i;
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
        System.out.println(i + " ");
        nachfolger.InformationAusgeben();
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param zahlNeu neues Datenelement
     *
     * @return (bisheriger) Knoten als neuer Nachfolger
     */
    @Override
    Knoten HintenEinfügen(int zahlNeu)
    {
        nachfolger = nachfolger.HintenEinfügen(zahlNeu);
        return this;
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param zahlNeu neues Datenelement
     * @param zahlVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als Nachfolger für den alten Vorgänger
     */
    @Override
    Knoten EinfügenVor(int zahlNeu, int zahlVergleich)
    {
        if (i == zahlVergleich)
        {
            return new Knoten(zahlNeu, this);
        }
        else
        {
            nachfolger = nachfolger.EinfügenVor(zahlNeu, zahlVergleich);
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
    int Suchen(String schlüssel)
    {
        if (i == Integer.parseInt(schlüssel))
        {
            return i;
        }
        else
        {
            return nachfolger.Suchen(schlüssel);
        }
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param zahlNeu neues Datenelement
     *
     * @return Knoten als ggf. neuer Nachfolger für den Vorgänger
     */
    @Override
    Knoten SortiertEinfügen(int zahlNeu)
    {
        if (i < zahlNeu)
        {
            nachfolger = nachfolger.SortiertEinfügen(zahlNeu);
            return this;
        }
        else
        {
            return new Knoten(zahlNeu, this);
        }
    }
}
