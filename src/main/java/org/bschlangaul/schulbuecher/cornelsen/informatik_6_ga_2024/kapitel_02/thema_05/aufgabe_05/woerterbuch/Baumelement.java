package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_05.woerterbuch;

/**
 * Abstrakte Klasse Baumelement zur Realisierung einer Baumstruktur mit Hilfe
 * des Entwurfsmusters Kompositum: Die Klasse legt ausschließlich die
 * Schnittstelle für die Klassen Knoten und Abschluss in Form von Methoden fest.
 *
 * @author (Peter Brichzin)
 *
 * @version (23.5.24)
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
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist, in
     * die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @param datenNeu das Datenelement des einzufügenden Knoten
     *
     * @return (neues) Nachfolgeelement des Aufrufers, null falls es kein
     *     Datenelement mit dem eingegebenen Schlüssel gibt
     */
    abstract Baumelement Einfügen(Woerterbucheintrag datenNeu);

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    abstract Woerterbucheintrag Suchen(String suchSchlüssel);

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    abstract boolean IstVorhanden(String suchSchlüssel);

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @param aktTiefe Tiefe des aktuellen Knotens
     *
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    abstract int HöheGeben(int aktTiefe);

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     * @param tiefe dei Teife des aktuellen Knotens
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht
     *     vorhanden ist.
     */
    abstract int TiefeGeben(String suchSchlüssel, int tiefe);

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * preorder auf der Konsole aus.
     */
    abstract void PreorderAusgeben();

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Inorder auf der Konsole aus.
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
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Postorder auf der Konsole aus.
     */
    abstract void PostorderAusgeben();

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel
     * das aufgerufene Objekt ist Das eingefügte Baumelement kann selbst auch
     * Nachfolger haben. In diesem Fall kann mit der Methode RechtsEinfuegen
     * verschiedene Bäume zusammengefügt werden. Es ist wichtig, an der
     * richtigen Stelle einzufügen, damit die Ordnung des Binärbaums nicht
     * zerstört wird!
     *
     * @param element einzufügendes Baumelement
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract Baumelement RechtsEinfügen(Baumelement element);

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel
     * hat.
     *
     * @param vergleichsSchlüssel Schlülssel, identifiziert das zu entfernende
     *     Datenelement und damit auch den zu entfernenden Knoten
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract Baumelement Entfernen(String vergleichsSchlüssel);

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel
     * hat.
     *
     * @param vergleichsSchlüssel Schlülssel, identifiziert das zu entfernende
     *     Datenelement und damit auch den zu entfernenden Knoten
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract Baumelement Entfernen2(String vergleichsSchlüssel);

    /**
     * Sucht bzgl.der Ordnungsrelation das Datenelement mit dem kleinsten
     * Schlüssel und gibt dieses zurück
     *
     * @param aktuellesMinimum
     *
     * @return Datenelement mit minimalem Schlüsselwert
     */
    abstract Woerterbucheintrag MinimumGeben(
            Woerterbucheintrag aktuellesMinimum);

}
