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
    private User daten;
    /** Referenz auf den linken Nachfolger */
    private Baumelement linkerNachfolger;
    /** Referenz auf den rechten Nachfolger */
    private Baumelement rechterNachfolger;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten Nachfolger, d.h. es werden 
     * zwei Abschluss-Objekte erzeugt und den entsprechenden Referenzattributen zugewiesen.
     * @param datenNeu Referenz auf ein Objekt der KLasse User, das vom Knoten verwaltet wird.
     */
    Knoten(User datenNeu) 
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();
    }

    /**
     * Fügt ein Datenelement (User), falls sein Schlüssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum 
     * bleibt erhalten.
     * @param datenNeu einzufügendes Datenelement (User)
     * @return Referenz auf das eigene Objekt
     */
    @Override Baumelement Einfügen(User datenNeu) 
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
     * Sucht ein Datenelement (User), das über seinen Schlüssel identifiziert wird
     * und gibt dieses aus.
     * @param suchSchlüssel Schlüssel nach dem gesucht wird als Zeichenkette 
     * @return gesuchtes Datenelement (User) bzw. null, falls die Suche erfolglos ist
     */
    @Override User Suchen(int suchSchlüssel) 
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
}