package schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_05.graph_matrix;

import java.util.ArrayList;

import schulbuecher.cornelsen.shared.graph_visualisierung.KantenSymbol;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GraphMatrix
{
    /**
     * Feld der Knoten des Graphen
     */
    private ArrayList<Knoten> knoten;

    /** 2-dim Feld der Adjazenzmatrix */
    private ArrayList<ArrayList<Integer>> matrix;

    /**
     * Feld der Kantensymbole des Graphen
     */
    private ArrayList<KantenSymbol> kanten;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix()
    {
        // Ergänzen laut Teilaufgabe a
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen
     *
     * @param bezeichner Bezeichner des neuen Knotens, der dem Graphen
     *     hinzugefügt wird.
     * @param x x-Koordinate für die Anzeige des Knotens
     * @param y y-Koordinate für die Anzeige des Knotens
     */
    void KnotenEinfügen(String bezeichner, int x, int y)
    {
        // Ergänzen laut Teilaufgabe b
    }

    /**
     * Gibt den Knoten mit dem angegebenen Bezeichner zurück. Wenn ein Knoten
     * mit diesem Bezeichner nicht bekannt ist wird null zurückgegeben
     *
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     *
     * @return Referenz auf das Knotenobjekt oder null
     */
    private Knoten KnotenGeben(String bezeichner)
    {
        for (Knoten k : knoten)
        {
            if (k.BezeichnerGeben().equals(bezeichner))
            {
                return k;
            }
        }
        return null;
    }

    /**
     * Gibt die interne Nummer des Knotens Wenn ein Knoten mit diesem Bezeichner
     * nicht bekannt ist wird -1 zurückgegeben
     *
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     *
     * @return Indexnummer des Knotens im Knotenfeld; 0 &lt;= res &lt;=
     *     knoten.size()-1 bzw. -1
     */
    private int KnotenNummerGeben(String bezeichner)
    {
        // Ergänzen laut Teilaufgabe c
        return -1;
    }

    /**
     * Gibt die Bezeichnung eines Knotens mit der internen Knotennummer
     *
     * @param knotenNummer Indexnummer des Knotens im Knotenarray; 0&lt;= x
     *     &lt;= knoten.size()
     *
     * @return Bezeichner des Knotens
     */
    String KnotenBezeichnerGeben(int knotenNummer)
    {
        if ((knotenNummer < knoten.size()) && (knotenNummer >= 0))
        {
            return knoten.get(knotenNummer).BezeichnerGeben();
        }
        else
        {
            return "";
        }
    }

    /**
     * Einfügen einer Kante in den Graphen Eine Kante ist durch einen
     * Anfangsknoten und einen Endknoten festgelegt und hat eine Gewichtung
     *
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     * @param gewichtung Gewichtung der Kante als Ganzzahl
     */
    void KanteEinfügen(String von, String nach, int gewichtung)
    {
        // Ergänzen laut Teilaufgabe d
    }

    /**
     * Gibt die Adjazenzmatrix des Graphen in der Konsole aus Nach Zeilen und
     * Spalten formatiert Als Spaltenbreite wurde hier 4 Zeichen gewählt.
     */
    void Ausgeben()
    {
        // Kopfzeile
        System.out.print("    ");
        for (int i = 0; i < knoten.size(); i++)
        {
            System.out.print(
                    (knoten.get(i).BezeichnerGeben() + "    ").substring(0, 4));
        }
        System.out.println();
        for (int i = 0; i < knoten.size(); i++)
        {
            System.out.print(
                    (knoten.get(i).BezeichnerGeben() + "    ").substring(0, 4));
            for (int j = 0; j < knoten.size(); j++)
            {
                if (matrix.get(i).get(j) != -1)
                {
                    System.out.print(
                            (matrix.get(i).get(j) + "   ").substring(0, 4));
                }
                else
                {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Gibt die Anzahl der Knoten des Graphen zurück
     *
     * @return Anzahl der Knoten
     */
    int KnotenAnzahlgeben()
    {
        return knoten.size();
    }

    /**
     * Gibt die Gewichtung einer Kante zurück Die Kante ist durch einen
     * Anfangsknoten und einen Endknoten festgelegt
     *
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     *
     * @return Gewichtung der Kante
     */
    int KanteGewichtGeben(String von, String nach)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(von);
        nachNummer = KnotenNummerGeben(nach);
        if ((vonNummer != -1) && (nachNummer != -1))
        {
            return matrix.get(vonNummer).get(nachNummer);
        }
        else
        {
            return -1;
        }
    }

    /**
     * Löscht die Kanten und Knoten des Graphen Die Anzeige wird auch gelöscht
     */
    void ZurückSetzen()
    {
        for (KantenSymbol k : kanten)
        {
            k.Entfernen();
        }
        for (Knoten k : knoten)
        {
            k.SymbolGeben().Entfernen();
        }
        knoten.clear();
        kanten.clear();
        matrix.clear();
    }
}
