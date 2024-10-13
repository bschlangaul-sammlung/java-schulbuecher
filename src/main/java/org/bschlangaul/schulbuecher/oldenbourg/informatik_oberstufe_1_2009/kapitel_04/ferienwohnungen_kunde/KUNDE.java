package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

/**
 * Rahmenklasse, fügt die Teile zusammen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KUNDE
{
    /**
     * Legt die Teile an
     */
    private KUNDE()
    {
        KONTROLLEUR k;
        OBERFLAECHE o;
        k = new KONTROLLEUR();
        o = new OBERFLAECHE(k);
        k.OberflaecheSetzen(o);
        DATENBANKVERBINDUNG.VerbindungGeben().Registrieren(o);
    }

    /**
     * Startmethode
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new KUNDE();
    }
}
