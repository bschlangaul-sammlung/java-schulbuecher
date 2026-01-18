package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_02;

public class Veranstaltung
{

    int tag;

    int zeitfenster;

    String name;

    public Veranstaltung(int tag, int zeitfenster, String name)
    {
        this.tag = tag;
        this.zeitfenster = zeitfenster;
        this.name = name;
    }

    public int tagGeben()
    {
        return tag;
    }

    public void tagSetzen(int tag)
    {
        this.tag = tag;
    }

    public int zeitfensterGeben()
    {
        return zeitfenster;
    }

    public void zeitfensterSetzen(int zeitfenster)
    {
        this.zeitfenster = zeitfenster;
    }

    public String nameGeben()
    {
        return name;
    }

    public void nameSetzen(String name)
    {
        this.name = name;
    }

}
