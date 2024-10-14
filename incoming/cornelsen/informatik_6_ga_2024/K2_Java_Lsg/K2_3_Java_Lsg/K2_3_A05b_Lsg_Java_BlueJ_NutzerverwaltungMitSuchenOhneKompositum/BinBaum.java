/**
 * Die Klasse BinBaum ist die Grundstruktur eines geordneten Binärbaums
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
    /**
     * Die Wurzel des Baums */
    private Knoten wurzel;

    /**
     * Konstruktor für Objekte der Klasse Binbaum: Ein leerer Baum wird erzeugt.
     */
    BinBaum()
    {
        wurzel = null;
    }

    /**
     * Fügt ein Datenelement sortiert in den geordneten Binärbaum ein,
     * d.h. die Eigenschaft, dass der Baum geordnet ist bleibt bei jedem
     * Einfügevorgang erhalten.
     * @param datenNeu neues Datenelement
     */
    void Einfügen(User datenNeu)
    {
        if(wurzel != null)
        {
            wurzel.Einfügen(datenNeu);
        }
        else
        {
            wurzel = new Knoten(datenNeu);
        }
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel
     * identifiziert wird, und gibt es aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    User Suchen(int suchSchlüssel)
    {
        if (wurzel != null)
        {
            return wurzel.Suchen(suchSchlüssel);
        }
        else
        {
            return null;
        }
    }
}
