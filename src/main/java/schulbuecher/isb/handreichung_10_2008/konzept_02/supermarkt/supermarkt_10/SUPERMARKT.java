package schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_10;

/**
 * Kontrolle des Supermarkts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SUPERMARKT
{
    KASSE[] kassen;

    int wartezeit;

    /**
     * Legt die Kassen und ihre Warteschlangen an.
     */
    SUPERMARKT()
    {
        kassen = new KASSE[3];
        for (int i = 0; i < kassen.length; i++)
        {
            WARTESCHLANGE schlange = new WARTESCHLANGE();
            schlange.PositionSetzen(375, 75 + i * 100);
            kassen[i] = new KASSE(schlange);
            kassen[i].PositionSetzen(400, 50 + i * 100);
        }
        wartezeit = 0;
    }

    /**
     * Erzeugt einen neuen Kunden und lässt ihn anstellen
     */
    void KundeErzeugen()
    {
        KUNDE k = new KUNDE(7);
        k.Anstellen(kassen);
    }

    /**
     * Empfngt die Impulse des Taktgebers.
     */
    void TaktImpulsAusfuehren()
    {
        for (int i = 0; i < kassen.length; i++)
        {
            kassen[i].TaktImpulsAusfuehren();
        }
        if (wartezeit == 0)
        {
            KundeErzeugen();
            wartezeit = 50;
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
