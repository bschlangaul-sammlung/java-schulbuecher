package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_mit_kompositum;

class IT_HOTLINE
{
    // Referenzattribut
    private LISTE anruferschlange;

    // Konstruktor
    IT_HOTLINE()
    {
        anruferschlange = new LISTE();
    }

    /**
     * nimmt die Daten der anrufenden Kunden auf und reiht den Kunden in die
     * Warteschlange ein
     *
     * @param kundennummer Kundennummer und Problemschilderung 'Wir begrüßen Sie
     *     bei der Hotline von IT-Kompetent. Geben Sie bitte Ihre Kundennummer
     *     sowie eine Kurzbeschreibung Ihres Problems an.'
     */
    void DatenAufnehmen(int kundennummer, String problem)
    {
        DATENELEMENT kunde = new ANRUFER(kundennummer, problem);
        anruferschlange.EndeEinfuegen(kunde);
    }

    /**
     * holt nächsten Anrufer aus der Warteschlange und zeigt Informationen auf
     * der Konsole an
     */
    void NaechstenAnruferHolen()
    {
        if (!anruferschlange.IstLeer())
        {
            DATENELEMENT naechster = anruferschlange.AnfangEntfernen();
            naechster.Ausgeben();
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
        System.out.println("Momentane Anzahl der Anrufer in der Warteschleife: "
                + anruferschlange.AnzahlGeben());
        System.out.println(
                "----------------------------------------------------");
    }
}
