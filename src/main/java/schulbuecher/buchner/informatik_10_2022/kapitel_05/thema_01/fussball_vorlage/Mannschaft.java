package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_01.fussball_vorlage;

/**
 * Klasse zur Darstellung einer Fußballmannschaft mit Mannschaftsname und
 * Spielerliste
 */
public class Mannschaft
{
    private String name;

    private Spieler[] spielerliste;

    public Mannschaft()
    {
        this.name = "Testmannschaft";
        this.spielerliste = new Spieler[6];
        this.spielerliste[0] = new Spieler("Johannes", 12);
        this.spielerliste[1] = new Spieler("Peer", 1);
        this.spielerliste[2] = new Spieler("Anastasia", 7);
        this.spielerliste[3] = new Spieler("Chiara", 4);
        this.spielerliste[4] = new Spieler("Simon", 14);
        this.spielerliste[5] = new Spieler("Melanie", 8);
    }
}
