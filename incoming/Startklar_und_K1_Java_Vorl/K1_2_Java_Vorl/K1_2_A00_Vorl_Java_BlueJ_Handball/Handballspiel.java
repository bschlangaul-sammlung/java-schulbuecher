import java.util.ArrayList;
/**
 * Klasse zur Beschreibung eines Handballspiels
 * 
 * @author Klaus Reinold
 * @version 0.4
 */
class Handballspiel
{
    /** Termin des Spiels */
    private String termin;
    /** Liga */
    private String liga;
    /** Spielort */
    private String spielort;
    /** Mannschaft 1 */
    private String mannschaft1;
    /** Mannschaft 2 */
    private String mannschaft2;
    /** Schiedsrichter1 */
    private String schiedsrichter1;
    /** Schiedsrichter2 */
    private String schiedsrichter2;
    /** Zeitnehmer */
    private String zeitnehmer;
    /** Sekretär */
    private String sekretär;
    /** Offizielle der Mannschaft 1 (Trainer usw.) */
    private ArrayList<String> offizielleMannschaft1;
    /** Offizielle der Mannschaft 2 (Trainer usw.) */
    private ArrayList<String> offizielleMannschaft2;
    /** Spieler der Mannschaft 1 */
    private ArrayList<String> spielerMannschaft1;
    /** Spieler der Mannschaft 2 */
    private ArrayList<String> spielerMannschaft2;
    /** Feld der Minuten, in denen ein Tor für Mannschaft 1 geschossen wurde */
    private ArrayList<Integer> torMinuteMannschaft1;
    /** Feld der Spieler, die ein Tor für Mannschaft 1 geschossen haben */
    private ArrayList<String> torSpielerMannschaft1;
    /** Feld der Minuten, in denen ein Tor für Mannschaft 2 geschossen wurde */
    private ArrayList<Integer> torMinuteMannschaft2;
    /** Feld der Spieler, die ein Tor für Mannschaft 1 geschossen haben */
    private ArrayList<String> torSpielerMannschaft2;
    /** Feld der Minuten der Siebenmeter, die für Mannschaft 1 geschossen wurden */
    private ArrayList<Integer> siebenmeterMinuteMannschaft1;
    /** Feld der Spieler, die für Mannschaft 1 einen Siebenmeter geschossen haben */
    private ArrayList<String> siebenmeterSpielerMannschaft1;
    /** Feld speichert, ob Siebenmeter für Mannschaft 1 ein Treffer war */
    private ArrayList<Boolean> istSiebenmeterTrefferMannschaft1;
    /** Feld der Minuten der Siebenmeter, die für Mannschaft 2 geschossen wurden */
    private ArrayList<Integer> siebenmeterMinuteMannschaft2;
    /** Feld der Spieler, die für Mannschaft 2 einen Siebenmeter geschossen haben */
    private ArrayList<String> siebenmeterSpielerMannschaft2;
    /** Feld speichert, ob Siebenmeter für Mannschaft 2 ein Treffer war */
    private ArrayList<Boolean> istSiebenmeterTrefferMannschaft2;
    /** Zweiminutenstrafe x in Minute y für Mannschaft1 */
    private ArrayList<Integer> zweiMinStrafeMinuteMannschaft1;
    /** Zweiminutenstrafe x für Spieler y für Mannschaft1 */
    private ArrayList<String> zweiMinStrafeSpielerMannschaft1;
    /** Zweiminutenstrafe x in Minute y für Mannschaft2 */
    private ArrayList<Integer> zweiMinStrafeMinuteMannschaft2;
    /** Zweiminutenstrafe x für Spieler y für Mannschaft2 */
    private ArrayList<String> zweiMinStrafeSpielerMannschaft2;
    /** Auszeit1 von Mannschaft1 */
    private int timeout1Mannschaft1;
    /** Auszeit2 von Mannschaft1 */
    private int timeout2Mannschaft1;
    /** Auszeit1 von Mannschaft2 */
    private int timeout1Mannschaft2;
    /** Auszeit2 von Mannschaft2 */
    private int timeout2Mannschaft2;

    /**
     * Konstruktor für Objekte der Klasse Handballspiel
     * @param terminNeu Spieltermin
     * @param ligaNeu Liga des Spiels
     * @param spielortNeu Ort des Spiels
     * @param mannschaft1Neu erste Mannschaft
     * @param mannschaft2Neu zweite Mannschaft
     */
    Handballspiel(String terminNeu, String ligaNeu, String spielortNeu, String mannschaft1Neu, String mannschaft2Neu)
    {
        termin = terminNeu;
        liga = ligaNeu;
        spielort = spielortNeu;
        mannschaft1 = mannschaft1Neu;
        mannschaft2 = mannschaft2Neu;
        offizielleMannschaft1 = new ArrayList<String>();
        offizielleMannschaft2 = new ArrayList<String>();
        spielerMannschaft1 = new ArrayList<String>();
        spielerMannschaft2 = new ArrayList<String>();
        torMinuteMannschaft1 = new ArrayList<Integer>();
        torSpielerMannschaft1 = new ArrayList<String>();
        torMinuteMannschaft2 = new ArrayList<Integer>();
        torSpielerMannschaft2 = new ArrayList<String>();
        siebenmeterMinuteMannschaft1 = new ArrayList<Integer>();
        siebenmeterSpielerMannschaft1 = new ArrayList<String>();
        istSiebenmeterTrefferMannschaft1 = new ArrayList<Boolean>();
        siebenmeterMinuteMannschaft2 = new ArrayList<Integer>();
        siebenmeterSpielerMannschaft2 = new ArrayList<String>();
        istSiebenmeterTrefferMannschaft2 = new ArrayList<Boolean>();
        zweiMinStrafeMinuteMannschaft1 = new ArrayList<Integer>();
        zweiMinStrafeSpielerMannschaft1 = new ArrayList<String>();
        zweiMinStrafeMinuteMannschaft2 = new ArrayList<Integer>();
        zweiMinStrafeSpielerMannschaft2 = new ArrayList<String>();
    }

