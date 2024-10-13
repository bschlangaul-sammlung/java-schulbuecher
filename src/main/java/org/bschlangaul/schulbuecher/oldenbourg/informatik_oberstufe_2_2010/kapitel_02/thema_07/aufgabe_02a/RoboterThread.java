package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_02a;

/**
 * Write a description of class ROBOTERTHREAD here.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class RoboterThread extends Thread
{
    Karol2 robi;

    /**
     * Legt die Anzahl der Tanzschritte fest.
     *
     * @param robi Referenz auf den auszuführenden Roboter
     *
     */
    RoboterThread(Karol2 robi)
    {
        super();
        this.robi = robi;
    }

    /**
     * Die Startmethode des Threads.
     */
    public void run()
    {
        do
        {
            robi.Bewegen();
            try
            {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
            }
        }
        while (!Karol2.IstEnde());
    }
}
