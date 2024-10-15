package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell;

/**
 * Beschreibt eine allgemeines Datenelement für Liste oder Baum.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public interface DATENELEMENT
{
    /**
     * Vergleicht den Schlüssel des Datenelements mit dem in der Referenz
     * angegebenen Schüssel. &lt;0: Der eigene Schlüssel ist kleiner als der
     * referenzierte Schlüssel<br>
     * =0: Der eigene Schlüssel ist gleich dem referenzierten Schlüssel<br>
     * &gt;0: Der eigene Schlüssel ist größer als der referenzierte Schlüssel
     *
     * @return das Vergleichsergebnis
     */
    int Vergleichen(DATENELEMENT schluessel);
}
