package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.marius_kart_vorlage;

/**
 * Klasse zur Darstellung eines Rennens zwischen maximal 8 Spielern in
 * Marius-Kart
 */
@SuppressWarnings("unused")
public class Rennen
{
    private String name;

    private int schwierigkeitsstufe;

    private Item[] items;

    private Spieler[] teilnehmer;

    public Rennen()
    {
        name = "Regenbogen-Boulevard";
        schwierigkeitsstufe = 4;
        teilnehmer = new Spieler[8];
        teilnehmer[0] = new Spieler("Mario", new Gefaehrt("Go-Kart", "rot"),
                "Geschwindigkeit");
        teilnehmer[1] = new Spieler("Luigi", new Gefaehrt("Cruiser", "grün"),
                "Geschwindigkeit");
        teilnehmer[2] = new Spieler("Princess",
                new Gefaehrt("Limousine", "rosa"), "Wendigkeit");
        teilnehmer[3] = new Spieler("Bobba",
                new Gefaehrt("Monstertruck", "schwarz"), "Stärke");
        items = new Item[6];
        items[0] = new Item("Bananenschale");
        items[1] = new Item("Grüner Panzer");
        items[2] = new Item("Roter Panzer");
        items[3] = new Item("Bombe");
        items[4] = new Item("Falle");
        items[5] = new Item("Blitz");
    }
}
