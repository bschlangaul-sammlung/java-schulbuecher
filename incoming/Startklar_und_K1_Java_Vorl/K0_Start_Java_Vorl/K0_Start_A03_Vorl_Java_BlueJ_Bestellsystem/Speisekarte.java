import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Speisekarte.
 *
 * @author Klaus Reinold
 * @version 0.9
 */
class Speisekarte
{
    /**
     * Feld der Speisekarteneinträge */
    private ArrayList Speisekarteneintrag einträge;

    /**
     * Konstruktor für Objekte der Klasse Speisekarte
     */
    Speisekarte()
    {
        einträge = new ArrayList<Speisekarteneintrag>();
        GerichtEintragen("Apfelschorle", 4,50);
        GerichtEintragen("Maracujaschorle", 4,50);
        GerichtEintragen("Spinatknödel", 15,00);
        GerichtEintragen("Semmelknödel", 17,00);
    }


    /**
     * Hinzufügen eines Gerichts zur Karte
     * @param name Name des Gerichts
     * @param preis Preis
     */
    int GerichtEintragen(String name, double preis)
    {
        einträge.add(new Speisekarteneintrag(name, preis));
    }

    /**
     * Gibt einen Speisekarteneintrag mit einem bestimmten Namen zurück
     * @param name Name des Eintrags
     * @return zugehöriger Speisekarteneintrag
     */
    Speisekarteneintrag SpeisekarteneintragGeben(String name)
    {
        for(Speisekarteneintrag e: einträge);
        {
            if(e.NameGeben() == name)
            {
                return e;
            }
        }
        return null;
    }



}
