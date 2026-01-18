package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

import java.util.Date;

/**
 * Beschreibt einen Reservierungseintrag.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RESERVIERUNGSINFO
{
    private int nummer;

    private int wohnung;

    private String wohnungsname;

    private String benutzer;

    private String art;

    private Date startDatum;

    private Date endeDatum;

    /**
     * Belegt die Attributwerte
     *
     * @param nummer Schlüssel der Reservierung
     * @param wohnung reservierte Wohnung
     * @param wohnungsname Name der reservierten Wohnung
     * @param benutzer Benutzername des Reservierenden
     * @param art Art der Reservierung ('reserviert', 'gebucht')
     * @param startDatum Beginn der Reservierung
     * @param endeDatum Ende der Reservierung
     */
    RESERVIERUNGSINFO(int nummer, int wohnung, String wohnungsname,
            String benutzer, String art, Date startDatum, Date endeDatum)
    {
        this.nummer = nummer;
        this.wohnung = wohnung;
        this.wohnungsname = wohnungsname;
        this.benutzer = benutzer;
        this.art = art;
        this.startDatum = startDatum;
        this.endeDatum = endeDatum;
    }

    /**
     * Meldet die Nummer der Reservierung
     *
     * @return Schlüssel der Reservierung
     */
    int NummerGeben()
    {
        return nummer;
    }

    /**
     * Meldet die resrvierte Wohnung
     *
     * @return Nummer der Wohnung
     */
    int WohnungGeben()
    {
        return wohnung;
    }

    /**
     * Meldet den reservierenden Benutzer
     *
     * @return Benutzername
     */
    String BenutzerGeben()
    {
        return benutzer;
    }

    /**
     * Meldet die Art der Reservierung
     *
     * @return Reservierungsart
     */
    String ArtGeben()
    {
        return art;
    }

    /**
     * Meldet den Beginn der Reservierung
     *
     * @return Angangsdatum der Reservierung
     */
    Date StartDatumGeben()
    {
        return startDatum;
    }

    /**
     * Meldet das Ende der Reservierung
     *
     * @return Endedatum der Reservierung
     */
    Date EndeDatumGeben()
    {
        return endeDatum;
    }

    /**
     * Stringrepäsentation der Buchung
     *
     * @return Klartextbeschreibung
     */
    public String toString()
    {
        return wohnungsname + " " + art + " vom " + startDatum + " bis "
                + endeDatum;
    }
}
