package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Write a description of class FAHRRADROUTENPLANER here.
 *
 * @author (your name)
 *
 * @version (a version number or a date)
 */
class FAHRRADROUTENPLANER
{
    private LISTE orte;

    private LISTE strecken;

    private DATENBANKVERBINDUNG verbindung;

    private KARTE k;

    private OBERFLAECHE o;

    private DIJKSTRA d;

    /**
     * Constructor for objects of class FAHRRADROUTENPLANER
     */
    private FAHRRADROUTENPLANER()
    {
        String[] ortsInfo, wegInfo;
        DATENELEMENT[] hilf;
        orte = new LISTE();
        strecken = new LISTE();
        verbindung = new DATENBANKVERBINDUNG();
        verbindung.OrteHolen(orte);
        verbindung.StreckenHolen(strecken, orte);
        verbindung.Schliessen();
        d = new DIJKSTRA(orte, strecken);
        k = new KARTE(orte, strecken);
        hilf = strecken.DatenelementeAlsFeldGeben();
        wegInfo = new String[hilf.length];
        for (int i = 0; i < wegInfo.length; i++)
        {
            wegInfo[i] = ((STRECKE) hilf[i]).InfoGeben();
        }
        hilf = orte.DatenelementeAlsFeldGeben();
        ortsInfo = new String[hilf.length];
        for (int i = 0; i < ortsInfo.length; i++)
        {
            ortsInfo[i] = ((ORT) hilf[i]).InfoGeben();
        }
        o = new OBERFLAECHE(k, hilf, ortsInfo, wegInfo, new KONTROLLEUR(d));
        d.Registrieren(o);
        d.Registrieren(k);
    }

    /**
     * Einsprungmethode für den Programmstart.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new FAHRRADROUTENPLANER();
    }
}
