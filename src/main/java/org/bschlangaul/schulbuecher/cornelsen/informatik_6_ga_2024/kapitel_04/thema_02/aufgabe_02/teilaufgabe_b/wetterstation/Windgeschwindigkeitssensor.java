package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

import java.util.concurrent.ThreadLocalRandom;

public class Windgeschwindigkeitssensor extends Sensor
{
    public Windgeschwindigkeitssensor()
    {
        typ = "Windgeschwindigkeit";
    }

    public String getMesswert()
    {
        return ThreadLocalRandom.current().nextInt(0, 201) + " km/h";
    }
}
