package schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_01.bank_a3;

/**
 * Lösung 4.1 A3 Klasse Konto
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-01-31
 */
class Konto
{
    // Instanzvariablen
    double kontostand;

    int kontonummer;

    int pin;

    /**
     * Konstruktor für Objekte der Klasse Konto
     */
    Konto(int eineNummer, int einePin)
    {
        // Instanzvariablen initialisieren
        kontostand = 0;
        kontonummer = eineNummer;
        pin = einePin;
    }

    void zahleEin(double betrag)
    {
        kontostand = kontostand + betrag;
    }

    void zeigeKontostand(int pinEingabe)
    {
        if (pinEingabe == pin)
        {
            System.out.println(kontostand);
        }
        else
        {
            System.out.println("falsche Pin");
        }
    }
}
