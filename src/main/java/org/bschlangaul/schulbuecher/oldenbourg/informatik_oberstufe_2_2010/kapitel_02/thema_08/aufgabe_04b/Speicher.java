package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04b;

/**
 * Verwaltet den Zwischenspeicher. In deiser Version mit 10 Pltzen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Speicher
{
    /** Gibt an, wie viele Plätze belegt sind */
    private int anzahlbelegt;

    /** Die eventuell vorhandene Kiste */
    private Kiste[] plaetze;

    /**
     * Besetzt die Attribute vor
     */
    Speicher()
    {
        anzahlbelegt = 0;
        plaetze = new Kiste[10];
        for (int i = 0; i < plaetze.length; i++)
        {
            plaetze[i] = null;
        }
    }

    /**
     * Versucht, eine Kiste abzulegen und wartet gegebenenfalls.
     *
     * @param kiste die abzulegende Kiste
     */
    synchronized void Ablegen(Kiste kiste)
    {
        while (anzahlbelegt >= plaetze.length)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
            }
        }
        plaetze[anzahlbelegt] = kiste;
        anzahlbelegt += 1;
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
        while (anzahlbelegt == 0)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
            }
        }
        anzahlbelegt -= 1;
        k = plaetze[0];
        for (int i = 0; i < anzahlbelegt; i++)
        {
            plaetze[i] = plaetze[i + 1];
        }
        plaetze[anzahlbelegt] = null;
        notify();
        return k;
    }
}
