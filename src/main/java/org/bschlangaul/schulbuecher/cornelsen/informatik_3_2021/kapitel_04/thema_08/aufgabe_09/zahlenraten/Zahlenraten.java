package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_09.zahlenraten;

import java.util.Random;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Kreis;

/**
 * Zahlenraten - Spiel.
 *
 * @author Klasse 10b
 *
 * @version 12.02.2020
 */
class Zahlenraten
{
    /**
     * die zufällige, zu erratende Zahl
     */
    int zufallszahl;

    /**
     * die Anzahl der Versuche
     */
    int anzahlVersuche;

    /**
     * der Zufallsgenerator
     */
    Random zzGenerator;

    /**
     * der Kreis zur Bewertungsanzeige
     */
    Kreis bewertungsKreis;

    /**
     * Der Konstruktor erzeugt die zu erratende Zahl und bereitet die anderen
     * Attribute vor
     */
    Zahlenraten()
    {
        zzGenerator = new Random();
        zufallszahl = zzGenerator.nextInt(100);
        anzahlVersuche = 0;
        bewertungsKreis = new Kreis();
        bewertungsKreis.FarbeSetzen("schwarz");
    }

    /**
     * Lässt einen neue Zahl eingeben und bewertet sie
     *
     * @param neueZahl der neue Versuch
     */
    void RatezahlEingeben(int neueZahl)
    {
        if (zufallszahl == neueZahl)
        {
            System.out.println("richtig!");
            bewertungsKreis.FarbeSetzen("grün");
        }
        else if (zufallszahl > neueZahl)
        {
            System.out.println("zu niedrig!");
            bewertungsKreis.FarbeSetzen("gelb");
        }
        else if (zufallszahl < neueZahl)
        {
            System.out.println("zu hoch!");
            bewertungsKreis.FarbeSetzen("rot");
        }
        anzahlVersuche = anzahlVersuche + 1;
    }

    /**
     * Meldet die Anzahl der Versuche
     *
     * @return Anzahl der Versuche
     */
    int AnzahlVersucheGeben()
    {
        return anzahlVersuche;
    }

    /**
     * Startet ein neues Spiel ,it einer neuen Zufallszahl
     */
    void NeuesSpielStarten()
    {
        anzahlVersuche = 0;
        zufallszahl = zzGenerator.nextInt(100);
        bewertungsKreis.FarbeSetzen("schwarz");
    }
}
