package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_01;

/**
 * Write a description of class ROBOTERTHREAD here.
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
            robi.Tanzen();
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
            }
        }
    }
}
