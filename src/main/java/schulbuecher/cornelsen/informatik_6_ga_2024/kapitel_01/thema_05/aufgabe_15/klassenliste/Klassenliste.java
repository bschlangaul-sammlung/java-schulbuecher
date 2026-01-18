package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_15.klassenliste;

/**
 * Klasse zur Verwaltung der Klassenliste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Klassenliste
{
    /**
     * Liste
     */
    private Liste l;

    /**
     * Konstruktor erzeugt eine leere Liste
     */
    Klassenliste()
    {
        l = new Liste();
    }

    /**
     * Fügt eine neue Person ein
     *
     * @param nachname Nachname
     * @param vorname Vorname
     */
    void Einfügen(String nachname, String vorname)
    {
        Schueler s;
        s = new Schueler(nachname, vorname);
        l.SortiertEinfügen(s);
    }

    /**
     * Entfernt eine Person aus der Liste
     *
     * @param nachname Nachname
     * @param vorname Vorname
     */
    void Entfernen(String nachname, String vorname)
    {
        l.Entfernen(nachname + " " + vorname);
    }

    /**
     * Gibt die Liste aller Namen zurück
     *
     * @return Namensliste
     */
    String NamenslisteGeben()
    {
        return l.NamenslisteGeben();
    }
}
