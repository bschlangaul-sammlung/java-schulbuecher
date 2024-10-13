package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.baum3;

/**
 * Datenelemente mit einer Ganzzahl als Wert.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class ZahlDaten implements DatenElement
{
    /**
     * Der Wert des Elements
     */
    private int wert;

    /**
     * Legt das Datenelement mit dem gegebenen Wert an.
     *
     * @param w Wert des Datenelements
     */
    ZahlDaten(int w)
    {
        wert = w;
    }

    /**
     * Vergleicht das vorhandene Datenelement mit dem übergebenen.
     *
     * @param wert Referenzauf den Vergleichswert
     *
     * @return -1: das aktuelle Element ist kleiner als das
     *     Vergleichselement<br>
     *     0: das aktuelle Elelemt hat den gleichen Wert wie das
     *     Vergleichselement<br>
     *     1: das aktuelle Element ist größer als das Vergleichselement
     */
    public int Vergleichen(DatenElement wert)
    {
        int vergleich;
        vergleich = ((ZahlDaten) wert).wert;
        if (this.wert == vergleich)
        {
            return 0;
        }
        else if (this.wert < vergleich)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    public void Ausgeben()
    {
        System.out.println("Das Datenelement hat den Wert: " + wert);
    }
}
