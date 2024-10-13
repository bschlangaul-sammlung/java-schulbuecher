package org.bschlangaul.schulbuecher.isb.handreichung_10.karol.beispiel_04;

import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.Karol;
import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.KarolWelt;

/**
 * Löst Aufgabe zu Beispiel 4.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    KarolWelt welt;

    Karol karol;

    /**
     * Generates the world and places the roboter in its appropriate place.
     */
    Arbeit()
    {
        welt = new KarolWelt("welt_4.kdw");
        karol = new Karol(2, 4, 'S', welt);
    }

    /**
     * Executes the work the roboter is expected to do
     */
    void Ausfuehren()
    {
        if (karol.IstZiegel())
        {
            karol.Aufheben();
            karol.Schritt();
        }
        else
        {
            karol.Schritt();
            if (karol.IstMarke())
            {
                karol.MarkeLoeschen();
                karol.LinksDrehen();
                karol.LinksDrehen();
                karol.Schritt();
                karol.LinksDrehen();
                karol.LinksDrehen();
                karol.Hinlegen();
                karol.Schritt();
            }
            else
            {
                karol.MarkeSetzen();
            }
        }
    }
}
