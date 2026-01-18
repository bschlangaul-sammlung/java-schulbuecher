package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_01;

public class Camp
{
    Besucher[] besucher;

    boolean nachbarplaetzeVerfuegbar(int n)
    {
        int zaehler = 0;
        for (int i = 0; i < besucher.length; i++)
        {
            if (besucher[i] == null)
            {
                zaehler++;
            }
            else
            {
                zaehler = 0;
            }
            if (zaehler >= n)
            {
                return true;
            }
        }
        return false;
    }
}
