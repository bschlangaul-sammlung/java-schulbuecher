package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class ZEICHEN implements DATENELEMENT
{
    /** Der Wert des Elements */
    private char wert;

    /**
     * Legt das Datenelement mit dem gegebenen Wert an.
     *
     * @param w Wert des Datenelements
     */
    ZEICHEN(char w)
    {
        wert = w;
    }

    /**
     * Vergleicht das vorhandene Datenelement mit dem übergebenen. Die Methode
     * wurde auf einen Rückgabewert boolean angepasst.
     *
     * @param wert Referenzauf den Vergleichswert
     *
     * @return -1: das aktuelle Element ist kleiner als das
     *     Vergleichselement<br>
     *     0: das aktuelle Elelemt hat den gleichen Wert wie das
     *     Vergleichselement<br>
     *     1: das aktuelle Element ist größer als das Vergleichselement
     */
    public boolean Vergleichen(DATENELEMENT wert)
    {
        char vergleich;
        vergleich = ((ZEICHEN) wert).wert;
        return (this.wert == vergleich);
    }

    /**
     * Gibt die relevante Information des Datenelements auf die Konsole aus.
     */
    public void Ausgeben()
    {
        System.out.print(wert + " ");
    }
}
