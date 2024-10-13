package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_08;

/**
 * Klasse zur Implementierung des Brute-Force-Algorithmus zum Passwortknacken
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class BruteForce
{
    private char[] zeichenvorrat;

    private int maxlen;

    private Fenster f;

    private String passwort;

    private boolean gefunden;

    private boolean abgebrochen;

    private long startNanoTime;

    /**
     * Konstruktor der Klasse BRUTEFORCE
     *
     * @param zeichenvorratNeu gewünschtes Alphabet
     * @param maxlenNeu maximale Passwortlänge
     * @param passwortNeu gesuchtes Passwort
     * @param fNeu Fenster
     */
    public BruteForce(char[] zeichenvorratNeu, int maxlenNeu,
            String passwortNeu, Fenster fNeu)
    {
        zeichenvorrat = zeichenvorratNeu;
        maxlen = maxlenNeu;
        f = fNeu;
        passwort = passwortNeu;
        gefunden = false;
    }

    /**
     * Startet den Brute-Force-Angriff
     */
    public void Attacke()
    {
        startNanoTime = System.nanoTime();
        NextString("");
    }

    /**
     * Untersucht alle Passwörter bis zur gewünschten Länge Ausgehend vom Wert
     * des Parameters werden jeweils die Buchstaben des Alphabets angehängt und
     * darauf getestet, ob der entstandene String identisch mit dem Passwort
     * sind. Für den entstandenen String erfolgt der rekursive Aufruf der
     * Methode.
     *
     * @param s Ausgangsstring
     */
    private void NextString(String s)
    {
        int i = 0;
        while (i < zeichenvorrat.length && !gefunden && !abgebrochen)
        {
            String sneu;
            sneu = s + new Character(zeichenvorrat[i]).toString();
            if (sneu.equals(passwort))
            {
                gefunden = true;
                f.ErgebnisSetzen(sneu, System.nanoTime() - startNanoTime);
                return;
            }
            if (sneu.length() <= maxlen - 1)
            {
                NextString(sneu);
            }
            i++;
        }
    }
}
