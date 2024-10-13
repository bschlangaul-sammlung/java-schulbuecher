package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_03.thema_05.bildweitergabe;

/**
 * Beschreiben Sie hier die Klasse Beispiel1.
 *
 * @author Anja Stube
 *
 * @version 2023-02-08
 */
public class Einstieg
{
    public void ablaufen()
    {
        GRAPH graph = new GRAPH(7);
        KNOTEN k1 = new KNOTEN("Alan", "A");
        KNOTEN k2 = new KNOTEN("Bao", "B");
        KNOTEN k3 = new KNOTEN("Cedric", "C");
        KNOTEN k4 = new KNOTEN("Ella", "E");
        KNOTEN k5 = new KNOTEN("Freddy", "F");
        KNOTEN k6 = new KNOTEN("Lukas", "L");
        KNOTEN k7 = new KNOTEN("Maja", "M");
        graph.knotenHinzufuegen(k1);
        graph.knotenHinzufuegen(k2);
        graph.knotenHinzufuegen(k3);
        graph.knotenHinzufuegen(k4);
        graph.knotenHinzufuegen(k5);
        graph.knotenHinzufuegen(k6);
        graph.knotenHinzufuegen(k7);
        graph.kanteHinzufuegen(0, 3);
        graph.kanteHinzufuegen(0, 5);
        graph.kanteHinzufuegen(0, 6);
        graph.kanteHinzufuegen(1, 2);
        graph.kanteHinzufuegen(2, 5);
        graph.kanteHinzufuegen(3, 5);
        graph.kanteHinzufuegen(4, 6);
        graph.adjaAusgeben();
        graph.breitensuche(5);
    }
}
