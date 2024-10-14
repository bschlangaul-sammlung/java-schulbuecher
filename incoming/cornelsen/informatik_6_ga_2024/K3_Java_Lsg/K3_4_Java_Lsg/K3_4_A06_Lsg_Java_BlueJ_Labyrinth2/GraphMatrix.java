
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
     * Aktueller Weg der Tiefensuche */
    private ArrayList<Knoten> aktuellerWeg;
    /**
     * Von der Tiefensuche gefundener optimaler Weg */
    private ArrayList<Knoten> optimalerWeg;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix ()
    {
        knoten = new ArrayList<Knoten>();
        matrix = new ArrayList<ArrayList<Integer>>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Integer>();
        aktuellerWeg = new ArrayList<Knoten>();
        optimalerWeg = new ArrayList<Knoten>();
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen
     * @param x x-Koordinate des Knotens
     * @param y y-Koordinate des Knotens
     */
    void KnotenEinfügen(int x, int y)
    {
        knoten.add(new Knoten(x, y));
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
     * Gibt den Knoten mit den angegebenen Koordinaten zurück.
     * Wenn ein Knoten mit diesen Koordinaten nicht bekannt ist, wird null zurückgegeben
     * @param x x-Koordinate des Knotens
     * @param y y-Koordinate des Knotens
     * @return Referenz auf das Knotenobjekt oder null
     */
    Knoten KnotenGeben(int x, int y)
    {
        for (Knoten k: knoten)
        {
            if ((k.XGeben() == x) && (k.YGeben() == y))
            {
                return k;
            }
        }
        return null;
    }

    /**
     * Gibt die interne Nummer des Knotens
     * Wenn ein Knoten mit diesen Koordinaten nicht bekannt ist, wird -1 zurückgegeben
     * @param x x-Koordinate des Knotens
     * @param y y-Koordinate des Knotens
     * @return Indexnummer des Knotens im Knotenfeld; 0 <= res <= knoten.size()-1 bzw. -1
     */
    private int KnotenNummerGeben(int x, int y)
    {
        for (int index=0; index < knoten.size(); index++)
        {
            Knoten k = knoten.get(index);
            if ((k.XGeben() == x) && (k.YGeben() == y))
            {
                return index;
            }
        }
        return -1;
    }

    /**
     * Einfügen einer Kante in den Graphen
     * Eine Kante ist durch einen Anfangsknoten und einen Endknoten festgelegt und hat eine Gewichtung
     * @param x1 x-Koordinate des Anfangsknotens
     * @param y1 y-Koordinate des Anfangsknotens
     * @param x2 x-Koordinate des Endknotens
     * @param y2 y-Koordinate des Endknotens
     */
    void KanteEinfügen(int x1, int y1, int x2, int y2)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(x1, y1);
        nachNummer = KnotenNummerGeben(x2, y2);
        if ((vonNummer!=-1) && (nachNummer!=-1) && (vonNummer!=nachNummer))
        {
            matrix.get(vonNummer).set(nachNummer, 1);
            matrix.get(nachNummer).set(vonNummer, 1);
            kanten.add(new KantenSymbol(knoten.get(vonNummer).SymbolGeben(), knoten.get(nachNummer).SymbolGeben(), false, "", 3, "blau"));
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
     * @param x1 x-Koordinate des Anfangsknotens
     * @param y1 y-Koordinate des Anfangsknotens
     * @param x2 x-Koordinate des Endknotens
     * @param y2 y-Koordinate des Endknotens
     * @return Gewichtung der Kante
     */
    int KanteGewichtGeben(int x1, int y1, int x2, int y2)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(x1, y1);
        nachNummer = KnotenNummerGeben(x2, y2);
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
     * Setzt die Sichtbarkeit des Graphen
     * @param sichtbar wenn wahr, ist das Labyrinth sichtbar
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        for (KantenSymbol k: kanten)
        {
            k.SichtbarkeitSetzen(sichtbar);
        }
        for (Knoten k: knoten)
        {
            k.SymbolGeben().SichtbarkeitSetzen(sichtbar);
        }
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     * @param x1 x-Koordinate des Startknotens
     * @param y1 y-Koordinate des Startknotens
     * @param x2 x-Koordinate des Zielknotens
     * @param y2 y-Koordinate des Zielknotens
     * @return Weg als Feld von Knoten
     */
    ArrayList<Knoten> TiefensucheAusführen (int x1, int y1, int x2, int y2)
    {
        besuchteKnoten.clear();
        aktuellerWeg.clear();
        optimalerWeg.clear();
        KnotenBesuchen(KnotenNummerGeben(x1, y1), KnotenNummerGeben(x2, y2));
        return optimalerWeg;
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     * @param ziel die Nummer des Zielknotens
     */
    void KnotenBesuchen(int aktuell, int ziel)
    {
        besuchteKnoten.add(aktuell);
        aktuellerWeg.add(knoten.get(aktuell));
        if (aktuell == ziel)
        {
            if ((optimalerWeg.size() == 0) || (aktuellerWeg.size() < optimalerWeg.size()))
            {
                optimalerWeg.clear();
                for (Knoten k: aktuellerWeg)
                {
                    optimalerWeg.add(k);
                }
            }
        }
        else
        {
            for (int nummer = 0; nummer < knoten.size(); nummer += 1)
            {
                if ((matrix.get(aktuell).get(nummer) > 0) && (!besuchteKnoten.contains(nummer)))
                {
                    KnotenBesuchen(nummer, ziel);
                }
            }
        }
        aktuellerWeg.remove(aktuellerWeg.size() - 1);
        besuchteKnoten.remove(new Integer (aktuell));
    }
}
