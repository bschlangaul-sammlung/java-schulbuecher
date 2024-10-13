package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.rangierbahnhof.handreichung;

public class RANGIERBAHNHOF
{
    // Attribute
    private STAPEL gleis1, gleis2, gleis3;

    // Konstruktor
    RANGIERBAHNHOF()
    {
        // Erzeugung der Gleise
        gleis1 = new STAPEL();
        gleis2 = new STAPEL();
        gleis3 = new STAPEL();
        // Belegung des Gleises A mit TestWaggon
        NeuenWaggonAufGleis1Stellen(1, 'E', 3);
        NeuenWaggonAufGleis1Stellen(2, 'F', 2);
        NeuenWaggonAufGleis1Stellen(4, 'I', 3);
        NeuenWaggonAufGleis1Stellen(3, 'I', 2);
        NeuenWaggonAufGleis1Stellen(7, 'F', 3);
    }

    // Methoden
    /**
     * erzeugt einen neuen Waggon (mit übergebenen Attributwerten) und setzt ihn
     * auf Gleis 1
     */
    void NeuenWaggonAufGleis1Stellen(int waggonnummer, char waggontyp,
            int zielgleis)
    {
        WAGGON waggon = new WAGGON(waggonnummer, waggontyp, zielgleis);
        gleis1.Einfuegen(waggon);
    }

    /**
     * gibt die aktuelle Belegung aller drei Gleise aus
     */
    void AktuelleGleisbelegungGeben()
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
     * führt den Rangiervorgang aus Dabei muss nur überprüft werden, aus welches
     * Zielgleis der Waggon gesetzt werden soll.
     */
    void Rangieren()
    {
        WAGGON rangierterWaggon;
        while (!gleis1.IstLeer())
        {
            rangierterWaggon = (WAGGON) gleis1.Entfernen();
            if (rangierterWaggon.ZielgleisGeben() == 2)
            {
                gleis2.Einfuegen(rangierterWaggon);
            }
            else
            {
                gleis3.Einfuegen(rangierterWaggon);
            }
        }
        AktuelleGleisbelegungGeben();
    }

    /**
     * gibt die Anzahl der Waggons auf dem gewüschten Gleis aus Dabei muss nur
     * überprüft werden, aus welches Zielgleis der Waggon gesetzt werden soll.
     * Aufgabe c i
     *
     * @param gleisnummer Gleisnummer des Gleises, dessen Waggonanzahl bestimmt
     *     werden soll.
     */
    void AnzahlWaggonGeben(int gleisnummer)
    {
        int anzahl = 0;
        switch (gleisnummer)
        {
        case 1:
            anzahl = gleis1.AnzahlGeben();
            break;

        case 2:
            anzahl = gleis2.AnzahlGeben();
            break;

        case 3:
            anzahl = gleis3.AnzahlGeben();
            break;

        // Fehlerfall:
        default:
            anzahl = -1;
        }
        System.out.println("Gleis " + gleisnummer + ": " + anzahl + " Waggons");
    }

    /**
     * sucht einen Waggon mit der gewüschten Waggonnummer und gibt ggf. die
     * Nummer des Gleises aus, auf dem dieser Waggon steht Die Methode nutzt
     * Methode Suchen von STAPEL bzw. LISTE Aufgabe c ii
     *
     * @param waggonnummer Nummer des gesuchten Waggons
     */
    void WaggonSuchen(int waggonnummer)
    {
        WAGGON waggon = new WAGGON(waggonnummer, '0', -1);
        if (gleis1.Suchen(waggon))
        {
            System.out.println("Gesuchter Waggon " + waggonnummer
                    + " befindet sich auf Gleis 1");
        }
        else
        {
            if (gleis2.Suchen(waggon))
            {
                System.out.println("Gesuchter Waggon " + waggonnummer
                        + " befindet sich auf Gleis 2");
            }
            else
            {
                if (gleis3.Suchen(waggon))
                {
                    System.out.println("Gesuchter Waggon " + waggonnummer
                            + " befindet sich auf Gleis 3");
                }
                else
                {
                    System.out.println("Gesuchter Waggon " + waggonnummer
                            + " ist nicht vorhanden!");
                }
            }
        }
    }

    /**
     * bestimmt die Anzahl der Waggons des vorgegebenen Typs auf einem
     * bestimmten Gleis Aufgabe c iii
     *
     * @param gleisnummer Nummer des Gleises, das untersucht werden soll und Typ
     *     der gesuchten Waggons
     */
    void AnzahlWaggontypGeben(int gleisnummer, char typ)
    {
        int anzahl = 0;
        WAGGON waggon = new WAGGON(-1, typ, 0);
        switch (gleisnummer)
        {
        case 1:
            anzahl = gleis1.AnzahlmitEigenschaftGeben(waggon);
            break;

        case 2:
            anzahl = gleis2.AnzahlmitEigenschaftGeben(waggon);
            break;

        case 3:
            anzahl = gleis3.AnzahlmitEigenschaftGeben(waggon);
            break;

        // Fehlerfall:
        default:
            anzahl = -1;
        }
        System.out.println("Gleis " + gleisnummer + ": " + anzahl
                + " Waggons vom Typ " + typ);
    }
}
