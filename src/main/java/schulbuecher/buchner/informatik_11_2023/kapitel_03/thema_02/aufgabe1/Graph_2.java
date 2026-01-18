package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.aufgabe1;

/**
 * Beschreiben Sie hier die Klasse Beispiel1.
 *
 * @author Anja Stube
 *
 * @version 2022-04-28
 */
public class Graph_2
{
    public void ablaufen()
    {
        GRAPH_ungerichtet graph = new GRAPH_ungerichtet(4);
        KNOTEN k1 = new KNOTEN("K1");
        KNOTEN k2 = new KNOTEN("K2");
        KNOTEN k3 = new KNOTEN("K3");
        KNOTEN k4 = new KNOTEN("K4");
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.kanteHinzufuegen(0, 1, 4);
        graph.kanteHinzufuegen(0, 2, 7);
        graph.kanteHinzufuegen(0, 3, 3);
        graph.kanteHinzufuegen(1, 2, 10);
        graph.kanteHinzufuegen(2, 3, 5);
        graph.adjaAusgeben();
    }
}
