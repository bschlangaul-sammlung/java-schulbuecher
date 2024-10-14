
import java.util.*;
/**
 * Löst das Problem der 8 Damen
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Damen
{
    /**
     * Die Information über dei Position der Damen */
    private ArrayList<Integer> schachbrett;

    /**
     * Legt das Schachbrett an
     */
    Damen ()
    {
        schachbrett = new ArrayList<Integer>();
        for (int spalte = 0; spalte < 8; spalte += 1)
        {
            schachbrett.add(-1);
        }
        SchrittAusführen(0);
    }

    /**
     * Testet, ob das angegebene Element des Schachbretts durch eine der bisher aufgestellten Damen bedroht ist.
     * @param zeile Zeile das Feldelements
     * @param spalte Spalte das Feldelements
     */
    boolean IstFeldBedroht(int zeile, int spalte)
    {
        for (int aktspalte = spalte - 1; aktspalte >= 0; aktspalte -= 1)
        {
            int aktzeile = schachbrett.get(aktspalte);
            if ((zeile == aktzeile) || (zeile + spalte == aktzeile + aktspalte) ||
                (zeile - spalte == aktzeile - aktspalte))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt die gefundene Lösung aus.
     */
    void LösungAusgeben()
    {
        System.out.println("Lösung:");
        for (int spalte = 0; spalte < schachbrett.size(); spalte += 1)
        {
            System.out.print(" " + schachbrett.get(spalte));
        }
        System.out.println();
    }

    /**
     * Macht einen Rekursionsschritt auf dem Weg zur Lösung
     * @param spalte die Spalte, für die eine Position der Dame gesucht wird.
     */
    void SchrittAusführen(int spalte)
    {
        for (int zeile = 0; zeile < schachbrett.size(); zeile += 1)
        {
            if (!IstFeldBedroht(zeile, spalte))
            {
                schachbrett.set(spalte, zeile);
                if (spalte == schachbrett.size() - 1)
                {
                    LösungAusgeben();
                }
                else
                {
                    SchrittAusführen(spalte + 1);
                }
                schachbrett.set(spalte, -1);
            }
        }
    }
}
