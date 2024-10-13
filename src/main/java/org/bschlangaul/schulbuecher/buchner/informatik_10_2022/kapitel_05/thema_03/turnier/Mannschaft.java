package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_03.turnier;

/**
 * Klasse zur Darstellung einer Mannschaft mit Name und Spielerliste
 */
class Mannschaft
{
    String name;

    Spieler[] spielerliste;

    Mannschaft()
    {
        name = "Testmannschaft";
        spielerliste = new Spieler[6];
        spielerliste[0] = new Spieler("Yannick", 1);
        spielerliste[1] = new Spieler("Naomi", 5);
        spielerliste[2] = new Spieler("Mohammed", 10);
        spielerliste[3] = new Spieler("Evi", 9);
        spielerliste[4] = new Spieler("Victoria", 2);
        spielerliste[5] = new Spieler("Kim", 3);
    }
}
