package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_07.ackermann;

/**
 * Berechnung der Ackermann-Péter-Funktion
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class AckermannRechner
{

    /**
     * Berechnet den Wert der Ackermann-Péter-Funktion rekursiv
     *
     * @param n 1. Parameter der Ackermann-Péter-Funktion
     * @param m 2. Parameter der Ackermann-Péter-Funktion
     *
     * @return Wert der Ackermann-Péter-Funktion
     */
    static int Acker(int n, int m)
    {
        System.out.println("Aufruf mit n = " + n + ", m = " + m);
        if (n == 0)
        {
            return m + 1;
        }
        else if (m == 0)
        {
            return Acker(n - 1, 1);
        }
        else
        {
            return Acker(n - 1, Acker(n, m - 1));
        }
    }
}
