package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_14.aufgabe_03;

/**
 * Klasse zur Realisierung des Goldbach-Tests Oldenbourg Schulbuchverlag
 * Informatik Oberstufe 2
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class GoldbachMitLaufzeitMessung
{
    private int schrittzaehler;

    /**
     * Konstruktor
     */
    GoldbachMitLaufzeitMessung()
    {
        schrittzaehler = 0;
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
        schrittzaehler++;
        if (n <= 1)
        {
            schrittzaehler++;
            System.out.println("Wertebereich-Fehler: n <= 1");
            schrittzaehler++;
            return false;
        }
        else
        {
            schrittzaehler++;
            if (n == 2)
            {
                schrittzaehler++;
                return true;
            }
            else
            {
                schrittzaehler++;
                boolean prim = true;
                schrittzaehler++;
                int i = 2;
                schrittzaehler++;
                while (prim && (i <= Math.sqrt(n)))
                {
                    schrittzaehler++;
                    if (n % i == 0)
                    {
                        schrittzaehler++;
                        prim = false;
                    }
                    schrittzaehler++;
                    i = i + 1;
                }
                schrittzaehler++;
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
        schrittzaehler = 0;
        schrittzaehler++;
        boolean goldbachErfuellt = false;
        schrittzaehler++;
        if (n <= 1 || n % 2 == 1)
        {
            schrittzaehler++;
            System.out
                    .println("Wertebereich-Fehler: n <= 1 oder ungerade Zahl");
        }
        else
        {
            schrittzaehler++;
            int i = 2;
            schrittzaehler++;
            while (i <= n / 2 && !goldbachErfuellt)
            {
                schrittzaehler++;
                if (IstPrim(i) && IstPrim(n - i))
                {
                    schrittzaehler++;
                    goldbachErfuellt = true;
                    schrittzaehler++;
                    schrittzaehler++; // System.out.println(n+" ist die Summe
                                      // der Primzahlen "+i+"
                                      // und "+j); //Wegen Messreihe erfolgt
                                      // keine Ausgabe der
                                      // Einzelergebnisse
                }
                schrittzaehler++;
                i = i + 1;
            }
        }
        schrittzaehler++;
        System.out.println(schrittzaehler);
        return goldbachErfuellt; // Wegen Messreihe erfolgt keine Ausgabe der
                                 // Einzelergebnisse
    }

    /**
     * Führt eine Messreihe bzgl. Goldbach-Eigenschaft für die geraden Zahlen
     * von 4 bis 1000 durch.
     */
    void GoldbachMessreihe()
    {
        for (int i = 4; i < 1000; i = i + 2)
        {
            GoldbachTesten(i);
        }
    }
}
