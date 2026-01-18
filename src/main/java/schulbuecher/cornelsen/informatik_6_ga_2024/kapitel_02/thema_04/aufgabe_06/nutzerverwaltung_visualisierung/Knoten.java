package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_04.aufgabe_06.nutzerverwaltung_visualisierung;

import schulbuecher.cornelsen.shared.graph_visualisierung.KantenSymbol;
import schulbuecher.cornelsen.shared.graph_visualisierung.KnotenSymbol;

/**
 * Klasse Knoten als Bestandteil eines geordneten Binärbaums. (Implementierung
 * mit Entwurfsmuster Kompositum)
 *
 * @author Peter Brichzin
 *
 * @version 23.5.24
 */
class Knoten extends Baumelement
{

    /**
     * Datenelement des Knotens
     */
    private User daten;

    /**
     * Referenz auf den linken Nachfolger
     */
    private Baumelement linkerNachfolger;

    /**
     * Referenz auf den rechten Nachfolger
     */
    private Baumelement rechterNachfolger;

    /**
     * Das Darstellungssymbol des Knotens und der Kanten
     */
    private KnotenSymbol knotenSymbol;

    private KantenSymbol kantenSymbol;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten
     * Nachfolger, d.h. es werden zwei Abschluss-Objekte erzeugt und den
     * entsprechenden Referenzattributen zugewiesen.
     *
     * @param datenNeu Referenz auf ein Objekt der KLasse User, das vom Knoten
     *     verwaltet wird.
     */
    Knoten(User datenNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();

        knotenSymbol = new KnotenSymbol(100, 100, 25, "cyan",
                daten.SchlüsselAlsStringGeben());
        knotenSymbol.SichtbarkeitSetzen(true);
        kantenSymbol = null;
    }

    /**
     * Konstruktor für Objekte der Klasse Knoten mit Nachfolgern.
     *
     * @param datenNeu Referenz auf ein Objekt der Klasse User, das vom Knoten
     *     verwaltet wird.
     * @param linkerNachfolgerNeu der linke Nachfolger des Knotens
     * @param rechterNachfolgerNeu der rechte Nachfolger des Knotens
     */
    Knoten(User datenNeu, Baumelement linkerNachfolgerNeu,
            Baumelement rechterNachfolgerNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = linkerNachfolgerNeu;
        rechterNachfolger = rechterNachfolgerNeu;

        knotenSymbol = new KnotenSymbol(100, 100, 25, "cyan",
                daten.SchlüsselAlsStringGeben());
        knotenSymbol.SichtbarkeitSetzen(true);
        kantenSymbol = null;
    }

    /**
     * Fügt ein Datenelement (User), falls sein Schlüssel noch nicht vorhanden
     * ist, in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter
     * Binärbaum bleibt erhalten.
     *
     * @param datenNeu einzufügendes Datenelement (User)
     *
     * @return Referenz auf das eigene Objekt
     */
    @Override
    Baumelement Einfügen(User datenNeu)
    {
        // Falls es den Wert schon gibt, Einfügen abbrechen.
        if (daten.IstGleich(datenNeu))
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage ob im rechten oder linken Teilbaum eingefügt werden muss
        else
        {
            if (daten.IstGrößerAls(datenNeu))
            {
                linkerNachfolger = linkerNachfolger.Einfügen(datenNeu);
            }
            else
            {
                rechterNachfolger = rechterNachfolger.Einfügen(datenNeu);
            }
        }
        return this;
    }

