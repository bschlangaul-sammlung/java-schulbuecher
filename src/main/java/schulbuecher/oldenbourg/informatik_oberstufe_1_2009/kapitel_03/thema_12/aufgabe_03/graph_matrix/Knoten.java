package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_12.aufgabe_03.graph_matrix;

/**
 * Klasse KNOTEN. für die Darstellungen eines Graphen mittels Adjazenzmatrix
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

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     */
    public Knoten(String neuerWert)
    {
        bezeichnung = neuerWert;
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
     * Gibt den Bezeichner des Knotenobjekts formatiert zurück Der Bezeichner
     * wird auf die angegebene Länge abgeschnitten bzw. mit Blanks aufgefüllt
     *
     * @param breite Anzahl der Zeichen auf die der Bezeichner formatiert wird.
     *     Maximal 15 Zeichen.
     *
     * @return formatierter Bezeichner
     *
     */
    public String BezFormatGeben(int breite)
    {
        return (bezeichnung + "               ").substring(0, breite);
    }
}
