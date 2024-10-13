
/**
 * Verwaltet einen Apfel.
 * Der Apfel gibt einen Bonus von 200 Punkten.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Apfel extends SonderFeld
{
    /**
     * Legt einen Apfel an zufälliger, freier Stelle an.
     * @param s das Spiel, in dem der Apfel erzeut werden soll.
     */
    Apfel(Spiel s)
    {
        super(s);
        symbol = new ApfelSymbol();
        ZufälligPositionieren();
    }
    
    /**
     * Führt die Aktion des Apfels aus
     */
    @Override void Aktion()
    {
        spiel.PunkteÄndern(200);
        ZufälligPositionieren();
    }
}
