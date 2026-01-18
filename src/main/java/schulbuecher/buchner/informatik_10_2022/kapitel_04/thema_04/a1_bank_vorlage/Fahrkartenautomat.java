package schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_04.a1_bank_vorlage;

/**
 * Klasse Fahrkartenautomat, fuer 4.4 A1
 * <p>
 * https://www.ccbuchner.de/_files_media/mediathek/downloads/11069.zip
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Fahrkartenautomat
{
    private String standort;

    Fahrkartenautomat(String einStandort)
    {
        standort = einStandort;
    }

    void druckeEinzelfahrt(Konto einKonto, int einePin)
    {
        einKonto.abheben(1.80, einePin);
        System.out.println("Fahrkarte entnehmen");
    }
}
