package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_06.bank;

/**
 * Klasse Kunde für Kapitel 4.6, A1 und A2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-12-01
 */
class Kunde
{
    private String vorname;

    private String name;

    private Konto eigenesKonto;

    public Kunde(String einVorname, String einNachnname, Konto einKonto)
    {
        vorname = einVorname;
        name = einNachnname;
        eigenesKonto = einKonto;
    }

    public void zeigeKontoInformationen()
    {
        System.out.println(
                "Nummer von eigenem Konto: " + eigenesKonto.gibKontonummer());
    }

    public String gibVorname()
    {
        return vorname;
    }

    public String gibName()
    {
        return name;
    }

    public void zeigeEigenenKontostand(int pinEingabe)
    {
        System.out.println("Kontostand von eigenem Konto: ");
        eigenesKonto.zeigeKontostand(pinEingabe);
    }
}
