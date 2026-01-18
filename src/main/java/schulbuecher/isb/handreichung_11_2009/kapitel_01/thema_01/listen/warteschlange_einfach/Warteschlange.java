package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.warteschlange_einfach;

class Warteschlange
{
    private Knoten anfang;

    // Konstruktor
    Warteschlange()
    {
        anfang = null;
    }

    // weitere Methoden
    boolean IstLeer()
    {
        return (anfang == null);
    }

    void EndeEinfuegen(String neuerName, String neuerVorname)
    {
        if (!IstLeer())
            anfang.EndeEinfuegen(neuerName, neuerVorname);
        else
            anfang = new Knoten(anfang, neuerName, neuerVorname);
    }

    String AnfangEntfernen()
    {
        String entfernt;
        if (!IstLeer())
        {
            entfernt = anfang.NameVornameGeben();
            anfang = anfang.NachfolgerGeben();
        }
        else
            entfernt = "";
        return entfernt;
    }

    String AnfangGeben()
    {
        if (!IstLeer())
            return anfang.NameVornameGeben();
        else
            return "";
    }

    void AlleAusgeben()
    {
        if (!IstLeer())
            anfang.AlleAusgeben();
    }

    int AnzahlGeben()
    {
        if (!IstLeer())
            return anfang.AnzahlGeben();
        else
            return 0;
    }
}
