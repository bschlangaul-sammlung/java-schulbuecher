package org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Ereignisbehandlung;

/**
 * <p>
 * Diese Klasse wurde nachträglich hinzugefügt. Sie ist nicht im originalen
 * Projekt zu finden.
 * </p>
 */
record Abmessungen(int minX, int maxX, int minY, int maxY)
{
}

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
            matrix.get(index).add(Integer.valueOf(-1));
        }
        matrix.add(new ArrayList<Integer>());
        for (int index = 0; index < matrix.size(); index++)
        {
            matrix.get(matrix.size() - 1).add(Integer.valueOf(-1));
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
    public Knoten KnotenGeben(String bezeichner)
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
     * @param knotenNummer Indexnummer des Knotens im Knotenarray; 0 &lt;= x
     *     &lt;= knoten.size()
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

    /**
     * Berechnet die Abmessungen des Graphen. Dabei werden die Positionen aller
     * Knoten durchgegangen und die minimalen und maximalen Werte sowohl der
     * x-Koordinate als auch der y-Koordinate bestimmt.
     *
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public Abmessungen AbmessungenAusgeben()
    {
        // Das Fenster hat eine maximale Breite von 800 Pixel? Lieber auf
        // Nummer sicher gehen und den größten darstellbaren Ganzzahl-Wert
        // verwenden.
        int minX = Integer.MAX_VALUE;
        // Vielleicht sind auch negative Werte möglich?
        int maxX = Integer.MIN_VALUE;
        // Das Fenster hat eine maximale Höhe von 560 Pixel? Lieber auf Nummer
        // sicher gehen und den größten darstellbaren Ganzzahl-Wert verwenden.
        int minY = Integer.MAX_VALUE;
        // Vielleicht sind auch negative Werte möglich?
        int maxY = Integer.MIN_VALUE;
        for (Knoten k : knoten)
        {

            if (k.XGeben() < minX)
            {
                minX = k.XGeben();
            }

            if (k.XGeben() > maxX)
            {
                maxX = k.XGeben();
            }

            if (k.YGeben() < minY)
            {
                minY = k.YGeben();
            }

            if (k.YGeben() > maxY)
            {
                maxY = k.YGeben();
            }
        }
        return new Abmessungen(minX, maxX, minY, maxY);
    }

    /**
     * Gibt Java-Code aus, um den Graphen über ein andere Implementation
     * darstellen zu können. So kann die sqlite-Datenbank umgangen werden.
     *
     * <p>
     * Diese Methode wurde nachträglich hinzugefügt. Sie ist nicht im originalen
     * Projekt zu finden.
     * </p>
     */
    public void JavaCodeAusgeben()
    {
        for (Knoten k : knoten)
        {
            k.JavaCodeAusgeben(this);
        }

        for (KantenSymbol k : kanten)
        {
            k.JavaCodeAusgeben();
        }

        System.out.println(AbmessungenAusgeben());
    }

    public static void main(String[] args)
    {
        GraphMatrix g = new GraphMatrix();
        Lesen l = new Lesen();
        // l.LesenDatenbank("Abiturfahrt.grdb", g);
        // l.LesenDatenbank("Autobahn.grdb", g);
        // l.LesenDatenbank("ICENetz.grdb", g);
        // l.LesenDatenbank("Beispielgraph.grdb", g);
        l.LesenDatenbank("Beispielgraph2.grdb", g);

        g.JavaCodeAusgeben();

    }
}
