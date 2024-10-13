package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_09.aufgabe_05.binbaum_durchlaufen;

/**
 * Abstrakte Klasse BAUMELEMENT zur Realisierung einer Baumstruktur mit Hilfe
 * des Entwurfsmusters Kompositum: Die Klasse legt ausschließlich die
 * Schnittstelle für die Klassen KNOTEN und ABSCHLUSS in Form von Methoden fest.
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
abstract class BAUMELEMENT
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    BAUMELEMENT()
    {
        // nichts zu tun
    }

    /**
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist, in
     * die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @return (neues) Nachfolgeelement des Aufrufers, null falls es kein
     *     Datenelement mit dem eingegebenen Schlüssel gibt
     */
    public abstract BAUMELEMENT Einfuegen(DATENELEMENT datenNeu);

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    public abstract DATENELEMENT Suchen(String suchSchluessel);

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    public abstract boolean IstVorhanden(String suchSchluessel);

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht
     *     vorhanden ist.
     */
    public abstract int TiefeGeben(String suchSchluessel, int tiefe);

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel
     * das aufgerufene Objekt ist Das eingefügte Baumelement kann selbst auch
     * Nachfolger haben. In diesem Fall kann mit der Methode RechtsEinfuegen
     * verschiedene Bäme zusammengefügt werden. Es ist wichtig, an der richtigen
     * Stelle einzufügen, damit die Ordnung des Binärbaums nicht zerstört wird!
     *
     * @param element einzufügendes Baumelement
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    public abstract BAUMELEMENT RechtsEinfuegen(BAUMELEMENT element);

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel (in
     * Form einer Zeichenkette) hat.
     *
     * @param suchSchluessel Schlüssel, identifiziert das zu entfernende
     *     Datenelement und damit auch den zu entfernenden Knoten
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    public abstract BAUMELEMENT Entfernen(String suchSchluessel);

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * preorder auf der Konsole aus.
     */
    public abstract void PreorderAusgeben();

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Inorder auf der Konsole aus.
     */
    public abstract void InorderAusgeben();

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur durch Einrücken.
     */
    public abstract void StrukturAusgeben(int tiefe);

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur inklusiv Abschluss-Objekte durch Einrücken.
     */
    public abstract void StrukturAusgeben2(int tiefe);

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Postorder auf der Konsole aus.
     */
    public abstract void PostorderAusgeben();
}
