package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.ueberblick_durch_sortierung;

class IT_HOTLINE
{
    // Referenzattribut
    private LISTE anruferschlange;

    private LISTE kundendaten;

    // Konstruktor
    IT_HOTLINE()
    {
        anruferschlange = new LISTE();
        kundendaten = new LISTE();
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
        kundendaten.EndeEinfuegen(kunde);
    }

    /**
     * dient zum Löschen eines Kunden, der anhand der Kundennummer identifiziert
     * wird
     *
     * @param kundennummer Kundennummer
     */
    void KundenLoeschen(int kundennummer)
    {
        DATENELEMENT kunde = new KUNDE(kundennummer, "", "");
        kundendaten.Entfernen(kunde);
    }

    /**
     * dient zum Suchen eines Kunden (-Objekts) über die Kundennummer Der Kunde
     * muss dabei nicht unbedingt vorhanden sein
     *
     * @param kundennummer Kundennummer
     *
     */
    void KundendatenAusgeben(int kundennummer)
    {
        KUNDE vergleichskunde = new KUNDE(kundennummer, "", "");
        KUNDE k = (KUNDE) kundendaten.DatenSuchen(vergleichskunde);
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
        KUNDE k = (KUNDE) kundendaten.DatenSuchen(vergleichskunde);
        k.SchulnameAendern(neuerSchulname);
    }

    // Aufgabe 3
    /**
     * sortiert die ungeordneten Kundendaten in eine sortierte Liste ein
     */
    private LISTE KundendatenSortieren()
    {
        LISTE kundendatenGeordnet = new LISTE();
        LISTE temporaereListe = kundendaten;
        while (temporaereListe.AnzahlGeben() > 0)
        {
            DATENELEMENT k = temporaereListe.AnfangEntfernen();
            kundendatenGeordnet.SortiertEinfuegen(k);
        }
        return kundendatenGeordnet;
    }

    /**
     * gibt eine nach der Kundennummer geordnete Liste mit den Kundendaten aus
     */
    void GesamteKundendatenGeordnetAusgeben()
    {
        LISTE geordneteListe = KundendatenSortieren();
        geordneteListe.AlleAusgeben();
    }
}
