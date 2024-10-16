package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

import org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.shared.TaktGeber;

/**
 * Gibt die Botschaften der Oberfläche an die Kreuzung weiter
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version 1.0
 */
class ADAPTER
{
    KREUZUNG k;

    TaktGeber t;

    /**
     * Setzt die Empfänger der Botschaften
     *
     * @param k die zu bedienende Kreuzung
     * @param t der zu bedienende Taktgeber
     */
    ADAPTER(KREUZUNG k, TaktGeber t)
    {
        this.k = k;
        this.t = t;
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
     * Setzt die mittlere Wartezeit zwischen 2 Fahrzeugen
     *
     * @param zeit mittlere Wartezeit
     */
    void FahrzeugabstandSetzen(int zeit)
    {
        k.FahrzeugabstandSetzen(zeit);
    }
}
