package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_09.tuerme_von_hanoi;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Stellt eine Scheibe des Turms auf dem Bildschirm dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ScheibenSymbol
{
    /**
     * Basisgröße der Scheiben
     */
    static final int basis = 20;

    /**
     * Der Außenrand
     */
    private Rechteck außen;

    /**
     * Der Innenrand
     */
    private Rechteck innen;

    /**
     * Breite der Scheibe
     */
    @SuppressWarnings("unused")
    private int breite;

    /**
     * x-Position der Scheibe
     */
    private int x;

    /**
     * y-Position der Scheibe
     */
    private int y;

    /**
     * Legt die beiden Rechtecke an und positioniert Sie auf Turm 1
     *
     * @param nummer die Scheibennummer
     */
    ScheibenSymbol(int nummer)
    {
        x = 0;
        y = 0;
        breite = basis * nummer;
        außen = new Rechteck();
        außen.FarbeSetzen("schwarz");
        außen.GrößeSetzen(basis * nummer, basis);
        innen = new Rechteck();
        innen.FarbeSetzen("rot");
        innen.GrößeSetzen(basis * nummer - 2, basis - 2);
        PositionSetzen(1, 1);
    }

    /**
     * Setzt die Position bei der Lage in einem Turm.
     *
     * @param turmNummer Nummer des Turms
     * @param scheibenNummer Nummer der Scheibe von unten her ab 1.
     */
    void PositionSetzen(int turmNummer, int scheibenNummer)
    {
        int abstand = Darstellung.turmAbstand;
        x = abstand / 2 + abstand * turmNummer - außen.breite / 2;
        y = Darstellung.bodenPosition - basis * (scheibenNummer + 1);
        außen.PositionSetzen(x, y);
        innen.PositionSetzen(x + 1, y + 1);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach oben.
     */
    void Anheben()
    {
        y -= 2;
        außen.PositionSetzen(x, y);
        innen.PositionSetzen(x + 1, y + 1);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach unten.
     */
    void Absenken()
    {
        y += 2;
        außen.PositionSetzen(x, y);
        innen.PositionSetzen(x + 1, y + 1);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach links.
     */
    void LinksFahren()
    {
        x -= 2;
        außen.PositionSetzen(x, y);
        innen.PositionSetzen(x + 1, y + 1);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach rechts.
     */
    void RechtsFahren()
    {
        x += 2;
        außen.PositionSetzen(x, y);
        innen.PositionSetzen(x + 1, y + 1);
    }
}
