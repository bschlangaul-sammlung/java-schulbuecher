package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

import java.util.EnumSet;

/**
 * Beschreibung eines Objekts.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class OBJEKTINFO
{
    enum Ausstattungen
    {
        Fernseher, Waschmaschine, Trockner, Kuehlschrank, Gefrierschrank,
        Swimmingpool
    }

    private int nummer;

    private String name;

    private int groesse;

    private int anzahlzimmer;

    private int anzahlpersonen;

    private int landnummer;

    private String art;

    private double preis;

    private EnumSet<Ausstattungen> ausstattung;

    private boolean sperre;

    /**
     * Belegt die Attribute.
     */
    OBJEKTINFO(int nummer, String name, int groesse, int anzahlzimmer,
            int anzahlpersonen, int landnummer, String art, double preis,
            String ausstattung, boolean sperre)
    {
        this.nummer = nummer;
        this.name = name;
        this.groesse = groesse;
        this.anzahlzimmer = anzahlzimmer;
        this.anzahlpersonen = anzahlpersonen;
        this.landnummer = landnummer;
        this.art = art;
        this.preis = preis;
        this.sperre = sperre;
        this.ausstattung = EnumSet
                .noneOf(Ausstattungen.Fernseher.getDeclaringClass());
        String[] hilf = ausstattung.split(",");
        for (int i = 0; i < hilf.length; i++)
        {
            try
            {
                this.ausstattung.add(Ausstattungen.valueOf(
                        Ausstattungen.Fernseher.getDeclaringClass(), hilf[i]));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    /**
     * Ausgabe des Objekts in "lesbarer" Form
     *
     * @return Objektangaben
     */
    public String toString()
    {
        return "Objekt Nummer " + nummer + ": " + name;
    }

    /**
     * Meldet den Schlüssel des Objekts.
     *
     * @return Schlüsselnummer
     */
    int NummerGeben()
    {
        return nummer;
    }

    /**
     * Meldet den Namen des Objekts.
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Meldet die Größe des Objekts.
     *
     * @return Schlüsselnummer
     */
    int GroesseGeben()
    {
        return groesse;
    }

    /**
     * Meldet die Personenanzahl des Objekts.
     *
     * @return Personenanzahl
     */
    int PersonenAnzahlGeben()
    {
        return anzahlpersonen;
    }

    /**
     * Meldet die Zimmeranzahl des Objekts.
     *
     * @return Zimmeranzahl
     */
    int ZimmerAnzahlGeben()
    {
        return anzahlzimmer;
    }

    /**
     * Meldet den Schlüssel des Landes des Objekts.
     *
     * @return Schlüsselnummer des Landes
     */
    int LandNummerGeben()
    {
        return landnummer;
    }

    /**
     * Meldet die Art des Objekts.
     *
     * @return Art ('Haus', 'Wohnung')
     */
    String ArtGeben()
    {
        return art;
    }

    /**
     * Meldet den Wochenpreis des Objekts.
     *
     * @return Wochenpreis
     */
    double PreisGeben()
    {
        return preis;
    }

    /**
     * Meldet die Ausstattungen des Objekts.
     *
     * @return logisches Feld mit den Ausstattungen
     */
    boolean[] AusstattungenGeben()
    {
        boolean[] res;
        res = new boolean[6];
        res[0] = ausstattung.contains(Ausstattungen.Fernseher);
        res[1] = ausstattung.contains(Ausstattungen.Waschmaschine);
        res[2] = ausstattung.contains(Ausstattungen.Trockner);
        res[3] = ausstattung.contains(Ausstattungen.Kuehlschrank);
        res[4] = ausstattung.contains(Ausstattungen.Gefrierschrank);
        res[5] = ausstattung.contains(Ausstattungen.Swimmingpool);
        return res;
    }

    /**
     * Meldet den Sperreintrag des Objekts.
     *
     * @return Sperre
     */
    boolean SperreGeben()
    {
        return sperre;
    }

    /**
     * Vergleicht zwei Objekte. überschreibt die Methode aus Object, hat aber
     * nur eigene Semantik, wenn das Vergleichsobjet ebenfalls von der Klasse
     * OBJEKTINFO ist.
     *
     * @param obj das zu vergleichende Objekt
     *
     * @return wahr, wenn die Schlüssel gleich sind
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof OBJEKTINFO)
        {
            return nummer == ((OBJEKTINFO) obj).nummer;
        }
        else
        {
            return super.equals(obj);
        }
    }
}
