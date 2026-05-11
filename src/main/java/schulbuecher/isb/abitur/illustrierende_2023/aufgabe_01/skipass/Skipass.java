package schulbuecher.isb.abitur.illustrierende_2023.aufgabe_01.skipass;

public class Skipass
{
    int nummer;

    char art;

    public Skipass(int number, char art)
    {
        this.nummer = number;
        this.art = art;
    }

    public int nummerGeben()
    {
        return nummer;
    }

    public int artGeben()
    {
        return art;
    }

    public void datenAusgeben()
    {
        System.out.println("Nr: " + nummer + " Art: " + art);
    }
}
