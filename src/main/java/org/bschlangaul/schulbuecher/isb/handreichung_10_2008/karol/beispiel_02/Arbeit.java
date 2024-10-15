package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.karol.beispiel_02;

import org.bschlangaul.schulbuecher.isb.handreichung_10_2008.karol.Karol;
import org.bschlangaul.schulbuecher.isb.handreichung_10_2008.karol.KarolWelt;

/**
 * Löst Aufgabe zu Beispiel 2.
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
        welt = new KarolWelt(5, 8, 4);
        karol = new Karol(welt);
    }

    /**
     * Executes the work the roboter is expected to do
     */
    void Ausfuehren()
    {
        karol.Hinlegen();
        karol.Schritt();
        karol.Schritt();
        karol.MarkeSetzen();
        karol.Schritt();
        karol.Hinlegen();
        karol.Schritt();
        karol.Schritt();
        karol.MarkeSetzen();
        karol.Schritt();
        karol.Hinlegen();
        karol.Schritt();
    }
}
