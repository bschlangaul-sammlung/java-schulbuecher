package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_05a.tastatur_turtle;

/**
 * Durch die Tastatur gesteuerte Turtle
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class TastaturTurtle extends Turtle
{
    /**
     * Die Methode für gedrückte Sondertasten.
     *
     * @param taste KeyCode der gedrückten Taste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
        System.out.println("Sondertaste: " + taste);
    }

}
