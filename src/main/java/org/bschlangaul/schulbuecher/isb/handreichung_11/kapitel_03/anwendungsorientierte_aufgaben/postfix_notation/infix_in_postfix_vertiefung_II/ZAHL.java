package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix_vertiefung_II;

class ZAHL extends DATENELEMENT
{
    private int zahl;

    ZAHL(int neueZahl)
    {
        zahl = neueZahl;
    }

    boolean Vergleichen(DATENELEMENT d)
    {
        ZAHL hilfe = (ZAHL) d;
        return (hilfe.WertGeben() == zahl);
    }

    void Ausgeben()
    {
        System.out.println("Zahl: " + zahl);
    }

    int WertGeben()
    {
        return zahl;
    }
}