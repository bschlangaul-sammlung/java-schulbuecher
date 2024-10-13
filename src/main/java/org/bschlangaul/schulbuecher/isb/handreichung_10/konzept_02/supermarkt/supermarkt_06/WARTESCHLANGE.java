package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_06;

/**
 * Write a description of class WARTESCHLANGE here.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class WARTESCHLANGE
{
    KUNDE kunde1;

    KUNDE kunde2;

    int x;

    int y;

    /**
     * Legt eine leere Warteschlange an.
     */
    WARTESCHLANGE()
    {
        kunde1 = null;
        kunde2 = null;
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
        return kunde1 != null;
    }

    /**
     * Liefert den ersten Kunden und zeichnet die Schlange neu.
     *
     * @return erster Kunde oder null
     */
    KUNDE KundeUebergeben()
    {
        KUNDE res;
        res = kunde1;
        kunde1 = kunde2;
        kunde2 = null;
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
        if (kunde1 == null)
        {
            kunde1 = kunde;
        }
        else if (kunde2 == null)
        {
            kunde2 = kunde;
        }
        SchlangeAnordnen();
    }

    /**
     * Zeichnet die Schlange neu.
     */
    void SchlangeAnordnen()
    {
        if (kunde1 != null)
        {
            kunde1.PositionSetzen(x, y);
        }
        if (kunde2 != null)
        {
            kunde2.PositionSetzen(x - 50, y);
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
