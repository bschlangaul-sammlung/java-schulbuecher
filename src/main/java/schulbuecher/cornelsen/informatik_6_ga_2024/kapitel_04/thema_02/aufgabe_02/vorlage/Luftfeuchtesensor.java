package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.vorlage;

import java.util.concurrent.ThreadLocalRandom;

public class Luftfeuchtesensor extends Sensor
{
    public Luftfeuchtesensor()
    {
        typ = "Luftfeuchte";
    }

    public String getMesswert()
    {
        return ThreadLocalRandom.current().nextInt(0, 101) + " %";
    }
}
