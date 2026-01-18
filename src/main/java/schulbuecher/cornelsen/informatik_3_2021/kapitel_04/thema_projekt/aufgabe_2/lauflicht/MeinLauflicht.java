package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_2.lauflicht;

/**
 * Erweiterung der Klasse LAUFLICHT um zusätliche Methoden
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeinLauflicht extends Lauflicht
{
    public MeinLauflicht()
    {
        super();
    }

    public void geradeAn()
    {
        super.licht(0, true);
        super.licht(2, true);
        super.licht(4, true);
        super.licht(6, true);
    }

    public void geradeAus()
    {
        super.licht(0, false);
        super.licht(2, false);
        super.licht(4, false);
        super.licht(6, false);
    }

    public void ungeradeAn()
    {
        super.licht(1, true);
        super.licht(3, true);
        super.licht(5, true);
        super.licht(7, true);
    }

    public void ungeradeAus()
    {
        super.licht(1, false);
        super.licht(3, false);
        super.licht(5, false);
        super.licht(7, false);
    }

    public void alleAn()
    {
        this.geradeAn();
        this.ungeradeAn();
    }

    public void alleAus()
    {
        this.geradeAus();
        this.ungeradeAus();
    }

    public void flash()
    {
        this.alleAus();
        this.geradeAn();
        super.warte(0.1);
        this.geradeAus();
        super.warte(0.1);
        this.ungeradeAn();
        super.warte(0.1);
        this.ungeradeAus();
        super.warte(0.1);
        this.alleAus();
        this.geradeAn();
        super.warte(0.1);
        this.geradeAus();
        super.warte(0.1);
        this.ungeradeAn();
        super.warte(0.1);
        this.ungeradeAus();
        super.warte(0.1);
        this.alleAus();
        this.geradeAn();
        super.warte(0.1);
        this.geradeAus();
        super.warte(0.1);
        this.ungeradeAn();
        super.warte(0.1);
        this.ungeradeAus();
        super.warte(0.1);
        this.alleAus();
    }

    public void LaufNachRechts()
    {
        this.alleAus();
        super.licht(0, true);
        super.warte(0.1);
        super.licht(0, false);
        super.licht(1, true);
        super.warte(0.1);
        super.licht(1, false);
        super.licht(2, true);
        super.warte(0.1);
        super.licht(2, false);
        super.licht(3, true);
        super.warte(0.1);
        super.licht(3, false);
        super.licht(4, true);
        super.warte(0.1);
        super.licht(4, false);
        super.licht(5, true);
        super.warte(0.1);
        super.licht(5, false);
        super.licht(6, true);
        super.warte(0.1);
        super.licht(6, false);
        super.licht(7, true);
        super.warte(0.1);
        super.licht(7, false);
    }

    public void LaufNachLinks()
    {
        this.alleAus();
        super.licht(7, true);
        super.warte(0.1);
        super.licht(7, false);
        super.licht(6, true);
        super.warte(0.1);
        super.licht(6, false);
        super.licht(5, true);
        super.warte(0.1);
        super.licht(5, false);
        super.licht(4, true);
        super.warte(0.1);
        super.licht(4, false);
        super.licht(3, true);
        super.warte(0.1);
        super.licht(3, false);
        super.licht(2, true);
        super.warte(0.1);
        super.licht(2, false);
        super.licht(1, true);
        super.warte(0.1);
        super.licht(1, false);
        super.licht(0, true);
        super.warte(0.1);
        super.licht(0, false);
    }
}
