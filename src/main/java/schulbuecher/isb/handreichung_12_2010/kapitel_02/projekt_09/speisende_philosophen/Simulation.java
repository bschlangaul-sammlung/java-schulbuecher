package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_09.speisende_philosophen;

import java.util.ArrayList;

/**
 * Hauptprogramm zur Simulation der speisenden Philosophen<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Simulation
{
    /**
     * Anzahl der Philosophen
     */
    private static final int ANZAHL = 5;

    /**
     * erzeugt (Ess-) Stäbchen und Philosphen
     *
     * @param args wird nicht benötigt
     */
    public static void main(String[] args)
    {
        ArrayList<Philosoph> philosophen = new ArrayList<Philosoph>();
        ArrayList<Stab> staebchen = new ArrayList<Stab>();
        // Stäbchen erzeugen
        for (int i = 0; i < ANZAHL; i++)
        {
            staebchen.add(new Stab());
        }
        // Philosphen erzeugen und linkes und rechtes Stäbchen zuweisen.
        for (int i = 0; i < ANZAHL; i++)
        {
            philosophen.add(new Philosoph(i + "", staebchen.get(i),
                    staebchen.get((i + 1) % ANZAHL)));
        }
        // Philosophen beginnen zu essen und denken...
        for (int i = 0; i < ANZAHL; i++)
        {
            philosophen.get(i).start();
        }
    }
}
