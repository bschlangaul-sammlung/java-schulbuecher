package schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_11;

/**
 * Write a description of class WARTESCHLANGE here.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class WARTESCHLANGE
{
    KUNDE[] kunden;

    int x;

    int y;

    /**
     * Legt eine leere Warteschlange an.
     */
    WARTESCHLANGE()
    {
        kunden = new KUNDE[30];
        for (int i = 0; i < kunden.length; i++)
        {
            kunden[i] = null;
        }
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
        return kunden[0] != null;
    }

    /**
     * Liefert den ersten Kunden und zeichnet die Schlange neu.
     *
     * @return erster Kunde oder null
     */
    KUNDE KundeUebergeben()
    {
        KUNDE res;
        res = kunden[0];
        for (int i = 0; i < kunden.length - 1; i++)
        {
            kunden[i] = kunden[i + 1];
        }
        kunden[kunden.length - 1] = null;
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
        int i;
        if (kunden[kunden.length - 1] == null)
        {
            i = 0;
            while (kunden[i] != null)
            {
                i = i + 1;
            }
            kunden[i] = kunde;
        }
        SchlangeAnordnen();
    }

    /**
     * Zeichnet die Schlange neu.
     */
    void SchlangeAnordnen()
    {
        for (int i = 0; i < kunden.length; i++)
        {
            KUNDE k = kunden[i];
            if (k != null)
            {
                k.PositionSetzen(x - i * 50, y);
            }
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

    /**
     * Meldet die Länge der Warteschlange
     *
     * @return Anzahl der Kunden in der Warteschlange
     */
    int LaengeHolen()
    {
        int anz;
        anz = 0;
        for (int i = 0; i < kunden.length; i++)
        {
            if (kunden[i] != null)
            {
                anz = anz + 1;
            }
        }
        return anz;
    }
}
