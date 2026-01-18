package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_08.binbaum_woerterbuch;

/**
 * Klasse KNOTEN als Bestandteil eines geordneten Binärbaums. (Implementierung
 * ohne Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (27.7.08)
 */
public class Knoten
{
    // Referenz auf das Datenelement
    private DatenElement daten;

    // Referenz auf den linken und rechten Nachfolger
    private Knoten linkerNachfolger;

    private Knoten rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN ohne linken und rechten
     * Nachfolger, d.h. die entsprechenden Referenzattribute haben den "Wert"
     * null.
     *
     * @param datenNeu Referenz auf das Datenelement, das vom Knoten verwaltet
     *     wird.
     */
    public Knoten(DatenElement datenNeu)
    {
        daten = datenNeu;
        linkerNachfolger = null;
        rechterNachfolger = null;
    }

    /**
     * Konstruktor für Objekte der Klasse KNOTEN mit linken und rechten
     * Nachfolger,
     *
     * @param datenNeu Referenz auf das Datenelement, das vom Knoten verwaltet
     *     wird.
     * @param liNachfolgerNeu Referenz auf ein Knoten, der linker Nachfolger
     *     wird.
     * @param reNachfolgerNeu Referenz auf ein Knoten, der linker Nachfolger
     *     wird.
     */
    public Knoten(DatenElement datenNeu, Knoten liNachfolgerNeu,
            Knoten reNachfolgerNeu)
    {
        daten = datenNeu;
        if (datenNeu.IstGroesserAls(liNachfolgerNeu.DatenGeben()))
        {
            linkerNachfolger = liNachfolgerNeu;
        }
        else
        {
            linkerNachfolger = null;
            System.out.println(
                    "Linker Nachfolger wurde nicht eingefügt, um die Ordnng des Bin\u00E4rbaums zu erhalten!");
        }
        if (datenNeu.IstKleinerAls(reNachfolgerNeu.DatenGeben()))
        {
            rechterNachfolger = reNachfolgerNeu;
        }
        else
        {
            rechterNachfolger = null;
            System.out.println(
                    "Rechter Nachfolger wurde nicht eingefügt, um die Ordnng des Bin\u00E4rbaums zu erhalten!");
        }
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
                // wenn es einen linken Nachfolger gibt,
                // dann wird über eine Methodenaufruf beim linken Nachfolger
                // rekursiv gesucht
                // sonst war die Suche erfolglos,
                if (linkerNachfolger != null)
                {
                    return linkerNachfolger.Suchen(suchSchluessel); // Rückgabewert
                                                                    // wird nach
                                                                    // unten
                                                                    // abgefragt
                                                                    // und dann
                                                                    // nach oben
                                                                    // durchgereicht
                }
                else
                {
                    return null;
                }
            }
            else
            {
                // wenn es einen rechten Nachfolger gibt,
                // dann wird über eine Methodenaufruf beim rechten Nachfolger
                // rekursiv gesucht
                // sonst war die Suche erfolglos,
                if (rechterNachfolger != null)
                {
                    return rechterNachfolger.Suchen(suchSchluessel); // Rückgabewert
                                                                     // wird
                                                                     // nach
                                                                     // unten
                                                                     // abgefragt
                                                                     // und dann
                                                                     // nach
                                                                     // oben
                                                                     // durchgereicht
                }
                else
                {
                    return null;
                }
            }
        }
    }

    /**
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist, in
     * die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @param datenNeu einzufügendes Datenelement
     */
    public void Einfuegen(DatenElement datenNeu)
    {
        // Falls es ein Datenelement mit dem gleichen Schlüssel schon gibt,
        // Einfuegen abbrechen.
        if (daten.IstGleich(datenNeu))
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage ob im rechten oder linken Teilbaum eingefügt werden muss
        else
        {
            if (daten.IstGroesserAls(datenNeu))
            {
                // wenn es einen linken Nachfolger gibt,
                // dannn wird das Datenelement im linkem Teilbaum eingefügt
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement
                // erzeugt und als
                // linker Nachfolger zugewiesen
                if (linkerNachfolger != null)
                {
                    linkerNachfolger.Einfuegen(datenNeu);
                }
                else
                {
                    linkerNachfolger = new Knoten(datenNeu);
                }
            }
            else
            {
                // wenn es einen rechten Nachfolger gibt,
                // dannn wird das Datenelement im rechten Teilbaum eingefügt
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement
                // erzeugt und als
                // rechter Nachfolger zugewiesen
                if (rechterNachfolger != null)
                {
                    rechterNachfolger.Einfuegen(datenNeu);
                }
                // sonst Datenelement im rechten Teilbaum einfügen
                else
                {
                    rechterNachfolger = new Knoten(datenNeu);
                }
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
                // wenn es einen linken Nachfolger gibt,
                // dannn wird durch einen Methodenaufruf beim linken Nachfolger
                // rekursiv gesucht
                // sonst war die Suche erfolglos, false wird zurückgegeben.
                if (linkerNachfolger != null)
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
                    return false;
                }
            }
            else
            {
                // wenn es einen rechten Nachfolger gibt,
                // dannn wird durch einen Methodenaufruf beim rechten Nachfolger
                // rekursiv gesucht
                // sonst war die Suche erfolglos, false wird zurückgegeben.
                if (rechterNachfolger != null)
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
                else
                {
                    return false;
                }
            }
        }
    }

    public void DatenSetzen(DatenElement datenNeu)
    {
        daten = datenNeu;
    }

    public DatenElement DatenGeben()
    {
        return daten;
    }
}
