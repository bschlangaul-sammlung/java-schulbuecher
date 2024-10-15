package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.woerterbuch;

import java.text.Collator;

/**
 * Datenelemente für ein Wörterbuch.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class WORT implements DATENELEMENT
{
    /**
     * Der englische Suchbegriff
     */
    private String englisch;

    /**
     * Die deutschen Entsprchungen
     */
    private String deutsch;

    /**
     * Vergleichsobjekt
     */
    private Collator coll;

    /**
     * Legt das Datenelement mit dem gegebenen Wert an.
     */
    WORT(String e, String d)
    {
        englisch = e;
        deutsch = d;
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
    public int Vergleichen(DATENELEMENT wert)
    {
        return coll.compare(englisch, ((WORT) wert).englisch);
    }

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    public void Ausgeben()
    {
        System.out.println("Das englische Wort: " + englisch
                + " bedeutet im Deutschen: " + deutsch);
    }
}
