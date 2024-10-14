
/**
 * Der Ausgangbaustein des Labyrinths
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Ausgang extends Gang
{

    /**
     * Legt das Darstellungsrechteck in der Ausgangfarbe an.
     * @param x x-Position des Quadrats in Zellenangben
     * @param y y-Position des Quadrats in Zellenangben
     */
    Ausgang (int x, int y)
    {
        super(x, y);
        darstellung.FarbeSetzen("grün");
    }
}
