package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_06.beste_mannschaften_vorlage;

/**
 * Projekt 5-6_BesteMannschaften
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Mannschaft
{
    private String name;

    private Spieler[] spielerliste;

    public Mannschaft()
    {
        this.name = "Testmannschaft";
        this.spielerliste = new Spieler[8];
        spielerliste[0] = new Spieler("Yannick", 1);
        spielerliste[1] = new Spieler("Naomi", 5);
        spielerliste[2] = new Spieler("Mohammed", 10);
        spielerliste[3] = new Spieler("Evi", 9);
        spielerliste[4] = new Spieler("Victoria", 2);
        spielerliste[5] = new Spieler("Kim", 3);
        spielerliste[6] = new Spieler("Lena", 15);
        spielerliste[7] = new Spieler("Josua", 20);
    }

    public String nenneName()
    {
        return this.name;
    }
}
