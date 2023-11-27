package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

/**
 * Verwaltet die Daten eines Landes.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class LANDINFO
{
    private int ID;

    private String name;

    /**
     * Besetzt die Attribute
     *
     * @param ID   Schlüssel des Landes
     * @param name Name des Landes
     */
    LANDINFO(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    /**
     * Meldet den Schlüssel des Landes
     *
     * @return Schlüssel
     */
    int IDGeben()
    {
        return ID;
    }

    /**
     * Meldet den Namen des Landes
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Meldet den Namen des Landes als Stringrepräsentation des Objekts.
     *
     * @return Name
     */
    public String toString()
    {
        return name;
    }
}
