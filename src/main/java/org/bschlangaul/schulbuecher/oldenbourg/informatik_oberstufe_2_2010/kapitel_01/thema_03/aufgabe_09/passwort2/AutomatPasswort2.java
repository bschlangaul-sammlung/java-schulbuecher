package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_09.passwort2;

/**
 *
 * Der Automat prüft Passwörter nach folgender Vorgabe: Das Passwort enthält
 * mindestens einen Buchstaben und ein Sonderzeichen (aber keine Ziffer).
 * Alphabet A = { a; b; ...; z; :, ), §, %, $}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatPasswort2
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 (Startzustand), 2, 3,
     * 4, 5, 6, 7, 8, 9, 10,(Endzustand) 11 (Fangzustand). (vgl.
     * Zustandsdiagramm zu Aufgabe 3a, ii
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_PASSWORT2: Der Startzustand
     * wird gesetzt.
     */
    public AutomatPasswort2()
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
        case 'a':
            aktuellerZustand = 2;
            break;

        case 'b':
            aktuellerZustand = 2;
            break;

        case 'c':
            aktuellerZustand = 2;
            break;

        case 'd':
            aktuellerZustand = 2;
            break;

        case 'e':
            aktuellerZustand = 2;
            break;

        case 'f':
            aktuellerZustand = 2;
            break;

        case 'g':
            aktuellerZustand = 2;
            break;

        case 'h':
            aktuellerZustand = 2;
            break;

        case 'i':
            aktuellerZustand = 2;
            break;

        case 'j':
            aktuellerZustand = 2;
            break;

        case 'k':
            aktuellerZustand = 2;
            break;

        case 'l':
            aktuellerZustand = 2;
            break;

        case 'm':
            aktuellerZustand = 2;
            break;

        case 'n':
            aktuellerZustand = 2;
            break;

        case 'o':
            aktuellerZustand = 2;
            break;

        case 'p':
            aktuellerZustand = 2;
            break;

        case 'q':
            aktuellerZustand = 2;
            break;

        case 'r':
            aktuellerZustand = 2;
            break;

        case 's':
            aktuellerZustand = 2;
            break;

        case 't':
            aktuellerZustand = 2;
            break;

        case 'u':
            aktuellerZustand = 2;
            break;

        case 'v':
            aktuellerZustand = 2;
            break;

        case 'w':
            aktuellerZustand = 2;
            break;

        case 'x':
            aktuellerZustand = 2;
            break;

        case 'y':
            aktuellerZustand = 2;
            break;

        case 'z':
            aktuellerZustand = 2;
            break;

        case ':':
            aktuellerZustand = 5;
            break;

        case ')':
            aktuellerZustand = 5;
            break;

        case '§':
            aktuellerZustand = 5;
            break;

        case '%':
            aktuellerZustand = 5;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 3;
            break;

        case 'b':
            aktuellerZustand = 3;
            break;

        case 'c':
            aktuellerZustand = 3;
            break;

        case 'd':
            aktuellerZustand = 3;
            break;

        case 'e':
            aktuellerZustand = 3;
            break;

        case 'f':
            aktuellerZustand = 3;
            break;

        case 'g':
            aktuellerZustand = 3;
            break;

        case 'h':
            aktuellerZustand = 3;
            break;

        case 'i':
            aktuellerZustand = 3;
            break;

        case 'j':
            aktuellerZustand = 3;
            break;

        case 'k':
            aktuellerZustand = 3;
            break;

        case 'l':
            aktuellerZustand = 3;
            break;

        case 'm':
            aktuellerZustand = 3;
            break;

        case 'n':
            aktuellerZustand = 3;
            break;

        case 'o':
            aktuellerZustand = 3;
            break;

        case 'p':
            aktuellerZustand = 3;
            break;

        case 'q':
            aktuellerZustand = 3;
            break;

        case 'r':
            aktuellerZustand = 3;
            break;

        case 's':
            aktuellerZustand = 3;
            break;

        case 't':
            aktuellerZustand = 3;
            break;

        case 'u':
            aktuellerZustand = 3;
            break;

        case 'v':
            aktuellerZustand = 3;
            break;

        case 'w':
            aktuellerZustand = 3;
            break;

        case 'x':
            aktuellerZustand = 3;
            break;

        case 'y':
            aktuellerZustand = 3;
            break;

        case 'z':
            aktuellerZustand = 3;
            break;

        case ':':
            aktuellerZustand = 8;
            break;

        case ')':
            aktuellerZustand = 8;
            break;

        case '§':
            aktuellerZustand = 8;
            break;

        case '%':
            aktuellerZustand = 8;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 4;
            break;

        case 'b':
            aktuellerZustand = 4;
            break;

        case 'c':
            aktuellerZustand = 4;
            break;

        case 'd':
            aktuellerZustand = 4;
            break;

        case 'e':
            aktuellerZustand = 4;
            break;

        case 'f':
            aktuellerZustand = 4;
            break;

        case 'g':
            aktuellerZustand = 4;
            break;

        case 'h':
            aktuellerZustand = 4;
            break;

        case 'i':
            aktuellerZustand = 4;
            break;

        case 'j':
            aktuellerZustand = 4;
            break;

        case 'k':
            aktuellerZustand = 4;
            break;

        case 'l':
            aktuellerZustand = 4;
            break;

        case 'm':
            aktuellerZustand = 4;
            break;

        case 'n':
            aktuellerZustand = 4;
            break;

        case 'o':
            aktuellerZustand = 4;
            break;

        case 'p':
            aktuellerZustand = 4;
            break;

        case 'q':
            aktuellerZustand = 4;
            break;

        case 'r':
            aktuellerZustand = 4;
            break;

        case 's':
            aktuellerZustand = 4;
            break;

        case 't':
            aktuellerZustand = 4;
            break;

        case 'u':
            aktuellerZustand = 4;
            break;

        case 'v':
            aktuellerZustand = 4;
            break;

        case 'w':
            aktuellerZustand = 4;
            break;

        case 'x':
            aktuellerZustand = 4;
            break;

        case 'y':
            aktuellerZustand = 4;
            break;

        case 'z':
            aktuellerZustand = 4;
            break;

        case ':':
            aktuellerZustand = 9;
            break;

        case ')':
            aktuellerZustand = 9;
            break;

        case '§':
            aktuellerZustand = 9;
            break;

        case '%':
            aktuellerZustand = 9;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 4;
            break;

        case 'b':
            aktuellerZustand = 4;
            break;

        case 'c':
            aktuellerZustand = 4;
            break;

        case 'd':
            aktuellerZustand = 4;
            break;

        case 'e':
            aktuellerZustand = 4;
            break;

        case 'f':
            aktuellerZustand = 4;
            break;

        case 'g':
            aktuellerZustand = 4;
            break;

        case 'h':
            aktuellerZustand = 4;
            break;

        case 'i':
            aktuellerZustand = 4;
            break;

        case 'j':
            aktuellerZustand = 4;
            break;

        case 'k':
            aktuellerZustand = 4;
            break;

        case 'l':
            aktuellerZustand = 4;
            break;

        case 'm':
            aktuellerZustand = 4;
            break;

        case 'n':
            aktuellerZustand = 4;
            break;

        case 'o':
            aktuellerZustand = 4;
            break;

        case 'p':
            aktuellerZustand = 4;
            break;

        case 'q':
            aktuellerZustand = 4;
            break;

        case 'r':
            aktuellerZustand = 4;
            break;

        case 's':
            aktuellerZustand = 4;
            break;

        case 't':
            aktuellerZustand = 4;
            break;

        case 'u':
            aktuellerZustand = 4;
            break;

        case 'v':
            aktuellerZustand = 4;
            break;

        case 'w':
            aktuellerZustand = 4;
            break;

        case 'x':
            aktuellerZustand = 4;
            break;

        case 'y':
            aktuellerZustand = 4;
            break;

        case 'z':
            aktuellerZustand = 4;
            break;

        case ':':
            aktuellerZustand = 10;
            break;

        case ')':
            aktuellerZustand = 10;
            break;

        case '§':
            aktuellerZustand = 10;
            break;

        case '%':
            aktuellerZustand = 10;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 8;
            break;

        case 'b':
            aktuellerZustand = 8;
            break;

        case 'c':
            aktuellerZustand = 8;
            break;

        case 'd':
            aktuellerZustand = 8;
            break;

        case 'e':
            aktuellerZustand = 8;
            break;

        case 'f':
            aktuellerZustand = 8;
            break;

        case 'g':
            aktuellerZustand = 8;
            break;

        case 'h':
            aktuellerZustand = 8;
            break;

        case 'i':
            aktuellerZustand = 8;
            break;

        case 'j':
            aktuellerZustand = 8;
            break;

        case 'k':
            aktuellerZustand = 8;
            break;

        case 'l':
            aktuellerZustand = 8;
            break;

        case 'm':
            aktuellerZustand = 8;
            break;

        case 'n':
            aktuellerZustand = 8;
            break;

        case 'o':
            aktuellerZustand = 8;
            break;

        case 'p':
            aktuellerZustand = 8;
            break;

        case 'q':
            aktuellerZustand = 8;
            break;

        case 'r':
            aktuellerZustand = 8;
            break;

        case 's':
            aktuellerZustand = 8;
            break;

        case 't':
            aktuellerZustand = 8;
            break;

        case 'u':
            aktuellerZustand = 8;
            break;

        case 'v':
            aktuellerZustand = 8;
            break;

        case 'w':
            aktuellerZustand = 8;
            break;

        case 'x':
            aktuellerZustand = 8;
            break;

        case 'y':
            aktuellerZustand = 8;
            break;

        case 'z':
            aktuellerZustand = 8;
            break;

        case ':':
            aktuellerZustand = 6;
            break;

        case ')':
            aktuellerZustand = 6;
            break;

        case '§':
            aktuellerZustand = 6;
            break;

        case '%':
            aktuellerZustand = 6;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 9;
            break;

        case 'b':
            aktuellerZustand = 9;
            break;

        case 'c':
            aktuellerZustand = 9;
            break;

        case 'd':
            aktuellerZustand = 9;
            break;

        case 'e':
            aktuellerZustand = 9;
            break;

        case 'f':
            aktuellerZustand = 9;
            break;

        case 'g':
            aktuellerZustand = 9;
            break;

        case 'h':
            aktuellerZustand = 9;
            break;

        case 'i':
            aktuellerZustand = 9;
            break;

        case 'j':
            aktuellerZustand = 9;
            break;

        case 'k':
            aktuellerZustand = 9;
            break;

        case 'l':
            aktuellerZustand = 9;
            break;

        case 'm':
            aktuellerZustand = 9;
            break;

        case 'n':
            aktuellerZustand = 9;
            break;

        case 'o':
            aktuellerZustand = 9;
            break;

        case 'p':
            aktuellerZustand = 9;
            break;

        case 'q':
            aktuellerZustand = 9;
            break;

        case 'r':
            aktuellerZustand = 9;
            break;

        case 's':
            aktuellerZustand = 9;
            break;

        case 't':
            aktuellerZustand = 9;
            break;

        case 'u':
            aktuellerZustand = 9;
            break;

        case 'v':
            aktuellerZustand = 9;
            break;

        case 'w':
            aktuellerZustand = 9;
            break;

        case 'x':
            aktuellerZustand = 9;
            break;

        case 'y':
            aktuellerZustand = 9;
            break;

        case 'z':
            aktuellerZustand = 9;
            break;

        case ':':
            aktuellerZustand = 7;
            break;

        case ')':
            aktuellerZustand = 7;
            break;

        case '§':
            aktuellerZustand = 7;
            break;

        case '%':
            aktuellerZustand = 7;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 10;
            break;

        case 'b':
            aktuellerZustand = 10;
            break;

        case 'c':
            aktuellerZustand = 10;
            break;

        case 'd':
            aktuellerZustand = 10;
            break;

        case 'e':
            aktuellerZustand = 10;
            break;

        case 'f':
            aktuellerZustand = 10;
            break;

        case 'g':
            aktuellerZustand = 10;
            break;

        case 'h':
            aktuellerZustand = 10;
            break;

        case 'i':
            aktuellerZustand = 10;
            break;

        case 'j':
            aktuellerZustand = 10;
            break;

        case 'k':
            aktuellerZustand = 10;
            break;

        case 'l':
            aktuellerZustand = 10;
            break;

        case 'm':
            aktuellerZustand = 10;
            break;

        case 'n':
            aktuellerZustand = 10;
            break;

        case 'o':
            aktuellerZustand = 10;
            break;

        case 'p':
            aktuellerZustand = 10;
            break;

        case 'q':
            aktuellerZustand = 10;
            break;

        case 'r':
            aktuellerZustand = 10;
            break;

        case 's':
            aktuellerZustand = 10;
            break;

        case 't':
            aktuellerZustand = 10;
            break;

        case 'u':
            aktuellerZustand = 10;
            break;

        case 'v':
            aktuellerZustand = 10;
            break;

        case 'w':
            aktuellerZustand = 10;
            break;

        case 'x':
            aktuellerZustand = 10;
            break;

        case 'y':
            aktuellerZustand = 10;
            break;

        case 'z':
            aktuellerZustand = 10;
            break;

        case ':':
            aktuellerZustand = 7;
            break;

        case ')':
            aktuellerZustand = 7;
            break;

        case '§':
            aktuellerZustand = 7;
            break;

        case '%':
            aktuellerZustand = 7;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 9;
            break;

        case 'b':
            aktuellerZustand = 9;
            break;

        case 'c':
            aktuellerZustand = 9;
            break;

        case 'd':
            aktuellerZustand = 9;
            break;

        case 'e':
            aktuellerZustand = 9;
            break;

        case 'f':
            aktuellerZustand = 9;
            break;

        case 'g':
            aktuellerZustand = 9;
            break;

        case 'h':
            aktuellerZustand = 9;
            break;

        case 'i':
            aktuellerZustand = 9;
            break;

        case 'j':
            aktuellerZustand = 9;
            break;

        case 'k':
            aktuellerZustand = 9;
            break;

        case 'l':
            aktuellerZustand = 9;
            break;

        case 'm':
            aktuellerZustand = 9;
            break;

        case 'n':
            aktuellerZustand = 9;
            break;

        case 'o':
            aktuellerZustand = 9;
            break;

        case 'p':
            aktuellerZustand = 9;
            break;

        case 'q':
            aktuellerZustand = 9;
            break;

        case 'r':
            aktuellerZustand = 9;
            break;

        case 's':
            aktuellerZustand = 9;
            break;

        case 't':
            aktuellerZustand = 9;
            break;

        case 'u':
            aktuellerZustand = 9;
            break;

        case 'v':
            aktuellerZustand = 9;
            break;

        case 'w':
            aktuellerZustand = 9;
            break;

        case 'x':
            aktuellerZustand = 9;
            break;

        case 'y':
            aktuellerZustand = 9;
            break;

        case 'z':
            aktuellerZustand = 9;
            break;

        case ':':
            aktuellerZustand = 9;
            break;

        case ')':
            aktuellerZustand = 9;
            break;

        case '§':
            aktuellerZustand = 9;
            break;

        case '%':
            aktuellerZustand = 9;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 10;
            break;

        case 'b':
            aktuellerZustand = 10;
            break;

        case 'c':
            aktuellerZustand = 10;
            break;

        case 'd':
            aktuellerZustand = 10;
            break;

        case 'e':
            aktuellerZustand = 10;
            break;

        case 'f':
            aktuellerZustand = 10;
            break;

        case 'g':
            aktuellerZustand = 10;
            break;

        case 'h':
            aktuellerZustand = 10;
            break;

        case 'i':
            aktuellerZustand = 10;
            break;

        case 'j':
            aktuellerZustand = 10;
            break;

        case 'k':
            aktuellerZustand = 10;
            break;

        case 'l':
            aktuellerZustand = 10;
            break;

        case 'm':
            aktuellerZustand = 10;
            break;

        case 'n':
            aktuellerZustand = 10;
            break;

        case 'o':
            aktuellerZustand = 10;
            break;

        case 'p':
            aktuellerZustand = 10;
            break;

        case 'q':
            aktuellerZustand = 10;
            break;

        case 'r':
            aktuellerZustand = 10;
            break;

        case 's':
            aktuellerZustand = 10;
            break;

        case 't':
            aktuellerZustand = 10;
            break;

        case 'u':
            aktuellerZustand = 10;
            break;

        case 'v':
            aktuellerZustand = 10;
            break;

        case 'w':
            aktuellerZustand = 10;
            break;

        case 'x':
            aktuellerZustand = 10;
            break;

        case 'y':
            aktuellerZustand = 10;
            break;

        case 'z':
            aktuellerZustand = 10;
            break;

        case ':':
            aktuellerZustand = 10;
            break;

        case ')':
            aktuellerZustand = 10;
            break;

        case '§':
            aktuellerZustand = 10;
            break;

        case '%':
            aktuellerZustand = 10;
            break;

        case '$':
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
        case 'a':
            aktuellerZustand = 10;
            break;

        case 'b':
            aktuellerZustand = 10;
            break;

        case 'c':
            aktuellerZustand = 10;
            break;

        case 'd':
            aktuellerZustand = 10;
            break;

        case 'e':
            aktuellerZustand = 10;
            break;

        case 'f':
            aktuellerZustand = 10;
            break;

        case 'g':
            aktuellerZustand = 10;
            break;

        case 'h':
            aktuellerZustand = 10;
            break;

        case 'i':
            aktuellerZustand = 10;
            break;

        case 'j':
            aktuellerZustand = 10;
            break;

        case 'k':
            aktuellerZustand = 10;
            break;

        case 'l':
            aktuellerZustand = 10;
            break;

        case 'm':
            aktuellerZustand = 10;
            break;

        case 'n':
            aktuellerZustand = 10;
            break;

        case 'o':
            aktuellerZustand = 10;
            break;

        case 'p':
            aktuellerZustand = 10;
            break;

        case 'q':
            aktuellerZustand = 10;
            break;

        case 'r':
            aktuellerZustand = 10;
            break;

        case 's':
            aktuellerZustand = 10;
            break;

        case 't':
            aktuellerZustand = 10;
            break;

        case 'u':
            aktuellerZustand = 10;
            break;

        case 'v':
            aktuellerZustand = 10;
            break;

        case 'w':
            aktuellerZustand = 10;
            break;

        case 'x':
            aktuellerZustand = 10;
            break;

        case 'y':
            aktuellerZustand = 10;
            break;

        case 'z':
            aktuellerZustand = 10;
            break;

        case ':':
            aktuellerZustand = 10;
            break;

        case ')':
            aktuellerZustand = 10;
            break;

        case '§':
            aktuellerZustand = 10;
            break;

        case '%':
            aktuellerZustand = 10;
            break;

        case '$':
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
