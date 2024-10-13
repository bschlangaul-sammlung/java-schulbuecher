package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_11.aktives_warten_vorlage;

/**
 * Verbraucher zur Weiterverarbeitung eines Produkts<br/>
 * Vorlage für die Aufgabe 1, Kapitel 2.4.2.3 Quellcodeergänzung notwendig!
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Verbraucher extends Thread
{
    /**
     * Referenz auf den Abstellplatz
     */
    AbstellPlatz abstellplatz;

    /**
     * Konstruktor
     *
     * @param abstellplatz der Abstellplatz zur Anlieferung
     */
    public Verbraucher(AbstellPlatz abstellplatz)
    {
        this.abstellplatz = abstellplatz;
    }

    /**
     * simuliert durch Warten das Verarbeiten eines Produkts
     *
     */
    private void verarbeiten()
    {
        try
        {
            // produzieren braucht Zeit
            sleep((int) (Math.random() * 100));
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * simuliert die Arbeit des Verbrauchers:<br/>
     * falls das Abholen des produzierten Produkt gelingt, wird
     * weiterverarbeitet, andernfalls wird weiter versucht einen Produkt
     * abzuholen.
     */
    @Override
    public void run()
    {
        // Quellcodeergänzung nötig
    }
}
