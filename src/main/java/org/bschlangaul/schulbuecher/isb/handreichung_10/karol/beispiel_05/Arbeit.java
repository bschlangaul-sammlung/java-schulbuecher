package org.bschlangaul.schulbuecher.isb.handreichung_10.karol.beispiel_05;

import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.Karol;
import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.KarolWelt;

/**
 * Löst Aufgabe zu Beispiel 5.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    KarolWelt welt;

    Karol[] roboter;

    /**
     * Generates the world and places the roboter in its appropriate place.
     */
    Arbeit()
    {
        welt = new KarolWelt("Welt_5.kdw");
        roboter = new Karol[5];
        for (int spalte = 0; spalte < 5; spalte++)
        {
            roboter[spalte] = new Karol(spalte + 1, 1, 'S', welt);
        }
    }

    /**
     * Executes the work the roboter is expected to do
     */
    void Ausfuehren()
    {
        for (int zeile = 0; zeile < 8; zeile++)
        {
            for (int spalte = 0; spalte < 5; spalte++)
            {
                if (roboter[spalte].IstMarke())
                {
                    roboter[spalte].MarkeLoeschen();
                }
                else
                {
                    roboter[spalte].MarkeSetzen();
                }
                if (zeile == 7)
                {
                    roboter[spalte].LinksDrehen();
                    roboter[spalte].LinksDrehen();
                }
                else
                {
                    roboter[spalte].Schritt();
                }
            }
        }
        for (int spalte = 0; spalte < 5; spalte++)
        {
            while (!roboter[spalte].IstWand())
            {
                roboter[spalte].Schritt();
            }
            roboter[spalte].LinksDrehen();
            roboter[spalte].LinksDrehen();
        }
    }
}
