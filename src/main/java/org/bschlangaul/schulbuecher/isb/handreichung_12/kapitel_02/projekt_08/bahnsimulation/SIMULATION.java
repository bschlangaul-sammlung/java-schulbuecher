package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_08.bahnsimulation;

/**
 * Hauptprogramm zur Simulation einer Bahnplatzbuchung<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class SIMULATION
{
    /**
     * erzeugt zwei Informationen über Züge und zwei Kunden die zufällig in den
     * Zügen buchen
     *
     * @param args wird nicht benötigt
     */
    public static void main(String[] args)
    {
        // Züge erzeugen
        ZUG[] zuege = new ZUG[2];
        zuege[0] = new ZUG("DB");
        zuege[1] = new ZUG("Vogtlandbahn");
        // Kunden erzeugen...
        KUNDE t1 = new KUNDE("Kunde 1", zuege);
        KUNDE t2 = new KUNDE("Kunde 2", zuege);
        // Kunden fragen an und reservieren....
        t1.start();
        t2.start();
    }
}
