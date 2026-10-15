import java.util.regex.Pattern;
/**
 * Umsetzung der Beispiele aus Aufgabe 9 über das Alphabet {a, b, e, f, i, n, r}
 * 
 * @author Peter Brichzin
 * @version 20.5.25
 */
class RegulaereAusdrueckeFuerBeispiele
{
    /** Der übersetzte reguläre Ausdruck */
    private Pattern pattern; 

    /**
     * Konstruktor für Objekte der Klasse RegulaereAusdrueckeFuerBeispiele
     */
    RegulaereAusdrueckeFuerBeispiele()
    {
        //keine Initialisierung, weil diese erst mit dem jeweiligen
        // regulären Ausdruck erfolgen kann
    }

    /**
     * Methode IstEingabeAkzeptiertTeil1 überprüft auf die Länge zwei und das Ende "r".
     *
     * @param wort die zu überprüfende Zeichenkette
     * @return true bei akzeptanz, false sonst
     */
    boolean IstEingabeAkzeptiertTeil1(String wort)
    {
        String regex = "[abefinr]r";
        pattern = Pattern.compile(regex);

        return pattern.matcher(wort).matches();
    }

    /**
     * Methode Teil1Testen testet IstEingabeAkzeptiertTeil1(String wort).
     */
    void Teil1Testen()
    {
        System.out.println("Test regulärer Ausdruck: [abefinr]r");
        String[] testZeichenketten = { 
                "r",         // ungültig
                "br",        // gültig
                "er",        // gültig
                "ff",        // ungültig 
                "elf",       // ungültig (zu lange)
                "ur",        // ungültig (u nicht im Alphabet)
            };

        for (String s : testZeichenketten) 
        {
            System.out.printf("Test: %-8s -> %b\n", s, IstEingabeAkzeptiertTeil1(s));
        }
    }

    /**
     * Methode IstEingabeAkzeptiertTeil2 überprüft auf den Beginn mit "f" und dass nur ein "f" enthalten ist.
     *
     * @param wort die zu überprüfende Zeichenkette
     * @return true bei akzeptanz, false sonst
     */
    boolean IstEingabeAkzeptiertTeil2(String wort)
    {
        String regex = "f[abeinr]*";
        pattern = Pattern.compile(regex);

        return pattern.matcher(wort).matches();
    }

    /**
     * Methode Teil2Testen testet IstEingabeAkzeptiertTeil2(String wort).
     */
    void Teil2Testen()
    {
        System.out.println("Test regulärer Ausdruck: f[abeinr]*");
        String[] testZeichenketten = { 
                "f",          // gültig
                "fee",        // gültig
                "ff",         // ungültig (zweites 'f')
                "elf",       // ungültig (beginnt nicht mit f)
                "feuer",      // ungültig (u nicht im Alphabet)
            };

        for (String s : testZeichenketten) 
        {
            System.out.printf("Test: %-8s -> %b\n", s, IstEingabeAkzeptiertTeil2(s));
        }
    }

    /**
     * Methode IstEingabeAkzeptiertTeil3 überprüft, ob die Zeichenkette "ferien" enthalten ist
     *
     * @param wort die zu überprüfende Zeichenkette
     * @return true bei akzeptanz, false sonst
     */
    boolean IstEingabeAkzeptiertTeil3(String wort)
    {
        String regex = "[abefinr]*ferien[abefinr]*";
        pattern = Pattern.compile(regex);

        return pattern.matcher(wort).matches();
    }

    /**
     * Methode Teil3Testen testet IstEingabeAkzeptiertTeil3(String wort).
     *
     */
    void Teil3Testen()
    {
        System.out.println("Test regulärer Ausdruck: [abefinr]*ferien[abefinr]*");
        String[] testZeichenketten = { 
                "ferien",          // gültig
                "ferienfrei",      // gültig
                "abiferien",       // gültig
                "abiferienfrei",   // gültig
                "elfenfee",        // ungültig 
                "feuerferien",     // ungültig (u nicht im Alphabet)
            };

        for (String s : testZeichenketten) 
        {
            System.out.printf("Test: %-15s -> %b\n", s, IstEingabeAkzeptiertTeil3(s));
        }
    }
}
