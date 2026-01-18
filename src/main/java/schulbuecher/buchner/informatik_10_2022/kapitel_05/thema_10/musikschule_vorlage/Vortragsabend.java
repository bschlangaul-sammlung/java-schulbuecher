package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.musikschule_vorlage;

/**
 * Projekt 5-10_Musikschule (ÜuV Aufgabe 14)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Vortragsabend
{
    Schueler[] vortragende;

    String vortragsort;

    public Vortragsabend()
    {
        vortragsort = "Muenchen";
        Lehrer standardMusiklehrer = new Lehrer();
        Lehrer bassinstrumenteLehrer = new Lehrer("Mister Cool");
        vortragende = new Schueler[10];
        vortragende[0] = new Schueler("Klara", 10, new Instrument("Geige"),
                standardMusiklehrer);
        vortragende[1] = new Schueler("Benedikt", 7,
                new Instrument("Schlagzeug"), bassinstrumenteLehrer);
        vortragende[2] = new Schueler("Johanna", 14, new Instrument("Triangel"),
                standardMusiklehrer);
        vortragende[3] = new Schueler("Levin", 15, new Instrument("Posaune"),
                bassinstrumenteLehrer);
        vortragende[4] = new Schueler("Julia", 17, new Instrument("Cello"),
                bassinstrumenteLehrer);
        vortragende[5] = new Schueler("Jens", 13, new Instrument("Kontrabass"),
                bassinstrumenteLehrer);
        vortragende[6] = new Schueler("Mike", 14, new Instrument("Klavier"),
                standardMusiklehrer);
        vortragende[7] = new Schueler("Marina", 9, new Instrument("Querflöte"),
                bassinstrumenteLehrer);
        vortragende[8] = new Schueler("Yasser", 6, new Instrument("Gitarre"),
                standardMusiklehrer);
        vortragende[9] = new Schueler("Janina", 12, new Instrument("Geige"),
                standardMusiklehrer);
    }

    public void nenneVortragende()
    {
        // Aufgabe 14b
    }

    // Aufgabe 14c
    public void tauscheAnAnfang()
    {
        int i = vortragende.length - 1;
        while (i > 0)
        {
            if (vortragende[i].nenneAlter() < vortragende[i - 1].nenneAlter())
            {
                Schueler temp = vortragende[i];
                vortragende[i] = vortragende[i - 1];
                vortragende[i - 1] = temp;
            }
            i = i - 1;
        }
    }

    public void sortiereVortragende()
    {
        // Aufgabe 14e
    }
}
