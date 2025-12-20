package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.flugnetz;

class Flugnetz
{
    // Attribute
    private GraphMatrix flugnetz;

    // Konstruktor
    Flugnetz()
    {
        flugnetz = new GraphMatrix(10);
        FlughaefenAnlegen();
        FlugverbindungenAnlegen();
    }

    // Methoden
    /**
     * Hilfsmethode zum Füllen des Knoten-Feldes Die Belegung des Knotenfeldes
     * erfolgt in der Reihenfolge der Nr., die in der Tabelle gegeben ist. Damit
     * stimmen Feldindex und Flughafennr überein.
     */
    private void FlughaefenAnlegen()
    {
        FlughafenHinzufuegen("Heathrow", "London", false);
        FlughafenHinzufuegen("Tegel", "Berlin", true);
        FlughafenHinzufuegen("Charles de Gaulle", "Paris", false);
        FlughafenHinzufuegen("Franz Josef Strauss", "Muenchen", false);
        FlughafenHinzufuegen("Leonardo da Vinci", "Rom", true);
        FlughafenHinzufuegen("Wien", "Wien", false);
        FlughafenHinzufuegen("W.A.Mozart", "Salzburg", false);
    }

    /**
     * Hilfsmethode zur Belegung der Adjazenzmatrix
     */
    private void FlugverbindungenAnlegen()
    {
        FlugverbindungHinzufuegen(0, 2, 212);
        FlugverbindungHinzufuegen(2, 1, 545);
        FlugverbindungHinzufuegen(1, 3, 313);
        FlugverbindungHinzufuegen(3, 4, 433);
        FlugverbindungHinzufuegen(2, 4, 695);
        FlugverbindungHinzufuegen(5, 6, 155);
    }

    /**
     * Aufgabe 2 Hinzufuegen eines neuen Flughafens Ausgenuetzt wird dabei die
     * Methode knotenHinzufuegen(DATENELEMENT inhalt) der Klasse GRAPH_MATRIX
     */
    void FlughafenHinzufuegen(String flughafenname, String stadt,
            boolean zuganbindung)
    {
        DatenElement daten = new DatenElement(flughafenname, stadt,
                zuganbindung);
        flugnetz.KnotenHinzufuegen(daten);
    }

    /**
     * Aufgabe 2 Hinzufuegen einer neuen Flugverbindung Ausgenuetzt wird dabei
     * die Methode kanteHinzufügen(int start, int ziel, int bewertung) der
     * Klasse GRAPH_MATRIX Es wird davon ausgegangen, dass es sich immer um
     * bidirektionale Verbindungen handelt!
     */
    void FlugverbindungHinzufuegen(int flughafennr01, int flughafennr02,
            int entfernung)
    {
        flugnetz.KanteHinzufügen(flughafennr01, flughafennr02, entfernung);
        flugnetz.KanteHinzufügen(flughafennr02, flughafennr01, entfernung);
    }

    /**
     * Aufgabe 3: Suchen der Flughaefen mit Bahnanbindung Es reicht hier, das
     * Flughafen-Feld zu untersuchen
     */
    void BahnanbindungAusgeben()
    {
        System.out.println("Flughäfen mit direkter Zuganbindung: ");
        for (int k = 0; k < flugnetz.KnotenanzahlGeben(); k = k + 1)
        {
            DatenElement flughafen = flugnetz.DatenDesKnotenMitIndexAusgeben(k);
            if (flughafen.ZuganbindungGeben())
            {
                flughafen.FlughafennameAusgeben();
            }
        }
        System.out.println("");
    }

    /**
     * Aufgabe 4: Suchen der Flughaefen, die von einem gegebenen Flughafen
     * direkt erreichbar sind. Übergeben wird der Index des Feldes, das die
     * Daten des gegebenen Flughafens "enthält". Ausgenutzt wird hierbei, dass
     * die Adjazenzmatrix symmetrisch ist. Alle "Direktverbindungen" sind
     * aufgrund der Entfernungseinträge in der Zeile i (i Index des
     * Ausgangsflughafens) bzw. der Spalte i ersichtlich. Es reicht, entweder
     * die entsprechende Zeile oder Spalte abzuprüfen!
     */
    void DirektverbindungSuchen(int i)
    {
        DatenElement flughafen = flugnetz.DatenDesKnotenMitIndexAusgeben(i);
        System.out.print("Direktverbindungen von ");
        flughafen.FlughafennameAusgeben();
        for (int k = 0; k < flugnetz.KnotenanzahlGeben(); k = k + 1)
        {
            if (flugnetz.KantePruefen(i, k))
            {
                DatenElement zielflughafen = flugnetz
                        .DatenDesKnotenMitIndexAusgeben(k);
                zielflughafen.FlughafennameAusgeben();
            }
        }
        System.out.println("");
    }

    /**
     * Aufgabe 5: Suchen der Flughaefen, die von einem durch die Flughafennummer
     * gegebenen Flughafen aus (irgendwie) erreichbar sind Idee zur Umsetzung:
     * Tiefensuche
     */
    void ErreichbareFlughaefenSuchen(int indexStartflughafen)
    {
        DatenElement flughafen = flugnetz
                .DatenDesKnotenMitIndexAusgeben(indexStartflughafen);
        System.out.print("Ausgangsflughafen ");
        flughafen.FlughafennameAusgeben();
        System.out.println("Erreichbar sind folgende Flughäfen: ");
        flugnetz.TiefensucheStarten(indexStartflughafen);
        System.out.println();
    }

    /**
     * Aufgabe 6: Anwenderfreundlichere Version der Methode
     * DirektverbindungSuchen durch Eingabe des Flughafennamens Es wird aus
     * Einfachheitsgruenden davon ausgegangen, dass der übergebene Flughafenname
     * existiert!
     */
    public void DirektverbindungSuchen(String flughafenname)
    {
        DirektverbindungSuchen(NameFuerIndexSuchen(flughafenname));
    }

    /**
     * Hilfsmethode, die zu einem gegebenen Flughafennamen die Flughafennummer,
     * also den Index des Knotens, der den Flughafen verwaltet, sucht
     */
    private int NameFuerIndexSuchen(String flughafenname)
    {
        int index = 0;
        DatenElement flughafen = flugnetz.DatenDesKnotenMitIndexAusgeben(index);
        while (!flughafen.FlughafennameVergleichen(flughafenname))
        {
            index = index + 1;
            flughafen = flugnetz.DatenDesKnotenMitIndexAusgeben(index);
        }
        return index;
    }
}
