package org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Ereignisbehandlung;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
public class GraphMatrix extends Ereignisbehandlung
{
    /**
     * Feld der Knoten des Graphen
     */
    protected ArrayList<Knoten> knoten;

    /**
     * 2-dim Feld der Adjazenzmatrix
     */
    protected ArrayList<ArrayList<Integer>> matrix;

    /**
     * Feld der Kantensymbole des Graphen
     */
    protected ArrayList<KantenSymbol> kanten;

    /**
     * Baut die Datenstruktur auf
     */
    public GraphMatrix()
    {
        super();
        knoten = new ArrayList<Knoten>();
        matrix = new ArrayList<ArrayList<Integer>>();
        kanten = new ArrayList<KantenSymbol>();
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
        knoten.add(new Knoten(bezeichner, x, y));
        for (int index = 0; index < matrix.size(); index++)
        {
            matrix.get(index).add(new Integer(-1));
        }
        matrix.add(new ArrayList<Integer>());
        for (int index = 0; index < matrix.size(); index++)
        {
            matrix.get(matrix.size() - 1).add(new Integer(-1));
        }
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
     * @return Indexnummer des Knotens im Knotenfeld; 0 <= res <=
     *     knoten.size()-1 bzw. -1
     */
    public int KnotenNummerGeben(String bezeichner)
    {
        for (int index = 0; index < knoten.size(); index++)
        {
            if (knoten.get(index).BezeichnerGeben().equals(bezeichner))
            {
                return index;
            }
        }
        return -1;
    }

    /**
     * Gibt die Bezeichnung eines Knotens mit der internen Knotennummer
     *
     * @param Indexnummer des Knotens im Knotenarray; 0<= x <= knoten.size()
     *
     * @return Bezeichner des Knotens
     */
    public String KnotenBezeichnerGeben(int knotenNummer)
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
    public void KanteEinfügen(String von, String nach, int gewichtung)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(von);
        nachNummer = KnotenNummerGeben(nach);
        if ((vonNummer != -1) && (nachNummer != -1)
                && (vonNummer != nachNummer))
        {
            matrix.get(vonNummer).set(nachNummer, gewichtung);
            matrix.get(nachNummer).set(vonNummer, gewichtung);
            kanten.add(new KantenSymbol(knoten.get(vonNummer).SymbolGeben(),
                    knoten.get(nachNummer).SymbolGeben(), false,
                    "" + gewichtung, 3, "schwarz"));
        }
    }

    /**
     * Gibt die Anzahl der Knoten des Graphen zurück
     *
     * @return Anzahl der Knoten
     */
    public int KnotenAnzahlGeben()
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
    public int KanteGewichtGeben(String von, String nach)
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

}
