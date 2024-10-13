package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private DATENELEMENT daten;

    // Konstruktoren
    KNOTEN()
    {
        super();
        nachfolger = null;
        daten = null;
    }

    KNOTEN(LISTENELEMENT naechsterKnoten, DATENELEMENT datenObjekt)
    {
        super();
        nachfolger = naechsterKnoten;
        daten = datenObjekt;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(LISTENELEMENT neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    LISTENELEMENT NachfolgerGeben()
    {
        return nachfolger;
    }

    void Datensetzen(DATENELEMENT datenObjekt)
    {
        daten = datenObjekt;
    }

    DATENELEMENT DatenGeben()
    {
        return daten;
    }

    // weitere Methoden
    DATENELEMENT EndeGeben()
    {
        DATENELEMENT wert;
        wert = nachfolger.EndeGeben();
        if (wert == null)
            return daten;
        else
            return wert;
    }

    LISTENELEMENT EndeEinfuegen(DATENELEMENT datenObjekt)
    {
        nachfolger = nachfolger.EndeEinfuegen(datenObjekt);
        return this;
    }

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt))
            return true;
        else
            return nachfolger.Suchen(datenObjekt);
    }

    LISTENELEMENT Entfernen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt))
            return nachfolger;
        else
        {
            nachfolger = nachfolger.Entfernen(datenObjekt);
            return this;
        }
    }

    LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt)
    {
        // meine Daten sind kleiner
        if (daten.Vergleichen(datenObjekt))
        {
            nachfolger = nachfolger.SortiertEinfuegen(datenObjekt);
            return this;
        }
        // meine Daten sind größer oder gleich
        else
            return new KNOTEN(this, datenObjekt);
    }

    int AnzahlGeben()
    {
        return nachfolger.AnzahlGeben() + 1;
    }

    void AlleAbHierAusgeben()
    {
        daten.Ausgeben();
        nachfolger.AlleAbHierAusgeben();
    }

    int AnzahlMitEigenschaftAbHierGeben(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt))
        {
            return nachfolger.AnzahlMitEigenschaftAbHierGeben(datenObjekt) + 1;
        }
        else
        {
            return nachfolger.AnzahlMitEigenschaftAbHierGeben(datenObjekt);
        }
    }
}