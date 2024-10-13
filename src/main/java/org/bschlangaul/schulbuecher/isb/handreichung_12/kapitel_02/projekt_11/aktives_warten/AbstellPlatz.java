package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_11.aktives_warten;

/**
 * Abstellplatz zur Aufnahme eines Produkts<br/>
 * aktives Warten
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
     * belegt den Abstellplatz, falls er frei ist.<br/>
     *
     * @return true, falls der Platz belegt werden konnte
     */
    public synchronized boolean ablegen()
    {
        if (!platzbelegt)
        {
            platzbelegt = true;
            System.out.println("Platz wurde belegt");
            return true;
        }
        return false;
    }

    /**
     * holt das Produkt vom Abstellplatz, falls er belegt ist.<br/>
     * die Methode ist <b>nicht synchronisiert!y</b>
     *
     * @return true, falls das Produkt abgeholt werden konnte.
     */
    public synchronized boolean abholen()
    {
        if (platzbelegt)
        {
            platzbelegt = false;
            System.out.println("Platz wurde frei");
            return true;
        }
        return false;
    }
}
