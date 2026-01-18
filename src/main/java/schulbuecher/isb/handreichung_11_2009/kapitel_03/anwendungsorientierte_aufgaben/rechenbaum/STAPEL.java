package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class STAPEL
{
    private LISTE liste;

    // Konstruktor
    STAPEL()
    {
        liste = new LISTE();
    }

    // Methoden
    void Einfuegen(BAUM baum)
    {
        liste.AnfangEinfuegen(baum);
    }

    BAUM Entfernen()
    {
        return liste.AnfangEntfernen();
    }
}
