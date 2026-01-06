package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eis;

/**
 * An diesem Eisautomat koennen Kunden fuer 80 Cent ein Eis am Stiel kaufen. Der
 * Automat akzeptiert nur 20-Cent-Muenzen. Er bietet die Eissorten "Aloe Vera",
 * "Ananas" und "Apfelsine" an. Erst wenn der Kunde eine Eissorte gewaehlt hat
 * und mehr als vier Muenzen in den Eisautomat geworfen hat, erhaelt er Eis und
 * Restgeld zurueck. Eine Muenze entspricht einem 20 Cent-Stueck.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Eisautomat
{
    private int anzahlDerMuenzen;

    private String eissorte;

    /**
     * Konstruktor fuer Objekte der Klasse Eisautomat
     */
    public Eisautomat()
    {
        anzahlDerMuenzen = 0;
        eissorte = "nicht gewaehlt";
    }

    /**
     * Mit dieser Methode koennen Sie eine Muenze in den Eiseautomaten werfen.
     */
    public void muenzeEinwerfen()
    {
        anzahlDerMuenzen++;
        if (!eissorte.equals("nicht gewaehlt") && anzahlDerMuenzen >= 4)
        {
            anzahlDerMuenzen = 0;
            System.out.println("Sie erhalten ein " + eissorte + "-Eis.");
            eissorte = "nicht gewaehlt";
        }
    }

    /**
     * Der Automat bietet die Eissorten "Aloe Vera", "Ananas" und "Apfelsine"
     * an.
     */
    public void eissorteWaehlen(String neueEissorte)
    {
        if (neueEissorte.equals("Aloe Vera") || neueEissorte.equals("Ananas")
                || neueEissorte.equals("Apfelsine"))
        {
            eissorte = neueEissorte;
        }
        else
        {
            System.out.println("Der Automat bietet diese Eissorte nicht an!");
            return;
        }
        if (anzahlDerMuenzen >= 4)
        {
            int rueckgeld = anzahlDerMuenzen - 4;
            anzahlDerMuenzen = 0;
            System.out.println("Sie erhalten ein " + eissorte
                    + "-Eis. Rueckgeld: " + rueckgeld * 20 + " Cent");
            eissorte = "nicht gewaehlt";
        }
    }
}
