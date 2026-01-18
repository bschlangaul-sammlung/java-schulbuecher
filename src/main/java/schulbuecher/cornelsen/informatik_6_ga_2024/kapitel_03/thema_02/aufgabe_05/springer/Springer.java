package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_02.aufgabe_05.springer;

import java.util.ArrayList;

/**
 * Löst das Problem der Springerreise
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Springer
{
    /**
     * Das Schachbrett mit den Nummern der Springerzüge.
     */
    private ArrayList<ArrayList<Integer>> schachbrett;

    /**
     * Legt das Schachbrett an
     *
     * @param startX x-Position für den Startpunkt der Springerreise
     * @param startY y-Position für den Startpunkt der Springerreise
     */
    Springer(int startX, int startY)
    {
        schachbrett = new ArrayList<ArrayList<Integer>>();
        for (int zeile = 0; zeile < 6; zeile += 1)
        {
            schachbrett.add(new ArrayList<Integer>());
            for (int spalte = 0; spalte < 6; spalte += 1)
            {
                schachbrett.get(zeile).add(0);
            }
        }
        SchrittAusführen(startY, startX, 1);
    }

    /**
     * Gibt die gefundene Lösung aus.
     */
    void LösungAusgeben()
    {
        System.out.println("Lösung:");
        for (int spalte = 0; spalte < schachbrett.size(); spalte += 1)
        {
            for (int zeile = 0; zeile < schachbrett.size(); zeile += 1)
            {
                int nummer = schachbrett.get(zeile).get(spalte);
                if (nummer < 10)
                {
                    System.out.print("  " + nummer);
                }
                else
                {
                    System.out.print(" " + nummer);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Macht einen Rekursionsschritt auf dem Weg zur Lösung
     *
     * @param zeile die Zeile, auf die der Springer gesetzt wird.
     * @param spalte die Spalte, auf die der Springer gesetzt wird.
     * @param nummer die Nummer des Springers
     */
    void SchrittAusführen(int zeile, int spalte, int nummer)
    {
        int aktZeile, aktSpalte;
        schachbrett.get(zeile).set(spalte, nummer);
        if (nummer == schachbrett.size() * schachbrett.size())
        {
            LösungAusgeben();
        }
        else
        {
            for (int pos = 0; pos < 8; pos += 1)
            {
                switch (pos)
                {
                case 0:
                    aktZeile = zeile + 1;
                    aktSpalte = spalte + 2;
                    break;

                case 1:
                    aktZeile = zeile - 1;
                    aktSpalte = spalte + 2;
                    break;

                case 2:
                    aktZeile = zeile - 2;
                    aktSpalte = spalte + 1;
                    break;

                case 3:
                    aktZeile = zeile - 2;
                    aktSpalte = spalte - 1;
                    break;

                case 4:
                    aktZeile = zeile - 1;
                    aktSpalte = spalte - 2;
                    break;

                case 5:
                    aktZeile = zeile + 1;
                    aktSpalte = spalte - 2;
                    break;

                case 6:
                    aktZeile = zeile + 2;
                    aktSpalte = spalte - 1;
                    break;

                case 7:
                    aktZeile = zeile + 2;
                    aktSpalte = spalte + 1;
                    break;

                default:
                    aktZeile = -1;
                    aktSpalte = -1;
                    break;
                }
                if ((aktZeile >= 0) && (aktZeile < schachbrett.size())
                        && (aktSpalte >= 0) && (aktSpalte < schachbrett.size())
                        && (schachbrett.get(aktZeile).get(aktSpalte) == 0))
                {
                    SchrittAusführen(aktZeile, aktSpalte, nummer + 1);
                }
            }
        }
        schachbrett.get(zeile).set(spalte, 0);
    }
}
