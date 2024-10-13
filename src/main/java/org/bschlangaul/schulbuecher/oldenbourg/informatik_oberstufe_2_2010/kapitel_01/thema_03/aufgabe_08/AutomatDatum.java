package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_08;

/**
 *
 * Der Automat prüft Daten des Formats TT.MM.JJJJ: Das Passwort enthÃ¤lt
 * mindestens einen Buchstaben und ein Sonderzeichen (aber keine Ziffer).
 * Alphabet A = { .; 0; 1; ...; 9}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatDatum
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 (Startzustand) 21,
     * 22, 23 3 4 51, 52 6, 7, 81, 82, 9, 10, 11,(Endzustand) 12 (Fangzustand).
     * (vgl. Zustandsdiagramm zu Aufgabe 1a
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_DATUM: Der Startzustand wird
     * gesetzt.
     */
    public AutomatDatum()
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

        case 21:
            Z21ZeicheneingabeBearbeiten(zeichen);
            break;

        case 22:
            Z22ZeicheneingabeBearbeiten(zeichen);
            break;

        case 23:
            Z23ZeicheneingabeBearbeiten(zeichen);
            break;

        case 3:
            Z3ZeicheneingabeBearbeiten(zeichen);
            break;

        case 4:
            Z4ZeicheneingabeBearbeiten(zeichen);
            break;

        case 51:
            Z51ZeicheneingabeBearbeiten(zeichen);
            break;

        case 52:
            Z52ZeicheneingabeBearbeiten(zeichen);
            break;

        case 6:
            Z6ZeicheneingabeBearbeiten(zeichen);
            break;

        case 7:
            Z7ZeicheneingabeBearbeiten(zeichen);
            break;

        case 81:
            Z81ZeicheneingabeBearbeiten(zeichen);
            break;

        case 82:
            Z82ZeicheneingabeBearbeiten(zeichen);
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
        case '.':
            aktuellerZustand = 12;
            break;

        case '0':
            aktuellerZustand = 21;
            break;

        case '1':
            aktuellerZustand = 22;
            break;

        case '2':
            aktuellerZustand = 22;
            break;

        case '3':
            aktuellerZustand = 23;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z21 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z21ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '1':
            aktuellerZustand = 3;
            break;

        case '2':
            aktuellerZustand = 3;
            break;

        case '3':
            aktuellerZustand = 3;
            break;

        case '4':
            aktuellerZustand = 3;
            break;

        case '5':
            aktuellerZustand = 3;
            break;

        case '6':
            aktuellerZustand = 3;
            break;

        case '7':
            aktuellerZustand = 3;
            break;

        case '8':
            aktuellerZustand = 3;
            break;

        case '9':
            aktuellerZustand = 3;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z22 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z22ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '0':
            aktuellerZustand = 3;
            break;

        case '1':
            aktuellerZustand = 3;
            break;

        case '2':
            aktuellerZustand = 3;
            break;

        case '3':
            aktuellerZustand = 3;
            break;

        case '4':
            aktuellerZustand = 3;
            break;

        case '5':
            aktuellerZustand = 3;
            break;

        case '6':
            aktuellerZustand = 3;
            break;

        case '7':
            aktuellerZustand = 3;
            break;

        case '8':
            aktuellerZustand = 3;
            break;

        case '9':
            aktuellerZustand = 3;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z23 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z23ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '0':
            aktuellerZustand = 3;
            break;

        case '1':
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
        case '.':
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
        case '0':
            aktuellerZustand = 51;
            break;

        case '1':
            aktuellerZustand = 52;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z51 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z51ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '1':
            aktuellerZustand = 6;
            break;

        case '2':
            aktuellerZustand = 6;
            break;

        case '3':
            aktuellerZustand = 6;
            break;

        case '4':
            aktuellerZustand = 6;
            break;

        case '5':
            aktuellerZustand = 6;
            break;

        case '6':
            aktuellerZustand = 6;
            break;

        case '7':
            aktuellerZustand = 6;
            break;

        case '8':
            aktuellerZustand = 6;
            break;

        case '9':
            aktuellerZustand = 6;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z52 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z52ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '0':
            aktuellerZustand = 6;
            break;

        case '1':
            aktuellerZustand = 6;
            break;

        case '2':
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
        case '.':
            aktuellerZustand = 7;
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
            aktuellerZustand = 81;
            break;

        case '2':
            aktuellerZustand = 82;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z81 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z81ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '9':
            aktuellerZustand = 9;
            break;

        default:
            aktuellerZustand = 12;
        }
    }

    /**
     * Führt den Zustandsübergang von Z82 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z82ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '0':
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
        // Der Endzustand ist Z11
        if (aktuellerZustand == 11)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
