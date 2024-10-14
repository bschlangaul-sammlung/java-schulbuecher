package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_05.fibonacci;

/**
 * Rahmenklasse für die Fibonacci-Funktion.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class FibonacciRechner
{

    /**
     * Berechnet den Wert der Fibonacci-Funktion
     *
     * @param n Anzahl der Monate
     *
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
