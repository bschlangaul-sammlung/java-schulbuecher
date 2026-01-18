package schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_04.aufgabe1_kantine;

/**
 * Klasse Tasse, für Kapitel 4.2 Aufgabe 2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-02-28
 */
class Tasse
{
    double fuellstand;

    /**
     * Konstruktor für Objekte der Klasse Tasse
     */
    Tasse(double einFuellstand)
    {
        // Instanzvariable initialisieren
        fuellstand = einFuellstand;
    }

    void erhoeheFuellstand(double wieviel)
    {
        if (wieviel > 0)
        {
            fuellstand = fuellstand + wieviel;
        }
    }

    void verringereFuellstand(double wieviel)
    {
        if (wieviel > 0)
        {
            fuellstand = fuellstand - wieviel;
        }
    }
}
