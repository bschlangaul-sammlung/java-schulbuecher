package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

class Ganzzahl extends DatenElement
{
    private int zahl;

    Ganzzahl(int neueZahl)
    {
        zahl = neueZahl;
    }

    void Ausgeben()
    {
        System.out.println("Zahl: " + zahl);
    }
}
