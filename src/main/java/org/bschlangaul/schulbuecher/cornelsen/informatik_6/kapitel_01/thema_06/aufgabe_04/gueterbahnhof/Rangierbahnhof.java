package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_04.gueterbahnhof;

import java.util.ArrayList;

/**
 * Verwaltung des Rangierbahnhofs
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Rangierbahnhof
{
    /** Feld der Abstellgleise */
    private ArrayList<Abstellgleis> gleise;

    /**
     * Erzeugt die drei Abstellgleise
     */
    Rangierbahnhof()
    {
        gleise = new ArrayList<Abstellgleis>();
        for (int i = 0; i < 3; i = i + 1)
        {
            gleise.add(new Abstellgleis());
        }
    }

    /**
     * Einfügen eines Waggons auf ein bestimmtes Gleis
     *
     * @param w Waggon
     * @param gleisnummer Nummer von 0 bis 2
     */
    void WaggonEinfügen(Waggon w, int gleisnummer)
    {
        gleise.get(gleisnummer).Einfügen(w);
    }

    /**
     * Entfernen eines Waggons von einem bestimmten Gleis
     *
     * @param gleisnummer Nummer von 0 bis 2
     *
     * @return zuletzt eingefügter Waggon
     */
    Waggon WaggonEntfernen(int gleisnummer)
    {
        return gleise.get(gleisnummer).Entfernen();
    }

    /**
     * Verschieben eines Waggons zwischen zwei Gleisen
     *
     * @param vonGleis Nummer von 0 bis 2
     * @param nachGleis Nummer von 0 bis 2
     */
    void WaggonVerschieben(int vonGleis, int nachGleis)
    {
        gleise.get(nachGleis).Einfügen(gleise.get(vonGleis).Entfernen());
    }
}
