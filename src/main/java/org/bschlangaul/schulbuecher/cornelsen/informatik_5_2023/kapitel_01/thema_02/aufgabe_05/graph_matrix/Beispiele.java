package org.bschlangaul.schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_05.graph_matrix;

/**
 * Beispiele für diverse Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Beispiele
{
    GraphMatrix g;

    Lesen l;

    /**
     * Legt das Graphenobjekt an.
     */
    Beispiele()
    {
        g = new GraphMatrix();
        l = new Lesen();
    }

    /**
     * Legt den Graphen für das Beispiel im Lehrtext an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenAbiturfahrt()
    {
        g.ZurückSetzen();
        if (l.LesenDatenbank("Abiturfahrt.grdb", g))
        {
            g.Ausgeben();
        }
    }

    /**
     * Legt einen Graphen für den süddeutschen Teil des Autobahnnetztes an. Am
     * Ende Ausgabe der Adjazenzmatrix zur Kontrolle
     */
    void AusführenAutobahn()
    {
        // Entsprechend AusführenAbiturfahrt ergänzen
    }

    /**
     * Legt einen Graphen für dei gegebenen Flugverbindungen an. Am Ende Ausgabe
     * der Adjazenzmatrix zur Kontrolle
     */
    void AusführenFlug()
    {
        // Entsprechend AusführenAbiturfahrt ergänzen
    }

    /**
     * Legt einen Graphen für das deutsche ICE-Netzt an. Am Ende Ausgabe der
     * Adjazenzmatrix zur Kontrolle
     */
    void AusführenICE()
    {
        // Entsprechend AusführenAbiturfahrt ergänzen
    }

    /**
     * Legt einen Graphen für das münchner S-U-Bahn-Netzt an. Am Ende Ausgabe
     * der Adjazenzmatrix zur Kontrolle
     */
    void AusführenSUBahn()
    {
        // Entsprechend AusführenAbiturfahrt ergänzen
    }
}
