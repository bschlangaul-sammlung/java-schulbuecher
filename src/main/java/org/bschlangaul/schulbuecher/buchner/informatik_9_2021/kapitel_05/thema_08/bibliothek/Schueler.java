package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek;

import greenfoot.Actor;

/**
 * Klasse Schueler <br>
 * Kap. 5.6, Arbeitsaufträge 1 und 2
 */
public class Schueler extends Actor
{
    char geschlecht;

    int alter;

    Schueler(int startAlter)
    {
        alter = startAlter;
        initialisiereGeschlecht(); // wählt zufällig ein Geschlecht aus
        aktualisiereBild(); // zeigt ein Bild an, dessen Größe an das Alter
                            // angepasst ist
    }

    // A1
    void setzeAlter(int neuesAlter)
    {
        alter = neuesAlter;
        aktualisiereBild();
    }

    int gibAlter()
    {
        return alter;
    }

    /*
     * Der Programmtext ab hier Klasse braucht für die Bearbeitung der
     * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
     */
    void aktualisiereBild()
    {
        setImage(BildHilfe.erstelleSchuelerBild(geschlecht, alter));
    }

    void initialisiereGeschlecht()
    {
        double rnd = Math.random();
        // 48.4% männliche und 51.6% weibliche Bevölkerung in DE
        if (rnd < 0.484)
        {
            geschlecht = 'm';
        }
        else
        {
            geschlecht = 'w';
        }
    }
}
