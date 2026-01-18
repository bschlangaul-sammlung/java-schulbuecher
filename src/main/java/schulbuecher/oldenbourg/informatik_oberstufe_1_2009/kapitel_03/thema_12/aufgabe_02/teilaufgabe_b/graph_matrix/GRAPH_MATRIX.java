package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_03.thema_12.aufgabe_02.teilaufgabe_b.graph_matrix;

/**
 * Klasse GRAPH_MATRIX Klasse für einen ungerichteten, gewichteten Graphen Als
 * Datenstruktur wird eine Adjazenzmatrix verwendet
 * <p>
 * Schulbuch Informatik 1 Oberstufe Oldenbourg Verlag
 *
 * @author U.Freiberger
 *
 * @version 1.0
 *
 */
public class GRAPH_MATRIX
{
    // aktuelle Knotenanzahl
    private int anzahlKnoten;

    // Feld der Knoten des Graphen
    private KNOTEN[] knoten;

    // 2-dim Feld der Adjazenzmatrix
    private int[][] matrix;

    // Hilfsfeld zur temporären Speicherung ob ein Knoten besucht wurde oder
    // nicht
    private boolean[] besucht;

    /**
     * Konstruktor für Objekte der Klasse GRAPH_MATRIX Die maximale Anzahl der
     * Knoten wird dabei festgelegt
     *
     * @param maximaleKnoten Anzahl der maximal möglichen Knoten
     *
     */
    public GRAPH_MATRIX(int maximaleKnoten)
    {
        anzahlKnoten = 0;
        knoten = new KNOTEN[maximaleKnoten];
        matrix = new int[maximaleKnoten][maximaleKnoten];
        besucht = new boolean[maximaleKnoten];
    }

    /**
     * Einfügen eines neuen Knoten in den Graphen Wenn die maximale Anzahl an
     * Knoten erreicht wird, dann erfolgt kein Einfügen
     *
     * @param bezeichner Bezeichner des neuen Knotens, der dem Graphen
     *     hinzugefügt wird.
     *
     */
    public void KnotenEinfuegen(String bezeichner)
    {
        if ((anzahlKnoten < knoten.length) && (KnotenNummer(bezeichner) == -1))
        {
            knoten[anzahlKnoten] = new KNOTEN(bezeichner);
            matrix[anzahlKnoten][anzahlKnoten] = 0;
            for (int i = 0; i < anzahlKnoten; i++)
            {
                // Symmetrie, da ungerichteter Graph
                matrix[anzahlKnoten][i] = -1;
                matrix[i][anzahlKnoten] = -1;
            }
            anzahlKnoten = anzahlKnoten + 1;
        }
    }

    /**
     * Gibt die interne Nummer des Knoten Wenn ein Knoten mit diesem Bezeichner
     * nicht bekannt ist wird -1 zurückgegeben
     *
     * @param bezeichner Bezeichner des Knoten der gesucht wird
     *
     * @return Indexnummer des Knotens im Knotenarray; 0&lt;= x &lt;= anzahl-1
     *     bzw. -1
     *
     */
    private int KnotenNummer(String bezeichner)
    {
        int i, ergeb;
        ergeb = -1;
        for (i = 0; (i < anzahlKnoten) && (ergeb == -1); i++)
            if (knoten[i].BezeichnungGeben().equals(bezeichner))
                ergeb = i;
        return ergeb;
    }

    /**
     * Gibt die Bezeichnung eines Knotens mit der internen Knotennummer
     *
     * @param knotenNummer Indexnummer des Knotens im Knotenarray; 0&lt;= x
     *     &lt;= anzahl-1
     *
     * @return bezeichner Bezeichner des Knoten
     *
     */
    public String KnotenBezeichnerGeben(int knotenNummer)
    {
        if ((knotenNummer < anzahlKnoten) && (knotenNummer >= 0))
            return knoten[knotenNummer].BezeichnungGeben();
        else
            return "";
    }

