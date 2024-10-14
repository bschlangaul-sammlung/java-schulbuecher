
/**
 * Ein Mauerbaustein des Labyrinths
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Mauer extends LabyrinthElement
{

    /**
     * Legt das Darstellungsrechteck in der Mauerfarbe an.
     * @param x x-Position des Quadrats in Zellenangben
     * @param y y-Position des Quadrats in Zellenangben
     */
    Mauer (int x, int y)
    {
        super(x, y);
        darstellung.FarbeSetzen("schwarz");
    }
}
