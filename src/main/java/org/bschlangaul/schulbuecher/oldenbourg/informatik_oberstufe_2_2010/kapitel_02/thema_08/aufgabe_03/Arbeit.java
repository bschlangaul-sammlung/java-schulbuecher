package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_03;

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

    KarolWelt w;

    /**
     * Legt die Roboterthreads an.
     *
     * @param anzahl Anzahl der Roboter
     * @param schritte Anzahl der Tanzschritte
     */
    Arbeit(int anzahl, int schritte)
    {
        threads = new RoboterThread[anzahl];
        w = new KarolWelt(anzahl, anzahl, 5);
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
}
