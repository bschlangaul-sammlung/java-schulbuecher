package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_03.graphen.radnetz;

/**
 * Beispiel für einen gerichteten, bewerteten Graphen, der mit Hilfe der
 * Adjazenzmatrix implementiert wird. Der Anwendungszusammenhang ist ein
 * Wegenetz für Radfahrer. Die Richtung einer Kante gibt die Richtung des
 * Radweges an und ihre Bewertung steht für die durchschnittlich benoetigte
 * Zeit.
 *
 */
class GRAPH_MATRIX
{
    private KNOTEN[] knotenfeld;

    private int[][] adjazenzmatrix;

    private int anzahlKnoten = 0;

    // Konstruktor
    GRAPH_MATRIX(int maxAnzahlKnoten)
    {
        knotenfeld = new KNOTEN[maxAnzahlKnoten];
        adjazenzmatrix = new int[maxAnzahlKnoten][maxAnzahlKnoten];
        // Die Adjazenzmatrix wird mit den Werten 0 auf der Diagonalen und
        // sonst mit den Werten -1 ("keine Kante") vorbelegt.
        for (int i = 0; i < maxAnzahlKnoten; i = i + 1)
        {
            for (int j = 0; j < maxAnzahlKnoten; j = j + 1)
            {
                if (i == j)
                {
                    adjazenzmatrix[i][j] = 0;
                }
                else
                {
                    adjazenzmatrix[i][j] = -1;
                }
            }
        }
    }

    // Die Knoten ausgeben
    void knotenAusgeben()
    {
        for (int i = 0; i < anzahlKnoten; i = i + 1)
        {
            knotenfeld[i].datenLiefern().ausgeben();
        }
    }

    // Die Kanten bzw. Adjazenzmatrix ausgeben
    void matrixAusgeben()
    {
        System.out.println("");
        System.out.println("Die Adjazenzmatrix lautet:");
        for (int i = 0; i < anzahlKnoten; i = i + 1)
        {
            for (int j = 0; j < anzahlKnoten; j = j + 1)
            {
                System.out.print(adjazenzmatrix[i][j] + ",  ");
            }
            System.out.println("");
        }
    }

    /****************************************************************************************************
     * Tiefensuche als Verfahren zum Graphendurchlauf Rekursives Verfahren
     ****************************************************************************************************/
    // Methode zum Starten der Tiefensuche
    void tiefensucheStarten(int startKnotenNr)
    {
        // Am Anfang alle Knoten auf unbesucht setzen
        for (int i = 0; i < anzahlKnoten; i++)
        {
            knotenfeld[i].markierungSetzen(false);
        }
        // Beginn der Tiefensuche mit dem angegebenen Startknoten
        if (startKnotenNr >= 0 && startKnotenNr < anzahlKnoten)
        {
            tiefensucheDurchfuehren(startKnotenNr);
        }
    }

    // Rekursive Methode zum Durchfuehren der Tiefensuche
    private void tiefensucheDurchfuehren(int knotenNr)
    {
        // Knoten als besucht markieren und auf der Konsole ausgeben.
        knotenfeld[knotenNr].markierungSetzen(true);
        System.out.println("Jetzt wurde der folgende Ort besucht:");
        knotenfeld[knotenNr].datenLiefern().ausgeben();
        // Für benachbarte Knoten die Tiefensuche erneut aufrufen.
        for (int j = 0; j < anzahlKnoten; j++)
        {
            if (adjazenzmatrix[knotenNr][j] > 0
                    && (knotenfeld[j].markierungGeben() == false))
            {
                // Rekursiver Aufruf der Tiefensuche für den naechsten Knoten
                tiefensucheDurchfuehren(j);
            }
        }
    }

    /****************************************************************************************************
     * Hinzufuegen und Loeschen von Knoten bzw. Kanten
     ****************************************************************************************************/
    // Eine Kante hinzufuegen
    void kanteHinzufuegen(int start, int ziel, int bewertung)
    {
        if (start < knotenfeld.length && ziel < knotenfeld.length)
        {
            adjazenzmatrix[start][ziel] = bewertung;
        }
        else
        {
            System.out.println(
                    "Es wurde keine Kante erzeugt, da Start- oder Zielknoten nicht existieren.");
        }
    }

    // Eine Kante loeschen
    void kanteLoeschen(int start, int ziel)
    {
        if (start < knotenfeld.length && ziel < knotenfeld.length)
        {
            adjazenzmatrix[start][ziel] = -1;
        }
        else
        {
            System.out.println(
                    "Es wurde keine Kante geloescht, da Start- oder Zielknoten nicht existieren.");
        }
    }

    // Einen Knoten hinzufuegen, der Index wird zurückgegeben
    int knotenHinzufuegen(DATENELEMENT inhalt)
    {
        int index = -1;
        if (anzahlKnoten < knotenfeld.length)
        {
            // Den Knoten an die erste freie Stelle im Feld setzen.
            index = anzahlKnoten;
            knotenfeld[index] = new KNOTEN(inhalt);
            anzahlKnoten = anzahlKnoten + 1;
        }
        else
        {
            System.out.println(
                    "Es wurde kein Knoten erzeugt, da der Graph schon die maximale Anzahl an Knoten enthält.");
        }
        return index;
    }

    // Einen Knoten loeschen
    void knotenLoeschen(int knotenIndex)
    {
        if (knotenIndex == knotenfeld.length - 1)
        {
            // Letzten Knoten mit allen Kanten loeschen
            knotenfeld[knotenIndex] = null;
            for (int i = 0; i < knotenfeld.length - 1; i = i + 1)
            {
                adjazenzmatrix[i][knotenIndex] = -1;
                adjazenzmatrix[knotenIndex][i] = -1;
            }
            adjazenzmatrix[knotenIndex][knotenIndex] = 0;
        }
        else
        {
            // Alle Feldelemente des Knotenfeldes ab dem zu loeschenden Knoten
            // werden eine Stelle
            // nach vorne gerückt.
            for (int i = knotenIndex; i < knotenfeld.length - 1; i = i + 1)
            {
                knotenfeld[i] = knotenfeld[i + 1];
            }
            // Die Eintraege der Adjazenzmatrix entsprechend verschieben.
            for (int i = knotenIndex; i < knotenfeld.length - 1; i = i + 1)
            {
                for (int j = 0; j < knotenfeld.length; j = j + 1)
                {
                    // Zeileneintraege verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i + 1][j];
                }
            }
            for (int i = 0; i < knotenfeld.length; i = i + 1)
            {
                for (int j = knotenIndex; j < knotenfeld.length - 1; j = j + 1)
                {
                    // Spaltenneintraege verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i][j + 1];
                }
            }
        }
        anzahlKnoten = anzahlKnoten - 1;
        System.out.println("Es wurde der Knoten mit der Nummer " + knotenIndex
                + " geloescht.");
    }
}
