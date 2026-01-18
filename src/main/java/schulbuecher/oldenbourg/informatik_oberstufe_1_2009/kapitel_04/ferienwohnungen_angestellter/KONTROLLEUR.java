package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

/**
 * Kontrolleur für die Oberfläche eines Angestellten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KONTROLLEUR implements KONTROLLEURINTERFACE
{
    private OBERFLACHENINTERFACE oberflaeche;

    private LANDINFO[] laender;

    private DATENBANKVERBINDUNG verb;

    private OBJEKTINFO aktObjekt;

    private KUNDENINFO aktKunde;

    private String tabName;

    /**
     * Besetzt die Attribute, insbesondere die Datenbankverbindung
     */
    KONTROLLEUR()
    {
        oberflaeche = null;
        laender = null;
        aktObjekt = null;
        aktKunde = null;
        verb = DATENBANKVERBINDUNG.VerbindungGeben();
    }

    /**
     * Setzt die zu bedienende Oberfläche.
     *
     * @param o Oberfläche
     */
    void OberflaecheSetzen(OBERFLACHENINTERFACE o)
    {
        oberflaeche = o;
        LaenderdatenSetzen();
        ObjektdatenSetzen();
        KundendatenSetzen();
    }

    /**
     * Besetzt die Länderinformation der Oberfläche
     */
    void LaenderdatenSetzen()
    {
        laender = verb.LaenderHolen();
        oberflaeche.LaenderSetzen(laender);
    }

    /**
     * Besetzt die Objektinformation der Oberfläche
     */
    void ObjektdatenSetzen()
    {
        oberflaeche.ObjekteSetzen(verb.AlleObjekteHolen());
    }

    /**
     * Besetzt die Objektinformation der Oberfläche
     */
    void KundendatenSetzen()
    {
        oberflaeche.KundenSetzen(verb.AlleKundenHolen());
    }

    /**
     * Besetzt das Datenblatt für ein Objekt
     *
     * @param nummer der Schlüssel des Objekts
     */
    void ObjektDatenSetzen(int nummer)
    {
        ObjektDatenSetzen(verb.ObjektHolen(nummer));
    }

    /**
     * Besetzt das Datenblatt für ein Objekt
     *
     * @param info Information über das Objekt
     */
    void ObjektDatenSetzen(OBJEKTINFO info)
    {
        LANDINFO land;
        land = null;
        if (info != null)
        {
            for (LANDINFO l : laender)
            {
                if (l.IDGeben() == info.LandNummerGeben())
                {
                    land = l;
                    break;
                }
            }
            oberflaeche.ObjektInfoSetzen(info.NummerGeben(), info.NameGeben(),
                    info.GroesseGeben(), info.ZimmerAnzahlGeben(),
                    info.PersonenAnzahlGeben(), land, info.ArtGeben(),
                    info.PreisGeben(), info.SperreGeben(),
                    info.AusstattungenGeben());
        }
    }

    /**
     * Behandelt die Objektauswahl
     *
     * @param objekt der ausgewählte Objekteintrag
     */
    public void ObjektAuswaehlen(Object objekt)
    {
        aktObjekt = (OBJEKTINFO) objekt;
        ObjektDatenSetzen(aktObjekt);
    }

    /**
     * Behandelt die Auswahl der Dialogseite
     *
     * @param name Name des Tab-Eintrags
     */
    public void TabAuswaehlen(String name)
    {
        tabName = name;
        if (tabName == "")
        {
            if (aktObjekt != null)
            {
                ObjektDatenSetzen(aktObjekt);
            }
        }
    }

    /**
     * Veranlasst das Eintragen eines neuen Landes.
     *
     * @param name Name des neuen Landes
     */
    public void LandEintragen(String name)
    {
        verb.NeuesLandEintragen(name);
        LaenderdatenSetzen();
    }

    /**
     * Veranlasst das Anlegen eines neuen Objekts mit den gegebenen Daten.
     *
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    public void NeuesObjektAnlegen(String name, int groesse, int zimmer,
            int personen, Object land, String art, double preis,
            boolean gesperrt, boolean[] ausstattungen)
    {
        String[] aus = { "Fernseher", "Waschmaschine", "Trockner",
                "Kuehlschrank", "Gefrierschrank", "Swimmingpool" };
        boolean erster;
        String res;
        erster = true;
        res = null;
        for (int i = 0; i < ausstattungen.length; i++)
        {
            if (ausstattungen[i])
            {
                if (erster)
                {
                    erster = false;
                    res = aus[i];
                }
                else
                {
                    res = res + "," + aus[i];
                }
            }
        }
        int nummer = verb.NeuesObjektAnlegen(name, groesse, zimmer, personen,
                ((LANDINFO) land).IDGeben(), art, preis, gesperrt, res);
        ObjektdatenSetzen();
        oberflaeche.ObjektWaehlen(new OBJEKTINFO(nummer, name, groesse, zimmer,
                personen, ((LANDINFO) land).IDGeben(), art, preis, res,
                gesperrt));
    }

    /**
     * Veranlasst das ändern eines Objekts mit den gegebenen Daten.
     *
     * @param nummer Schlüssel des Objekts
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    public void ObjektAendern(int nummer, String name, int groesse, int zimmer,
            int personen, Object land, String art, double preis,
            boolean gesperrt, boolean[] ausstattungen)
    {
        String[] aus = { "Fernseher", "Waschmaschine", "Trockner",
                "Kuehlschrank", "Gefrierschrank", "Swimmingpool" };
        boolean erster;
        String res;
        erster = true;
        res = null;
        for (int i = 0; i < ausstattungen.length; i++)
        {
            if (ausstattungen[i])
            {
                if (erster)
                {
                    erster = false;
                    res = aus[i];
                }
                else
                {
                    res = res + "," + aus[i];
                }
            }
        }
        verb.ObjektAendern(nummer, name, groesse, zimmer, personen,
                ((LANDINFO) land).IDGeben(), art, preis, gesperrt, res);
        ObjektdatenSetzen();
        oberflaeche.ObjektWaehlen(new OBJEKTINFO(nummer, name, groesse, zimmer,
                personen, ((LANDINFO) land).IDGeben(), art, preis, res,
                gesperrt));
    }

    /**
     * Veranlasst das Löschen des angegebenen Objekts.
     *
     * @param nummer Schlüssel des Objekts
     */
    public void ObjektLoeschen(int nummer)
    {
        verb.ObjektLoeschen(nummer);
        ObjektdatenSetzen();
    }

    /**
     * Behandelt die Kundenauswahl
     *
     * @param kunde der ausgewählte Kunde
     */
    public void KundeAuswaehlen(Object kunde)
    {
        aktKunde = (KUNDENINFO) kunde;
        KundenDatenSetzen(aktKunde);
    }

    /**
     * Besetzt das Datenblatt für einen Kunden
     *
     * @param nummer der Schlüssel des Objekts
     */
    void KundenDatenSetzen(int nummer)
    {
        ObjektDatenSetzen(verb.ObjektHolen(nummer));
    }

    /**
     * Besetzt das Datenblatt für einen Kunden
     *
     * @param info Information über den Kunden
     */
    void KundenDatenSetzen(KUNDENINFO info)
    {
        if (info != null)
        {
            oberflaeche.KundenInfoSetzen(info.IDGeben(), info.NameGeben(),
                    info.VornameGeben());
        }
    }

    /**
     * Veranlasst das Anlegen eines neuen Kunden mit den gegebenen Daten.
     *
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    public void NeuenKundenAnlegen(String name, String vorname)
    {
        String benutzername;
        benutzername = verb.BenutzernamenErzeugen(name, vorname);
        verb.NeuenKundenAnlegen(benutzername, name, vorname);
        KundendatenSetzen();
        oberflaeche
                .KundeWaehlen(new KUNDENINFO(benutzername, name, vorname, ""));
    }

    /**
     * Veranlasst das ändern eines Kunden mit den gegebenen Daten.
     *
     * @param benutzername Schlüssel des Kunden
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    public void KundenAendern(String benutzername, String name, String vorname)
    {
        verb.KundenAendern(benutzername, name, vorname);
        KundendatenSetzen();
        oberflaeche
                .KundeWaehlen(new KUNDENINFO(benutzername, name, vorname, ""));
    }

    /**
     * Veranlasst das Löschen des angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     */
    public void KundenLoeschen(String benutzername)
    {
        verb.KundenLoeschen(benutzername);
        KundendatenSetzen();
    }

    /**
     * Veranlasst das Setzen des Passworts für den angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     * @param pass das Passwort des Kunden
     */
    public void PasswortSetzen(String benutzername, String pass)
    {
        verb.PasswortSetzen(benutzername, pass);
        KundendatenSetzen();
    }

    /**
     * Veranlasst das Holen aller Buchungen zum angegebenen Objekt.
     *
     * @param objekt Beschreibung des Objekts
     */
    public void BuchungenFuerObjektHolen(Object objekt)
    {
        oberflaeche.BuchungenSetzen(verb
                .BuchungenFuerObjektHolen(((OBJEKTINFO) objekt).NummerGeben()));
    }

    /**
     * Veranlasst das Holen aller Buchungen des angegebenen Kunden.
     *
     * @param kunde Beschreibung des Kunden
     */
    public void BuchungenFuerKundeHolen(Object kunde)
    {
        oberflaeche.BuchungenSetzen(
                verb.BuchungenFuerKundenHolen(((KUNDENINFO) kunde).IDGeben()));
    }

    /**
     * Veranlasst das Löschen der angegebenen Buchung.
     *
     * @param buchung Beschreibung der Buchung
     */
    public void BuchungLoeschen(Object buchung)
    {
        verb.BuchungLoeschen(((RESERVIERUNGSINFO) buchung).NummerGeben());
        oberflaeche.BuchungenSetzen(new Object[0]);
    }

    /**
     * Veranlasst das Umwandeln einer Reservierung in eine feste Buchung.
     *
     * @param buchung Beschreibung der Buchung
     */
    public void ReservierungBuchen(Object buchung)
    {
        verb.ReservierungBuchen(((RESERVIERUNGSINFO) buchung).NummerGeben());
        oberflaeche.BuchungenSetzen(new Object[0]);
    }

    /**
     * Beendet die Ausführung des Programms
     */
    public void Beenden()
    {
        verb.VerbindungBeenden();
        System.exit(1);
    }
}
