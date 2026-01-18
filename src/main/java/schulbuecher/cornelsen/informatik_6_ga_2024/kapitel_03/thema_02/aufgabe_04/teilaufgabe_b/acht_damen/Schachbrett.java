package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_02.aufgabe_04.teilaufgabe_b.acht_damen;

import java.util.ArrayList;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Verwaltet das Schachbrett und die Damen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Schachbrett
{
    /**
     * Referenz auf die Felder des Brettes
     */
    private ArrayList<ArrayList<Rechteck>> brett;

    /**
     * Legt das Schachbrett und die Damen an.
     */
    Schachbrett()
    {
        brett = new ArrayList<ArrayList<Rechteck>>();
        for (int zeile = 0; zeile < 8; zeile += 1)
        {
            brett.add(new ArrayList<Rechteck>());
            for (int spalte = 0; spalte < 8; spalte += 1)
            {
                brett.get(zeile).add(new Rechteck());
                brett.get(zeile).get(spalte).GrößeSetzen(50, 50);
                brett.get(zeile).get(spalte).PositionSetzen(50 + spalte * 50,
                        400 - zeile * 50);
                brett.get(zeile).get(spalte).FarbeSetzen(
                        ((spalte + zeile) % 2 == 0 ? "schwarz" : "weiß"));
            }
        }
    }

    /**
     * Steuert die Sichtbarkeit des Schachbretts
     *
     * @param sichtbar wenn wahr, wird das Brett angezeigt
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        for (int zeile = 0; zeile < 8; zeile += 1)
        {
            for (int spalte = 0; spalte < 8; spalte += 1)
            {
                brett.get(zeile).get(spalte).SichtbarkeitSetzen(sichtbar);
            }
        }
    }
}
