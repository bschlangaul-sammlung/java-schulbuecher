package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Beschreibt eine Umsteigemöglichkeit.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class UMSTEIGEINFO implements DATENELEMENT
{
    private int nummer;

    private int linie1, linie2;

    /**
     * Legt die Daten fest.
     *
     * @param nummer Nummer des Bahnhofs
     * @param linie1 ankommende Linie
     * @param linie2 abgehende Linie
     */
    UMSTEIGEINFO(int nummer, int linie1, int linie2)
    {
        this.nummer = nummer;
        this.linie1 = linie1;
        this.linie2 = linie2;
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
        return (((UMSTEIGEINFO) test).nummer == nummer)
                && (((UMSTEIGEINFO) test).linie1 == linie1)
                && (((UMSTEIGEINFO) test).linie2 == linie2);
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
        if (nummer < ((UMSTEIGEINFO) test).nummer)
        {
            return -1;
        }
        else if (nummer > ((UMSTEIGEINFO) test).nummer)
        {
            return 1;
        }
        else
        {
            if (linie1 < ((UMSTEIGEINFO) test).linie1)
            {
                return -1;
            }
            else if (linie1 > ((UMSTEIGEINFO) test).linie1)
            {
                return 1;
            }
            else
            {
                if (linie2 < ((UMSTEIGEINFO) test).linie2)
                {
                    return -1;
                }
                else if (linie2 > ((UMSTEIGEINFO) test).linie2)
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
     * Meldet die Nummer des Bahnhofs.
     *
     * @return Nummer des Bahnhofs
     */
    int BahnhofGeben()
    {
        return nummer;
    }

    /**
     * Meldet die Nummer der Linie, mit der man ankommt.
     *
     * @return Nummer der ankommenden Linie
     */
    int VonLinieGeben()
    {
        return linie1;
    }

    /**
     * Meldet die Nummer der Linie, mit der man abfährt.
     *
     * @return Nummer der weiterführenden Linie
     */
    int AbLinieGeben()
    {
        return linie2;
    }
}
