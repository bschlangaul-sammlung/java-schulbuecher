package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_04.turnier;

/**
 * Klasse zur Darstellung einer Mannschaft mit Name und Spielerliste
 */
public class Mannschaft
{
    private String name;

    private Spieler[] spielerliste;

    public Mannschaft()
    {
        this.name = "Testmannschaft";
        this.spielerliste = new Spieler[6]; // nach Bearbeitung von A3
                                            // spielerliste = new
                                            // Spieler[8];
        spielerliste[0] = new Spieler("Yannick", 1);
        spielerliste[1] = new Spieler("Naomi", 5);
        spielerliste[2] = new Spieler("Mohammed", 10);
        spielerliste[3] = new Spieler("Evi", 9);
        spielerliste[4] = new Spieler("Victoria", 2);
        spielerliste[5] = new Spieler("Kim", 3);
        spielerliste[6] = new Spieler("Lena", 15);
        spielerliste[7] = new Spieler("Josua", 20);
    }
}
