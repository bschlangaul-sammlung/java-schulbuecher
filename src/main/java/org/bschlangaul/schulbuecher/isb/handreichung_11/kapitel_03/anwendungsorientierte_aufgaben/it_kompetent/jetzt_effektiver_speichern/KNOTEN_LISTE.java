package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

class KNOTEN_LISTE extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private DATENELEMENT daten;

    // Konstruktoren
    KNOTEN_LISTE()
    {
        super();
        nachfolger = null;
        daten = null;
    }

    KNOTEN_LISTE(LISTENELEMENT naechsterKnoten, DATENELEMENT datenObjekt)
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

    LISTENELEMENT SortiertEinfuegen(DATENELEMENT datenObjekt)
    {
        // meine Daten sind kleiner
        if (daten.Vergleichen(datenObjekt) < 0)
        {
            nachfolger = nachfolger.SortiertEinfuegen(datenObjekt);
            return this;
        }
        // meine Daten sind größer oder gleich
        else
            return new KNOTEN_LISTE(this, datenObjekt);
    }

    boolean Suchen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt) == 0)
            return true;
        else
            return nachfolger.Suchen(datenObjekt);
    }

    LISTENELEMENT Entfernen(DATENELEMENT datenObjekt)
    {
        if (daten.Vergleichen(datenObjekt) == 0)
            return nachfolger;
        else
        {
            nachfolger = nachfolger.Entfernen(datenObjekt);
            return this;
        }
    }

    int AnzahlAbHierGeben()
    {
        return nachfolger.AnzahlAbHierGeben() + 1;
    }

    void AlleAusgeben()
    {
        daten.Ausgeben();
        nachfolger.AlleAusgeben();
    }

    // Erweiterung der Klasse um notwendige Suchmethoden
    DATENELEMENT DatenAbHierSuchen(DATENELEMENT vergleichsdaten)
    {
        if (daten.Vergleichen(vergleichsdaten) == 0)
        {
            return daten;
        }
        else
        {
            return nachfolger.DatenAbHierSuchen(vergleichsdaten);
        }
    }
}
