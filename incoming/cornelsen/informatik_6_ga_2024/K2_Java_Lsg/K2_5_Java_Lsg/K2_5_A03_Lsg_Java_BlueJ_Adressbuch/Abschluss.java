/**
 * Klasse Abschluss als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit dem Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
class Abschluss extends Baumelement
{
    /**
     * Konstruktor für Objekte der Klasse Abschluss
     */
    Abschluss()
    {
        super();
    }

    /**
     * Fügt ein Datenelement in die bestehende Datenstruktur ein, indem es einen neuen Knoten 
     * (mit zwei Abschluss-Objekten als Nachfolger) erzeugt und eine Referenz auf diesen Knoten
     * zurückgibt. Das Abschluss-Objekt, dass diese Methode ausführt, wird dabei aus dem Baum entfernt.
     * @param datenNeu einzufügendes Datenelement 
     * @return Referenz auf den neu erzeugten Knoten
     */
    @Override Baumelement Einfügen(Adressbucheintrag datenNeu)
    {
        return new Knoten(datenNeu);
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette 
     * @return null, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet den Ende eines Astes!).
     */
    @Override Adressbucheintrag Suchen(String suchSchlüssel) 
    {
        return null;
    }

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die übergebene Höhe -1, da hier beim Abschluss das Ende eines Astes erreicht ist und 
     * die Abschlusselemente bei der Höhenberechnung nicht einbezogen werden.
     */
    @Override int HöheGeben(int aktTiefe)
    {
        return aktTiefe - 1;
    }

    /**
     * Überprüft, ob ein Datenelement mit dem eingegebenen Schlüssel (in Form einer
     * Zeichenkette) vorhanden ist. 
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette 
     * @return false, da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet den Ende eines Astes!).
     */
    @Override boolean IstVorhanden(String suchSchlüssel) 
    {
        return false;
    }

    /**
     * Gibt die Tiefe des Knotens an, in dem ein Datenelement mit dem Schlüssel suchSchluessel gespeichert ist.
     * @param suchSchlüssel Schlüssel, nach dem gesucht wird als Zeichenkette
     * @return -1 da die Suche erfolglos ist (Abschluss-Objekt kennzeichnet den Ende eines Astes!).
     */
    @Override int TiefeGeben(String suchSchlüssel, int tiefe)
    {
        return -1;
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Preorder auf der Konsole aus.
     * Hier ist das Ende eines Asts erreicht, es muss nichts mehr ausgegeben werden.
     */
    @Override void PreorderAusgeben()
    {
        //tue nichts
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Inorder aus.     
     * Hier ist das Ende eines Asts erreicht, es muss nichts mehr ausgegeben werden.
     */
    @Override void InorderAusgeben()
    {
        //tue nichts
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur durch Einrücken.
     * Hier ist das Ende eines Asts erreicht, es muss nichts mehr ausgegeben werden.
     */
    @Override void StrukturAusgeben(int tiefe)
    {
        //tue nichts
    }

    /**
     * Gibt den Baum Preorder auf der Konsole aus und visualisiert dabei die 
     * Struktur inklusiv Abschluss-Objekte durch Einrücken.
     */
    @Override void StrukturAusgeben2(int tiefe)
    {   
        // lokales Attribut s: Zeichnkette, mit 4*tiefe des Knotens Leerzeichen, die für die Einrückung sorgt
        String s;
        s = "";
        for(int i = 0; i<tiefe; i = i + 1)
        {
            s = s + "    ";
        }

        System.out.println(s + "a");
    }

    /**
     * Gibt alle in den Datenelementen eines Baums gespeicherten Informationen Postorder auf der Konsole aus.
     */
    @Override void PostorderAusgeben()
    {
        //tue nichts
    }

    /**
     * Methode AnzahlKnotenBerechnen berechnet die Anzahl der enthaltenen Knoten.
     *
     * @return Anzahl der Knoten
     */
    @Override int AnzahlKnotenBerechnen()
    {
        return 0;
    }
}