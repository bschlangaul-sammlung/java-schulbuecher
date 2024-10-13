package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_00.aufgabe_01.schulverwaltung;

/**
 * Klasse zur Beschreibung für einen Klassenraum
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Klassenraum extends Raum
{
    /**
     * Name der Schulklasse
     */
    private String klasse;

    /**
     * Konstruktor für Objekte der Klasse Klassenraum
     *
     * @param nummerNeu Raumnummer
     * @param anzahlNeu Anzahl der Plätze
     * @param klasseNeu Klasse
     */
    Klassenraum(String nummerNeu, int anzahlNeu, String klasseNeu)
    {
        super(nummerNeu, anzahlNeu);
        this.klasse = klasseNeu;
    }

    /**
     * Legt die Klasse fest, um deren Klassenzimmer es sich beim Raum handelt.
     *
     * @param klasseNeu Klasse
     */
    void KlasseSetzen(String klasseNeu)
    {
        this.klasse = klasseNeu;
    }

    /**
     * Gibt die Klasse zurück
     *
     * @return Bezeichner der Klasse
     */
    String KlasseGeben()
    {
        return this.klasse;
    }

    /**
     * Gibt auf der Konsole Information zum Raum aus.
     */
    @Override
    void InformationAusgeben()
    {
        super.InformationAusgeben();
        System.out.println("Klasse: " + this.klasse);
    }

}
