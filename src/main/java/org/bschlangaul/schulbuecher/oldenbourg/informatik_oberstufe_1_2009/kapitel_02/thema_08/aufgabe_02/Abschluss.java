package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_02;

/**
 * Klasse ABSCHLUSS als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
public class Abschluss extends BaumElement
{
    /**
     * * Konstruktor für Objekte der Klasse ABSCHLUSS *
     */
    public Abschluss()
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
    public BaumElement Einfuegen(DatenElement datenNeu)
    {
        return new Knoten(datenNeu);
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
    public DatenElement Suchen(String suchSchluessel)
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

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return -1 da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet den
     *     Ende eines Astes!).
     */
    public int TiefeGeben(String suchSchluessel, int tiefe)
    {
        return -1;
    }

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel
     * das aufgerufene Objekt ist Das eingefügte Baumelement kann selbst auch
     * Nachfolger haben, ist somit selbst ein Teilbaum Hier in der Klasse
     * ABSCHLUSS ist das Ende eines Asts bereits erreicht. Das element (egal ob
     * Knoten, Knoten mit Nachfolgern - d.h. Teilbaum - oder Abschluss wird
     * eingefügt. Damit wird das aufgerufene Abschluss-Objekt ü berschrieben
     *
     * @param element einzufügendes Baumelement
     *
     * @return Referenz auf das einzufügende Baumelement als neues
     *     Nachfolgeelement des Aufrufers
     */
    public BaumElement RechtsEinfuegen(BaumElement element)
    {
        return element;
    }
}
