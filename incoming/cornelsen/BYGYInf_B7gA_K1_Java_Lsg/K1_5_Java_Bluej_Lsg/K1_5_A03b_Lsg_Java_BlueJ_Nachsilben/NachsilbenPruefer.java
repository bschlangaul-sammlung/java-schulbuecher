
/**
 * NachsilbenPruefer
 * 
 * @author Johannes Neumeyer 
 * @version 1.0
 */
class NachsilbenPruefer
{    
    /** Der aktuelle Zustand */
    private int aktZustand;

    /**
     * Konstruktor für Objekte der Klasse NachsilbenPruefer
     * Legt den Startzustand fest
     */
    NachsilbenPruefer()
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
        zeichenkette = zeichenkette.toLowerCase();
        aktZustand = 0; // Damit die Methode mehrfach ausgeführt werden kann, muss der Startzustand hier gesetzt werden

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        return aktZustand == 4;
    }

    /**
     * Führt abhängig vom aktuellen Zustand und dem aktuellen Zeichen
     * die Zustandsübergänge durch.
     * Der Fangzustand wird mit -1 codiert.
     * @param zei zu verarbeitendes Zeichen
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
            default:
                aktZustand = -1;
                break;
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z0 durch.
     * @param zei zu verarbeitendes Zeichen
     */
    private void ZeichenInZ0Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z':
                aktZustand = 0;
                break;
            case 'h', 'k':
                aktZustand = 1;
                break;            
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z1 durch.
     * @param zei zu verarbeitendes Zeichen
     */
    private void ZeichenInZ1Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'e':
                aktZustand = 2;
                break;
            case 'a', 'b', 'c', 'd', 'f', 'g', 'i', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z':
                aktZustand = 0;
                break;
            case 'h', 'k':
                aktZustand = 1;
                break;            
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z2 durch.
     * @param zei zu verarbeitendes Zeichen
     */
    private void ZeichenInZ2Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 'i':
                aktZustand = 3;
                break;
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z':
                aktZustand = 0;
                break;
            case 'h', 'k':
                aktZustand = 1;
                break;            
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z3 durch.
     * @param zei zu verarbeitendes Zeichen
     */
    private void ZeichenInZ3Verarbeiten(char zei)
    {
        switch (zei)
        {
            case 't':
                aktZustand = 4;
                break;
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z':
                aktZustand = 0;
                break;
            case 'h', 'k':
                aktZustand = 1;
                break;            
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand Z4 durch.
     * @param zei zu verarbeitendes Zeichen
     */
    private void ZeichenInZ4Verarbeiten(char zei)
    {
        switch (zei)
        {            
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z':
                aktZustand = 0;
                break;
            case 'h', 'k':
                aktZustand = 1;
                break;            
            default:
                aktZustand = -1;
                break;                    
        }
    }

    /**
     * Testmethode für verschiedene Wörter
     */
    void AutomatTesten()
    {
        String[] woerter = {"Freundlichkeit", "Zeit", "Heiterkeit", "Weite", "Einheit", "bereit", "heit", "keit", "Zartheit", "befreit"};

        for (String wort : woerter)
        {
            System.out.print(wort);
            if (IstEingabeAkzeptiert(wort))
            {
                System.out.println(": akzeptiert");
            }
            else
            {
                System.out.println(": verworfen");
            }
        }

    }
}
