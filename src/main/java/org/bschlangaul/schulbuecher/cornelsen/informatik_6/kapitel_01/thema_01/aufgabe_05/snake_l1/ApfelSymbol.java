package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_05.snake_l1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Das Symbol eines Apfels. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ApfelSymbol extends SonderSymbol
{
    /**
     * Standardkonstruktor für Objekte der Klasse KASSENSYMBOL. Er erzeugt einen
     * Apfel an Position (0 | 0). Das Fenster wird bei Bedarf angelegt.
     */
    ApfelSymbol()
    {
        super();
        anzeige = new JComponent()
        {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent(Graphics g)
            {
                g.clearRect(1, 1, größe - 1, größe - 1);
                g.setColor(Color.white);
                g.fillRect(1, 1, größe - 2, größe - 2);
                g.setColor(Color.red);
                g.fillOval(größe / 4, 3 * größe / 8, größe / 2, größe / 2);
                g.setColor(Color.green);
                g.drawLine(größe / 2 - 1, 3 * größe / 8, 5 * größe / 8 - 1,
                        größe / 8);
                g.drawLine(größe / 2, 3 * größe / 8, 5 * größe / 8, größe / 8);
                g.drawLine(größe / 2 + 1, 3 * größe / 8, 5 * größe / 8 + 1,
                        größe / 8);
                g.drawLine(größe / 2 - 1, 3 * größe / 8, größe / 4 - 1,
                        größe / 8);
                g.drawLine(größe / 2, 3 * größe / 8, größe / 4, größe / 8);
                g.drawLine(größe / 2 + 1, 3 * größe / 8, größe / 4 + 1,
                        größe / 8);
                g.setColor(new Color(200, 100, 0));
                g.drawLine(größe / 2 - 1, 3 * größe / 8, 3 * größe / 8 - 1,
                        größe / 8);
                g.drawLine(größe / 2, 3 * größe / 8, 3 * größe / 8, größe / 8);
                g.drawLine(größe / 2 + 1, 3 * größe / 8, 3 * größe / 8 + 1,
                        größe / 8);
            }
        };
        anzeige.setVisible(true);
        anzeige.setSize(größe, größe);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }
}
