package org.bschlangaul.schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_07.graph_liste;

import java.util.ArrayList;

/**
 * Verwaltet einen ungerichteten, gewichteten Graphen mittels Adjazenzlisten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GraphListe
{
    /**
     * Feld der Knoten des Graphen
     */
    private ArrayList<Knoten> knoten;

    /**
     * Feld der Kantensymbole des Graphen
     */
    private ArrayList<KantenSymbol> kanten;

    /**
     * Baut die Datenstruktur auf
     */
    GraphListe()
    {
        knoten = new ArrayList<Knoten>();
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
        int vonNummer, nachNummer;
        vonNummer = KnotenNummerGeben(von);
        nachNummer = KnotenNummerGeben(nach);
        if ((vonNummer != -1) && (nachNummer != -1)
                && (vonNummer != nachNummer))
        {
            // Ergänzen der Adjazenzlisteneinträge
            kanten.add(new KantenSymbol(knoten.get(vonNummer).SymbolGeben(),
                    knoten.get(nachNummer).SymbolGeben(), false,
                    "" + gewichtung, 3, "blau"));
        }
    }

    /**
     * Gibt die Adjazenzlisten der Knoten auf der Konsole aus Für jeden Knoten
     * wird die Liste der Ziele mit Gewichten ausgegeben
     */
    void Ausgeben()
    {
        // Ergänzen
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
        int vonNummer;
        Knoten nachKnoten;
        vonNummer = KnotenNummerGeben(von);
        nachKnoten = KnotenGeben(nach);
        if ((vonNummer != -1) && (nachKnoten != null))
        {
            // Echten Wert ergänzen
            return -1;
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
    }
}
