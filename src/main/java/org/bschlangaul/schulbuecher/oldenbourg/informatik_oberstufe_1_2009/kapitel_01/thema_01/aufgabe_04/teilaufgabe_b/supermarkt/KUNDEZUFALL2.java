package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_b.supermarkt;

/**
 * Verwaltet einen Kunden.
 *
 * @author Klaus van Dijkstran und Barbara Leidorn
 * @version 1.0
 */
import java.util.Random;

class KUNDEZUFALL2 extends KUNDE
{
    private Random zufall;

    /**
     * Konstruktor des Kunden.
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    KUNDEZUFALL2(int artikel)
    {
        super(artikel);
        zufall = new Random();
    }

    /**
     * Setzt den Anstellmechanismus in Gang. Hier ist die Strategie: zufällig
     * die kürzeste Schlange oder die mit den wenigsten Artikeln Vorbedingung:
     * es gibt mindestens eine offene Kasse
     *
     * @param schlangen Warteschlange, an der sich der Kunde anstellt
     */
    void Anstellen(WARTESCHLANGE[] schlangen)
    {
        WARTESCHLANGE beste;
        int i;
        i = 0;
        while (!schlangen[i].IstAnstellenMoeglich())
        {
            i++;
        }
        beste = schlangen[i];
        if (zufall.nextFloat() < 0.5f)
        {
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
        }
        else
        {
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
        }
        beste.Einreihen(this);
    }
}
