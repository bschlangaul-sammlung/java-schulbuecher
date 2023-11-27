package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_02.morsecode;

class Morsecode
{
    String eingabe;

    int anzahl;

    String ausgabe = "";

    Morsecode()
    {
    }

    String textZuMorsecode(String _eingabe)
    {
        eingabe = _eingabe;
        anzahl = eingabe.length();
        String ausgabe = "";
        for (int i = 0; i < anzahl; i++)
        {
            if (gibZeichen(i) == 'a')
                ausgabe = ausgabe + ".- ";
            if (gibZeichen(i) == 'b')
                ausgabe = ausgabe + "-... ";
            if (gibZeichen(i) == 'c')
                ausgabe = ausgabe + "-.-. ";
            if (gibZeichen(i) == 'd')
                ausgabe = ausgabe + "-.. ";
            if (gibZeichen(i) == 'e')
                ausgabe = ausgabe + ". ";
            if (gibZeichen(i) == 'f')
                ausgabe = ausgabe + "..-. ";
            if (gibZeichen(i) == 'g')
                ausgabe = ausgabe + "--. ";
            if (gibZeichen(i) == 'h')
                ausgabe = ausgabe + ".... ";
            if (gibZeichen(i) == 'i')
                ausgabe = ausgabe + ".. ";
            if (gibZeichen(i) == 'j')
                ausgabe = ausgabe + ".--- ";
            if (gibZeichen(i) == 'k')
                ausgabe = ausgabe + "-.- ";
            if (gibZeichen(i) == 'l')
                ausgabe = ausgabe + ".-.. ";
            if (gibZeichen(i) == 'm')
                ausgabe = ausgabe + "-- ";
            if (gibZeichen(i) == 'n')
                ausgabe = ausgabe + "-. ";
            if (gibZeichen(i) == 'o')
                ausgabe = ausgabe + "--- ";
            if (gibZeichen(i) == 'p')
                ausgabe = ausgabe + ".--. ";
            if (gibZeichen(i) == 'q')
                ausgabe = ausgabe + "--.- ";
            if (gibZeichen(i) == 'r')
                ausgabe = ausgabe + ".-. ";
            if (gibZeichen(i) == 's')
                ausgabe = ausgabe + "... ";
            if (gibZeichen(i) == 't')
                ausgabe = ausgabe + "- ";
            if (gibZeichen(i) == 'u')
                ausgabe = ausgabe + "..- ";
            if (gibZeichen(i) == 'v')
                ausgabe = ausgabe + "...- ";
            if (gibZeichen(i) == 'w')
                ausgabe = ausgabe + ".-- ";
            if (gibZeichen(i) == 'x')
                ausgabe = ausgabe + "-..- ";
            if (gibZeichen(i) == 'y')
                ausgabe = ausgabe + "-.-- ";
            if (gibZeichen(i) == 'z')
                ausgabe = ausgabe + "--.. ";
            if (gibZeichen(i) == 'ä')
                ausgabe = ausgabe + ".-.- ";
            if (gibZeichen(i) == 'ö')
                ausgabe = ausgabe + "---. ";
            if (gibZeichen(i) == 'ü')
                ausgabe = ausgabe + "..-- ";
            if (gibZeichen(i) == ',')
                ausgabe = ausgabe + "--..-- ";
            if (gibZeichen(i) == '.')
                ausgabe = ausgabe + ".-.-.- ";
            if (gibZeichen(i) == '?')
                ausgabe = ausgabe + "..--.. ";
            if (gibZeichen(i) == ' ')
                ausgabe = ausgabe + "/ ";
            //
            // weiter Sonderzeichen und Zahlen können noch ergänzt werden
            //
        }
        return ausgabe;
    }

    // Hilsmethoden
    // gibZeichen gibt das n-te Zeichen beginnend mit 0 der Eingabe zurück
    char gibZeichen(int n)
    {
        return eingabe.charAt(n);
    }

    // gibZeichen gibt das n-te Morsezeichen beginnend mit 0 der Eingabe zurück
    String gibMorsezeichen(int n)
    {
        String[] out = eingabe.split(" ");
        return out[n];
    }
}
