/**
 * Abstrakte Klasse Baumelement zur Realisierung einer Baumstruktur mit Hilfe des Entwurfsmusters
 * Kompositum: Die Klasse legt ausschließlich die Schnittstelle für die Klassen
 * Knoten und Abschluss in Form von Methoden fest.
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */

abstract class Baumelement
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    Baumelement()
    {
        // nichts zu tun
    }

    /**
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum 
     * bleibt erhalten.
     * @param datenNeu das Datenelement des einzufügenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers, null falls es kein Datenelement mit dem eingegebenen Schlüssel gibt
     */
    abstract Baumelement Einfügen(User datenNeu);       

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette 
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    abstract User Suchen(String suchSchlüssel); 

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist. 
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette 
     * @return true, im Erfolgsfall, false sonst.
     */
    abstract boolean IstVorhanden(String suchSchlüssel); 

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    abstract int HöheGeben(int aktTiefe);

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel suchSchluessel gespeichert ist.
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     * @param tiefe dei Teife des aktuellen Knotens
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht vorhanden ist.
     */
    abstract int TiefeGeben(String suchSchlüssel, int tiefe);

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen preorder auf der Konsole aus.
     */
    abstract void PreorderAusgeben();

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Inorder auf der Konsole aus.
     */
    abstract void InorderAusgeben();

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur durch Einrücken.
     */
    abstract void StrukturAusgeben(int tiefe);

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur inklusiv Abschluss-Objekte durch Einrücken.
     */
    abstract void StrukturAusgeben2(int tiefe);

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Postorder auf der Konsole aus.
     */
    abstract void PostorderAusgeben();
    
    /**
     * Methode AnzahlKnotenBerechnen berechnet die Anzahl der enthaltenen Knoten.
     *
     * @return Anzahl der Knoten
     */
    abstract int AnzahlKnotenBerechnen();
    
        /**
     * Methode AnzahlJugendlicheBerechnen berechnet die Anzahl der Nutzer unter 18 Jahre.
     *
     * @return Anzahl der Knoten
     */
    abstract int AnzahlJugendlicheBerechnen();
    
    /**
     * Methode AnzahlJugendlicheBerechnen berechnet die Anzahl der Nutzer, die
     * 18 Jahre oder älter sind.
     *
     * @return Anzahl der Knoten
     */
    abstract int AnzahlErwachseneBerechnen();
}
