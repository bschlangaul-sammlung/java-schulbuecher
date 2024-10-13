package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_06.bank_vorlage;

/**
 * Klasse Hauptprogramm für Kapitel 4.6, A1 und A2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Hauptprogramm
{
    public static void main()
    {
        Konto konto1 = new Konto(1, 1234);
        Kunde kunde1 = new Kunde("Zariah", "Huber", konto1);
        kunde1.zeigeEigeneKontoInformationen();
    }
}
