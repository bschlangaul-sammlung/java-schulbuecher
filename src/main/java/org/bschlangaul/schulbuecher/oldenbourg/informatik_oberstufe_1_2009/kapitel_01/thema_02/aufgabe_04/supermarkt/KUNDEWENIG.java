package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.supermarkt;

/**
 * Verwaltet einen Kunden.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class KUNDEWENIG extends KUNDE
{
    /**
     * Konstruktor des Kunden.
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    public KUNDEWENIG(int artikel)
    {
        super(artikel);
    }

    /**
     * Setzt den Anstellmechanismus in Gang. Hier ist die Strategie: Schlange
     * mit der geringsten Gesamtanzahl der Artikel Vorbedingung: es gibt
     * mindestens eine offene Kasse
     *
     * @param schlangen Warteschlange, an der sich der Kunde anstellt
     */
    public void Anstellen(WARTESCHLANGE[] schlangen)
    {
        WARTESCHLANGE beste;
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
                if (schlangen[i].ArtikelanzahlGeben() < beste
                        .ArtikelanzahlGeben())
                {
                    beste = schlangen[i];
                }
            }
        }
        beste.Einreihen(this);
    }
}
