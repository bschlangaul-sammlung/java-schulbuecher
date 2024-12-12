package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2012.inf1.aufgabe_i.teilaufgabe_03;

public class DatenKnoten extends BaumElement
{

    BaumElement naechsterLinks;

    BaumElement naechsterRechts;

    Athlet inhalt;

    void k2()
    {
        naechsterLinks.k2();
        if (inhalt.nationGeben().equals("Deutschland"))
        {
            System.out
                    .println(inhalt.nameGeben() + ": " + inhalt.nationGeben());
        }
        naechsterRechts.k2();
    }
}
