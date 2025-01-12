package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_11.aufgabe_07.teilaufgabe_a.graph_liste;

/**
 * Klasse KANTE für die Darstellungen eines Graphen durch Adjazenzlisten
 * <p>
 * Schulbuch Informatik 1 Oberstufe Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 */
public class Kante
{
    private int gewichtung;

    Knoten zielknoten;

    Kante nachfolger;

    /**
     * Konstruktor für Objekte der Klasse KANTE
     */
    public Kante(Knoten ziel, Kante naechste, int gewicht)
    {
        gewichtung = gewicht;
        zielknoten = ziel;
        nachfolger = naechste;
    }

    /**
     * Gibt den Bezeichner des Zielknotens der Kante zurück
     *
     * @return Bezeichner
     *
     */
    public String ZielknotenGeben()
    {
        return zielknoten.BezeichnungGeben();
    }

    /**
     * Gibt die Gewichtung der Kante zurück
     *
     * @return Gewichtung
     *
     */
    public int GewichtungGeben()
    {
        return gewichtung;
    }

    /**
     * Gibt die Kanteliste ab dieser Kante in der Konsole aus, jeweils
     * Bezeichner des Zielknoten und Gewichtung
     * <p>
     * Ruft, wenn es nicht die letzte Kante in der Adjazenzliste eines Knotens
     * ist, deren Nachfolger auf
     *
     */
    public void Ausgeben()
    {
        System.out.print(ZielknotenGeben() + "," + GewichtungGeben() + "; ");
        if (nachfolger != null)
            nachfolger.Ausgeben();
    }
}
