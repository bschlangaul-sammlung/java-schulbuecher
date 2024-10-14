package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_2.lauflicht;

/**
 * Lauflicht bestehend aus 8 Lichtern, die einzeln geschaltet werden können.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Lauflicht extends SPIEL
{
    private RECHTECK box;

    private KREIS[] lichter;

    private String farbe;

    /**
     * Lauflicht Konstruktor
     *
     */
    public Lauflicht()
    {
        super(1000, 200);
        this.box = new RECHTECK(32, 4);
        this.box.setzeMittelpunkt(0, 0);
        this.box.setzeFarbe("hellgrau");
        this.box.setzeEbenenposition(1);
        this.lichter = new KREIS[8];
        for (int i = 0; i < 8; i++)
        {
            this.lichter[i] = new KREIS(1.8);
            this.lichter[i].setzeFarbe("dunkelgrau");
            this.lichter[i].setzeMittelpunkt(-14 + 4 * i, 0);
            this.lichter[i].setzeEbenenposition(2);
        }
        this.farbe = "gelb";
    }

    /**
     * Schaltet einzelne Lichter des Lauflichts ein oder aus.
     *
     * @param i Nummer des Lauflichts (0-7)
     * @param an true = an ; false = aus
     */
    public void licht(int i, boolean an)
    {
        if (an)
        {
            this.lichter[i].setzeFarbe(farbe);
        }
        else
        {
            this.lichter[i].setzeFarbe("dunkelgrau");
        }
    }

    /**
     * Setzt die Farbe in der aktuell die Lichter eingeschaltet werden.
     *
     * @param farbe Der Name der gewuenschten Farbe
     */
    public void setzeLichtfarbe(String farbe)
    {
        this.farbe = farbe;
    }

    /**
     * Wartet die angegebene Zeit, bis der naechste Methodenaufruf ausgefuehrt
     * wird.
     *
     * @param sekunden Dauer in Sekunden (z.B. 0.05 fuer 5 Hunderstel Sekunden)
     */
    @Override
    public void warte(double sekunden)
    {
        super.warte(sekunden);
    }

    /**
     * Erzeugt eine ganzzahlige Zufallszahl.
     *
     * @param von kleinste Zufallszahl (inklusive)
     * @param bis groesste Zufallszahl (inklusive)
     *
     * @return Die erzeugte Zufallszahl
     */
    @Override
    public int zufallszahlVonBis(int von, int bis)
    {
        return super.zufallszahlVonBis(von, bis);
    }
}
