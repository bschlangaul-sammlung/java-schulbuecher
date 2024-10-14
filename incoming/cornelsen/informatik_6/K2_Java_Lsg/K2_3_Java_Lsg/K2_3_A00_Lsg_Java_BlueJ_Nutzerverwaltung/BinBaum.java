/**
 * Die Klasse Binbaum ist die Grundstruktur eines geordneten Bin�rbaums
 * und hier zur Verwaltung von Usern eingesetzt wird.
 * Die Methoden die ein Objekt dieser Klasse anbietet, leiten den Aufruf an den
 * Wurzelknoten weiter, wenn der Baum nicht leer ist.
 * (Implementierung ohne Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin
 * @version 24.5.24
 */
 class BinBaum
{
    /** Die Wurzel des Baums */
    private Knoten wurzel;

    /**
     * Konstruktor f�r Objekte der Klasse Binbaum:
     * Ein leerer Baum wird erzeugt.
     */
    BinBaum()
    {
        wurzel = null;
    }

    /**
     * F�gt ein Datenelement sortiert in den geordneten Bin�rbaum ein, 
     * d.h. die Eigenschaft, dass der Baum geordnet ist bleibt bei jedem 
     * Einf�gevorgang erhalten.
     * @param datenNeu neues Datenelement
     */
    void Einf�gen(User datenNeu)
    {
        if(wurzel != null)
        {
            wurzel.Einf�gen(datenNeu); 
        }
        else
        {
            wurzel = new Knoten(datenNeu);
        }
    }
}
