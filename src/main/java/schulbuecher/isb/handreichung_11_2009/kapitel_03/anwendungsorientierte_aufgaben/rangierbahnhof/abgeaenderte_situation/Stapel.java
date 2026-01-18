package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class Stapel
{
    private Liste liste;

    // Konstruktor
    Stapel()
    {
        liste = new Liste();
    }

    // Methoden
    void Einfuegen(DatenElement neueDaten)
    {
        liste.AnfangEinfuegen(neueDaten);
    }

    DatenElement Entfernen()
    {
        return liste.AnfangEntfernen();
    }

    boolean IstLeer()
    {
        return liste.IstLeer();
    }

    DatenElement AnfangGeben()
    {
        return liste.AnfangGeben();
    }

    void AlleAusgeben()
    {
        liste.AlleAusgeben();
    }
}
