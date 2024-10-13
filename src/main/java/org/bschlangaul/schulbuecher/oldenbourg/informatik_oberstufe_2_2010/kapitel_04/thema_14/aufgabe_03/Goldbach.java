package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_14.aufgabe_03;

/**
 * Klasse zur Realisierung des Goldbach-Tests Oldenbourg Schulbuchverlag
 * Informatik Oberstufe 2
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Goldbach
{
    Goldbach()
    {
    }

    /**
     * Ermittelt, ob eine Zahl prim ist
     *
     * @param n untersuchte Zahl
     *
     * @return Wahrheitswert
     */
    boolean IstPrim(int n)
    {
        if (n <= 1)
        {
            System.out.println("Wertebereich-Fehler: n <= 1");
            return false;
        }
        else
        {
            if (n == 2)
            {
                return true;
            }
            else
            {
                boolean prim = true;
                int i = 2;
                while (prim && (i <= Math.sqrt(n)))
                {
                    if (n % i == 0)
                    {
                        prim = false;
                    }
                    i = i + 1;
                }
                return prim;
            }
        }
    }

    /**
     * Ermittelt, ob eine Zahl die Goldbach-Eigenschaft erfüllt
     *
     * @param n untersuchte Zahl
     *
     * @return Wahrheitswert
     */
    boolean GoldbachTesten(int n)
    {
        boolean goldbachErfuellt = false;
        if (n <= 1 || n % 2 == 1)
        {
            System.out
                    .println("Wertebereich-Fehler: n <= 1 oder ungerade Zahl");
        }
        else
        {
            int i = 2;
            while (i <= n / 2 && !goldbachErfuellt)
            {
                if (IstPrim(i) && IstPrim(n - i))
                {
                    goldbachErfuellt = true;
                    int j = n - i;
                    System.out.println(n + " ist die Summe der Primzahlen " + i
                            + " und " + j);
                }
                i = i + 1;
            }
        }
        return goldbachErfuellt;
    }
}
