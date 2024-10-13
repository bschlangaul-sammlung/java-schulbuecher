package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_12.passives_warten;

/**
 * Erzeuger zur Lieferung eines Artikels<br/>
 * Passives Warten
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Verbraucher extends Thread
{
    /** Referenz auf den Abstellplatz */
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
    public void verarbeiten()
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
     * simuliert die Arbeit des Verbrauchers<br/>
     * falls keine Produkt abgeholt werden konnte, wird der Thread in den
     * Wartezustand versetzt.
     */
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("Hole ab");
            abstellplatz.abholen();
            verarbeiten();
        }
    }
}
