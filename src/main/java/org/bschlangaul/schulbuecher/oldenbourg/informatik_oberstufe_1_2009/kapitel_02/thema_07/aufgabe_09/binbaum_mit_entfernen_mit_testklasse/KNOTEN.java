package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_09.binbaum_mit_entfernen_mit_testklasse;

/**
 * Klasse KNOTEN als Bestandteil eines geordneten Binärbaums. (Implementierung
 * ohne Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (27.7.08)
 */
public class KNOTEN
{
    // Referenz auf das Datenelement
    private DATENELEMENT daten;

    // Referenz auf den linken und rechten Nachfolger
    private KNOTEN linkerNachfolger;

    private KNOTEN rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN ohne linken und rechten
     * Nachfolger, d.h. die entsprechenden Referenzattribute haben den "Wert"
     * null.
     *
     * @param datenNeu Referenz auf das Datenelement, das vom Knoten verwaltet
     *     wird.
     */
    public KNOTEN(DATENELEMENT datenNeu)
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
    public KNOTEN(DATENELEMENT datenNeu, KNOTEN liNachfolgerNeu,
            KNOTEN reNachfolgerNeu)
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
                    "Linker Nachfolger wurde nicht eingef\u00FCgt, um die Ordnng des Bin\u00E4rbaums zu erhalten!");
        }
        if (datenNeu.IstKleinerAls(reNachfolgerNeu.DatenGeben()))
        {
            rechterNachfolger = reNachfolgerNeu;
        }
        else
        {
            rechterNachfolger = null;
            System.out.println(
                    "Rechter Nachfolger wurde nicht eingef\u00FCgt, um die Ordnng des Bin\u00E4rbaums zu erhalten!");
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
    public DATENELEMENT Suchen(String suchSchluessel)
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
    public void Einfuegen(DATENELEMENT datenNeu)
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
                    linkerNachfolger = new KNOTEN(datenNeu);
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
                    rechterNachfolger = new KNOTEN(datenNeu);
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

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel (in
     * Form einer Zeichenkette) hat. Eine überprüfung, ob der Schlüssel in der
     * Baumstruktur vorhanden ist, erfolgt in der Klasse BINBAUM. Die Methode
     * Entfernen überprüt, welcher der folgenden 3 Fälle vorliegt und ruft dann
     * zum eigentlichen Entfernen entweder die Methode Entfernen2 auf bzw. gibt
     * die Aufforderung zum Entfernen an den linken oder rechten Nachbarn
     * weiter. 1. Fall: Der eigene Schlüssel ist größer als der suchSchluessel
     * --> Entfernen im rechten Teilbaum (rekursiver Aufruf) 2. Fall: Der eigene
     * Schlüssel ist kleiner als der suchSchluessel --> Entfernen im rechten
     * Teilbaum (rekursiver Aufruf) 3. Fall: Der eigene Knoten enthält den zu
     * entfernenden Wert --> Knoten wird mit Hilfe der Methode Entfernen2
     * entfernt.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return this im 1. und 2. Fall Rückgabewert der Methode Entfernen2 im 3.
     *     Fall
     *
     *
     */
    public KNOTEN Entfernen(String suchSchluessel)
    {
        // 1. Fall: Der eigene Schlüssel ist größer als der suchSchluessel
        // --> Entfernen im linken Teilbaum (rekursiver Aufruf)
        if (daten.SchluesselIstGroesserAls(suchSchluessel))
        {
            linkerNachfolger = linkerNachfolger.Entfernen(suchSchluessel);
            return this;
        }
        // 2. Fall: Der eigene Schlüssel ist kleiner als der suchSchluessel
        // --> Entfernen im rechten Teilbaum (rekursiver Aufruf)
        else if (daten.SchluesselIstKleinerAls(suchSchluessel))
        {
            rechterNachfolger = rechterNachfolger.Entfernen(suchSchluessel);
            return this;
        }
        else
        // 3. Fall: Der eigene Knoten enthält den zu entfernenden Wert
        {
            return Entfernen2(suchSchluessel); // Knoten wird entfernt
        }
    }

    /**
     * Wird die Methode Entfernen2 aufgerufen, ist der zu entfernende Knoten
     * bereits idetifiziert. Beim eigentlichen Entfernen können nun 3
     * prinzipiell unterschiedliche Fälle auftreten: und ruft dann entweder zum
     * eigentlichen Entfernen die Methode Entfernen2 auf bzw. gibt die
     * Aufforderung zum Entfernen an den linken oder rechten Nachbarn weiter.
     * Fall A: Der zu entfernende Knoten ist ein Blatt --> Knoten wird entfernt,
     * indem null zurückgegeben wird. Fall B: Der zu entfernende Knoten hat
     * genau einen Nachfolger, B1: einen rechten Nachfolger --> Der Knoten wird
     * ersetzt durch seinen rechten Nachfolger --> Rückgabewert ist eine
     * Referenz auf den rechten Nachfolger B2: einen linken Nachfolger --> Der
     * Knoten wird ersetzt durch seinen linken Nachfolger --> Rückgabewert ist
     * eine Referenz auf den linken Nachfolger Fall C: Der zu entfernende Knoten
     * hat genau zwei Nachfolger --> Suche das Minimum im rechten Teilbaum -->
     * Ersetze damit die eigenen Daten --> Entferne im rechten Teilbaum das
     * gefundene Minium (es ist ja schon als eigener Datensatz vorhanden) -->
     * Gib eine this als Referenz zurück (- Der eigene Knoten wird nicht
     * entfernt, sondern er hat nun eine andere Bedeutung, weil die Daten
     * ersetzt wurden Entfernt einen Knoten, dessen Datenelement den
     * eingegebenen Schlüssel (in Form einer Zeichenkette) hat.
     *
     * @param suchSchluessel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return Fall A: null Fall B: rechterNachfolger bzw. linkerNachfolger Fall
     *     C: this
     *
     *
     */
    public KNOTEN Entfernen2(String suchSchluessel)
    {
        // Fall A: Der zu entfernende Knoten ist ein Blatt
        if (linkerNachfolger == null && rechterNachfolger == null)
        {
            return null; // Knoten wird einfach entfernt
        }
        else
        // Fall B1: Der zu entfernende Knoten hat genau einen Nachfolger, einen
        // rechten
        if (linkerNachfolger == null && rechterNachfolger != null)
        {
            return rechterNachfolger; // Knoten kann entfernt werden und
                                      // wird in Struktur durch seinen
                                      // rechten Nachfolger ersetzt
        }
        else
        // Fall B2: Der zu entfernende Knoten hat genau einen Nachfolger, einen
        // linken
        if (linkerNachfolger != null && rechterNachfolger == null)
        {
            return linkerNachfolger; // Knoten kann entfernt werden und
                                     // wird in Struktur durch seinen
                                     // rechten Nachfolger ersetzt
        }
        else
        // Fall C: Der zu entfernende Knoten hat genau zwei Nachfolger
        {
            // Suche das Minimum im rechten Teilbaum und ersetze damit die
            // eigenen Daten
            DatenSetzen(rechterNachfolger.MinimumGeben());
            // Entferne das Minimum im rechten Teilbaum und haenge den
            // veraenderten
            // rechten Teilbaum als neuen rechten Teilbaum ein.
            rechterNachfolger = rechterNachfolger
                    .Entfernen(daten.SchluesselAlsStringGeben());
            return this;
        }
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur (ohne null) durch einrücken.
     */
    public void StrukturAusgeben(int tiefe)
    {
        // lokales Attribut zur Einrückung abh&aauml;ngig von der Tiefe
        String einrueckung;
        einrueckung = "";
        for (int i = 1; i < tiefe; i = i + 1)
        {
            einrueckung = einrueckung + "    ";
        }
        System.out.println(einrueckung + daten.SchluesselAlsStringGeben());
        if (linkerNachfolger == null)
        {
        }
        else
        {
            linkerNachfolger.StrukturAusgeben((tiefe + 1));
        }
        if (rechterNachfolger == null)
        {
        }
        else
        {
            rechterNachfolger.StrukturAusgeben((tiefe + 1));
        }
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur (mit null) durch einrücken.
     */
    public void StrukturAusgeben2(int tiefe)
    {
        // lokales Attribut zur Einrückung abh&aauml;ngig von der Tiefe
        String einrueckung;
        einrueckung = "";
        for (int i = 1; i < tiefe; i = i + 1)
        {
            einrueckung = einrueckung + "    ";
        }
        System.out.println(einrueckung + daten.SchluesselAlsStringGeben());
        if (linkerNachfolger == null)
        {
            System.out.println(einrueckung + "    " + "null");
        }
        else
        {
            linkerNachfolger.StrukturAusgeben2((tiefe + 1));
        }
        if (rechterNachfolger == null)
        {
            System.out.println(einrueckung + "    " + "null");
        }
        else
        {
            rechterNachfolger.StrukturAusgeben2((tiefe + 1));
        }
    }

    /**
     * SetzenMethode für die im Referenzattribut daten gespeicherten Daten
     *
     * @param datenNeu neue Daten
     */
    public void DatenSetzen(DATENELEMENT datenNeu)
    {
        daten = datenNeu;
    }

    /**
     * GebenMethode für die im Referenzattribut daten gespeicherten Daten
     *
     * @return daten
     */
    public DATENELEMENT DatenGeben()
    {
        return daten;
    }

    /**
     * Sucht bzgl.der Ordnungsrelation das Datenelement mit dem kleinsten
     * Schlüssel und gibt dieses zurück
     *
     * @return minimales Datenelement
     */
    public DATENELEMENT MinimumGeben()
    {
        if (linkerNachfolger == null)
        {
            return daten;
        }
        else
        {
            return linkerNachfolger.MinimumGeben();
        }
    }
}
