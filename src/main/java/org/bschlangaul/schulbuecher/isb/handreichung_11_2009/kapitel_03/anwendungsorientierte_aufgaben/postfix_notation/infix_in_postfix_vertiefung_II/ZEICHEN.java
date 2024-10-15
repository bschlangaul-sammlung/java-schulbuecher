package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix_vertiefung_II;

class ZEICHEN extends DATENELEMENT
{
    private char zeichen;

    ZEICHEN(char neuesZeichen)
    {
        zeichen = neuesZeichen;
    }

    boolean Vergleichen(DATENELEMENT d)
    {
        ZEICHEN hilfe = (ZEICHEN) d;
        return (hilfe.WertGeben() == zeichen);
    }

    void Ausgeben()
    {
        System.out.println("Zeichen: " + zeichen);
    }

    char WertGeben()
    {
        return zeichen;
    }
}
