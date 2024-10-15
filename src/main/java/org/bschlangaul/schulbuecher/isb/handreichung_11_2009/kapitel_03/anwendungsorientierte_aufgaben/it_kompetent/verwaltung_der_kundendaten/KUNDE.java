package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

class KUNDE extends DATENELEMENT
{
    // Attribute
    private int kundennummer;

    private String schulname;

    private String software;

    // Konstruktor
    KUNDE(int kundennummer, String schulname, String software)
    {
        this.kundennummer = kundennummer;
        this.schulname = schulname;
        this.software = software;
    }

    /**
     * gibt Information über Kundennummer des Anrufers und Problembeschreibung
     * aus.
     */
    void Ausgeben()
    {
        System.out.println("Kundennummer: " + kundennummer);
        System.out.println("Schulname: " + schulname);
        System.out.println("Eingesetzte Software: " + software);
        System.out.println(
                "----------------------------------------------------");
    }

    /**
     * vergleicht die Kundennummer
     */
    int Vergleichen(DATENELEMENT vergleichsObjekt)
    {
        KUNDE vergleichskunde = (KUNDE) vergleichsObjekt;
        int ergebnis = 0;
        if (kundennummer < vergleichskunde.kundennummer)
            ergebnis = -1;
        if (kundennummer == vergleichskunde.kundennummer)
            ergebnis = 0;
        if (kundennummer > vergleichskunde.kundennummer)
            ergebnis = +1;
        return ergebnis;
    }

    // Zusaetzliche Methoden
    /**
     * erlaubt das ändern des Schulnamens
     */
    void SchulnameAendern(String name)
    {
        schulname = name;
    }
}
