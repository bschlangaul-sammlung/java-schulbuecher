package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.sortieren;

/**
 * Hauptklasse des Programms.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class SortierenTesten
{
    /**
     * Legt die Ausgangsobjekte an. Kann nur über die Startmethode verwendet
     * werden.
     */
    private SortierenTesten()
    {
        Kontrolleur k;
        Oberflaeche o;
        k = new Kontrolleur();
        o = new Oberflaeche(k);
        k.OberflaecheSetzen(o);
    }

    /**
     * Startmethode, erzeugt ein Objekt dieser Klasse.
     *
     * @param args eventuelle Kommandozeilenargumente (nicht benötigt)
     */
    public static void main(String[] args)
    {
        new SortierenTesten();
    }
}
