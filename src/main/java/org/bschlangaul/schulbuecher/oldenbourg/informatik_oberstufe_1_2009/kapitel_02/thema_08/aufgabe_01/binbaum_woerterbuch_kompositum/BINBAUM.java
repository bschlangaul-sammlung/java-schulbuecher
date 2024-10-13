package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_01.binbaum_woerterbuch_kompositum;

/**
 * Die Klasse BINBAUM ist die Grundstruktur eines geordneten Binärbaums. Die
 * Methoden die ein Objekt dieser Klasse anbietet, leiten den Aufruf an den
 * Wurzelknoten weiter, wenn der Baum nicht leer ist. (Implementierung mit
 * Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
public class BINBAUM
{
    private BAUMELEMENT wurzel;

    /**
     * Konstruktor für Objekte der Klasse BINBAUM Ein leerer Baum wird erzeugt:
     * Er besteht nur aus einem Abschluss-Objekt.
     */
    public BINBAUM()
    {
        wurzel = new ABSCHLUSS();
    }

    /**
     * Fügt ein Datenelement sortiert in den geordneten Binärbaum ein, d.h. die
     * Eigenschaft, dass der Baum geordnet ist bleibt bei jedem Einfügevorgang
     * erhalten.
     *
     * @param datenNeu neues Datenelement
     */
    public void Einfuegen(DATENELEMENT datenNeu)
    {
        wurzel = wurzel.Einfuegen(datenNeu);
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param suchSchluessel neues Datenelement
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    public DATENELEMENT Suchen(String suchSchluessel)
    {
        return wurzel.Suchen(suchSchluessel);
    }

    /**
     * überprüt, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form
     * einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    public boolean IstVorhanden(String suchSchluessel)
    {
        return wurzel.IstVorhanden(suchSchluessel);
    }
}
