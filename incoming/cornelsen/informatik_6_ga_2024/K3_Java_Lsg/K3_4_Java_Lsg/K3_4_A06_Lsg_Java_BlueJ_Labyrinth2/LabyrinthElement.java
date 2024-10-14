
/**
 * Oberklasse aller Bausteine des Labyrinths
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class LabyrinthElement
{
    /**
     * Die Seitenlänge elens Elementquadrats */
    static final int seitenlänge = 20;
    /**
     * Das Darstellungsrechteck */
    protected Rechteck darstellung;
    /**
     * x-Position des Quadrats in Zellenangaben */
    protected int x;
    /**
     * y-Position des Quadrats in Zellenangaben */
    protected int y;

    /**
     * Legt das Darstellungsrechteck an.
     * @param x x-Position des Quadrats in Zellenangaben
     * @param y y-Position des Quadrats in Zellenangaben
     */
    LabyrinthElement (int x, int y)
    {
        this.x = x;
        this.y = y;
        darstellung = new Rechteck();
        darstellung.PositionSetzen(x * seitenlänge, y * seitenlänge);
        darstellung.GrößeSetzen(seitenlänge, seitenlänge);
    }

    /**
     * Gibt die x-Position des Elements zurück.
     * @return x-Position
     */
    int XPositionGeben()
    {
        return x;
    }

    /**
     * Gibt die y-Position des Elements zurück.
     * @return y-Position
     */
    int YPositionGeben()
    {
        return y;
    }

    /**
     * Setzt die Sichtbarkeit des Elements
     * @param sichtbar wenn wahr, ist das Element sichtbar
     */
    void SichtbarkeitSetzen(boolean sichtbar)
    {
        darstellung.SichtbarkeitSetzen(sichtbar);
    }
}
