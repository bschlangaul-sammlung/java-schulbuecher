package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_09.freundschaft;

/**
 * Beschreiben Sie hier die Klasse Beispiel1.
 *
 * @author Anja Stube
 *
 * @version 2023-07-08
 */
public class FREUNDSCHAFT
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(7);
        KNOTEN k0 = new KNOTEN("Aaron");
        KNOTEN k1 = new KNOTEN("Felix");
        KNOTEN k2 = new KNOTEN("James");
        KNOTEN k3 = new KNOTEN("Klara");
        KNOTEN k4 = new KNOTEN("Mirko");
        KNOTEN k5 = new KNOTEN("Nico");
        KNOTEN k6 = new KNOTEN("Samiha");
        graph.knotenHinzufuegen(k0);
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.knotenHinzufuegen(k5);
        graph.knotenHinzufuegen(k6);
        graph.kanteHinzufuegen(0, 1, 1.0);
        graph.kanteHinzufuegen(0, 6, 3.4);
        graph.kanteHinzufuegen(1, 3, 6.1);
        graph.kanteHinzufuegen(1, 5, 2.4);
        graph.kanteHinzufuegen(1, 6, 4.7);
        graph.kanteHinzufuegen(3, 4, 0.8);
        graph.kanteHinzufuegen(4, 5, 9.4);
        graph.adjaAusgeben();
        graph.existierenDickeFreunde();
    }
}
