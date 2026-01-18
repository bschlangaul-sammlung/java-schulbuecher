package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_01.binbaum_woerterbuch_kompositum;

/**
 * Klasse KNOTEN als Bestandteil eines geordneten Binärbaums. (Implementierung
 * mit Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
public class Knoten extends BaumElement
{
    // Knoten
    private DatenElement daten;

    // Referenz auf den linken und rechten Nachfolger
    private BaumElement linkerNachfolger;

    private BaumElement rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN ohne linken und rechten
     * Nachfolger, d.h. es werden zwei Abschluss-Objekte erzeugt und den
     * entsprechenden Referenzattributen zugewiesen.
     *
     * @param datenNeu Referenz auf ein Objekt der KLasse DATENELEMENT, das vom
     *     Knoten verwaltet wird.
     */
    public Knoten(DatenElement datenNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();
    }

    /**
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist, in
     * die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @param datenNeu einzufügendes Datenelement
     *
     * @return Referenz auf das eigene Objekt
     */
    public BaumElement Einfuegen(DatenElement datenNeu)
    {
        // Falls es den Wert schon gibt, Einfuegen abbrechen.
        if (daten.IstGleich(datenNeu))
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage ob im rechten oder linken Teilbaum eingefügt werden muss
        else
        {
            if (daten.IstGroesserAls(datenNeu))
            {
                linkerNachfolger = linkerNachfolger.Einfuegen(datenNeu);
            }
            else
            {
                rechterNachfolger = rechterNachfolger.Einfuegen(datenNeu);
            }
        }
        return this;
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    public DatenElement Suchen(String suchSchluessel)
    {
        if (daten.SchluesselIstGleich(suchSchluessel))
        {
            return daten;
        }
        else
        {
            if (daten.SchluesselIstGroesserAls(suchSchluessel))
            {
                return linkerNachfolger.Suchen(suchSchluessel); // Rückgabewert
                                                                // wird nach
                                                                // unten
                                                                // abgefragt und
                                                                // dann nach
                                                                // oben
                                                                // durchgereicht
            }
            else
            {
                return rechterNachfolger.Suchen(suchSchluessel); // Rückgabewert
                                                                 // wird nach
                                                                 // unten
                                                                 // abgefragt
                                                                 // und dann
                                                                 // nach oben
                                                                 // durchgereicht
            }
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
        if (daten.SchluesselIstGleich(suchSchluessel))
        {
            return true;
        }
        else
        {
            if (daten.SchluesselIstGroesserAls(suchSchluessel))
            {
                return linkerNachfolger.IstVorhanden(suchSchluessel); // Rückgabewert
                                                                      // wird
                                                                      // nach
                                                                      // unten
                                                                      // abgefragt
                                                                      // und
                                                                      // dann
                                                                      // nach
                                                                      // oben
                                                                      // durchgereicht
            }
            else
            {
                return rechterNachfolger.IstVorhanden(suchSchluessel); // Rückgabewert
                                                                       // wird
                                                                       // nach
                                                                       // unten
                                                                       // abgefragt
                                                                       // und
                                                                       // dann
                                                                       // nach
                                                                       // oben
                                                                       // durchgereicht
            }
        }
    }
}
