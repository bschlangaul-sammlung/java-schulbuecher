package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_04.turnier_vorlage;

/**
 * Projekt 5-4_Turnier
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Spieler
{
    private String name;

    private int trikotnummer;

    private String[] sportarten;

    public Spieler(String name, int trikotnummer)
    {
        this.name = name;
        this.trikotnummer = trikotnummer;
        sportarten = new String[3];
        sportarten[0] = "Handball";
        sportarten[1] = "Schwimmen";
        sportarten[2] = "Fußball";
    }

    public void nenneSportarten()
    {
        // Kapitel 5.4 Aufgabe A2a
    }
}
