package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.bank2;

/**
 * Klasse Kunde für Kapitel 4.7, A1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
class Kunde
{
    private String vorname;

    private String name;

    private Konto eigenesKonto;

    private Berater anlageberater;

    private Berater immobilienberater;

    public Kunde(String einVorname, String einNachnname, Konto einKonto)
    {
        vorname = einVorname;
        name = einNachnname;
        eigenesKonto = einKonto;
    }

    public void zeigeEigeneKontoInformationen()
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

    public void setzeAnlageBerater(Berater einBerater)
    {
        anlageberater = einBerater;
    }

    public void setzeImmobilienBerater(Berater einBerater)
    {
        immobilienberater = einBerater;
    }

    public void zeigeEigeneBerater()
    {
        anlageberater.zeigeBeraterInformationen();
        immobilienberater.zeigeBeraterInformationen();
    }
}
