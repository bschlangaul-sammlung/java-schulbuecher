package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.unter_uns_vorlage;

/**
 * Projekt 5-10_UnterUns (ÜüV Aufgabe 17)
 *
 * @author Verena Haller
 *
 * @version 2022-09-12
 */
@SuppressWarnings("unused")
public class Aufgabe
{
    private int aufgabennummer;

    private int punktezahl;

    private boolean erledigt;

    public Aufgabe(int aufgabennummer, int punktezahl)
    {
        this.aufgabennummer = aufgabennummer;
        this.punktezahl = punktezahl;
        erledigt = false;
    }
}
