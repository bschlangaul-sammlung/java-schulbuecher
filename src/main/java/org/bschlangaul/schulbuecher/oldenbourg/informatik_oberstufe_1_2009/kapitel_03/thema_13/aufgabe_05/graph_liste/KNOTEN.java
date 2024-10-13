package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_13.aufgabe_05.graph_liste;

/**
 * Klasse KNOTEN für die Darstellungen eines Graphen durch Adjazenzlisten
 * <p>
 * Schulbuch Informatik 1 Oberstufe Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 */
public class KNOTEN
{
    private String bezeichnung;

    private KANTE anfang;

    private KNOTEN nachfolger;

    // Attribut zur temporäre Speicherung ob ein Knoten besucht wurde oder nicht
    private boolean besucht;

    // Hilfsattribute für die Suche des kürzesten Wegs nach Dijkstra
    private int distanz;

    private KNOTEN kommtVon;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     *
     * @param neuerWert Bezeichnung des neuen Knotenobjekts
     * @param neuerNachfolger Referenz auf den Nachfolgeknoten
     *
     */
    public KNOTEN(String neuerWert, KNOTEN neuerNachfolger)
    {
        bezeichnung = neuerWert;
        anfang = null;
        nachfolger = neuerNachfolger;
        besucht = false;
        distanz = Integer.MAX_VALUE;
        kommtVon = null;
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
     * Gibt eine Referenz auf das erste Kantenobjekt des Knotens
     *
     * @return Referenz auf Kantenobjekt
     *
     */
    public KANTE AnfangGeben()
    {
        return anfang;
    }

    /**
     * Gibt eine Referenz auf das nachfolgende Knotenobjekt
     *
     * @return Referenz auf Knotenobjekt
     *
     */
    public KNOTEN NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Setzt den Status des Attributs besucht
     *
     * @param neuerWert neuer Wert für besucht
     *
     */
    public void BesuchtSetzen(boolean neuerWert)
    {
        besucht = neuerWert;
    }

    /**
     * Setzt den Status des Attributs besucht für diesen und alle nachfolgenden
     * Knoten in der Knotenliste
     *
     * @param neuerWert neuer Wert für besucht
     *
     */
    public void AlleBesuchtSetzen(boolean neuerWert)
    {
        besucht = neuerWert;
        if (nachfolger != null)
            nachfolger.AlleBesuchtSetzen(neuerWert);
    }

    /**
     * Gibt den Status des Attributs besucht des Knotenobjekts zurück
     *
     * @return Bezeichner
     *
     */
    public boolean BesuchtGeben()
    {
        return besucht;
    }

    /**
     * Setzt den Status des Attributs distanz
     *
     * @param neuerWert neuer Wert für distanz
     *
     */
    public void DistanzSetzen(int neuerWert)
    {
        distanz = neuerWert;
    }

    /**
     * Setzt den Status des Attributs distanz für diesen und alle nachfolgenden
     * Knoten in der Knotenliste
     *
     * @param neuerWert neuer Wert für distanz
     *
     */
    public void AlleDistanzSetzen(int neuerWert)
    {
        distanz = neuerWert;
        if (nachfolger != null)
            nachfolger.AlleDistanzSetzen(neuerWert);
    }

    /**
     * Gibt den Status des Attributs distanz des Knotenobjekts zurück
     *
     * @return Bezeichner
     *
     */
    public int DistanzGeben()
    {
        return distanz;
    }

    /**
     * Setzt den Status des Attributs kommtVon
     *
     * @param neuerWert neuer Wert für kommtVon
     *
     */
    public void KommtVonSetzen(KNOTEN neuerWert)
    {
        kommtVon = neuerWert;
    }

    /**
     * Gibt den Status des Attributs kommtVon des Knotenobjekts zurück
     *
     * @return Referenz auf Knotenobjekt
     *
     */
    public KNOTEN KommtVonGeben()
    {
        return kommtVon;
    }

    /**
     * Sucht in der Knotenliste nach einem Knoten mit dem übergebenen
     * Bezeichner; die Suche beginnt ab dem aufgerufenen Knoten; ruft rekursiv
     * das Suchen des Nachfolgers auf
     *
     * @return Referenz auf den gefundenen Knoten, null wenn nicht gefunden
     *
     */
    public KNOTEN Suchen(String suchBezeichnung)
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
    public void KanteEinfuegen(KNOTEN nachKnoten, int gewichtung)
    {
        KANTE alterAnfang;
        alterAnfang = anfang;
        anfang = new KANTE(nachKnoten, alterAnfang, gewichtung);
    }

    /**
     * Gibt den Bezeichner des Knotenobjekts zusammen mit der Adjazenzliste, die
     * zu diesem Knoten gehört in der Konsole aus ruft, sofern nicht letzter
     * Knoten in der Liste, die Ausgabe des Nachfolgers auf
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
