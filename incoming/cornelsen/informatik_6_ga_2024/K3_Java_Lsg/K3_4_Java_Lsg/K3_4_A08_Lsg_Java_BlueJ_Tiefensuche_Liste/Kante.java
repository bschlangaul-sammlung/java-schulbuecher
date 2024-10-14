
/**
 * Beschreibt eine Kante für die Graphendarstellung mit Adjazenzlisten
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Kante
{
    //Gewicht der Kante
    private int gewicht;
    // Zielknoten der Kante
    private Knoten ziel;
    
    /**
     * Legt ein Adjazenzlistenelement an.
     * @param gewicht das Gewicht der Kante
     * @param ziel der Zielknoten der Kante
     */
    Kante (int gewicht, Knoten ziel)
    {
        this.gewicht = gewicht;
        this.ziel = ziel;
    }
    
    /**
     * Meldet das Gewicht der Kante zurück
     * @return Gewicht
     */
    int GewichtGeben()
    {
        return gewicht;
    }
    
    /**
     * Meldet den Zielknoten der Kante zurück
     * @return Zielknoten
     */
    Knoten ZielGeben()
    {
        return ziel;
    }
}
