import java.util.ArrayList;
/**
 * Beschreibung der Warteschlange
 * 
 * @author Klaus Reinold
 * @version 0.9
 */
 class Warteschlange
{
    /** Verwaltung der Patienten in der Warteschlange über ein Feld. */
    private ArrayList<Patient> patientenfeld;
    
    /**
     * Konstruktor der Warteschlange
     * erzeugt ein leeres Feld
     */
    Warteschlange()
    {
           patientenfeld = new ArrayList<Patient>();
    }
    
    /**
     * Fügt einen neuen Patienten am Ende der Warteschlange ein.
     * Sucht von vorne den ersten freien Platz und fügt dort den Patienten ein.
     * (in einer ArrayList können auch null-Werte auftreten)
     * Benutzt die ArrayList als indizierte Datenstruktur (obwohl es natürlich einfacher geht!)
     * @param patientNeu neuer Patient
     * 
     */
    void Einfügen(Patient patientNeu)
    {

        for(int i = 0; i< patientenfeld.size(); i = i+1)
        {
            if(patientenfeld.get(i)==null)
            {
                patientenfeld.add(i, patientNeu);
                return;
            }
        }
        patientenfeld.add(patientenfeld.size(), patientNeu);
    }
    
    /**
     * Entfernt den ersten Patient aus der Warteschlange und gibt ihn aus.
     * @return bisheriger erster Patient 
     */
     Patient Entfernen()
    {
        //muss noch passend ergänzt werden!
        return null;
    }
}
