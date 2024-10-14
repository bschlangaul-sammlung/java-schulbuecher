package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_04.gueterbahnhof;

/**
 * Klasse zur Verwaltung eines Waggons
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Waggon implements Datenelement
{
    /**
     * Zielort des Waggons
     */
    private String zielort;

    /**
     * Distanz zum Zielort
     */
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
     *
     * @return wahr, wenn der Waggon weniger weit von Zielort entferntz ist, als
     *     das Vergleichselement
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
    {
        return distanz_zum_zielort < ((Waggon) dvergleich).distanz_zum_zielort;
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     *
     * @return immer wahr
     */
    public boolean SchlüsselIstGleich(String s)
    {
        return true;
    }
}
