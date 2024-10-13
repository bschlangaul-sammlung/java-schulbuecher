package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_01;

/**
 * Erledigt die Arbeit.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Arbeit
{
    RoboterThread[] threads;

    TanzWelt w;

    /**
     * Legt die Roboterthreads an.
     *
     * @param anzahl Anzahl der Roboter
     * @param schritte Anzahl der Tanzschritte
     */
    Arbeit(int anzahl, int schritte)
    {
        threads = new RoboterThread[anzahl];
        w = new TanzWelt(anzahl, anzahl, 5);
        for (int i = 0; i < anzahl; i++)
        {
            threads[i] = new RoboterThread(
                    new TanzRoboter(i + 1, i + 1, 'S', w), schritte);
        }
    }

    /**
     * Startet den Tanz der Roboter.
     */
    void Ausfuehren()
    {
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }
    }

    public static void main(String[] args)
    {
        TanzWelt welt = new TanzWelt(10, 10, 5);
        Karol karol = new Karol(3, 3, 'N', welt);
        karol.LinksDrehen();
        karol.Schritt();
        karol.Schritt();
        karol.RechtsDrehen();
    }
}
