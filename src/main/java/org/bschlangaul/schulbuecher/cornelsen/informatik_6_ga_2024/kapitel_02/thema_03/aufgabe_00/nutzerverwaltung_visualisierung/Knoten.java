package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_00.nutzerverwaltung_visualisierung;

import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.KantenSymbol;
import org.bschlangaul.schulbuecher.cornelsen.shared.graph_visualisierung.KnotenSymbol;

/**
 * Klasse Knoten zur Verwaltung von Usern als Datenelement innerhalb eines
 * geordneten Binärbaums. (Implementierung ohne Entwurfsmuster Kompositum)
 *
 * @author Peter Brichzin
 *
 * @version 23.5.24
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
     * Das Darstellungssymbol des Knotens und der Kanten
     */
    private KnotenSymbol knotenSymbol;

    private KantenSymbol kantenSymbol;

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

        knotenSymbol = new KnotenSymbol(100, 100, 25, "cyan",
                daten.NachnameGeben());
        knotenSymbol.SichtbarkeitSetzen(true);
        kantenSymbol = null;
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

    // Ab hier nur Methoden, die zur Darstellung des Baums benötigt werden!

    /**
     * Zeichnet den Knoten passend im Zeichenfenster, ergänzt ggf. noch eine
     * Kante zum Vorgänger
     *
     * @param xmin der minimale Wert des Breitenbereichs
     * @param xmax der maximale Wert des Breitenbereichs
     * @param y der y-Wert der Ebene
     * @param dy der Unerschied zur nächsten Ebene
     * @param symbolVorgänger nötig, um die Kante zu zeichnen: das eigene Symbol
     *     -> ist für den neuen Knoten das Vorgängersymbol
     */
    void KnotenZeichnen(int xmin, int xmax, int y, int dy,
            KnotenSymbol symbolVorgänger)
    {
        knotenSymbol.PositionSetzen(xmin + (xmax - xmin) / 2, y);
        // Eine Kante wird nur gezeichnet, wenn es einen Vorgänger gibt (d.h.
        // dieser Knoten nicht die Wurzel ist)
        if (symbolVorgänger != null)
        {
            if (kantenSymbol == null)
            {
                kantenSymbol = new KantenSymbol(symbolVorgänger, knotenSymbol,
                        false, "", 3, "schwarz");
            }
            else
            {
                kantenSymbol.DarstellungAktualisieren();
            }
        }

        if (rechterNachfolger != null)
        {
            rechterNachfolger.KnotenZeichnen(xmin + (xmax - xmin) / 2, xmax,
                    y + dy, dy, knotenSymbol);
        }
        if (linkerNachfolger != null)
        {
            linkerNachfolger.KnotenZeichnen(xmin, xmin + (xmax - xmin) / 2,
                    y + dy, dy, knotenSymbol);
        }
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @param aktTiefe Tiefe des aktuellen Knotens
     *
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    int HöheGeben(int aktTiefe)
    {
        // lokale Attriubute
        int maxHöheLinkerTeilbaum;
        maxHöheLinkerTeilbaum = 0;
        int maxHöheRechterTeilbaum;
        maxHöheRechterTeilbaum = 0;

        if (linkerNachfolger != null)
        {
            maxHöheLinkerTeilbaum = linkerNachfolger.HöheGeben(aktTiefe + 1);
        }
        else
        {
            maxHöheLinkerTeilbaum = aktTiefe;
        }

        if (rechterNachfolger != null)
        {
            maxHöheRechterTeilbaum = rechterNachfolger.HöheGeben(aktTiefe + 1);
        }
        else
        {
            maxHöheRechterTeilbaum = aktTiefe;
        }

        if (maxHöheLinkerTeilbaum > maxHöheRechterTeilbaum)
        {
            return maxHöheLinkerTeilbaum;
        }
        else
        {
            return maxHöheRechterTeilbaum;
        }
    }
}
