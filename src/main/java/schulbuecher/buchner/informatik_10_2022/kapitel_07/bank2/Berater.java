package schulbuecher.buchner.informatik_10_2022.kapitel_07.bank2;

/**
 * Klasse Berater, fuer 4.7 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
public class Berater
{
    private String vorname;

    private String nachname;

    private String sachgebiet;

    public Berater(String einVorname, String einNachname, String einSachgebiet)
    {
        vorname = einVorname;
        nachname = einNachname;
        sachgebiet = einSachgebiet;
    }

    public void zeigeBeraterInformationen()
    {
        System.out.println("Nachname: " + nachname);
        System.out.println("Vorname: " + vorname);
        System.out.println("Sachgebiet: " + sachgebiet);
    }
}
