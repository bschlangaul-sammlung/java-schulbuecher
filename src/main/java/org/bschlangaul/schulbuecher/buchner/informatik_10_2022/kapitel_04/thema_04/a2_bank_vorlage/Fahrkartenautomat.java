package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_04.a2_bank_vorlage;

/**
 * Klasse Fahrkartenautomat, fuer 4.4 A2
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
        if (einKonto.istKontoGedeckt(1.80, einePin) == true)
        {
            einKonto.abheben(1.80, einePin);
            System.out.println("Fahrkarte entnehmen");
        }
        else
        {
            System.out.println("Vorgang nicht möglich.");
        }
    }
}
