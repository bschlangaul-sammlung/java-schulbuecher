package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_00.aufgabe_03.bestellsystem;

/**
 * Klasse zur Beschreibung eines Postens
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Posten
{
    /**
     * Name des Artikels
     */
    private String artikel;

    /**
     * Anzahl des Artikels
     */
    private int anzahl;

    /**
     * Konstruktor für Objekte der Klasse Posten
     *
     * @param artikelNeu Artikel
     * @param anzahlNeu Anzahl
     */
    Posten(String artikelNeu, int anzahlNeu)
    {
        artikel = artikelNeu;
        anzahl = anzahlNeu;
    }

    /**
     * Gibt den Namen des bestellten Artikels zurück
     *
     * @return Name des Artikels
     */
    String ArtikelGeben()
    {
        return artikel;
    }

    /**
     * Gibt die Anzahl der Bestellungen des Artikels zurück
     *
     * @return Anzahl der Bestellungen des Artikels
     */
    int AnzahlGeben()
    {
        return anzahl;
    }
}
