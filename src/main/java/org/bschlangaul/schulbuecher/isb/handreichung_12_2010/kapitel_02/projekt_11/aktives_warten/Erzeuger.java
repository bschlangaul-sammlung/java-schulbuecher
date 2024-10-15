package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_11.aktives_warten;

/**
 * Erzeuger zur Lieferung eines Produkts<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Erzeuger extends Thread
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
    public Erzeuger(AbstellPlatz abstellplatz)
    {
        this.abstellplatz = abstellplatz;
    }

    /**
     * simuliert durch Warten das Produzieren eines Produkts
     *
     */
    private void produzieren()
    {
        // erzeugen(), braucht Zeit;
        try
        {
            sleep((int) (Math.random() * 100));
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * simuliert die Arbeit des Erzeugers:<br/>
     * falls das Ablegen des produzierten Produkt gelingt, wird erneut
     * produziert, andernfalls versucht der Erzeuger erneut den Produkt
     * abzulegen.
     */
    @Override
    public void run()
    {
        produzieren();
        while (true)
        {
            System.out.println("lege ab");
            if (abstellplatz.ablegen())
            {
                produzieren();
            }
        }
    }
}
