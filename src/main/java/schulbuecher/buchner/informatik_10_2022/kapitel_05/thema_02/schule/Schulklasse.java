package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_02.schule;

/**
 * Klasse zur Darstellung einer Schulklasse mit Bezeichnung, Schülerliste und
 * den Notendurchschnitten für die einzelnen Fächer
 */
public class Schulklasse
{
    private String bezeichnung;

    private Schueler[] schuelerliste;

    private double[] notendurchschnitte;

    public Schulklasse(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
        notendurchschnitte = new double[10];
        notendurchschnitte[0] = 2.6;
        notendurchschnitte[0] = 3.2;
        notendurchschnitte[0] = 1.8;
        notendurchschnitte[0] = 2.4;
        schuelerliste = new Schueler[10];
        schuelerliste[0] = new Schueler("Amira", 15);
        schuelerliste[1] = new Schueler("Stefan", 16);
        schuelerliste[2] = new Schueler("Melanie", 15);
        schuelerliste[3] = new Schueler("Tamara", 17);
        schuelerliste[4] = new Schueler("Susi", 15);
        schuelerliste[5] = new Schueler("Ali", 16);
        schuelerliste[6] = new Schueler("Damian", 16);
        schuelerliste[7] = new Schueler("Luan", 16);

        // Bearbeitung Aufgabe A3a)

        Schueler fritz = new Schueler("Fritz Feld");
        schuelerliste[6] = fritz;
        Schueler anna = new Schueler("Anna Array");
        schuelerliste[8] = anna;

        // Bearbeitung Aufgabe A3b)

        System.out.println(schuelerliste[7].nenneName());
        // Bearbeitung Aufgabe A3c)

        System.out.println(schuelerliste.length);
    }
}
