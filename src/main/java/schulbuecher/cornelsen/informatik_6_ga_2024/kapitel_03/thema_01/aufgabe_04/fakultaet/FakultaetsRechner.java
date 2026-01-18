package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_04.fakultaet;

/**
 * Verschiedene Methoden zur Berechnung der Fakultät
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class FakultaetsRechner
{

    /**
     * Berechnet die Fakultät rekursiv
     *
     * @param n Der Wert, für den die Fakultät berechnet werden soll
     *
     * @return n!
     */
    static long FakultätBerechnen(long n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return n * FakultätBerechnen(n - 1);
        }
    }

    /**
     * Berechnet die Fakultät iterativ
     *
     * @param n Der Wert, für den die Fakultät berechnet werden soll
     *
     * @return n!
     */
    static long FakultätBerechnen2(long n)
    {
        long res = 1;
        for (long i = 2; i <= n; i += 1)
        {
            res = res * i;
        }
        return res;
    }

    /**
     * Berechnet die Fakultät mittels Mehrfachauswahl
     *
     * @param n Der Wert, für den die Fakultät berechnet werden soll
     *
     * @return n!
     */
    static long FakultätBerechnen3(long n)
    {
        switch ((int) n)
        {
        case 1:
            return 1;

        case 2:
            return 2;

        case 3:
            return 6;

        case 4:
            return 24;

        case 5:
            return 120;

        case 6:
            return 720;

        case 7:
            return 5040;

        case 8:
            return 40320;

        case 9:
            return 362880;

        case 10:
            return 3628800;

        case 11:
            return 39916800;

        case 12:
            return 479001600;

        case 13:
            return 6227020800l;

        case 14:
            return 87178291200l;

        case 15:
            return 1307674368000l;

        case 16:
            return 20922789888000l;

        case 17:
            return 355687428096000l;

        case 18:
            return 6402373705728000l;

        case 19:
            return 121645100408832000l;

        case 20:
            return 2432902008176640000l;

        default:
            return 0;
        }
    }
}
