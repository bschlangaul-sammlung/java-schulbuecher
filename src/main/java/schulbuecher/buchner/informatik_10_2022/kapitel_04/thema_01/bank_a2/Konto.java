package schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_01.bank_a2;

/**
 * Lösung 4.1 A2 Klasse Konto.
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-01-31
 */
class Konto
{
    double kontostand;

    /**
     * Konstruktor für Objekte der Klasse Konto
     */
    Konto()
    {
        // Instanzvariable initialisieren
        kontostand = 0;
    }

    void zahleEin(double betrag)
    {
        kontostand = kontostand + betrag;
    }
}
