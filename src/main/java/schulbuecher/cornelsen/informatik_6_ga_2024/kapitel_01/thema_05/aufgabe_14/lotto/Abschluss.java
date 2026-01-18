package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_14.lotto;

/**
 * Klasse zur Kennzeichnung des Ende der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Abschluss extends Listenelement
{

    /**
     * Gibt die Länge zurück.
     *
     * @return Länge
     */
    @Override
    int RestlängeGeben()
    {
        return 0;
    }

    /**
     * Gibt das Datenelement des Vorgängers (also des letzten Knotens) zurück
     *
     * @param zahlNeu übergebenes Datenelement
     *
     * @return übergebenes Datenelement
     */
    @Override
    int EndeGeben(int zahlNeu)
    {
        return zahlNeu;
    }

    /**
     * Entfernt den Knoten, dessen Datenelement das übergebene ist.
     *
     * @param zahlNeu übergebenes Datenelement
     *
     * @return gibt sich selbst zurück
     */
    @Override
    Listenelement KnotenEntfernen(int zahlNeu)
    {
        return this;
    }

    /**
     * Da der Abschluss kein Datenelement hat, gibt er 0 zurück
     *
     * @return 0
     */
    @Override
    int ZahlGeben()
    {
        return 0;
    }

    /**
     * Da der Abschluss keinen Nachfolger hat, gibt er sich selbst zurück
     *
     * @return nachfolger
     */
    @Override
    Listenelement NachfolgerGeben()
    {
        return this;
    }

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus
     */
    @Override
    void InformationAusgeben()
    {
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param zahlNeu neues Datenelement
     *
     * @return (neuer) Knoten als neuer Nachfolger des bisherigen Vorgängers
     */
    @Override
    Knoten HintenEinfügen(int zahlNeu)
    {
        return new Knoten(zahlNeu, this);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param zahlNeu neues Datenelement
     * @param zahlVergleich Datenelement, vor dem eingefügt werden soll
     *
     * @return Knoten als neuer Nachfolger für den alten Vorgänger
     */
    @Override
    Knoten EinfügenVor(int zahlNeu, int zahlVergleich)
    {
        return new Knoten(zahlNeu, this);
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchte Zahl
     */
    @Override
    int Suchen(String schlüssel)
    {
        return 0;
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param zahlNeu neues Datenelement
     *
     * @return Knoten als neuer Nachfolger für den Vorgänger
     */
    @Override
    Knoten SortiertEinfügen(int zahlNeu)
    {
        return new Knoten(zahlNeu, this);
    }
}
