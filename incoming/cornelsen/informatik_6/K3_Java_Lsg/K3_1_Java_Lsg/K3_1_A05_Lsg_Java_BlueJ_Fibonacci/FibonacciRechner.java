
/**
 * Rahmenklasse für die Fibonacci-Funktion.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class FibonacciRechner
{

    /**
     * nichts zu tun
     */
    FibonacciRechner()
    {
        
    }
    
    /**
     * Berechnet den Wert der Fibonacci-Funktion
     * @param n Anzahl der Monate
     * @return Anzahl der Kaninchenpaare
     */
    static int FibonacciBerechnen(int n)
    {
        System.out.println("Aufruf mit n = " + n);
        if (n == 1)
        {
            return 1;
        }
        else if (n == 2)
        {
            return 1;
        }
        else
        {
            return FibonacciBerechnen(n - 1) + FibonacciBerechnen(n - 2);
        }
    }
}
