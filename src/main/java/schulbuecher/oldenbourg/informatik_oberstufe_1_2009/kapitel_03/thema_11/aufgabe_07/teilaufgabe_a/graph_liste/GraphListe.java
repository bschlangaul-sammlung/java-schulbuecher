package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_11.aufgabe_07.teilaufgabe_a.graph_liste;

/**
 * Klasse GRAPH_LISTE Klasse für einen ungerichteten, gewichteten Graphen Als
 * Datenstruktur werden Adjazenzlisten verwendet
 * <p>
 * Schulbuch Informatik 1 Oberstufe Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 *
 */
public class GraphListe
{
    // aktuelle Anzahl der Knoten
    private int anzahlKnoten;

    // Referenz auf den ersten Knoten in der Knotenliste
    private Knoten anfang;

    /**
     * Konstruktor für Objekte der Klasse GRAPH_LISTE
     *
     *
     */
    public GraphListe()
    {
        anzahlKnoten = 0;
        anfang = null;
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen
     *
     * @param bezeichner Bezeichner des neuen Knotens, der dem Graphen
     *     hinzugefügt wird.
     *
     */
    public void KnotenEinfuegen(String bezeichner)
    {
        Knoten alterAnfang = anfang;
        if (anfang == null || anfang.Suchen(bezeichner) == null)
        {
            anfang = new Knoten(bezeichner, alterAnfang);
            anzahlKnoten = anzahlKnoten + 1;
        }
    }

    /**
     * Einfügen einer Kante in den Graphen Eine Kante ist durch einen
     * Anfangsknoten und einen Endknoten festgelegt und hat eine Gewichtung Da
     * der Graph ungerichtet ist muss die Kante für beide "Richtungen"
     * eingetragen werden.
     *
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     * @param gewichtung Gewichtung der Kante als Ganzzahl
     *
     */
    public void KanteEinfuegen(String von, String nach, int gewichtung)
    {
        Knoten vonKnoten, nachKnoten;
        vonKnoten = anfang.Suchen(von);
        nachKnoten = anfang.Suchen(nach);
        if ((vonKnoten != null) && (nachKnoten != null)
                && (vonKnoten != nachKnoten))
        {
            // da ungerichteter Graph, in beiden Kantenlisten eintragen
            vonKnoten.KanteEinfuegen(nachKnoten, gewichtung);
            nachKnoten.KanteEinfuegen(vonKnoten, gewichtung);
        }
    }

    /**
     * Gibt die Adjazenzlisten des Graphen in der Konsole aus für jeden Knoten
     * und seine Kantenadjazenzliste eine Zeile
     *
     */
    public void Ausgeben()
    {
        if (anfang != null)
            anfang.Ausgeben();
    }

    /**
     * Gibt die Anzahl der Knoten des Graphen
     *
     * @return Anzahl der Knoten
     *
     */
    int KnotenAnzahlGeben()
    {
        return anzahlKnoten;
    }
}
