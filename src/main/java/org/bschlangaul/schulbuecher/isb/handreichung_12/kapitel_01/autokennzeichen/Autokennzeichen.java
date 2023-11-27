package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_01.autokennzeichen;

class Autokennzeichen
{
    private int zustand;

    public Autokennzeichen()
    {
        zustand = 0; // Anfangszustand z0
    }

    public boolean wortUntersuchen(String kennzeichen)
    {
        boolean kennzeichenIstKorrekt = false;
        for (int i = 0; i < kennzeichen.length(); i++)
        {
            zustandWechseln(kennzeichen.charAt(i));
        }
        if ((zustand == 8) || (zustand == 9) || (zustand == 10)
                || (zustand == 11))
        {
            kennzeichenIstKorrekt = true;
            System.out.println("Das Wort ''" + kennzeichen
                    + "'' ist ein gültiges KFZ-Zeichen!");
        }
        else
        {
            System.out.println("Das Wort ''" + kennzeichen
                    + "'' ist kein gültiges KFZ-Zeichen!");
        }
        System.out.println("ZUSTAND: " + zustand);
        zustand = 0; // Anfangszustand z0
        return kennzeichenIstKorrekt;
    }

    private void zustandWechseln(char eingabezeichen)
    {
        switch (zustand)
        {
        case 0:
        {
            switch (eingabezeichen)
            {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'Ä':
            case 'Ö':
            case 'Ü':
            {
                zustand = 1;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 0

        case 1:
        {
            switch (eingabezeichen)
            {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'Ä':
            case 'Ö':
            case 'Ü':
            {
                zustand = 2;
            }
                break;

            case ' ':
            {
                zustand = 4;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 1

        case 2:
        {
            switch (eingabezeichen)
            {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'Ä':
            case 'Ö':
            case 'Ü':
            {
                zustand = 3;
            }
                break;

            case ' ':
            {
                zustand = 4;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 2

        case 3:
        {
            switch (eingabezeichen)
            {
            case ' ':
            {
                zustand = 4;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 3

        case 4:
        {
            switch (eingabezeichen)
            {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'Ä':
            case 'Ö':
            case 'Ü':
            {
                zustand = 5;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 4

        case 5:
        {
            switch (eingabezeichen)
            {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'Ä':
            case 'Ö':
            case 'Ü':
            {
                zustand = 6;
            }
                break;

            case ' ':
            {
                zustand = 7;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 5

        case 6:
        {
            switch (eingabezeichen)
            {
            case ' ':
            {
                zustand = 7;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 6

        case 7:
        {
            switch (eingabezeichen)
            {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            {
                zustand = 8;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 7

        case 8:
        {
            switch (eingabezeichen)
            {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            {
                zustand = 9;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 8

        case 9:
        {
            switch (eingabezeichen)
            {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            {
                zustand = 10;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 9

        case 10:
        {
            switch (eingabezeichen)
            {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            {
                zustand = 11;
            }
                break;

            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 10

        case 11:
        {
            switch (eingabezeichen)
            {
            // case '': {zustand = 11;}
            default:
            {
                zustand = 12;
            }
                break;
            }
        }
            break; // ende case 11
        } // ende switch zustand
    } // ende void zustandWechseln
}
