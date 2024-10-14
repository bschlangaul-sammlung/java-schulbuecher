
import java.util.*;
/**
 * Lösung für das klassische Rucksackproblem
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Rucksack
{
    /** Feld der Gewichte der Vorräte. */
    private ArrayList<Integer> gewichte;
    /** Feld der Nährwerte der Vorräte */
    private ArrayList<Integer> nährwerte;
    /** Feld der Nummern der aktuellen Vorräte */
    private ArrayList<Integer> aktuelleVorräte;
    /** Feld der Nummern der optimalen Vorräte */
    private ArrayList<Integer> optimaleVorräte;
    /** Optimaler Nährwert */
    private int optimalerNährwert;
    /** Maximales Gewicht im Rucksack */
    private final int maximalGewicht;
    
    /**
     * Legt die Vorratsdaten und die Attribute an.
     */
    Rucksack ()
    {
        maximalGewicht = 30;
        gewichte = new ArrayList<Integer>();
        gewichte.add(5);
        gewichte.add(7);
        gewichte.add(4);
        gewichte.add(3);
        gewichte.add(10);
        gewichte.add(12);
        gewichte.add(13);
        gewichte.add(8);
        nährwerte = new ArrayList<Integer>();
        nährwerte.add(40);
        nährwerte.add(35);
        nährwerte.add(12);
        nährwerte.add(30);
        nährwerte.add(25);
        nährwerte.add(84);
        nährwerte.add(78);
        nährwerte.add(80);
        aktuelleVorräte = new ArrayList<Integer>();
        optimaleVorräte = new ArrayList<Integer>();
        optimalerNährwert = -1;
        SchrittAusführen(0, 0, 0);
        OptimalenVorratAusgeben();
    }
    
    /**
     * Speichert den aktuellen Vorrat als optimalen Vorrat.
     * @param nährwert: der Gesamtnährwert des gespeicherten Vorrats.
     */
    private void OptimumSichern(int nährwert)
    {
        optimaleVorräte = new ArrayList<Integer>();
        for (Integer i: aktuelleVorräte)
        {
            optimaleVorräte.add(i);
        }
        optimalerNährwert = nährwert;
    }
    
    /**
     * Gibt den optimalen Vorrakt auf die Konsole aus.
     */
    void OptimalenVorratAusgeben()
    {
        System.out.println("Der optimale Vorrat hat den Gesamtnährwert " + optimalerNährwert + "MJ");
        System.out.println("Einzelvorräte");
        for (Integer i: optimaleVorräte)
        {
            System.out.println("Nummer " + i + ": Gewicht " + gewichte.get(i) + "kg, Nährwert: " + nährwerte.get(i) + "MJ");
        }
    }
    
    /**
     * Fügt den nächsten Vorrat zu den bisherigen Vorräten hinzu
     * @param startIndex der Index, ab dem die Vorräte ergänzt werden können.
     * @param aktuellesGewicht das Gewicht des bisherigen Vorratsstapels
     * @param aktuellerNährwert der Nährwert des bisherigen Vorratsstapels
     */
    private void SchrittAusführen(int startIndex, int aktuellesGewicht, int aktuellerNährwert)
    {
        for (int index = startIndex; index < gewichte.size(); index += 1)
        {
            if (gewichte.get(index) + aktuellesGewicht <= maximalGewicht)
            {
                aktuelleVorräte.add(index);
                if (nährwerte.get(index) + aktuellerNährwert > optimalerNährwert)
                {
                    OptimumSichern(nährwerte.get(index) + aktuellerNährwert);
                }
                SchrittAusführen(index + 1, gewichte.get(index) + aktuellesGewicht, nährwerte.get(index) + aktuellerNährwert);
                aktuelleVorräte.remove(aktuelleVorräte.size() - 1);
            }
        }
    }
}
