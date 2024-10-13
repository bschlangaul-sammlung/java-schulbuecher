
/**
 * Klasse zur Verwaltung der Lottozahlen
 * 
 * @author Klaus Reinold
 * @version 1.0
 */
class Lotto
{
    private Liste l;

    /**
     * Konstruktor der Klasse Lotto
     * erzeugt eine leere Liste
     */
    Lotto()
    {
        l = new Liste();
    }
    
    /**
     * Einfügen einer neuen Zahl
     * @param i einzufügende int-Zahl
     */
    void Einfügen(Zahl i)
    {
        Zahl zahl;
        zahl = new Zahl(i);
        l.SortiertEinfügen(zahl);
    }
    
    
    /**
     * Ausgabe aller Zahlen über die Konsole
     */
    void Ausgeben()
    {
        l.InformationAusgeben();
    }
}
