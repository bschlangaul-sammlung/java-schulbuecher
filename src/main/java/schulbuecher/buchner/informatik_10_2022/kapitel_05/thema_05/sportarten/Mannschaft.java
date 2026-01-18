package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_05.sportarten;

/**
 * Projekt 5-4_Turnier
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Mannschaft
{
    private String name;

    private Spieler[] spielerliste;

    public Mannschaft()
    {
        this.name = "Testmannschaft";
        this.spielerliste = new Spieler[8];
        spielerliste[0] = new Spieler("Yannick");
        spielerliste[1] = new Spieler("Naomi");
        spielerliste[2] = new Spieler("Mohammed");
        spielerliste[3] = new Spieler("Evi");
        spielerliste[4] = new Spieler("Victoria");
        spielerliste[5] = new Spieler("Kim");
        spielerliste[6] = new Spieler("Lena");
        spielerliste[7] = new Spieler("Josua");
    }
}
