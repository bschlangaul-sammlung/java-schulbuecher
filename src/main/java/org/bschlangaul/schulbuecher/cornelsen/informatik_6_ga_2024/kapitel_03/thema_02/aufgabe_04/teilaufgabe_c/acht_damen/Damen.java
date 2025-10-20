package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_02.aufgabe_04.teilaufgabe_c.acht_damen;

import java.util.*;

/**
 * Löst das Problem der N Damen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Damen
{
    private ArrayList<ArrayList<Boolean>> schachbrett;

    /**
     * Legt das Schachbrett an
     *
     * @param anzahl die Anzahl der Damen (und damit auch die Größe des
     *     Schachbretts
     */
    Damen(int anzahl)
    {
        schachbrett = new ArrayList<ArrayList<Boolean>>();
        for (int zeile = 0; zeile < anzahl; zeile += 1)
        {
            schachbrett.add(new ArrayList<Boolean>());
            for (int spalte = 0; spalte < anzahl; spalte += 1)
            {
                schachbrett.get(zeile).add(false);
            }
        }
        SchrittAusführen(0);
    }

    /**
     * Testet, ob das angegebene Element des Schachbretts durch eine der bisher
     * aufgestellten Damen bedroht ist.
     *
     * @param zeile Zeile das Feldelements
     * @param spalte Spalte das Feldelements
     */
    boolean IstFeldBedroht(int zeile, int spalte)
    {
        int aktspalte = spalte - 1;
        while (aktspalte >= 0)
        {
            if (schachbrett.get(zeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
        }
        aktspalte = spalte - 1;
        int aktzeile = zeile - 1;
        while ((aktspalte >= 0) && (aktzeile >= 0))
        {
            if (schachbrett.get(aktzeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
            aktzeile -= 1;
        }
        aktspalte = spalte - 1;
        aktzeile = zeile + 1;
        while ((aktspalte >= 0) && (aktzeile < schachbrett.size()))
        {
            if (schachbrett.get(aktzeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
            aktzeile += 1;
        }
        return false;
    }

    /**
     * Gibt die gefundene Lösung aus.
     */
    void LösungAusgeben()
    {
        System.out.println("Lösung:");
        for (int spalte = 0; spalte < schachbrett.size(); spalte += 1)
        {
            for (int zeile = 0; zeile < schachbrett.size(); zeile += 1)
            {
                if (schachbrett.get(zeile).get(spalte))
                {
                    System.out.print(" " + zeile);
                }
            }
        }
        System.out.println();
    }

    /**
     * Macht einen Rekursionsschritt auf dem Weg zur Lösung
     *
     * @param spalte die Spalte, für die eine Position der Dame gesucht wird.
     */
    void SchrittAusführen(int spalte)
    {
        for (int zeile = 0; zeile < schachbrett.size(); zeile += 1)
        {
            if (!IstFeldBedroht(zeile, spalte))
            {
                schachbrett.get(zeile).set(spalte, true);
                if (spalte == schachbrett.size() - 1)
                {
                    LösungAusgeben();
                }
                else
                {
                    SchrittAusführen(spalte + 1);
                }
                schachbrett.get(zeile).set(spalte, false);
            }
        }
    }

    public static void main(String[] args)
    {
        new Damen(5);
    }
}
