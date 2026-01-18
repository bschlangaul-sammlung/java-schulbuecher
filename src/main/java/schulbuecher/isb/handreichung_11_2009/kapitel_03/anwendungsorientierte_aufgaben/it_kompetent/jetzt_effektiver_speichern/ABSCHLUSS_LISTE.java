package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

class ABSCHLUSS_LISTE extends LISTENELEMENT
{
    // KONSTRUKTOR
    ABSCHLUSS_LISTE()
    {
        super();
    }

    // Getter- und Setter-Methoden
    LISTENELEMENT NachfolgerGeben()
    {
        return this;
    }

    DATENELEMENT DatenGeben()
    {
        return null;
    }

    // weitere Methoden
    DATENELEMENT EndeGeben()
    {
        return null;
    }

    LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt)
    {
        return new KNOTEN_LISTE(this, datenObjekt);
    }

    LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt)
    {
        return new KNOTEN_LISTE(this, datenObjekt);
    }

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        return false;
    }

    LISTENELEMENT Entfernen(DATENELEMENT datenObjekt)
    {
        return this;
    }

    int AnzahlAbHierGeben()
    {
        return 0;
    }

    void AlleAusgeben()
    {
    }

    // Erweiterung der Klasse um notwendige Suchmethoden
    DATENELEMENT DatenAbHierSuchen(DATENELEMENT vergleichsdaten)
    {
        return null;
    }
}
