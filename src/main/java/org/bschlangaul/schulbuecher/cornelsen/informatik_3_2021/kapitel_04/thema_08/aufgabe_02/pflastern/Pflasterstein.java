package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_02.pflastern;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Beschreibt einen Pflasterstein.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Pflasterstein extends Rechteck
{
    /**
     * Der Konstruktor sorgt für Größe und Position des Steins
     *
     * @param zeile Zeilennummer ab 0
     * @param spalte Spaltennummer ab 0
     * @param größe die Größe der Pflastersteine
     * @param farbe die Farbe der Pflastersteine
     */
    Pflasterstein(int zeile, int spalte, int größe, String farbe)
    {
        super();
        GrößeSetzen(größe, größe);
        PositionSetzen(spalte * (größe + 2), zeile * (größe + 2));
        FarbeSetzen(farbe);
    }
}
