
/**
 * Klasse zur Beschreibung eines Bildes
 *
 * @author Klaus Reinold
 * @version 0.9
 */
 class Bild
{
    /**
     * Dateiname */
    private String name;

    //Die Nachfolgerverwaltung fehlt noch.

    /**
    * Konstruktor des Bildes
    * @param s Name des Bildes
    */
     Bild(String s)
    {
        name = "Bilder/" + s;
    }

     /**
     * Gibt Information über das Bild aus.
     */
     void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Bildes aus
     * @return Name des Bildes
     */
     String NameGeben()
    {
        return name;
    }
}
