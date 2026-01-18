package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.zahlenreihen_vorlage;

/**
 * Projekt 5-10_Zahlenreihen (ÜuV Aufgabe 22)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Tetraederzahlen extends Zahlenreihe
{
    public Tetraederzahlen(int laenge)
    {
        super(laenge);
        Dreieckszahlen dreieckszahlen = new Dreieckszahlen(laenge);
        zahlenfolge[0] = 1;
        int i = 1;
        while (i < zahlenfolge.length)
        {
            zahlenfolge[i] = zahlenfolge[i - 1] + dreieckszahlen.zahlenfolge[i];
            i = i + 1;
        }
    }
}
