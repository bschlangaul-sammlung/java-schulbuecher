package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix_vorfahrtregeln;
// Grundaufgabe: Rechenterm-Umwandlung Infix-Notation --> Postfix-Notation

// Vertiefungsaufgabe: Ausrechnen eines Terms in Postfix-Notation
class UMWANDLER
{
    // Attribute
    private String termInInfixnotation;

    private String termInPostfixnotation;

    private STAPEL stapel;

    // Konstruktor
    UMWANDLER()
    {
        stapel = new STAPEL();
    }

    // Methoden
    /**
     * Eingabe eines Terms als String in Infix-Notation Aus Einfachheitsgründen
     * sind nur die Zahlen 0 bis 9 bzw. einbuchstabige Variablen zulässig!
     *
     * @param term Term in Infix-Notation
     *
     */
    void TermInInfixNotationEingeben(String term)
    {
        termInInfixnotation = term;
    }

    /**
     * Eingabe eines Terms als String in Postfix-Notation Aus
     * Einfachheitsgründen sind nur die Zahlen 0 bis 9 bzw. einbuchstabige
     * Variablen zulässig! Methode ist nützlich bei Vertiefungsaufgabe 2
     *
     * @param term Term in Postfix-Notation
     */
    void TermInPostfixnotationEingeben(String term)
    {
        termInPostfixnotation = term;
    }

    /**
     * Umwandlung des in termInInfixnotation abgespeicherten Terms in die
     * Postfix-Notation und Abspeicherung des Ergebnisses in
     * termInPostfixnotation
     */
    void UmwandelnInInfixnotation()
    {
        String term = termInInfixnotation;
        termInPostfixnotation = "";
        ZEICHEN z;
        // Lokale Hilfsvariable für die Abspeicherung des Indexes des momentan
        // betrachteten Zeichens
        // von termInInfixnotation
        int zeichenposition = 0;
        while (zeichenposition < term.length())
        {
            // Momentan untersuchtes Zeichen der Zeichenkette
            // term_in_infixnotation
            char zeichen = term.charAt(zeichenposition);
            zeichenposition = zeichenposition + 1;
            switch (zeichen)
            {
            // Ist das Zeichen eine öffnende Klammer, lege es auf den Stack
            case '(':
                z = new ZEICHEN(zeichen);
                stapel.Einfuegen(z);
                break;

            // Ist das Zeichen ein Rechenzeichen ...
            case '+':
            case '-':
            case '/':
            case '*':
                // und der Stapel leer ODER das Zeichen von hoeherem Rang als
                // das oberste
                // Zeichen auf dem Stapel
                if (RechenzeichenIstHoeher(zeichen) || stapel.IstLeer())
                {
                    z = new ZEICHEN(zeichen);
                    stapel.Einfuegen(z);
                }
                else
                {
                    // und das Zeichen von gleichem oder niedrigerem Rang als
                    // das oberste
                    // Zeichen auf dem Stapel
                    z = (ZEICHEN) stapel.Entfernen();
                    termInPostfixnotation = termInPostfixnotation + z;
                    while (!RechenzeichenIstHoeher(zeichen))
                    {
                        z = (ZEICHEN) stapel.Entfernen();
                        termInPostfixnotation = termInPostfixnotation + z;
                    }
                    z = new ZEICHEN(zeichen);
                    stapel.Einfuegen(z);
                }
                break;

            // Ist das Zeichen eine schließende Klammer, so nimm solange Zeichen
            // vom Stack und
            // hänge sie an die Zeichenkette term_in_postfixnotation, bis eine
            // öffende Klammer
            // oben auf dem Stack liegt
            case ')':
                z = (ZEICHEN) stapel.Entfernen();
                while (z.WertGeben() != '(')
                {
                    termInPostfixnotation = termInPostfixnotation
                            + z.WertGeben();
                    z = (ZEICHEN) stapel.Entfernen();
                }
                break;

            // Ansonsten muss das Zeichen eine Zahl oder eine Variable sein...
            default:
                termInPostfixnotation = termInPostfixnotation + zeichen;
                break;
            }
        }
        // Leeren des Stapels
        while (!stapel.IstLeer())
        {
            z = (ZEICHEN) stapel.Entfernen();
            termInPostfixnotation = termInPostfixnotation + z.WertGeben();
        }
        ErgebnisAusgeben();
    }

    /**
     * prüft, ob das übergebene Rechenzeichen einen höheren Rang hat als das
     * Zeichen, das ganz oben auf dem Stapel liegt Die Methode ist sehr kurz,
     * wenn man mit logischen operatoren arbeitet
     *
     * @param zeichen das eingelesene Rechenzeichen
     */
    private boolean RechenzeichenIstHoeher(char zeichen)
    {
        ZEICHEN oberstesElement = (ZEICHEN) stapel.OberstesDatenelementGeben();
        if (oberstesElement == null)
        {
            return true;
        }
        else
        {
            return ((zeichen == '*' || zeichen == '/')
                    && (oberstesElement.WertGeben() == '+'
                            || oberstesElement.WertGeben() == '-'));
        }
    }

    /**
     * Ausgabe des Umwandlungsergebnisses
     */
    void ErgebnisAusgeben()
    {
        System.out
                .println(termInInfixnotation + " --> " + termInPostfixnotation);
    }
}
