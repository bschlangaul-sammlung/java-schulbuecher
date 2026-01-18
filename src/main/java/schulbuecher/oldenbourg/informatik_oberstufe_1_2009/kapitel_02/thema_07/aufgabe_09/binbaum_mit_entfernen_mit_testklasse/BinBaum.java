package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_09.binbaum_mit_entfernen_mit_testklasse;

/**
 * Die Klasse BINBAUM ist die Grundstruktur eines geordneten Binärbaums. Die
 * Methoden die ein Objekt dieser Klasse anbietet, leiten den Aufruf an den
 * Wurzelknoten weiter, wenn der Baum nicht leer ist. (Implementierung ohne
 * Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (30.07.08)
 */
public class BinBaum
{
    private Knoten wurzel;

    /**
     * Konstruktor für Objekte der Klasse BINBAUM: Ein leerer Baum wird erzeugt.
     */
    public BinBaum()
    {
        wurzel = null;
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
        if (wurzel != null)
        {
            wurzel.Einfuegen(datenNeu);
        }
        else
        {
            wurzel = new Knoten(datenNeu);
        }
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
        if (wurzel != null)
        {
            return wurzel.Suchen(suchSchluessel);
        }
        else
        {
            return null;
        }
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
        if (wurzel != null)
        {
            return wurzel.IstVorhanden(suchSchluessel);
        }
        else
        {
            return false;
        }
    }

    /**
     * Entfernt den Knoten, dessen Datenelement den eingegebenen Schlüssel hat.
     * Falls es keinen Knoten mit dem eingegebenen Schlüssel gibt, wird dies
     * über die konsole mitgeteilt.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     */
    public void KnotenEntfernen(String suchSchluessel)
    {
        if (IstVorhanden(suchSchluessel)) // Bedingung enthaelt auch den
                                          // Sonderfall des leeren Baums
        {
            wurzel = wurzel.Entfernen(suchSchluessel);
        }
        else
        {
            System.out.println(
                    "Inhalt existiert nicht und kann deshalb nicht gelöscht werden");
        }
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur (ohne null) durch einrücken.
     */
    public void StrukturAusgeben()
    {
        wurzel.StrukturAusgeben(1);
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur (mit null) durch einrücken.
     */
    public void StrukturAusgeben2()
    {
        wurzel.StrukturAusgeben2(1);
    }
}
