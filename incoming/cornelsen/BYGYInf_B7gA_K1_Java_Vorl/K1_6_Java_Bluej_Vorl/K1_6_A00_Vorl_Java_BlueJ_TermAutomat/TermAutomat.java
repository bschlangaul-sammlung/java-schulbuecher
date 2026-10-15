
import java.util.*;
/**
 * Automat, der testet, ob ein einfacher mathematischer Term korrekt ist.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class TermAutomat
{
    /** Die Nummer des aktuellen Zustands */
    private int aktuellerZustand;
    /** Gespeicherte Zustandsinformation */
    private ArrayList<Character> speicher;

    /**
     * Default für Startzustand und Einrichten des Speichers
     */
    TermAutomat()
    {
        aktuellerZustand = -1;
        speicher = new ArrayList<Character>();
    }
 
    /**
     * Legt ein Zeichen auf dem Speicher ab
     * @param ch: Zeichen
     */
    private void Speichern(char ch)
    {
        speicher.add(new Character(ch));
    }
    
    /**
     * Prüft, ob das angegebene Zeichen zuoberst im Speicher liegt und löscht es dann
     * @param ch das zu testende Zeichen
     * @return wahr, wenn das angegebene Zeichen zuoberst im Speicher liegt
     */
    private boolean TestenUndLöschen(char ch)
    {
        if (speicher.size() > 0)
        {
            char choben = speicher.remove(speicher.size() - 1);
            return ch == choben;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Verarbeitet das Eingabezeichen für den Zustand 0
     * @param ch Eingabezeichen
     */
    private void Z0(char ch)
    {
        if (('0' <= ch) && (ch <= '9'))
        {
            aktuellerZustand = 1;
        }
        else if (ch == '(')
        {
            Speichern('(');
            aktuellerZustand = 2;
        }
        else
        {
            aktuellerZustand = -1;
        }
    }
    
    /**
     * Verarbeitet das Eingabezeichen für den Zustand 1
     * @param ch Eingabezeichen
     */
    private void Z1(char ch)
    {
        if (('0' <= ch) && (ch <= '9'))
        {
            aktuellerZustand = 1;
        }
        else if (ch == ')')
        {
            if (TestenUndLöschen('('))
            {
                aktuellerZustand = 3;
            }
            else
            {
                aktuellerZustand = -1;
            }
        }
        else if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/'))
        {
            aktuellerZustand = 4;
        }
        else
        {
            aktuellerZustand = -1;
        }
    }
    
    /**
     * Verarbeitet das Eingabezeichen für den Zustand 2
     * @param ch Eingabezeichen
     */
    private void Z2(char ch)
    {
        if (('0' <= ch) && (ch <= '9'))
        {
            aktuellerZustand = 1;
        }
        else if (ch == '(')
        {
            Speichern('(');
            aktuellerZustand = 2;
        }
        else
        {
            aktuellerZustand = -1;
        }
    }
    
    /**
     * Verarbeitet das Eingabezeichen für den Zustand 3
     * @param ch Eingabezeichen
     */
    private void Z3(char ch)
    {
        if (ch == ')')
        {
            if (TestenUndLöschen('('))
            {
                aktuellerZustand = 3;
            }
            else
            {
                aktuellerZustand = -1;
            }
        }
        else if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/'))
        {
            aktuellerZustand = 4;
        }
        else
        {
            aktuellerZustand = -1;
        }
    }
    
    /**
     * Verarbeitet das Eingabezeichen für den Zustand 4
     * @param ch Eingabezeichen
     */
    private void Z4(char ch)
    {
        if (('0' <= ch) && (ch <= '9'))
        {
            aktuellerZustand = 1;
        }
        else if (ch == '(')
        {
            Speichern('(');
            aktuellerZustand = 2;
        }
        else
        {
            aktuellerZustand = -1;
        }
    }
    
    /**
     * Verarbeitet das nächste Zeichen
     * @param ch nächstes Zeichen
     */
    private void ZeichenBearbeiten(char ch)
    {
        switch (aktuellerZustand)
        {
            case 0:
                Z0(ch);
                break;
            case 1:
                Z1(ch);
                break;
            case 2:
                Z2(ch);
                break;
            case 3:
                Z3(ch);
                break;
            case 4:
                Z4(ch);
                break;
            default:
                aktuellerZustand = -1;
                break;
        }
    }

    /**
     * Prüft, ob die übergebene Zeichenkette einen korrekten einfachen mathematischen Term darstellt.
     * @param text die Zeichenkette
     */
    void TermPrüfen(String text)
    {
        aktuellerZustand = 0;
        speicher.clear();
        for (int i = 0; i < text.length(); i += 1)
        {
            ZeichenBearbeiten(text.charAt(i));
        }
        if (((aktuellerZustand == 1) || (aktuellerZustand == 3)) && (speicher.size() == 0))
        {
            System.out.println("Der Text stellt einen korrekten Term dar");
        }
        else
        {
            System.out.println("Der Text stellt keinen korrekten Term dar");
        }
    }
}
