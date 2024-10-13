package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_02.hanoi;

/**
 * 1 * Klasse zur Verwaltung eines Spiels
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class SPIEL
{
    /** Erster Hanoiturm */
    HANOITURM hanoiturm1;

    /** Zweiter Hanoiturm */
    HANOITURM hanoiturm2;

    /** Dritter Hanoiturm */
    HANOITURM hanoiturm3;

    /** Sorgt für die Verzögerung bei der Anzeige */
    int taktdauer;

    /**
     * Konstruktor Erzeugt die Türme. Legt die Taktdauer abhängig von der
     * Scheibenzahl fest. Erzeugt die Scheiben und legt sie auf den ersten Turm.
     * Startet den rekursiven Algorithmus; die Scheiben werden zum zweiten Turm
     * transportiert.
     *
     * @param scheibenzahl Anzahl der Scheiben
     */
    SPIEL(int scheibenzahl)
    {
        hanoiturm1 = new HANOITURM(90, 200);
        hanoiturm2 = new HANOITURM(190, 200);
        hanoiturm3 = new HANOITURM(290, 200);
        if (scheibenzahl <= 3)
        {
            taktdauer = 2000;
        }
        else
        {
            if (scheibenzahl <= 6)
            {
                taktdauer = 700;
            }
            else
            {
                taktdauer = 100;
            }
        }
        for (int i = 0; i < scheibenzahl; i++)
        {
            hanoiturm1.Einfuegen(new SCHEIBE(100 - 10 * i));
        }
        SchiebeTurm(scheibenzahl, hanoiturm1, hanoiturm2, hanoiturm3);
    }

    /**
     * Rekursiver Algorithmus zur Lösung des Problems
     *
     * @param hoehe Anzahl der zu entfernenden Scheiben
     * @param vonTurm Hanoiturm, von dem die Scheiben entfernt werden
     * @param nachTurm Ziel-Hanoiturm
     * @param freierTurm freier Hanoiturm
     */
    void SchiebeTurm(int hoehe, HANOITURM vonTurm, HANOITURM nachTurm,
            HANOITURM freierTurm)
    {
        if (hoehe > 0)
        {
            SchiebeTurm(hoehe - 1, vonTurm, freierTurm, nachTurm);
            Pause();
            nachTurm.Einfuegen(vonTurm.Entfernen());
            Pause();
            SchiebeTurm(hoehe - 1, freierTurm, nachTurm, vonTurm);
        }
    }

    /**
     * Sorgt für die Verzögerung
     */
    void Pause()
    {
        try
        {
            Thread.sleep(taktdauer);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * Leert den zweiten Hanoiturm (beim Start eines zweiten Spiels).
     */
    void Loeschen()
    {
        hanoiturm2.Loeschen();
    }
}
