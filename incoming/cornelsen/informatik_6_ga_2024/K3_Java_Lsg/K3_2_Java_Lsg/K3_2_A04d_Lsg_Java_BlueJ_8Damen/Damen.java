
import java.util.*;
/**
 * Löst das Problem der 8 Damen
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Damen  extends Ereignisbehandlung
{
    /**
     * Das Brett zum Suchen der Lösung */
    private ArrayList<ArrayList<Boolean>> schachbrett;
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

        schachbrett = new ArrayList<ArrayList<Boolean>>();
        for (int zeile = 0; zeile < 8; zeile += 1)
        {
            schachbrett.add(new ArrayList<Boolean>());
            for (int spalte = 0; spalte < 8; spalte += 1)
            {
                schachbrett.get(zeile).add(false);
            }
        }
        SchrittAusführen(0);
    }

    /**
     * Die Aktionsmethode für gedrückte Tasten.
     * @param taste die gedrückte Taste
     */
    @Override void TasteGedrückt (char taste)
    {
        weiter = true;
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     * @param taste KeyCode der gedrückten Taste
     */
    @Override void SonderTasteGedrückt (int taste)
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
        int aktspalte = spalte - 1;
        while (aktspalte >= 0)
        {
            if (schachbrett.get(zeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
        }
        aktspalte = spalte - 1;
        int aktzeile = zeile - 1;
        while ((aktspalte >= 0) && (aktzeile >= 0))
        {
            if (schachbrett.get(aktzeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
            aktzeile -= 1;
        }
        aktspalte = spalte - 1;
        aktzeile = zeile + 1;
        while ((aktspalte >= 0) && (aktzeile < schachbrett.size()))
        {
            if (schachbrett.get(aktzeile).get(aktspalte))
            {
                return true;
            }
            aktspalte -= 1;
            aktzeile += 1;
        }
        return false;
    }

    /**
     * Gibt die gefundene Lösung aus.
     */
    void LösungAusgeben()
    {
        while (!weiter)
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
                schachbrett.get(zeile).set(spalte, true);
                if (spalte == schachbrett.size() - 1)
                {
                    LösungAusgeben();
                }
                else
                {
                    SchrittAusführen(spalte + 1);
                }
                schachbrett.get(zeile).set(spalte, false);
            }
        }
        damen.get(spalte).SichtbarkeitSetzen(false);
    }
}
