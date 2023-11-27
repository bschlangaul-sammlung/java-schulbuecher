package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_05.hunderennen_vorlage;

import greenfoot.Actor;

/**
 * Klasse Hund <br>
 * Arbeitsaufträge 1, 2 und 3, Aufgabe 1
 */
public class Hund extends Actor
{
    String rasse;

    int geschwindigkeit;

    char geschlecht;
    // Füge hier neue Attribute ein

    void setzeWerteObererHund() // initialisiert Attribute für den oberen Hund
    {
        rasse = "Husky";
        geschwindigkeit = 40;
        geschlecht = 'm';
    }

    void setzeWerteMittlererHund() // initialisiert Attribute für den mittleren
                                   // Hund
    {
        rasse = "Dackel";
        geschwindigkeit = 25;
        geschlecht = 'm';
    }

    void setzeWerteUntererHund() // initialisiert Attribute für den unteren Hund
    {
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    public void act()
    {
        setRotation(0);
        move(geschwindigkeit);
    }
}
