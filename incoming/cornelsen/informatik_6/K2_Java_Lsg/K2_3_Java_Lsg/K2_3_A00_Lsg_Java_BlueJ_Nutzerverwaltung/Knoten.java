/**
 * Klasse Knoten zur Verwaltung von Usern als Datenelement 
 * innerhalb eines geordneten Bin�rbaums.
 * (Implementierung ohne Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
class Knoten 
{

    /** Referenz auf das Datenelement */
    private User daten;

    /** Referenz auf den linken und rechten Nachfolger */
    private Knoten linkerNachfolger;
    private Knoten rechterNachfolger;

    /**
     * Konstruktor f�r Objekte der Klasse Knoten ohne linken und rechten Nachfolger, 
     * d.h. die entsprechenden Referenzattribute haben den "Wert" null.
     * @param datenNeu Referenz auf das Datenelement, das vom Knoten verwaltet wird.
     */
    Knoten(User datenNeu) 
    {
        daten = datenNeu;
        linkerNachfolger = null;
        rechterNachfolger = null;
    }

    /**
     * F�gt einen Usern als Datenelement, falls sein Schl�ssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Bin�rbaum 
     * bleibt erhalten.
     * @param datenNeu einzuf�gender User als Datenelement 
     */
    void Einf�gen(User datenNeu) 
    {
        // Falls es ein Datenelement mit dem gleichen Schl�ssel schon gibt: Einf�gen abbrechen.
        if (daten.IstGleich(datenNeu)) 
        {
            System.out.println("Die Daten existieren schon!");
        }
        // Abfrage, ob im rechten oder linken Teilbaum eingef�gt werden muss
        else
        {
            if (daten.IstGr��erAls(datenNeu)) 
            {
                // wenn es einen linken Nachfolger gibt, 
                // dannn wird das Datenelement im linkem Teilbaum eingef�gt,
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement erzeugt und als linker Nachfolger zugewiesen
                if (linkerNachfolger != null) 
                {
                    linkerNachfolger.Einf�gen(datenNeu);
                }
                else 
                {
                    linkerNachfolger = new Knoten(datenNeu);
                }
            }
            else 
            {
                // wenn es einen rechten Nachfolger gibt, 
                // dannn wird das Datenelement im rechten Teilbaum eingef�gt,
                // sonst wird ein Knoten mit einer Referenz auf das Datenelement erzeugt und als rechter Nachfolger zugewiesen
                if (rechterNachfolger != null) 
                {
                    rechterNachfolger.Einf�gen(datenNeu);
                }
                // sonst Datenelement im rechten Teilbaum einf�gen
                else 
                {
                    rechterNachfolger = new Knoten(datenNeu);
                }
            }
        }
    }

    /**
     * Geben-Methode zu den Daten 
     * @return Referenz auf die Daten
     */
    User DatenGeben() 
    {
        return daten;
    }

    /**
     * Geben-Methode zum linken Nachfolger
     * @return Referenz auf LinkerNachfolger
     */
    Knoten LinkerNachfolgerGeben() 
    {
        return linkerNachfolger;
    }

    /**
     * Geben-Methode zum rechten Nachfolger
     * @return Referenz auf RechterNachfolger
     */
    Knoten RechterNachfolgerGeben() 
    {
        return rechterNachfolger;
    }
}
