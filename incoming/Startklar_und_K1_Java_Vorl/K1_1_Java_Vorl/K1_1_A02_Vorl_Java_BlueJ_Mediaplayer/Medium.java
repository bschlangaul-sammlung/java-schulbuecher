
/**
 * Beschreibung der Klasse Medium
 * 
 * @author Klaus Reinold 
 * @version 0.9
 */
class Medium
{
    /** Dateiname */
    private String name;

    //Die Referenz auf den Nachfolger und die passenden Methoden fehlen!

    /**
     * Konstruktor des Mediums
     * @param s Name des Mediums
     */
    Medium(String s)
    {
        name = "media/"+s;
    }

    /**
     * Gibt Information über das Medium aus.
     */
    void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Mediums zurück
     * @return Name des Mediums
     */
    String NameGeben()
    {
        return name;
    }
}
