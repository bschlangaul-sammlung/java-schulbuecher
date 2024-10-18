package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_11.klassenliste;

/**
 * Klasse zur Verwaltung der Klassenliste
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class KlassenListe
{
    /**
     * Liste
     */
    private Liste l;

    /**
     * Konstruktor erzeugt eine leere Liste
     *
     */
    KlassenListe()
    {
        l = new Liste();
    }

    /**
     * Fügt einen neuen Schüler ein.
     *
     * @param nachname Nachname des Schülers
     * @param vorname Vorname des Schülers
     */
    void Einfuegen(String nachname, String vorname)
    {
        Schueler s;
        s = new Schueler(nachname, vorname);
        l.SortiertEinfuegen(s);
    }

    /**
     * Ausgabe der Klassenliste
     */
    void InformationAusgeben()
    {
        l.InformationAusgeben();
    }

    /**
     * ändert den Nachnamen eines gesuchten Schülers n_alt Nachname des
     * gesuchten Schülers v_alt Vorname des gesuchten Schülers n_neu neuer
     * Nachname
     */
    void NachnameSetzen(String n_alt, String v_alt, String n_neu)
    {
        Schueler s;
        DatenElement d;
        d = l.Suchen(n_alt + " " + v_alt);
        s = (Schueler) d;
        if (s != null)
        {
            s.NachnameSetzen(n_neu);
            System.out.println("Name geändert");
        }
    }

    /**
     * ändert den Nachnamen eines gesuchten Schülers n_alt Nachname des
     * gesuchten Schülers v_alt Vorname des gesuchten Schülers v_neu neuer
     * Vorname
     */
    void VornameSetzen(String n_alt, String v_alt, String v_neu)
    {
        Schueler s = (Schueler) l.Suchen(n_alt + " " + v_alt);
        if (s != null)
        {
            s.VornameSetzen(v_neu);
            System.out.println("Name geändert");
        }
    }
}
