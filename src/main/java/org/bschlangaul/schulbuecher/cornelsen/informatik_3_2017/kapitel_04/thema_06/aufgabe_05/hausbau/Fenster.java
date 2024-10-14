package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_06.aufgabe_05.hausbau;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Erzeugt das Rechteck für die Fenster des Hauses.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Fenster extends Rechteck
{
    /**
     * Legt Größe und Farbe fest
     */
    Fenster()
    {
        super();
        GrößeSetzen(30, 30);
        super.FarbeSetzen("gelb");
    }

    /**
     * Legt Position, Größe und Farbe fest
     *
     * @param x x-Position des Fensters
     * @param y y-Position des Fensters
     */
    Fenster(int x, int y)
    {
        super();
        PositionSetzen(x, y);
        GrößeSetzen(30, 30);
        super.FarbeSetzen("gelb");
    }

    /**
     * Sorgt dafür, dass die Farbe nicht verändert werden kann
     */
    @Override
    public void FarbeSetzen(String farbe)
    {
        // nichts
    }

    /**
     * Setzt das Fenster für den Tag gelb
     */
    void TagSetzen()
    {
        super.FarbeSetzen("gelb");
    }

    /**
     * Setzt das Fenster für die Nacht schwarz
     */
    void NachtSetzen()
    {
        super.FarbeSetzen("schwarz");
    }
}
