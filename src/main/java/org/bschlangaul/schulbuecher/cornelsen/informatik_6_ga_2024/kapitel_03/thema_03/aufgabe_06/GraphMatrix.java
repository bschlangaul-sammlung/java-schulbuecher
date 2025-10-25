package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_03.aufgabe_06;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.KantenSymbol;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Zeichenfenster;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GraphMatrix extends
        org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.GraphMatrix
{
    /**
     * Feld der Knoten des Graphen
     */
    private ArrayList<Knoten> knoten;

    /**
     * 2-dim Feld der Adjazenzmatrix
     */
    private ArrayList<ArrayList<Integer>> matrix;

    /**
     * Feld der Kantensymbole des Graphen
     */
    private ArrayList<KantenSymbol> kanten;

    /**
     * Markierung für die besuchten Knoten
     */
    private ArrayList<Integer> besuchteKnoten;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix()
    {
        knoten = new ArrayList<Knoten>();
        matrix = new ArrayList<ArrayList<Integer>>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Integer>();
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen
     *
     * @param bezeichner Bezeichner des neuen Knotens, der dem Graphen
     *     hinzugefügt wird.
     * @param x x-Koordinate für die Anzeige des Knotens
     * @param y y-Koordinate für die Anzeige des Knotens
     */
    public void KnotenEinfügen(String bezeichner, int x, int y)
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
     * @return Indexnummer des Knotens im Knotenfeld; 0 $lt;= res &lt;=
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
                    "" + gewichtung, 3, "blau"));
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

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     *
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     * @param vorgänger die Nummer des Vorgängerknotens oder -1
     */
    void KnotenBesuchen(int aktuell, int vorgänger)
    {
        System.out.println("Knoten: " + knoten.get(aktuell).BezeichnerGeben());
        besuchteKnoten.add(aktuell);
        if (vorgänger != -1)
        {
            knoten.get(vorgänger).NeuesBlattAnfügen(knoten.get(aktuell));
        }
        for (int nummer = 0; nummer < knoten.size(); nummer += 1)
        {
            if ((matrix.get(aktuell).get(nummer) > 0)
                    && (!besuchteKnoten.contains(nummer)))
            {
                KnotenBesuchen(nummer, aktuell);
            }
        }
        knoten.get(aktuell).FarbeSetzen("grün");
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     *
     * @param startKnoten die Nummer des Startknotens
     */
    void TiefensucheAusführen(int startKnoten)
    {
        besuchteKnoten.clear();
        KnotenBesuchen(startKnoten, -1);
        BaumAnzeigen(knoten.get(startKnoten));
    }

    /**
     * Testet, ob der Graph zusammenhängend ist.
     *
     * @return wahr, wenn der Graph zusammenhängend ist
     */
    boolean ZusammenhangTesten()
    {
        besuchteKnoten.clear();
        KnotenBesuchen(0, -1);
        return besuchteKnoten.size() == knoten.size();
    }

    /**
     * Zeigt den Tiefensuchbaum vom gegebenen Startknoten aus an
     *
     * @param wurzel Wurzelknoten
     */
    void BaumAnzeigen(Knoten wurzel)
    {
        for (KantenSymbol k : kanten)
        {
            k.Entfernen();
        }
        for (Knoten k : knoten)
        {
            k.SymbolGeben().SichtbarkeitSetzen(false);
        }
        int höhenschritt = Zeichenfenster.MalflächenHöheGeben()
                / TeilbaumtiefeBerechnen(wurzel);
        int breite = Zeichenfenster.MalflächenBreiteGeben();
        TeilbaumZeichnen(wurzel, 0, breite, höhenschritt, höhenschritt);
    }

    /**
     * Berechnet die Tiefe des Breitensuchebaums an der gegebenen Wurzel
     *
     * @param wurzel der Wurzelknoten des (Teil-)Baums
     *
     * @return Tiefe dieses Teilbaums
     */
    private int TeilbaumtiefeBerechnen(Knoten wurzel)
    {
        int max = 0;
        for (Knoten k : wurzel.BlätterGeben())
        {
            int tiefe = TeilbaumtiefeBerechnen(k);
            if (tiefe > max)
            {
                max = tiefe;
            }
        }
        return max + 1;
    }

    /**
     * Zeichnet den Teilbaum ab der gegebenen Wurzel
     *
     * @param wurzel der Wurzelknoten des (Teil-Baums)
     * @param xmin der minimale Wert des Breitenbereichs
     * @param xmax der maximale Wert des Breitenbereichs
     * @param y der y-Wert der Ebene
     * @param dy der Unerschied zur nächsten Ebene
     */
    private void TeilbaumZeichnen(Knoten wurzel, int xmin, int xmax, int y,
            int dy)
    {
        wurzel.SymbolGeben().PositionSetzen(xmin + (xmax - xmin) / 2, y);
        wurzel.SymbolGeben().SichtbarkeitSetzen(true);
        int anzahl = wurzel.BlätterGeben().size();
        if (anzahl > 0)
        {
            int dx = (xmax - xmin) / anzahl;
            int x = xmin;
            for (Knoten k : wurzel.BlätterGeben())
            {
                TeilbaumZeichnen(k, x, x + dx, y + dy, dy);
                kanten.add(new KantenSymbol(wurzel.SymbolGeben(),
                        k.SymbolGeben(), false, "", 3, "blau"));
                x = x + dx;
            }
        }
    }
}
