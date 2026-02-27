package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_f.erzeuger_verbraucher;

import java.util.concurrent.Semaphore;

/**
 * Zwischenspeicher beim Erzeuger-Verbraucher-Problem
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Speicher
{
    /**
     * Gibt an, ob Platz frei ist.
     */
    private boolean frei;

    /**
     * eventuell vorhandene Kiste
     */
    private Kiste kiste;

    /**
     * Semaphor für den Speicher
     */
    private Semaphore semaphore;

    /**
     * Besetzt die Attribute vor.
     */
    Speicher()
    {
        frei = true;
        kiste = null;
        semaphore = new Semaphore(1);
    }

    /**
     * Ablegen der Kiste
     *
     * @param kisteNeu die abzulegende Kiste
     */
    void Ablegen(Kiste kisteNeu)
    {
        semaphore.acquireUninterruptibly();
        while (!frei)
        {
            semaphore.release();
            try
            {
                wait(100);
            }
            catch (Exception e)
            {
            }
            semaphore.acquireUninterruptibly();
        }
        frei = false;
        kiste = kisteNeu;
        semaphore.release();
    }

    /**
     * Holen der Kiste
     *
     * @return die geholte Kiste
     */
    Kiste Holen()
    {
        Kiste k;
        semaphore.acquireUninterruptibly();
        while (frei)
        {
            semaphore.release();
            try
            {
                wait(100);
            }
            catch (Exception e)
            {
            }
            semaphore.acquireUninterruptibly();
        }
        frei = true;
        k = kiste;
        kiste = null;
        semaphore.release();
        return k;
    }
}
