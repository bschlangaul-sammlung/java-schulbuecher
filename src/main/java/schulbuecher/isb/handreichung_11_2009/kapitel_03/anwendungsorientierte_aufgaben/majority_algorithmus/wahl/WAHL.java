package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.majority_algorithmus.wahl;

class WAHL
{
    // Attribute
    private STAPEL stapel;

    private UNGEORDNETELISTE stimmzettelliste;

    // Konstruktor
    WAHL()
    {
        stapel = new STAPEL();
        stimmzettelliste = new UNGEORDNETELISTE();
    }

    // Methoden
    /**
     * ermöglicht die Stimmabgabe Die Stimmen werden in einer (ungeordneten)
     * Liste verwaltet
     *
     * @param name Name der gewälten Person
     */
    void StimmeAbgeben(String name)
    {
        DATENELEMENT stimmzettel = new STIMMZETTEL(name);
        stimmzettelliste.Einfuegen(stimmzettel);
    }

    /**
     * wertet die Wahl unter Verwendung des Majority-Algorithmus aus und gibt
     * anschließend den Wahlsieger, sofern es einen gibt, auf der Konsole aus
     */
    void WahlAuswerten()
    {
        // stimmzettelliste wird im Laufe von WahlAuswerten abgebaut. Um die
        // Daten nicht zu
        // verliegen, werden sie in einer anderen Liste zwischengespeichert, die
        // am Ende der Methodenausführung dem Attribut stimmzettelliste wieder
        // zugewiesen wird
        UNGEORDNETELISTE zwischenspeicher = new UNGEORDNETELISTE();
        // Phase 1: Abarbeiten der Stimmzettel und evtl. Ablegen auf dem Stapel
        while (!stimmzettelliste.IstLeer())
        {
            DATENELEMENT aktuelleStimme = stimmzettelliste.Entfernen();
            if (stapel.IstLeer())
            {
                stapel.Einfuegen(aktuelleStimme);
            }
            else
            {
                // Lösung, die nur auf die Methoden Entfernen und Einfügen
                // basiert
                // Die Methode AnfangGeben, die nur das jeweilige Datenelement
                // zurückgibt, ohne das
                // Listen- bzw. Stapelelement zu löschen, wird hier
                // nicht verwendet.
                DATENELEMENT vergleichsstimme = stapel.Entfernen();
                if (aktuelleStimme.Vergleichen(vergleichsstimme))
                {
                    stapel.Einfuegen(vergleichsstimme);
                    stapel.Einfuegen(aktuelleStimme);
                }
            }
            zwischenspeicher.Einfuegen(aktuelleStimme);
        }
        stimmzettelliste = zwischenspeicher;
        // Phase 2: Auswertung des Stapels
        if (stapel.IstLeer())
        {
            System.out.println(
                    "Kein Kandidat erreicht die absolute Mehrheit erreicht!");
        }
        else
        {
            DATENELEMENT vergleichsstimme = stapel.Entfernen();
            int stimmenanzahl = StimmenZaehlen(vergleichsstimme);
            int stimmenInListe = stimmzettelliste.AnzahlGeben();
            if (stimmenanzahl > stimmenInListe / 2)
            {
                System.out.print(
                        "Folgender Kandidat hat die absolute Mehrheit erhalten: ");
                vergleichsstimme.Ausgeben();
                System.out.println();
            }
            else
            {
                System.out.println(
                        "Kein Kandidat erreicht die absolute Mehrheit erreicht!");
            }
        }
    }

    // Stimmenanzahl zu gegebenem Kandidaten in Liste bestimmen
    private int StimmenZaehlen(DATENELEMENT daten)
    {
        return stimmzettelliste.AnzahlMitEigenschaftGeben(daten);
    }
}
