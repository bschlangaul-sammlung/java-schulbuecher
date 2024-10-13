package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

/**
 * Verwaltet einen Kunden.
 *
 * @author Klaus Reinold und Barbara Leidorn
 * @version 1.0
 */
import java.util.Random;

class KUNDEZUFALL extends KUNDE
{
    private Random zufall;

    /**
     * Konstruktor des Kunden.
     *
     * @param artikel Anzahl der Artikel im Warenkorb
     */
    KUNDEZUFALL(int artikel)
    {
        super(artikel);
        zufall = new Random();
    }

    /**
     * Setzt den Anstellmechanismus in Gang. Hier ist die Strategie: zufällige
     * Schlange Vorbedingung: es gibt mindestens eine offene Kasse
     *
     * @param schlangen Warteschlange, an der sich der Kunde anstellt
     */
    void Anstellen(WARTESCHLANGE[] schlangen)
    {
        int anzahl, nummer;
        anzahl = 0;
        for (int i = 0; i < schlangen.length; i++)
        {
            if (schlangen[i].IstAnstellenMoeglich())
            {
                anzahl = anzahl + 1;
            }
        }
        nummer = zufall.nextInt(anzahl);
        for (int i = 0; i < schlangen.length; i++)
        {
            if (schlangen[i].IstAnstellenMoeglich())
            {
                if (nummer == 0)
                {
                    schlangen[i].Einreihen(this);
                    return;
                }
                else
                {
                    nummer = nummer - 1;
                }
            }
        }
    }
}