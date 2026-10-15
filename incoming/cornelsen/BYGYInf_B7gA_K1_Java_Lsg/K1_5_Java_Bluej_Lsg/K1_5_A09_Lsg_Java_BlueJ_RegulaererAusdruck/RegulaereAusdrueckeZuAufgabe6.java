import java.util.regex.Pattern;
/**
 * Umsetzung aus Aufgabe 6: Kundennummer eines Fahrradverleihs
 * 
 * @author Peter Brichzin 
 * @version 20.5.25
 */
class RegulaereAusdrueckeZuAufgabe6
{
    /** Der übersetzte reguläre Ausdruck */
    private Pattern pattern; 
    
    /**
     * Konstruktor für Objekte der Klasse RegulaereAusdrueckZuAufgabe4d
     * Bereitet daszu verwendende Muster vor
     */
    RegulaereAusdrueckeZuAufgabe6()
    {
        String regex = "[FP][1-9][0-9]*";
        pattern = Pattern.compile(regex);
    }

    /**
     * Methode IstEingabeAkzeptiert überprüft auf eine gültige Kundennummer
     *
     * @param wort die zu überprüfende Zeichenkette
     * @return true bei Akzeptanz, false sonst
     */
    boolean IstEingabeAkzeptiert(String wort)
    {
        return pattern.matcher(wort).matches();
    }

    /**
     * Methode RegulaerenAusdruckTesten testet IstEingabeAkzeptiert(String wort).
     *
     */
    void RegulaerenAusdruckTesten()
    {
        System.out.println("Test regulärer Ausdruck: [FP][1-9][0-9]*");
        String[] testZeichenketten = { 
                "F1",         // gültig
                "PF1",        // ungültig
                "GF1",        // ungültig
                "F01",        // ungültig
                "P55",        // gültig 
                "G9",         // ungültig
                "P2020202",   // gültig
            };

        for (String s : testZeichenketten) 
        {
            System.out.printf("Test: %-8s -> %b\n", s, IstEingabeAkzeptiert(s));
        }
    }
}
