package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_01.stadtbibliothek_vorlage;

/**
 * Klasse zur Darstellung eines Buches mit Name und Seitenzahl
 */
public class Buch
{
    private String name;

    private int seitenzahl;

    public Buch(String name, int seitenzahl)
    {
        this.name = name;
        this.seitenzahl = seitenzahl;
    }
}
