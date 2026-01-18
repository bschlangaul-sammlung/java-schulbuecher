package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_07.abiturparty;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Klasse zur Beschreibung des Dancefloors
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Dancefloor
{
    /**
     * Die Leuchten
     */
    Rechteck[][] leuchten;

    /**
     * Die zur Verfügung stehenden Farben
     */
    String[][] farben;

    /**
     * Größe einer Leuchte
     */
    final int breite = 40;

    /**
     * Anzahl der Leuchten pro Spalte
     */
    final int spaltenanzahl = 19;

    /**
     * Anzahl der Leuchten pro Zeile
     */
    final int zeilenanzahl = 19;

    /**
     * Konstruktor des Dancefloors legt die Leuchten an
     */
    Dancefloor()
    {
        leuchten = new Rechteck[spaltenanzahl][zeilenanzahl];
        farben = new String[spaltenanzahl][zeilenanzahl];
        String farbe;
        farbe = "blau";
        for (int spalte = 0; spalte < spaltenanzahl; spalte = spalte + 1)
        {
            for (int zeile = 0; zeile < zeilenanzahl; zeile = zeile + 1)
            {
                leuchten[spalte][zeile] = new Rechteck();
                leuchten[spalte][zeile].GrößeSetzen(breite, breite);
                leuchten[spalte][zeile].PositionSetzen(spalte * breite,
                        zeile * breite);
                if (farbe == "blau")
                {
                    farbe = "rot";
                }
                else
                {
                    farbe = "blau";
                }
                FarbeSetzen(spalte, zeile, farbe);
                farben[spalte][zeile] = farbe;
            }
        }
    }

    /**
     * Setzt die angegebene Leuchte auf die gewünschte Farbe
     *
     * @param spalte die Spaltennummer der Leuchte
     * @param zeile die Zeilennummer der Leuchte
     * @param farbe die gewünschte Farbe
     */
    void FarbeSetzen(int spalte, int zeile, String farbe)
    {
        leuchten[spalte][zeile].FarbeSetzen(farbe);
        farben[spalte][zeile] = farbe;
    }

    /**
     * Gibt die Farbe der angegebene Leuchte
     *
     * @param spalte die Spaltennummer der Leuchte
     * @param zeile die Zeilennummer der Leuchte
     *
     * @return die Farbe der gewünschten Leuchte
     */
    String FarbeGeben(int spalte, int zeile)
    {
        return farben[spalte][zeile];
    }

    /**
     * Meldet die Anzahl der Spalten
     *
     * @return Spaltenanzahl
     */
    int SpaltenanzahlGeben()
    {
        return spaltenanzahl;
    }

    /**
     * Meldet die Anzahl der Zeilen
     *
     * @return Zeilenanzahl
     */
    int ZeilenanzahlGeben()
    {
        return zeilenanzahl;
    }

    public static void main(String[] args)
    {
        new Dancefloor();
    }
}
