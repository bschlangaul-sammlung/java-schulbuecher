package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.flugnetz;

public class GRAPH_MATRIX
{
    private KNOTEN[] knotenfeld;

    private int[][] adjazenzmatrix;

    private int anzahlKnoten = 0;

    // Konstruktor
    GRAPH_MATRIX(int maxAnzahlKnoten)
    {
        knotenfeld = new KNOTEN[maxAnzahlKnoten];
        adjazenzmatrix = new int[maxAnzahlKnoten][maxAnzahlKnoten];
        // Die Adjazenzmatrix wird mit den Werten 0 auf der Diagonalen und sonst
        // mit den Werten -1
        // vorbelegt.
        // Der Wert -1 steht für "keine Kante".
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
            knotenfeld[i].ausgeben();
        }
    }

    // Die Kanten bzw. Adjazenzmatrix ausgeben
    void kantenAusgeben()
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
    void TiefensucheStarten(int startKnotenNr)
    {
        // Am Anfang alle Knoten auf unbesucht setzen
        for (int i = 0; i < anzahlKnoten; i++)
        {
            knotenfeld[i].MarkierungSetzen(false);
        }
        // Beginn der Tiefensuche mit dem angegebenen Startknoten
        if (startKnotenNr >= 0 && startKnotenNr < anzahlKnoten)
        {
            TiefensucheDurchfuehren(startKnotenNr);
        }
    }

    // Rekursive Methode zum Durchführen der Tiefensuche
    private void TiefensucheDurchfuehren(int knotenNr)
    {
        // Knoten als besucht markieren und auf der Konsole ausgeben.
        knotenfeld[knotenNr].MarkierungSetzen(true);
        knotenfeld[knotenNr].ausgeben();
        // Für benachbarte Knoten die Tiefensuche erneut aufrufen.
        for (int j = 0; j < anzahlKnoten; j++)
        {
            if (adjazenzmatrix[knotenNr][j] > 0
                    && !knotenfeld[j].MarkierungGeben())
            {
                // Rekursiver Aufruf der Tiefensuche für den nächsten Knoten
                TiefensucheDurchfuehren(j);
            }
        }
    }

    /****************************************************************************************************
     * Hinzufügen und Löschen von Knoten bzw. Kanten
     ****************************************************************************************************/
    // Eine Kante hinzufügen
    void KanteHinzufügen(int start, int ziel, int bewertung)
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

    // Eine Kante löschen
    void kanteLoeschen(int start, int ziel)
    {
        if (start < knotenfeld.length && ziel < knotenfeld.length)
        {
            adjazenzmatrix[start][ziel] = -1;
        }
        else
        {
            System.out.println(
                    "Es wurde keine Kante gelöscht, da Start- oder Zielknoten nicht existieren.");
        }
    }

    // Einen Knoten hinzufügen, der Index wird zurückgegeben
    int KnotenHinzufuegen(DATENELEMENT inhalt)
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

    // Einen Knoten löschen
    void KnotenLoeschen(int knotenIndex)
    {
        if (knotenIndex == knotenfeld.length - 1)
        {
            // Letzten Knoten mit allen Kanten löschen
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
            // Alle Feldelemente des Knotenfeldes ab dem zu löschenden Knoten
            // werden eine Stelle
            // nach vorne gerückt.
            for (int i = knotenIndex; i < knotenfeld.length - 1; i = i + 1)
            {
                knotenfeld[i] = knotenfeld[i + 1];
            }
            // Die Einträge der Adjazenzmatrix entsprechend verschieben.
            for (int i = knotenIndex; i < knotenfeld.length - 1; i = i + 1)
            {
                for (int j = 0; j < knotenfeld.length; j = j + 1)
                {
                    // Zeileneinträge verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i + 1][j];
                }
            }
            for (int i = 0; i < knotenfeld.length; i = i + 1)
            {
                for (int j = knotenIndex; j < knotenfeld.length - 1; j = j + 1)
                {
                    // Spaltenneinträge verschieben
                    adjazenzmatrix[i][j] = adjazenzmatrix[i][j + 1];
                }
            }
        }
        anzahlKnoten = anzahlKnoten - 1;
        System.out.println("Es wurde der Knoten mit der Nummer " + knotenIndex
                + " gelöscht.");
    }

    // Ergänzung der notwendigen Methoden für Aufgabe 3, 4
    DATENELEMENT DatenDesKnotenMitIndexAusgeben(int index)
    {
        return knotenfeld[index].DatenGeben();
    }

    int KnotenanzahlGeben()
    {
        return anzahlKnoten;
    }

    // Ergänzung der notwendigen Methoden für Aufgabe 4
    boolean KantePruefen(int index1, int index2)
    {
        return (adjazenzmatrix[index1][index2] > 0 && index1 != index2);
    }
}
