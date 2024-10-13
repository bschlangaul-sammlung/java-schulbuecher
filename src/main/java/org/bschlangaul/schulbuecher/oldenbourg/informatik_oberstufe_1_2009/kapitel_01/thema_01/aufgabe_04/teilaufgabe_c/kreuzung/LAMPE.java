package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_c.kreuzung;

/**
 * Eine Lampe auf einem Fenster. Das Fenster wird bei Bedarf generiert. Das Koordinatensystem des
 * Fensters ist ein Rastersystem mit Ursprung in der Mitte, (0/0) bezeichnet das Feld rechts
 * unterhalb des Ursprungs. Die y-Achse zeigt nach unten
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;

public class LAMPE
{
    private enum Farbe
    {
        weiss, schwarz, rot, gruen, blau, gelb, magenta, cyan, grau;

        /**
         * Konvertiert die angegebene Farbe in ihr AWT-Pendant.
         *
         * @return die entsprechende AWT-Farbe
         */
        java.awt.Color AWTFarbe()
        {
            java.awt.Color farbe;
            switch (this)
            {
            case weiss:
                farbe = java.awt.Color.white;
                break;

            case schwarz:
                farbe = java.awt.Color.black;
                break;

            case rot:
                farbe = java.awt.Color.red;
                break;

            case gruen:
                farbe = java.awt.Color.green;
                break;

            case blau:
                farbe = java.awt.Color.blue;
                break;

            case gelb:
                farbe = java.awt.Color.yellow;
                break;

            case magenta:
                farbe = java.awt.Color.magenta;
                break;

            case cyan:
                farbe = java.awt.Color.cyan;
                break;

            case grau:
                farbe = java.awt.Color.gray;
                break;

            default:
                farbe = java.awt.Color.white;
            }
            return farbe;
        }
    }

    /** Das Anzeigefenster. */
    private Frame fenster;

    /** Anzeigegröße für eine Lampe */
    private static final int groesse = OBERFLAECHE.RasterGroesseGeben();

    /** Interna */
    private static int radius = groesse / 4;

    private Farbe aktFarbe;

    private int x;

    private int y;

    private Canvas anzeige;

    /**
     * Standardkonstruktor für Objekte der Klasse LAMPE. Er erzeugt eine scharze
     * Lampe in der Zelle (0 / 0) des Fensters. Das Fenster wird bei Bedarf
     * angelegt.
     */
    public LAMPE()
    {
        fenster = OBERFLAECHE.FensterGeben();
        anzeige = new Canvas()
        {
            // Stellt die Lampe auf dem Fenster dar.
            public void paint(Graphics g)
            {
                g.clearRect(0, 0, groesse, groesse);
                g.setColor(Color.black);
                g.drawRect(0, 0, groesse - 1, groesse - 1);
                g.setColor(aktFarbe.AWTFarbe());
                g.fillOval(radius, radius, radius * 2, radius * 2);
            }
        };
        aktFarbe = Farbe.schwarz;
        anzeige.setVisible(true);
        anzeige.setSize(groesse, groesse);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }

    /**
     * Zeichnet die Lampe.
     */
    private void Zeichne()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Setzt die Farbe der Lampe.
     *
     * @param neueFarbe die neue Farbe der Lampe
     */
    public void FarbeSetzen(String neueFarbe)
    {
        try
        {
            aktFarbe = Farbe.valueOf(aktFarbe.getDeclaringClass(), neueFarbe);
        }
        catch (Exception e)
        {
            aktFarbe = Farbe.weiss;
        }
        Zeichne();
    }

    /**
     * Setzt die Position der Lampe. Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten. (x /y) bedeutet das Kästchen
     * rechts unterhalb der Gitterlinien.
     *
     * @param x x-Position
     * @param y y-Position
     */
    public void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        anzeige.setLocation(OBERFLAECHE.FensterBreiteGeben() / 2 + x * groesse,
                OBERFLAECHE.FensterHoeheGeben() / 2 + y * groesse);
    }
}
