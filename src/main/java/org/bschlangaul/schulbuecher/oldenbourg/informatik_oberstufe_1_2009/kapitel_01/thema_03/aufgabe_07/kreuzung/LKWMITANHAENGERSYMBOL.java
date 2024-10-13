package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

/**
 * Ein Fahrzeugsymbol auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;

class LKWMITANHAENGERSYMBOL extends FAHRZEUGSYMBOL
{
    /**
     * Standardkonstruktor für Objekte der Klasse LKWMITANHANGERSYMBOL. Er
     * erzeugt ein blaues Symbol in der Mitte des Fensters, Fahrtrichtung Osten.
     * Das Fenster wird bei Bedarf angelegt.
     */
    LKWMITANHAENGERSYMBOL()
    {
        super();
        laenge = OBERFLAECHE.RasterGroesseGeben() * 3;
        anzeige = new Canvas()
        {
            /**
             * Stellt das Fahrzeug auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                Polygon umriss = null;
                Polygon umriss2 = null;
                Polygon umriss3 = null;
                Polygon umriss4 = null;
                Polygon umriss5 = null;
                switch (ausrichtung)
                {
                case 'S':
                    umriss = new Polygon(
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 },
                            new int[]
                            { laenge / 2, laenge - 3, laenge - 1, laenge - 1,
                                    laenge - 3, laenge / 2 },
                            6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 },
                            new int[]
                            { laenge / 2 + 1, laenge - 3, laenge - 2,
                                    laenge - 2, laenge - 3, laenge / 2 + 1 },
                            6);
                    umriss3 = new Polygon(
                            new int[]
                            { 0, 0, breite - 1, breite - 1 },
                            new int[]
                            { 0, laenge / 2 - 3, laenge / 2 - 3, 0 }, 4);
                    umriss4 = new Polygon(
                            new int[]
                            { 1, 1, breite - 2, breite - 2 },
                            new int[]
                            { 1, laenge / 2 - 4, laenge / 2 - 4, 1 }, 4);
                    umriss5 = new Polygon(
                            new int[]
                            { breite / 2 - 1, breite / 2 - 1, breite / 2,
                                    breite / 2 },
                            new int[]
                            { laenge / 2, laenge / 2 - 3, laenge / 2 - 3,
                                    laenge / 2 },
                            4);
                    break;

                case 'N':
                    umriss = new Polygon(
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 },
                            new int[]
                            { 0, 3, laenge / 2 - 1, laenge / 2 - 1, 3, 0 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 3, 1, 1, breite - 2, breite - 2, breite - 4 },
                            new int[]
                            { 1, 4, laenge / 2 - 2, laenge / 2 - 2, 4, 1 }, 6);
                    umriss3 = new Polygon(
                            new int[]
                            { 0, 0, breite - 1, breite - 1 },
                            new int[]
                            { laenge / 2 + 3, laenge - 1, laenge - 1,
                                    laenge / 2 + 3 },
                            4);
                    umriss4 = new Polygon(
                            new int[]
                            { 1, 1, breite - 2, breite - 2 },
                            new int[]
                            { laenge / 2 + 4, laenge - 2, laenge - 2,
                                    laenge / 2 + 4 },
                            4);
                    umriss5 = new Polygon(
                            new int[]
                            { breite / 2 - 1, breite / 2 - 1, breite / 2,
                                    breite / 2 },
                            new int[]
                            { laenge / 2, laenge / 2 + 3, laenge / 2 + 3,
                                    laenge / 2 },
                            4);
                    break;

                case 'O':
                    umriss = new Polygon(
                            new int[]
                            { laenge / 2, laenge - 3, laenge - 1, laenge - 1,
                                    laenge - 3, laenge / 2 },
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { laenge / 2 + 1, laenge - 3, laenge - 2,
                                    laenge - 2, laenge - 3, laenge / 2 + 1 },
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 }, 6);
                    umriss3 = new Polygon(
                            new int[]
                            { 0, laenge / 2 - 4, laenge / 2 - 4, 0 },
                            new int[]
                            { 0, 0, breite - 1, breite - 1 }, 4);
                    umriss4 = new Polygon(
                            new int[]
                            { 1, laenge / 2 - 5, laenge / 2 - 5, 1 },
                            new int[]
                            { 1, 1, breite - 2, breite - 2 }, 4);
                    umriss5 = new Polygon(
                            new int[]
                            { laenge / 2, laenge / 2 - 3, laenge / 2 - 3,
                                    laenge / 2 },
                            new int[]
                            { breite / 2 - 1, breite / 2 - 1, breite / 2,
                                    breite / 2 },
                            4);
                    break;

                case 'W':
                    umriss = new Polygon(
                            new int[]
                            { 0, 4, laenge / 2 - 1, laenge / 2 - 1, 4, 0 },
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 4, laenge / 2 - 2, laenge / 2 - 2, 4, 1 },
                            new int[]
                            { 3, 1, 1, breite - 2, breite - 2, breite - 4 }, 6);
                    umriss3 = new Polygon(
                            new int[]
                            { laenge / 2 + 3, laenge - 1, laenge - 1,
                                    laenge / 2 + 3 },
                            new int[]
                            { 0, 0, breite - 1, breite - 1 }, 4);
                    umriss4 = new Polygon(
                            new int[]
                            { laenge / 2 + 4, laenge - 2, laenge - 2,
                                    laenge / 2 + 4 },
                            new int[]
                            { 1, 1, breite - 2, breite - 2 }, 4);
                    umriss5 = new Polygon(
                            new int[]
                            { laenge / 2, laenge / 2 + 3, laenge / 2 + 3,
                                    laenge / 2 },
                            new int[]
                            { breite / 2 - 1, breite / 2 - 1, breite / 2,
                                    breite / 2 },
                            4);
                    break;
                }
                g.setColor(AWTFarbe(aktFarbe));
                g.fillPolygon(umriss);
                g.fillPolygon(umriss3);
                g.setColor(Color.black);
                g.drawPolygon(umriss);
                g.drawPolygon(umriss2);
                g.drawPolygon(umriss3);
                g.drawPolygon(umriss4);
                g.drawPolygon(umriss5);
            }
        };
        anzeige.setVisible(true);
        anzeige.setSize(laenge + 1, breite + 1);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }
}
