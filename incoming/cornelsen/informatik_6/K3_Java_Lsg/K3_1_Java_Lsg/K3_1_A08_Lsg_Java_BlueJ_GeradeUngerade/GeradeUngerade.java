
/**
 * Rahmenklasse für den Test auf gerade bzw. ungerade
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class GeradeUngerade
{

    /**
     * nichts zu tun
     */
    GeradeUngerade ()
    {
        
    }
    
    /**
     * Ermittelt, ob eine Zahl gerade ist
     * @param n die zu testende Zahl
     * @return wahr, wenn die Zahl gerade ist
     */
    static boolean Gerade(int n)
    {
        if (n == 0)
        {
            return true;
        }
        else
        {
            return Ungerade(n - 1);
        }
    }
    
    /**
     * Ermittelt, ob eine Zahl ungerade ist
     * @param n die zu testende Zahl
     * @return wahr, wenn die Zahl ungerade ist
     */
    static boolean Ungerade(int n)
    {
        if (n == 0)
        {
            return false;
        }
        else
        {
            return Gerade(n - 1);
        }
    }
    
    /**
     * Ermittelt, ob eine Zahl gerade ist
     * @param n die zu testende Zahl
     * @return wahr, wenn die Zahl gerade ist
     */
    static boolean IstGerade2(int n)
    {
        return n % 2 == 0;
    }
}
