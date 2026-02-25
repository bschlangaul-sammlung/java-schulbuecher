package schulbuecher.isb.abitur.pruefung_2022.inf1.aufgabe_ii.teilaufgabe_04;

public class Abonnent
{
    String eMail;

    String name;

    boolean istKleinerAls(String text)
    {
        return eMail.compareTo(text) < 0;
    }

    boolean istGroesserAls(String text)
    {
        return eMail.compareTo(text) > 0;
    }

    public void ausgeben()
    {
        System.out.println(eMail);
    }
}
