package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_11.sierpinski_dreieck;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Dreieck;

/**
 * Erzeugt das Sierpinski-Dreieck.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SierpinskiDreieck
{

    /**
     * Legt das Grunddreieck an und stößt die Rekursion an
     *
     * @param tiefe Rekursionstiefe
     */
    SierpinskiDreieck(int tiefe)
    {
        Dreieck basis = new Dreieck();
        basis.FarbeSetzen("weiß");
        basis.PositionSetzen(400, 10);
        basis.GrößeSetzen(600, 520);
        SchrittAusführen(400, 10, 600, 520, tiefe);
    }

    /**
     * Ermittelt den Rekursionsschritt
     *
     * @x x-Position der Dreiecksspitze
     *
     * @y y-Position der Dreiecksspitze
     *
     * @breite die Breite des Umgebungsdreiecks
     *
     * @höhe die Höhe des Umgebungsdreiecks
     *
     * @tiefe restliche Rekursionstiefe
     */
    void SchrittAusführen(int x, int y, int breite, int höhe, int tiefe)
    {
        if (tiefe > 0)
        {
            SchrittAusführen(x, y, breite / 2, höhe / 2, tiefe - 1);
            SchrittAusführen(x - breite / 4, y + höhe / 2, breite / 2, höhe / 2,
                    tiefe - 1);
            SchrittAusführen(x + breite / 4, y + höhe / 2, breite / 2, höhe / 2,
                    tiefe - 1);

        }
        else
        {
            Dreieck basis = new Dreieck();
            basis.FarbeSetzen("schwarz");
            basis.PositionSetzen(x, y);
            basis.GrößeSetzen(breite, höhe);
        }
    }

    public static void main(String[] args)
    {
        new SierpinskiDreieck(5);
    }
}
