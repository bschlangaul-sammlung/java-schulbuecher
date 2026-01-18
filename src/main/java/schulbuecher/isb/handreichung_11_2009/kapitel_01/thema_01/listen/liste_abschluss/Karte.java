package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

class Karte extends DatenElement
{
    private String rang;

    private int anzahl;

    private float preis;

    Karte(String neuerRang, int neueAnzahl, float neuerPreis)
    {
        rang = neuerRang;
        anzahl = neueAnzahl;
        preis = neuerPreis;
    }

    void Ausgeben()
    {
        System.out.println("Karte: " + rang + ", " + anzahl + ", " + preis);
    }
}
