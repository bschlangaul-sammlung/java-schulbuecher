package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Baut die Bausteine des Programms zusammen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class FAHRPLANWARTUNG
{
    /**
     * Baut die Bausteine des Programms zusammen.
     */
    private FAHRPLANWARTUNG()
    {
        DATENBANKVERBINDUNG d;
        BAHNHOFSLISTE b;
        ABSCHNITTSLISTE a;
        UMSTEIGELISTE u;
        KONTROLLEUR k;
        OBERFLAECHE o;
        PLANANZEIGE p;
        d = DATENBANKVERBINDUNG.VerbindungGeben();
        b = new BAHNHOFSLISTE();
        a = new ABSCHNITTSLISTE();
        u = new UMSTEIGELISTE();
        d.BahnhoefeHolen(b, a, u);
        p = new PLANANZEIGE(b, a);
        k = new KONTROLLEUR(b, a, u, p);
        o = new OBERFLAECHE(k, b.NamenslisteGeben(), p);
        k.OberflaecheSetzen(o);
    }

    /**
     * Startmethode des Programms.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new FAHRPLANWARTUNG();
    }
}
