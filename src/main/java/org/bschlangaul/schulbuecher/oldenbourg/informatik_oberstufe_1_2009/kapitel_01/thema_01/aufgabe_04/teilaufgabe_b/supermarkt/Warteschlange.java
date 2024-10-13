package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_b.supermarkt;

/**
 * Verwaltet eine Warteschlange
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class Warteschlange
{
    /**
     * Verwaltung des ersten Kunden in der Warteschlange.
     */
    private Kunde anfang;

    /**
     * Verwaltung des letzten Kunden in der Warteschlange.
     */
    private Kunde ende;

    /**
     * Die Nummer der zugehörigen Kasse
     */
    private int kassennummer;

    /**
     * Die Anzahl der Kunden in der Warteschlange
     */
    private int kundenanzahl;

    /**
     * Der Zustand der Warteschlange - Anstellen ist möglich oder nicht
     */
    private boolean anstellenMoeglich;

    /**
     * Konstruktor der WARTESCHLANGE Realisierung mit Datenstruktur Schlange
     */
    Warteschlange()
    {
        anfang = null;
        ende = null;
        kundenanzahl = 0;
        anstellenMoeglich = true;
    }

    /**
     * Reiht einen Kunden auf dem ersten freien Platz der Warteschlange ein.
     *
     * @param kundeNeu einzureihender Kunde
     */
    void Einreihen(Kunde kundeNeu)
    {
        if (ende != null)
        {
            ende.NachfolgerSetzen(kundeNeu);
        }
        else
        {
            anfang = kundeNeu;
        }
        ende = kundeNeu;
        kundenanzahl = kundenanzahl + 1;
        KundenNeuPositionieren();
    }

    /**
     * Gibt den ersten Kunden der Warteschlange aus.
     */
    Kunde ErstenKundenGeben()
    {
        return anfang;
    }

    /**
     * Die Kunden rücken um einen Platz auf. Die Arbeit dieser Methode
     */
    void Aufruecken()
    {
        if (anfang != null)
        {
            anfang = anfang.NachfolgerGeben();
            if (anfang == null)
            {
                ende = null;
            }
        }
        KundenNeuPositionieren();
    }

    /**
     * Speicherung der Kassennummer in der zugehörigen Variable.
     *
     * @param kassennummerNeu die neue Nummer der Kasse
     */
    void KassennummerSetzen(int kassennummerNeu)
    {
        kassennummer = kassennummerNeu;
    }

    /**
     * Aufruf der Methode der Kunden zum Neudarstellen.
     */
    void KundenNeuPositionieren()
    {
        Kunde k;
        k = anfang;
        int i;
        i = 0;
        while (k != null)
        {
            k.NeuPositionieren(kassennummer, i + 1);
            i = i + 1;
            k = k.NachfolgerGeben();
        }
    }

    /**
     * Ausgabe der Kundenanzahl
     */
    int KundenanzahlGeben()
    {
        return kundenanzahl;
    }

    /**
     * Spiegelt den Zustand der Kasse auf die Warteschlange.
     *
     * @param a neuer Zustand
     */
    void AnstellenMoeglichSetzen(boolean a)
    {
        anstellenMoeglich = a;
    }

    /**
     * Meldet den Zustand der Warteschlange.
     *
     * @return Zustand der Warteschlange
     */
    boolean IstAnstellenMoeglich()
    {
        return anstellenMoeglich;
    }

    /**
     * Meldet die Gesamtzahl der Artikel in den Warenkörben aller Kunden
     */
    int ArtikelanzahlGeben()
    {
        int anzahl;
        anzahl = 0;
        Kunde k;
        k = anfang;
        while (k != null)
        {
            anzahl = anzahl + k.ArtikelzahlGeben();
        }
        return anzahl;
    }
}
