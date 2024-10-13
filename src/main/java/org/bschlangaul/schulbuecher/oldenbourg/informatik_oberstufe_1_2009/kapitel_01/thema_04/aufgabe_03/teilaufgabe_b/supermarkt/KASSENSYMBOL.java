package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

/**
 * Ein Kassensymbol auf einem Fenster. Das Fenster wird bei Bedarf generiert.
 *
 * @author Klaus van Dijkstran und Barbara Leidorn
 * @version 1.0
 */
import java.awt.*;

class KASSENSYMBOL
{
    /** Das Anzeigefenster. */
    private Canvas anzeige;

    /** Anzeigegröße für das Rechteck */
    private int hoehe = 50;

    private int breite = 100;

    /** Interna */
    private OBERFLAECHE.FARBE aktFarbe;

    /**
     * Standardkonstruktor für Objekte der Klasse KASSENSYMBOL. Er erzeugt ein
     * scharzes Rechteck in der linken oberen Ecke des Fensters. Das Fenster
     * wird bei Bedarf angelegt.
     */
    KASSENSYMBOL()
    {
        anzeige = new Canvas()
        {
            /**
             * Stellt die Figur auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                g.clearRect(0, 0, breite, hoehe);
                g.setColor(Color.black);
                g.drawRect(0, 0, breite - 1, hoehe - 1);
                g.setColor(aktFarbe.AWTFarbe());
                g.fillRect(1, 1, breite - 2, hoehe - 2);
            }
        };
        aktFarbe = OBERFLAECHE.FARBE.gruen;
        anzeige.setVisible(true);
        anzeige.setSize(breite, hoehe);
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
     * @param kassennummer Nummer der Kasse
     */
    void PositionSetzen(int kassennummer)
    {
        int x = 400;
        int y = 100 * kassennummer;
        anzeige.setLocation(x, 100 * kassennummer);;
    }

    /**
     * Setzt die Größe der Figur.
     *
     * @param b neue Breite
     * @param h neue Höhe
     */
    void GroesseSetzen(int b, int h)
    {
        hoehe = h;
        breite = b;
        anzeige.setSize(b, h);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    public void Entfernen()
    {
        (OBERFLAECHE.FensterGeben()).remove(anzeige);
    }
}
