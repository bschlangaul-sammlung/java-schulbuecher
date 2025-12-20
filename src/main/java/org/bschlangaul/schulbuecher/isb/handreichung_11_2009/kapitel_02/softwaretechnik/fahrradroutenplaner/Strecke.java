package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Beschreibt die Strecke zwischen zwei Orten.
 *
 * @version 1.0
 */
class Strecke implements Datenelement
{
    private Ort startOrt;

    private Ort zielOrt;

    private String streckenInfo;

    private int laenge;

    private int steigung;

    /**
     * Belegt die Attribute.
     *
     * @param start Startort
     * @param ziel Zielort
     * @param info Information über die Strecke
     * @param l Länge der Strecke
     * @param st Steigung der Strecke
     */
    Strecke(Ort start, Ort ziel, String info, int l, int st)
    {
        startOrt = start;
        zielOrt = ziel;
        streckenInfo = info;
        laenge = l;
        steigung = st;
    }

    /**
     * Meldet den Startort der Strecke.
     *
     * @return Startort
     */
    Ort StartortGeben()
    {
        return startOrt;
    }

    /**
     * Meldet den Zielort der Strecke.
     *
     * @return Zielort
     */
    Ort ZielortGeben()
    {
        return zielOrt;
    }

    /**
     * Meldet die Länge der Strecke.
     *
     * @return Länge
     */
    int LaengeGeben()
    {
        return laenge;
    }

    /**
     * Meldet die Steigung der Strecke.
     *
     * @return Steigung
     */
    int SteigungGeben()
    {
        return steigung;
    }

    /**
     * Meldet die Information über die Strecke.
     *
     * @return Information
     */
    String InfoGeben()
    {
        return streckenInfo;
    }

    /**
     * Identifiziert das Element.
     *
     * @param wert der Vergleichswert.
     *
     * @return true, wenn einer der Ortsnamen dem Vergleichswert entspricht.
     */
    public boolean IstGleich(String wert)
    {
        return startOrt.IstGleich(wert) || zielOrt.IstGleich(wert);
    }

    /**
     * Implementiert die Kleiner-Relation für die Minimumsuche. d Datenelement
     * mit dem Vergleichswert.
     *
     * @return meldet immer false.
     */
    public boolean IstKleiner(Datenelement d)
    {
        return false;
    }
}
