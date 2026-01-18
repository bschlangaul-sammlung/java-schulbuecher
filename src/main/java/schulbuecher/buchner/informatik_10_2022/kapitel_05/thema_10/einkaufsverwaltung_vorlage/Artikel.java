package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.einkaufsverwaltung_vorlage;

/**
 * Projekt 5-10_Einkaufsverwaltung (ÜuV Aufgabe 24)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Artikel
{
    private String name;

    private String kategorie;

    private double betrag;

    public Artikel(String name, String kategorie, double betrag)
    {
        this.name = name;
        this.kategorie = kategorie;
        this.betrag = betrag;
    }

    public String nenneName()
    {
        return this.name;
    }

    public String nenneKategorie()
    {
        return this.kategorie;
    }

    public double nenneBetrag()
    {
        return this.betrag;
    }
}
