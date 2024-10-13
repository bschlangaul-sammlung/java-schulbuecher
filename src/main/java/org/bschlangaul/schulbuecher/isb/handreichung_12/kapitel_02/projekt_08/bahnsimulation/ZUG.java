package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_08.bahnsimulation;

/**
 * Klasse zur Simulation eines Zuges<br/>
 * der Zugriff auf die freien Plätze ist nicht synchronisiert.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class ZUG
{
    /** die Platznummer im Zug */
    private int platz = 0;

    /** der Name des Zuges */
    private String name = "DB";

    /**
     * Konstruktor
     *
     * @param name der Name des Zuges.
     */
    public ZUG(String name)
    {
        this.name = name;
    }

    /**
     * gibt den Namen des Zuges zurück
     *
     * @return der Name des Zuges
     */
    public String getName()
    {
        return name;
    }

    /**
     * gibt den nächsten freien Platz zurück, es wird in aufsteigender
     * Reihenfolge gebucht.
     *
     * @return der nächsten freie und damit buchbare Platz
     */
    public int nochFrei()
    {
        int n = platz; // letzten reservierten Platz lesen
        try
        { // das Lesen braucht etwas Zeit ...
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (InterruptedException e)
        {
        }
        platz = n + 1; // naechsten (freien) Platz "ermittlen und belegen"
        return platz; // und zurueckgeben
    }
}
