package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_13;

/**
 * Ein Kassensymbol Rechteck) auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;

class RECHTECK
{
    /** Das Anzeigefenster. */
    private Canvas anzeige;

    /** Interna */
    private OBERFLAECHE.FARBE aktFarbe;

    /**
     * Standardkonstruktor für Objekte der Klasse RECHTECK. Er erzeugt ein
     * scharzes Rechteck in der linken oberen Ecke des Fensters. Das Fenster
     * wird bei Bedarf angelegt.
     */
    RECHTECK()
    {
        anzeige = new Canvas()
        {
            /**
             * Stellt die Figur auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                int hoehe = getHeight();
                int breite = getWidth();
                g.clearRect(0, 0, breite, hoehe);
                g.setColor(Color.black);
                g.drawRect(0, 0, breite - 1, hoehe - 1);
                g.setColor(aktFarbe.AWTFarbe());
                g.fillRect(1, 1, breite - 2, hoehe - 2);
            }
        };
        aktFarbe = OBERFLAECHE.FARBE.schwarz;
        anzeige.setVisible(true);
        anzeige.setSize(100, 50);
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
     * @param breite neue Breite
     * @param hoehe neue Höhe
     */
    void GroesseSetzen(int breite, int hoehe)
    {
        anzeige.setSize(breite, hoehe);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    public void Entfernen()
    {
        (OBERFLAECHE.FensterGeben()).remove(anzeige);
    }
}
