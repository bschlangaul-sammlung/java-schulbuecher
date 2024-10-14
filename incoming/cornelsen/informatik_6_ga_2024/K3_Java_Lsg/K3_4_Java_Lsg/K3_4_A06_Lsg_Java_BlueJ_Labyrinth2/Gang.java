
/**
 * Ein Gangbaustein des Labyrinths
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Gang extends LabyrinthElement
{

    /**
     * Legt das Darstellungsrechteck in der Gangfarbe an.
     * @param x x-Position des Quadrats in Zellenangben
     * @param y y-Position des Quadrats in Zellenangben
     */
    Gang (int x, int y)
    {
        super(x, y);
        darstellung.FarbeSetzen("weiß");
    }
}
