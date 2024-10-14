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
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette 
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    abstract User Suchen(int suchSchlüssel); 
}
