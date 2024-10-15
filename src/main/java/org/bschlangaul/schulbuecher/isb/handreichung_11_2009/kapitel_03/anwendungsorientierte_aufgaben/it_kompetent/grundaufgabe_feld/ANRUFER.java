package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.it_kompetent.grundaufgabe_feld;

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

    // Methoden
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
}
