package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

class Ganzzahl extends DatenElement
{
    private int zahl;

    Ganzzahl(int neueZahl)
    {
        zahl = neueZahl;
    }

    int Vergleichen(DatenElement vergleichsObjekt)
    {
        Ganzzahl vergleichsZahl = (Ganzzahl) vergleichsObjekt;
        int ergebnis = 0;
        if (zahl < vergleichsZahl.zahl)
            ergebnis = -1;
        if (zahl == vergleichsZahl.zahl)
            ergebnis = 0;
        if (zahl > vergleichsZahl.zahl)
            ergebnis = +1;
        return ergebnis;
    }

    void Ausgeben()
    {
        System.out.println("Zahl: " + zahl);
    }
}
