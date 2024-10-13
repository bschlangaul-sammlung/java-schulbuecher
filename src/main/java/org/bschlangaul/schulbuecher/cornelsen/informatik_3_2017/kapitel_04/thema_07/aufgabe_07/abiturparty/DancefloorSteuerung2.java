package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_07.abiturparty;

/**
 * Steuerung der Leuchten auf dem Dancefloor
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class DancefloorSteuerung2 extends DancefloorSteuerung
{
    /**
     * Erzeugt zufällige Farbwechsel
     */
    @Override
    void AktionAusführen()
    {
        for (int spalte = 0; spalte < d.SpaltenanzahlGeben(); spalte = spalte
                + 1)
        {
            for (int zeile = 0; zeile < d.ZeilenanzahlGeben(); zeile = zeile
                    + 1)
            {
                d.FarbeSetzen(spalte, zeile, ZufälligeFarbeGeben());
            }
        }
    }
}
