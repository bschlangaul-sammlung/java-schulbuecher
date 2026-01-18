package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.oepnv;

public class KNOTEN
{
    private String bezeichner;

    public KNOTEN(String eNeu)
    {
        // Instanzvariable initialisieren
        bezeichner = eNeu;
    }

    public void bezeichnerSetzen(String eNeu)
    {
        bezeichner = eNeu;
    }

    public String bezeichnerGeben()
    {
        return bezeichner;
    }

    public boolean bezeichnerIstGleich(String wert)
    {
        return bezeichner.compareTo(wert) == 0;
    }
}
