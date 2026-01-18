package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_3.ampel;

/**
 * Darstellung einer Verkehrsampel mit den drei Lichtern rot, gelb und grün.
 *
 * @author Mike Ganshorn (Mike_gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class Ampel extends SPIEL
{
    private RECHTECK box;

    private KREIS rot, gelb, gruen;

    /**
     * Ampel Konstruktor
     *
     */
    public Ampel()
    {
        super(300, 500);
        this.box = new RECHTECK(4, 12);
        this.box.setzeMittelpunkt(0, 0);
        this.box.setzeFarbe("hellgrau");
        this.box.setzeEbenenposition(1);
        this.rot = new KREIS(1.8);
        this.rot.setzeMittelpunkt(0, 4);
        this.rot.setzeFarbe("rot");
        this.rot.setzeEbenenposition(2);
        this.gelb = new KREIS(1.8);
        this.gelb.setzeMittelpunkt(0, 0);
        this.gelb.setzeFarbe("gelb");
        this.gelb.setzeEbenenposition(2);
        this.gruen = new KREIS(1.8);
        this.gruen.setzeMittelpunkt(0, -4);
        this.gruen.setzeFarbe("gruen");
        this.gruen.setzeEbenenposition(2);
    }

    /**
     * Schaltet das grüne Licht an bzw. aus.
     *
     * @param an true = an ; false = aus
     */
    public void gruen(boolean an)
    {
        if (an)
        {
            this.gruen.setzeFarbe("gruen");
        }
        else
        {
            this.gruen.setzeFarbe("dunkelgrau");
        }
    }

    /**
     * Schaltet das gelbe Licht an bzw. aus.
     *
     * @param an true = an ; false = aus
     */
    public void gelb(boolean an)
    {
        if (an)
        {
            this.gelb.setzeFarbe("gelb");
        }
        else
        {
            this.gelb.setzeFarbe("dunkelgrau");
        }
    }

    /**
     * Schaltet das rote Licht an bzw. aus.
     *
     * @param an true = an ; false = aus
     */
    public void rot(boolean an)
    {
        if (an)
        {
            this.rot.setzeFarbe("rot");
        }
        else
        {
            this.rot.setzeFarbe("dunkelgrau");
        }
    }

    /**
     * Wartet eine bestimmte Zeit, bis der naechste Methodenaufruf ausgeführt
     * wird.
     *
     * @param sekunden Die zu wartende Zeit in Sekunden (z.B. 0.05 fuer 5
     *     Hundertstel Sekunden)
     */
    @Override
    public void warte(double sekunden)
    {
        super.warte(sekunden);
    }

    /**
     * Methode zu Ueberschreiben in einer Unterklasse. Wird beim Druecken einer
     * Taste am Keyboard des Computers automatisch aufgerufen. Ihr wird
     * automatisch eine Nummer uebergeben. Fuer die Nummern gibt es sprechende
     * Konstanten wie TASTE.A , Taste._1, Taste.LEERTASTE, ... siehe Klasse
     * TASTE !!!
     *
     * @param tastenCode Ein Parameter
     */
    @Override
    public void tasteReagieren(int tastenCode)
    {
        super.tasteReagieren(tastenCode);
    }
    // ----------------------------------------------------------------------------------
    // In Verbindung mit der Methode warte(...) sollte tick() NIE aufgerufen
    // werden !!!
    // ----------------------------------------------------------------------------------
    // @Override
    // public void tick()
    // {
    // super.tick();
    // }
    // @Override
    // public void stoppeTicker()
    // {
    // super.stoppeTicker();
    // }
    // @Override
    // public void starteTickerNeu( double sekunden )
    // {
    // super.starteTickerNeu( sekunden );
    // }
}
