/**
 * Klasse Knoten als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Entwurfsmuster Kompositum)
 *
 * @author (Peter Brichzin)
 * @version (23.5.24)
 */
class Knoten extends Baumelement
{

    /**
     * Datenelement des Knotens */
    private Woerterbucheintrag daten;
    /**
     * Referenz auf den linken Nachfolger */
    private Baumelement linkerNachfolger;
    /**
     * Referenz auf den rechten Nachfolger */
    private Baumelement rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten Nachfolger, d.h. es werden
     * zwei Abschluss-Objekte erzeugt und den entsprechenden Referenzattributen zugewiesen.
     * @param datenNeu Referenz auf ein Objekt der KLasse Woerterbucheintrag, das vom Knoten verwaltet wird.
     */
    Knoten(Woerterbucheintrag datenNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();
    }

    /**
    /**
     * Konstruktor für Objekte der Klasse Knoten mit linken und rechten Nachfolger
     * @param datenNeu Referenz auf ein Objekt der KLasse Woerterbucheintrag, das vom Knoten verwaltet wird.
     * @param linkerNachfolgerNeu linker Nachfolger
     * @param rechterNachfolgerNeu rechter Nachfolger
     */
    Knoten(Woerterbucheintrag datenNeu, Baumelement linkerNachfolgerNeu, Baumelement rechterNachfolgerNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = linkerNachfolgerNeu;
        rechterNachfolger = rechterNachfolgerNeu;
    }

