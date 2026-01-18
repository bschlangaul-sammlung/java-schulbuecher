package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_1.bouncer;

/**
 * Klasse Boden.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Boden
{
    RECHTECK r;

    /**
     * Boden Konstruktor
     *
     */
    public Boden()
    {
        this.r = new RECHTECK(10, 0.5);
        this.r.setzeFarbe("gelb");
        SPIEL.zeigeKoordinatensystem(true);
    }

    /**
     * Aendert die Farbe des Bodens.
     *
     * @param farbe Name der neuen Farbe
     */
    public void setzeFarbe(String farbe)
    {
        this.r.setzeFarbe(farbe);
    }

    /**
     * Verschiebt den Boden auf einen neuen Ort.
     *
     * @param x neue x-Koordinate des Mittelpunkts
     * @param y neue y-Koordinate des Mittelpunkts
     */
    public void setzeMittelpunkt(double x, double y)
    {
        this.r.setzeMittelpunkt(x, y);
    }

    /**
     * Aendert die Breite und / oder Hoehe des Bodens.
     *
     * @param breite Die neue Breite
     * @param hoehe Die neue Hoehe
     */
    public void setzeGroesse(double breite, double hoehe)
    {
        this.r.setzeGroesse(breite, hoehe);
    }

    /**
     * Macht den Boden undurchdringbar fuer andere AKTIVE Objekte.
     *
     */
    public void machePassiv()
    {
        this.r.machePassiv();
    }

    /**
     * Setze die Elastizitaet des Bodens bzgl. auftreffende AKTIVE Objekte.
     *
     * @param Elastizitaet In der Regel Werte zwischen 0 und 1
     */
    public void setzeElastizitaet(double Elastizitaet)
    {
        this.r.setzeElastizitaet(Elastizitaet);
    }

    /**
     * Setzt den Reibungsköffizienten auf einen neuen Wert. Dies beeinflusst
     * z.B. das Ausrollen des Balls auf dem Boden.
     *
     * @param Reibungsköffizient In der Regel Werte zwischen 0 und 1
     */
    public void setzeReibung(double Reibungsköffizient)
    {
        double x = this.r.nenneMittelpunktX();
        double y = this.r.nenneMittelpunktY();
        double b = this.r.nenneBreite();
        double h = this.r.nenneHoehe();
        String farbe = this.r.nenneFarbe();
        this.r.setzeSichtbar(false);
        this.r = new RECHTECK(b, h);
        this.r.setzeFarbe(farbe);
        this.r.setzeMittelpunkt(x, y);
        this.r.setzeReibung(Reibungsköffizient);
    }
}