    /**
     * Einfügen einer Kante in den Graphen Eine Kante ist durch einen
     * Anfangsknoten und einen Endknoten festgelegt und hat eine Gewichtung
     *
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     * @param gewichtung Gewichtung der Kante als Ganzzahl
     *
     */
    public void KanteEinfuegen(String von, String nach, int gewichtung)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummer(von);
        nachNummer = KnotenNummer(nach);
        if ((vonNummer != -1) && (nachNummer != -1)
                && (vonNummer != nachNummer))
        {
            matrix[vonNummer][nachNummer] = gewichtung;
            matrix[nachNummer][vonNummer] = gewichtung;
        }
    }

    /**
     * Gibt die Adjazenzmatrix des Graphen in der Konsole aus Nach Zeilen und
     * Spalten formatiert Als Spaltenbreite wurde hier 4 Zeichen gewählt.
     *
     */
    public void Ausgeben()
    {
        int breite = 4;
        // Kopfzeile
        System.out.print("    ");
        for (int i = 0; i < anzahlKnoten; i++)
            System.out.print(knoten[i].BezFormatGeben(breite));
        System.out.println();
        for (int i = 0; i < anzahlKnoten; i++)
        {
            System.out.print(knoten[i].BezFormatGeben(breite));
            for (int j = 0; j < anzahlKnoten; j++)
                if (matrix[i][j] != -1)
                    System.out
                            .print((matrix[i][j] + "   ").substring(0, breite));
                else
                    System.out.print("    ");
            System.out.println();
        }
    }

    /**
     * Gibt die Anzahl der Knoten des Graphen
     *
     * @return Anzahl der Knoten
     *
     */
    int KnotenAnzahlgeben()
    {
        return anzahlKnoten;
    }

    /**
     * Gibt die Gewichtung einer Kante Die Kante ist durch einen Anfangsknoten
     * und einen Endknoten festgelegt
     *
     * @param von Bezeichner des Anfangsknotens
     * @param nach Bezeichner des Endknotens
     *
     * @return Gewichtung der Kante
     *
     */
    int KanteGewichtGeben(String von, String nach)
    {
        int vonNummer, nachNummer;
        vonNummer = KnotenNummer(von);
        nachNummer = KnotenNummer(nach);
        if ((vonNummer != -1) && (nachNummer != -1))
            return matrix[vonNummer][nachNummer];
        else
            return -1;
    }

    /**
     * Besucht einen Knoten und besucht dann alle von diesem Knoten ausgehenden
     * Knoten sofern diese noch nicht besucht wurden.
     *
     * @param knotenNummer Knotennummer des zu besuchenden Knotens
     *
     */
    private void Besuchen(int knotenNummer)
    {
        // aktiven Knoten auf besucht setzen und in der Konsole ausgeben
        besucht[knotenNummer] = true;
        System.out.print(
                "besucht " + knoten[knotenNummer].BezeichnungGeben() + "; ");
        // in der Matrix die Zeile des aktiven Knotens nach Kanten durchforsten
        for (int abzweigNummer = 0; abzweigNummer < anzahlKnoten; abzweigNummer++)
        {
            // es gibt eine Kante und deren Zielknoten ist noch nicht besucht
            if ((matrix[knotenNummer][abzweigNummer] > 0)
                    && !(besucht[abzweigNummer]))
            {
                Besuchen(abzweigNummer);
                System.out.print("zurück nach "
                        + knoten[knotenNummer].BezeichnungGeben() + "; ");
            }
        }
        // der aktive Knoten mit der knotenNummer ist fertig bearbeitet
        System.out.println(
                "fertig mit " + knoten[knotenNummer].BezeichnungGeben() + "; ");
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
        int startNummer;
        startNummer = KnotenNummer(startKnoten);
        if (startNummer != -1)
        {
            for (int i = 0; i < anzahlKnoten; i++)
                besucht[i] = false;
            Besuchen(startNummer);
        }
    }
}
