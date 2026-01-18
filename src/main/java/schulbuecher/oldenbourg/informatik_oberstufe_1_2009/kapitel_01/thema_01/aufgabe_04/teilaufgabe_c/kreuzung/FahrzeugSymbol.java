package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_c.kreuzung;

import java.awt.Canvas;
import java.awt.Frame;

/**
 * Ein Fahrzeugsymbol auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class FahrzeugSymbol
{
    /**
     * Das Anzeigefenster.
     */
    protected Frame fenster;

    /**
     * Anzeigegröße für ein Fahrzeug
     */
    protected int laenge;

    protected static final int breite = Oberflaeche.RasterGroesseGeben() / 2;

    /**
     * Interna
     */
    protected String aktFarbe;

    protected float x;

    protected float y;

    protected Canvas anzeige;

    protected char ausrichtung;

    /**
     * Standardkonstruktor für Objekte der Klasse FAHRZEUGSYMBOL. Keine Anzeige,
     * Fahrtrichtung Osten. Das Fenster wird bei Bedarf angelegt.
     */
    FahrzeugSymbol()
    {
        laenge = Oberflaeche.RasterGroesseGeben();
        fenster = Oberflaeche.FensterGeben();
        anzeige = null;
        aktFarbe = "blau";
        ausrichtung = 'O';
    }

    protected java.awt.Color AWTFarbe(String farbe)
    {
        if (farbe == "weiss")
        {
            return java.awt.Color.white;
        }
        else if (farbe == "schwarz")
        {
            return java.awt.Color.black;
        }
        else if (farbe == "rot")
        {
            return java.awt.Color.red;
        }
        else if ((farbe == "gruen") || (farbe == "grün"))
        {
            return java.awt.Color.green;
        }
        else if (farbe == "blau")
        {
            return java.awt.Color.blue;
        }
        else if (farbe == "gelb")
        {
            return java.awt.Color.yellow;
        }
        else if (farbe == "magenta")
        {
            return java.awt.Color.magenta;
        }
        else if (farbe == "cyan")
        {
            return java.awt.Color.cyan;
        }
        else if (farbe == "grau")
        {
            return java.awt.Color.gray;
        }
        else
        {
            return java.awt.Color.white;
        }
    }

    /**
     * Zeichnet das Fahrzeugsymbol.
     */
    private void Zeichne()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Setzt die Farbe des Fahrzeugsymbols.
     *
     * @param neueFarbe die neue Farbe des Fahrzeugsymbols
     */
    public void FarbeSetzen(String neueFarbe)
    {
        aktFarbe = neueFarbe.toLowerCase();
        Zeichne();
    }

    /**
     * Setzt die Position des Fahrzeugsymbols. Das Koordinatensystem rechnet in
     * Metern; der Ursprung ist in der Mitte des Fensters. Das Fahrzeugsymbol
     * repräsentiert eine Länge von 5,0m. Die Koordinaten bezeichnen die linke,
     * obere Ecke des Fahrzeugsymbols.
     *
     * @param x x-Position
     * @param y y-Position
     */
    public void PositionSetzen(float x, float y)
    {
        this.x = x;
        this.y = y;
        anzeige.setLocation(
                Oberflaeche.FensterBreiteGeben() / 2
                        + (int) (x * Oberflaeche.MeterAlsPixelGeben()),
                Oberflaeche.FensterHoeheGeben() / 2
                        + (int) (y * Oberflaeche.MeterAlsPixelGeben()));
    }

    /**
     * Setzt die Ausrichtung des Fahrzeugs.
     *
     * @param ausrichtung Ausrichtung des Fahrzeugs.
     */
    public void AusrichtungSetzen(char ausrichtung)
    {
        this.ausrichtung = ausrichtung;
        switch (ausrichtung)
        {
        case 'N':
            anzeige.setSize(breite, laenge);
            break;

        case 'S':
            anzeige.setSize(breite, laenge);
            break;

        case 'O':
            anzeige.setSize(laenge, breite);
            break;

        case 'W':
            anzeige.setSize(laenge, breite);
            break;
        }
        Zeichne();
    }

    /**
     * Entfernt das Fahrzeugsymbol aus der Anzeige
     */
    public void Entfernen()
    {
        fenster.remove(anzeige);
    }
}
