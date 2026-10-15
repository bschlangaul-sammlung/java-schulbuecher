/**
 * Überprüft, ob Anforderungen an ein Passwort erfüllt werden
 * 
 * @author Johannes Neumeyer
 * @version 1.0
 */
class PasswortPruefer
{
    /** Der aktuelle Zustand */
    private int aktZustand;

    /**
     * Konstruktor für Objekte der Klasse PasswortPruefer
     * Legt den Startzustand fest
     */
    PasswortPruefer()
    {
        aktZustand = 0;
    }

    /**
     * Überprüft, ob die Eingabe aktzeptiert wird.
     * 
     * @param zeichenkette zu überprüfende Eingabe
     * @return true, wenn die Eingabe das Format einer ganzen Zahl hat
     */
    boolean IstEingabeAkzeptiert(String zeichenkette)
    {
        aktZustand = 0; // Damit die Methode mehrfach ausgeführt werden kann, muss der Startzustand hier gesetzt werden

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        return aktZustand == 9;
    }

    /**
     * Führt abhängig vom aktuellen Zustand und dem aktuellen Zeichen
     * die Zustandsübergänge durch.
     * Der Fangzustand wird mit -1 codiert.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void AktZeichenVerarbeiten(char zei)
    {
        switch (aktZustand)
        {
            case 0:
                ZeichenInZ0Verarbeiten(zei);
                break;
            case 1:
                ZeichenInZ1Verarbeiten(zei);
                break;
            case 2:
                ZeichenInZ2Verarbeiten(zei);
                break;            
            case 3:
                ZeichenInZ3Verarbeiten(zei);
                break;
            case 4:
                ZeichenInZ4Verarbeiten(zei);
                break;
            case 5:
                ZeichenInZ5Verarbeiten(zei);
                break;
            case 6:
                ZeichenInZ6Verarbeiten(zei);
                break;
            case 7:
                ZeichenInZ7Verarbeiten(zei);
                break;
            case 8:
                ZeichenInZ8Verarbeiten(zei);
                break;
            case 9:
                ZeichenInZ9Verarbeiten(zei);
                break;
            case -1:
                aktZustand = -1;
                break;
            default:
                break;
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z0 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ0Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 1;
                break;
            case 'S':
                aktZustand = 4;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z1 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ1Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 2;
                break;
            case 'S':
                aktZustand = 7;
                break;
            default:
                aktZustand = -1;
                break;                     
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z2 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ2Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 3;
                break;
            case 'S':
                aktZustand = 8;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z3 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ3Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 3;
                break;
            case 'S':
                aktZustand = 9;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z4 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ4Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 7;
                break;
            case 'S':
                aktZustand = 5;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z5 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ5Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 8;
                break;
            case 'S':
                aktZustand = 6;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z6 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ6Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B':
                aktZustand = 9;
                break;
            case 'S':
                aktZustand = 6;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z7 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ7Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B', 'S':
                aktZustand = 8;
                break;        
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z8 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ8Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B', 'S':
                aktZustand = 9;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z9 durch.
     * @param zei aktuell zu verarbeitendes Zeichen
     */
    private void ZeichenInZ9Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'B', 'S':
                aktZustand = 9;
                break;
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Methode EndlichenAutomatTesten testet IstEingabeAkzeptiert(String wort).
     */
    void EndlichenAutomatTesten()
    {
        System.out.println("Test:");
        String[] testZeichenketten = { 
                "BZSSBBBBBBBZZ", // p1:)freitag22   ungültig
                "BBSZBBBZ",      // gg§3abs4        ungültig
                "BSBBS"          // j%nn$           gültig
            };

        for (String s : testZeichenketten) 
        {
            System.out.printf("Test: %-8s -> %b\n", s, IstEingabeAkzeptiert(s));
        }
    }
}
