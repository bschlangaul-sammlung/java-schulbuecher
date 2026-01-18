package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_5.pong;

/**
 * Klasse Pong. Vorlage fuer ein Pong-Spiel.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Pong extends SPIEL
{
    private RECHTECK spielerLinks;

    private RECHTECK spielerRechts;

    private KREIS ball;

    private RECHTECK boden;

    private TEXT punkteLinks, punkteRechts;

    private int trefferLinks, trefferRechts;

    public Pong()
    {
        super(800, 600);
        super.zeigeKoordinatensystem(true);
        this.spielerLinks = new RECHTECK(0.3, 3);
        this.spielerLinks.setzeFarbe("gelb");
        this.spielerLinks.setzeMittelpunkt(-12, 0);
        this.spielerRechts = new RECHTECK(0.3, 3);
        this.spielerRechts.setzeFarbe("gelb");
        this.spielerRechts.setzeMittelpunkt(12, 0);
        this.ball = new KREIS(0.5f);
        this.ball.setzeFarbe("blau");
        this.ball.setzeMittelpunkt(0, 0);
        this.boden = new RECHTECK(30, 0.1);
        this.boden.setzeFarbe("rot");
        this.boden.setzeMittelpunkt(0, -9.9);
        this.trefferLinks = 0;
        this.trefferRechts = 0;
        this.punkteLinks = new TEXT(-7.5, 9, 1, this.trefferLinks);
        this.punkteRechts = new TEXT(7.5, 9, 1, this.trefferRechts);
    }

    public void linkenSpielerVerschiebenUm(double x, double y)
    {
        this.spielerLinks.verschiebenUm(x, y);
    }

    public void rechtenSpielerVerschiebenUm(double x, double y)
    {
        this.spielerRechts.verschiebenUm(x, y);
    }

    public void ballSetzeMittelpunkt(double x, double y)
    {
        this.ball.setzeMittelpunkt(x, y);
    }

    public void ballMacheAktiv()
    {
        this.ball.macheAktiv();
    }

    public void linkerSpielerMachePassiv()
    {
        this.spielerLinks.machePassiv();
    }

    public void rechterSpielerMachePassiv()
    {
        this.spielerRechts.machePassiv();
    }

    public void bodenMachePassiv()
    {
        this.boden.machePassiv();
    }

    public void ballSetzeElastizitaet(double prozent)
    {
        this.ball.setzeElastizitaet(prozent);
    }

    public void bodenSetzeElastizitaet(double prozent)
    {
        this.boden.setzeElastizitaet(prozent);
    }

    public void linkerSpielerSetzeElastizitaet(double prozent)
    {
        this.spielerLinks.setzeElastizitaet(prozent);
    }

    public void rechterSpielerSetzeElastizitaet(double prozent)
    {
        this.spielerRechts.setzeElastizitaet(prozent);
    }

    public void ballWirkeImpuls(double x, double y)
    {
        this.ball.wirkeImpuls(x, y);
    }

    public void ballStoppen()
    {
        this.ball.setzeGeschwindigkeit(0, 0);
    }

    public boolean ballBeruehrtSpielerLinks()
    {
        return this.ball.beruehrt(this.spielerLinks);
    }

    public boolean ballBeruehrtSpielerRechts()
    {
        return this.ball.beruehrt(this.spielerRechts);
    }

    public double ballNenneMittelpunktX()
    {
        return this.ball.nenneMittelpunktX();
    }

    public double ballNenneMittelpunktY()
    {
        return this.ball.nenneMittelpunktY();
    }

    public double linkerSpielerNenneMittelpunktX()
    {
        return this.spielerLinks.nenneMittelpunktX();
    }

    public double linkerSpielerNenneMittelpunktY()
    {
        return this.spielerLinks.nenneMittelpunktY();
    }

    public double rechterSpielerNenneMittelpunktX()
    {
        return this.spielerRechts.nenneMittelpunktX();
    }

    public double rechterSpielerNenneMittelpunktY()
    {
        return this.spielerRechts.nenneMittelpunktY();
    }

    public int zufallszahlVonBis(int kleinsterWert, int groessterWert)
    {
        return super.zufallszahlVonBis(kleinsterWert, groessterWert);
    }

    public void erhoehePunktestandLinks()
    {
        this.trefferLinks++;
        this.punkteLinks.setzeInhalt("" + this.trefferLinks);
    }

    public void erhoehePunktestandRechts()
    {
        this.trefferRechts++;
        this.punkteRechts.setzeInhalt("" + this.trefferRechts);
    }

    public void zeigeKoordinaten(boolean zeigen)
    {
        SPIEL.zeigeKoordinatensystem(zeigen);
    }

    public void starteTickerNeu(double sekunden)
    {
        super.starteTickerNeu(sekunden);
    }

    public void stoppeTicker()
    {
        super.stoppeTicker();
    }

    @Override
    public void tick()
    {
        super.tick();
    }

    @Override
    public void tasteReagieren(int tastenCode)
    {
        super.tasteReagieren(tastenCode);
    }
}
