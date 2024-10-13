package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_7.jump_n_run;

/**
 * Beschreiben Sie hier die Klasse Stern.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stern
{
    private DREIECK d1, d2;

    public Stern(double x, double y)
    {
        this.d1 = new DREIECK(0, 0.5, 1, 2, 2, 0.5);
        this.d1.setzeMittelpunkt(x, y + 0.5);
        this.d1.setzeFarbe("gelb");
        this.d2 = new DREIECK(0, 1.5, 1, 0, 2, 1.5);
        this.d2.setzeMittelpunkt(x, y);
        this.d2.setzeFarbe("gelb");
    }

    /**
     * Prueft ob der Stern gerade eine andere Spielfigur beruehrt.
     *
     * @param ea Die andere Speilfigur
     *
     * @return true = beruehrt die andere Figur ; false = beruehrt sie nicht
     */
    public boolean beruehrt(ea.edu.EduActor ea)
    {
        return (this.d1.beruehrt(ea) || this.d2.beruehrt(ea));
    }
}
