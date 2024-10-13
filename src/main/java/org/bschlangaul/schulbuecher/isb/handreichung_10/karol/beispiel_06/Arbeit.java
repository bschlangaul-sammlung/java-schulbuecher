package org.bschlangaul.schulbuecher.isb.handreichung_10.karol.beispiel_06;

import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.KarolWelt;

/**
 * Löst Aufgabe zu Beispiel 6.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    KarolWelt welt;

    Karol2[] roboter;

    /**
     * Generates the world and places the roboter in its appropriate place.
     */
    Arbeit()
    {
        welt = new KarolWelt(5, 8, 4);
        roboter = new Karol2[5];
        for (int spalte = 0; spalte < 5; spalte++)
        {
            roboter[spalte] = new Karol2(spalte + 1, 1, 'S', welt);
        }
        welt.ZiegelVerstreuen(10, 1);
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
                if (zeile == 7)
                {
                    roboter[spalte].Umdrehen();
                }
                else
                {
                    if (zeile == 1)
                    {
                        roboter[spalte].Umdrehen();
                        if (roboter[spalte].IstZiegel())
                        {
                            roboter[spalte].Aufheben();
                            roboter[spalte].MarkeVorSichSetzen();
                        }
                        roboter[spalte].Umdrehen();
                    }
                    if (roboter[spalte].IstZiegel())
                    {
                        roboter[spalte].Aufheben();
                        roboter[spalte].MarkeVorSichSetzen();
                    }
                    roboter[spalte].Schritt();
                }
            }
        }
    }
}
