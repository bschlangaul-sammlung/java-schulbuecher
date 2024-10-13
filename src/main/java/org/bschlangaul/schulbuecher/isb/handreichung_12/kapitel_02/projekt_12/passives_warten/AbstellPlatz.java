package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_12.passives_warten;

/**
 * Abstellplatz zur Aufnahme eines Produkts<br/>
 * passives Warten
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class AbstellPlatz
{
    /**
     * wahr, wenn der Platz belegt ist
     */
    private boolean platzbelegt = false;

    /**
     * belegt den Abstellplatz, falls nicht frei ist.<br/>
     *
     * falls der Platz belegt ist, werden Threads die den Zugriff versuchen in
     * den Wartezustand versetzt.
     */
    public synchronized void ablegen()
    {
        while (platzbelegt)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        platzbelegt = true;
        System.out.println("Platz wurde belegt");
        notifyAll();
    }

    /**
     * holt das Produkt vom Abstellplatz, falls er belegt ist.<br/>
     *
     * falls keine Produkt vorhanden ist (der Platz ist nicht belegt), werden
     * Threads die den Zugriff versuchen in den Wartezustand versetzt.
     */
    public synchronized void abholen()
    {
        while (!platzbelegt)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }
        platzbelegt = false;
        System.out.println("Platz wurde frei");
        notifyAll();
    }
}
