package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_10.listen_und_baeume;

/**
 * Klasse Abschluss als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit dem Entwurfsmuster Kompositum)
 *
 * @author (Peter Brichzin)
 *
 * @version (23.5.24)
 */
class AbschlussBaum extends Baumelement
{

    /**
     * Konstruktor für Objekte der Klasse Abschluss
     */
    AbschlussBaum()
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
    @Override
    Baumelement Einfügen(Woerterbucheintrag datenNeu)
    {
        return new KnotenBaum(datenNeu);
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return null, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet
     *     den Ende eines Astes!).
     */
    @Override
    Woerterbucheintrag Suchen(String suchSchlüssel)
    {
        return null;
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @param aktTiefe Tiefe des aktuellen Knotens
     *
     * @return die übergebene Höhe -1, da hier beim Abschluss das Ende eines
     *     Astes erreicht ist und die Abschlusselemente bei der Höhenberechnung
     *     nicht einbezogen werden.
     */
    @Override
    int HöheGeben(int aktTiefe)
    {
        return aktTiefe - 1;
    }

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return false, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet
     *     den Ende eines Astes!).
     */
    @Override
    boolean IstVorhanden(String suchSchlüssel)
    {
        return false;
    }

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem
     * Schl&uumlssel suchSchluessel gespeichert ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return -1 da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet den
     *     Ende eines Astes!).
     */
    @Override
    int TiefeGeben(String suchSchlüssel, int tiefe)
    {
        return -1;
    }
}
