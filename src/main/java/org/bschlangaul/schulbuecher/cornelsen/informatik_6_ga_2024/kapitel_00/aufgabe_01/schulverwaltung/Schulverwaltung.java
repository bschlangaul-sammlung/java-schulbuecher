package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_01.schulverwaltung;

import java.util.ArrayList;

/**
 * Klasse zur Verwaltung der Räume
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Schulverwaltung
{
    /**
     * Feld der Räume
     */
    private ArrayList<Raum> räume;

    /**
     * Konstruktor für Objekte der Klasse Schulverwaltung
     */
    Schulverwaltung()
    {
        räume = new ArrayList<Raum>();
    }

    /**
     * Fügt einen Raum hinzu
     *
     * @param r neuer Raum
     */
    void RaumHinzufügen(Raum r)
    {
        räume.add(r);
    }

    void InformationAusgeben()
    {
        for (Raum r : räume)
        {
            r.InformationAusgeben();
        }
    }
}
