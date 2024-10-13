package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

class ABSCHLUSS extends LISTENELEMENT
{
    // KONSTRUKTOR
    ABSCHLUSS()
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
        return new KNOTEN(this, datenObjekt);
    }

    LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt)
    {
        return new KNOTEN(this, datenObjekt);
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
