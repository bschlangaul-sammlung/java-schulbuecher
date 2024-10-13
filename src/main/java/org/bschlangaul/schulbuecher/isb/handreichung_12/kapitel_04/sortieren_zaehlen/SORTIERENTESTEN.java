package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.sortieren_zaehlen;

/**
 * Hauptklasse des Programms.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class SORTIERENTESTEN
{
    /**
     * Legt die Ausgangsobjekte an. Kann nur über die Startmethode verwendet
     * werden.
     */
    private SORTIERENTESTEN()
    {
        KONTROLLEUR k;
        OBERFLAECHE o;
        k = new KONTROLLEUR();
        o = new OBERFLAECHE(k);
        k.OberflaecheSetzen(o);
    }

    /**
     * Startmethode, erzeugt ein Objekt dieser Klasse.
     *
     * @param args eventuelle Kommandozeilenargumente (nicht benötigt)
     */
    public static void main(String[] args)
    {
        new SORTIERENTESTEN();
    }
}
