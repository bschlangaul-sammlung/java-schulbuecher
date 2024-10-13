
/**
 * Klasse zur Verwaltung einer Lottozahl
 * 
 * @author Klaus Reinold
 * @version 1.0
 */
class Zahl implements Datenelement
{
    /**Zu verwaltender Wert*/
    private int z;

    /**
     * Konstruktor
     * @param zahlNeu Wert der Zahl
     */
    Zahl(int zahlNeu)
    {
        z = zahlNeu;
    }
    
    /**
     * Ausgabe der Zahl auf der Konsole
     */
    public void InformationAusgeben()
    {
        System.out.println(z);
    }
   
     /**
     * Vergleich zweier Zahlen
     * @param dvergleich Vergleichs-Datenelement
     * @return Wahrheitswert
     */
    public void IstKleinerAls(Datenelement dvergleich)
    {
        Zahl zahl;
        zahl = (Zahl) dvergleich;
        if (z < zahl.ZahlGeben())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Ausgabe der verwalteten Zahl
     * @return Zahl
     */
    private int ZahlGeben()
    {
        return z;
    }
    
    public boolean SchlüsselIstGleich(String s)
    {
        String zahlAlsString;
        zahlAlsString = z + "";
        return zahlAlsString.compareTo(s) == 0; 
    }
        
}
