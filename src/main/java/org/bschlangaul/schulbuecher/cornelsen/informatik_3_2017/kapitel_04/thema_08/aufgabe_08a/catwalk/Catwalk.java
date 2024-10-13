package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_08a.catwalk;

/**
 * Klasse zur Beschreibung des Catwalks
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Catwalk
{
    /**
     * Die Leuchten
     */
    Rechteck[] leuchten;

    /**
     * Die zur Verfügung stehenden Farben
     */
    String[] farben;

    /**
     * Größe einer Leuchte
     */
    final int breite = 40;

    /**
     * Anzahl der Leuchten
     */
    final int spaltenanzahl = 10;

    /**
     * Der Konstruktor des Catwalks legt die Leuchten an
     */
    Catwalk()
    {
        leuchten = new Rechteck[spaltenanzahl];
        farben = new String[spaltenanzahl];
        String farbe;
        farbe = "blau";
        for (int spalte = 0; spalte < spaltenanzahl; spalte = spalte + 1)
        {
            leuchten[spalte] = new Rechteck();
            leuchten[spalte].GrößeSetzen(breite, breite);
            leuchten[spalte].PositionSetzen(40 + spalte * breite, 50);
            if (farbe == "blau")
            {
                farbe = "rot";
            }
            else
            {
                farbe = "blau";
            }
            FarbeSetzen(spalte, farbe);
            farben[spalte] = farbe;
        }
    }

    /**
     * Setzt die angegebene Leuchte auf die gewünschte Farbe
     *
     * @param spalte die Spaltennummer der Leuchte
     * @param farbe die gewünschte Farbe
     */
    void FarbeSetzen(int spalte, String farbe)
    {
        leuchten[spalte].FarbeSetzen(farbe);
        farben[spalte] = farbe;
    }

    /**
     * Gibt die Farbe der angegebene Leuchte
     *
     * @param spalte die Spaltennummer der Leuchte
     *
     * @return die Farbe der gewünschten Leuchte
     */
    String FarbeGeben(int spalte)
    {
        return farben[spalte];
    }

    /**
     * Meldet die Anzahl der Leuchten
     *
     * @return Leuchtenanzahl
     */
    int SpaltenanzahlGeben()
    {
        return spaltenanzahl;
    }
}
