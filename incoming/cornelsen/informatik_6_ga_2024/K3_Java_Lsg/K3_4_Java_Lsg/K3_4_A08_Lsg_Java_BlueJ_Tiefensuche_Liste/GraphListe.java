
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
     * Markierung für die besuchten Knoten */
    private ArrayList<Knoten> besuchteKnoten;
    /**
     * Der in Bearbeitung befindliche Weg */
    private ArrayList<Knoten> aktuellerWeg;
    /**
     * Der (bisher) beste Weg */
    private ArrayList<Knoten> optimalerWeg;
    /**
     * Länge des besten Weges */
    private int optimaleLänge;

    /**
     * Baut die Datenstruktur auf
     */
    GraphListe ()
    {
        knoten = new ArrayList<Knoten>();
        kanten = new ArrayList<KantenSymbol>();
        besuchteKnoten = new ArrayList<Knoten>();
        aktuellerWeg = new ArrayList<Knoten>();
        optimalerWeg = new ArrayList<Knoten>();
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
    }

    /**
     * Gibt den Knoten mit dem angegebenen Bezeichner zurück.
     * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist, wird null zurückgegeben
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
     * Gibt die interne Nummer des Knotens
     * Wenn ein Knoten mit diesem Bezeichner nicht bekannt ist, wird -1 zurückgegeben
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     * @return Indexnummer des Knotens im Knotenfeld; 0 <= res <= knoten.size()-1 bzw. -1
     */
    private int KnotenNummerGeben(String bezeichner)
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
            knoten.get(vonNummer).AdjazenzlisteGeben().add(new Kante(gewichtung, knoten.get(nachNummer)));
            knoten.get(nachNummer).AdjazenzlisteGeben().add(new Kante(gewichtung, knoten.get(vonNummer)));
            kanten.add(new KantenSymbol(knoten.get(vonNummer).SymbolGeben(), knoten.get(nachNummer).SymbolGeben(), false, "" + gewichtung, 3, "blau"));
        }
    }

    /**
     * Gibt die Adjazenzlisten der Knoten auf der Konsole aus
     * Für jeden Knoten wird die Liste der Ziele mit Gewichten ausgegeben
     */
    void Ausgeben()
    {
        for (Knoten k: knoten)
        {
            System.out.print(k.BezeichnerGeben() + ": ");
            for (Kante ka: k.AdjazenzlisteGeben())
            {
                System.out.print("(" + ka.GewichtGeben() + "-> " + ka.ZielGeben().BezeichnerGeben() + ") ");
            }
            System.out.println();
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
        int vonNummer;
        Knoten nachKnoten;

        vonNummer = KnotenNummerGeben(von);
        nachKnoten = KnotenGeben(nach);
        if ((vonNummer !=- 1) && (nachKnoten != null))
        {
            for (Kante k: knoten.get(vonNummer).AdjazenzlisteGeben())
            {
                if (k.ZielGeben() == nachKnoten)
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

    void Umwandeln(ArrayList<ArrayList<Integer>> matrix)
    {
        for (int zeile = 0; zeile <= matrix.size(); zeile += 1)
        {
            for (int spalte = zeile + 1; spalte <= matrix.get(zeile).size(); spalte += 1)
            {
                int gewichtung = matrix.get(zeile).get(spalte);
                knoten.get(zeile).AdjazenzlisteGeben().add(new Kante(gewichtung, knoten.get(spalte)));
                knoten.get(spalte).AdjazenzlisteGeben().add(new Kante(gewichtung, knoten.get(zeile)));
                kanten.add(new KantenSymbol(knoten.get(zeile).SymbolGeben(), knoten.get(spalte).SymbolGeben(), false, "" + gewichtung, 3, "blau"));
            }
        }
    }

    /**
     * Setzt den Rekursionsschritt bei einem Knoten um.
     * @param aktuell der aktuell besuchte Knoten
     * @param zielKnoten der Zielknoten
     * @param länge bisherige Weglänge
     */
    void KnotenBesuchen(Knoten aktuell, Knoten zielKnoten, int länge)
    {
        besuchteKnoten.add(aktuell);
        aktuellerWeg.add(aktuell);
        if (aktuell == zielKnoten)
        {
            if (länge < optimaleLänge)
            {
                optimaleLänge = länge;
                optimalerWeg.clear();
                for (Knoten kn: aktuellerWeg)
                {
                    optimalerWeg.add(kn);
                }
            }

        }
        else
        {
            for (Kante ka: aktuell.AdjazenzlisteGeben())
            {
                if (!besuchteKnoten.contains(ka.ZielGeben()))
                {
                    KnotenBesuchen(ka.ZielGeben(), zielKnoten, ka.GewichtGeben() + länge);
                }
            }
        }
        besuchteKnoten.remove(aktuell);
        aktuellerWeg.remove(aktuell);
    }

    /**
     * Führt die Tiefensuche vom Startknoten aus durch
     * @param startKnoten der Startknoten
     * @param zielKnoten der Zielknoten
     */
    void TiefensucheAusführen (Knoten startKnoten, Knoten zielKnoten)
    {
        besuchteKnoten.clear();
        aktuellerWeg.clear();
        optimalerWeg.clear();
        optimaleLänge = Integer.MAX_VALUE;
        KnotenBesuchen(startKnoten, zielKnoten, 0);
        for (Knoten kn: optimalerWeg)
        {
            kn.FarbeSetzen("grün");
        }
    }
}
