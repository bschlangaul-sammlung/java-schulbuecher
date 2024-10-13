package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_02;

/**
 * Klasse KNOTEN als Bestandteil eines geordneten Binärbaums. (Implementierung
 * mit Composite Pattern)
 *
 * @author (Peter Brichzin)
 *
 * @version (6.8.08)
 */
public class KNOTEN extends BAUMELEMENT
{
    // Knoten
    private DATENELEMENT daten;

    // Referenz auf den linken und rechten Nachfolger
    private BAUMELEMENT linkerNachfolger;

    private BAUMELEMENT rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN ohne linken und rechten
     * Nachfolger, d.h. es werden zwei Abschluss-Objekte erzeugt und den
     * entsprechenden Referenzattributen zugewiesen.
     *
     * @param datenNeu Referenz auf ein Objekt der KLasse DATENELEMENT, das vom
     *     Knoten verwaltet wird.
     */
    public KNOTEN(DATENELEMENT datenNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new ABSCHLUSS();
        rechterNachfolger = new ABSCHLUSS();
    }

    /**
     * Konstruktor für Objekte der Klasse KNOTEN ohne linken und rechten
     * Nachfolger, d.h. es werden zwei Abschluss-Objekte erzeugt und den
     * entsprechenden Referenzattributen zugewiesen.
     *
     * @param datenNeu Referenz auf ein Objekt der KLasse DATENELEMENT, das vom
     *     Knoten verwaltet wird.
     */
    public KNOTEN(DATENELEMENT datenNeu, BAUMELEMENT linkerNachfolgerNeu,
            BAUMELEMENT rechterNachfolgerNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = linkerNachfolgerNeu;
        rechterNachfolger = rechterNachfolgerNeu;
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
    public BAUMELEMENT Einfuegen(DATENELEMENT datenNeu)
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

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchluessel gespeichert ist.
     *
     * @param suchSchluessel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchluessel nicht
     *     vorhanden ist.
     */
    public int TiefeGeben(String suchSchluessel, int tiefe)
    {
        if (daten.SchluesselIstGleich(suchSchluessel))
        {
            return tiefe;
        }
        else
        {
            if (daten.SchluesselIstGroesserAls(suchSchluessel))
            {
                return linkerNachfolger.TiefeGeben(suchSchluessel, tiefe + 1);
            }
            else
            {
                return rechterNachfolger.TiefeGeben(suchSchluessel, tiefe + 1);
            }
        }
    }

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel
     * das aufgerufene Objekt ist Das eingefügte Baumelement kann selbst auch
     * Nachfolger haben. In diesem Fall kann mit der Methode RechtsEinfuegen
     * verschiedene Bäme zusammengefügt werden. Es ist wichtig, an der richtigen
     * Stelle einzufügen, damit die Ordnung des Binärbaums nicht zerstört wird!
     *
     * @param element einzufügendes Baumelement
     *
     * @return Referenz auf das eigene Objekt als Nachfolgeelement des Aufrufers
     */
    public BAUMELEMENT RechtsEinfuegen(BAUMELEMENT element)
    {
        rechterNachfolger = rechterNachfolger.RechtsEinfuegen(element);
        return this;
    }
}
