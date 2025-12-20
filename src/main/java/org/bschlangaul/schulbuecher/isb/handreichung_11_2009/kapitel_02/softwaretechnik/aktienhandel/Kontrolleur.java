package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

import java.util.ArrayList;

/**
 * Zuständig für die Weitergabe der Ereignisse.
 *
 * @version 1.0
 */
class Kontrolleur implements KnotrolleurInterface
{
    private Boerse boerse;

    private KnotenListe konten;

    private Konto konto;

    private Kursanzeige kursAnzeige;

    private DatenbankVerbindung verbindung;

    private OberflaechenInterface oberflaeche;

    /**
     * Besetzt die Attribute
     *
     * @param boerse die Boerse, an der der Handel stattfindet.
     * @param konten das Konto, für das die Geschäfte abgewickelt werden.
     * @param kursAnzeige Fenster für die Anzeige der Kursentwicklung einer
     *     Aktie.
     */
    Kontrolleur(Boerse boerse, KnotenListe konten, Kursanzeige kursAnzeige)
    {
        this.konten = konten;
        this.boerse = boerse;
        this.kursAnzeige = kursAnzeige;
        verbindung = DatenbankVerbindung.VerbindungGeben();
        oberflaeche = null;
        konto = konten.Suchen(1);
    }

    /**
     * Setzt die Oberfläche für die Rückmeldungen
     *
     * @param o Referenz auf die Oberfläche
     */
    void OberflaecheSetzen(OberflaechenInterface o)
    {
        oberflaeche = o;
        oberflaeche.StatuszeileSetzen("");
        oberflaeche.KontostandsanzeigeSetzen(konto.KontoStandGeben());
        oberflaeche.DepotlisteSetzen(DepotlisteAufbauen());
    }

    /**
     * Ermittelt alle Depoteinträge
     *
     * @return Stringfeld mit den Depoteinträgen
     */
    private String[] DepotlisteAufbauen()
    {
        ArrayList<Aktienpaket> liste;
        String[] res;
        int index;
        liste = verbindung.AktienpaketeGeben();
        res = new String[liste.size()];
        index = 0;
        for (Aktienpaket paket : liste)
        {
            res[index] = paket.AnzeigedatenGeben();
            index++;
        }
        return res;
    }

    /**
     * Holt die Nummern aller Konten
     *
     * @return Feld mit den Kontonummern
     */
    public int[] KontennummernGeben()
    {
        return konten.KontonummernGeben();
    }

    /**
     * Setzt des aktuelle Konto anhand der gegebenen Kontonummer
     *
     * @param nummer neue Kontonummer
     */
    public void KontoSetzen(int nummer)
    {
        konto = konten.Suchen(nummer);
        oberflaeche.KontostandsanzeigeSetzen(konto.KontoStandGeben());
    }

    /**
     * Ereignis "Aktien einkaufen"
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl gewünschte Anzahl der Aktie
     */
    public void AktienKaufen(int aktienID, int anzahl)
    {
        if (anzahl > 0)
        {
            boerse.Kaufen(aktienID, anzahl, konto);
            oberflaeche.KontostandsanzeigeSetzen(konto.KontoStandGeben());
            oberflaeche.DepotlisteSetzen(DepotlisteAufbauen());
        }
    }

    /**
     * Ereignis "Aktien verkaufen"
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl gewünschte Anzahl der Aktie
     */
    public void AktienVerkaufen(int aktienID, int anzahl)
    {
        if (anzahl > 0)
        {
            boerse.Verkaufen(aktienID, anzahl, konto);
            oberflaeche.KontostandsanzeigeSetzen(konto.KontoStandGeben());
            oberflaeche.DepotlisteSetzen(DepotlisteAufbauen());
        }
    }

    /**
     * Ereignis "Kursverlauf anzeigen"
     *
     * @param aktienID Schlüssel der Aktie
     */
    public void KursverlaufAnzeigen(int aktienID)
    {
        kursAnzeige.Anzeigen(
                verbindung.KurseHolen(Kursanzeige.kursAnzahl, aktienID),
                verbindung.AktienNameHolen(aktienID));
    }

    /**
     * Ereignis "neue Kurse"
     */
    public void NeueKurswerteBerechnen()
    {
        boerse.NeueKurseBestimmen();
    }

    /**
     * Ereignis "Ende"
     */
    public void Beenden()
    {
        verbindung.Schliessen();
        System.exit(0);
    }

    /**
     * Inhalt für die Aktienliste besorgen
     */
    public String[] AktienNamenGeben()
    {
        return verbindung.AktienNamenHolen();
    }
}
