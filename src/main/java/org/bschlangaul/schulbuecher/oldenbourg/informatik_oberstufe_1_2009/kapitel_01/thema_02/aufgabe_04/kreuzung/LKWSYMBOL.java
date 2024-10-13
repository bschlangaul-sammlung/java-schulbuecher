package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

/**
 * Ein Fahrzeugsymbol auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;

class LKWSYMBOL extends FAHRZEUGSYMBOL
{
    /**
     * Standardkonstruktor für Objekte der Klasse PKWSYMBOL. Er erzeugt ein
     * blaues Symbol in der Mitte des Fensters, Fahrtrichtung Osten. Das Fenster
     * wird bei Bedarf angelegt.
     */
    LKWSYMBOL()
    {
        super();
        laenge = OBERFLAECHE.RasterGroesseGeben() * 3 / 2;
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
                    umriss = new Polygon(
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 },
                            new int[]
                            { 0, laenge - 3, laenge - 1, laenge - 1, laenge - 3,
                                    0 },
                            6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 },
                            new int[]
                            { 1, laenge - 3, laenge - 2, laenge - 2, laenge - 3,
                                    1 },
                            6);
                    break;

                case 'N':
                    umriss = new Polygon(
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 },
                            new int[]
                            { 0, 3, laenge - 1, laenge - 1, 3, 0 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 3, 1, 1, breite - 2, breite - 2, breite - 4 },
                            new int[]
                            { 1, 4, laenge - 2, laenge - 2, 4, 1 }, 6);
                    break;

                case 'O':
                    umriss = new Polygon(
                            new int[]
                            { 0, laenge - 3, laenge - 1, laenge - 1, laenge - 3,
                                    0 },
                            new int[]
                            { 0, 0, 2, breite - 3, breite - 1, breite - 1 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, laenge - 3, laenge - 2, laenge - 2, laenge - 3,
                                    1 },
                            new int[]
                            { 1, 1, 3, breite - 4, breite - 2, breite - 2 }, 6);
                    break;

                case 'W':
                    umriss = new Polygon(
                            new int[]
                            { 0, 4, laenge - 1, laenge - 1, 4, 0 },
                            new int[]
                            { 2, 0, 0, breite - 1, breite - 1, breite - 3 }, 6);
                    umriss2 = new Polygon(
                            new int[]
                            { 1, 4, laenge - 2, laenge - 2, 4, 1 },
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
