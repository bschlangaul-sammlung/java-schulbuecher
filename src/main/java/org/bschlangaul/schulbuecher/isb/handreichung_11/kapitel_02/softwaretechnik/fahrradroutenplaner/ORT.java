package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Verwaltet die Information für einen Ort.
 *
 * @version 1.0
 */
class ORT implements DATENELEMENT
{
    private String ortsname;

    private String ortsinfo;

    private int xpos;

    private int ypos;

    /**
     * Legt die Attributwerte fest
     *
     * @param name Ortsname
     * @param info Informationen über den Ort
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    ORT(String name, String info, int x, int y)
    {
        ortsname = name;
        ortsinfo = info;
        xpos = x;
        ypos = y;
    }

    /**
     * Meldet den Namen des Ortes.
     *
     * @return Name
     */
    String NameGeben()
    {
        return ortsname;
    }

    /**
     * Meldet die Information über den Ort.
     *
     * @return Informationstext
     */
    String InfoGeben()
    {
        return ortsinfo;
    }

    /**
     * Meldet die X-Koordinate des Ortes.
     *
     * @return X-Koordinate
     */
    int XPosGeben()
    {
        return xpos;
    }

    /**
     * Meldet die Y-Koordinate des Ortes.
     *
     * @return Y-Koordinate
     */
    int YPosGeben()
    {
        return ypos;
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
        return ortsname.equals(wert);
    }

    /**
     * Implementiert die Kleiner-Relation für die Minimumsuche.
     *
     * @param d Datenelement mit dem Vergleichswert.
     *
     * @return meldet immer false.
     */
    public boolean IstKleiner(DATENELEMENT d)
    {
        return false;
    }

    /**
     * Stringrepäsentation des Ortes für die Menüdarstellung
     */
    public String toString()
    {
        return ortsname;
    }
}
