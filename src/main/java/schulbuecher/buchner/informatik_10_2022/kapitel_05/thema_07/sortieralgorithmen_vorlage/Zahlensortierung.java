package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_07.sortieralgorithmen_vorlage;

/**
 * Projekt 5-7_Sortieralgorithmen
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Zahlensortierung
{
    private int[] zahlen;

    public Zahlensortierung()
    {
        zahlen = new int[7];
        zahlen[0] = 3;
        zahlen[1] = 7;
        zahlen[2] = 1;
        zahlen[3] = 0;
        zahlen[4] = 30;
        zahlen[5] = 5;
        zahlen[6] = 4;
    }

    public Zahlensortierung(int length)
    {
        this.zahlen = new int[length];
        int i = 0;
        while (i < zahlen.length)
        {
            zahlen[i] = length - i;
            i = i + 1;
        }
    }
    // Für Schnelle: Analysiere die Bubble-Methode und vergleiche sie mit dem
    // Code im Schulbuch.
    // Beschreibe dabei die Unterschiede und erkläre diese.

    public void bubble()
    {
        int i = 1;
        while (i < zahlen.length)
        {
            if (zahlen[i] < zahlen[i - 1])
            {
                int h = zahlen[i];
                zahlen[i] = zahlen[i - 1];
                zahlen[i - 1] = h;
            }
            i = i + 1;
        }
    }

    public void bubblesort()
    {
        int i = zahlen.length - 1; // richtig: i = zahlen.length
        while (i > 0) // richtig: i > 1
        {
            bubble();
            i = i + 1; // richtig: i = i-1;
        }
    }
}
