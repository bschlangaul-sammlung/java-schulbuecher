/**
 * Prüft Eingaben auf Teilbarkeit durch 6
 * 
 * @author Johannes Neumeyer
 * @version 1.0
 */
class TeilbarkeitsPruefer
{
    /** Der aktuelle Zustand */
    private String aktZustand;
    
    /**
     * Konstruktor für Objekte der Klasse TeilbarkeitsPruefer
     * Setzt den Startzustand
     */
    TeilbarkeitsPruefer()
    {
        aktZustand = "R0,g";
    }

    /**
     * Überprüft, ob die Eingabe aktzeptiert wird.
     * 
     * @param zahl zu überprüfende Zahl
     * @return true, wenn die eingegebene Zahl durch 6 teilbar ist
     */
    boolean IstEingabeAkzeptiert(int zahl)
    {
        String zeichenkette = String.valueOf(zahl);        

        for (int i = 0; i < zeichenkette.length(); i++)
        {
            AktZeichenVerarbeiten(zeichenkette.charAt(i));
        }

        return aktZustand.equals("R0,g");
    }

    /**
     * Wählt abhängig vom aktuellen Zustand die richtige Verarbeitungsmethode
     * für das zu überprüfende Zeichen
     * 
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void AktZeichenVerarbeiten(char zei)
    {
        switch (aktZustand)
        {
            case "R0,g":
                ZeichenInR0gVerarbeiten(zei);
                break;
            case "R0,u":
                ZeichenInR0uVerarbeiten(zei);
                break;
            case "R1,g":
                ZeichenInR1gVerarbeiten(zei);
                break;
            case "R1,u":
                ZeichenInR1uVerarbeiten(zei);
                break;
            case "R2,g":
                ZeichenInR2gVerarbeiten(zei);
                break;
            case "R2,u":
                ZeichenInR2uVerarbeiten(zei);
                break;
            default:
                break;
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R0,g" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR0gVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R0,g"; break;
            case '1', '7': aktZustand = "R1,u"; break;
            case '2', '8': aktZustand = "R2,g"; break;
            case '3', '9': aktZustand = "R0,u"; break;
            case '4': aktZustand = "R1,g"; break;
            case '5': aktZustand = "R2,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R0,u" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR0uVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R0,g"; break;
            case '1', '7': aktZustand = "R1,u"; break;
            case '2', '8': aktZustand = "R2,g"; break;
            case '3', '9': aktZustand = "R0,u"; break;
            case '4': aktZustand = "R1,g"; break;
            case '5': aktZustand = "R2,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R1,g" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR1gVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R1,g"; break;
            case '1', '7': aktZustand = "R2,u"; break;
            case '2', '8': aktZustand = "R0,g"; break;
            case '3', '9': aktZustand = "R1,u"; break;
            case '4': aktZustand = "R2,g"; break;
            case '5': aktZustand = "R0,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R1,u" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR1uVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R1,g"; break;
            case '1', '7': aktZustand = "R2,g"; break;
            case '2', '8': aktZustand = "R0,g"; break;
            case '3', '9': aktZustand = "R1,u"; break;
            case '4': aktZustand = "R2,g"; break;
            case '5': aktZustand = "R0,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R2,g" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR2gVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R2,g"; break;
            case '1', '7': aktZustand = "R0,u"; break;
            case '2', '8': aktZustand = "R1,g"; break;
            case '3', '9': aktZustand = "R2,u"; break;
            case '4': aktZustand = "R0,g"; break;
            case '5': aktZustand = "R1,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Führt die Zustandsübergänge für das aktuelle Zeichen vom Zustand "R2,u" durch.
     * @param zei aktuell zu überprüfendes Zeichen
     */
    private void ZeichenInR2uVerarbeiten(char zei)
    {
        switch (zei)
        {
            case '0', '6': aktZustand = "R2,g"; break;
            case '1', '7': aktZustand = "R0,u"; break;
            case '2', '8': aktZustand = "R1,g"; break;
            case '3', '9': aktZustand = "R2,u"; break;
            case '4': aktZustand = "R0,g"; break;
            case '5': aktZustand = "R1,u"; break;
            default: aktZustand = "ZF";
        }
    }

    /**
     * Methode EndlichenAutomatTesten testet IstEingabeAkzeptiert(String wort).
     */
    void EndlichenAutomatTesten()
    {
        System.out.println("Test:");
        int[] testZeichenketten = { 
                0,         // gültig
                12,         // gültig
                54,        // gültig
                672,  // gültig
                -3,        // ungültig
                5,        // ungültig
                25,        // ungültig
                901,        // ungültig 
            };

        for (int zahl : testZeichenketten) 
        {
            System.out.printf("Test: %-8s -> %b\n", "" + zahl, IstEingabeAkzeptiert(zahl));
        }
    }
}
