package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Steuert die Figuren.
 */
class FigurenThread extends Thread
{
    /** Die zu verwaltende Figur */
    private Figur figur;

    /** Die Wartezeit der Figur */
    private long warteZeit;

    /** Endebedingung für die Threads */
    private static boolean ende;

    /**
     * Legt die Attribute an.
     *
     * @param figur die zu bewegende Figur
     * @param zeit die Wartezeit
     */
    FigurenThread(Figur figur, long zeit)
    {
        super();
        this.figur = figur;
        warteZeit = zeit;
        ende = false;
    }

    /**
     * Die Startmethode des Threads
     */
    public void run()
    {
        long akt, endeLocal;
        while (!ende)
        {
            akt = System.currentTimeMillis();
            endeLocal = akt + warteZeit;
            while (akt < endeLocal)
            {
                try
                {
                    wait(endeLocal - akt);
                }
                catch (Exception e)
                {
                }
                akt = System.currentTimeMillis();
            }
            figur.Bewegen();
        }
    }

    /**
     * Setzt die Ende-Bedingung zum Stoppen der Bewegung.
     */
    static void EndeSetzen()
    {
        ende = true;
    }
}
