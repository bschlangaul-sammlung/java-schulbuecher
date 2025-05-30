
import java.util.ArrayList;
/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class GraphMatrix
{
    /**
     * Feld der Knoten des Graphen */
    private ArrayList<Knoten> knoten;
    /** 2-dim Feld der Adjazenzmatrix */
    private ArrayList<ArrayList<Integer>> matrix;
    /**
     * Feld der Kantensymbole des Graphen */
    private ArrayList<KantenSymbol> kanten;
    /**
     * Markierung für die besuchten Knoten */
    private ArrayList<Integer> besuchteKnoten;
    /**
     * Der in Bearbeitung befindliche Weg */
    private ArrayList<Integer> aktuellerWeg;
    /**
     * Der (bisher) beste Weg */
    private ArrayList<Integer> optimalerWeg;
    /**
     * Länge des besten Weges */
    private int optimaleLänge;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix ()
    {
        knoten = new ArrayList<Knoten>();
        matrix = new ArrayList<ArrayList<Integer>>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Integer>();
        aktuellerWeg = new ArrayList<Integer>();
        optimalerWeg = new ArrayList<Integer>();
        optimaleLänge = Integer.MAX_VALUE;
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen
     * @param bezeichner Bezeichner des neuen Knotens, der dem Graphen hinzugefügt wird.
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
            matrix.get(matrix.size()-1).add(new Integer(-1));
        }
    }

    /**
     * Gibt den Knoten mit dem angegebenen Bezeichner zurück.
     * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist, wird null zurückgegeben
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     * @return Referenz auf das Knotenobjekt oder null
     */
    private Knoten KnotenGeben(String bezeichner)
    {
        for (Knoten k: knoten)
        {
            if (k.BezeichnerGeben().equals(bezeichner))
            {
                return k;
            }
        }
        return null;
    }

    /**
     * Gibt die interne Nummer des Knotens
     * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist, wird -1 zurückgegeben
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     * @return Indexnummer des Knotens im Knotenfeld; 0 <= res <= knoten.size()-1 bzw. -1
     */
    int KnotenNummerGeben(String bezeichner)
    {
        for (int index=0; index < knoten.size(); index++)
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
     * @param Indexnummer des Knotens im Knotenarray; 0<= x <= knoten.size()
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
     * Einfügen einer Kante in den Graphen
     * Eine Kante ist durch einen Anfangsknoten und einen Endknoten festgelegt und hat eine Gewichtung
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     * @param gewichtung Gewichtung der Kante als Ganzzahl
     */
    void KanteEinfügen(String von, String nach, int gewichtung)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(von);
        nachNummer = KnotenNummerGeben(nach);
        if ((vonNummer!=-1) && (nachNummer!=-1) && (vonNummer!=nachNummer))
        {
            matrix.get(vonNummer).set(nachNummer, gewichtung);
            matrix.get(nachNummer).set(vonNummer, gewichtung);
            kanten.add(new KantenSymbol(knoten.get(vonNummer).SymbolGeben(), knoten.get(nachNummer).SymbolGeben(), false, "" + gewichtung, 3, "blau"));
        }
    }

    /**
     * Gibt die Anzahl der Knoten des Graphen zurück
     * @return  Anzahl der Knoten
     */
    int KnotenAnzahlGeben()
    {
        return knoten.size();
    }

    /**
     * Gibt die Gewichtung einer Kante zurück
     * Die Kante ist durch einen Anfangsknoten und einen Endknoten festgelegt
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     * @return Gewichtung der Kante
     */
    int KanteGewichtGeben(String von, String nach)
    {
        int vonNummer, nachNummer;

        vonNummer = KnotenNummerGeben(von);
        nachNummer = KnotenNummerGeben(nach);
        if ((vonNummer!=-1) && (nachNummer!=-1))
        {
            return matrix.get(vonNummer).get(nachNummer);
        }
        else
        {
            return -1;
        }
    }

    /**
     * Berechnet alle Knotenverbindungen nach Floyd-Warshall
     */
    void AlleVerbindungenBerechnen()
    {
        for (int k = 0; k < matrix.size(); k += 1)
        {
            for (int i = 0; i < matrix.size(); i += 1)
            {
                for (int j = 0; j < matrix.size(); j += 1)
                {
                    if (i != j)
                    {
                        if ((matrix.get(i).get(k) != -1) && (matrix.get(k).get(j) != -1))
                        {
                            if ((matrix.get(i).get(j) == -1) || (matrix.get(i).get(j) > matrix.get(i).get(k) + matrix.get(k).get(j)))
                            {
                                matrix.get(i).set(j, matrix.get(i).get(k) + matrix.get(k).get(j));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Löscht die Kanten und Knoten des Graphen
     * Die Anzeige wird auch gelöscht
     */
    void ZurückSetzen()
    {
        for (KantenSymbol k: kanten)
        {
            k.Entfernen();
        }
        for (Knoten k: knoten)
        {
            k.SymbolGeben().Entfernen();
        }
        knoten.clear();
        kanten.clear();
        matrix.clear();
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     * @param zielKnoten die Nummer des Zielknotens (Startknoten
     * @param länge bisherige Weglänge
     */
    void KnotenBesuchen(int aktuell, int zielKnoten, int länge)
    {
        besuchteKnoten.add(aktuell);
        aktuellerWeg.add(aktuell);
        for (int nummer = 0; nummer < knoten.size(); nummer += 1)
        {
            if (nummer != aktuell)
            {
                if ((nummer == zielKnoten) && (besuchteKnoten.size() == knoten.size()))
                {
                    if (länge + matrix.get(aktuell).get(nummer) < optimaleLänge)
                    {
                        optimaleLänge = länge + matrix.get(aktuell).get(nummer);
                        optimalerWeg.clear();
                        for (Integer i: aktuellerWeg)
                        {
                            optimalerWeg.add(i);
                        }
                    }
                }
                else if (!besuchteKnoten.contains(nummer))
                {
                    KnotenBesuchen(nummer, zielKnoten, matrix.get(aktuell).get(nummer) + länge);
                }
            }
        }

        besuchteKnoten.remove(new Integer(aktuell));
        aktuellerWeg.remove(new Integer(aktuell));
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     * @param startKnoten die Nummer des Startknotens
     */
    void TiefensucheAusführen (int startKnoten)
    {
        besuchteKnoten.clear();
        aktuellerWeg.clear();
        optimalerWeg.clear();
        optimaleLänge = Integer.MAX_VALUE;
        KnotenBesuchen(startKnoten, startKnoten, 0);
        System.out.println("Der Weg hat die Länge: " + optimaleLänge);
        System.out.println("Er führt über");
        for (Integer i: optimalerWeg)
        {
            System.out.println(knoten.get(i).BezeichnerGeben());
        }
    }
}
