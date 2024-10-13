package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_04.a2_bank_vorlage;

/**
 * Klasse Konto, fuer 4.4 A2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
public class Konto
{
    public double kontostand;

    public int kontonummer;

    public int pin;

    /**
     * Konstruktor für Objekte der Klasse Konto
     */
    public Konto(int eineNummer, int einePin)
    {
        kontostand = 0;
        kontonummer = eineNummer;
        pin = einePin;
    }

    public int gibKontonummer()
    {
        return kontonummer;
    }

    public void einzahlen(double betrag)
    {
        kontostand = kontostand + betrag;
    }

    public void zeigeKontostand(int einePin)
    {
        if (pin == einePin)
        {
            System.out.println(kontostand);
        }
        else
        {
            System.out.println("falsche Eingabe");
        }
    }

    public void abheben(double betrag, int einePin)
    {
        if (pin == einePin)
        {
            kontostand = kontostand - betrag;
        }
        else
        {
            System.out.println("falsche Pin-Eingabe");
        }
    }

    public boolean istKontoGedeckt(double einBetrag, int einePin)
    {
        if (einBetrag > kontostand)
        {
            return false;
        }
        else if (einePin != pin)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
