package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_04.aufgabe_06.teilaufgabe_e.philosophen;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Gabel zwischen zwei Philosophen
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Gabel
{
    /** gibt an, ob die Gabel aktuell genutzt wird */
    private boolean inBenutzung;

    /** Id der Gabel */
    private int id;

    /** Darstellung der Gabel */
    private Rechteck symbol;

    /**
     * Konstruktor für Objekte der Klasse Gabel
     */
    Gabel(int gabelId)
    {
        inBenutzung = false;
        symbol = new Rechteck();
        symbol.FarbeSetzen("schwarz");
        id = gabelId;
    }

    /**
     * Es wird gewartet, bis die Gabel nicht mehr in Benutzung ist; dann wird
     * sie aufgenommen.
     *
     * @param eigeneFarbe Die Farbe des Philosophen, der die Gabel aufnehmen
     *     möchte; die Gabel wird dann auf diese Farbe gesetzt.
     */
    synchronized void Aufnehmen(String eigeneFarbe)
    {
        while (inBenutzung)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        inBenutzung = true;
        symbol.FarbeSetzen(eigeneFarbe);
    }

    /**
     * Es wird mit kurzen Wartepausen immer wieder versucht, eine Gabel
     * aufzunehmen. Gelingt dies nicht, wird die Methode nach maximal 100
     * Versuchen beendet.
     *
     * @param eigeneFarbe Die Farbe des Philosophen, der die Gabel aufnehmen
     *     möchte; die Gabel wird bei erfolgreicher Aufnahme auf diese Farbe
     *     gesetzt.
     */
    synchronized boolean AufnehmenVersuchen(String eigeneFarbe)
    {
        int n = 0;
        while (n < 100)
        {
            if (!inBenutzung)
            {
                inBenutzung = true;
                symbol.FarbeSetzen(eigeneFarbe);
                return true;
            }
            else
            {
                try
                {
                    wait(10);
                }
                catch (InterruptedException e)
                {
                }
                n = n + 1;
            }
        }
        return false;
    }

    /**
     * Die Gabel wird abgelegt; da sie dann keinen Besitzer mehr hat, wird ihre
     * Farbe auf "schwarz" gesetzt.
     */
    synchronized void Ablegen()
    {
        inBenutzung = false;
        symbol.FarbeSetzen("schwarz");
        notify();
    }

    /**
     * Liefert die Id der Gabel.
     */
    int IdGeben()
    {
        return id;
    }

    /**
     * Liefert das Symbol der Gabel.
     *
     * @return Symbol der Gabel
     */
    Rechteck SymbolGeben()
    {
        return symbol;
    }
}
