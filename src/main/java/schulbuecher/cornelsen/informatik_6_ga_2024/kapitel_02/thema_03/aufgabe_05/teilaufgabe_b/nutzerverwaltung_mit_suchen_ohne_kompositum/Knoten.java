package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_05.teilaufgabe_b.nutzerverwaltung_mit_suchen_ohne_kompositum;

/**
 * Klasse Knoten zur Verwaltung von Usern als Datenelement innerhalb eines
 * geordneten Binärbaums. (Implementierung ohne Entwurfsmuster Kompositum)
 *
 * @author (Peter Brichzin)
 *
 * @version (23.5.24)
 */
class Knoten
{
    /**
     * Referenz auf das Datenelement
     */
    private User daten;

    /**
     * Referenz auf den linken und rechten Nachfolger
     */
    private Knoten linkerNachfolger;

    private Knoten rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten
     * Nachfolger, d.h. die entsprechenden Referenzattribute haben den "Wert"
     * null.
     *
     * @param datenNeu Referenz auf das Datenelement, das vom Knoten verwaltet
     *     wird.
     */
    Knoten(User datenNeu)
    {
        daten = datenNeu;
        linkerNachfolger = null;
        rechterNachfolger = null;
    }

    /**
     * Fügt einen Usern als Datenelement, falls sein Schlüssel noch nicht
     * vorhanden ist, in die bestehende Datenstruktur ein. D.h. die Eigenschaft
     * geordneter Binärbaum bleibt erhalten.
     *
     * @param datenNeu einzufügender User als Datenelement
     */
    void Einfügen(User datenNeu)
    {
        // Falls es ein Datenelement mit dem gleichen Schlüssel schon gibt:
        // Einfügen abbrechen.
        if (daten.IstGleich(datenNeu))
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage, ob im rechten oder linken Teilbaum eingefügt werden muss
        else
        {
            if (daten.IstGrößerAls(datenNeu))
            {
                // wenn es einen linken Nachfolger gibt,
                // dannn wird das Datenelement im linkem Teilbaum eingefügt,
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement
                // erzeugt und als linker Nachfolger zugewiesen
                if (linkerNachfolger != null)
                {
                    linkerNachfolger.Einfügen(datenNeu);
                }
                else
                {
                    linkerNachfolger = new Knoten(datenNeu);
                }
            }
            else
            {
                // wenn es einen rechten Nachfolger gibt,
                // dannn wird das Datenelement im rechten Teilbaum eingefügt,
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement
                // erzeugt und als rechter Nachfolger zugewiesen
                if (rechterNachfolger != null)
                {
                    rechterNachfolger.Einfügen(datenNeu);
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
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird und
     * gibt dieses aus.
     *
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement bzw. null, falls die Suche erfolglos ist
     */
    User Suchen(int suchSchlüssel)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return daten;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                // wenn es einen linken Nachfolger gibt,
                // dann wird über eine Methodenaufruf beim linken Nachfolger
                // rekursiv gesucht
                // sonst war die Suche erfolglos,
                if (linkerNachfolger != null)
                {
                    return linkerNachfolger.Suchen(suchSchlüssel); // Rückgabewert
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
                    return rechterNachfolger.Suchen(suchSchlüssel); // Rückgabewert
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
        }
    }

    /**
     * Geben-Methode zu den Daten
     *
     * @return Referenz auf die Daten
     */
    User DatenGeben()
    {
        return daten;
    }

    /**
     * Geben-Methode zum linken Nachfolger
     *
     * @return Referenz auf LinkerNachfolger
     */
    Knoten LinkerNachfolgerGeben()
    {
        return linkerNachfolger;
    }

    /**
     * Geben-Methode zum rechten Nachfolger
     *
     * @return Referenz auf RechterNachfolger
     */
    Knoten RechterNachfolgerGeben()
    {
        return rechterNachfolger;
    }
}
