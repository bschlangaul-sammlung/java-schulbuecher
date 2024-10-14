package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_05.snake_l1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Das Symbol eines Minuszeichens. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MinusSymbol extends SonderSymbol
{
    /**
     * Standardkonstruktor für Objekte der Klasse MinusSymbol. Das Fenster wird
     * bei Bedarf angelegt.
     */
    MinusSymbol()
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
                g.setColor(Color.yellow);
                g.fillOval(größe / 4, größe / 4, größe / 2, größe / 2);
                g.setColor(Color.blue);
                g.drawLine(größe / 4, größe / 2, 3 * größe / 4, größe / 2);
                g.drawLine(größe / 4 + 1, größe / 2 - 1, 3 * größe / 4 - 1,
                        größe / 2 - 1);
                g.drawLine(größe / 4 + 1, größe / 2 + 1, 3 * größe / 4 - 1,
                        größe / 2 + 1);
            }
        };
        anzeige.setVisible(true);
        anzeige.setSize(größe, größe);
        fenster.add(anzeige, 0);
        PositionSetzen(0, 0);
    }
}
