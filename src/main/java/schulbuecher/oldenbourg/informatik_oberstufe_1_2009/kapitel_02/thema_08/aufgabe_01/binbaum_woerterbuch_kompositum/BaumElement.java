package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_01.binbaum_woerterbuch_kompositum;

/**
 * Abstrakte Klasse BAUMELEMENT zur Realisierung einer Baumstruktur mit Hilfe
 * des Entwurfsmusters Kompositum: Die Klasse legt ausschließlich die
 * Schnittstelle für die Klassen KNOTEN und ABSCHLUSS in Form von Methoden fest.
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
abstract class BaumElement
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    BaumElement()
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
    public abstract BaumElement Einfuegen(DatenElement datenNeu);

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    public abstract DatenElement Suchen(String suchSchluessel);

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    public abstract boolean IstVorhanden(String suchSchluessel);
}
