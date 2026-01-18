package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.notenliste_vorlage;

/**
 * Klasse zur Darstellung eines Schülers mit Namen und Informatiknoten
 */
@SuppressWarnings("unused")
public class Schueler
{
    private String name;

    private int[] noten;

    private Schueler(String n)
    {
        name = n;
        noten = new int[7];
        noten[0] = 1;
        noten[1] = 4;
        noten[2] = 2;
        noten[3] = 2;
        noten[4] = 3;
        noten[5] = 4;
        noten[6] = 5;
    }
}
