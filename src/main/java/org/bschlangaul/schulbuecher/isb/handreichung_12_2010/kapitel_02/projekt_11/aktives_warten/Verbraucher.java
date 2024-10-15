package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_11.aktives_warten;

/**
 * Verbraucher zur Weiterverarbeitung eines Produkts<br/>
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
        while (true)
        {
            System.out.println("hole ab");
            if (abstellplatz.abholen())
            {
                verarbeiten();
            }
        }
    }
}
