package schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_08;

import java.util.ArrayList;

/**
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class WARTESCHLANGE
{
    ArrayList<KUNDE> kunden;

    int x;

    int y;

    /**
     * Legt eine leere Warteschlange an.
     */
    WARTESCHLANGE()
    {
        kunden = new ArrayList<KUNDE>();
        x = 400;
        y = 50;
    }

    /**
     * Meldet, ob noch Kunden in der Warteschlange stehen
     *
     * @return wahr, wenn es noch mindestens einen Kunden gibt.
     */
    boolean IstKundeVorhanden()
    {
        return !kunden.isEmpty();
    }

    /**
     * Liefert den ersten Kunden und zeichnet die Schlange neu.
     *
     * @return erster Kunde oder null
     */
    KUNDE KundeUebergeben()
    {
        KUNDE res;
        if (kunden.isEmpty())
        {
            res = null;
        }
        else
        {
            res = kunden.get(0);
            kunden.remove(res);
        }
        SchlangeAnordnen();
        return res;
    }

    /**
     * Stellt einen Kunden hinten an (so Platz) und zeichnet die Schlange neu.
     *
     * @param kunde der neue Kunde
     */
    void Anfuegen(KUNDE kunde)
    {
        kunden.add(kunde);
        SchlangeAnordnen();
    }

    /**
     * Zeichnet die Schlange neu.
     */
    void SchlangeAnordnen()
    {
        for (KUNDE k : kunden)
        {
            k.PositionSetzen(x - kunden.indexOf(k) * 50, y);
        }
    }

    /**
     * Setzt die Position der Warteschlange und zeichnet sie neu.
     *
     * @param xNeu x-Position
     * @param yNeu y-Position
     */
    void PositionSetzen(int xNeu, int yNeu)
    {
        x = xNeu;
        y = yNeu;
        SchlangeAnordnen();
    }
}
