package schulbuecher.buchner.informatik_10_2022.kapitel_06.bank_vorlage;

/**
 * Klasse Konto für Kapitel 4.6, A1 und A2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Konto
{
    private double kontostand;

    private int kontonummer;

    private int pin;

    public Konto(int eineNummer, int einePin)
    {
        kontostand = 0;
        kontonummer = eineNummer;
        pin = einePin;
    }

    int gibKontonummer()
    {
        return kontonummer;
    }

    void einzahlen(double betrag)
    {
        kontostand = kontostand + betrag;
    }

    private boolean pruefePin(int einePin)
    {
        if (einePin == pin)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void zeigeKontostand(int einePin)
    {
        if (pruefePin(einePin) == true)
        {
            System.out.println(kontostand);
        }
        else
        {
            System.out.println("falsche Eingabe");
        }
    }

    void abheben(double betrag, int einePin)
    {
        if (pruefePin(einePin) == true)
        {
            kontostand = kontostand - betrag;
        }
        else
        {
            System.out.println("falsche Pin-Eingabe");
        }
    }
}
