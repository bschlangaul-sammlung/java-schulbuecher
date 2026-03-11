package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.vorlage_d;

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
     * Besetzt die Attribute vor.
     */
    Speicher()
    {
        frei = true;
        kiste = null;
    }

    /**
     * Ablegen der Kiste
     *
     * @param kisteNeu die abzulegende Kiste
     */
    synchronized void Ablegen(Kiste kisteNeu)
    {
        while (!frei)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
            }
        }
        frei = false;
        kiste = kisteNeu;
        notify();
    }

    /**
     * Holen der Kiste
     *
     * @return die geholte Kiste
     */
    synchronized Kiste Holen()
    {
        Kiste k;
        while (frei)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
            }
        }
        frei = true;
        k = kiste;
        kiste = null;
        notify();
        return k;
    }
}
