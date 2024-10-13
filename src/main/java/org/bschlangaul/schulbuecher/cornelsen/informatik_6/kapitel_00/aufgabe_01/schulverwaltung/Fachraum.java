package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_00.aufgabe_01.schulverwaltung;

/**
 * Klasse zur Beschreibung für einen Fachraum
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Fachraum extends Raum
{
    /** Name des Fachs */
    private String fach;

    /**
     * Konstruktor für Objekte der Klasse Klassenraum
     *
     * @param nummerNeu Raumnummer
     * @param anzahlNeu Anzahl der Plätze
     * @param fachNeu Fach
     */
    Fachraum(String nummerNeu, int anzahlNeu, String fachNeu)
    {
        super(nummerNeu, anzahlNeu);
        this.fach = fachNeu;
    }

    /**
     * Legt das Fach fest
     *
     * @param fachNeu Fach
     */
    void FachSetzen(String fachNeu)
    {
        this.fach = fachNeu;
    }

    /**
     * Gibt das Fach zurück
     *
     * @return Fach
     */
    String FachGeben()
    {
        return this.fach;
    }

    /**
     * Gibt auf der Konsole Information zum Raum aus.
     */
    @Override
    void InformationAusgeben()
    {
        super.InformationAusgeben();
        System.out.println("Fach: " + this.fach);
    }

}
