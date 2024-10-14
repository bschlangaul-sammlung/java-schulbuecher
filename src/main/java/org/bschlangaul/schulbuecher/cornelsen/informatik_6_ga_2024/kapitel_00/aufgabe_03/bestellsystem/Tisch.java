package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_03.bestellsystem;

import java.util.ArrayList;

/**
 * Klasse zur Verwaltung der Bestellungen eines Tisches
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Tisch
{
    /**
     * Feld der bestellten Posten
     */
    private ArrayList<Posten> bestelltePosten;

    /**
     * Konstruktor für Objekte der Klasse Tisch
     */
    Tisch()
    {
        bestelltePosten = new ArrayList<Posten>();
    }

    /**
     * Bestellen eines Artikels
     *
     * @param artikel Name des Artikes
     * @param anzahl Anzahl der Bestellungen des Artikels
     */
    void Bestellen(String artikel, int anzahl)
    {
        bestelltePosten.add(new Posten(artikel, anzahl));
    }

    /**
     * Gibt die bestellten Posten eines Tisches zurück
     *
     * @return Feld der bestellten Posten
     */
    ArrayList<Posten> BestelltePostenGeben()
    {
        return bestelltePosten;
    }

    /**
     * Löscht alle bestellten Posten
     */
    void BestelltePostenLöschen()
    {
        bestelltePosten.clear();
    }
}
