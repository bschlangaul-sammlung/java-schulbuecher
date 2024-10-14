package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_04.labyrinth;

/**
 * Klasse zur Beschreibung des Labyrinths
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Labyrinth
{
    /**
     * Legt die Mauern an und positioniert den Ausgang
     */
    Labyrinth()
    {
        new MauerHorizontal(0, 0, 15);
        new MauerHorizontal(3, 1, 3);
        new MauerHorizontal(8, 1, 3);
        new MauerHorizontal(13, 1, 1);
        new MauerHorizontal(2, 2, 4);
        new MauerHorizontal(12, 2, 1);
        new MauerHorizontal(3, 3, 3);
        new MauerHorizontal(11, 3, 2);
        new MauerHorizontal(3, 4, 2);
        new MauerHorizontal(12, 4, 2);
        new MauerHorizontal(2, 5, 4);
        new MauerHorizontal(8, 5, 2);
        new MauerHorizontal(13, 5, 2);
        new MauerHorizontal(1, 6, 10);
        new MauerHorizontal(0, 7, 10);
        new MauerHorizontal(1, 8, 10);
        new MauerHorizontal(0, 9, 15);
        new MauerVertikal(0, 0, 9);
        new MauerVertikal(1, 1, 5);
        new MauerVertikal(2, 0, 5);
        new MauerVertikal(3, 3, 1);
        new MauerVertikal(6, 1, 1);
        new MauerVertikal(6, 3, 2);
        new MauerVertikal(7, 0, 2);
        new MauerVertikal(7, 3, 3);
        new MauerVertikal(8, 1, 4);
        new MauerVertikal(9, 1, 3);
        new MauerVertikal(10, 2, 3);
        new MauerVertikal(11, 1, 7);
        new MauerVertikal(12, 0, 2);
        new MauerVertikal(12, 4, 5);
        new MauerVertikal(13, 2, 1);
        new MauerVertikal(13, 5, 3);
        new MauerVertikal(14, 1, 3);
        new MauerVertikal(14, 6, 3);
        new MauerVertikal(15, 0, 8);
        new Ausgang();
    }
}
