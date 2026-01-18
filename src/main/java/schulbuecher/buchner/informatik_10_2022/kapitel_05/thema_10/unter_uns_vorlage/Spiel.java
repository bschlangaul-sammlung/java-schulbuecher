package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.unter_uns_vorlage;

/**
 * Projekt 5-10_UnterUns (ÜüV Aufgabe 17)
 *
 * @author Verena Haller
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Spiel
{
    private String name;

    private Spieler ersteller;

    private Spieler[] spieler;

    private int spielerzahl;

    public Spiel(String name, Spieler ersteller)
    {
        this.name = name;
        this.ersteller = ersteller;
        spieler[0] = ersteller;
        this.spielerzahl = 0;
    }
}
