package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_14.lotto;

/**
 * Beschreibung der Liste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Liste
{
    /** erstes Element der Liste */
    private Listenelement anfang;

    /**
     * Konstruktor der Liste
     */
    Liste()
    {
        anfang = new Abschluss();
    }

    /**
     * Einfügen am Anfang der Liste (nichtrekursiv!)
     *
     * @param zahlNeu neues Datenelement
     */
    void VorneEinfügen(int zahlNeu)
    {
        anfang = new Knoten(zahlNeu, anfang);
    }

    /**
     * Bestimmung der Länge der Liste
     *
     * @return Länge der Liste
     */
    int LängeGeben()
    {
        return anfang.RestlängeGeben();
    }

    /**
     * Entfernt den letzten Knoten und gibt dessen Datenelement zurück.
     *
     * @return Zahl des bisher letzten Knotens
     */
    int EndeEntfernen()
    {
        int letzteZahl = anfang.EndeGeben(0);
        anfang = anfang.KnotenEntfernen(letzteZahl);
        return letzteZahl;
    }

    /**
     * Entfernt den Anfang aus der Liste und gibt das zugehörige Datenelement
     * zurück.
     *
     * @return Datenelement des Anfangsknotens
     */
    int AnfangEntfernen()
    {
        int i = anfang.ZahlGeben();
        anfang = anfang.NachfolgerGeben();
        return i;
    }

    /**
     * Gibt die Information zu den Datenelementen auf der Konsole aus.
     */
    void InformationAusgeben()
    {
        anfang.InformationAusgeben();
    }

    /**
     * Fügt das Datenelement am Ende ein.
     *
     * @param zahlNeu neues Datenelement
     */
    void HintenEinfügen(int zahlNeu)
    {
        anfang = anfang.HintenEinfügen(zahlNeu);
    }

    /**
     * Fügt ein neues Datenelement vor einem bestimmten Datenelement ein.
     *
     * @param zahlNeu neues Datenelement
     * @param zahlVergleich Datenelement, vor dem eingefügt werden soll
     */
    void EinfügenVor(int zahlNeu, int zahlVergleich)
    {
        anfang = anfang.EinfügenVor(zahlNeu, zahlVergleich);
    }

    /**
     * Sucht ein Datenelement mit einem bestimmten Schlüsselwert in der Liste
     * und gibt es zurück.
     *
     * @param schlüssel Wert, nach dem gesucht wird
     *
     * @return gesuchtes Datenelement
     */
    int Suchen(String schlüssel)
    {
        return anfang.Suchen(schlüssel);
    }

    /**
     * Sortiertes Einfügen in die Liste
     *
     * @param zahlNeu neues Datenelement
     */
    void SortiertEinfügen(int zahlNeu)
    {
        anfang = anfang.SortiertEinfügen(zahlNeu);
    }

}
