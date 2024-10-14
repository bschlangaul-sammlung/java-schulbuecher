/**
 * Verwaltet den Kran
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Kran
{
    /**
     * Der Querträger */
    private Rechteck träger;
    /**
     * Das Seil */
    private Rechteck seil;
    /**
     * Der Fanghaken */
    private Rechteck haken;
     /**
     * Das linke Rad */
    private Kreis rad1;
     /**
     * Das rechte Rad */
    private Kreis rad2;
    /**
     * x-Position des Krans */
    private int x;
    /**
     * y-Position des Fanghakens */
    private int y;

    /**
     * Legt die Figuren an und positioniert den Kran über auf Turm 1
     */
    Kran ()
    {
        x = Darstellung.turmAbstand / 2 - 15;
        y = 100;
        träger = new Rechteck();
        träger.FarbeSetzen("blau");
        träger.GrößeSetzen(30, 6);
        seil = new Rechteck();
        seil.FarbeSetzen("blau");
        seil.GrößeSetzen(2, y - 60);
        haken = new Rechteck();
        haken.FarbeSetzen("blau");
        haken.GrößeSetzen(10, 2);
        rad1 = new Kreis();
        rad1.FarbeSetzen("blau");
        rad1.RadiusSetzen(5);
        rad2 = new Kreis();
        rad2.FarbeSetzen("blau");
        rad2.RadiusSetzen(5);
        PositionSetzen(0);
    }

    /**
     * Setzt die Position bei der Lage in einem Turm.
     * @param turmNummer Nummer des Turms
     */
    void PositionSetzen (int turmNummer)
    {
        x = Darstellung.turmAbstand / 2  + turmNummer * Darstellung.turmAbstand - 15;
        träger.PositionSetzen(x, 57);
        seil.PositionSetzen(x + 14, 60);
        seil.GrößeSetzen(2, y - 60);
        haken.PositionSetzen(x + 10, y - 2);
        rad1.PositionSetzen(x, 60);
        rad2.PositionSetzen(x + 30, 60);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach oben.
     */
    void Anheben ()
    {
        y -= 2;
        träger.PositionSetzen(x, 57);
        seil.PositionSetzen(x + 14, 60);
        seil.GrößeSetzen(2, y - 60);
        haken.PositionSetzen(x + 10, y - 2);
        rad1.PositionSetzen(x, 60);
        rad2.PositionSetzen(x + 30, 60);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach unten.
     */
    void Absenken ()
    {
        y += 2;
        träger.PositionSetzen(x, 57);
        seil.PositionSetzen(x + 14, 60);
        seil.GrößeSetzen(2, y - 60);
        haken.PositionSetzen(x + 10, y - 2);
        rad1.PositionSetzen(x, 60);
        rad2.PositionSetzen(x + 30, 60);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach links.
     */
    void LinksFahren ()
    {
        x -= 2;
        träger.PositionSetzen(x, 57);
        seil.PositionSetzen(x + 14, 60);
        haken.PositionSetzen(x + 10, y - 2);
        rad1.PositionSetzen(x, 60);
        rad2.PositionSetzen(x + 30, 60);
    }

    /**
     * Bewegt die Scheibe um zwei Punkte nach rechts.
     */
    void RechtsFahren ()
    {
        x += 2;
        träger.PositionSetzen(x, 57);
        seil.PositionSetzen(x + 14, 60);
        haken.PositionSetzen(x + 10, y - 2);
        rad1.PositionSetzen(x, 60);
        rad2.PositionSetzen(x + 30, 60);
    }

    /**
     * Gibt die x-Position des Krans bezogen auf die Seilmitte
     * @return Kranposition
     */
    int KranpositionGeben()
    {
        return x + 15;
    }

    /**
     * Gibt die y-Position der Unterkante des Kranhakens
     * @return Kranhöhe
     */
    int KranhöheGeben()
    {
        return y;
    }
}
