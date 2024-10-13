package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Beschreibt einen Streckenabschnitt.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ABSCHNITT implements DATENELEMENT
{
    private int linie;

    private int bahnhof1, bahnhof2;

    private float laenge;

    /**
     * Legt die Daten fest.
     *
     * @param linie Linie, zu der der Abschnitt gehört
     * @param bahnhof1 eine Bahnhof des Abschnitts
     * @param bahnhof2 anderer Bahnhof des Abschnitts
     * @param laenge Länge des Abschnitts
     */
    ABSCHNITT(int linie, int bahnhof1, int bahnhof2, float laenge)
    {
        this.linie = linie;
        this.bahnhof1 = bahnhof1;
        this.bahnhof2 = bahnhof2;
        this.laenge = laenge;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return true, wenn die Schlüssel übereinstimmen
     */
    public boolean IstGleich(DATENELEMENT test)
    {
        return (((ABSCHNITT) test).linie == linie)
                && (((ABSCHNITT) test).bahnhof1 == bahnhof1)
                && (((ABSCHNITT) test).bahnhof2 == bahnhof2);
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter. <br>
     * Hat das Datenelement einen kleineren Schlüssel als test, ist das Ergebnis
     * -1. <br>
     * Hat das Datenelement den gleichen Schlüssel wie test, ist das Ergebnis 0.
     * <br>
     * Hat das Datenelement einen größeren Schlüssel als test, ist das Ergebnis
     * 1.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return Vergleichsergebnis
     */
    public int Vergleichen(DATENELEMENT test)
    {
        if (linie < ((ABSCHNITT) test).linie)
        {
            return -1;
        }
        else if (linie > ((ABSCHNITT) test).linie)
        {
            return 1;
        }
        else
        {
            if (bahnhof1 < ((ABSCHNITT) test).bahnhof1)
            {
                return -1;
            }
            else if (bahnhof1 > ((ABSCHNITT) test).bahnhof1)
            {
                return 1;
            }
            else
            {
                if (bahnhof2 < ((ABSCHNITT) test).bahnhof2)
                {
                    return -1;
                }
                else if (bahnhof2 > ((ABSCHNITT) test).bahnhof2)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
    }

    /**
     * Meldet den ersten Bahnhof des Abschnitts.
     *
     * @return Nummer des ersten Bahnhofs.
     */
    int Bahnhof1Geben()
    {
        return bahnhof1;
    }

    /**
     * Meldet den zweiten Bahnhof des Abschnitts.
     *
     * @return Nummer des zweiten Bahnhofs.
     */
    int Bahnhof2Geben()
    {
        return bahnhof2;
    }

    /**
     * Meldet die Linie des Abschnitts.
     *
     * @return Nummer der Linie.
     */
    int LinieGeben()
    {
        return linie;
    }

    /**
     * Meldet die Länge des Abschnitts.
     *
     * @return Länge des Abschnitts.
     */
    float LaengeGeben()
    {
        return laenge;
    }
}
