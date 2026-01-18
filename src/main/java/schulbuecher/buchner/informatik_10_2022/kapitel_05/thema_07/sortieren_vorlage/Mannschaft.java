package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_07.sortieren_vorlage;

/**
 * Projekt 5-7_Sortieren
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
        this.spielerliste = new Spieler[6]; // nach Bearbeitung von A3
                                            // spielerliste = new
                                            // Spieler[8];
        spielerliste[0] = new Spieler("Ali", 1, 2, 45);
        spielerliste[1] = new Spieler("Kim", 5, 4, 45);
        spielerliste[2] = new Spieler("Leo", 10, 0, 45);
        spielerliste[3] = new Spieler("Noah", 9, 1, 45);
        spielerliste[4] = new Spieler("Max", 2, 3, 20);
        spielerliste[5] = new Spieler("Uwe", 3, 5, 25);
    }

    public void bubble()
    {
        Spieler h = new Spieler(null, 0, 0, 0);
        int i = 0;
        while (i < spielerliste.length - 1)
        {
            if (spielerliste[i].nenneSpielzeit() > spielerliste[i + 1]
                    .nenneSpielzeit())
            {
                h = spielerliste[i];
                spielerliste[i] = spielerliste[i + 1];
                spielerliste[i + 1] = h;
            }
            i = i + 1;
        }
    }
}
