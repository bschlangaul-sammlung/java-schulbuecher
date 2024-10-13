package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_01.thema_03.aufgabe_11.eurobetrag2;

/**
 *
 * Der Automat prüft Eurobeträge nach folgenden Vorgaben: Ein Euro Geldbetrag
 * beginnt mit einer Zahl und endet mit dem Eurosymbol. Die Zahl kann Null, eine
 * einzelne Ziffer oder eine Zahl mit beliebig vielen Stellen sein. Eine
 * führende Null ist bei der Zahl nicht erlaubt. Optional sind zwischen der Zahl
 * und dem Eurozeichen noch genau zwei Nachkommastellen erlaubt, die einen
 * Centwert zwischen 0 und 99 Cent beschreiben. Als Trennzeichen zwischen den
 * Euros und den Cents wird ein Punkt verwendet. Vor dem Eurozeichen wird kein
 * Leerzeichen als Trennzeichen verwendet! Alphabet A = { .; &#8364; ; 0; 1; 2;
 * ...; 9}
 *
 * @author (Peter Brichzin)
 *
 * @version (10.9.2009)
 */
public class AutomatEurobetrag
{
    /**
     * Die Zustände sind nummeriert. Mögliche Werte sind 1 (Startzustand), 21,
     * 22, 23, 24, 25, 26, 3, 4, 5, 6, 7,(Endzustand) 8 (Fangzustand)
     */
    private int aktuellerZustand;

    /**
     * Konstruktor für Objekte der Klasse AUTOMAT_EUROBETRAG: Der Startzustand
     * wird gesetzt.
     */
    public AutomatEurobetrag()
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

        case 21:
            Z21ZeicheneingabeBearbeiten(zeichen);
            break;

        case 22:
            Z22ZeicheneingabeBearbeiten(zeichen);
            break;

        case 23:
            Z23ZeicheneingabeBearbeiten(zeichen);
            break;

        case 24:
            Z24ZeicheneingabeBearbeiten(zeichen);
            break;

        case 25:
            Z25ZeicheneingabeBearbeiten(zeichen);
            break;

        case 26:
            Z26ZeicheneingabeBearbeiten(zeichen);
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
        case '0':
            aktuellerZustand = 6;
            break;

        case '1':
            aktuellerZustand = 21;
            break;

        case '2':
            aktuellerZustand = 21;
            break;

        case '3':
            aktuellerZustand = 21;
            break;

        case '4':
            aktuellerZustand = 21;
            break;

        case '5':
            aktuellerZustand = 21;
            break;

        case '6':
            aktuellerZustand = 21;
            break;

        case '7':
            aktuellerZustand = 21;
            break;

        case '8':
            aktuellerZustand = 21;
            break;

        case '9':
            aktuellerZustand = 21;
            break;

