package schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_7.jump_n_run;

/**
 * Klasse KugelRegen.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-29)
 */
public class Kugel
{
    private KREIS kugel;

    private double x, y;

    private boolean nachRechts;

    /**
     * Kugel Konstruktor
     *
     * @param x          x-Koordinate
     * @param y          y-Koordinate
     * @param nachRechts true = nach rechts ; false = nach links
     */
    public Kugel(double x, double y, boolean nachRechts)
    {
        this.x = x;
        this.y = y;
        this.nachRechts = nachRechts;
        this.kugel = new KREIS(1.3);
        this.kugel.setzeMittelpunkt(x, y);
        this.kugel.setzeFarbe("orange");
        this.kugel.setzeElastizitaet(0.7);
        this.kugel.setzeReibung(0.0);
        this.kugel.setzeMasse(100);
        if (nachRechts)
        {
            this.kugel.wirkeImpuls(400, 0);
        }
        else
        {
            this.kugel.wirkeImpuls(-200, 0);
        }
        SPIEL.parallel(() -> this.wiederholen());
        this.kugel.macheAktiv();
    }

    /**
     * Prueft, ob die Kugel ein anderes Objekt beruehrt.
     *
     * @param ea Das andere Objekt
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean beruehrt(ea.edu.EduActor ea)
    {
        return this.kugel.beruehrt(ea);
    }

    /**
     * Sorgt dafuer, dass die Kugel neu geworfen wird, wenn sie ganz nach unten
     * gelangt ist oder still liegt.
     *
     */
    private void wiederholen()
    {
        while (true)
        {
            if (this.kugel.nenneMittelpunktY() < -12 || (Math
                    .abs(this.kugel.nenneGeschwindigkeitX()) < 0.1
                    && Math.abs(this.kugel.nenneGeschwindigkeitY()) < 0.1))
            {
                this.kugel.setzeMittelpunkt(this.x, this.y);
                this.kugel.setzeGeschwindigkeit(0, 0);
                if (this.nachRechts)
                {
                    this.kugel.wirkeImpuls(SPIEL.zufallszahlVonBis(300, 500),
                            0);
                }
                else
                {
                    this.kugel.wirkeImpuls(-SPIEL.zufallszahlVonBis(100, 300),
                            0);
                }
            }
            SPIEL.warte(0.1);
        }
    }
}
