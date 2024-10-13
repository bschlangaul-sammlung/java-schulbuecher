package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.bank2;

/**
 * Klasse Hauptprogramm für Kapitel 4.7, A1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
public class Hauptprogramm
{
    public static void main()
    {
        Konto konto1giro = new Konto(1, 1234);
        Kunde kunde1 = new Kunde("Ahmed", "Müller", konto1giro);
        kunde1.zeigeEigeneKontoInformationen();
        Berater berater1 = new Berater("Anton", "Bucher", "Anlage");
        Berater berater2 = new Berater("Lisa", "Muster", "Immobilien");
        kunde1.setzeAnlageBerater(berater1);
        kunde1.setzeImmobilienBerater(berater2);
        kunde1.zeigeEigeneBerater();
    }
}
