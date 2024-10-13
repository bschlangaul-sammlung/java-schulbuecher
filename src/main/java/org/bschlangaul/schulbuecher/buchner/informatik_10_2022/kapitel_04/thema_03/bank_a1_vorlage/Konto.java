package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_03.bank_a1_vorlage;

/**
 * Klasse Konto, fuer 4.3 A1
 * <p>
 * https://www.ccbuchner.de/clip_code-38010-26/
 * <p>
 * https://www.ccbuchner.de/_files_media/mediathek/downloads/11071.zip
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
}
