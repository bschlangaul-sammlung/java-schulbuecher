package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

import java.util.concurrent.ThreadLocalRandom;

public class Windrichtungssensor extends Sensor
{
    public Windrichtungssensor()
    {
        typ = "Windrichtung";
    }

    public String getMesswert()
    {
        return new String[] { "N", "NO", "O", "SO", "S", "SW", "W",
                "NW" }[ThreadLocalRandom.current().nextInt(0, 8)];
    }
}
