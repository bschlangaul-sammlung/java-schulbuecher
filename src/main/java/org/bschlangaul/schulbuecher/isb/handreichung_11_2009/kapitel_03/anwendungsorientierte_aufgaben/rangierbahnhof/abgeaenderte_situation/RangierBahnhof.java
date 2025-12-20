package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.abgeaenderte_situation;

class RangierBahnhof
{
    // Attribute
    private Stapel gleis1, gleis2, gleis3;

    // Konstruktor
    RangierBahnhof()
    {
        // Erzeugung der Gleise
        gleis1 = new Stapel();
        gleis2 = new Stapel();
        gleis3 = new Stapel();
        // Belegung des Gleises A mit Waggons
        WaggonAufstellen(3);
        WaggonAufstellen(2);
        WaggonAufstellen(1);
        WaggonAufstellen(4);
    }

    // Methoden
    /**
     * erzeugt einen neuen Waggon mit der gewüschten Nummer (im sortierten Zug)
     * setzt ihn auf Gleis 1
     *
     * @param nummer gewüschten Nummer (im sortierten Zug von der Lok aus
     *     gesehen)
     */
    void WaggonAufstellen(int nummer)
    {
        DatenElement waggon = new Waggon(nummer);
        gleis1.Einfuegen(waggon);
    }

    /**
     * gibt die aktuelle Belegung aller drei Gleise aus
     */
    void AktuelleSituationGeben()
    {
        System.out.print("Gleis 1: ");
        gleis1.AlleAusgeben();
        System.out.println();
        System.out.print("Gleis 2: ");
        gleis2.AlleAusgeben();
        System.out.println();
        System.out.print("Gleis 3: ");
        gleis3.AlleAusgeben();
        System.out.println();
        System.out.println(
                "--------------------------------------------------------------");
    }

    /**
     * führt den Rangiervorgang nach dem ersten Algorithmus aus Aufgabe
     * 'Rangierbahnhof - Abgeäderte Situation'aus
     */
    void Rangieren()
    {
        int anzahlschritte = 0;
        DatenElement waggon;
        while (!gleis1.IstLeer())
        {
            while (!gleis1.IstLeer())
            {
                if (gleis3.IstLeer())
                {
                    waggon = gleis1.Entfernen();
                    gleis3.Einfuegen(waggon);
                }
                else
                {
                    if (gleis1.AnfangGeben()
                            .SchluesselIstKleiner(gleis3.AnfangGeben()))
                    {
                        waggon = gleis1.Entfernen();
                        gleis3.Einfuegen(waggon);
                    }
                    else
                    {
                        waggon = gleis3.Entfernen();
                        gleis2.Einfuegen(waggon);
                    }
                }
                AktuelleSituationGeben();
                anzahlschritte = anzahlschritte + 1;
            }
            // Gleis 1 leer und Gleis 2 nicht leer --> Verschiebe alle Waggons
            // von Gleis 2 auf Gleis
            // 1
            while (!gleis2.IstLeer())
            {
                waggon = gleis2.Entfernen();
                gleis1.Einfuegen(waggon);
                AktuelleSituationGeben();
                anzahlschritte = anzahlschritte + 1;
            }
        }
        System.out.println("Anzahl der Rangierschritte: " + anzahlschritte);
    }

    /**
     * führt den Rangiervorgang nach dem optimierten Algorithmus aus Aufgabe
     * 'Rangierbahnhof - Abgeäderte Situation'aus
     */
    void RangierenBesser()
    {
        int anzahlschritte = 0;
        DatenElement waggon;
        Stapel startgleis = gleis1;
        // Hilfsvariable zum Vertauschen zweier Werte
        Stapel hilfsgleis = gleis2;
        while (!startgleis.IstLeer())
        {
            while (!startgleis.IstLeer())
            {
                if (gleis3.IstLeer())
                {
                    waggon = startgleis.Entfernen();
                    gleis3.Einfuegen(waggon);
                }
                else
                {
                    if (startgleis.AnfangGeben()
                            .SchluesselIstKleiner(gleis3.AnfangGeben()))
                    {
                        waggon = startgleis.Entfernen();
                        gleis3.Einfuegen(waggon);
                    }
                    else
                    {
                        waggon = gleis3.Entfernen();
                        hilfsgleis.Einfuegen(waggon);
                    }
                }
                AktuelleSituationGeben();
                anzahlschritte = anzahlschritte + 1;
            }
            if (!hilfsgleis.IstLeer())
            {
                Stapel tausch = hilfsgleis;
                hilfsgleis = startgleis;
                startgleis = tausch;
            }
        }
        System.out.println("Anzahl der Rangierschritte: " + anzahlschritte);
    }
}
