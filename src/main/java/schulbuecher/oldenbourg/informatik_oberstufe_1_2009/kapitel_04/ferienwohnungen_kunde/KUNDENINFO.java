package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Verwaltet die Daten eines Landes.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KUNDENINFO
{
    private String ID;

    private String name;

    private String vorname;

    private String pass;

    /**
     * Besetzt die Attribute
     *
     * @param ID Schlüssel des Kunden
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     * @param pass Passwort des Kunden
     */
    KUNDENINFO(String ID, String name, String vorname, String pass)
    {
        this.ID = ID;
        this.name = name;
        this.vorname = vorname;
        this.pass = pass;
    }

    /**
     * Meldet den Schlüssel des Kunden
     *
     * @return Schlüssel
     */
    String IDGeben()
    {
        return ID;
    }

    /**
     * Meldet den Namen des Kunden
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Meldet den Vornamen des Kunden
     *
     * @return Vorname
     */
    String VornameGeben()
    {
        return vorname;
    }

    /**
     * Meldet das Passwort des Kunden
     *
     * @return Passwort
     */
    String PasswortGeben()
    {
        return pass;
    }

    /**
     * Meldet die Daten des Kunden als Stringrepräsentation des Objekts.
     *
     * @return Anzeigedaten
     */
    public String toString()
    {
        return ID + ": " + vorname + " " + name;
    }

    /**
     * Vergleicht zwei Objekte. überschreibt die Methode aus Object, hat aber
     * nur eigene Semantik, wenn das Vergleichsobjet ebenfalls von der Klasse
     * KUNDENINFO ist.
     *
     * @param obj das zu vergleichende Objekt
     *
     * @return wahr, wenn die Schlüssel gleich sind
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof KUNDENINFO)
        {
            return ID.equals(((KUNDENINFO) obj).ID);
        }
        else
        {
            return super.equals(obj);
        }
    }
}
