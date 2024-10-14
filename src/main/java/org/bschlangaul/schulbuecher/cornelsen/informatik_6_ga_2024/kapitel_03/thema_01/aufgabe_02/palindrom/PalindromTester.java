package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_02.palindrom;

/**
 * Rahmenklasse für die Methode Palindromtest
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class PalindromTester
{

    /**
     * Prüft, ob der gegebene Text ein Palindrom ist.
     *
     * @param text der zu prüfende Text
     *
     * @return wahr, wenn der text ein Palindrom ist
     */
    static boolean Palindromtest(String text)
    {
        if (text.length() <= 1)
        {
            return true;
        }
        else if (text.charAt(0) != text.charAt(text.length() - 1))
        {
            return false;
        }
        else
        {
            return Palindromtest(text.substring(1, text.length() - 1));
        }
    }
}
