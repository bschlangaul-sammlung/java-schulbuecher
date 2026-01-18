package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_05.snake_l1;

/**
 * Verwaltet einen allgemeines Sonderfeld.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class SonderFeld
{
    /**
     * Das Anzeigesymbol
     */
    protected SonderSymbol symbol;

    /**
     * Das Spiel, in dem das Sonderfeld erzeugt wurde.
     */
    protected Spiel spiel;

    /**
     * Speichert die Referenz auf das Spiel.
     *
     * @param s das Spiel, in dem der Apfel erzeut werden soll.
     */
    SonderFeld(Spiel s)
    {
        spiel = s;
    }

    /**
     * Positioniert das Sonderfeld an zufälliger, freier Stelle.
     */
    protected void ZufälligPositionieren()
    {
        int x;
        int y;
        do
        {
            x = spiel.XKoordinateZufälligGeben();
            y = spiel.YKoordinateZufälligGeben();
        }
        while (!spiel.IstFrei(x, y));
        symbol.PositionSetzen(x, y);
    }

    /**
     * Gibt die x-Position des Sonderfelds zurück.
     *
     * @return x-Position des Sonderfelds
     */
    int XPositionGeben()
    {
        return symbol.XPositionGeben();
    }

    /**
     * Gibt die y-Position des Sonderfelds zurück.
     *
     * @return y-Position des Sonderfelds
     */
    int YPositionGeben()
    {
        return symbol.YPositionGeben();
    }

    /**
     * Führt die Aktion des Sonderfelds aus. Muss in den Unterklassen
     * überschrieben werden
     */
    abstract void Aktion();
}
