package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_02.pflastern;

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