    /**
     * Festlegen eines der vier Schiedsrichter
     * @param name Name des Schiedsrichters
     * @param art mögliche Arten: Schiedsrichter 1, Schiedsrichter 2, Zeitnehmer, Sekretär
     */
    void SchiedsrichterFestlegen(String nameNeu, String artNeu)
    {
        switch (artNeu)
        {
            case "Schiedsrichter 1":
                schiedsrichter1 = nameNeu;
                break;
            case "Schiedsrichter 2":
                schiedsrichter2 = nameNeu;
                break;
            case "Zeitnehmer":
                zeitnehmer = nameNeu;
                break;
            case "Sekretär":
                sekretär = nameNeu;
                break;
            default: System.out.println("Ungültige Angabe bei Art des Schiedsrichters. Zulässig: Schiedsrichter 1, Schiedsrichter 2, Zeitnehmer, Sekretär");
        }
    }

    /**
     * Festlegen eines Offiziellen (Trainer etc.) für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param offiziellerNeu Name des Offiziellen
     */
    void OffiziellenFestlegenFürMannschaft(String mannschaftNeu, String offiziellerNeu)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            offizielleMannschaft1.add(offiziellerNeu);
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                offizielleMannschaft2.add(offiziellerNeu);
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }

    /**
     * Festlegen eines Spielers für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param spielerNeu Name des Spielers
     */
    void SpielerFestlegenFürMannschaft(String mannschaftNeu, String spielerNeu)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            spielerMannschaft1.add(spielerNeu);
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                spielerMannschaft2.add(spielerNeu);
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }

    /**
     * Festlegen eines Tores für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param spielerNeu Name des Spielers
     * @param minuteNeu Minute des Tores
     */
    void TorFestlegenFürMannschaft(String mannschaftNeu, String spielerNeu, int minuteNeu)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            torSpielerMannschaft1.add(spielerNeu);
            torMinuteMannschaft1.add(new Integer(minuteNeu));
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                torSpielerMannschaft2.add(spielerNeu);
                torMinuteMannschaft2.add(new Integer(minuteNeu));
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }

    /**
     * Festlegen eines Siebenmeters für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param spielerNeu Name des Spielers
     * @param minuteNeu Minute des Tores
     */
    void SiebenmeterFestlegenFürMannschaft(String mannschaftNeu, String spielerNeu, int minuteNeu, boolean istTreffer)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            siebenmeterSpielerMannschaft1.add(spielerNeu);
            siebenmeterMinuteMannschaft1.add(new Integer(minuteNeu));
            istSiebenmeterTrefferMannschaft1.add(new Boolean(istTreffer));
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                siebenmeterSpielerMannschaft1.add(spielerNeu);
                siebenmeterMinuteMannschaft1.add(new Integer(minuteNeu));
                istSiebenmeterTrefferMannschaft1.add(new Boolean(istTreffer));
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }

    /**
     * Festlegen einer Zweiminutenstrafe für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param spielerNeu Name des Spielers
     * @param minuteNeu Minute der Strafe
     */
    void ZweiminutenstrafeFestlegenFürMannschaft(String mannschaftNeu, String spielerNeu, int minuteNeu)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            zweiMinStrafeSpielerMannschaft1.add(spielerNeu);
            zweiMinStrafeMinuteMannschaft1.add(new Integer(minuteNeu));
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                zweiMinStrafeSpielerMannschaft2.add(spielerNeu);
                zweiMinStrafeMinuteMannschaft2.add(new Integer(minuteNeu));
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }

    /**
     * Festlegen eines Timeouts für eine Mannschaft
     * @param mannschaftNeu Name der Mannschaft
     * @param halbzeitNeu aktuelle Halbzeit
     * @param minuteNeu Minute des Timeouts
     */
    void TimeoutSetzen(String mannschaftNeu, int halbzeitNeu, int minuteNeu)
    {
        if (mannschaft1 == mannschaftNeu)
        {
            if(halbzeitNeu == 1)
            {
                timeout1Mannschaft1 = minuteNeu;
            }
            else
            {
                timeout2Mannschaft1 = minuteNeu;
            }
        }
        else
        {
            if (mannschaft2 == mannschaftNeu)
            {
                if(halbzeitNeu == 1)
                {
                    timeout1Mannschaft2 = minuteNeu;
                }
                else
                {
                    timeout2Mannschaft2 = minuteNeu;
                }
            }
            else
            {
                System.out.println("Mannschaft nicht erkannt");
            }
        }
    }
}