        default:
            aktuellerZustand = 8;
        }
    }

    /**
     * Führt den Zustandsübergang von Z2 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z21ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        case '0':
            aktuellerZustand = 22;
            break;

        case '1':
            aktuellerZustand = 22;
            break;

        case '2':
            aktuellerZustand = 22;
            break;

        case '3':
            aktuellerZustand = 22;
            break;

        case '4':
            aktuellerZustand = 22;
            break;

        case '5':
            aktuellerZustand = 22;
            break;

        case '6':
            aktuellerZustand = 22;
            break;

        case '7':
            aktuellerZustand = 22;
            break;

        case '8':
            aktuellerZustand = 22;
            break;

        case '9':
            aktuellerZustand = 22;
            break;

        default:
            aktuellerZustand = 8;
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
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        case '0':
            aktuellerZustand = 23;
            break;

        case '1':
            aktuellerZustand = 23;
            break;

        case '2':
            aktuellerZustand = 23;
            break;

        case '3':
            aktuellerZustand = 23;
            break;

        case '4':
            aktuellerZustand = 23;
            break;

        case '5':
            aktuellerZustand = 23;
            break;

        case '6':
            aktuellerZustand = 23;
            break;

        case '7':
            aktuellerZustand = 23;
            break;

        case '8':
            aktuellerZustand = 23;
            break;

        case '9':
            aktuellerZustand = 23;
            break;

        default:
            aktuellerZustand = 8;
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
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        case '0':
            aktuellerZustand = 24;
            break;

        case '1':
            aktuellerZustand = 24;
            break;

        case '2':
            aktuellerZustand = 24;
            break;

        case '3':
            aktuellerZustand = 24;
            break;

        case '4':
            aktuellerZustand = 24;
            break;

        case '5':
            aktuellerZustand = 24;
            break;

        case '6':
            aktuellerZustand = 24;
            break;

        case '7':
            aktuellerZustand = 24;
            break;

        case '8':
            aktuellerZustand = 24;
            break;

        case '9':
            aktuellerZustand = 24;
            break;

        default:
            aktuellerZustand = 8;
        }
    }

    /**
     * Führt den Zustandsübergang von Z24 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z24ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        case '0':
            aktuellerZustand = 25;
            break;

        case '1':
            aktuellerZustand = 25;
            break;

        case '2':
            aktuellerZustand = 25;
            break;

        case '3':
            aktuellerZustand = 25;
            break;

        case '4':
            aktuellerZustand = 25;
            break;

        case '5':
            aktuellerZustand = 25;
            break;

        case '6':
            aktuellerZustand = 25;
            break;

        case '7':
            aktuellerZustand = 25;
            break;

        case '8':
            aktuellerZustand = 25;
            break;

        case '9':
            aktuellerZustand = 25;
            break;

        default:
            aktuellerZustand = 8;
        }
    }

    /**
     * Führt den Zustandsübergang von Z25 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z25ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        case '0':
            aktuellerZustand = 26;
            break;

        case '1':
            aktuellerZustand = 26;
            break;

        case '2':
            aktuellerZustand = 26;
            break;

        case '3':
            aktuellerZustand = 26;
            break;

        case '4':
            aktuellerZustand = 26;
            break;

        case '5':
            aktuellerZustand = 26;
            break;

        case '6':
            aktuellerZustand = 26;
            break;

        case '7':
            aktuellerZustand = 26;
            break;

        case '8':
            aktuellerZustand = 26;
            break;

        case '9':
            aktuellerZustand = 26;
            break;

        default:
            aktuellerZustand = 8;
        }
    }

    /**
     * Führt den Zustandsübergang von Z26 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z26ZeicheneingabeBearbeiten(char zeichen)
    {
        switch (zeichen)
        {
        case '.':
            aktuellerZustand = 3;
            break;

        case '\u20AC':
            aktuellerZustand = 7;
            break;

        default:
            aktuellerZustand = 8;
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
        case '0':
            aktuellerZustand = 4;
            break;

        case '1':
            aktuellerZustand = 4;
            break;

        case '2':
            aktuellerZustand = 4;
            break;

        case '3':
            aktuellerZustand = 4;
            break;

        case '4':
            aktuellerZustand = 4;
            break;

        case '5':
            aktuellerZustand = 4;
            break;

        case '6':
            aktuellerZustand = 4;
            break;

        case '7':
            aktuellerZustand = 4;
            break;

        case '8':
            aktuellerZustand = 4;
            break;

        case '9':
            aktuellerZustand = 4;
            break;

        default:
            aktuellerZustand = 8;
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
            aktuellerZustand = 5;
            break;

        case '1':
            aktuellerZustand = 5;
            break;

        case '2':
            aktuellerZustand = 5;
            break;

        case '3':
            aktuellerZustand = 5;
            break;

        case '4':
            aktuellerZustand = 5;
            break;

        case '5':
            aktuellerZustand = 5;
            break;

        case '6':
            aktuellerZustand = 5;
            break;

        case '7':
            aktuellerZustand = 5;
            break;

        case '8':
            aktuellerZustand = 5;
            break;

        case '9':
            aktuellerZustand = 5;
            break;

        default:
            aktuellerZustand = 8;
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
        case '\u20AC':
            aktuellerZustand = 7;
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
        case '\u20AC':
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
        aktuellerZustand = 8;
    }

    /**
     * Führt den Zustandsübergang von Z8 abhängig vom aktuellen Zustand durch.
     *
     * @param zeichen das aktuell zu verarbeitende Zeichen.
     *
     */
    private void Z8ZeicheneingabeBearbeiten(char zeichen)
    {
        aktuellerZustand = 8;
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
        // Der Endzustand ist Z7
        if (aktuellerZustand == 7)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
