package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_11.aufgabe_07.teilaufgabe_b.graph_liste;

/**
 * Klasse KNOTEN für die Darstellungen eines Graphen durch Adjazenzlisten
 * <p>
 * Schulbuch Informatik 1 Oberstufe Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 */
public class Knoten
{
    private String bezeichnung;

    private Kante anfang;

    private Knoten nachfolger;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     *
     * @param neuerWert Bezeichnung des neuen Knotenobjekts
     * @param neuerNachfolger Referenz auf den Nachfolgeknoten
     *
     */
    public Knoten(String neuerWert, Knoten neuerNachfolger)
    {
        bezeichnung = neuerWert;
        anfang = null;
        nachfolger = neuerNachfolger;
    }

    /**
     * Gibt den Bezeichner des Knotenobjekts zurück
     *
     * @return Bezeichner
     *
     */
    public String BezeichnungGeben()
    {
        return bezeichnung;
    }

    /**
     * Sucht in der Knotenliste nach einem Knoten mit dem übergebenen
     * Bezeichner; die Suche beginnt ab dem aufgerufenen Knoten; ruft rekursiv
     * das Suchen des Nachfolgers auf;
     *
     * @return Referenz auf den gefundenen Knoten, null wenn nicht gefunden
     *
     */
    public Knoten Suchen(String suchBezeichnung)
    {
        if (bezeichnung.compareTo(suchBezeichnung) == 0)
            return this;
        else if (nachfolger == null)
            return null;
        else
            return nachfolger.Suchen(suchBezeichnung);
    }

    /**
     * Einfügen einer Kante in die Adjazenzliste des Knotens Eine Kante ist
     * durch einen Anfangsknoten (=dieser Knoten) und einen Endknoten festgelegt
     * und hat eine Gewichtung.
     *
     * @param nachKnoten Referenz auf den Endknoten der Kante
     * @param gewichtung Gewichtung der Kante als Ganzzahl
     *
     */
    public void KanteEinfuegen(Knoten nachKnoten, int gewichtung)
    {
        Kante alterAnfang;
        alterAnfang = anfang;
        anfang = new Kante(nachKnoten, alterAnfang, gewichtung);
    }

    /**
     * Gibt den Bezeichner des Knotenobjekts zusammen mit der
     * Kantenadjanzenliste, die zu diesem Knoten gehört in der Konsole aus ruft,
     * sofern nicht letzter Knoten in der Liste, die Ausgabe des Nachfolgers auf
     *
     */
    public void Ausgeben()
    {
        System.out.print(BezeichnungGeben() + ": ");
        if (anfang != null)
            anfang.Ausgeben();
        System.out.println();
        if (nachfolger != null)
            nachfolger.Ausgeben();
    }
}
