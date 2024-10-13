package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_14.aufgabe_02;

/**
 * Klasse zur Realisierung der Collatz-Funktion Oldenbourg Schulbuchverlag
 * Informatik Oberstufe 2
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Collatz
{
    Collatz()
    {
    }

    /**
     * Berechnet den Wert der Collatzfunktion für eine nat. Zahl n
     *
     * @param n Argument der Collatzfunktion
     *
     * @return Wert der Collatzfunktion
     */
    int CollatzwertGeben(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            if (n % 2 == 0)
            {
                return CollatzwertGeben(n / 2);
            }
            else
            {
                return CollatzwertGeben(3 * n + 1);
            }
        }
    }

    /**
     * Berechnet den Wert der Collatzfunktion für eine nat. Zahl und gibt die
     * zugehörige Collatzfolge aus. n
     *
     * @param n Argument der Collatzfunktion
     *
     * @return Wert der Collatzfunktion
     */
    int CollatzfolgeAusgeben(int n)
    {
        System.out.print(n + " ");
        if (n == 1)
        {
            System.out.println();
            return 1;
        }
        else
        {
            if (n % 2 == 0)
            {
                return CollatzfolgeAusgeben(n / 2);
            }
            else
            {
                return CollatzfolgeAusgeben(3 * n + 1);
            }
        }
    }
}
