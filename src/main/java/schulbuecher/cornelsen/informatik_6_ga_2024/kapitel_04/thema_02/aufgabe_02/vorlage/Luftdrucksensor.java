package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.vorlage;

import java.util.concurrent.ThreadLocalRandom;

public class Luftdrucksensor extends Sensor
{
    public Luftdrucksensor()
    {
        typ = "Luftdruck";
    }

    public String getMesswert()
    {
        return ThreadLocalRandom.current().nextInt(1000, 1030) + " hPa";
    }
}
