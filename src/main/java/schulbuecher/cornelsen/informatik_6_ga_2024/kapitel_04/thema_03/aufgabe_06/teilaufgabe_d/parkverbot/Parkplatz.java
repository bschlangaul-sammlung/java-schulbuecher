package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_06.teilaufgabe_d.parkverbot;

/**
 * Parkplatz
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Parkplatz
{
    /**
     * gibt an, ob der Parkplatz belegt ist oder nicht
     */
    private boolean frei;

    /**
     * Konstruktor für Objekte der Klasse Parkplatz
     */
    Parkplatz()
    {
        frei = true;
    }

    /**
     * Falls der Parkplatz frei ist, wird er beparkt.
     *
     * @param kennzeichen Kennzeichen des Fahrzeugs
     *
     * @return wahr
     */
    synchronized boolean Beparken(int kennzeichen)
    {
        while (!frei)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }

        }
        frei = false;
        System.out.println(kennzeichen + " erfolgreich eingeparkt.");
        notify();
        return true;
    }

    /**
     * Der Parkplatz wird verlassen.
     *
     * @param kennzeichen Kennzeichen des Fahrzeugs
     */
    synchronized void Ausparken(int kennzeichen)
    {
        while (frei)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        frei = true;
        System.out.println(kennzeichen + " ausgeparkt.");
        notify();
    }
}
