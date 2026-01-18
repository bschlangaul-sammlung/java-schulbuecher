package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_10;

/**
 *
 * Der Automat prüft Kfz_Kennzeichen nach folgenden Vorgaben:
 * <p>
 * Ein bis drei Buchstaben kennzeichnen den Verwaltungsbezirk, in dem das
 * Fahrzeug angemeldet ist, beispielsweise M für die Stadt München oder BAR für
 * den Landkreis Barnim. Dieser Teil wird Unterscheidungszeichen genannt. Ein
 * bis zwei Buchstaben und eine ein- bis vierstellige Zahl (führende Nullen sind
 * nicht erlaubt!) ermöglichen eine Identifikation des Fahrzeugbesitzers
 * innerhalb des Verwaltungsbezirks. Dieser Bestandteil des Kennzeichens wird
 * Erkennungsnummer genannt (obwohl auch Buchstaben dazugehören).
 * Unterscheidungszeichen und Erkennungsnummer sind durch einen Bindestrich
 * getrennt.
 * <p>
 * Alphabet A = { -, A; B; ...; Z; 0; 1; ..., 9}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatKfzkennzeichen
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 (Startzustand), 2, 3,
     * 4, 5, 6, 7, 8, 9, 10, 11,(Endzustände) 12 (Fangzustand).
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_KFZKENNZEICHEN: Der
     * Startzustand wird gesetzt.
     */
    public AutomatKfzkennzeichen()
    {
        aktuellerZustand = 1; // Anfangszustand
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

        case 12:
            Z12ZeicheneingabeBearbeiten(zeichen);
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
        case 'A':
            aktuellerZustand = 2;
            break;

        case 'B':
            aktuellerZustand = 2;
            break;

        case 'C':
            aktuellerZustand = 2;
            break;

        case 'D':
            aktuellerZustand = 2;
            break;

        case 'E':
            aktuellerZustand = 2;
            break;

        case 'F':
            aktuellerZustand = 2;
            break;

        case 'G':
            aktuellerZustand = 2;
            break;

        case 'H':
            aktuellerZustand = 2;
            break;

        case 'I':
            aktuellerZustand = 2;
            break;

        case 'J':
            aktuellerZustand = 2;
            break;

        case 'K':
            aktuellerZustand = 2;
            break;

        case 'L':
            aktuellerZustand = 2;
            break;

        case 'M':
            aktuellerZustand = 2;
            break;

        case 'N':
            aktuellerZustand = 2;
            break;

        case 'O':
            aktuellerZustand = 2;
            break;

        case 'P':
            aktuellerZustand = 2;
            break;

        case 'Q':
            aktuellerZustand = 2;
            break;

        case 'R':
            aktuellerZustand = 2;
            break;

        case 'S':
            aktuellerZustand = 2;
            break;

        case 'T':
            aktuellerZustand = 2;
            break;

        case 'U':
            aktuellerZustand = 2;
            break;

        case 'V':
            aktuellerZustand = 2;
            break;

        case 'W':
            aktuellerZustand = 2;
            break;

        case 'X':
            aktuellerZustand = 2;
            break;

        case 'Y':
            aktuellerZustand = 2;
            break;

        case 'Z':
            aktuellerZustand = 2;
            break;

        default:
            aktuellerZustand = 12;
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
            aktuellerZustand = 5;
            break;

        case 'A':
            aktuellerZustand = 3;
            break;

        case 'B':
            aktuellerZustand = 3;
            break;

        case 'C':
            aktuellerZustand = 3;
            break;

        case 'D':
            aktuellerZustand = 3;
            break;

        case 'E':
            aktuellerZustand = 3;
            break;

        case 'F':
            aktuellerZustand = 3;
            break;

        case 'G':
            aktuellerZustand = 3;
            break;

        case 'H':
            aktuellerZustand = 3;
            break;

        case 'I':
            aktuellerZustand = 3;
            break;

        case 'J':
            aktuellerZustand = 3;
            break;

        case 'K':
            aktuellerZustand = 3;
            break;

        case 'L':
            aktuellerZustand = 3;
            break;

        case 'M':
            aktuellerZustand = 3;
            break;

        case 'N':
            aktuellerZustand = 3;
            break;

        case 'O':
            aktuellerZustand = 3;
            break;

        case 'P':
            aktuellerZustand = 3;
            break;

        case 'Q':
            aktuellerZustand = 3;
            break;

        case 'R':
            aktuellerZustand = 3;
            break;

        case 'S':
            aktuellerZustand = 3;
            break;

        case 'T':
            aktuellerZustand = 3;
            break;

        case 'U':
            aktuellerZustand = 3;
            break;

        case 'V':
            aktuellerZustand = 3;
            break;

        case 'W':
            aktuellerZustand = 3;
            break;

        case 'X':
            aktuellerZustand = 3;
            break;

        case 'Y':
            aktuellerZustand = 3;
            break;

        case 'Z':
            aktuellerZustand = 3;
            break;

        default:
            aktuellerZustand = 12;
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
            aktuellerZustand = 5;
            break;

        case 'A':
            aktuellerZustand = 4;
            break;

        case 'B':
            aktuellerZustand = 4;
            break;

        case 'C':
            aktuellerZustand = 4;
            break;

        case 'D':
            aktuellerZustand = 4;
            break;

        case 'E':
            aktuellerZustand = 4;
            break;

        case 'F':
            aktuellerZustand = 4;
            break;

        case 'G':
            aktuellerZustand = 4;
            break;

        case 'H':
            aktuellerZustand = 4;
            break;

        case 'I':
            aktuellerZustand = 4;
            break;

        case 'J':
            aktuellerZustand = 4;
            break;

        case 'K':
            aktuellerZustand = 4;
            break;

        case 'L':
            aktuellerZustand = 4;
            break;

        case 'M':
            aktuellerZustand = 4;
            break;

        case 'N':
            aktuellerZustand = 4;
            break;

        case 'O':
            aktuellerZustand = 4;
            break;

        case 'P':
            aktuellerZustand = 4;
            break;

        case 'Q':
            aktuellerZustand = 4;
            break;

        case 'R':
            aktuellerZustand = 4;
            break;

        case 'S':
            aktuellerZustand = 4;
            break;

        case 'T':
            aktuellerZustand = 4;
            break;

        case 'U':
            aktuellerZustand = 4;
            break;

        case 'V':
            aktuellerZustand = 4;
            break;

        case 'W':
            aktuellerZustand = 4;
            break;

        case 'X':
            aktuellerZustand = 4;
            break;

        case 'Y':
            aktuellerZustand = 4;
            break;

        case 'Z':
            aktuellerZustand = 4;
            break;

        default:
            aktuellerZustand = 12;
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
            aktuellerZustand = 5;
            break;

        default:
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
        case 'A':
            aktuellerZustand = 6;
            break;

        case 'B':
            aktuellerZustand = 6;
            break;

        case 'C':
            aktuellerZustand = 6;
            break;

        case 'D':
            aktuellerZustand = 6;
            break;

        case 'E':
            aktuellerZustand = 6;
            break;

        case 'F':
            aktuellerZustand = 6;
            break;

        case 'G':
            aktuellerZustand = 6;
            break;

        case 'H':
            aktuellerZustand = 6;
            break;

        case 'I':
            aktuellerZustand = 6;
            break;

        case 'J':
            aktuellerZustand = 6;
            break;

        case 'K':
            aktuellerZustand = 6;
            break;

        case 'L':
            aktuellerZustand = 6;
            break;

        case 'M':
            aktuellerZustand = 6;
            break;

        case 'N':
            aktuellerZustand = 6;
            break;

        case 'O':
            aktuellerZustand = 6;
            break;

        case 'P':
            aktuellerZustand = 6;
            break;

        case 'Q':
            aktuellerZustand = 6;
            break;

        case 'R':
            aktuellerZustand = 6;
            break;

        case 'S':
            aktuellerZustand = 6;
            break;

        case 'T':
            aktuellerZustand = 6;
            break;

        case 'U':
            aktuellerZustand = 6;
            break;

        case 'V':
            aktuellerZustand = 6;
            break;

        case 'W':
            aktuellerZustand = 6;
            break;

        case 'X':
            aktuellerZustand = 6;
            break;

        case 'Y':
            aktuellerZustand = 6;
            break;

        case 'Z':
            aktuellerZustand = 6;
            break;

        default:
            aktuellerZustand = 12;
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
            aktuellerZustand = 5;
            break;

        case 'A':
            aktuellerZustand = 7;
            break;

        case 'B':
            aktuellerZustand = 7;
            break;

        case 'C':
            aktuellerZustand = 7;
            break;

        case 'D':
            aktuellerZustand = 7;
            break;

        case 'E':
            aktuellerZustand = 7;
            break;

        case 'F':
            aktuellerZustand = 7;
            break;

        case 'G':
            aktuellerZustand = 7;
            break;

        case 'H':
            aktuellerZustand = 7;
            break;

        case 'I':
            aktuellerZustand = 7;
            break;

        case 'J':
            aktuellerZustand = 7;
            break;

        case 'K':
            aktuellerZustand = 7;
            break;

        case 'L':
            aktuellerZustand = 7;
            break;

        case 'M':
            aktuellerZustand = 7;
            break;

        case 'N':
            aktuellerZustand = 7;
            break;

        case 'O':
            aktuellerZustand = 7;
            break;

        case 'P':
            aktuellerZustand = 7;
            break;

        case 'Q':
            aktuellerZustand = 7;
            break;

        case 'R':
            aktuellerZustand = 7;
            break;

        case 'S':
            aktuellerZustand = 7;
            break;

        case 'T':
            aktuellerZustand = 7;
            break;

        case 'U':
            aktuellerZustand = 7;
            break;

        case 'V':
            aktuellerZustand = 7;
            break;

        case 'W':
            aktuellerZustand = 7;
            break;

        case 'X':
            aktuellerZustand = 7;
            break;

        case 'Y':
            aktuellerZustand = 7;
            break;

        case 'Z':
            aktuellerZustand = 7;
            break;

        case '1':
            aktuellerZustand = 8;
            break;

        case '2':
            aktuellerZustand = 8;
            break;

        case '3':
            aktuellerZustand = 8;
            break;

        case '4':
            aktuellerZustand = 8;
            break;

        case '5':
            aktuellerZustand = 8;
            break;

        case '6':
            aktuellerZustand = 8;
            break;

        case '7':
            aktuellerZustand = 8;
            break;

        case '8':
            aktuellerZustand = 8;
            break;

        case '9':
            aktuellerZustand = 8;
            break;

        default:
            aktuellerZustand = 12;
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
        case '1':
            aktuellerZustand = 8;
            break;

        case '2':
            aktuellerZustand = 8;
            break;

        case '3':
            aktuellerZustand = 8;
            break;

        case '4':
            aktuellerZustand = 8;
            break;

        case '5':
            aktuellerZustand = 8;
            break;

        case '6':
            aktuellerZustand = 8;
            break;

        case '7':
            aktuellerZustand = 8;
            break;

        case '8':
            aktuellerZustand = 8;
            break;

        case '9':
            aktuellerZustand = 8;
            break;

        default:
            aktuellerZustand = 12;
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
        case '0':
            aktuellerZustand = 9;
            break;

        case '1':
            aktuellerZustand = 9;
            break;

        case '2':
            aktuellerZustand = 9;
            break;

        case '3':
            aktuellerZustand = 9;
            break;

        case '4':
            aktuellerZustand = 9;
            break;

        case '5':
            aktuellerZustand = 9;
            break;

        case '6':
            aktuellerZustand = 9;
            break;

        case '7':
            aktuellerZustand = 9;
            break;

        case '8':
            aktuellerZustand = 9;
            break;

        case '9':
            aktuellerZustand = 9;
            break;

        default:
            aktuellerZustand = 12;
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
        case '0':
            aktuellerZustand = 10;
            break;

        case '1':
            aktuellerZustand = 10;
            break;

        case '2':
            aktuellerZustand = 10;
            break;

        case '3':
            aktuellerZustand = 10;
            break;

        case '4':
            aktuellerZustand = 10;
            break;

        case '5':
            aktuellerZustand = 10;
            break;

        case '6':
            aktuellerZustand = 10;
            break;

        case '7':
            aktuellerZustand = 10;
            break;

        case '8':
            aktuellerZustand = 10;
            break;

        case '9':
            aktuellerZustand = 10;
            break;

        default:
            aktuellerZustand = 12;
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
        case '0':
            aktuellerZustand = 11;
            break;

        case '1':
            aktuellerZustand = 11;
            break;

        case '2':
            aktuellerZustand = 11;
            break;

        case '3':
            aktuellerZustand = 11;
            break;

        case '4':
            aktuellerZustand = 11;
            break;

        case '5':
            aktuellerZustand = 11;
            break;

        case '6':
            aktuellerZustand = 11;
            break;

        case '7':
            aktuellerZustand = 11;
            break;

        case '8':
            aktuellerZustand = 11;
            break;

        case '9':
            aktuellerZustand = 11;
            break;

        default:
            aktuellerZustand = 12;
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
        aktuellerZustand = 12;
    }

    /**
     * Führt den Zustandsübergang von Z12 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z12ZeicheneingabeBearbeiten(char zeichen)
    {
        aktuellerZustand = 12;
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
        for (int zaehler = 1; zaehler <= zeichenkette
                .length(); zaehler = zaehler + 1)
        {
            ZeicheneingabeWeiterleiten(zeichenketteRest.charAt(0));
            zeichenketteRest = zeichenketteRest.substring(1);
        }
        // Der Endzustand ist Z8, Z9, Z10, Z11
        if (aktuellerZustand == 8 || aktuellerZustand == 9
                || aktuellerZustand == 10 || aktuellerZustand == 11)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
