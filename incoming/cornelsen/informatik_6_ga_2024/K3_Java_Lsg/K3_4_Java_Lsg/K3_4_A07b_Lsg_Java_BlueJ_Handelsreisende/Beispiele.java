
/**
 * Der Handlungsreisende: Alle Orte besuchen
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class Beispiele
{
    GraphMatrix g;
    Lesen l;
    
    /**
     * Legt das Graphenobjekt an.
     */
    Beispiele ()
    {
        g = new GraphMatrix();
        l = new Lesen();
    }

    /**
     * Lädt das Standardbeispiel
     */
    void StandardbeispielLaden()
    {
        g.ZurückSetzen();
        l.LesenDatenbank("Autobahn.grdb", g);
        g.AlleVerbindungenBerechnen();
    }

    /**
     * Lädt das kleine Beispiel
     */
    void KleinesBeispielLaden()
    {
        g.ZurückSetzen();
        l.LesenDatenbank("Autobahn_klein.grdb", g);
        g.AlleVerbindungenBerechnen();
    }

    /**
     * Führt die Tiefensuche für alle Startknoten zurück zum Startknoten durch
     * und bestimmt dem optimalen Startknoten
     */
    void TiefensucheAusführen ()
    {
        if (g != null)
        {
            g.TiefensucheAusführen();
        }
    }
}
