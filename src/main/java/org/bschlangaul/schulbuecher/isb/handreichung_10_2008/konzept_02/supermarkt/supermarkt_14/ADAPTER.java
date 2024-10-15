package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_14;

/**
 * Gibt die Botschaften der Oberfläche an den Supermarkt weiter
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ADAPTER
{
    SUPERMARKT s;

    TAKTGEBER t;

    /**
     * Besetzt die Attribute
     */
    ADAPTER(SUPERMARKT s, TAKTGEBER t)
    {
        this.t = t;
        this.s = s;
    }

    /**
     * Öffnet die angegebene Kasse.
     *
     * @param nr Nummer der zu ffnenden Kasse.
     */
    void KasseOeffnen(int nr)
    {
        s.KasseOeffnen(nr);
    }

    /**
     * Schließt die angegebene Kasse nach Bedienung der Restschlange.
     *
     * @param nr Nummer der zu schlie§enden Kasse.
     */
    void KasseSchliessen(int nr)
    {
        s.KasseSchliessen(nr);
    }

    /**
     * Timer starten
     */
    void Starten()
    {
        t.Starten();
    }

    /**
     * Timer anhalten
     */
    void Anhalten()
    {
        t.Anhalten();
    }

    /**
     * Taktimpulsabtand einstellen
     *
     * @param dauer Impulsabstand in Millisekunden
     */
    void DauerSetzen(int dauer)
    {
        t.DauerSetzen(dauer);
    }

    /**
     * Setzt die mittlere Wartezeit zwischen 2 Kunden
     *
     * @param zeit mittlere Wartezeit
     */
    public void KundenabstandSetzen(int zeit)
    {
        s.KundenabstandSetzen(zeit);
    }
}
