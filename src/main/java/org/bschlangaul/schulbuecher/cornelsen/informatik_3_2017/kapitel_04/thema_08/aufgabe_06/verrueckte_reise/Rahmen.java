package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_06.verrueckte_reise;

import java.util.Random;

/**
 * Baut das Szenarium auf und steuert den Taktgeber
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rahmen extends Ereignisbehandlung
{
    /**
     * Zufallsgenerator.
     */
    Random zufall;

    /**
     * Erzeugt die Objekte und startet den Ablauf.
     */
    Rahmen()
    {
        super();
        zufall = new Random();
        new Rand();
        HindernisseAufbauen();
        new SpielFigur(zufall.nextInt(360));
        TaktdauerSetzen(100);
        Starten();
    }

    /**
     * Erzeugt die Hindernisse.
     */
    void HindernisseAufbauen()
    {
        int x;
        int y;
        int breite;
        int höhe;
        int radius;
        String farbe = "";
        for (int nummer = 1; nummer <= 30; nummer += 1)
        {
            switch (zufall.nextInt(4))
            {
            case 0:
                farbe = "rot";
                break;

            case 1:
                farbe = "grün";
                break;

            case 2:
                farbe = "blau";
                break;

            case 3:
                farbe = "gelb";
                break;
            }
            switch (zufall.nextInt(3))
            {
            case 0:
                breite = zufall.nextInt(40) + 10;
                höhe = zufall.nextInt(40) + 10;
                x = zufall.nextInt(760 - breite) + 20;
                y = zufall.nextInt(460 - höhe) + 20;
                new RechteckBesser(x, y, breite, höhe, farbe);
                break;

            case 1:
                radius = zufall.nextInt(20) + 5;
                x = zufall.nextInt(760 - radius * 2) + 20 + radius;
                y = zufall.nextInt(460 - radius * 2) + 20 + radius;
                new KreisBesser(x, y, radius, farbe);
                break;

            case 2:
                breite = zufall.nextInt(40) + 10;
                höhe = zufall.nextInt(40) + 10;
                x = zufall.nextInt(760 - breite) + 20 + breite / 2;
                y = zufall.nextInt(460 - höhe) + 20;
                new DreieckBesser(x, y, breite, höhe, farbe);
                break;
            }
        }
    }

    /**
     * Dummy zur Vermeidung der Ausgabe
     */
    @Override
    void TaktImpulsAusführen()
    {
    }

    /**
     * Dummy zur Vermeidung der Ausgabe
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
    }

    /**
     * Dummy zur Vermeidung der Ausgabe
     */
    @Override
    void TasteGedrückt(char taste)
    {
    }
}
