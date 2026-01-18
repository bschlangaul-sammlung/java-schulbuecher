package schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_05.bahnhoefe;

/**
 *
 *
 * @author Anja Stube
 *
 * @version 2023-04-24
 */
public class BAHNHOEFE
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(12);
        KNOTEN k1 = new KNOTEN("Hamburg", "HH");
        KNOTEN k2 = new KNOTEN("Bremen", "HB");
        KNOTEN k3 = new KNOTEN("Hannover", "H");
        KNOTEN k4 = new KNOTEN("Berlin", "B");
        KNOTEN k5 = new KNOTEN("Köln", "K");
        KNOTEN k6 = new KNOTEN("Leipzig", "L");
        KNOTEN k7 = new KNOTEN("Dresden", "DD");
        KNOTEN k8 = new KNOTEN("Erfurt", "E");
        KNOTEN k9 = new KNOTEN("Frankfurt", "F");
        KNOTEN k10 = new KNOTEN("Nürnberg", "N");
        KNOTEN k11 = new KNOTEN("Augsburg", "A");
        KNOTEN k12 = new KNOTEN("München", "M");
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.knotenHinzufuegen(k5);
        graph.knotenHinzufuegen(k6);
        graph.knotenHinzufuegen(k7);
        graph.knotenHinzufuegen(k8);
        graph.knotenHinzufuegen(k9);
        graph.knotenHinzufuegen(k10);
        graph.knotenHinzufuegen(k11);
        graph.knotenHinzufuegen(k12);
        graph.kanteHinzufuegen(0, 1);
        graph.kanteHinzufuegen(0, 2);
        graph.kanteHinzufuegen(0, 3);
        graph.kanteHinzufuegen(1, 4);
        graph.kanteHinzufuegen(2, 3);
        graph.kanteHinzufuegen(2, 4);
        graph.kanteHinzufuegen(2, 8);
        graph.kanteHinzufuegen(3, 5);
        graph.kanteHinzufuegen(4, 8);
        graph.kanteHinzufuegen(5, 6);
        graph.kanteHinzufuegen(5, 7);
        graph.kanteHinzufuegen(7, 8);
        graph.kanteHinzufuegen(7, 9);
        graph.kanteHinzufuegen(8, 9);
        graph.kanteHinzufuegen(9, 10);
        graph.kanteHinzufuegen(9, 11);
        graph.kanteHinzufuegen(10, 11);
        // graph.adjaAusgeben();
        graph.breitensuche_2b("Augsburg", "Dresden");
    }
}