    /**
     * Fügt ein Datenelement (Woerterbucheintrag), falls sein Schlüssel noch nicht vorhanden ist,
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum
     * bleibt erhalten.
     * @param datenNeu einzufügendes Datenelement (Woerterbucheintrag)
     * @return Referenz auf das eigene Objekt
     */
    @Override Baumelement Einfügen(Woerterbucheintrag datenNeu)
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
     * Sucht ein Datenelement (Woerterbucheintrag), das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette
     * @return gesuchtes Datenelement  (Woerterbucheintrag) bzw. null, falls die Suche erfolglos ist
     */
    @Override Woerterbucheintrag Suchen(String suchSchlüssel)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return daten;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                return linkerNachfolger.Suchen(suchSchlüssel); // Rückgabewert wird nach unten abgefragt und dann nach oben durchgereicht
            }
            else
            {
                return rechterNachfolger.Suchen(suchSchlüssel); // Rückgabewert wird nach unten abgefragt und dann nach oben durchgereicht
            }
        }
    }

    /**
     * Überprüft, ob ein Datenelement (Woerterbucheintrag) mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     * @return true, im Erfolgsfall, false sonst.
     */
    @Override boolean IstVorhanden(String suchSchlüssel)
    {
        if (daten.SchlüsselIstGleich(suchSchlüssel))
        {
            return true;
        }
        else
        {
            if (daten.SchlüsselIstGrößerAls(suchSchlüssel))
            {
                return linkerNachfolger.IstVorhanden(suchSchlüssel); // Rückgabewert wird nach unten abgefragt und dann nach oben durchgereicht
            }
            else
            {
                return rechterNachfolger.IstVorhanden(suchSchlüssel); // Rückgabewert wird nach unten abgefragt und dann nach oben durchgereicht
            }
        }
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    @Override int HöheGeben(int aktTiefe)
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
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel suchSchlüssel gespeichert ist.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     * @return Tiefe als positive Zahl, bzw. -1 falls der suchSchlüssel nicht vorhanden ist.
     */
    @Override int TiefeGeben(String suchSchlüssel, int tiefe)
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
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Inorder auf der Konsole aus.
     */
    @Override void InorderAusgeben()
    {
        linkerNachfolger.InorderAusgeben();
        daten.InformationAusgeben();
        rechterNachfolger.InorderAusgeben();
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Preorder auf der Konsole aus.
     */
    @Override void PreorderAusgeben()
    {
        daten.InformationAusgeben();
        linkerNachfolger.PreorderAusgeben();
        rechterNachfolger.PreorderAusgeben();
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur durch Einrücken.
     */
    @Override void StrukturAusgeben(int tiefe)
    {
        // lokales Attribut s: Zeichenkette, mit 4*Tiefe des Knotens Leerzeichen,
        // die für die Einrückung sorgt
        String s;
        s = "";
        for(int i = 0; i<tiefe; i = i + 1)
        {
            s = s + "    ";
        }

        System.out.println(s + daten.SchlüsselAlsStringGeben());

        linkerNachfolger.StrukturAusgeben( (tiefe + 1) );
        rechterNachfolger.StrukturAusgeben( (tiefe + 1) );
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die
     * Struktur inklusiv Abschluss-Objekte durch Einrücken.
     * (In der Klasse Knoten ist kein Unterschied zur Methode StrukturAusgeben)
     */
    @Override void StrukturAusgeben2(int tiefe)
    {
        // lokales Attribut s: Zeichnkette, mit 4*tife des Knotens Leerzeichen, die für die Einrückung sorgt
        String s;
        s = "";
        for(int i = 0; i<tiefe; i = i + 1)
        {
            s = s + "    ";
        }

        System.out.println(s + daten.SchlüsselAlsStringGeben());

        linkerNachfolger.StrukturAusgeben2( (tiefe + 1) );
        rechterNachfolger.StrukturAusgeben2( (tiefe + 1) );
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Postorder auf der Konsole aus.
     */
    @Override void PostorderAusgeben()
    {
        linkerNachfolger.PostorderAusgeben();
        rechterNachfolger.PostorderAusgeben();
        daten.InformationAusgeben();
    }

    /**
     * Fügt ein Baumelement "rechts unten" in dem Teilbaum ein, dessen Wurzel das aufgerufene Objekt ist
     * Das eingefügte Baumelement kann selbst auch Nachfolger haben. In diesem Fall kann mit der Methode
     * RechtsEinfuegen verschiedene Bäume zusammengefügt werden. Es ist wichtig, an der richtigen Stelle einzufügen,
     * damit die Ordnung des Binärbaums nicht zerstört wird!
     * @param element einzufügendes Baumelement
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    @Override Baumelement RechtsEinfügen(Baumelement element)
    {
        rechterNachfolger = rechterNachfolger.RechtsEinfügen(element);
        return this;
    }

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel hat.
     * @param vergleichsSchlüssel Schlüssel, identifiziert das zu entfernende Datenelement und damit auch den zu entfernenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    @Override Baumelement Entfernen(String suchSchlüssel)
    {
        // Datenelement mit suchSchlüssel ist vorhanden - Rekursionsende:zugehöriger Knoten muss entfernt werden
        if(daten.SchlüsselIstGleich(suchSchlüssel))
        {
            // Fall 1: Der zu entfernende Knoten ist ein Blatt
            if(linkerNachfolger instanceof Abschluss && rechterNachfolger instanceof Abschluss)
            {
                return linkerNachfolger; // Knoten wird einfach entfernt-> Rückgabe eines Abschlusses
            }
            else // Fall 2: Der zu entfernende Knoten hat genau einen Nachfolger
            if(linkerNachfolger instanceof Abschluss)
            {
                return rechterNachfolger;   // Knoten wird entfernt und durch seinen
                // rechten Nachfolger ersetzt
            }
            else
            if(rechterNachfolger instanceof Abschluss)
            {
                return linkerNachfolger;  // Knoten wird entfernt und durch seinen
                // linken Nachfolger ersetzt
            }
            else // Fall 3: Der zu entfernende Knoten hat genau zwei Nachfolger
            {
                // Suche das Minimum im rechten Teilbaum und ersetze damit die eigenen Daten
                DatenSetzen(rechterNachfolger.MinimumGeben(daten));
                // Entferne das Minimum im rechten Teilbaum und hänge den veränderten
                // rechten Teilbaum als neuen rechten Teilbaum ein.
                rechterNachfolger = rechterNachfolger.Entfernen(daten.SchlüsselAlsStringGeben());
                return this;
            }
        }
        else
        // Eigener Schlüssel ist kleiner -> rekursiver Aufruf im rechten Teilbaum
        if (daten.SchlüsselIstKleinerAls(suchSchlüssel) )
        {
            rechterNachfolger = rechterNachfolger.Entfernen2(suchSchlüssel);
            return this;
        }
        // Eigener Schlüssel ist größer -> rekursiver Aufruf im linken Teilbaum
        else
        {
            linkerNachfolger = linkerNachfolger.Entfernen2(suchSchlüssel);
            return this;
        }
    }

    /**
     * Entfernt einen Knoten, dessen Datenelement den eingegebenen Schlüssel hat.
     * @param vergleichsSchlüssel Schlüssel, identifiziert das zu entfernende Datenelement und damit auch den zu entfernenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    @Override Baumelement Entfernen2(String suchSchlüssel)
    {
        if(daten.SchlüsselIstGleich(suchSchlüssel))
        {
            linkerNachfolger = linkerNachfolger.RechtsEinfügen(rechterNachfolger);
            return linkerNachfolger;      // linker Teilbaum wird zurückgegeben und entfernt dadurch den zu entfernenden Knoten
        }
        else
        // Eigener Schlüssel ist kleiner -> rekursiver Aufruf im rechten Teilbaum
        if (daten.SchlüsselIstKleinerAls(suchSchlüssel) )
        {
            rechterNachfolger = rechterNachfolger.Entfernen2(suchSchlüssel);
            return this;
        }
        // letzer Fall: Eigener Schlüssel ist größer -> rekursiver Aufruf im linken Teilbaum
        else
        {
            linkerNachfolger = linkerNachfolger.Entfernen2(suchSchlüssel);
            return this;
        }
    }

    /**
     * SetzenMethode für das Datenelement
     * @param datenNeu neue Daten
     */
    void DatenSetzen(Woerterbucheintrag datenNeu)
    {
        daten = datenNeu;
    }

    /**
     * GebenMethode für das Datenelement
     * @return daten
     */
    Woerterbucheintrag DatenGeben()
    {
        return daten;
    }

    /**
     * Sucht bzgl.der Ordnungsrelation das Datenelement mit dem kleinsten Schlüssel
     * und gibt dieses zurück
     * @param aktuellesMinimum - die eigenen Daten (dient zur Übergabe an das Abschluss-Objekt)
     * @return Datenelement mit minimalem Schlüsselwert
     */
    @Override Woerterbucheintrag MinimumGeben(Woerterbucheintrag aktuellesMinimum)
    {
        return linkerNachfolger.MinimumGeben(daten);
    }
}
