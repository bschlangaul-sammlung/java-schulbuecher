
/**
 * Verwaltet einen Pilz.
 * Der Pilz läßt die Schlange 10 Züge lang wachsen.
 * @author Albert Wiedemann
 * @version 1.0
 */
class Pilz extends SonderFeld
{
    /**
     * Legt einen Pilz an zufälliger, freier Stelle an.
     * @param s das Spiel, in dem der Pilz erzeut werden soll.
     */
    Pilz(Spiel s)
    {
        super(s);
        symbol = new PilzSymbol();
        ZufälligPositionieren();
    }
    
    /**
     * Führt die Aktion des Pilzes aus
     */
    @Override void Aktion()
    {
        spiel.Sonderwachstum();
        ZufälligPositionieren();
    }
}
