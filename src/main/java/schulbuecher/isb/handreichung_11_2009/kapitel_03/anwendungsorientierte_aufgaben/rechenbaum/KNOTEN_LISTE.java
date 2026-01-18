package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class KNOTEN_LISTE extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private BAUM daten;

    // Konstruktoren
    KNOTEN_LISTE(LISTENELEMENT naechsterKnoten, BAUM datenObjekt)
    {
        super();
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Methoden
    LISTENELEMENT NachfolgerGeben()
    {
        return nachfolger;
    }

    BAUM DatenGeben()
    {
        return daten;
    }
}
