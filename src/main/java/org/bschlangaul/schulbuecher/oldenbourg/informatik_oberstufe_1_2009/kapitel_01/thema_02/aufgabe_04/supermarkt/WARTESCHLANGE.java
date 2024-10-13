package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.supermarkt;

/**
 * Verwaltet eine Warteschlange
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
public class WARTESCHLANGE
{
    /** Verwaltung des ersten Kunden in der Warteschlange. */
    private SCHLANGE schlange;

    /** Die Nummer der zugehörigen Kasse */
    private int kassennummer;

    /** Die Anzahl der Kunden in der Warteschlange */
    private int kundenanzahl;

    /** Der Zustand der Warteschlange - Anstellen ist möglich oder nicht */
    private boolean anstellenMoeglich;

    /**
     * Konstruktor der WARTESCHLANGE Realisierung mit Datenstruktur Schlange
     */
    public WARTESCHLANGE()
    {
        schlange = new SCHLANGE();
        kundenanzahl = 0;
        anstellenMoeglich = true;
    }

    /**
     * Reiht einen Kunden auf dem ersten freien Platz der Warteschlange ein.
     *
     * @param kundeNeu einzureihender Kunde
     */
    public void Einreihen(KUNDE kundeNeu)
    {
        schlange.Einfuegen(kundeNeu);
        kundenanzahl = kundenanzahl + 1;
        KundenNeuPositionieren();
    }

    /**
     * Gibt den ersten Kunden der Warteschlange aus.
     */
    public KUNDE ErstenKundenGeben()
    {
        KUNDE k;
        DATENELEMENT d;
        d = schlange.Entfernen();
        k = (KUNDE) d;
        return k;
    }

    /**
     * Die Kunden rücken um einen Platz auf. Die Arbeit dieser Methode
     */
    public void Aufruecken()
    {
        KundenNeuPositionieren();
    }

    /**
     * Speicherung der Kassennummer in der zugehörigen Variable.
     *
     * @param kassennummerNeu die neue Nummer der Kasse
     */
    public void KassennummerSetzen(int kassennummerNeu)
    {
        kassennummer = kassennummerNeu;
    }

    /**
     * Ausgabe der Kundenanzahl
     */
    public int KundenanzahlGeben()
    {
        return kundenanzahl;
    }

    /**
     * Spiegelt den Zustand der Kasse auf die Warteschlange.
     *
     * @param a neuer Zustand
     */
    public void AnstellenMoeglichSetzen(boolean a)
    {
        anstellenMoeglich = a;
    }

    /**
     * Meldet den Zustand der Warteschlange.
     *
     * @return Zustand der Warteschlange
     */
    public boolean IstAnstellenMoeglich()
    {
        return anstellenMoeglich;
    }

    /**
     * Meldet die Gesamtzahl der Artikel in den Warenkörben aller Kunden
     */
    public int ArtikelanzahlGeben()
    {
        KNOTEN k;
        k = schlange.AnfangGeben();
        int artikelzahl = 0;
        while (!(k == null))
        {
            DATENELEMENT d;
            d = k.DatenelementGeben();
            KUNDE ku;
            ku = (KUNDE) d;
            artikelzahl = artikelzahl + ku.ArtikelzahlGeben();
            k = k.NachfolgerGeben();
        }
        return artikelzahl;
    }

    /**
     * Methode zum Neupositionieren der Kunden in der Warteschlange
     */
    public void KundenNeuPositionieren()
    {
        KNOTEN k;
        k = schlange.AnfangGeben();
        int i = 0;
        while (!(k == null))
        {
            DATENELEMENT d;
            d = k.DatenelementGeben();
            KUNDE ku;
            ku = (KUNDE) d;
            ku.NeuPositionieren(kassennummer, i);
            i = i + 1;
            k = k.NachfolgerGeben();
        }
    }
}
