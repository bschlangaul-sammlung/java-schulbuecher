package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell;

/**
 * Beschreibt ein Datenelement, das nur aus einem als String beschriebenen
 * Schüssel besteht..
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class StringDaten implements DatenElement
{
    /**
     * Der Schlüssel des Datenelements
     */
    private String schluessel;

    /**
     * Trägt den Schlüssel ein.
     *
     * @param s der Schlüssel des Datenelements
     */
    public StringDaten(String s)
    {
        schluessel = s;
    }

    /**
     * Vergleicht den Schlüssel des Datenelements mit dem in der Referenz
     * angegebenen Schüssel. &lt;0: Der eigene Schlüssel ist kleiner als der
     * referenzierte Schlüssel<br>
     * =0: Der eigene Schlüssel ist gleich dem referenzierten Schlüssel<br>
     * &gt;0: Der eigene Schlüssel ist größer als der referenzierte Schlüssel
     *
     * @return das Vergleichsergebnis
     */
    public int Vergleichen(DatenElement schluessel)
    {
        return this.schluessel.compareTo(((StringDaten) schluessel).schluessel);
    }
}
