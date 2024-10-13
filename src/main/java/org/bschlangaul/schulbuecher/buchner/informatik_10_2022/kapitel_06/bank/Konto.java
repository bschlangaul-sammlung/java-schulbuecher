package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_06.bank;

/**
 * Klasse Konto für Kapitel 4.6, A1 und A2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-12-01
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

    private boolean pruefePin(int pinEingabe)
    {
        if (pinEingabe == pin)
            return true;
        else
            return false;
    }

    void zeigeKontostand(int pinEingabe)
    {
        if (pruefePin(pinEingabe) == true)
        {
            System.out.println(kontostand);
        }
        else
        {
            System.out.println("falsche Eingabe");
        }
    }

    void hebeAb(double betrag, int pinEingabe)
    {
        if (pruefePin(pinEingabe) == true)
        {
            kontostand = kontostand - betrag;
        }
        else
        {
            System.out.println("falsche Pin-Eingabe");
        }
    }
}
