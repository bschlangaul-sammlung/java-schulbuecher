package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_c.kreuzung;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Ein Fahrzeugsymbol auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SPORTWAGENSYMBOL extends FAHRZEUGSYMBOL
{
    /**
     * Standardkonstruktor für Objekte der Klasse SPORTWAGENSYMBOL. Er erzeugt
     * ein blaues Symbol in der Mitte des Fensters, Fahrtrichtung Osten. Das
     * Fenster wird bei Bedarf angelegt.
     */
    SPORTWAGENSYMBOL()
    {
        super();
        laenge = OBERFLAECHE.RasterGroesseGeben() * 3 / 4;
        anzeige = new Canvas()
        {
            /**
             * Stellt das Fahrzeug auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                Polygon umriss = null;
                Polygon umriss2 = null;
                switch (ausrichtung)
                {
                case 'S':
                    g.clearRect(0, 0, breite, laenge);
                    umriss = new Polygon(
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 },
                            new int[]
                            { 0, laenge - 7, laenge - 1, laenge - 1, laenge - 7,
                                    0 },
                            6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 },
                            new int[]
                            { 1, laenge - 7, laenge - 2, laenge - 2, laenge - 7,
                                    1 },
                            6);
                    break;

                case 'N':
                    g.clearRect(0, 0, breite, laenge);
                    umriss = new Polygon(
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 },
                            new int[]
                            { 0, 7, laenge - 1, laenge - 1, 7, 0 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 3, 1, 1, breite - 2, breite - 2, breite - 4 },
                            new int[]
                            { 1, 7, laenge - 2, laenge - 2, 7, 1 }, 6);
                    break;

                case 'O':
                    g.clearRect(0, 0, laenge, breite);
                    umriss = new Polygon(
                            new int[]
                            { 0, laenge - 7, laenge - 1, laenge - 1, laenge - 7,
                                    0 },
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, laenge - 7, laenge - 2, laenge - 2, laenge - 7,
                                    1 },
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 }, 6);
                    break;

                case 'W':
                    g.clearRect(0, 0, laenge, breite);
                    umriss = new Polygon(
                            new int[]
                            { 0, 7, laenge - 1, laenge - 1, 7, 0 },
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 7, laenge - 2, laenge - 2, 7, 1 },
                            new int[]
                            { 3, 1, 1, breite - 2, breite - 2, breite - 4 }, 6);
                    break;
                }
                g.setColor(AWTFarbe(aktFarbe));
                g.fillPolygon(umriss);
                g.setColor(Color.black);
                g.drawPolygon(umriss);
                g.drawPolygon(umriss2);
            }
        };
        anzeige.setVisible(true);
        anzeige.setSize(laenge + 1, breite + 1);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }
}
