package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

/**
 * Eine Richtungsfahrbahn mit Haltelinie.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class FahrbahnSymbol
{
    /**
     * Das Anzeigefenster.
     */
    private Frame fenster;

    /**
     * Breite der Richtungsfahrbahn
     */
    private static final int breite = Oberfaeche.RasterGroesseGeben();

    /**
     * Interna
     */
    private int x;

    private int y;

    private char ausrichtung;

    private Canvas anzeige;

    /**
     * Erzeugt das FAHRBAHNSYMBOL in Richtung West -> Ost
     */
    FahrbahnSymbol()
    {
        fenster = Oberfaeche.FensterGeben();
        x = 0;
        y = 0;
        ausrichtung = 'O';
        anzeige = new Canvas()
        {
            public void paint(Graphics g)
            {
                g.setColor(Color.lightGray);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.white);
                switch (ausrichtung)
                {
                case 'N':
                    g.fillRect(2, Oberfaeche.FensterHoeheGeben() / 2
                            + (y + 2) * breite, breite - 4, breite / 5);
                    break;

                case 'S':
                    g.fillRect(2,
                            Oberfaeche.FensterHoeheGeben() / 2
                                    + (y - 2) * breite - breite / 5,
                            breite - 4, breite / 5);
                    break;

                case 'O':
                    g.fillRect(
                            Oberfaeche.FensterBreiteGeben() / 2
                                    + (x - 2) * breite - breite / 5,
                            2, breite / 5, breite - 4);
                    break;

                case 'W':
                    g.fillRect(
                            Oberfaeche.FensterBreiteGeben() / 2
                                    + (x + 2) * breite,
                            2, breite / 5, breite - 4);
                    break;
                }
            }
        };
        Ausrichten();
        anzeige.setVisible(true);
        fenster.add(anzeige, 0);
    }

    /**
     * Zeichnet die Lampe.
     */
    private void Zeichne()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    private void Ausrichten()
    {
        switch (ausrichtung)
        {
        case 'N':
            anzeige.setSize(breite, Oberfaeche.FensterHoeheGeben());
            anzeige.setLocation(
                    Oberfaeche.FensterBreiteGeben() / 2 + x * breite, 0);
            break;

        case 'S':
            anzeige.setSize(breite, Oberfaeche.FensterHoeheGeben());
            anzeige.setLocation(
                    Oberfaeche.FensterBreiteGeben() / 2 + (x - 1) * breite, 0);
            break;

        case 'O':
            anzeige.setSize(Oberfaeche.FensterBreiteGeben(), breite);
            anzeige.setLocation(0,
                    Oberfaeche.FensterHoeheGeben() / 2 + y * breite);
            break;

        case 'W':
            anzeige.setSize(Oberfaeche.FensterBreiteGeben(), breite);
            anzeige.setLocation(0,
                    Oberfaeche.FensterHoeheGeben() / 2 + (y - 1) * breite);
            break;
        }
        Zeichne();
    }

    /**
     * Setzt die Position der Fahrbahn. Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten. (x /y) bedeutet den Mittelpunkt
     * der Kreuzung, um den sich die Fahrbahn je nach Ausrichtung dreht.
     *
     * @param x x-Position des Kreuzungsmittelpunkts
     * @param y y-Position des Kreuzungsmittelpunkts
     */
    public void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        Ausrichten();
    }

    /**
     * Setzt die Ausrichtung der Fahrbahn.
     *
     * @param ausrichtung Ausrichtung der Fahrbahn.
     */
    public void AusrichtungSetzen(char ausrichtung)
    {
        this.ausrichtung = ausrichtung;
        Ausrichten();
    }

    /**
     * Entfernt das Fahrbahnsymbol aus der Anzeige
     */
    public void Entfernen()
    {
        fenster.remove(anzeige);
    }

    /**
     * Meldet die Eintrittsposition des Fahrzeugs
     *
     * @return Startposition des Fahrzeugs
     */
    public float EintrittsPositionGeben()
    {
        switch (ausrichtung)
        {
        case 'N':
            return (Oberfaeche.FensterHoeheGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'S':
            return -(Oberfaeche.FensterHoeheGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'O':
            return -(Oberfaeche.FensterBreiteGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'W':
            return (Oberfaeche.FensterBreiteGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        default:
            return 0;
        }
    }

    /**
     * Meldet die Austrittsposition des Fahrzeugs
     *
     * @return Austrittsposition des Fahrzeugs
     */
    public float AustrittsPositionGeben()
    {
        switch (ausrichtung)
        {
        case 'N':
            return -(Oberfaeche.FensterHoeheGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'S':
            return (Oberfaeche.FensterHoeheGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'O':
            return (Oberfaeche.FensterBreiteGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        case 'W':
            return -(Oberfaeche.FensterBreiteGeben() / 2)
                    / Oberfaeche.MeterAlsPixelGeben();

        default:
            return 0;
        }
    }

    /**
     * Meldet den Abstand zum inneren Fahrbahnrand
     *
     * @return Abstand des Fahrzeugs
     */
    public float RandAbstandGeben()
    {
        switch (ausrichtung)
        {
        case 'N':
            return x * Oberfaeche.MeterAlsPixelGeben() + 1.5f;

        case 'S':
            return (x - 1) * Oberfaeche.MeterAlsPixelGeben() + 1.5f;

        case 'O':
            return y * Oberfaeche.MeterAlsPixelGeben() + 1.5f;

        case 'W':
            return (y - 1) * Oberfaeche.MeterAlsPixelGeben() + 1.5f;

        default:
            return 0;
        }
    }

    /**
     * Meldet die Position der Haltelinie
     *
     * @return Haltelinienposition
     */
    public float HaltelinienPositionGeben()
    {
        switch (ausrichtung)
        {
        case 'N':
            return (y + 2) * Oberfaeche.MeterAlsPixelGeben();

        case 'S':
            return (y - 2) * Oberfaeche.MeterAlsPixelGeben();

        case 'O':
            return (x - 2) * Oberfaeche.MeterAlsPixelGeben();

        case 'W':
            return (x + 2) * Oberfaeche.MeterAlsPixelGeben();

        default:
            return 0;
        }
    }
}
