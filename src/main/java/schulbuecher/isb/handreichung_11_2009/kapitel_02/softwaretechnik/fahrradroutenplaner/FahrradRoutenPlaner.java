package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

class FahrradRoutenPlaner
{
    private Liste orte;

    private Liste strecken;

    private DatenbankVerbindung verbindung;

    private Karte k;

    private Oberflaeche o;

    private Dijkstra d;

    private FahrradRoutenPlaner()
    {
        String[] ortsInfo, wegInfo;
        Datenelement[] hilf;
        orte = new Liste();
        strecken = new Liste();
        verbindung = new DatenbankVerbindung();
        verbindung.OrteHolen(orte);
        verbindung.StreckenHolen(strecken, orte);
        verbindung.Schliessen();
        d = new Dijkstra(orte, strecken);
        k = new Karte(orte, strecken);
        hilf = strecken.DatenelementeAlsFeldGeben();
        wegInfo = new String[hilf.length];
        for (int i = 0; i < wegInfo.length; i++)
        {
            wegInfo[i] = ((Strecke) hilf[i]).InfoGeben();
        }
        hilf = orte.DatenelementeAlsFeldGeben();
        ortsInfo = new String[hilf.length];
        for (int i = 0; i < ortsInfo.length; i++)
        {
            ortsInfo[i] = ((Ort) hilf[i]).InfoGeben();
        }
        o = new Oberflaeche(k, hilf, ortsInfo, wegInfo, new Kontrolleur(d));
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
        new FahrradRoutenPlaner();
    }
}
