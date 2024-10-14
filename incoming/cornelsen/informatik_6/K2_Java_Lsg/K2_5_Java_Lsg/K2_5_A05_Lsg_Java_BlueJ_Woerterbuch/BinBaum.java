/**
 * Die Klasse Binbaum ist die Grundstruktur eines geordneten Binärbaums. 
 * Konkret wird hier der Binärbaum genutzt um ein einfaches Wörterbuch umzusetzen, 
 * deshalb sind die Daten von der Klasse Woerterbucheintrag.
 * Die Methoden die ein Objekt dieser Klasse anbietet, leiten den Aufruf an den
 * Wurzelknoten weiter, wenn der Baum nicht leer ist.
 * (Implementierung mit Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
class BinBaum
{
    /** Die Wurzel des Baums */
    private Baumelement wurzel;

    /**
     * Konstruktor für Objekte der Klasse Binbaum
     * Ein leerer Baum wird erzeugt: Er besteht nur aus einem Abschluss-Objekt.
     */
    BinBaum()
    {
        wurzel = new Abschluss();
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

    /**
     * Gibt den Baum Inorder als Liste auf der Konsole aus.
     */
    void InorderAusgeben()
    {
        wurzel.InorderAusgeben();
    }

    /**
     * Gibt den Baum Preorder als Liste auf der Konsole aus.
     */
    void PreorderAusgeben()
    {
        wurzel.PreorderAusgeben();
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur durch Einrücken.
     */
    void StrukturAusgeben() 
    {
        wurzel.StrukturAusgeben(0);
    } 

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur inklusiv Abschluss-Objekte durch Einrücken.
     */
    void StrukturAusgeben2() 
    {
        wurzel.StrukturAusgeben2(0);
    } 

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Postorder auf der Konsole aus.
     */
    void PostorderAusgeben()
    {
        wurzel.PostorderAusgeben();
    }

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel das aufgerufene Objekt ist
     * Das eingefügte Baumelement kann selbst auch Nachfolger haben. In diesem Fall kann mit der Methode
     * RechtsEinfuegen verschiedene Bäume zusammengefügt werden. Es ist wichtig, an der richtigen Stelle einzufügen,
     * damit die Ordnung des Binärbaums nicht zerstört wird! 
     * @param element einzufügendes Baumelement
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    void RechtsEinfügen(Baumelement element)
    {
        wurzel= wurzel.RechtsEinfügen(element);
    }

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel hat. 
     * @param vergleichsSchlüssel Schlülssel, identifiziert das zu entfernende Datenelement und damit auch den zu entfernenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers
     */void KnotenEntfernen(String vergleichsschlüssel)
    {
        wurzel= wurzel.Entfernen(vergleichsschlüssel);
    }

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel hat. 
     * @param vergleichsSchlüssel Schlülssel, identifiziert das zu entfernende Datenelement und damit auch den zu entfernenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers
     */void KnotenEntfernen2(String vergleichsschlüssel)
    {
        wurzel= wurzel.Entfernen2(vergleichsschlüssel);
    }
}