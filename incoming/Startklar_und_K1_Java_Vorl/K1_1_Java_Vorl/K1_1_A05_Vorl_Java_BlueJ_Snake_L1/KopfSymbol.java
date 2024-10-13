
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Das Symbol des Schlangenrumpfs.
 * Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class KopfSymbol
{
    /**
     * Das Anzeigefenster.*/
    private JFrame fenster;

    /**
     * Anzeigegröße für das Rumpfelement */
    private static final int größe = Oberflaeche.RasterGrößeGeben();

    /**
     * x-Position */
    private int x;
    /**
     * y-Position */
    private int y;
    /**
     * Blickrichtung */
    private char ausrichtung;
    /**
     * Anzeige */
    private JComponent anzeige;

    /**
     * Standardkonstruktor für Objekte der Klasse KopfSymbol.
     * Er erzeugt ein Kopfsymbol an Postion (0 | 0).
     * Das Fenster wird bei Bedarf angelegt.
     */
    KopfSymbol()
    {
        fenster = Oberflaeche.FensterGeben();
        anzeige = new JComponent() {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent(Graphics g)
            {
                AffineTransform old;
                Graphics2D g2;
                g2 = (Graphics2D) g;
                old = g2.getTransform();
                switch (ausrichtung)
                {
                    case 'N':
                    g2.transform(AffineTransform.getRotateInstance(Math.toRadians(270), größe / 2, größe / 2));
                    g2.transform(AffineTransform.getTranslateInstance(-größe, 0));
                    break;
                    case 'S':
                    g2.transform(AffineTransform.getRotateInstance(Math.toRadians(90), größe / 2, größe / 2));
                    break;
                    case 'W':
                    g2.transform(AffineTransform.getRotateInstance(Math.toRadians(180), größe / 2, größe / 2));
                    g2.transform(AffineTransform.getTranslateInstance(-größe, 0));
                    break;
                    default:
                    //nix
                }
                g.setColor(Color.yellow);
                g.fillRect(0, 0, größe / 2, größe - 1);
                g.fillArc(0, 0, größe - 1, größe - 1, -90, 180);
                g.setColor(Color.white);
                g.fillOval(größe / 2 - 8, 4, 8, 8);
                g.fillOval(größe / 2 - 8, größe - 12, 8, 8);
                g.setColor(new Color(50, 200, 0));
                g.drawLine(0, 0, größe / 2, 0);
                g.drawLine(1, 1, größe / 2, 1);
                g.drawLine(0, 0, 0, größe - 1);
                g.drawLine(1, 1, 1, größe - 3);
                g.drawLine(0, größe - 1, größe / 2, größe - 1);
                g.drawLine(1, größe - 2, größe / 2, größe - 2);
                g.drawArc(0, 0, größe - 1, größe - 1, -90, 180);
                g.drawArc(1, 1, größe - 3, größe - 3, -90, 180);
                g.drawOval(größe / 2 - 8, 4, 8, 8);
                g.drawOval(größe / 2 - 8, größe - 12, 8, 8);
                g.setColor(Color.black);
                g.fillOval(größe / 2 - 6, 6, 4, 4);
                g.fillOval(größe / 2 - 6, größe - 10, 4, 4);
                g.setColor(new Color(200, 0, 0));
                g.drawLine(größe, größe / 2 - 1, größe * 5 / 4, größe / 2 - 1);
                g.drawLine(größe, größe / 2, größe * 5 / 4, größe / 2);
                g.drawLine(größe, größe / 2 + 1, größe * 5 / 4, größe / 2 + 1);
                g.drawLine(größe * 5 / 4, größe / 2, größe * 6 / 4, größe * 3 / 4);
                g.drawLine(größe * 5 / 4, größe / 2 + 1, größe * 6 / 4, größe * 3 / 4 + 1);
                g.drawLine(größe * 5 / 4, größe / 2, größe * 6 / 4, größe * 1 / 4);
                g.drawLine(größe * 5 / 4, größe / 2 - 1, größe * 6 / 4, größe * 1 / 4 - 1);
                g2.setTransform(old);
            }
        };
        anzeige.setVisible(true);
        ausrichtung = 'O';
        x = 0;
        y = 0;
        fenster.add(anzeige, 0);
        Anordnen();
    }

    /**
     * Ordnet das Element gemäß Ausrichtung und Position so an, dass die Zunge "über das Kästchen raus hängt".
     */
    private void Anordnen()
    {
        switch (ausrichtung)
        {
          case 'O':
            anzeige.setSize(größe * 2, größe);
            anzeige.setLocation(Oberflaeche.FensterBreiteGeben() / 2 + x * größe, Oberflaeche.FensterHöheGeben() / 2 + y * größe);
            break;
          case 'W':
            anzeige.setSize(größe * 2, größe);
            anzeige.setLocation(Oberflaeche.FensterBreiteGeben() / 2 + (x - 1) * größe, Oberflaeche.FensterHöheGeben() / 2 + y * größe);
            break;
          case 'S':
            anzeige.setSize(größe, größe * 2);
            anzeige.setLocation(Oberflaeche.FensterBreiteGeben() / 2 + x * größe, Oberflaeche.FensterHöheGeben() / 2 + y * größe);
            break;
          case 'N':
            anzeige.setSize(größe, größe * 2);
            anzeige.setLocation(Oberflaeche.FensterBreiteGeben() / 2 + x * größe, Oberflaeche.FensterHöheGeben() / 2 + (y - 1) * größe);
            break;
        }
    }

    /**
     * Setzt die Position des Kopfelements.Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten.(x /y) bedeutet das
     * Kästchen rechts unterhalb der Gitterlinien.
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        Anordnen();
    }

    /**
     * Gibt den X-Wert der Position des Kopfelements.
     * @return x-Position
     */
    int XPositionGeben()
    {
        return x;
    }

    /**
     * Gibt den Y-Wert der Position des Kopfelements.
     * @return y-Position
     */
    int YPositionGeben()
    {
        return y;
    }

    /**
     * Setzt die Ausrichtung des Kopfelements.
     * @param ausrichtung Ausrichtung des Kopfelements.
     */
    void AusrichtungSetzen(char ausrichtung)
    {
        this.ausrichtung = ausrichtung;
        Anordnen();
    }

    /**
     * Setzt die Ausrichtung des Kopfelements.
     * @return Ausrichtung des Kopfelements.
     */
    char AusrichtungGeben()
    {
        return ausrichtung;
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen()
    {
        (Oberflaeche.FensterGeben()).remove(anzeige);
        (Oberflaeche.FensterGeben()).repaint();
    }
}
