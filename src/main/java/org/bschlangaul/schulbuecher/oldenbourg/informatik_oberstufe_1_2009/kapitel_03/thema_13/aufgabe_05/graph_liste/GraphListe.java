package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_13.aufgabe_05.graph_liste;

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

    /**
     * Besucht einen Knoten und besucht dann alle von diesem Knoten ausgehenden
     * Knoten sofern diese noch nicht besucht wurden.
     *
     * @param knoten Referenz auf den zu besuchenden Knoten
     *
     */
    private void Besuchen(Knoten knoten)
    {
        Kante kante;
        Knoten abzweig;
        // aktiven Knoten auf besucht setzen und in der Konsole ausgeben
        knoten.BesuchtSetzen(true);
        System.out.print("besucht " + knoten.BezeichnungGeben() + "; ");
        // Alle Kanten des aktiven Knotens durchlaufen
        kante = knoten.AnfangGeben();
        while (kante != null)
        {
            abzweig = kante.ZielGeben();
            // es gibt eine Kante und deren Zeilknoten ist noch nicht besucht
            if (!abzweig.BesuchtGeben())
            {
                Besuchen(abzweig);
                System.out.print(
                        "zurück nach " + knoten.BezeichnungGeben() + "; ");
            }
            kante = kante.NachfolgerGeben();
        }
        // der aktive Knoten mit der knotenNummer ist fertig bearbeitet
        System.out.println("fertig mit " + knoten.BezeichnungGeben() + "; ");
    }

    /**
     * Eigentliche Tiefensuche ruft die rekursive Methode Besuchen mit dem
     * Startknoten auf
     *
     * @param startKnoten Bezeichner des Startknotens für die Tiefensuche
     *
     */
    public void TiefenSuche(String startKnoten)
    {
        Knoten start;
        if (anfang != null)
        {
            start = anfang.Suchen(startKnoten);
            if (start != null)
            {
                anfang.AlleBesuchtSetzen(false);
                Besuchen(start);
            }
        }
    }

    /**
     * Besucht einen Knoten und läuft alle Abzweigungen ab, die von diesem
     * Knoten ausgehen sofern deren Zielknoten noch nicht besucht wurde. Bricht
     * ab, wenn der Zielknoten erreicht wurde.
     *
     * @param knoten Referenz des zu besuchenden Knotens
     * @param zielKnoten Referenz des Zielknoten, der erreicht werden soll
     * @param pfad bisher abgelaufener Pfad in der Notation kn1/kn2/kn3 ...
     * @param laenge Gewichtung des bisher abgelaufenen Pfads
     *
     */
    private void Ablaufen(Knoten knoten, Knoten zielKnoten, String pfad,
            int laenge)
    {
        int neueLaenge;
        String neuerPfad;
        Kante kante;
        Knoten abzweig;
        // aktiven Knoten auf besucht setzen
        knoten.BesuchtSetzen(true);
        // wenn der Zielknoten erreicht wird, dann abbrechen und Pfad ausgeben
        if (knoten == zielKnoten)
            System.out.println(pfad + "; Länge " + laenge);
        // sonst alle existierenden und noch möglichen Abzweigungen ablaufen
        // wie bei der Tiefensuche
        else
        {
            kante = knoten.AnfangGeben();
            while (kante != null)
            {
                abzweig = kante.ZielGeben();
                // es gibt eine Kante und deren Zeilknoten ist noch nicht
                // besucht
                if (!abzweig.BesuchtGeben())
                {
                    // der Weg wird in Richtung der Abzweigung verlängert
                    neuerPfad = pfad + "/" + abzweig.BezeichnungGeben();
                    neueLaenge = laenge + kante.GewichtungGeben();
                    // rekursiver Aufruf des Ablaufes
                    Ablaufen(abzweig, zielKnoten, neuerPfad, neueLaenge);
                }
                kante = kante.NachfolgerGeben();
            }
        }
        // Knoten im Gegensatz zur Tiefensuche wieder freigeben
        knoten.BesuchtSetzen(false);
    }

    /**
     * Eigentliche Wegesuche ruft die rekursive Methode Ablaufen mit dem
     * Startknoten und Zielknoten auf
     *
     * @param startKnoten Bezeichner des Startknotens für die Wegesuche
     * @param zielKnoten Bezeichner des Zielknotens für die Wegesuche
     *
     */
    public void WegeSuchen(String startKnoten, String zielKnoten)
    {
        Knoten start, ziel;
        if (anfang != null)
        {
            start = anfang.Suchen(startKnoten);
            ziel = anfang.Suchen(zielKnoten);
            if ((start != null) && (ziel != null) && (start != ziel))
            {
                anfang.AlleBesuchtSetzen(false);
                Ablaufen(start, ziel, start.BezeichnungGeben(), 0);
            }
        }
    }

    /**
     * Sucht nach dem unbesuchten Knoten mit derzeit minimalsten Distanzwert
     * wird von KuerzesterWeg() aufgerufen
     *
     * @return Referenz auf den unbesuchten Knotens mit dem kleinsten
     *     Distanzwert
     *
     */
    private Knoten MinKnoten()
    {
        Knoten minKnoten, knoten;
        int minWert = Integer.MAX_VALUE;
        knoten = anfang;
        minKnoten = anfang;
        while (knoten != null)
        {
            if (!knoten.BesuchtGeben() && (minWert > knoten.DistanzGeben()))
            {
                minWert = knoten.DistanzGeben();
                minKnoten = knoten;
            }
            knoten = knoten.NachfolgerGeben();
        }
        return minKnoten;
    }

    /**
     * Suche nach dem kürzesten Weg zwischen Startknoten und Zielknoten nach dem
     * Algorithmus von Dijkstra
     *
     * @param startKnoten Referenz des Startknotens für die Suche des kürzesten
     *     Wegs
     * @param zielKnoten Referenz des Zielknotens für die Suche des kürzesten
     *     Wegs
     *
     */
    public void KuerzesterWeg(String startKnoten, String zielKnoten)
    {
        Knoten start, ziel, knoten, abzweig;
        Kante kante;
        int neueDistanz;
        String pfad;
        if (anfang != null)
        {
            start = anfang.Suchen(startKnoten);
            ziel = anfang.Suchen(zielKnoten);
            // Vorbereitung
            anfang.AlleBesuchtSetzen(false);
            anfang.AlleDistanzSetzen(Integer.MAX_VALUE);
            start.DistanzSetzen(0);
            start.KommtVonSetzen(start);
            // wiederhole bis alle Knoten besucht sind
            for (int i = 0; i < anzahlKnoten; i++)
            {
                // der unbesuchte Knoten mit der minimalen Distanz wird zum
                // aktiven Knoten
                knoten = MinKnoten();
                knoten.BesuchtSetzen(true);
                // für alle Abzweigungen vom aktiven Knoten zu unbesuchten
                // Knoten
                kante = knoten.AnfangGeben();
                while (kante != null)
                {
                    abzweig = kante.ZielGeben();
                    // es gibt eine Kante und deren Zeilknoten ist noch nicht
                    // besucht
                    if (!abzweig.BesuchtGeben())
                    {
                        // die Distanz für den Weg über den aktiven Knoten
                        // berechnen
                        neueDistanz = knoten.DistanzGeben()
                                + kante.GewichtungGeben();
                        // wenn diese Distanz kleiner ist als die des Zielknoten
                        if (neueDistanz < abzweig.DistanzGeben())
                        {
                            // Distanz anpassen
                            abzweig.DistanzSetzen(neueDistanz);
                            // günstige Richtung anpassen
                            abzweig.KommtVonSetzen(knoten);
                        }
                    }
                    kante = kante.NachfolgerGeben();
                }
            }
            // Fertig! Die Entfernung ausgeben
            System.out.println("Entfernung: " + ziel.DistanzGeben());
            // Den Pfad des kürzesten Weges rückwärts, beim Ziel beginnend
            // ausgeben
            pfad = ziel.BezeichnungGeben();
            knoten = ziel;
            while (knoten != start)
            {
                knoten = knoten.KommtVonGeben();
                pfad = knoten.BezeichnungGeben() + "/" + pfad;
            }
            System.out.println("Weg: " + pfad);
        }
    }
}
