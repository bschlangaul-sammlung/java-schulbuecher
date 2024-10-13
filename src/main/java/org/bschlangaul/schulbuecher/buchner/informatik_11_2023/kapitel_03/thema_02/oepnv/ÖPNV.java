package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_02.oepnv;

/**
 * Beschreiben Sie hier die Klasse ÖPNV.
 *
 * @author Anja Stube
 *
 * @version 2022-08-31
 */
public class ÖPNV
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(9);
        KNOTEN k1 = new KNOTEN("P"); // Prinzregentenstr.
        KNOTEN k2 = new KNOTEN("S"); // Staatstheater
        KNOTEN k3 = new KNOTEN("A"); // Augsburg Hbf.
        KNOTEN k4 = new KNOTEN("K"); // Königsplatz
        KNOTEN k5 = new KNOTEN("M"); // Moritzplatz
        KNOTEN k6 = new KNOTEN("R"); // Rathausplatz
        KNOTEN k7 = new KNOTEN("F"); // Frohsinnstr.
        KNOTEN k8 = new KNOTEN("T"); // Th.-Heuss-Platz/IHK
        KNOTEN k9 = new KNOTEN("U"); // Ulrichsplatz
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.knotenHinzufuegen(k5);
        graph.knotenHinzufuegen(k6);
        graph.knotenHinzufuegen(k7);
        graph.knotenHinzufuegen(k8);
        graph.knotenHinzufuegen(k9);
        graph.kanteHinzufuegen(0, 1);
        graph.kanteHinzufuegen(1, 0);
        graph.kanteHinzufuegen(1, 2);
        graph.kanteHinzufuegen(1, 3);
        graph.kanteHinzufuegen(2, 0);
        graph.kanteHinzufuegen(2, 3);
        graph.kanteHinzufuegen(3, 1);
        graph.kanteHinzufuegen(3, 2);
        graph.kanteHinzufuegen(3, 4);
        graph.kanteHinzufuegen(3, 6);
        graph.kanteHinzufuegen(3, 7);
        graph.kanteHinzufuegen(4, 3);
        graph.kanteHinzufuegen(4, 5);
        graph.kanteHinzufuegen(4, 8);
        graph.kanteHinzufuegen(5, 4);
        graph.kanteHinzufuegen(6, 3);
        graph.kanteHinzufuegen(7, 3);
        graph.kanteHinzufuegen(8, 5);
        graph.adjaAusgeben();
    }
}
