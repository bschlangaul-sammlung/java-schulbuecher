
import java.awt.*;
import javax.swing.*;

/**
 * Das Symbol eines Pilzes.
 * Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class PilzSymbol extends SonderSymbol
{
    /**
     * Standardkonstruktor für Objekte der Klasse PilzSymbol.
     * Das Fenster wird bei Bedarf angelegt.
     */
    PilzSymbol()
    {
        super();
        anzeige = new JComponent ()
        {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent(Graphics g)
            {
                g.clearRect(1, 1, größe - 1, größe - 1);
                g.setColor(Color.white);
                g.fillRect(1, 1, größe - 2, größe - 2);
                g.setColor(new Color (191, 0, 0));
                g.fillArc(größe / 8, größe / 8, 3 * größe / 4, größe - 2, 0, 180);
                g.setColor(new Color (191, 95, 0));
                g.fillRect(7 * größe / 16, größe / 2, größe / 8, größe / 2 - 1);
                g.setColor(Color.white);
                g.fillOval(5 * größe / 16, 5 * größe / 16, größe / 8, größe / 8);
                g.fillOval(9 * größe / 16, 5 * größe / 16, größe / 8, größe / 8);
                g.fillOval(7 * größe / 16, 3 * größe / 16, größe / 8, größe / 8);                
            }
        };
        anzeige.setVisible(true);
        anzeige.setSize(größe, größe);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }
}
