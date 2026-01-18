package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_02.eisladen;

/**
 * Klasse zur Darstellung eines Eises mit bis zu 8 Kugeln
 */
public class Eis
{
    private String[] kugeln;

    public Eis()
    {
        kugeln = new String[8];
        kugeln[0] = "Mango";
        kugeln[1] = "Zitrone";
        kugeln[2] = "Himbeere";
        /*
         * Bearbeitung Aufgabe 1b)
         */
        kugeln[0] = "Schokolade";
        kugeln[1] = "Vanille";
        kugeln[2] = "Erdbeere";
        kugeln[3] = "Erdbeere";
        /*
         * Bearbeitung Aufgabe 1c)
         */
        kugeln[4] = "Stracciatella";
    }
}
