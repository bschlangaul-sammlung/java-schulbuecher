package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_01.listen.warteschlange_einfach;

class Knoten
{
    private Knoten nachfolger;

    private String name;

    private String vorname;

    // Konstruktoren
    Knoten()
    {
        nachfolger = null;
        name = "";
        vorname = "";
    }

    Knoten(Knoten naechsterKnoten, String neuerName, String neuerVorname)
    {
        nachfolger = naechsterKnoten;
        name = neuerName;
        vorname = neuerVorname;
    }

    // Getter- und Setter-Methoden
    void NachfolgerSetzen(Knoten neuerNachfolger)
    {
        nachfolger = neuerNachfolger;
    }

    Knoten NachfolgerGeben()
    {
        return nachfolger;
    }

    void NameSetzen(String neuerName)
    {
        name = neuerName;
    }

    void VornameSetzen(String neuerVorname)
    {
        vorname = neuerVorname;
    }

    String NameGeben()
    {
        return name;
    }

    String VornameGeben()
    {
        return vorname;
    }

    String NameVornameGeben()
    {
        return name + ", " + vorname;
    }

    // weitere Methoden
    String EndeGeben()
    {
        if (nachfolger == null)
            return NameVornameGeben();
        else
            return nachfolger.EndeGeben();
    }

    void EndeEinfuegen(String neuerName, String neuerVorname)
    {
        if (nachfolger == null)
            nachfolger = new Knoten(null, neuerName, neuerVorname);
        else
            nachfolger.EndeEinfuegen(neuerName, neuerVorname);
    }

    int AnzahlGeben()
    {
        if (nachfolger == null)
            return 1;
        else
            return nachfolger.AnzahlGeben() + 1;
    }

    void AlleAusgeben()
    {
        System.out.println("Kunde: " + name + ", " + vorname);
        if (nachfolger != null)
            nachfolger.AlleAusgeben();
    }
}
