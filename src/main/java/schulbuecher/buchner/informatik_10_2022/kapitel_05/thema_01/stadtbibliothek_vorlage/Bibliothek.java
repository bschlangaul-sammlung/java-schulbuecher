package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_01.stadtbibliothek_vorlage;

/**
 * Klasse zur Darstellung einer Stadtbibliothek mit Name, Adresse und einer
 * Auflistung der Bücher
 */
public class Bibliothek
{
    private String name;

    private String adresse;

    private Buch[] buecher;

    public Bibliothek()
    {
        buecher = new Buch[5];
        buecher[0] = new Buch("Harry Potter", 334);
        buecher[1] = new Buch("Die Tribute von Panem", 608);
        buecher[2] = new Buch("Die Känguru-Chroniken", 272);
        buecher[3] = new Buch("Winterkartoffelknödel", 240);
        buecher[4] = new Buch("Java ist auch eine Insel", 1000);
    }
}
