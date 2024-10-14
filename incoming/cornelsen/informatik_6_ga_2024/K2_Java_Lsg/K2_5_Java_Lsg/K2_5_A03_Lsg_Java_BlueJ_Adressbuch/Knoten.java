/**
 * Klasse Knoten als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin 
 * @version 23.5.24
 */
class Knoten extends Baumelement
{
    /** Datenelement des Knotens */
    private Adressbucheintrag daten;

    /** Referenz auf den linken Nachfolger */
    private Baumelement linkerNachfolger;
    /** Referenz auf den rechten Nachfolger */
    private Baumelement rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten Nachfolger, d.h. es werden 
     * zwei Abschluss-Objekte erzeugt und den entsprechenden Referenzattributen zugewiesen.
     * @param datenNeu Referenz auf ein Objekt der KLasse User, das vom Knoten verwaltet wird.
     */
    Knoten(Adressbucheintrag datenNeu) 
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();
    }

    /**
     * Fügt ein Datenelement (Adressbucheintrag), falls sein Schlüssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum 
     * bleibt erhalten.
     * @param datenNeu einzufügendes Datenelement (Adressbucheintrag)
     * @return Referenz auf das eigene Objekt
     */
    @Override Baumelement Einfügen(Adressbucheintrag datenNeu) 
    {
        // Falls es den Wert schon gibt, Einfügen abbrechen.
        if(daten.IstGleich(datenNeu)) 
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage ob im rechten oder linken Teilbaum eingefügt werden muss
        else
        {
            if(daten.IstGrößerAls(datenNeu)) 
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
     * Sucht ein Datenelement (Adressbucheintrag), das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette 
     * @return gesuchtes Datenelement  (Adressbucheintrag) bzw. null, falls die Suche erfolglos ist
     */
    @Override Adressbucheintrag Suchen(String suchSchlüssel) 
    {
        if(daten.SchlüsselIstGleich(suchSchlüssel)) 
        {
            return daten;
        }
        else
        {
            if(daten.SchlüsselIstGrößerAls(suchSchlüssel)) 
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
     * Überprüft, ob ein Datenelement (User) mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist. 
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette 
     * @return true, im Erfolgsfall, false sonst.
     */
    @Override boolean IstVorhanden(String suchSchlüssel) 
    {
        if(daten.SchlüsselIstGleich(suchSchlüssel)) 
        {
            return true;
        }
        else
        {
            if(daten.SchlüsselIstGrößerAls(suchSchlüssel))
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

        if(maxHöheLinkerTeilbaum > maxHöheRechterTeilbaum)
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
        if(daten.SchlüsselIstGleich(suchSchlüssel)) 
        {
            return tiefe;
        }
        else
        {
            if(daten.SchlüsselIstGrößerAls(suchSchlüssel))
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
     * Methode AnzahlKnotenBerechnen berechnet die Anzahl der enthaltenen Knoten.
     *
     * @return Anzahl der Knoten
     */
    @Override int AnzahlKnotenBerechnen()
    {
        return 1 + rechterNachfolger.AnzahlKnotenBerechnen() + linkerNachfolger.AnzahlKnotenBerechnen();
    }
}