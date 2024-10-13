package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_03;

/**
 * Klasse KNOTEN.
 * <p>
 * Schulbuch Informatik 2 Oberstufe Oldenbourg Verlag
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
