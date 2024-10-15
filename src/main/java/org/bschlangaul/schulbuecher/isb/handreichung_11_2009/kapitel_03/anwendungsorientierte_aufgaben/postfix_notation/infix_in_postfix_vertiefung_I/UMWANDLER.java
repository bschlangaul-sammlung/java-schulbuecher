package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.postfix_notation.infix_in_postfix_vertiefung_I;
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
     * Umwandlung des in termInInfixnotation abgespeicherten Terms in die
     * Postfix-Notation und Abspeicherung des Ergebnisses in
     * termInPostfixnotation Berüsichtigt ist nun der Rang des Rechenzeichens,
     * d.h. Punkt vor Strich und gleichwertige Rechenzeichen von links nach
     * rechts
     */
    void InInfixnotationUmwandeln()
    {
        String term = termInInfixnotation;
        termInPostfixnotation = "";
        ZEICHEN z, oberstesZeichen;
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

            case '+':
            case '-':
            case '/':
            case '*':
                // Falls der Stapel leer ist...
                if (stapel.IstLeer())
                {
                    z = new ZEICHEN(zeichen);
                    stapel.Einfuegen(z);
                }
                else
                {
                    // Falls der Rang von zeichen hoeher ist ...
                    if (RechenzeichenrangIstHoeher(zeichen))
                    {
                        z = new ZEICHEN(zeichen);
                        stapel.Einfuegen(z);
                    }
                    else
                    {
                        // Falls das oberste Zeichen ein Rechenzeichen ist ...
                        if (OberstesZeichenIstRechenzeichen())
                        {
                            oberstesZeichen = (ZEICHEN) stapel.Entfernen();
                            termInPostfixnotation = termInPostfixnotation
                                    + oberstesZeichen.WertGeben();
                        }
                        // Solange das oberste Zeichen ein hoeherrangiges
                        // Rechenzeichen ist ...
                        while (!stapel.IstLeer()
                                && !RechenzeichenrangIstHoeher(zeichen)
                                && OberstesZeichenIstRechenzeichen())
                        {
                            oberstesZeichen = (ZEICHEN) stapel.Entfernen();
                            termInPostfixnotation = termInPostfixnotation
                                    + oberstesZeichen.WertGeben();
                        }
                        // Rang von zeichen ist nun hoeher
                        z = new ZEICHEN(zeichen);
                        stapel.Einfuegen(z);
                    }
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
     * Zeichen, das ganz oben auf dem Stapel liegt Es handelt sich um eine
     * interne Hilfsmethode Es wird ebenfalls true zurückgegeben, wenn der
     * Stapel leer ist, weil das auch als Höherrangigkeit des übergebenen
     * Rechenzeichens interpretiert werden kann Die Methode ist private gesetzt,
     * da sie nur zur interne Prüfung notwendig ist
     *
     * @param zeichen das eingelesene Rechenzeichen
     */
    private boolean RechenzeichenrangIstHoeher(char zeichen)
    {
        ZEICHEN oberstesElement = (ZEICHEN) stapel.OberstesDatenelementGeben();
        // falls zeichen * oder / und das oberste Element + und -, liegt
        // Hoeherrangigkeit vor,
        // ansonsten nicht
        return ((zeichen == '*' || zeichen == '/')
                && (oberstesElement.WertGeben() == '+'
                        || oberstesElement.WertGeben() == '-'));
    }

    /**
     * prüft, ob das oberste Zeichen des Stapels ein Rechenzeichen oder nicht
     * (d.h. es muss sich dann um eine Klammer handeln) ist Es handelt sich um
     * eine interne Hilfsmethode
     */
    private boolean OberstesZeichenIstRechenzeichen()
    {
        ZEICHEN oberstesElement = (ZEICHEN) stapel.OberstesDatenelementGeben();
        switch (oberstesElement.WertGeben())
        {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;

        default:
            return false;
        }
    }

    /**
     * Ausgabe des Umwandlungsergebnisses
     */
    private void ErgebnisAusgeben()
    {
        System.out
                .println(termInInfixnotation + " --> " + termInPostfixnotation);
    }
}
