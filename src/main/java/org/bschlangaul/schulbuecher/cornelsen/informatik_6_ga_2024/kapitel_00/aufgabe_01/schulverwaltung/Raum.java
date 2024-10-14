package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_01.schulverwaltung;

/**
 * Klasse zur Beschreibung eines Raumes
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Raum
{
    /**
     * Raumnummer
     */
    protected String nummer;

    /**
     * Anzahl der Plätze im Raum
     */
    protected int anzahlPlätze;

    /**
     * Konstruktor für Objekte der Klasse Raum
     *
     * @param nummerNeu Raumnummer
     * @param anzahlPlätzeNeu Anzahl der Plätze
     */
    Raum(String nummerNeu, int anzahlPlätzeNeu)
    {
        this.nummer = nummerNeu;
        this.anzahlPlätze = anzahlPlätzeNeu;
    }

    /**
     * Legt die Raumnummer fest
     *
     * @param nummerNeu Raumnummer
     */
    void NummerSetzen(String nummerNeu)
    {
        this.nummer = nummerNeu;
    }

    /**
     * Gibt die Raumnummer zurück
     *
     * @return Raumnummer
     */
    String NummerGeben()
    {
        return this.nummer;
    }

    /**
     * Legt die Anzahl der Plätze fest
     *
     * @param anzahlNeu Anzahl der Plätze
     */
    void AnzahlPlätzeSetzen(int anzahlNeu)
    {
        this.anzahlPlätze = anzahlNeu;
    }

    /**
     * Gibt die Anzahl der Plätze zurück
     *
     * @return Anzahl der Plätze
     */
    int AnzahlPlätzeGeben()
    {
        return this.anzahlPlätze;
    }

    /**
     * Gibt auf der Konsole Information zum Raum aus.
     */
    void InformationAusgeben()
    {
        System.out.println("Raumnummer: " + this.nummer);
        System.out.println("Anzahl an Plätzen: " + this.anzahlPlätze);
    }
}
