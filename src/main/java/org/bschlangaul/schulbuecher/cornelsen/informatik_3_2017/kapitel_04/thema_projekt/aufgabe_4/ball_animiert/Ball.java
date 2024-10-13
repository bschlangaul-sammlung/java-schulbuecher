package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_4.ball_animiert;

/**
 * Repräsentiert einen einfachen Ball
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Ball extends SPIEL
{
    private KREIS k;

    private long zaehler;

    private double vx, vy;

    private KREIS hindernis;

    /**
     * Ball Konstruktor
     *
     * @param farbe Der Farbname des Balls
     *
     */
    public Ball(String farbe)
    {
        this.k = new KREIS(1);
        this.k.setzeFarbe(farbe);
        super.zeigeKoordinatensystem(true);
        this.zaehler = 0;
        this.vx = 0.1;
        this.vy = 0.05;
        this.k.macheAktiv();
        super.setzeSchwerkraft(0);
    }

    /**
     * Ball Konstruktor
     *
     */
    public Ball()
    {
        this("gruen");
    }

    /**
     * Setzt die Schrittweiten und damit Richtung und Geschwindigkeit auf einen
     * neuen Wert.
     *
     * @param vx Grafikfenster-Einheiten in x-Richtung pro Bewegungs-Schritt
     * @param vy Grafikfenster-Einheiten in x-Richtung pro Bewegungs-Schritt
     */
    public void setzeSchrittweite(double vx, double vy)
    {
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * Dreht die Richtung des Balles ums
     */
    public void umdrehen()
    {
    }

    /**
     * Nennt die aktuelle Schrittweite in Grafikfenster-Einheiten der Bewegung
     * in x-Richtung.
     *
     * @return Wert der aktuellen Schrittweite in x-Richtung
     */
    public double nenneSchrittweiteX()
    {
        return this.vx;
    }

    /**
     * Nennt die aktuelle Schrittweite in Grafikfenster-Einheiten der Bewegung
     * in y-Richtung.
     *
     * @return Wert der aktuellen Schrittweite in y-Richtung
     */
    public double nenneSchrittweiteY()
    {
        return this.vy;
    }

    /**
     * verschiebt den Ball um die eingestellte Schrittweite. Siehe Methode
     * setzeSchrittweite.
     *
     */
    public void bewegen()
    {
        this.k.verschiebenUm(this.vx, this.vy);
    }

    /**
     * Gibt den aktuellen Wert der Kittelpunkt-x-Koordinate des Balls zurueck.
     * <p>
     * return aktueller Wert der Mittelpunkt-x-Koordinate
     *
     */
    public double nenneMittelpunktX()
    {
        return this.k.nenneMittelpunktX();
    }

    /**
     * Gibt den aktuellen Wert der Kittelpunkt-y-Koordinate des Balls zurueck.
     * <p>
     * return aktueller Wert der Mittelpunkt-y-Koordinate
     *
     */
    public double nenneMittelpunktY()
    {
        return this.k.nenneMittelpunktY();
    }

    /**
     * Methode zum Ueberschreiben in einer Unterklasse. Die Methode wird nach
     * dem Starten des Ticker-Systems in regelmaessigen Zeitabstaenden immer
     * wieder automatisch aufgerufen. ! ! ! Die Dauer fuer die Ausfuehrung des
     * Rumpfes darf NICHT laenger sein als die Dauer zwischen zwei
     * aufeinanderfolgenden Ticks !!!
     *
     */
    @Override
    public void tick()
    {
        zaehler++;
        System.out.print(zaehler + ". ");
        super.tick();
    }

    @Override
    public void stoppeTicker()
    {
        super.stoppeTicker();
    }

    @Override
    public void starteTickerNeu(double sekunden)
    {
        super.starteTickerNeu(sekunden);
    }

    @Override
    public void zeigeKoordinatensystem(boolean zeigen)
    {
        super.zeigeKoordinatensystem(zeigen);
    }

    public void zeigeHindernis(boolean zeigen)
    {
        this.hindernis = new KREIS(2);
        this.hindernis.setzeMittelpunkt(0, 0);
        this.hindernis.machePassiv();
        this.hindernis.setzeElastizitaet(1);
    }
}
