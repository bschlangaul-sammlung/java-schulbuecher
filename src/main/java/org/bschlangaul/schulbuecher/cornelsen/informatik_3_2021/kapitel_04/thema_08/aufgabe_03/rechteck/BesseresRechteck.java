package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_03.rechteck;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Rechteck mit mehr Funktionen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class BesseresRechteck extends Rechteck
{
    /**
     * Meldet die Breite des Rechteck zurück
     *
     * @return Breite
     */
    int BreiteGeben()
    {
        return breite;
    }

    /**
     * Meldet die Höhe des Rechteck zurück
     *
     * @return Höhe
     */
    int HöheGeben()
    {
        return höhe;
    }

    /**
     * Meldet den Flächeninhalt des Rechteck zurück
     *
     * @return Flächeninhalt
     */
    int FlächeninhaltGeben()
    {
        return HöheGeben() * BreiteGeben();
    }

    /**
     * Setzt die Breite des Rechtecks unter Beibehaltung der Höhe
     *
     * @param breiteNeu die neue Breite
     */
    void BreiteSetzen(int breiteNeu)
    {
        GrößeSetzen(breiteNeu, HöheGeben());
    }

    /**
     * Meldet zurück, ob das Rechteck ein Quadrat ist
     *
     * @return wahr, wenn das Rechteck ein Quadrat ist
     */
    boolean IstQuadratGeben()
    {
        return HöheGeben() == BreiteGeben();
    }
}
