package schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_7.jump_n_run;

/**
 * Klasse JumpRun. Vorlage für ein Jump and Run Spiel.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class JumpRun extends SPIEL
{
    private RECHTECK boden, wand, deckel, links1, links2, links3, rechts1,
            rechts2, rechts3, mitte;

    private DREIECK waechterLinks, waechterRechts;

    private KREIS kreisel;

    private FIGUR spieler;

    private Stern stern;

    private double reibung;

    private TEXT anzeige, ende;

    private Kugel kugel1, kugel2;

    /**
     * JumpRun Konstruktor
     *
     */
    public JumpRun()
    {
        super(1350, 900);
        // super.zeigeKoordinatensystem( true );
        this.boden = new RECHTECK(50, 0.5);
        this.boden.machePassiv();
        this.reibung = 0.3;
        this.boden.setzeMittelpunkt(0, -14.5);
        this.boden.setzeFarbe("lila");
        this.boden.setzeReibung(this.reibung);
        this.wand = new RECHTECK(0.5, 21);
        this.wand.machePassiv();
        this.wand.setzeMittelpunkt(-22, -4);
        this.wand.setzeFarbe("lila");
        this.deckel = new RECHTECK(20, 0.5);
        this.deckel.machePassiv();
        this.deckel.setzeMittelpunkt(5, 10);
        this.deckel.setzeFarbe("lila");
        this.deckel.setzeReibung(reibung);
        this.links1 = new RECHTECK(9.5, 0.5);
        this.links1.machePassiv();
        this.links1.setzeMittelpunkt(-17, -8);
        this.links1.setzeFarbe("lila");
        this.links1.setzeReibung(reibung);
        this.links2 = new RECHTECK(7.5, 0.5);
        this.links2.machePassiv();
        this.links2.setzeMittelpunkt(-10, -2);
        this.links2.setzeFarbe("lila");
        this.links2.setzeReibung(reibung);
        this.links3 = new RECHTECK(10, 0.5);
        this.links3.machePassiv();
        this.links3.setzeMittelpunkt(-4, 4);
        this.links3.setzeFarbe("lila");
        this.links3.setzeReibung(reibung);
        this.mitte = new RECHTECK(8.5, 0.5);
        this.mitte.machePassiv();
        this.mitte.setzeMittelpunkt(4, -2);
        this.mitte.setzeFarbe("lila");
        this.mitte.setzeReibung(reibung);
        this.rechts1 = new RECHTECK(8.5, 0.5);
        this.rechts1.machePassiv();
        this.rechts1.setzeMittelpunkt(10, -8);
        this.rechts1.setzeFarbe("lila");
        this.rechts1.setzeReibung(reibung);
        this.rechts2 = new RECHTECK(6, 0.5);
        this.rechts2.machePassiv();
        this.rechts2.setzeMittelpunkt(17, -2);
        this.rechts2.setzeFarbe("lila");
        this.rechts2.setzeReibung(reibung);
        this.rechts3 = new RECHTECK(5, 0.5);
        this.rechts3.machePassiv();
        this.rechts3.setzeMittelpunkt(20, 4);
        this.rechts3.setzeFarbe("lila");
        this.rechts3.setzeReibung(reibung);
        this.stern = new Stern(5, 11.2);
        this.kreisel = new KREIS(0.4);
        this.kreisel.setzeFarbe("magenta");
        this.kreisel.setzeMittelpunkt(17, -1);
        this.kreisel.animiereKreis(2.5, 17, 1, true, true);
        this.waechterLinks = new DREIECK(4, 11, 2, 11, 3, 10);
        this.waechterLinks.setzeMittelpunkt(2, 11.2);
        this.waechterLinks.setzeFarbe("rot");
        this.waechterLinks.animiereGerade(1.7, -3.5, 11.2, true);
        this.waechterRechts = new DREIECK(4, 11, 2, 11, 3, 10);
        this.waechterRechts.setzeMittelpunkt(8, 11.2);
        this.waechterRechts.setzeFarbe("rot");
        this.waechterRechts.animiereGerade(1.6, 13.5, 11.2, true);
        this.anzeige = new TEXT(-15, 12, 2, 0);
        this.kugel1 = new Kugel(-9, 8, true);
        super.warte(1);
        this.kugel2 = new Kugel(-9, 8, false);
        this.spieler = new FIGUR("spielfigur.png");
        this.spieler.macheAktiv();
        this.spieler.setzeMittelpunkt(0, -10);
        this.spieler.setzeElastizitaet(0);
        this.spieler.setzeReibung(reibung);
        this.spieler.setzeMasse(1);
    }

    /**
     * Wirkt einen Impuls (Kraftstoss) auf den Spieler aus, wenn dieser steht.
     * Kann z.B. zum seitlichen Gleiten und zum Springen genutzt werden.
     *
     * @param x Impuls (Stoss-Staerke) in x-Richtung (Werte > 100)
     * @param y Impuls (Stoss-Staerke) in y-Richtung (Werte > 100)
     */
    public void wirkeImpulsAufSpieler(double x, double y)
    {
        if ((x == 0 && this.spieler.steht()) || (x != 0))
        {
            this.spieler.wirkeImpuls(x, y);
        }
    }

    /**
     * Gibt Ausunft ob der Spieler gerade steht oder sich in der Luft befindet.
     *
     * @return true = steht ; false = in der Luft
     */
    public boolean spielerSteht()
    {
        return this.spieler.steht();
    }

    /**
     * Stoppt die Bewegung des Spielers, wenn dieser nit gerade in der Luft ist.
     *
     */
    public void spielerStoppen()
    {
        if (this.spieler.steht())
        {
            this.spieler.setzeGeschwindigkeit(0, 0);
        }
    }

    /**
     * Gibt Auskunft, ob der Spieler gerade den Kreisel beruehrt.
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean spielerBeruehrtKreisel()
    {
        return this.spieler.beruehrt(this.kreisel);
    }

    /**
     * Gibt Auskunft, ob der Spieler gerade den linken Sternwaechter beruehrt.
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean spielerBeruehrtLinkenWaechter()
    {
        return this.spieler.beruehrt(this.waechterLinks);
    }

    /**
     * Gibt Auskunft, ob der Spieler gerade den rechten Sternwaechter beruehrt.
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean spielerBeruehrtRechtenWaechter()
    {
        return this.spieler.beruehrt(this.waechterRechts);
    }

    /**
     * Gibt Auskunft, ob der Spieler gerade den Stern beruehrt.
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean spielerBeruehrtStern()
    {
        return this.stern.beruehrt(this.spieler);
    }

    /**
     * Gibt Auskunft, ob der Spieler gerade eine der Kugeln beruehrt.
     *
     * @return true = beruehrt ; false = beruehrt nicht
     */
    public boolean spielerBeruehrtKugel()
    {
        return (this.kugel1.beruehrt(this.spieler)
                || this.kugel2.beruehrt(this.spieler));
    }

    /**
     * Startet das Tickersystem.
     *
     * @param sekunden Zeit in Sekunden zwischen den Ticks (z.B. 9.05 fuer 5
     *                 Hundertstel Sekunden)
     */
    public void starteTickerNeu(double sekunden)
    {
        super.starteTickerNeu(sekunden);
    }

    /**
     * Stoppt das Tickersystem.
     *
     */
    public void stoppeTicker()
    {
        super.stoppeTicker();
    }

    public void anzeigeAktualisieren(int wert)
    {
        this.anzeige.setzeInhalt("" + wert);
    }

    /**
     * Zeigt einen "Game Over"-Schriftzug an.
     *
     */
    public void zeigeSpielVerlorenAn()
    {
        this.ende = new TEXT(0, 2, 5, "Game Over");
        this.ende.setzeFarbe("rot");
    }

    /**
     * Zeigt einen "Gewonnen !!!"-Schriftzug an.
     *
     */
    public void zeigeSpielGewonnenAn()
    {
        this.ende = new TEXT(0, 2, 5, "Gewonnen !!!");
        this.ende.setzeFarbe("gruen");
    }
}
