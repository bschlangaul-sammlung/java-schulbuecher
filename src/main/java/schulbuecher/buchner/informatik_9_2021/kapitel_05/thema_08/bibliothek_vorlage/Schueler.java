package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek_vorlage;

import greenfoot.Actor;

public class Schueler extends Actor
{
    char geschlecht;

    int alter;

    Schueler(int alter)
    {
        this.alter = alter;
        // wählt zufällig ein Geschlecht aus
        initialisiereGeschlecht();
        // zeigt ein Bild an, dessen Größe an das Alter angepasst ist
        aktualisiereBild();
    }

    /**
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
