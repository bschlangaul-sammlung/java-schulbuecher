package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Überprüft, ob eine Eingabe das korrekte Format einer ganzen Zahl hat
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class AutomatischerGanzzahlPruefer
{
    /**
     * Referenz auf den aktuellen Zustand
     **/
    private Zustand aktZustand;

    /**
     * Konstruktor für Objekte der Klasse AutomatischerGanzzahlPruefer Legt den
     * Startzustand fest
     */
    AutomatischerGanzzahlPruefer()
    {
        aktZustand = Z0.ObjektGeben();
    }

    /**
     * Überprüft, ob die Eingabe aktzeptiert wird.
     *
     * @param zeichenkette zu überprüfende Eingabe
     *
     * @return true, wenn die Eingabe das Format einer ganzen Zahl hat
     */
    boolean IstEingabeAkzeptiert(String zeichenkette)
    {
        aktZustand = Z0.ObjektGeben(); // Damit die Methode mehrfach ausgeführt
                                       // werden kann, muss der Startzustand
                                       // hier gesetzt werden

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            aktZustand = aktZustand
                .AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        return aktZustand.IstEndzustandGeben();
    }

    /**
     * Methode EndlichenAutomatTesten testet IstEingabeAkzeptiert(String wort).
     *
     */
    void EndlichenAutomatTesten()
    {
        System.out.println("Test:");
        String[] testZeichenketten = { "0", // gültig
                "1", // gültig
                "-1", // gültig
                "12345678", // gültig
                "-4242", // gültig
                "-0", // ungültig
                "3-1", // ungültig
                "--", // ungültig
                "05", // ungültig
                "00", // ungültig
                "0-9", // ungültig
        };

        for (String s : testZeichenketten)
        {
            System.out.printf("Test: %-8s -> %b\n", s, IstEingabeAkzeptiert(s));
        }
    }
}
