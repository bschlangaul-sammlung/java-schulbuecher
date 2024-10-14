import java.util.ArrayList;

/**
 * Klasse Knoten als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Entwurfsmuster Kompositum)
 *
 * @author (Peter Brichzin)
 * @version (23.5.24)
 */
class KnotenBaum extends Baumelement
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
    KnotenBaum(Woerterbucheintrag datenNeu)
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new AbschlussBaum();
        rechterNachfolger = new AbschlussBaum();
    }

    /**
     * Konstruktor für Objekte der Klasse Knoten mit Nachfolgern.
     * @param datenNeu Referenz auf ein Objekt der Klasse Woerterbucheintrag, das vom Knoten verwaltet wird.
     * @param linkerNachfolgerNeu der linke Nachfolger des Knotens
     * @param rechterNachfolgerNeu der rechte Nachfolger des Knotens
     */
    KnotenBaum(Woerterbucheintrag datenNeu, Baumelement linkerNachfolgerNeu, Baumelement rechterNachfolgerNeu)
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
        int maxHöheLinkererTeilbaum;
        int maxHöheRechterTeilbaum;

        maxHöheLinkererTeilbaum = linkerNachfolger.HöheGeben(aktTiefe + 1);
        maxHöheRechterTeilbaum = rechterNachfolger.HöheGeben(aktTiefe + 1);

        if (maxHöheLinkererTeilbaum > maxHöheRechterTeilbaum)
        {
            return maxHöheLinkererTeilbaum;
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
}
