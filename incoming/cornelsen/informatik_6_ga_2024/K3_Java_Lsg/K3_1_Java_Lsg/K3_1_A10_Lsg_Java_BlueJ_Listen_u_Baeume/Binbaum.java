/**
 * Die Klasse Binbaum ist die Grundstruktur eines geordneten Binärbaums. 
 * Konkret wird hier der Binärbaum genutzt um ein einfaches Wörterbuch umzusetzen, 
 * deshalb sind die Daten von der Klasse Woerterbucheintrag.
 * Die Methoden die ein Objekt dieser Klasse anbietet, leiten den Aufruf an den
 * Wurzelknoten weiter, wenn der Baum nicht leer ist.
 * (Implementierung mit Entwurfsmuster Kompositum)
 * 
 * @author (Peter Brichzin) 
 * @version (23.5.24)
 */
class Binbaum
{
    /** Die wurzel des Bauns */
    private Baumelement wurzel;

    /**
     * Konstruktor für Objekte der Klasse Binbaum
     * Ein leerer Baum wird erzeugt: Er besteht nur aus einem Abschluss-Objekt.
     */
    Binbaum()
    {
        wurzel = new AbschlussBaum();
    }

    /**
     * Fügt ein Datenelement sortiert in den geordneten Binärbaum ein, 
     * d.h. die Eigenschaft, dass der Baum geordnet ist bleibt bei jedem 
     * Einfügevorgang erhalten.
     * @param datenNeu neues Datenelement
     */
    void Einfügen(Woerterbucheintrag datenNeu)
    {
        wurzel = wurzel.Einfügen(datenNeu);
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel 
     * identifiziert wird, und gibt es aus.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    Woerterbucheintrag Suchen(String suchSchlüssel)
    {
        return wurzel.Suchen(suchSchlüssel);
    }

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist. 
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette 
     * @return true, im Erfolgsfall, false sonst.
     */
    boolean IstVorhanden(String suchSchlüssel) 
    {
        return wurzel.IstVorhanden(suchSchlüssel);
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @return Höhe des Baums 
     */
    int HöheGeben()
    {
        return wurzel.HöheGeben(0);
    }

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel suchSchlüssel gespeichert ist.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette 
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchlüssel nicht vorhanden ist.
     */
    int TiefeGeben(String suchSchlüssel) 
    {
        return wurzel.TiefeGeben(suchSchlüssel, 0);
    }
}