    /**
     * Sucht ein Datenelement (User), das über seinen Schlüssel identifiziert
     * wird und gibt dieses aus.
     *
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette
     *
     * @return gesuchtes Datenelement (User) bzw. null, falls die Suche
     *     erfolglos ist
     */
    @Override
    User Suchen(String suchSchlüssel)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return daten;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                return linkerNachfolger.Suchen(suchSchlüssel); // Rückgabewert
                                                               // wird nach
                                                               // unten
                                                               // abgefragt und
                                                               // dann nach oben
                                                               // durchgereicht
            }
            else
            {
                return rechterNachfolger.Suchen(suchSchlüssel); // Rückgabewert
                                                                // wird nach
                                                                // unten
                                                                // abgefragt und
                                                                // dann nach
                                                                // oben
                                                                // durchgereicht
            }
        }
    }

    /**
     * Überprüft, ob ein Datenelement (User) mit dem eingegebenen Schlüssel (in
     * Form einer Zeichenkette) vorhanden ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return true, im Erfolgsfall, false sonst.
     */
    @Override
    boolean IstVorhanden(String suchSchlüssel)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return true;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                return linkerNachfolger.IstVorhanden(suchSchlüssel); // Rückgabewert
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
                return rechterNachfolger.IstVorhanden(suchSchlüssel); // Rückgabewert
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
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     *
     * @param aktTiefe Tiefe des aktuellen Knotens
     *
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    @Override
    int HöheGeben(int aktTiefe)
    {
        // lokale Attriubute
        int maxHöheLinkerTeilbaum;
        int maxHöheRechterTeilbaum;

        maxHöheLinkerTeilbaum = linkerNachfolger.HöheGeben(aktTiefe + 1);
        maxHöheRechterTeilbaum = rechterNachfolger.HöheGeben(aktTiefe + 1);

        if (maxHöheLinkerTeilbaum > maxHöheRechterTeilbaum)
        {
            return maxHöheLinkerTeilbaum;
        }
        else
        {
            return maxHöheRechterTeilbaum;
        }
    }

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel
     * suchSchlüssel gespeichert ist.
     *
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     *
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchlüssel nicht
     *     vorhanden ist.
     */
    @Override
    int TiefeGeben(String suchSchlüssel, int tiefe)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return tiefe;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                return linkerNachfolger.TiefeGeben(suchSchlüssel, tiefe + 1);
            }
            else
            {
                return rechterNachfolger.TiefeGeben(suchSchlüssel, tiefe + 1);
            }
        }
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Inorder auf der Konsole aus.
     */
    @Override
    void InorderAusgeben()
    {
        linkerNachfolger.InorderAusgeben();
        daten.InformationAusgeben();
        rechterNachfolger.InorderAusgeben();
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Preorder auf der Konsole aus.
     */
    @Override
    void PreorderAusgeben()
    {
        daten.InformationAusgeben();
        linkerNachfolger.PreorderAusgeben();
        rechterNachfolger.PreorderAusgeben();
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur durch Einrücken.
     */
    @Override
    void StrukturAusgeben(int tiefe)
    {
        // lokales Attribut s: Zeichenkette, mit 4*Tiefe des Knotens
        // Leerzeichen,
        // die für die Einrückung sorgt
        String s;
        s = "";
        for (int i = 0; i < tiefe; i = i + 1)
        {
            s = s + "    ";
        }

        System.out.println(s + daten.SchlüsselAlsStringGeben());

        linkerNachfolger.StrukturAusgeben((tiefe + 1));
        rechterNachfolger.StrukturAusgeben((tiefe + 1));
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur inklusiv Abschluss-Objekte durch Einrücken. (In der Klasse
     * Knoten ist kein Unterschied zur Methode StrukturAusgeben)
     */
    @Override
    void StrukturAusgeben2(int tiefe)
    {
        // lokales Attribut s: Zeichnkette, mit 4*tife des Knotens Leerzeichen,
        // die für die Einrückung sorgt
        String s;
        s = "";
        for (int i = 0; i < tiefe; i = i + 1)
        {
            s = s + "    ";
        }

        System.out.println(s + daten.SchlüsselAlsStringGeben());

        linkerNachfolger.StrukturAusgeben2((tiefe + 1));
        rechterNachfolger.StrukturAusgeben2((tiefe + 1));
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen
     * Postorder auf der Konsole aus.
     */
    @Override
    void PostorderAusgeben()
    {
        linkerNachfolger.PostorderAusgeben();
        rechterNachfolger.PostorderAusgeben();
        daten.InformationAusgeben();
    }

    /**
     * Methode AnzahlKnotenBerechnen berechnet die Anzahl der enthaltenen
     * Knoten.
     *
     * @return Anzahl der Knoten
     */
    @Override
    int AnzahlKnotenBerechnen()
    {
        return 1 + rechterNachfolger.AnzahlKnotenBerechnen()
                + linkerNachfolger.AnzahlKnotenBerechnen();
    }

    /**
     * Methode AnzahlJugendlicheBerechnen berechnet die Anzahl der Nutzer unter
     * 18 Jahre.
     *
     * @return Anzahl der Knoten
     */
    @Override
    int AnzahlJugendlicheBerechnen()
    {
        if (daten.AlterGeben() < 18)
        {
            return 1 + rechterNachfolger.AnzahlJugendlicheBerechnen()
                    + linkerNachfolger.AnzahlJugendlicheBerechnen();
        }
        else
        {
            return rechterNachfolger.AnzahlJugendlicheBerechnen()
                    + linkerNachfolger.AnzahlJugendlicheBerechnen();
        }
    }

    /**
     * Methode AnzahlJugendlicheBerechnen berechnet die Anzahl der Nutzer, die
     * 18 Jahre oder älter sind.
     *
     * @return Anzahl der Knoten
     */
    @Override
    int AnzahlErwachseneBerechnen()
    {
        if (daten.AlterGeben() >= 18)
        {
            return 1 + rechterNachfolger.AnzahlErwachseneBerechnen()
                    + linkerNachfolger.AnzahlErwachseneBerechnen();
        }
        else
        {
            return rechterNachfolger.AnzahlErwachseneBerechnen()
                    + linkerNachfolger.AnzahlErwachseneBerechnen();
        }
    }

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
    @Override
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

        rechterNachfolger.KnotenZeichnen(xmin + (xmax - xmin) / 2, xmax, y + dy,
                dy, knotenSymbol);
        linkerNachfolger.KnotenZeichnen(xmin, xmin + (xmax - xmin) / 2, y + dy,
                dy, knotenSymbol);
    }
}
