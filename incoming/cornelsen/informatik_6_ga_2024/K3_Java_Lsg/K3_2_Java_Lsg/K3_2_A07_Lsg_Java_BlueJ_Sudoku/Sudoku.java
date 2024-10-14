
import java.util.*;
/**
 * Löst ein Sudoku-Rätsel
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Sudoku
{
    /**
     * Das Sudoku-Feld */
    private ArrayList<ArrayList<ArrayList<Integer>>> feld;

    /**
     * Legt das Sudoku-Feld an und besetzt alle Elemente mit "alle Werte möglich" vor.
     */
    Sudoku ()
    {
        feld = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int zeile = 0; zeile < 9; zeile += 1)
        {
            feld.add(new ArrayList<ArrayList<Integer>>());
            for (int spalte = 0; spalte < 9; spalte += 1)
            {
                feld.get(zeile).add(new ArrayList<Integer>());
                for (int nummer = 1; nummer <= 9; nummer += 1)
                {
                    feld.get(zeile).get(spalte).add(nummer);
                }
            }
        }
    }

    /**
     * Legt das in der Aufgabe dargestellte Rätsel an.
     */
    void Vorbesetzen()
    {
        FeldelementFixieren(0, 2, 2);
        FeldelementFixieren(1, 0, 6);
        FeldelementFixieren(1, 4, 3);
        FeldelementFixieren(2, 0, 4);
        FeldelementFixieren(2, 2, 9);
        FeldelementFixieren(2, 3, 1);
        FeldelementFixieren(2, 4, 6);
        FeldelementFixieren(2, 5, 7);
        FeldelementFixieren(2, 8, 3);
        FeldelementFixieren(3, 1, 1);
        FeldelementFixieren(4, 2, 8);
        FeldelementFixieren(4, 5, 4);
        FeldelementFixieren(4, 6, 3);
        FeldelementFixieren(4, 8, 2);
        FeldelementFixieren(5, 6, 4);
        FeldelementFixieren(5, 7, 7);
        FeldelementFixieren(6, 1, 8);
        FeldelementFixieren(6, 4, 9);
        FeldelementFixieren(7, 4, 4);
        FeldelementFixieren(7, 5, 3);
        FeldelementFixieren(7, 8, 8);
        FeldelementFixieren(8, 3, 5);
        FeldelementFixieren(8, 4, 7);
        FeldelementFixieren(8, 6, 9);
    }

    /**
     * Erstellt eine Kopie des gegebenen Feldes
     * @param original das zu kopierende Feld
     * @return die erstellte Kopie
     */
    private ArrayList<ArrayList<ArrayList<Integer>>> Kopieren(ArrayList<ArrayList<ArrayList<Integer>>> original)
    {
        ArrayList<ArrayList<ArrayList<Integer>>> res;
        res = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int zeile = 0; zeile < original.size(); zeile+= 1)
        {
            res.add(new ArrayList<ArrayList<Integer>>());
            for (int spalte = 0; spalte < original.size(); spalte += 1)
            {
                res.get(zeile).add(new ArrayList<Integer>());
                for (Integer i: original.get(zeile).get(spalte))
                {
                    res.get(zeile).get(spalte).add(new Integer(i));
                }
            }
        }
        return res;
    }

    /**
     * Gibt das Sudoku-Feld auf der Konsole aus
     * Angegeben werden die eindeutigen Felder, sonst "-"
     */
    void FeldAusgeben()
    {
        for (int zeile = 0; zeile < 9; zeile += 1)
        {
            for (int spalte = 0; spalte < 9; spalte += 1)
            {
                if (feld.get(zeile).get(spalte).size() == 1)
                {
                    System.out.print(" " + feld.get(zeile).get(spalte).get(0));
                }
                else
                {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Legt das Feldelement auf den angegebenen Wert fest.
     * @param zeile Zeilennummer des zu fixierenden Elements
     * @param spalte Spaltennummer des zu fixierenden Elements
     * @param wert der Wert des Elements
     */
    void FeldelementFixieren(int zeile, int spalte, int wert)
    {
        for (int z = 0; z < 9; z += 1)
        {
            feld.get(z).get(spalte).remove(new Integer(wert));
        }
        for (int s = 0; s < 9; s += 1)
        {
            feld.get(zeile).get(s).remove(new Integer(wert));
        }
        for (int z = zeile / 3 * 3; z < (zeile / 3 + 1) * 3; z += 1)
        {
            for (int s = spalte / 3 * 3; s < (spalte / 3 + 1) * 3; s += 1)
            {
                feld.get(z).get(s).remove(new Integer(wert));
            }
        }
        feld.get(zeile).get(spalte).clear();
        feld.get(zeile).get(spalte).add(wert);
    }

    /**
     * Testet alle Möglichkeiten an der aktuellen Stelle
     * @param aktuelleZeile Nummer der Zeile des aktuellen Elements
     * @param aktuelleSpalte Nummer der Spalte des aktuellen Elements
     */
    void SchrittAusführen(int aktuelleZeile, int aktuelleSpalte)
    {
        ArrayList<ArrayList<ArrayList<Integer>>> startFeld = Kopieren(feld);
        for (Integer wert: startFeld.get(aktuelleZeile).get(aktuelleSpalte))
        {
            FeldelementFixieren(aktuelleZeile, aktuelleSpalte, wert);
            if ((aktuelleZeile == 8) && (aktuelleSpalte == 8))
            {
                FeldAusgeben();
            }
            else
            {
                int zeile = aktuelleZeile;
                int spalte = aktuelleSpalte + 1;
                if (spalte > 8)
                {
                    spalte = 0;
                    zeile += 1;
                }
                SchrittAusführen(zeile, spalte);
            }
            feld = Kopieren(startFeld);
        }
    }
}
