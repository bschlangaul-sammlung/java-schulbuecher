package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_08.arzt;

/**
 * Logische Verwaltung der Warteschlange in der Gemeinschaftspraxis
 * Schnittstelle zwischen LISTE und OBERFLäCHE.
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
     *
     */
    void Aufnehmen(Patient p)
    {
        liste.HintenEinfuegen(p);
    }

    /**
     * Ausgabe eines Patienten Fordert die Liste auf, einen geeigneten Patienten
     * auszugeben undd gibt seinen Namen im Fenster aus..
     *
     * @param s Arzt, der neuen Patienten benötigt.
     *
     * @return Name des Patienten
     */
    String Ausgeben(String s)
    {
        Datenelement d;
        d = liste.Suchen(s);
        if (d != null)
        {
            liste.KnotenEntfernen(d);
            Patient p;
            p = (Patient) d;
            return p.NameGeben();
        }
        else
        {
            return "leer";
        }
    }
}
