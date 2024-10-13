package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_1.bouncer;

/**
 * Klasse Ball. wirke* @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Ball
{
    private KREIS k;

    private boolean aktiv;

    /**
     * Ball Konstruktor
     *
     */
    public Ball()
    {
        this.k = new KREIS(0.5);
        this.k.setzeMittelpunkt(0, 5);
        SPIEL.zeigeKoordinatensystem(true);
        this.aktiv = false;
        this.k.setzeRotationBlockiert(false);
    }

    /**
     * Unterwirft das Objekt den Gesetzen der Schwerkraft. Aktive Objekt können
     * außerdem keine passiven Objekte durchdringen.
     *
     */
    public void macheAktiv()
    {
        this.k.macheAktiv();
        this.aktiv = true;
    }

    /**
     * Beeinflusst das "Bremsen" beim "Rutschen" auf einem anderen Objekt.
     *
     * @param Reibungsköffizient 0 = perfektes Glatteis ; hoehere Werte bremsen
     *     besser
     */
    public void setzeReibung(double Reibungsköffizient)
    {
        double x = this.k.nenneMittelpunktX();
        double y = this.k.nenneMittelpunktY();
        double r = this.k.nenneRadius();
        String farbe = this.k.nenneFarbe();
        this.k.setzeSichtbar(false);
        this.k = new KREIS(r);
        this.k.setzeFarbe(farbe);
        this.k.setzeMittelpunkt(x, y);
        this.k.setzeReibung(Reibungsköffizient);
        this.k.setzeRotationBlockiert(false);
        if (this.aktiv)
        {
            this.k.macheAktiv();
        }
    }

    public void setzeElastizitaet(double Elastizitaet)
    {
        this.k.setzeElastizitaet(Elastizitaet);
    }

    public void setzeFarbe(String farbe)
    {
        this.k.setzeFarbe(farbe);
    }

    public void setzeRadius(double radius)
    {
        this.k.setzeRadius(radius);
    }

    public void wirkeImpuls(double x, double y)
    {
        this.k.wirkeImpuls(x, y);
    }

    public void setzeMittelpunkt(double x, double y)
    {
        this.k.setzeGeschwindigkeit(0, 0);
        this.k.setzeMittelpunkt(x, y);
    }
}
