package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02a;

/**
 * Erstellt die Welt und initiert den Ablauf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    private RoboterThread polizist, schmuggler;

    /**
     * Baut die Welt auf und plaziert die Roboter.
     */
    Arbeit()
    {
        KarolWelt w;
        Polizist p;
        w = new KarolWelt(5, 20, 4);
        p = new Polizist(2, 1, 'S', w);
        while (!p.IstWand())
        {
            p.MarkeSetzen();
            p.Schritt();
        }
        p.MarkeSetzen();
        p.RechtsDrehen();
        p.RechtsDrehen();
        while (!p.IstWand())
        {
            p.Schritt();
        }
        p.RechtsDrehen();
        p.RechtsDrehen();
        polizist = new RoboterThread(p);
        schmuggler = new RoboterThread(new Schmuggler(5, 10, 'W', w));
    }

    /**
     * Startet die Bewegung der Roboter.
     */
    void Ausfuhren()
    {
        schmuggler.start();
        polizist.start();
    }
}
