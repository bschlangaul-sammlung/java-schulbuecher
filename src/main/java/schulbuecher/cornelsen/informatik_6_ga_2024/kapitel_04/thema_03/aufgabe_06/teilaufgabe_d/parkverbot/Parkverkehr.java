package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_06.teilaufgabe_d.parkverbot;

/**
 * Fahrzeuge, die um einen freien Parkplatz konkurrieren
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Parkverkehr
{
    /**
     * Konstruktor für Objekte der Klasse Parkverkehr
     */
    Parkverkehr()
    {
        Parkplatz p = new Parkplatz();
        Fahrzeug f;

        for (int id = 0; id < 10; id++)
        {
            f = new Fahrzeug(id, p);
            f.start();
        }
    }
}
