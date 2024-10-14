
import java.util.ArrayList;
/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzlisten
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class GraphListe
{
    /**
     * Feld der Knoten des Graphen */
    private ArrayList<Knoten> knoten;
    /**
     * Feld der Kantensymbole des Graphen */
    private ArrayList<KantenSymbol> kanten;
    /**
     * Feld der besuchten Knoten des Graphen */
    private ArrayList<Knoten> besuchteKnoten;

    /**
     * Baut die Datenstruktur auf
     */
    GraphListe ()
    {
        knoten = new ArrayList<Knoten>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Knoten>();
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
    }

    /**
     * Gibt den Knoten mit dem angegebenen Bezeichner zurück.
     * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist wird null zurückgegeben
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     * @return Referenz auf das Knotenobjekt oder null
     */
    Knoten KnotenGeben(String bezeichner)
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
        Knoten vonKnoten, nachKnoten;
        vonKnoten = KnotenGeben(von);
        nachKnoten = KnotenGeben(nach);
        if ((vonKnoten != null) && (nachKnoten != null) && (vonKnoten != nachKnoten))
        {
            vonKnoten.AdjazenzlisteGeben().add(new Kante(gewichtung, nachKnoten));
            nachKnoten.AdjazenzlisteGeben().add(new Kante(gewichtung, vonKnoten));
            kanten.add(new KantenSymbol(vonKnoten.SymbolGeben(), nachKnoten.SymbolGeben(), false, "" + gewichtung, 3, "blau"));
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
     * @param von Anfangsknoten
     * @param nach Endknoten
     * @return Gewichtung der Kante
     */
    int KanteGewichtGeben(Knoten von, Knoten nach)
    {
        if ((von != null) && (nach != null))
        {
            for (Kante k: von.AdjazenzlisteGeben())
            {
                if (k.ZielGeben() == nach)
                {
                    return k.GewichtGeben();
                }
            }
            return -1;
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
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * @param aktuell der aktuelle Knoten
     */
    void KnotenBesuchen(Knoten aktuell)
    {
        besuchteKnoten.add(aktuell);
        for (Kante k: aktuell.AdjazenzlisteGeben())
        {
            if (!besuchteKnoten.contains(k.ZielGeben()))
            {
                KnotenBesuchen(k.ZielGeben());
            }
        }
        aktuell.FarbeSetzen("grün");
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     * @param startKnoten der Startknoten
     */
    void TiefensucheAusführen (Knoten startKnoten)
    {
        besuchteKnoten.clear();
        KnotenBesuchen(startKnoten);
    }

    /**
     * Testet, ob der Graph zusammenhängend ist.
     * @return wahr, wenn der Graph zusammenhängend ist
     */
    boolean ZusammenhangTesten()
    {
        besuchteKnoten.clear();
        KnotenBesuchen(knoten.get(0));
        return besuchteKnoten.size() == knoten.size();
    }

}
