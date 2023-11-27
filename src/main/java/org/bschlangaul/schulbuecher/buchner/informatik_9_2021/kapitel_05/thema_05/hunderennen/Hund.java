package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_05.hunderennen;

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
    boolean haartBeimRennen;

    int gewicht;

    void setzeWerteObererHund() // initialisiert Attribute für den oberen Hund
    {
        rasse = "Husky";
        geschwindigkeit = 40;
        geschlecht = 'm';
        haartBeimRennen = false;
        gewicht = 35;
    }

    void setzeWerteMittlererHund() // initialisiert Attribute für den mittleren
                                   // Hund
    {
        rasse = "Dackel";
        geschwindigkeit = 25;
        geschlecht = 'm';
        haartBeimRennen = false;
        gewicht = 20;
    }

    void setzeWerteUntererHund() // initialisiert Attribute für den unteren Hund
    {
        rasse = "Pudel";
        geschwindigkeit = 48;
        geschlecht = 'w';
        haartBeimRennen = true;
        gewicht = 18;
    }

    public void act() // sorgt für die Bewegung der Hunde
    {
        setRotation(0); // alle Hunde schauen nach rechts
        move(geschwindigkeit); // bewegt einen Hund so schnell nach rechts, wie
                               // geschwindigkeit
                               // angibt
    }
}
