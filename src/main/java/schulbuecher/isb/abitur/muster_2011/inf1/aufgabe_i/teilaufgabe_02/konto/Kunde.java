package schulbuecher.isb.abitur.muster_2011.inf1.aufgabe_i.teilaufgabe_02.konto;

@SuppressWarnings("unused")
public class Kunde
{
    // Attribute

    private String name;

    private String strasse;

    private int hausnummer;

    private int postleitzahl;

    private String ort;

    // Konstruktor
    public Kunde(String n, String str, int hsnr, int pl, String o)
    {
        name = n;
        strasse = str;
        hausnummer = hsnr;
        postleitzahl = pl;
        ort = o;
    }

    // Methoden

}
