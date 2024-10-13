package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

/**
 * Kasse des Supermarkts.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class KASSE
{
    /**
     * Das zugehörige Darstellungssymbol für den Kunden.
     */
    private KASSENSYMBOL darstellung;

    /**
     * Referenz auf das gerade anstehende Kundenobjekt.
     */
    private DATENELEMENT kunded;

    private KUNDE kunde;

    /**
     * Die Kassennummer
     */
    private int nummer;

    /**
     * Die zugehörige Warteschlange
     */
    private WARTESCHLANGE wschlange;

    /**
     * Wartezeit bis zum nächsten Kunden
     */
    private int wartezeit;

    /**
     * Variable für den aktuellen Zustand der Kasse
     */
    private String zustand;

    /**
     * Baut die Kasse auf und trägt die zugehörige Warteschlange ein.
     *
     * @param nummer Nummer für diese Kasse
     */
    KASSE(int nummer, WARTESCHLANGE w)
    {
        this.nummer = nummer;
        darstellung = new KASSENSYMBOL();
        darstellung.PositionSetzen(nummer);
        wschlange = w;
        wschlange.KassennummerSetzen(nummer);
        wartezeit = 0;
        zustand = "offen";
    }

    /**
     * Holt einen Kunden von der Warteschlange und lässt die nachfolgenden
     * Kunden Aufrücken.
     */
    private void KundeHolen()
    {
        if (kunde != null)
        {
            kunde.KundensymbolEntfernen();
        }
        kunded = wschlange.ErstenKundenGeben();
        kunde = (KUNDE) kunded;
        if (kunde != null)
        {
            kunde.NeuPositionieren(nummer, -1);
        }
        else
        {
            if (zustand == "schliessend")
            {
                GeschlossenSetzen();
            }
        }
        wschlange.Aufruecken();
    }

    /**
     * Schaltet nach Ablauf der Wartezeit zum nächsten Kunden weiter.
     */
    void TaktImpulsAusfuehren()
    {
        if (wartezeit == 0)
        {
            KundeHolen();
            if (kunde == null)
            {
                wartezeit = 0;
            }
            else
            {
                wartezeit = 70 + kunde.ArtikelzahlGeben() * 10;
            }
        }
        else
        {
            wartezeit = wartezeit - 1;
        }
    }

    /**
     * öffnet die Kasse.
     */
    void OffenSetzen()
    {
        darstellung.FarbeSetzen("gruen");
        zustand = "offen";
        wschlange.AnstellenMoeglichSetzen(true);
    }

    /**
     * Bereitet das Schließen der Kasse vor.
     */
    void SchliessendSetzen()
    {
        darstellung.FarbeSetzen("gelb");
        zustand = "schliessend";
        wschlange.AnstellenMoeglichSetzen(false);
    }

    /**
     * Schließt die Kasse.
     */
    private void GeschlossenSetzen()
    {
        darstellung.FarbeSetzen("rot");
        zustand = "geschlossen";
        wschlange.AnstellenMoeglichSetzen(false);
    }
}
