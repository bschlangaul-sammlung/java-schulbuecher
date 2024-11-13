package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_03.bahnhof;

/**
 * Klasse zur Verwaltung eines Waggons
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Waggon implements DatenElement
{
    private String zielort;

    private int distanz_zum_zielort;

    /**
     * Konstruktor
     *
     * @param ort Zielort
     * @param distanz Abstand vom Zielort
     */
    Waggon(String ort, int distanz)
    {
        zielort = ort;
        distanz_zum_zielort = distanz;
    }

    /**
     * Ausgabe des Zielorts
     *
     * @return Zielort
     */
    String ZielortGeben()
    {
        return zielort;
    }

    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    public void InformationAusgeben()
    {
        System.out.println(zielort + "  " + distanz_zum_zielort + " km");
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        return distanz_zum_zielort < ((Waggon) dvergleich).distanz_zum_zielort;
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return true;
    }
}
