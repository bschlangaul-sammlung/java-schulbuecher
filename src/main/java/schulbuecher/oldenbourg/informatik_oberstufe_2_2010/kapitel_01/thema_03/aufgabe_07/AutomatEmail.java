package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_07;

/**
 * Der Automat prüft E-Mail Adressen entsprechend den Vorgaben im Lehrbuch:
 * Alphabet A = { {-; .; _; @; 1; 2; e; j; l; n; s; t; z}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatEmail
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 bis 11, mit dem
     * Startzustandm Z1, dem Endzuständen Z8, Z9, Z10 und dem Fangzustand Z11
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_E_MAIL: Der Startzustand wird
     * gesetzt.
     */
    public AutomatEmail()
    {
        aktuellerZustand = 1; // Anfangszustand
        // falschesZeichenWurdeEingegeben = false;
    }

    /**
     * Abhängig vom aktuellen Zustand wird eine jeweils darauf spezialisierte
     * Methode beauftragt das Zeichen zu verarbeiten und damit den
     * Zustandsübergang durchzuführen
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void ZeicheneingabeWeiterleiten(char zeichen)
    {
        switch (aktuellerZustand)
        {
        case 1:
            Z1ZeicheneingabeBearbeiten(zeichen);
            break;

        case 2:
            Z2ZeicheneingabeBearbeiten(zeichen);
            break;

        case 3:
            Z3ZeicheneingabeBearbeiten(zeichen);
            break;

        case 4:
            Z4ZeicheneingabeBearbeiten(zeichen);
            break;

        case 5:
            Z5ZeicheneingabeBearbeiten(zeichen);
            break;

        case 6:
            Z6ZeicheneingabeBearbeiten(zeichen);
            break;

        case 7:
            Z7ZeicheneingabeBearbeiten(zeichen);
            break;

        case 8:
            Z8ZeicheneingabeBearbeiten(zeichen);
            break;

        case 9:
            Z9ZeicheneingabeBearbeiten(zeichen);
            break;

        case 10:
            Z10ZeicheneingabeBearbeiten(zeichen);
            break;

        case 11:
            Z11ZeicheneingabeBearbeiten(zeichen);
            break;
        }
    }

    /**
     * Führt den Zustandsübergang von Z1 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z1ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 2;
            break;

        case '_':
            aktuellerZustand = 2;
            break;

        case '.':
            aktuellerZustand = 2;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 2;
            break;

        case '2':
            aktuellerZustand = 2;
            break;

        case 'e':
            aktuellerZustand = 2;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 2;
            break;

        case 'n':
            aktuellerZustand = 2;
            break;

        case 's':
            aktuellerZustand = 2;
            break;

        case 't':
            aktuellerZustand = 2;
            break;

        case 'z':
            aktuellerZustand = 2;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z2 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z2ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 2;
            break;

        case '_':
            aktuellerZustand = 2;
            break;

        case '.':
            aktuellerZustand = 2;
            break;

        case '@':
            aktuellerZustand = 3;
            break;

        case '1':
            aktuellerZustand = 2;
            break;

        case '2':
            aktuellerZustand = 2;
            break;

        case 'e':
            aktuellerZustand = 2;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 2;
            break;

        case 'n':
            aktuellerZustand = 2;
            break;

        case 's':
            aktuellerZustand = 2;
            break;

        case 't':
            aktuellerZustand = 2;
            break;

        case 'z':
            aktuellerZustand = 2;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z3 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z3ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 4;
            break;

        case '2':
            aktuellerZustand = 4;
            break;

        case 'e':
            aktuellerZustand = 4;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 4;
            break;

        case 'n':
            aktuellerZustand = 4;
            break;

        case 's':
            aktuellerZustand = 4;
            break;

        case 't':
            aktuellerZustand = 4;
            break;

        case 'z':
            aktuellerZustand = 4;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z4 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z4ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 4;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 5;
            break;

        case '2':
            aktuellerZustand = 5;
            break;

        case 'e':
            aktuellerZustand = 5;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 5;
            break;

        case 'n':
            aktuellerZustand = 5;
            break;

        case 's':
            aktuellerZustand = 5;
            break;

        case 't':
            aktuellerZustand = 5;
            break;

        case 'z':
            aktuellerZustand = 5;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z5 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z5ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 4;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 6;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 5;
            break;

        case '2':
            aktuellerZustand = 5;
            break;

        case 'e':
            aktuellerZustand = 5;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 5;
            break;

        case 'n':
            aktuellerZustand = 5;
            break;

        case 's':
            aktuellerZustand = 5;
            break;

        case 't':
            aktuellerZustand = 5;
            break;

        case 'z':
            aktuellerZustand = 5;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z6 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z6ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 7;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 7;
            break;

        case 'n':
            aktuellerZustand = 7;
            break;

        case 's':
            aktuellerZustand = 7;
            break;

        case 't':
            aktuellerZustand = 7;
            break;

        case 'z':
            aktuellerZustand = 7;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z7 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z7ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 8;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 8;
            break;

        case 'n':
            aktuellerZustand = 8;
            break;

        case 's':
            aktuellerZustand = 8;
            break;

        case 't':
            aktuellerZustand = 8;
            break;

        case 'z':
            aktuellerZustand = 8;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z8 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z8ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 9;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 9;
            break;

        case 'n':
            aktuellerZustand = 9;
            break;

        case 's':
            aktuellerZustand = 9;
            break;

        case 't':
            aktuellerZustand = 9;
            break;

        case 'z':
            aktuellerZustand = 9;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z9 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z9ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 10;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 10;
            break;

        case 'n':
            aktuellerZustand = 10;
            break;

        case 's':
            aktuellerZustand = 10;
            break;

        case 't':
            aktuellerZustand = 10;
            break;

        case 'z':
            aktuellerZustand = 10;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z10 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z10ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 11;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 11;
            break;

        case 'n':
            aktuellerZustand = 11;
            break;

        case 's':
            aktuellerZustand = 11;
            break;

        case 't':
            aktuellerZustand = 11;
            break;

        case 'z':
            aktuellerZustand = 11;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Führt den Zustandsübergang von Z11 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z11ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '-':
            aktuellerZustand = 11;
            break;

        case '_':
            aktuellerZustand = 11;
            break;

        case '.':
            aktuellerZustand = 11;
            break;

        case '@':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case 'e':
            aktuellerZustand = 11;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 11;
            break;

        case 'n':
            aktuellerZustand = 11;
            break;

        case 's':
            aktuellerZustand = 11;
            break;

        case 't':
            aktuellerZustand = 11;
            break;

        case 'z':
            aktuellerZustand = 11;
            break;

        default:
            System.out.println("Ein unerlaubtes Zeichen wurde eingegeben!");
            aktuellerZustand = 11;
        }
    }

    /**
     * Zerlegt die eingegebene Zeichenkette in einzelne Zeichen und ruft pro
     * Zeichen die Methode ZeicheneingabeWeiterleiten auf.
     *
     * @param zeichenkette die durch den Automaten zu überprüfende Zeichenkette
     *
     * @return true bei Akzeptanz der Eingabe, false bei Ablehnung
     *
     */
    public boolean IstEingabeAkzeptiert(String zeichenkette)
    {
        aktuellerZustand = 1; // zuruecksetzen auf den Anfangszustand
        String zeichenketteRest = zeichenkette; // noch zu verarbeitende
                                                // Restzeichenkette
        for (int zaehler = 1; zaehler <= zeichenkette.length(); zaehler++)
        {
            ZeicheneingabeWeiterleiten(zeichenketteRest.charAt(0));
            zeichenketteRest = zeichenketteRest.substring(1);
        }
        // Die Endzustände sind Z8, Z9 und Z10
        if (aktuellerZustand == 8 || aktuellerZustand == 9
                || aktuellerZustand == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
