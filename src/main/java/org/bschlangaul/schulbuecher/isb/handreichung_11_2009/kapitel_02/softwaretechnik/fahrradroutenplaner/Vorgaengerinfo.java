package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Verwaltet die Vorgängerinformation für dem Dijkstra-Algorithmus.
 *
 * @version 1.0
 */
class Vorgaengerinfo implements Datenelement
{
    private Ort ort;

    private Ort vorgaenger;

    private int gesamtLaenge;

    /**
     * Besetzt die Attribute.
     *
     * @param o aktueller Ort
     * @param v Vorgäner
     * @param laenge Weglänge bis hierher
     */
    Vorgaengerinfo(Ort o, Ort v, int laenge)
    {
        ort = o;
        vorgaenger = v;
        gesamtLaenge = laenge;
    }

    /**
     * Meldet den Ort.
     *
     * @return Ort
     */
    Ort OrtGeben()
    {
        return ort;
    }

    /**
     * Meldet den Vorgänger.
     *
     * @return Vorgänger
     */
    Ort VorgaengerGeben()
    {
        return vorgaenger;
    }

    /**
     * Meldet die aktuelle Weglaenge bis hierher.
     *
     * @return Gesamtlänge
     */
    int LaengeGeben()
    {
        return gesamtLaenge;
    }

    /**
     * Setzt den Vorgänger auf einen neuen Wert.
     *
     * @param v Vorgäner
     */
    void VorgaengerSetzen(Ort v)
    {
        vorgaenger = v;
    }

    /**
     * Setzt die Gesamtweglänge auf einen neuen Wert.
     *
     * @param laenge Weglänge bis hierher
     */
    void LaengeSetzen(int laenge)
    {
        gesamtLaenge = laenge;
    }

    /**
     * Identifiziert das Element.
     *
     * @param wert der Vergleichswert.
     *
     * @return true, wenn der Ortsname gleich dem Vergleichswert ist.
     */
    public boolean IstGleich(String wert)
    {
        return ort.IstGleich(wert);
    }

    /**
     * Implementiert die Kleiner-Relation für die Minimumsuche.
     *
     * @param d Datenelement mit dem Vergleichswert.
     *
     * @return true, wenn das Element eine kleinere Gesamtlaenge hat als der
     *     Vergleichswert.
     */
    public boolean IstKleiner(Datenelement d)
    {
        return (d == null) || (d instanceof Vorgaengerinfo)
                && (gesamtLaenge < ((Vorgaengerinfo) d).gesamtLaenge);
    }
}
