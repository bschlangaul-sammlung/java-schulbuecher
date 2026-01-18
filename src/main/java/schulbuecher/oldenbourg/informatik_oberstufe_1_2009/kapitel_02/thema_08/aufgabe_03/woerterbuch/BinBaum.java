package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_03.woerterbuch;

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
public class BinBaum
{
    private BaumElement wurzel;

    /**
     * Konstruktor für Objekte der Klasse BINBAUM Ein leerer Baum wird erzeugt:
     * Er besteht nur aus einem Abschluss-Objekt.
     */
    public BinBaum()
    {
        wurzel = new Abschluss();
    }

    /**
     * Fügt ein Datenelement sortiert in den geordneten Binärbaum ein, d.h. die
     * Eigenschaft, dass der Baum geordnet ist bleibt bei jedem Einfügevorgang
     * erhalten.
     *
     * @param datenNeu neues Datenelement
     */
    public void Einfuegen(DatenElement datenNeu)
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
    public DatenElement Suchen(String suchSchluessel)
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

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht
     *     vorhanden ist.
     */
    public int TiefeGeben(String suchSchluessel)
    {
        return wurzel.TiefeGeben(suchSchluessel, 0);
    }

    /**
     * Fügt ein Baumelement "rechts unten" in den Baum ein. Das eingefügte
     * Baumelement kann selbst auch Nachfolger haben. In diesem Fall kann mit
     * der Methode RechtsEinfuegen verschiedene Bäme zusammengefügt werden. Es
     * ist wichtig, an der richtigen Stelle einzufügen, damit die Ordnung des
     * Binärbaums nicht zerstört wird!
     *
     * @param element einzufügendes Baumelement
     */
    public void RechtsEinfuegen(BaumElement element)
    {
        wurzel = wurzel.RechtsEinfuegen(element);
    }

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel (in
     * Form einer Zeichenkette) hat.
     *
     * @param suchSchluessel Schlüssel, identifiziert das zu entfernende
     *     Datenelement und damit auch den zu entfernenden Knoten
     */
    public void KnotenEntfernen(String suchSchluessel)
    {
        wurzel = wurzel.Entfernen(suchSchluessel);
    }
}
