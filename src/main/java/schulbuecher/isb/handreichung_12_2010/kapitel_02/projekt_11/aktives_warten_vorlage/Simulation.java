package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_11.aktives_warten_vorlage;

/**
 * Hauptprogramm zur Simulation des aktiven Wartens<br/>
 * Vorlage für die Aufgabe 1, Kapitel 2.4.2.3
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Simulation
{
    /**
     * erstellt Objekte der Klassen AbstellPlatz, Erzeuger und Verbraucher und
     * startet die jeweiligen Threads.
     *
     * @param args wird nicht benötigt
     */
    public static void main(String[] args)
    {
        AbstellPlatz abstellplatz = new AbstellPlatz();
        Verbraucher verbraucher = new Verbraucher(abstellplatz);
        // optional mehr Verbraucher
        // Verbraucher verbraucher2 = new Verbraucher(abstellplatz);
        // Verbraucher verbraucher3 = new Verbraucher(abstellplatz);
        Erzeuger erzeuger = new Erzeuger(abstellplatz);
        // optional mehr Erzeuger
        // Erzeuger erzeuger2 = new Erzeuger(abstellplatz);
        verbraucher.start();
        erzeuger.start();
        // optionale Threads starten.
        // verbraucher2.start();
        // verbraucher3.start();
        // erzeuger2.start();
    }
}
