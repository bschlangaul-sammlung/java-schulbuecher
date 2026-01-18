package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.marius_kart_vorlage;

/**
 * Klasse zur Darstellung eines Spielers in Marius-Kart mit Name, Gefährt,
 * Stärke und gesammelten Items
 */
@SuppressWarnings("unused")
public class Spieler
{
    private String name;

    private Gefaehrt gefaehrt;

    private String staerke;

    private Item[] items;

    public Spieler(String n, Gefaehrt g, String s)
    {
        name = n;
        gefaehrt = g;
        staerke = s;
        items = new Item[2];
    }
}
