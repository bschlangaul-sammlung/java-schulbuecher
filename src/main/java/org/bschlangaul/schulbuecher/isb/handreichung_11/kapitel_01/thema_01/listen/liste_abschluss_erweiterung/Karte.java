package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

class Karte extends DatenElement
{
    private String rang;

    private int anzahl;

    private float preis;

    Karte(String neuerRang, int neueAnzahl, float neuerPreis)
    {
        super();
        rang = neuerRang;
        anzahl = neueAnzahl;
        preis = neuerPreis;
    }

    int Vergleichen(DatenElement vergleichsObjekt)
    {
        Karte vergleichsKarte = (Karte) vergleichsObjekt;
        return rang.compareTo(vergleichsKarte.rang);
    }

    void Ausgeben()
    {
        System.out.println("Karte: " + rang + ", " + anzahl + ", " + preis);
    }
}
