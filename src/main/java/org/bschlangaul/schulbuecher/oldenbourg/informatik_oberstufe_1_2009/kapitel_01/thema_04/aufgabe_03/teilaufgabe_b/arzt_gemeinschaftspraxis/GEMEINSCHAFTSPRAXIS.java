package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.arzt_gemeinschaftspraxis;

/**
 * Logische Verwaltung der Warteschlange in der Gemeinschaftspraxis
 * Schnittstelle zwischen LISTE und OBERFLäCHE.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class GEMEINSCHAFTSPRAXIS
{
    private LISTE liste;

    private FENSTER oberflaeche;

    /**
     * Konstruktor Erzeugt eine Liste und ein Fenster
     */
    GEMEINSCHAFTSPRAXIS()
    {
        liste = new LISTE();
        oberflaeche = new FENSTER(this);
    }

    /**
     * Aufnahme eines Patienten Fordert die Liste auf, einen neuen Patienten
     * hinten einzufügen.
     *
     * @param p neuer Patient
     *
     */
    void Aufnehmen(PATIENT p)
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
        DATENELEMENT d;
        d = liste.Suchen(s);
        if (d != null)
        {
            liste.KnotenEntfernen(d);
            PATIENT p;
            p = (PATIENT) d;
            return p.NameGeben();
        }
        else
        {
            return "leer";
        }
    }
}
