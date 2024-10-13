package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_03;

/**
 * Baut eine Adjazenzmatrix entsprechend der Aufgabe 3 in Kapitel 13 im Buch
 * Informatik Oberstufe 2 Oldenbourg Verlag auf und ermöglicht den
 * Laufzeitvergleich zwischen Brute-Force-Suche und Dijkstra-Algorithmus sowie
 * je eine Messreihe für die beiden Algorithmen bei wachsender Knotenzahl der
 * Graphen.
 *
 * @author K. Reinold, basierend auf einem Projekt von U. Freiberger
 *
 * @version 1.0
 */
public class Arbeit
{
    /**
     * Konstruktor der Klasse ARBEIT
     */
    public Arbeit()
    {
    }

    /**
     * Führt sämtliche Arbeiten zur Implementierung des Graphen abhängig von der
     * eingegebenen Knotenanzahl aus: Instanzieren des Graphenobjekts; Einfügen
     * der Knoten und Einfügen der Kanten Maximal sind 22 Knoten möglich, aber
     * es können auch weitere im Code hinzugefügt werden. Die Kanten werden nur
     * dann eingefügt, wenn die beiden Endknoten Teil des Graphen sind.
     *
     * @param knotenzahl Anzahl der Knoten des Graphen (Werte zwischen 1 und 22,
     *     falls nicht weitere Knoten ergänzt werden)
     *
     */
    public GraphMatrix GraphErzeugen(int knotenzahl)
    {
        // Erzeugen eines Graphenobjekts g
        GraphMatrix g = new GraphMatrix(knotenzahl);
        // Anlegen der Knoten
        if (knotenzahl >= 1)
            g.KnotenEinfuegen("WÜ");
        if (knotenzahl >= 2)
            g.KnotenEinfuegen("F");
        if (knotenzahl >= 3)
            g.KnotenEinfuegen("N");
        if (knotenzahl >= 4)
            g.KnotenEinfuegen("M");
        if (knotenzahl >= 5)
            g.KnotenEinfuegen("KA");
        if (knotenzahl >= 6)
            g.KnotenEinfuegen("LI");
        if (knotenzahl >= 7)
            g.KnotenEinfuegen("FD");
        if (knotenzahl >= 8)
            g.KnotenEinfuegen("HO");
        if (knotenzahl >= 9)
            g.KnotenEinfuegen("PA");
        if (knotenzahl >= 10)
            g.KnotenEinfuegen("R");
        if (knotenzahl >= 11)
            g.KnotenEinfuegen("RO");
        if (knotenzahl >= 12)
            g.KnotenEinfuegen("S");
        if (knotenzahl >= 13)
            g.KnotenEinfuegen("UL");
        if (knotenzahl >= 14)
            g.KnotenEinfuegen("A");
        if (knotenzahl >= 15)
            g.KnotenEinfuegen("DO");
        if (knotenzahl >= 16)
            g.KnotenEinfuegen("KS");
        if (knotenzahl >= 17)
            g.KnotenEinfuegen("L");
        if (knotenzahl >= 18)
            g.KnotenEinfuegen("DD");
        if (knotenzahl >= 19)
            g.KnotenEinfuegen("PB");
        if (knotenzahl >= 20)
            g.KnotenEinfuegen("BI");
        if (knotenzahl >= 21)
            g.KnotenEinfuegen("K");
        // Anlegen der Kanten
        g.KanteEinfuegen("KA", "F", 127);
        g.KanteEinfuegen("F", "WÜ", 131);
        g.KanteEinfuegen("WÜ", "N", 104);
        g.KanteEinfuegen("N", "R", 80);
        g.KanteEinfuegen("R", "PA", 72);
        g.KanteEinfuegen("HO", "WÜ", 192);
        g.KanteEinfuegen("HO", "N", 116);
        g.KanteEinfuegen("HO", "R", 166);
        g.KanteEinfuegen("FD", "WÜ", 98);
        g.KanteEinfuegen("M", "A", 64);
        g.KanteEinfuegen("M", "N", 163);
        g.KanteEinfuegen("M", "R", 117);
        g.KanteEinfuegen("M", "RO", 60);
        g.KanteEinfuegen("UL", "A", 59);
        g.KanteEinfuegen("UL", "WÜ", 165);
        g.KanteEinfuegen("UL", "LI", 126);
        g.KanteEinfuegen("UL", "S", 103);
        g.KanteEinfuegen("S", "KA", 53);
        g.KanteEinfuegen("S", "WÜ", 155);
        g.KanteEinfuegen("DO", "KS", 150);
        g.KanteEinfuegen("DO", "F", 204);
        g.KanteEinfuegen("KS", "FD", 100);
        g.KanteEinfuegen("KS", "L", 244);
        g.KanteEinfuegen("L", "HO", 143);
        g.KanteEinfuegen("L", "DD", 105);
        g.KanteEinfuegen("DD", "HO", 168);
        g.KanteEinfuegen("PB", "DO", 108);
        g.KanteEinfuegen("PB", "KS", 105);
        g.KanteEinfuegen("PB", "BI", 48);
        g.KanteEinfuegen("DO", "BI", 117);
        g.KanteEinfuegen("K", "F", 117);
        g.KanteEinfuegen("K", "DO", 194);
        return g;
    }

