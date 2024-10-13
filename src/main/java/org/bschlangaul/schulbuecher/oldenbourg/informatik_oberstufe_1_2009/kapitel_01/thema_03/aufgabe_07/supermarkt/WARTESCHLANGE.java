package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

/**
 * Verwaltet eine Warteschlange
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class WARTESCHLANGE
{
    /** Verwaltung des ersten Kunden in der Warteschlange. */
    private LISTE liste;

    /** Die Nummer der zugehörigen Kasse */
    private int kassennummer;

    /** Die Anzahl der Kunden in der Warteschlange */
    private int kundenanzahl;

    /** Der Zustand der Warteschlange - Anstellen ist möglich oder nicht */
    private boolean anstellenMoeglich;

    /**
     * Konstruktor der WARTESCHLANGE Realisierung mit Datenstruktur Schlange
     */
    WARTESCHLANGE()
    {
        liste = new LISTE();
        kundenanzahl = 0;
        anstellenMoeglich = true;
    }

    /**
     * Reiht einen Kunden auf dem ersten freien Platz der Warteschlange ein.
     *
     * @param kundeNeu einzureihender Kunde
     */
    void Einreihen(KUNDE kundeNeu)
    {
        liste.HintenEinfuegen(kundeNeu);
        kundenanzahl = kundenanzahl + 1;
        KundenNeuPositionieren();
    }

    /**
     * Gibt den ersten Kunden der Warteschlange aus.
     */
    KUNDE ErstenKundenGeben()
    {
        KUNDE k;
        DATENELEMENT d;
        d = liste.AnfangEntfernen();
        k = (KUNDE) d;
        return k;
    }

    /**
     * Die Kunden rücken um einen Platz auf. Die Arbeit dieser Methode
     */
    void Aufruecken()
    {
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
        return liste.ArtikelzahlGeben();
    }

    /**
     * Sorgt für das NeuPositionieren der Elemente in der Liste
     */
    void KundenNeuPositionieren()
    {
        liste.NeuPositionieren(kassennummer);
    }
}
