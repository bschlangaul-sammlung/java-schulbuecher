package schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_02.hauptprogramm_a1_vorlage;

/**
 * Klasse Hauptprogramm, fuer 4.2 A1
 * <p>
 * https://www.ccbuchner.de/_files_media/mediathek/downloads/11074.zip
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Hauptprogramm
{
    public static void hauptprogramm()
    {
        Konto meinKonto = new Konto(1001, 1234);
        System.out.println("Konto eröffnet");
        System.out.println("Der Kontostand ist:");
        meinKonto.zeigeKontostand(1234);
    }
}
