package schulbuecher.cornelsen.informatik_5_2023.kapitel_01.thema_02.aufgabe_07.graph_liste;

/**
 * Beschreibt eine Kante für die Graphendarstellung mit Adjazenzlisten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Kante
{
    // Attribute laut Beschreibung ergänzen
    /**
     * Legt ein Adjazenzlistenelement an.
     *
     * @param gewicht das Gewicht der Kante
     * @param ziel der Zielknoten der Kante
     */
    Kante(int gewicht, Knoten ziel)
    {
        // Atttribute besetzen
    }

    /**
     * Meldet das Gewicht der Kante zurück
     *
     * @return Gewicht
     */
    int GewichtGeben()
    {
        // tatsächliches Gewicht zurück geben
        return -1;
    }

    /**
     * Meldet den Zielknoten der Kante zurück
     *
     * @return Zielknoten
     */
    Knoten ZielGeben()
    {
        // tatsächlichen Knoten zurück geben
        return null;
    }
}
