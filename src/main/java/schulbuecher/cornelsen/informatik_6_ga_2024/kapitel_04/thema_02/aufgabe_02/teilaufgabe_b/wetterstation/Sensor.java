package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

public abstract class Sensor extends Thread
{
    protected String typ;

    private LCDDisplay anzeige;

    public void setAnzeige(LCDDisplay anzeige)
    {
        this.anzeige = anzeige;
    }

    public abstract String getMesswert();

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Thread.sleep(2000); // Zwei Sekunden Wartezeit zwischen den
                                    // Messwertausgaben
                String messwert = getMesswert();
                if (anzeige != null)
                {
                    String textzeile = "Sensor: " + typ + "\tMesswert: "
                            + messwert + "\n";
                    anzeige.textAusgeben(textzeile);
                }
            }
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }
}
