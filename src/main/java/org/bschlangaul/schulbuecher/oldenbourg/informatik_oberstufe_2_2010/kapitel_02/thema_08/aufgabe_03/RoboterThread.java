package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_03;

/**
 * Steuert einen Roboter.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RoboterThread extends Thread
{
    int schritte;

    TanzRoboter robi;

    /**
     * Legt die Anzahl der Tanzschritte fest.
     *
     * @param robi Referenz auf den auszuführenden Roboter
     * @param schritte Anzahl der Tanzschritte
     *
     */
    RoboterThread(TanzRoboter robi, int schritte)
    {
        super();
        this.robi = robi;
        this.schritte = schritte;
    }

    /**
     * Die Startmethode des Threads.
     */
    public void run()
    {
        for (int i = 0; i < schritte; i++)
        {
            Absichern(robi);
            try
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
            }
        }
    }

    /**
     * Synchronisiert die Tanzaufrufe. Synchronisiert die Aufrufe von allen
     * Threads aus, da sie zur Klasse und nicht zu einem Objekt gehört.
     *
     * @param robi Referenz auf den auszuführenden Roboter
     */
    private synchronized static void Absichern(TanzRoboter robi)
    {
        robi.Tanzen();
    }
}
