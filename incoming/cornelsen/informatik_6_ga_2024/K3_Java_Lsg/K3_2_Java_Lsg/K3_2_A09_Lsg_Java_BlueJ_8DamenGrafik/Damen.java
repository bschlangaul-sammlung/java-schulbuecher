
import java.util.*;
/**
 * Löst das Problem der 8 Damen
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Damen extends Ereignisbehandlung
{
    /**
     * Die Brettinformation zum Suchen der Lösung */
    private ArrayList<Integer> schachbrett;
    /**
     * Das Brett zum Anzeigen der Lösung */
    private Schachbrett brett;
    /**
     * Die Damen zum Anzeigen der Lösung */
    private ArrayList<Dame> damen;
    /**
     * Signal für gedrückte Taste */
    private boolean weiter;

    /**
     * Legt das Schachbrett an
     */
    Damen ()
    {
        super();
        weiter = false;
        brett = new Schachbrett();
        damen = new ArrayList<Dame>();
        for (int zeile = 0; zeile < 8; zeile += 1)
        {
            damen.add(new Dame());
            damen.get(zeile).SichtbarkeitSetzen(false);
        }
        schachbrett = new ArrayList<Integer>();
        for (int spalte = 0; spalte < 8; spalte += 1)
        {
            schachbrett.add(-1);
        }
        SchrittAusführen(0);
    }

    /**
     * Die Aktionsmethode für gedrückte Tasten.
     * @param taste die gedrückte Taste
     */
    void TasteGedrückt (char taste)
    {
        weiter = true;
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     * @param taste KeyCode der gedrückten Taste
     */
    void SonderTasteGedrückt (int taste)
    {
        weiter = true;
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
        while (! weiter)
        {
            try
            {
                wait(100);
            }
            catch (Exception e)
            {
                // nix
            }
        }
        weiter = false;
    }

    /**
     * Macht einen Rekursionsschritt auf dem Weg zur Lösung
     * @param spalte die Spalte, für die eine Position der Dame gesucht wird.
     */
    void SchrittAusführen(int spalte)
    {
        damen.get(spalte).SichtbarkeitSetzen(true);
        for (int zeile = 0; zeile < schachbrett.size(); zeile += 1)
        {
            if (!IstFeldBedroht(zeile, spalte))
            {
                damen.get(spalte).PositionSetzen(zeile, spalte);
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
        damen.get(spalte).SichtbarkeitSetzen(false);
    }
}
