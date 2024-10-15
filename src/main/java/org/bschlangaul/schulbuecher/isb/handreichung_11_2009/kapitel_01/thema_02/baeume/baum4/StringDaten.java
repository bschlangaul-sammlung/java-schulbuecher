package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.baum4;

import java.text.Collator;

/**
 * Datenelemente mit einer Zeichenkette als Wert.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class StringDaten implements DatenElement
{
    /**
     * Der Wert des Elements
     */
    private String wert;

    /**
     * Vergleichsobjekt
     */
    private Collator coll;

    /**
     * Legt das Datenelement mit dem gegebenen Wert an.
     *
     * @param w Wert des Datenelements
     */
    StringDaten(String w)
    {
        wert = w;
        coll = Collator.getInstance();
    }

    /**
     * Vergleicht das vorhandene Datenelement mit dem übergebenen.
     *
     * @param wert der Vergleichswert
     *
     * @return -1: das aktuelle Element ist kleiner als das
     *     Vergleichselement<br>
     *     0: das aktuelle Elelemt hat den gleichen Wert wie das
     *     Vergleichselement<br>
     *     1: das aktuelle Element ist größer als das Vergleichselement
     */
    public int Vergleichen(DatenElement wert)
    {
        return coll.compare(this.wert, ((StringDaten) wert).wert);
    }

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    public void Ausgeben()
    {
        System.out.println("Das Datenelement hat den Wert: " + wert);
    }
}
