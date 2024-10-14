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
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract Baumelement Einfügen(User datenNeu);       

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird 
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    abstract User Suchen(int suchSchlüssel); 

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist. 
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird 
     * @return true im Erfolgsfall, false sonst.
     */
    abstract boolean IstVorhanden(int suchSchlüssel); 

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    abstract int HöheGeben(int aktTiefe);

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel suchSchlüssel gespeichert ist.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird
     * @param tiefe die Tiefe des aktuellen Knotens
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchlüssel nicht vorhanden ist.
     */
    abstract int TiefeGeben(int suchSchlüssel, int tiefe);

    /**
     * Zeichnet den Knoten passend im Zeichenfenster, ergänzt ggf. noch eine Kante zum Vorgänger
     * @param xmin der minimale Wert des Breitenbereichs
     * @param xmax der maximale Wert des Breitenbereichs
     * @param y der y-Wert der Ebene
     * @param dy der Unterschied zur nächsten Ebene
     * @param symbolVorgänger nötig, um die Kante zu zeichnen: das eigene Symbol -> ist für den neuen Knoten das Vorgängersymbol
     */
    abstract void KnotenZeichnen(int xmin, int xmax, int y, int dy, KnotenSymbol symbolVorgänger);
}
