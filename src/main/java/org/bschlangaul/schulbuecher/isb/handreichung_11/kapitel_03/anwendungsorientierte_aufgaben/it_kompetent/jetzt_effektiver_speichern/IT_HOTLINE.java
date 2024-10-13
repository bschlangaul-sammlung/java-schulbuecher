package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.jetzt_effektiver_speichern;

class IT_HOTLINE
{
    // Referenzattribut
    private LISTE anruferschlange;

    private BAUM kundendaten;

    // Konstruktor
    IT_HOTLINE()
    {
        anruferschlange = new LISTE();
        kundendaten = new BAUM();
        // Spieldaten
        NeuenKundenAufnehmen(1, "Gymnasium Passau", "Windols");
        NeuenKundenAufnehmen(78, "Gymnasium München", "Linus");
        NeuenKundenAufnehmen(4, "Gymnasium Nürnberg", "Linus II");
        NeuenKundenAufnehmen(19, "Gymnasium Vilshofen", "Windols");
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
        DATENELEMENT anrufer = new ANRUFER(kundennummer, problem);
        anruferschlange.EndeEinfuegen(anrufer);
    }

    /**
     * holt nächsten Anrufer aus der Warteschlange und zeigt Informationen auf
     * der Konsole an Zu den Informationen gehören (im Vergleich zu
     * Aufgabenvorschlag 1) nicht nur die Anruferdaten, sondern auch die
     * Kundendaten!
     */
    void NaechstenAnruferHolen()
    {
        ANRUFER naechster = (ANRUFER) anruferschlange.AnfangEntfernen();
        if (naechster != null)
        {
            naechster.Ausgeben();
            int kdnr = naechster.KundennummerGeben();
            System.out.println("Im System abgespeicherte Kundendaten: ");
            KundendatenAusgeben(kdnr);
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

    // Aufgabe 2: Plege der Kundendaten
    /**
     * dient zum Aufnehmen eines neuen Kunden
     *
     * @param kundennummer Kundennummer, Scbhulname und eingesetzte Software
     */
    void NeuenKundenAufnehmen(int kundennummer, String schulname,
            String software)
    {
        DATENELEMENT kunde = new KUNDE(kundennummer, schulname, software);
        kundendaten.Einfuegen(kunde);
    }

    /**
     * dient zum Suchen eines Kunden (-Objekts) über die Kundennummer Der Kunde
     * muss dabei nicht unbedingt vorhanden sein
     *
     * @param kundennummer Kundennummer
     */
    void KundendatenAusgeben(int kundennummer)
    {
        KUNDE vergleichskunde = new KUNDE(kundennummer, "", "");
        KUNDE k = (KUNDE) kundendaten.Suchen(vergleichskunde);
        if (k == null)
        {
            System.out.println("Kunde ist nicht im System gespeichert!");
        }
        else
        {
            k.Ausgeben();
        }
    }

    /**
     * dient zum ändern des Schulnamen eines Kunden mit bestimmter Kundennummer
     * Aus Einfachheitsgründen wird davon ausgegangen, dass der durch die
     * übergebene Kundennummer festgelegte Kunde existiert
     *
     * @param kundennummer Kundennummer
     */
    void SchulnameAendern(int kundennummer, String neuerSchulname)
    {
        KUNDE vergleichskunde = new KUNDE(kundennummer, "", "");
        KUNDE k = (KUNDE) kundendaten.Suchen(vergleichskunde);
        k.SchulnameAendern(neuerSchulname);
    }

    /**
     * gibt die Kundendaten nach der Kundennummer geordnet aus es muss nur der
     * inorder-Durchlauf genutzt werden.
     */
    void GesamteKundendatenGeordnetAusgeben()
    {
        kundendaten.InOrder();
    }
}
