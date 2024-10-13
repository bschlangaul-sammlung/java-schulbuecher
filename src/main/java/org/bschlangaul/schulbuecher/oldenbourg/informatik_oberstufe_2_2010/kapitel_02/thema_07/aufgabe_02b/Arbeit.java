package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02b;

/**
 * Erstellt die Welt und initiert den Ablauf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    private RoboterThread[] polizist, schmuggler;

    /**
     * Baut die Welt auf und plaziert die Roboter.
     */
    Arbeit()
    {
        KarolWelt w;
        Polizist p;
        polizist = new RoboterThread[2];
        schmuggler = new RoboterThread[3];
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
        polizist[0] = new RoboterThread(p);
        polizist[1] = new RoboterThread(new Polizist(2, 20, 'N', w));
        schmuggler[0] = new RoboterThread(new Schmuggler(5, 5, 'W', w));
        schmuggler[1] = new RoboterThread(new Schmuggler(5, 10, 'W', w));
        schmuggler[2] = new RoboterThread(new Schmuggler(5, 15, 'W', w));
    }

    /**
     * Startet die Bewegung der Roboter.
     */
    void Ausfuhren()
    {
        for (int i = 0; i < schmuggler.length; i++)
        {
            schmuggler[i].start();
        }
        for (int i = 0; i < polizist.length; i++)
        {
            polizist[i].start();
        }
    }
}
