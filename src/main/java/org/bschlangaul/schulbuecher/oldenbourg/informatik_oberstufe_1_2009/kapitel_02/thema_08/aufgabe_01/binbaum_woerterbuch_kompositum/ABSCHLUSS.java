package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_01.binbaum_woerterbuch_kompositum;

/**
 * Klasse ABSCHLUSS als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
public class ABSCHLUSS extends BAUMELEMENT
{
    /**
     * * Konstruktor für Objekte der Klasse ABSCHLUSS *
     */
    public ABSCHLUSS()
    {
        super();
    }

    /**
     * Fügt ein Datenelement in die bestehende Datenstruktur ein, indem es einen
     * neuen Knoten (mit zwei Abschluss-Objekten als Nachfolger) erzeugt und
     * eine Referenz auf diesen Knoten zurückgibt. Das Abschluss-Objekt, dass
     * diese Methode ausführt, wird dabei aus dem Baum entfernt.
     *
     * @param datenNeu einzufügendes Datenelement
     *
     * @return Referenz auf den neu erzeugten Knoten
     */
    public BAUMELEMENT Einfuegen(DATENELEMENT datenNeu)
    {
        return new KNOTEN(datenNeu);
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return null, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet
     *     den Ende eines Astes!).
     */
    public DATENELEMENT Suchen(String suchSchluessel)
    {
        return null;
    }

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return false, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet
     *     den Ende eines Astes!).
     */
    public boolean IstVorhanden(String suchSchluessel)
    {
        return false;
    }
}
