package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_feld;

class IT_HOTLINE
{
    // Referenzattribute
    private DATENELEMENT[] anruferschlange;

    // Hilfsattribut: Erleichtert den Umgang mit dem Feld, da damit das erste
    // freie Element leicht
    // ermittelt werden kann.
    private int anzahlAnrufer;

    // Konstruktor
    IT_HOTLINE(int feldgroesse)
    {
        anruferschlange = new ANRUFER[feldgroesse];
    }

    /**
     * nimmt die Daten der anrufenden Kunden auf und reiht den Kunden in die
     * Warteschlange ein
     *
     * @param kundennummer Kundennummer und Problemschilderung 'Wir begrüßen Sie
     *     bei der Hotline von IT-Kompetent. Geben Sie bitte Ihre Kundennummer
     *     sowie eine Kurzbeschreibung Ihres Problems an.'
     */
    void DatenAufnehmen(int kundennummer, String problembeschreibung)
    {
        if (anzahlAnrufer < anruferschlange.length)
        {
            DATENELEMENT kunde = new ANRUFER(kundennummer, problembeschreibung);
            anruferschlange[anzahlAnrufer] = kunde;
            anzahlAnrufer = anzahlAnrufer + 1;
        }
        else
        {
            System.out.println("Die Hotline ist zur Zeit leider überlastet!");
        }
    }

    /**
     * holt nächsten Anrufer aus der Warteschlange und zeigt Informationen auf
     * der Konsole an
     */
    void NaechstenAnruferHolen()
    {
        if (anzahlAnrufer > 0)
        {
            DATENELEMENT naechster = anruferschlange[0];
            naechster.Ausgeben();
            // Vorrücken der restlichen Anrufer: Jeder Anrufer rückt um eine
            // Position nach vorne.
            // Das ist ein Nachteil des Feldes!
            for (int i = 1; i < anzahlAnrufer; i = i + 1)
            {
                anruferschlange[i] = anruferschlange[i - 1];
            }
            anzahlAnrufer = anzahlAnrufer - 1;
        }
        else
        {
            System.out
                    .println("Derzeit sind keine Anrufer in der Warteschleife");
            System.out.println(
                    "----------------------------------------------------");
        }
    }

    /**
     * bestimmt die Anzahl der Anrufer, die sich momentan in der Warteschlange
     * befinden und zeigt diese auf der Konsole an
     */
    void AnzahlDerAnruferHolen()
    {
        // Das ist hier wegen des Attributs anzahlAnrufer natürlich einfach
        System.out.println("Momentane Anzahl der Anrufer in der Warteschleife: "
                + anzahlAnrufer);
        System.out.println(
                "----------------------------------------------------");
    }
}
