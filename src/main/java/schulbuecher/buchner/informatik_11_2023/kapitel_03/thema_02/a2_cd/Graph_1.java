package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.a2_cd;

/**
 * Beschreiben Sie hier die Klasse Beispiel1.
 *
 * @author Anja Stube
 *
 * @version 2022-04-28
 */
public class Graph_1
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(4);
        KNOTEN k1 = new KNOTEN("A");
        KNOTEN k2 = new KNOTEN("B");
        KNOTEN k3 = new KNOTEN("C");
        KNOTEN k4 = new KNOTEN("D");
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.kanteHinzufuegen(0, 1);
        graph.kanteHinzufuegen(1, 0);
        graph.kanteHinzufuegen(2, 2);
        graph.kanteHinzufuegen(3, 1);
        graph.adjaAusgeben();
    }
}