    /**
     * Führt für das Brute-Force-Verfahren eine Messreihe bei wachsender
     * Knotenzahl (Werte z. Zt. von 1 bis 22) durch. Jeder Messwert entsteht aus
     * 10000-facher Durchführung und Minimumsbestimmung.
     */
    public void BruteForceMessreihe()
    {
        // Erzeugen eines Graphenobjekts g
        for (int knotenzahl = 1; knotenzahl < 23; knotenzahl++)
        {
            GraphMatrix g = GraphErzeugen(knotenzahl);
            // Suche aller Wege (Brute-Force-Verfahren)
            long minLaufzeit, dauer;
            long startNanoTime = System.nanoTime();
            g.WegeSuchen("M", "F");
            minLaufzeit = System.nanoTime() - startNanoTime;
            for (int i = 0; i < 1000; i++)
            {
                startNanoTime = System.nanoTime();
                g.WegeSuchen("M", "F");
                dauer = System.nanoTime() - startNanoTime;
                if (dauer < minLaufzeit)
                {
                    minLaufzeit = dauer;
                }
            }
            System.out.println(minLaufzeit);
        }
    }

    /**
     * Führt für das Dijkstra-Verfahren eine Messreihe bei wachsender Knotenzahl
     * (Werte z. Zt. von 1 bis 22) durch. Jeder Messwert entsteht aus
     * 10000-facher Durchführung und Minimumsbestimmung.
     */
    public void DijkstraMessreihe()
    {
        // Erzeugen eines Graphenobjekts g
        for (int knotenzahl = 1; knotenzahl < 23; knotenzahl++)
        {
            GraphMatrix g = GraphErzeugen(knotenzahl);
            // Suche des kürzesten Weges mit Dijkstra
            long minLaufzeit, dauer;
            long startNanoTime = System.nanoTime();
            startNanoTime = System.nanoTime();
            g.KuerzesterWeg("M", "F");
            minLaufzeit = System.nanoTime() - startNanoTime;
            for (int i = 0; i < 1000; i++)
            {
                startNanoTime = System.nanoTime();
                g.KuerzesterWeg("M", "F");
                dauer = System.nanoTime() - startNanoTime;
                if (dauer < minLaufzeit)
                {
                    minLaufzeit = dauer;
                }
            }
            System.out.println(minLaufzeit);
        }
    }

    /**
     * Vergleicht bei gegebener Knotenzahl die Laufzeit des Dijkstra-Algorithmus
     * mit der des Brute-Force-Verfahrens. Die Laufzeitmessung erfolgt als
     * Minimumsbestimmmung nach 10000-facher Durchführung.
     *
     */
    public void LaufzeitVergleichen(int knotenzahl)
    {
        // Erzeugen eines Graphenobjekts g
        GraphMatrix g = GraphErzeugen(knotenzahl);
        System.out.println("Knotenanzahl: " + knotenzahl);
        // Suche aller Wege (Brute-Force-Verfahren)
        long minLaufzeit, dauer;
        long startNanoTime = System.nanoTime();
        g.WegeSuchen("M", "F");
        minLaufzeit = System.nanoTime() - startNanoTime;
        for (int i = 0; i < 10000; i++)
        {
            startNanoTime = System.nanoTime();
            g.WegeSuchen("M", "F");
            dauer = System.nanoTime() - startNanoTime;
            if (dauer < minLaufzeit)
            {
                minLaufzeit = dauer;
            }
        }
        System.out.println("Suche aller Wege (Brute Force): " + minLaufzeit
                + " Nanosekunden");
        // Suche des kürzesten Weges mit Dijkstra
        startNanoTime = System.nanoTime();
        g.KuerzesterWeg("M", "F");
        minLaufzeit = System.nanoTime() - startNanoTime;
        for (int i = 0; i < 10000; i++)
        {
            startNanoTime = System.nanoTime();
            g.KuerzesterWeg("M", "F");
            dauer = System.nanoTime() - startNanoTime;
            if (dauer < minLaufzeit)
            {
                minLaufzeit = dauer;
            }
        }
        System.out.println("Suche kürzester Weg nach Dijkstra: " + minLaufzeit
                + " Nanosekunden");
    }
}
