package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_03.woerterbuch;

/**
 * Abstrakte Klasse Baumelement zur Realisierung einer Baumstruktur mit Hilfe
 * des Entwurfsmusters Kompositum: Die Klasse legt ausschließlich die
 * Schnittstelle für die Klassen Knoten und Abschluss in Form von Methoden fest.
 *
 * @author Peter Brichzin
 *
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
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist, in
     * die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @param datenNeu das Datenelement des einzufügenden Knoten
     *
     * @return (neues) Nachfolgeelement des Aufrufers
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
     * @return true im Erfolgsfall, false sonst.
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
}
