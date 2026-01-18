package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.potenzen_vorlage;

/**
 * Projekt 5-10_Potenzen (ÜuV Aufgabe 23)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Zweierpotenz
{
    private int[] zweierpotenz;

    public Zweierpotenz(int n)
    {
        zweierpotenz = new int[n];
        int i = 0;
        // Ergänze ab hier
        while (i < n)
        {
        }
    }

    public void tauscheEnden()
    {
        // Ergänze hier
    }

    public void umsortieren()
    {
        int i = 0;
        while (i < (zweierpotenz.length) / 2)
        {
            tausche(i, zweierpotenz.length - (i + 1));
            i = i + 1;
        }
    }

    public void tausche(int pos1, int pos2)
    {
        int temp = zweierpotenz[pos1];
        zweierpotenz[pos1] = zweierpotenz[pos2];
        zweierpotenz[pos2] = temp;
    }
}
