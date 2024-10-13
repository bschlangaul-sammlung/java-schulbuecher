package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.umsetzung_graph;

/**
 * Beschreiben Sie hier die Klasse Beispiel1.
 *
 * @author Anja Stube
 *
 * @version 2022-04-28
 */
public class Achterbahn
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(6);
        KNOTEN k1 = new KNOTEN("Bernd");
        KNOTEN k2 = new KNOTEN("Doris");
        KNOTEN k3 = new KNOTEN("Fatma");
        KNOTEN k4 = new KNOTEN("Gerda");
        KNOTEN k5 = new KNOTEN("Jakob");
        KNOTEN k6 = new KNOTEN("Simon");
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.knotenHinzufuegen(k5);
        graph.knotenHinzufuegen(k6);
        graph.kanteHinzufuegen(0, 1);
        graph.kanteHinzufuegen(0, 3);
        graph.kanteHinzufuegen(1, 0);
        graph.kanteHinzufuegen(1, 4);
        graph.kanteHinzufuegen(1, 5);
        graph.kanteHinzufuegen(2, 1);
        graph.kanteHinzufuegen(2, 3);
        graph.kanteHinzufuegen(3, 4);
        graph.kanteHinzufuegen(3, 5);
        graph.kanteHinzufuegen(4, 2);
        graph.kanteHinzufuegen(5, 0);
        graph.kanteHinzufuegen(5, 2);
        graph.kanteHinzufuegen(5, 4);
        graph.adjaAusgeben();
    }
}
