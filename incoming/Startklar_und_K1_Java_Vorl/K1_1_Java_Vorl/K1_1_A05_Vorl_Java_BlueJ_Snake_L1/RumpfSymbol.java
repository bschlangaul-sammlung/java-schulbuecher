/**
 * Das Symbol des Schlangenrumpfs.
 * Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;

class RumpfSymbol
{
    /** Das Anzeigefenster.*/
    private JFrame fenster;
    
    /** Anzeigegröße für das Rumpfelement */
    static final int größe = Oberflaeche.RasterGrößeGeben();

    /** x-Position */
    private int x;
    /** y-Position */
    private int y;
    /** Anzeige */
    private JComponent anzeige;

    /**
     * Standardkonstruktor für Objekte der Klasse KASSENSYMBOL.
     * Er erzeugt ein scharzes Rechteck in der linken oberen Ecke des Fensters.
     * Das Fenster wird bei Bedarf angelegt.
     */
    RumpfSymbol()
    {
        fenster = Oberflaeche.FensterGeben();
        anzeige = new JComponent() {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent(Graphics g)
            {
                g.clearRect(0, 0, größe, größe);
                g.setColor(Color.yellow);
                g.fillRect(0, 0, größe - 1, größe - 1);
                g.setColor(new Color(50, 200, 0));
                g.drawRect(0, 0, größe - 1, größe - 1);
                g.drawRect(1, 1, größe - 3, größe - 3);
                g.drawLine(0, 0, größe - 1, größe - 1);
                g.drawLine(1, 0, größe - 1, größe - 2);
                g.drawLine(0, 1, größe - 2, größe - 1);
                g.drawLine(0, größe - 1, größe - 1, 0);
                g.drawLine(1, größe - 1, größe - 1, 1);                
                g.drawLine(0, größe - 2, größe - 2, 0);
            }

        };
        anzeige.setVisible(true);
        anzeige.setSize(größe, größe);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }

    /**
     * Setzt die Position des Rumpfelements.Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten.(x /y) bedeutet das
     * Kästchen rechts unterhalb der Gitterlinien.
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        anzeige.setLocation(Oberflaeche.FensterBreiteGeben() / 2 + x * größe, Oberflaeche.FensterHöheGeben() / 2 + y * größe);
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
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen()
    {
        (Oberflaeche.FensterGeben()).remove(anzeige);
        (Oberflaeche.FensterGeben()).repaint();
    }
}
