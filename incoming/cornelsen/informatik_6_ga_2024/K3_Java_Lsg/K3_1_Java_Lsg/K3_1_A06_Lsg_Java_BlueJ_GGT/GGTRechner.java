
/**
 * Berechnung des größten gemeinsamen Teilers 
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class GGTRechner
{

    /**
     * nichts zu tun
     */
    GGTRechner()
    {
        
    }
    
    /**
     * Berechnet den GGT rekursiv
     * @param zahl1 Der erste Wert, für den der GGT berechnet werden soll
     * @param zahl2 Der zweite Wert, für den der GGT berechnet werden soll
     * @return GGT
     */
    static int GGTBerechnen(int zahl1, int zahl2)
    {
        if (zahl2 == 0)
        {
            return zahl1;
        }
        else
        {
            return GGTBerechnen(zahl2, zahl1 % zahl2);
        }
    }
}
