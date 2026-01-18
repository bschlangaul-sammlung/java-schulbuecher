package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rechenbaum;

class RECHENBAUM
{
    // Attribute
    private String termInPostfixnotation;

    private BAUM rechenbaum;

    private STAPEL stapel;

    /**
     * Konstruktor zum Erzeugen eines leeren Rechenbaumes
     */
    RECHENBAUM()
    {
        rechenbaum = new BAUM();
        stapel = new STAPEL();
    }

    // Methoden
    /**
     * erlaubt die Eingabe eines Terms in Postfixnotation.
     *
     * @param term: Term in Postfixnotation
     */
    void TermInPostfixnationEingeben(String term)
    {
        termInPostfixnotation = term;
    }

    /**
     * wandelt den in Postfixnotation abgespeicherten Term in einen Rechenbaum
     * um. Der Rechenbaum wird als Baum abgespeichert
     */
    void InBaumUmwandeln()
    {
        String term = termInPostfixnotation;
        ZEICHEN z;
        BAUM neuerbaum, teilbaumlinks, teilbaumrechts;
        // Lokale Hilfsvariable für die Abspeicherung des Indexes des momentan
        // betrachteten Zeichens
        // von termInInfixnotation
        int zeichenposition = 0;
        while (zeichenposition < term.length())
        {
            // Momentan untersuchtes Zeichen der Zeichenkette
            // termInPostfixnotation
            char zeichen = term.charAt(zeichenposition);
            zeichenposition = zeichenposition + 1;
            switch (zeichen)
            {
            // Ist das Zeichen eine Operationszeichen, lege es auf den Stapel
            case '+':
            case '-':
            case '/':
            case '*':
                // Erzeuge einen neuen Baum mit der Wurzel, die das Zeichen z
                // verwaltet
                z = new ZEICHEN(zeichen);
                neuerbaum = new BAUM(z);
                // Haenge an den neuen Baum die zwei obersten Teilbaeume, die im
                // Stapel
                // zwischengespeichert sind
                teilbaumrechts = stapel.Entfernen();
                teilbaumlinks = stapel.Entfernen();
                neuerbaum.RechtsEinfuegen(teilbaumrechts);
                neuerbaum.LinksEinfuegen(teilbaumlinks);
                stapel.Einfuegen(neuerbaum);
                break;

            // Ansonsten muss das Zeichen eine Zahl (oder evtl. auch eine
            // Variable) sein...
            default:
                z = new ZEICHEN(zeichen);
                // Erzeuge einen neuen Baum mit der Wurzel, die das Zeichen z
                // verwaltet
                neuerbaum = new BAUM(z);
                // Speichere den Baum im Stapel
                stapel.Einfuegen(neuerbaum);
                break;
            }
        }
        rechenbaum = stapel.Entfernen();
    }

    // Aufgabe 3
    /**
     * macht einen Inorder-Durchlauf durch den Rechenbaum mit Inorder und gibt
     * die Zeichen auf der Konsole aus.
     */
    void TermInInorderAusgeben()
    {
        rechenbaum.InOrder();
        System.out.println();
    }

    /**
     * macht einen Postorder-Durchlauf durch den Rechenbaum mit Inorder und gibt
     * die Zeichen auf der Konsole aus.
     */
    void TermInPostorderAusgeben()
    {
        rechenbaum.PostOrder();
        System.out.println();
    }

    /**
     * macht einen Preorder-Durchlauf durch den Rechenbaum mit Inorder und gibt
     * die Zeichen auf der Konsole aus.
     */
    void TermInPreorderAusgeben()
    {
        rechenbaum.PreOrder();
        System.out.println();
    }
}
