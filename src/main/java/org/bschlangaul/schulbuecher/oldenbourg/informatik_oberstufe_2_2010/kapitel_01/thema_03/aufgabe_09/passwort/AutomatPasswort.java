package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort;

/**
 *
 * Der Automat prüft Passwörter nach folgender Vorgabe: Das Passwort enthält
 * mindestens einen Buchstaben und ein Sonderzeichen (aber keine Ziffer).
 * Alphabet A = { B; S}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatPasswort
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 (Startzustand), 2, 3,
     * 4, 5, 6, 7, 8, 9, 10,(Endzustand) 11 (Fangzustand). (vgl.
     * Zustandsdiagramm zu Aufgabe 3a, ii
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_PASSWORT: Der Startzustand
     * wird gesetzt.
     */
    public AutomatPasswort()
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
        case 'B':
            aktuellerZustand = 2;
            break;

        case 'S':
            aktuellerZustand = 5;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 3;
            break;

        case 'S':
            aktuellerZustand = 8;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 4;
            break;

        case 'S':
            aktuellerZustand = 9;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 4;
            break;

        case 'S':
            aktuellerZustand = 10;
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
        case 'B':
            aktuellerZustand = 8;
            break;

        case 'S':
            aktuellerZustand = 6;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 9;
            break;

        case 'S':
            aktuellerZustand = 7;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 10;
            break;

        case 'S':
            aktuellerZustand = 7;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 9;
            break;

        case 'S':
            aktuellerZustand = 9;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 10;
            break;

        case 'S':
            aktuellerZustand = 10;
            break;

        default:
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
        case 'B':
            aktuellerZustand = 10;
            break;

        case 'S':
            aktuellerZustand = 10;
            break;

        default:
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
        aktuellerZustand = 11;
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
        // Der Endzustand ist Z10
        if (aktuellerZustand == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
