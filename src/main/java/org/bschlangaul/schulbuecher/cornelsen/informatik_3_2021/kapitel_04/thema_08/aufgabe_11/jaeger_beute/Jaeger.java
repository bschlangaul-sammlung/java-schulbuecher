package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_11.jaeger_beute;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Der Verfolger wird durch die Maus gesteuert.
 *
 * @author Albert.Wiedemann
 *
 * @version 1.0
 */
class Jaeger extends Figur
{
    /**
     * Breite des Spielfeldes.
     */
    int breite;

    /**
     * Höhe des Spielfeldes.
     */
    int höhe;

    /**
     * Zähler für dei Berührungen.
     */
    int zähler;

    /**
     * Legt die Anzeigesymbole an und positioniert den Verfolger in der Mitte
     * des Feldes.
     *
     * @param breite Breite des Spielfelds
     * @param höhe Höhe des Spielfelds
     */
    Jaeger(int breite, int höhe)
    {
        this.breite = breite;
        this.höhe = höhe;
        this.zähler = 0;
        PositionSetzen(breite / 2, höhe / 2);
        WinkelSetzen(0);
        FigurteilFestlegenRechteck(-20, -20, 40, 40, "blau");
        FigurteilFestlegenDreieck(-16, -16, +16, 0, -16, +16, "gelb");
    }

    /**
     * Bewegt den Verfolger um 10 Einheiten in der eingestellten Richtung. Wird
     * der Rand erreicht, wird die Bewegung gestoppt.
     */
    @Override
    public void AktionAusführen()
    {
        int xalt = XPositionGeben();
        int yalt = YPositionGeben();
        Gehen(10);
        if ((XPositionGeben() < 0) && (XPositionGeben() < xalt)
                || (XPositionGeben() > breite) && (XPositionGeben() > xalt)
                || (YPositionGeben() < 0) && (YPositionGeben() < yalt)
                || (YPositionGeben() > höhe) && (YPositionGeben() > yalt))
        {
            PositionSetzen(xalt, yalt);
        }
        if (Berührt())
        {
            zähler = zähler + 1;
        }
    }

    /**
     * Die eigentliche Aktionsmethode für einen Mausklick. <br>
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     * @param anzahl Anzahl der aufeinanderfolgenden Mausklicks
     */
    @Override
    public void MausGeklickt(int x, int y, int anzahl)
    {
        int richtung;
        richtung = RichtungGeben(x, y);
        WinkelSetzen(richtung);
    }

    /**
     * Wird bei Mausklick aufgerufen, um die Bewegungsrichtung des Verfolgers zu
     * ermitteln.
     *
     * @param xMaus x-Koordinate der Maus
     * @param yMaus y-Koordinate der Maus
     *
     * @return Richtungswinkel zum Klickpunkt
     */
    int RichtungGeben(int xMaus, int yMaus)
    {
        double dx = xMaus - XPositionGeben();
        double dy = yMaus - YPositionGeben();
        int richtung = 0;
        if (dx == 0)
        {
            if (dy > 0)
            {
                richtung = 270;
            }
            else if (dy < 0)
            {
                richtung = 90;
            }
        }
        else if (dx > 0)
        {
            richtung = -((int) Math
                    .round(Math.atan(dy / dx) * 180.0 / Math.PI));
        }
        else
        {
            richtung = 180
                    - ((int) Math.round(Math.atan(dy / dx) * 180.0 / Math.PI));
        }
        return richtung;
    }
}
