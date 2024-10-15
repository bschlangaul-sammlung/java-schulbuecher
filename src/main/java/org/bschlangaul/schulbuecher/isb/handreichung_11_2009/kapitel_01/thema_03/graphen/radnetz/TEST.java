package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_03.graphen.radnetz;

/**
 * Diese Klasse gibt das konkrete Radnetz als Testbeispiel an.
 */
class TEST
{
    // Für Testzwecke darf auf den Graphen selbst zugegriffen werden.
    public GRAPH_MATRIX radnetz;

    // Konstruktor
    TEST()
    {
        radnetz = new GRAPH_MATRIX(20);
        // Zu Testzwecken werden die ersten sieben Knoten fest angegeben.
        // Die Rueckgabewerte bezeichnen den Index des Knotens.
        int a = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Altdorf", 100, "Marktplatz"));
        int f = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Fischbach", 80, "Fischspezialitaeten"));
        int w = radnetz
                .knotenHinzufuegen(new DATENELEMENT("Weiler", 20, "Naturbad"));
        int z = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Ziegelstein", 200, "Heimatmuseum"));
        int b = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Burg", 50, "Historische Burg"));
        int n = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Neustadt", 80, "Einkaufszentrum"));
        int r = radnetz.knotenHinzufuegen(
                new DATENELEMENT("Rain", 50, "Klettergarten"));
        // Zu Testzwecken werden Kanten zwischen obigen Knoten festgelegt.
        radnetz.kanteHinzufuegen(a, f, 20);
        radnetz.kanteHinzufuegen(a, w, 15);
        radnetz.kanteHinzufuegen(f, a, 10);
        radnetz.kanteHinzufuegen(f, w, 10);
        radnetz.kanteHinzufuegen(w, f, 25);
        radnetz.kanteHinzufuegen(w, z, 5);
        radnetz.kanteHinzufuegen(z, f, 15);
        radnetz.kanteHinzufuegen(z, b, 20);
        radnetz.kanteHinzufuegen(b, z, 5);
        radnetz.kanteHinzufuegen(b, f, 15);
        radnetz.kanteHinzufuegen(z, n, 15);
        radnetz.kanteHinzufuegen(n, r, 20);
        radnetz.kanteHinzufuegen(r, b, 25);
        // Die Tiefensuche mit dem Start "Ziegelstein" ausfuehren
        radnetz.tiefensucheStarten(z);
    }

    // Alles ausgeben
    void ausgeben()
    {
        radnetz.knotenAusgeben();
        radnetz.matrixAusgeben();
    }
}
