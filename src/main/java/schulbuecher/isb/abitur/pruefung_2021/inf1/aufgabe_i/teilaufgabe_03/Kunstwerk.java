package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_03;

public class Kunstwerk
{
    String name;

    String kuenstler;

    Ort ort;

    public Kunstwerk(String name, String kuenstler, Ort ort)
    {
        this.name = name;
        this.kuenstler = kuenstler;
        this.ort = ort;
    }

    public String nameGeben()
    {
        return name;
    }

    public void nameSetzen(String name)
    {
        this.name = name;
    }

    public String kuenstlerGeben()
    {
        return kuenstler;
    }

    public void kuenstlerSetzen(String künstler)
    {
        this.kuenstler = künstler;
    }

    public Ort ortGeben()
    {
        return ort;
    }

    public void ortSetzen(Ort ort)
    {
        this.ort = ort;
    }
}
