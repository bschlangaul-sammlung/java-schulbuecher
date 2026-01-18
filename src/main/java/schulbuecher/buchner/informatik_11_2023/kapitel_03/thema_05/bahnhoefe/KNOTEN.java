package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_05.bahnhoefe;

public class KNOTEN
{
    private String bezeichner;

    private String kuerzel;

    public KNOTEN(String eNeu, String ekurz)
    {
        // Instanzvariable initialisieren
        this.bezeichner = eNeu;
        this.kuerzel = ekurz;
    }

    public void bezeichnerSetzen(String eNeu)
    {
        this.bezeichner = eNeu;
    }

    public String bezeichnerGeben()
    {
        return bezeichner;
    }

    public String kuerzelGeben()
    {
        return kuerzel;
    }

    public boolean bezeichnerIstGleich(String wert)
    {
        return (bezeichner.compareTo(wert) == 0);
    }
}
