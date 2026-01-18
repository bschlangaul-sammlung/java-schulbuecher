package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

import schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared.TaktGeber;

/**
 * Gibt die Botschaften der Oberfläche an den Supermarkt weiter
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class ADAPTER
{
    SUPERMARKT s;

    TaktGeber t;

    /**
     * Setzt die Empfänger der Botschaften
     *
     * @param s der zu bedienende Supermarkt
     * @param t der zu bedienende Taktgeber
     */
    ADAPTER(SUPERMARKT s, TaktGeber t)
    {
        this.s = s;
        this.t = t;
    }

    /**
     * öffnet die angegebene Kasse.
     *
     * @param nr Nummer der zu öffnenden Kasse.
     */
    void KasseOeffnen(int nr)
    {
        s.KasseOeffnen(nr);
    }

    /**
     * Schließt die angegebene Kasse nach Bedienung der Restschlange.
     *
     * @param nr Nummer der zu schließenden Kasse.
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
     * Ablaufgeschwindigkeit einstellen
     *
     * @param faktor: 1 entspricht 1000ms, 100 entspricht 10ms
     */
    void TaktdauerSetzen(int faktor)
    {
        t.TaktdauerSetzen(faktor);
    }

    /**
     * Setzt die mittlere Wartezeit zwischen 2 Kunden
     *
     * @param zeit mittlere Wartezeit
     */
    void KundenabstandSetzen(int zeit)
    {
        s.KundenabstandSetzen(zeit);
    }
}
