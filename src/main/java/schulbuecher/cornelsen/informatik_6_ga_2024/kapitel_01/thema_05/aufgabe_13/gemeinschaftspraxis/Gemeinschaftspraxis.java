package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_13.gemeinschaftspraxis;

/**
 * Logische Verwaltung der Warteschlange in der Gemeinschaftspraxis
 * Schnittstelle zwischen Liste und Oberfläche.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Gemeinschaftspraxis
{
    private Liste liste;

    @SuppressWarnings("unused")
    private Fenster oberflaeche;

    /**
     * Konstruktor Erzeugt eine Liste und ein Fenster
     */
    Gemeinschaftspraxis()
    {
        liste = new Liste();
        oberflaeche = new Fenster(this);
    }

    /**
     * Aufnahme eines Patienten Fordert die Liste auf, einen neuen Patienten
     * hinten einzufügen.
     *
     * @param p neuer Patient
     */
    void Aufnehmen(Patient p)
    {
        liste.HintenEinfügen(p);
    }

    /**
     * Ausgabe eines Patienten Fordert die Liste auf, einen geeigneten Patienten
     * auszugeben undd gibt seinen Namen im Fenster aus.
     *
     * @param s Arzt, der neuen Patienten benötigt.
     *
     * @return Name des Patienten
     */
    String Ausgeben(String s)
    {
        Datenelement d = liste.Suchen(s);
        Patient p = (Patient) d;
        if (p != null)
        {
            liste.KnotenEntfernen(p);
            return p.NameGeben();
        }
        else
        {
            return "leer";
        }
    }
}
