package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_08;

/**
 * Controller-Klasse
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Controller
{
    private BruteForce b;

    @SuppressWarnings("unused")
    private Fenster f;

    /**
     * Konstruktor erzeugt das Eingabealphabet wie gewünscht. Leitet die Werte
     * an das BRUTEFORCE-Objekt weiter und startet die Attacke.
     */
    public Controller(String alphabet, String length, String passwort,
            Fenster f_neu)
    {
        f = f_neu;
        char[] zeichenvorrat;
        if (alphabet.equals("a..z"))
        {
            char[] zeichenvorrat2 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z' };
            zeichenvorrat = zeichenvorrat2;
        }
        else
        {
            if (alphabet.equals("a..z A..Z"))
            {
                char[] zeichenvorrat2 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                        's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
                        'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                        'Z' };
                zeichenvorrat = zeichenvorrat2;
            }
            else
            {
                if (alphabet.equals("a..z 0..9"))
                {
                    char[] zeichenvorrat2 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
                            '1', '2', '3', '4', '5', '6', '7', '8', '9' };
                    zeichenvorrat = zeichenvorrat2;
                }
                else
                {
                    if (alphabet.equals("a..z A..Z 0..9"))
                    {
                        char[] zeichenvorrat2 = { 'a', 'b', 'c', 'd', 'e', 'f',
                                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                                'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                                'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                                '8', '9' };
                        zeichenvorrat = zeichenvorrat2;
                    }
                    else
                    {
                        char[] zeichenvorrat2 = { 'a', 'b', 'c', 'd', 'e', 'f',
                                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                                'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                                'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                                '8', '9', '!', '"', '§', '$', '%', '&', '/',
                                '(', ')', '=', '?', '*', '+', '#', '-', '_',
                                '.', ':', ';', ',' };
                        zeichenvorrat = zeichenvorrat2;
                    }
                }
            }
        }
        int laenge = Integer.parseInt(length);
        b = new BruteForce(zeichenvorrat, laenge, passwort, f_neu);
        b.Attacke();
    }
}
