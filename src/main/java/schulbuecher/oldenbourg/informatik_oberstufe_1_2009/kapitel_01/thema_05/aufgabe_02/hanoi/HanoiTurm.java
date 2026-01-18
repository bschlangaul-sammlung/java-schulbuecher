package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_02.hanoi;

/**
 * Klasse zur Verwaltung eines Hanoiturms
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class HanoiTurm
{
    /**
     * Position des Turms
     */
    private int xpos, ypos;

    /**
     * Nutzung der Datenstruktur Stapel
     */
    private Stapel stapel;

    /**
     * Konstruktor Setzt die Position des Hanoiturms und erzeugt den Stapel x
     * neue x-Position des Turms auf dem Fenster y neue y-Position des Turms auf
     * dem Fenster
     */
    public HanoiTurm(int x, int y)
    {
        xpos = x;
        ypos = y;
        stapel = new Stapel();
    }

    /**
     * Fügt eine Scheibe auf dem Hanoiturm ein und setzt diese auf die passende
     * Position
     *
     * @param s einzufügende Scheibe
     */
    public void Einfuegen(Scheibe s)
    {
        stapel.VorneEinfuegen(s);
        s.PositionSetzen(xpos, ypos - 10 * stapel.LaengeGeben());
    }

    /**
     * Entfernt die oberste Scheibe
     *
     * @return oberste Scheibe
     */
    public Scheibe Entfernen()
    {
        DatenElement d;
        d = stapel.AnfangEntfernen();
        return (Scheibe) d;
    }

    /**
     * Entfernt rekursiv alle Scheiben vom Turm und informiert Scheiben darüber
     *
     */
    void Loeschen()
    {
        if (stapel.LaengeGeben() != 0)
        {
            DatenElement d;
            d = stapel.AnfangEntfernen();
            ((Scheibe) d).Entfernen();
            Loeschen();
        }
    }
}
