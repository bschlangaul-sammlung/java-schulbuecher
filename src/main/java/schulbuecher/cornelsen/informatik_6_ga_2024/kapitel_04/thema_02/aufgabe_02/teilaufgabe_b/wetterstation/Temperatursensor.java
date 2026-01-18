package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

import java.util.concurrent.ThreadLocalRandom;

public class Temperatursensor extends Sensor
{
    public Temperatursensor()
    {
        typ = "Temperatur";
    }

    public String getMesswert()
    {
        return ThreadLocalRandom.current().nextInt(-10, 41) + " °C";
    }
}
