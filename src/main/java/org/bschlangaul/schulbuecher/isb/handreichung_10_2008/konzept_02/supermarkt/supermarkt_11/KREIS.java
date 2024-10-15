package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.supermarkt.supermarkt_11;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Ein Kundensymbol (Kreis) auf einem Fenster. Das Fenster wird bei Bedarf
 * generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KREIS
{
    /**
     * Das Anzeigefenster.
     */
    private Canvas anzeige;

    /**
     * Interna
     */
    private OBERFLAECHE.FARBE aktFarbe;

    /**
     * Standardkonstruktor für Objekte der Klasse KREIS. Er erzeugt einen
     * schwarzen Kreis in der linken oberen Ecke des Fensters. Das Fenster wird
     * bei Bedarf angelegt.
     */
    KREIS()
    {
        anzeige = new Canvas()
        {
            /**
             * Stellt die Figur auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                int groesse = getWidth();
                g.setColor(aktFarbe.AWTFarbe());
                g.fillOval(0, 0, groesse - 1, groesse - 1);
                g.setColor(Color.black);
                g.drawOval(0, 0, groesse - 1, groesse - 1);
            }
        };
        aktFarbe = OBERFLAECHE.FARBE.schwarz;
        anzeige.setVisible(true);
        anzeige.setSize(20, 20);
        anzeige.setLocation(0, 20);
        (OBERFLAECHE.FensterGeben()).add(anzeige, 0);
    }

    /**
     * Zeichnet die Figur.
     */
    private void Zeichnen()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Setzt die Farbe der Figur.
     *
     * @param neueFarbe die neue Farbe der Figur
     */
    void FarbeSetzen(String neueFarbe)
    {
        if ("zufall".equals(neueFarbe))
        {
            aktFarbe = OBERFLAECHE.FARBE.ZufallsFarbeErzeugen();
        }
        else
        {
            try
            {
                aktFarbe = OBERFLAECHE.FARBE
                        .valueOf(aktFarbe.getDeclaringClass(), neueFarbe);
            }
            catch (Exception e)
            {
                aktFarbe = OBERFLAECHE.FARBE.weiss;
            }
        }
        Zeichnen();
    }

    /**
     * Setzt die Position der Figur.
     *
     * @param x waagrechte Koordinate
     * @param y senkrechte Koordinate
     */
    void PositionSetzen(int x, int y)
    {
        anzeige.setLocation(x, y);
    }

    /**
     * Setzt die Größe der Figur.
     *
     * @param groesse neuer Durchmesser
     */
    void GroesseSetzen(int groesse)
    {
        anzeige.setSize(groesse, groesse);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    public void Entfernen()
    {
        (OBERFLAECHE.FensterGeben()).remove(anzeige);
    }
}
