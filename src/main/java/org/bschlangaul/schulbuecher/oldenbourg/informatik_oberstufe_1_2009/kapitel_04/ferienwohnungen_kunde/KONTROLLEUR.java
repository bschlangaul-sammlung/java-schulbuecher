package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    private DATENBANKVERBINDUNG verb;

    private KUNDENINFO kunde;

    private OBJEKTLISTE alleObjekte;

    private LANDINFO keines;

    private LANDINFO[] laender;

    private SimpleDateFormat ausgabeKonvertierung;

    /**
     * Constructor for objects of class KONTROLLEURANGESTELLTER
     */
    KONTROLLEUR()
    {
        oberflaeche = null;
        kunde = null;
        keines = new LANDINFO(-1, "-- alle --");
        ausgabeKonvertierung = new SimpleDateFormat("dd'.'MMM'.'yyyy");
        verb = DATENBANKVERBINDUNG.VerbindungGeben();
        alleObjekte = new OBJEKTLISTE();
        verb.AlleObjekteHolen(alleObjekte);
        laender = verb.LaenderHolen();
    }

    /**
     * Setzt die zu bedienende Oberfläche.
     *
     * @param o Oberfläche
     */
    void OberflaecheSetzen(OBERFLACHENINTERFACE o)
    {
        oberflaeche = o;
        oberflaeche.LaenderSetzen(laender, keines);
    }

    /**
     * Meldet den Kunden bei der Objektverwaltung an.
     */
    public void Anmelden(String name, String pass)
    {
        kunde = verb.KundeHolen(name);
        if (kunde != null)
        {
            if (pass.equals(kunde.PasswortGeben()))
            {
                oberflaeche.ReservierungslisteSetzen(
                        verb.ReservierungenFuerBenutzerHolen(kunde.IDGeben()));
                oberflaeche
                        .StatusSetzen(OBERFLACHENINTERFACE.Status.auswaehlen);
            }
            else
            {
                kunde = null;
                oberflaeche.StatuszeileSetzen("Falsches Passwort");
            }
        }
        else
        {
            oberflaeche.StatuszeileSetzen("Unbekannter Benutzer");
        }
    }

    /**
     * Sucht alle Objekte mit den angegebenen Daten
     *
     * @param land Land, in dem das Objekt liegt
     * @param art Art des Objekts
     * @param persmin Platz für mindestens persmin Personen
     * @param persmax Platz für maximal persmax Personen
     * @param zimmin minimale Zimmeranzahl
     * @param zimmax maximale Zimmeranzahl
     * @param aus geforderte Ausstattung
     * @param start Beginn des Anzeigezeitraums
     * @param ende Ende des Anzeigezeitraums
     */
    public void ObjekteSuchen(Object land, String art, int persmin, int persmax,
            int zimmin, int zimmax, boolean[] aus, Date start, Date ende)
    {
        OBJEKTLISTE res;
        res = new OBJEKTLISTE();
        if (land == keines)
        {
            land = null;
        }
        if (art == "Alles")
        {
            art = null;
        }
        alleObjekte.ObjekteSuchen(res, (LANDINFO) land, art, persmin, persmax,
                zimmin, zimmax, aus);
        oberflaeche.AuswahllisteSetzen(res.AlsFeldAusgeben());
    }

    /**
     * Meldet den Namen des Landes zur Nummer
     *
     * @param nummer Nummer des Landes
     *
     * @return Name des Landes;
     */
    private String LandSuchen(int nummer)
    {
        for (LANDINFO land : laender)
        {
            if (land.IDGeben() == nummer)
            {
                return land.NameGeben();
            }
        }
        return "";
    }

    /**
     * Meldet die Selektion eines Objekts aus der Auswahlliste
     *
     * @param objekt das gewählte Objekt
     * @param start Startdatum des Interessezeitraums
     * @param ende Endedatum des Interessezeitraums
     */
    public void ObjektAnzeigen(Object objekt, Date start, Date ende)
    {
        OBJEKTINFO o;
        RESERVIERUNGSINFO[] reservierungen;
        String reserviert;
        boolean erster;
        o = (OBJEKTINFO) objekt;
        if (o != null)
        {
            reservierungen = verb.ReservierungenHolen(o.NummerGeben(), start,
                    ende);
            reserviert = "keine Reservierungen";
            erster = true;
            for (RESERVIERUNGSINFO r : reservierungen)
            {
                if (erster)
                {
                    reserviert = "Reservierungen: ";
                    erster = false;
                }
                else
                {
                    reserviert = reserviert + "; ";
                }
                reserviert = reserviert
                        + ausgabeKonvertierung.format(r.StartDatumGeben())
                        + " bis "
                        + ausgabeKonvertierung.format(r.EndeDatumGeben());
            }
            oberflaeche.ObjektinfoSetzen(o.NameGeben() + " (" + o.ArtGeben()
                    + ") in " + LandSuchen(o.LandNummerGeben())
                    + " Wochenpreis: " + o.PreisGeben() + "Û",
                    "" + o.GroesseGeben() + "qm verteilt auf "
                            + o.ZimmerAnzahlGeben() + " Zimmer für maximal "
                            + o.PersonenAnzahlGeben() + " Personen",
                    "Ausstattung: " + o.AusstattungenAlsTextGeben(),
                    reserviert);
        }
    }

    /**
     * Reserviert das angegebene Objekt im angegebenen Zeitraum (wenn frei);
     *
     * @param objekt das gewählte Objekt
     * @param start Startdatum des Interessezeitraums
     * @param ende Endedatum des Interessezeitraums
     */
    public void ObjektReservieren(Object objekt, Date start, Date ende)
    {
        if (verb.Reservieren(((OBJEKTINFO) objekt).NummerGeben(),
                kunde.IDGeben(), start, ende))
        {
            oberflaeche.StatuszeileSetzen("Objekt erfolgreich reserviert");
        }
        else
        {
            oberflaeche.StatuszeileSetzen(
                    "Das Objekt konnte nicht reserviert werden");
        }
    }

    /**
     * Bucht die angegebene Reservierung fest
     *
     * @param reservierung die zu buchende Reservierung
     */
    public void ObjektBuchen(Object reservierung)
    {
        verb.ReservierungBuchen(
                ((RESERVIERUNGSINFO) reservierung).NummerGeben());
        oberflaeche.ReservierungslisteSetzen(
                verb.ReservierungenFuerBenutzerHolen(kunde.IDGeben()));
    }

    /**
     * Löscht die angegebene Reservierung
     *
     * @param reservierung die zu löschende Reservierung
     */
    public void ReservierungLoeschen(Object reservierung)
    {
        verb.ReservierungLoeschen(
                ((RESERVIERUNGSINFO) reservierung).NummerGeben());
        oberflaeche.ReservierungslisteSetzen(
                verb.ReservierungenFuerBenutzerHolen(kunde.IDGeben()));
    }

    /**
     * Setzt das Passwort des aktuellen Benutzers
     *
     * @param pass das neue Passwort
     */
    public void PasswortSetzen(String pass)
    {
        verb.PasswortSetzen(kunde.IDGeben(), pass);
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
