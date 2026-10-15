package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_a;

/**
 * Überprüft, ob eine Eingabe das korrekte Format einer ganzen Zahl hat
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class GanzzahlPruefer
{
    /**
     * Der aktuelle Zustand
     */
    private int aktZustand;

    /**
     * Konstruktor für Objekte der Klasse GanzzahlPruefer Setzt den Startzustand
     */
    GanzzahlPruefer()
    {
        aktZustand = 0;
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
        aktZustand = 0; // Damit die Methode mehrfach ausgeführt werden kann,
                        // muss der Startzustand hier gesetzt werden

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        return aktZustand == 2 || aktZustand == 3;
    }

    /**
     * Führt abhängig vom aktuellen Zustand und dem aktuellen Zeichen die
     * Zustandsübergänge durch. Der Fangzustand wird mit -1 codiert.
     *
     * @param zei das zu verarbeitende Zeichen
     */
    private void AktZeichenVerarbeiten(char zei)
    {
        switch (aktZustand)
        {
        case 0:
            switch (zei)
            {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9':
                aktZustand = 2;
                break;

            case '-':
                aktZustand = 1;
                break;

            case '0':
                aktZustand = 3;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        case 1:
            switch (zei)
            {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9':
                aktZustand = 2;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        case 2:
            switch (zei)
            {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                aktZustand = 2;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        case 3:
            aktZustand = -1;
            break;

        case -1:
            aktZustand = -1;
            break;

        default:
            break;
        }
    }

    /**
     * Methode EndlichenAutomatTesten testet IstEingabeAkzeptiert(String wort).
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
