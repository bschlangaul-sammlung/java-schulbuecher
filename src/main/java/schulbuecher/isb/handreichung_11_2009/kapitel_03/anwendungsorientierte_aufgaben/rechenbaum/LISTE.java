package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class LISTE
{
    private LISTENELEMENT anfang;

    // Konstruktor
    LISTE()
    {
        anfang = new ABSCHLUSS_LISTE();
    }

    // weitere Methoden
    void AnfangEinfuegen(BAUM baum)
    {
        KNOTEN_LISTE n = new KNOTEN_LISTE(anfang, baum);
        anfang = n;
    }

    BAUM AnfangEntfernen()
    {
        BAUM entfernt;
        entfernt = anfang.DatenGeben();
        anfang = anfang.NachfolgerGeben();
        return entfernt;
    }
}
