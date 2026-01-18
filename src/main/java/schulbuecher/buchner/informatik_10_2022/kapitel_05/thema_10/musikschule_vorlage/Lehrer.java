package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.musikschule_vorlage;

/**
 * Projekt 5-10_Musikschule (ÜuV Aufgabe 14)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Lehrer
{
    String name;

    Instrument[] instrumente;

    double gehalt;

    Schueler[] musikschueler;

    public Lehrer()
    {
        name = "Hans Dampf";
        gehalt = 2100.0;
        musikschueler = new Schueler[40];
        instrumente = new Instrument[4];
        instrumente[0] = new Instrument("Klavier");
        instrumente[1] = new Instrument("Geige");
        instrumente[2] = new Instrument("Gitarre");
        instrumente[3] = new Instrument("Triangel");
    }

    public Lehrer(String name)
    {
        this.name = name;
    }

    public String nenneLehrer()
    {
        return this.name;
    }
}
