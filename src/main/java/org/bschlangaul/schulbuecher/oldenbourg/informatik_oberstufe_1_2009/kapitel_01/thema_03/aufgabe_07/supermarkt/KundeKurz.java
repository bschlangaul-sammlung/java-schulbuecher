package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

/**
 * Verwaltet einen Kunden.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class KundeKurz extends Kunde
{
    /**
     * Konstruktor des Kunden.
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    KundeKurz(int artikel)
    {
        super(artikel);
    }

    /**
     * Setzt den Anstellmechanismus in Gang. Hier ist die Strategie: kürzeste
     * Schlange Vorbedingung: es gibt mindestens eine offene Kasse
     *
     * @param schlangen Warteschlange, an der sich der Kunde anstellt
     */
    void Anstellen(Warteschlange[] schlangen)
    {
        Warteschlange beste;
        int i;
        i = 0;
        while (!schlangen[i].IstAnstellenMoeglich())
        {
            i++;
        }
        beste = schlangen[i];
        for (i = 0; i < schlangen.length; i++)
        {
            if (schlangen[i].IstAnstellenMoeglich())
            {
                if (schlangen[i].KundenanzahlGeben() < beste
                        .KundenanzahlGeben())
                {
                    beste = schlangen[i];
                }
            }
        }
        beste.Einreihen(this);
    }
}
