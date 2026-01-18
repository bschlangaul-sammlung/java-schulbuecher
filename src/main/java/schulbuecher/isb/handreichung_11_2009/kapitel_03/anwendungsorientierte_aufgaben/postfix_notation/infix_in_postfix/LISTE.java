package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS();
    }

    // weitere Methoden
    void EndeEinfuegen(DATENELEMENT neueDaten)
    {
        anfang = anfang.EndeEinfuegen(neueDaten);
    }

    void AnfangEinfuegen(DATENELEMENT neueDaten)
    {
        KNOTEN n = new KNOTEN(anfang, neueDaten);
        anfang = n;
    }

    DATENELEMENT AnfangEntfernen()
    {
        DATENELEMENT entfernt;
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
        return entfernt;
    }

    DATENELEMENT AnfangGeben()
    {
        return anfang.DatenGeben();
    }

    void Entfernen(DATENELEMENT datenObjekt)
    {
        anfang = anfang.Entfernen(datenObjekt);
    }

    int AnzahlGeben()
    {
        return anfang.AnzahlGeben();
    }

    void AlleAusgeben()
    {
        anfang.AlleAusgeben();
    }

    boolean IstLeer()
    {
        if (anfang.AnzahlGeben() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
