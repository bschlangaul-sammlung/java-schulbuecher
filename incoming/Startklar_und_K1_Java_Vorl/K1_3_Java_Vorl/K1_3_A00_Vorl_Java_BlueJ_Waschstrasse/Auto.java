
/**
 * Klasse zur Verwaltung von Autos für eine Waschstraße
 * 
 * @author Klaus Reinold
 * @version 1.0
 */
class Auto
{
    /** Das Kennzeichen */
    private String kennzeichen;

    /**
     * Konstruktor für Objekte der Klasse Auto
     * @param kennzeichenNeu Kennzeichen des Fahrzeugs
     */
    Auto(String kennzeichenNeu)
    {
        kennzeichen = kennzeichenNeu;
    }
    
    /**
     * Gibt Information über das Auto aus.
     */
    void InformationAusgeben()
    {
        System.out.println(kennzeichen);
    }

    /**
     * Gibt das Kennzeichen des Autos zurück
     * @return Kennzeichen
     */
    String KennzeichenGeben()
    {
        return kennzeichen;
    }

}
