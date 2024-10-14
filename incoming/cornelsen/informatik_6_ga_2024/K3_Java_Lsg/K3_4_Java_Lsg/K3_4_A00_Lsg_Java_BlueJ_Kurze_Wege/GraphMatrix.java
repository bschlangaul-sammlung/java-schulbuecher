
import java.util.ArrayList;
/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzmatrix
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class GraphMatrix extends Ereignisbehandlung
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
    private ArrayList<Knoten> besuchteKnoten;
    /**
     * Signal für gedrückte Taste */
    private boolean weiter;
    /**
     * aktueller Weg zum Zielknoten */
    private ArrayList<Knoten> aktuellerWeg;
    /**
     * optimaler Weg zum Zielknoten */
    private ArrayList<Knoten> optimalerWeg;
    /**
     * Länge des optimalen Wegs */
    private int optimaleLänge;

    /**
     * Baut die Datenstruktur auf
     */
    GraphMatrix ()
    {
        super();
        knoten = new ArrayList<Knoten>();
        matrix = new ArrayList<ArrayList<Integer>>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Knoten>();
        weiter = false;
        aktuellerWeg = new ArrayList<Knoten>();
        optimalerWeg = new ArrayList<Knoten>();
        optimaleLänge = Integer.MAX_VALUE;
    }

    /**
     * Die Aktionsmethode für gedrückte Tasten.
     * @param taste die gedrückte Taste
     */
    void TasteGedrückt (char taste)
    {
        weiter = true;
    }

    /**
     * Die Aktionsmethode für gedrückte Sondertasten.
     * @param taste KeyCode der gedrückten Taste
     */
    void SonderTasteGedrückt (int taste)
    {
        weiter = true;
    }

    /**
     * Wartet auf einen Tastendruck
     */
    void AufTasteWarten()
    {
        while (! weiter)
        {
            try
            {
                wait(100);
            }
            catch (Exception e)
            {
                // nix
            }
        }
        weiter = false;
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
     * @param bezeichner Bezeichner des Knoten, der gesucht wird
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
     * Setzt die Farbe der Kante von Knoten k1 zu Knoten k2
     * @param k1 der eine Endknoten
     * @param k2 der andere Endknoten
     * @param farbe die neue Kantenfarbe
     */
    void KantenfarbeSetzen(Knoten k1, Knoten k2, String farbe)
    {
        for (KantenSymbol k: kanten)
        {
            if ((k1.SymbolGeben() == k.StartsymbolGeben()) && (k2.SymbolGeben() == k.ZielsymbolGeben()) ||
                (k2.SymbolGeben() == k.StartsymbolGeben()) && (k1.SymbolGeben() == k.ZielsymbolGeben()))
            {
                k.FarbeSetzen(farbe);
            }
        }
    }

    /**
     * Löscht die Kanten und Knoten des Graphen
     * Die Anzeige wird auch gelöscht
     */
    void ZurückSetzen()
    {
        besuchteKnoten.clear();
        aktuellerWeg.clear();
        optimalerWeg.clear();
        optimaleLänge = Integer.MAX_VALUE;
    }

    /**
     * Zeigt den optimalen Weg an.
     */
    void OptimalerWegAnzeigen()
    {
        Knoten letzter = null;
        for (Knoten aktuell: optimalerWeg)
        {
            aktuell.FarbeSetzen("rot");
            if (letzter != null)
            {
                KantenfarbeSetzen(aktuell, letzter, "rot");
            }
            letzter = aktuell;
        }
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * Alle Wege werden gesucht.
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     * @param ziel die Nummer des zu suchenden Knotens
     */
    void KnotenBesuchen1(int aktuell, int ziel)
    {
        besuchteKnoten.add(knoten.get(aktuell));
        knoten.get(aktuell).FarbeSetzen("grün");
        if (aktuell == ziel)
        {
            AufTasteWarten();
        }
        else
        {
            for (int nummer = knoten.size() - 1; nummer >= 0 ; nummer -= 1)
            {
                if ((matrix.get(aktuell).get(nummer) > 0) && (!besuchteKnoten.contains(knoten.get(nummer))))
                {
                    KantenfarbeSetzen(knoten.get(aktuell), knoten.get(nummer), "grün");
                    KnotenBesuchen1(nummer, ziel);
                    KantenfarbeSetzen(knoten.get(aktuell), knoten.get(nummer), "blau");
                }
            }
        }
        knoten.get(aktuell).FarbeSetzen("weiß");
        besuchteKnoten.remove(knoten.get(aktuell));
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * Der optimale Weg wird gespeichert.
     * @param aktuell die Nummer des aktuell zu besuchenden Knotens
     * @param ziel die Nummer des zu suchenden Knotens
     * @param länge die Länge des aktuellen Wegs
     */
    void KnotenBesuchen2(int aktuell, int ziel, int länge)
    {
        besuchteKnoten.add(knoten.get(aktuell));
        knoten.get(aktuell).FarbeSetzen("grün");
        aktuellerWeg.add(knoten.get(aktuell));
        if (aktuell == ziel)
        {
            AufTasteWarten();
            if (länge < optimaleLänge)
            {
                optimalerWeg = (ArrayList<Knoten>) aktuellerWeg.clone();
                optimaleLänge = länge;
            }
        }
        else
        {
            for (int nummer = 0; nummer < knoten.size(); nummer += 1)
            {
                if ((matrix.get(aktuell).get(nummer) > 0) && (!besuchteKnoten.contains(knoten.get(nummer))))
                {
                    KantenfarbeSetzen(knoten.get(aktuell), knoten.get(nummer), "grün");
                    KnotenBesuchen2(nummer, ziel, länge + matrix.get(aktuell).get(nummer));
                    KantenfarbeSetzen(knoten.get(aktuell), knoten.get(nummer), "blau");
                }
            }
        }
        knoten.get(aktuell).FarbeSetzen("weiß");
        besuchteKnoten.remove(knoten.get(aktuell));
        aktuellerWeg.remove(knoten.get(aktuell));
    }
}
