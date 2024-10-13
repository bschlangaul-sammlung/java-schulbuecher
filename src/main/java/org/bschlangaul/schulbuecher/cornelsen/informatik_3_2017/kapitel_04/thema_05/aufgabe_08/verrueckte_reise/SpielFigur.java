package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_08.verrueckte_reise;

/**
 * Die Spielfigur der verrückten Reise
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SpielFigur extends Figur
{
    /**
     * Bewegt die Figur gerade aus
     */
    @Override
    void AktionAusführen()
    {
        Gehen(15);
    }

    /**
     * Steuert die Richtung der Spielfigur.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
        if (taste == 37)
        {
            Drehen(5);
        }
        else if (taste == 39)
        {
            Drehen(-5);
        }
    }
}
