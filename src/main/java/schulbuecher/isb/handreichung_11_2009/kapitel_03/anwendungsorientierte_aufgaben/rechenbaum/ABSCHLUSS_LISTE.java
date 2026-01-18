package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class ABSCHLUSS_LISTE extends LISTENELEMENT
{
    // KONSTRUKTOR
    ABSCHLUSS_LISTE()
    {
        super();
    }

    LISTENELEMENT NachfolgerGeben()
    {
        return this;
    }

    BAUM DatenGeben()
    {
        return null;
    }
}
