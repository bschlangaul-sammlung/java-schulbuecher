package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_13;

import java.util.Random;

/**
 * Kontrolle des Supermarkts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SUPERMARKT implements TAKTKLIENT
{
    private KASSE[] kassen;

    private int wartezeit;

    private Random zufall;

    /**
     * Legt die Kassen und ihre Warteschlangen an.
     */
    SUPERMARKT(TAKTGEBER t)
    {
        kassen = new KASSE[3];
        for (int i = 0; i < kassen.length; i++)
        {
            WARTESCHLANGE schlange = new WARTESCHLANGE();
            schlange.PositionSetzen(375, 75 + i * 100);
            kassen[i] = new KASSE(schlange, t);
            kassen[i].PositionSetzen(400, 50 + i * 100);
        }
        wartezeit = 0;
        zufall = new Random(0);
        t.Registrieren(this);
    }

    /**
     * Erzeugt einen neuen Kunden und lässt ihn anstellen
     */
    void KundeErzeugen()
    {
        KUNDE k;
        int artikel;
        k = null;
        artikel = 3 + zufall.nextInt(8);
        switch (zufall.nextInt(4))
        {
        case 0:
            k = new KUNDEWENIG(artikel);
            break;

        case 1:
            k = new KUNDEKURZ(artikel);
            break;

        case 2:
            k = new KUNDEZUFALL(artikel);
            break;

        case 3:
            k = new KUNDEKURZODERWENIG(artikel);
            break;
        }
        k.Anstellen(kassen);
    }

    /**
     * Empfngt die Impulse des Taktgebers.
     */
    public void TaktImpulsAusfuehren()
    {
        if (wartezeit == 0)
        {
            KundeErzeugen();
            wartezeit = 25 + zufall.nextInt(50);
        }
        else
        {
            wartezeit = wartezeit - 1;
        }
    }

    /**
     * Öffnet die angegebene Kasse.
     *
     * @param nr Nummer der zu ffnenden Kasse.
     */
    void KasseOeffnen(int nr)
    {
        if ((nr >= 0) && (nr < kassen.length))
        {
            kassen[nr].OffenSetzen();
        }
    }

    /**
     * Schließt die angegebene Kasse nach Bedienung der Restschlange.
     *
     * @param nr Nummer der zu schlie§enden Kasse.
     */
    void KasseSchliessen(int nr)
    {
        if ((nr >= 0) && (nr < kassen.length) && (kassen[nr].IstOffen()))
        {
            kassen[nr].SchliessendSetzen();
        }
    }
}
