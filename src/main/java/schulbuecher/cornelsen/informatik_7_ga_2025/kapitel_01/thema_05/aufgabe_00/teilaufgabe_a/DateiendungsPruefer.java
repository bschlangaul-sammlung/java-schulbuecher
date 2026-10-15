package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_00.teilaufgabe_a;

/**
 * DateiendungsPruefer
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class DateiendungsPruefer
{
    /** Der aktuelle Zustand */
    private int aktZustand;

    /**
     * Konstruktor für Objekte der Klasse DateiendungsPruefer Setzt den
     * Startzustand
     */
    DateiendungsPruefer()
    {
        aktZustand = 0;
    }

    /**
     * Überprüft, ob die Eingabe aktzeptiert wird.
     *
     * @param zeichenkette zu überprüfende Eingabe
     *
     * @return true, wenn die Eingabe jpg, jpeg oder png ist.
     */
    boolean IstEingabeAkzeptiert(String zeichenkette)
    {
        aktZustand = 0; // Damit die Methode mehrfach ausgeführt werden kann,
                        // muss der Startzustand hier gesetzt werden

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        if (aktZustand == 5) // %%%%% return aktZustand == 5
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Führt abhängig vom aktuellen Zustand und dem aktuellen Zeichen die
     * Zustandsübergänge durch. Der Fangzustand wird mit -1 codiert.
     *
     * @param zei zu verarbeitendes Zeichen
     */
    private void AktZeichenVerarbeiten(char zei)
    {
        switch (aktZustand)
        {
        case 0:
            switch (zei)
            {
            case 'j':
                aktZustand = 1;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        case 1:
            switch (zei)
            {
            case 'p':
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
            case 'e':
                aktZustand = 4;
                break;

            case 'g':
                aktZustand = 5;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        case 4:
            switch (zei)
            {
            case 'g':
                aktZustand = 5;
                break;

            default:
                aktZustand = -1;
                break;
            }
            break;

        default:
            aktZustand = -1;
            break;
        }
    }
}
