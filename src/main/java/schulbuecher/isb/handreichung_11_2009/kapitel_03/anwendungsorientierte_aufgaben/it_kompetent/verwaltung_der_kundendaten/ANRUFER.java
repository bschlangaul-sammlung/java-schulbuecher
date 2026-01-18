package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.verwaltung_der_kundendaten;

class ANRUFER extends DATENELEMENT
{
    // Attribute
    private int kundennummer;

    private String problembeschreibung;

    // Konstruktor
    ANRUFER(int kundennummer, String problem)
    {
        this.kundennummer = kundennummer;
        problembeschreibung = problem;
    }

    /**
     * gibt Information über Kundennummer des Anrufers und Problembeschreibung
     * aus.
     */
    void Ausgeben()
    {
        System.out.println("Kundennummer: " + kundennummer);
        System.out.println("Problembeschreibung: " + problembeschreibung);
        System.out.println(
                "----------------------------------------------------");
    }

    /**
     * vergleicht die Kundennummer
     */
    int Vergleichen(DATENELEMENT vergleichsObjekt)
    {
        ANRUFER vergleichskunde = (ANRUFER) vergleichsObjekt;
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
     * gibt die Kundennummer zurück
     */
    int KundennummerGeben()
    {
        return kundennummer;
    }
}
