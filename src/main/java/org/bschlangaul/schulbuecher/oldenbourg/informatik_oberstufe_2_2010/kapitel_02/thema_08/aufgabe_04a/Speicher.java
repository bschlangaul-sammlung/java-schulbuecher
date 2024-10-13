package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04a;

/**
 * Verwaltet den Zwischenspeicher.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Speicher
{
    /** Gibt an, ob Platz frei ist */
    private boolean frei;

    /** Die eventuell vorhandene Kiste */
    private Kiste kiste;

    /**
     * Besetzt die Attribute vor
     */
    Speicher()
    {
        frei = true;
        kiste = null;
    }

    /**
     * Versucht, eine Kiste abzulegen und wartet gegebenenfalls.
     *
     * @param kiste die abzulegende Kiste
     */
    synchronized void Ablegen(Kiste kiste)
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
        this.kiste = kiste;
        notify();
    }

    /**
     * Versucht, eine Kiste zu holen und wartet gegebenenfalls.
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
