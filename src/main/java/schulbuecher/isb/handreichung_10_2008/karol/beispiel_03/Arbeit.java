package schulbuecher.isb.handreichung_10_2008.karol.beispiel_03;

import schulbuecher.isb.handreichung_10_2008.karol.Karol;
import schulbuecher.isb.handreichung_10_2008.karol.KarolWelt;

/**
 * Löst Aufgabe zu Beispiel 3.
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
        karol = new Karol(2, 4, 'S', welt);
    }

    /**
     * Executes the work the roboter is expected to do
     */
    void Ausfuehren()
    {
        while (!karol.IstWand())
        {
            karol.Schritt();
        }
        karol.LinksDrehen();
        while (!karol.IstWand())
        {
            karol.Schritt();
        }
        karol.LinksDrehen();
    }
}
