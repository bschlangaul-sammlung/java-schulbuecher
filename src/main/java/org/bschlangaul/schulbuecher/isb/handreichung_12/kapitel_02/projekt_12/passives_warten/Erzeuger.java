package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_12.passives_warten;

/**
 * Erzeuger zur Lieferung eines Artikels<br/>
 * Passives Warten
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Erzeuger extends Thread
{
    /** Referenz auf den Abstellplatz */
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
     * simuliert durch Warten das Produzieren eines Artikels
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
     * simuliert die Arbeit des Erzeugers<br/>
     * falls das Produkt nicht abgelegt werden konnte, wird der Thread in den
     * Wartezustand versetzt.
     */
    @Override
    public void run()
    {
        while (true)
        {
            produzieren();
            abstellplatz.ablegen();
        }
    }
}
