package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.snake;

import java.awt.*;
import java.awt.event.*;

/**
 * Leinwand für die Darstellung der Symbole.
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class LEINWAND extends Canvas
{
    /** Verwaltung der Darstellung, die im Konstruktor übergeben wird */
    private DARSTELLUNG darstellung;

    /** Größe eines Kästchens */
    private int kaestchengroesse;

    /** Kästchenzahl nach rechts */
    private int kaestchenzahl_nach_rechts;

    /** Kästchenzahl nach unten */
    private int kaestchenzahl_nach_unten;

    /**
     * Konstruktor der Klasse LEINWAND Setzt die Attribute gemäß den übergebenen
     * Parametern legt Größe und Sichbarkeit der Leinwand fest.
     *
     * @param d Objekt für die Verwaltung der Darstellung
     * @param kgroesse Größe eines Kästchens
     * @param krechts Anzahl der Kästchen, die auf der Leinwand dargestellt
     *     werden (Breite)
     * @param kunten Anzahl der Kästchen, die auf der Leinwand dargestellt
     *     werden (Höhe)
     */
    LEINWAND(DARSTELLUNG d, int kgroesse, int krechts, int kunten)
    {
        setVisible(true);
        kaestchengroesse = kgroesse;
        kaestchenzahl_nach_rechts = krechts;
        kaestchenzahl_nach_unten = kunten;
        setSize(kaestchengroesse * kaestchenzahl_nach_rechts,
                kaestchengroesse * kaestchenzahl_nach_unten);
        darstellung = d;
    }

    /**
     * Aufruf der Zeichenmethoden für das Spielfeldsymbol und die einzelnen
     * Quadrate param g Graphics-Objekt
     */
    public void paint(Graphics g)
    {
        // Zeichnen des Spielfeldsymbols
        g.setColor(Color.red);
        for (int x = 0; x < kaestchengroesse * kaestchenzahl_nach_rechts; x = x
                + kaestchengroesse)
        {
            g.drawLine(x, 0, x, kaestchengroesse * kaestchenzahl_nach_unten);
        } ;
        for (int y = 0; y < kaestchengroesse * kaestchenzahl_nach_unten; y = y
                + kaestchengroesse)
        {
            g.drawLine(0, y, kaestchengroesse * kaestchenzahl_nach_rechts, y);
        } ;
        // Zeichnen der Quadrate
        char[][] spielfeld;
        spielfeld = new char[kaestchenzahl_nach_rechts][kaestchenzahl_nach_unten];
        spielfeld = darstellung.SpielfeldGeben();
        for (int i = 0; i < kaestchenzahl_nach_rechts; i++)
        {
            for (int j = 0; j < kaestchenzahl_nach_unten; j++)
            {
                switch (spielfeld[i][j])
                {
                case 'f':
                    g.setColor(Color.red);
                    break;

                case 's':
                    g.setColor(Color.green);
                    break;

                default:
                    g.setColor(Color.white);
                }
                g.fillRect(i * kaestchengroesse + 1, j * kaestchengroesse + 1,
                        kaestchengroesse - 1, kaestchengroesse - 1);
            }
        }
    }
}
