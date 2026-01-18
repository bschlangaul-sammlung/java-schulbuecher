package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

public class Wetterstation
{
    public Wetterstation()
    {
        LCDDisplay anzeige = new LCDDisplay();
        Sensor[] sensoren = new Sensor[] { new Temperatursensor(),
                new Luftdrucksensor(), new Luftfeuchtesensor(),
                new Windgeschwindigkeitssensor(), new Windrichtungssensor() };
        for (Sensor s : sensoren)
        {
            s.setAnzeige(anzeige);
            s.start();
        }
    }
}
