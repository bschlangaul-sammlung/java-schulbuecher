package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_08.bahnsimulation;

/**
 * Hauptprogramm zur Simulation einer Bahnplatzbuchung<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Simulation
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
        Zug[] zuege = new Zug[2];
        zuege[0] = new Zug("DB");
        zuege[1] = new Zug("Vogtlandbahn");
        // Kunden erzeugen...
        Kunde t1 = new Kunde("Kunde 1", zuege);
        Kunde t2 = new Kunde("Kunde 2", zuege);
        // Kunden fragen an und reservieren....
        t1.start();
        t2.start();
    }
}
