package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_03.bank_a1_vorlage;

/**
 * Klasse Hauptprogramm, fuer 4.3 A1
 * <p>
 * https://www.ccbuchner.de/clip_code-38010-26/
 * <p>
 * https://www.ccbuchner.de/_files_media/mediathek/downloads/11071.zip
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Hauptprogramm
{
    public static void main()
    {
        Konto k = new Konto(1, 1234);
        System.out.println("Kontostand anzeigen:");
        k.zeigeKontostand(1234);
    }
}
