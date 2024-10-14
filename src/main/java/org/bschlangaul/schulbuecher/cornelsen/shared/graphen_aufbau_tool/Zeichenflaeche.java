package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * Die Zeichenfläche zur Darstellung des Graphen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Zeichenflaeche extends JComponent
{
    /**
     * Feld aller zu zeichnenden Objekte.
     */
    private ArrayList<GraphenSymbol> alleSymbole;

    /**
     * Legt die Attribute an.
     */
    Zeichenflaeche()
    {
        super();
        alleSymbole = new ArrayList<GraphenSymbol>();
    }

    /**
     * Die eigentliche Zeichenmethode
     *
     * @param g der Grafport zum Zeichnen
     */
    @Override
    public void paint(Graphics g)
    {
        g.setColor(new Color(230, 230, 230));
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        synchronized (alleSymbole)
        {
            for (GraphenSymbol s : alleSymbole)
            {
                s.Zeichnen((Graphics2D) g);
            }
        }
    }

    /**
     * Trägt das angegebene Symbol in die Liste ein.
     *
     * @param symbol das einzutragende Symbol
     */
    void Eintragen(GraphenSymbol symbol)
    {
        synchronized (alleSymbole)
        {
            alleSymbole.add(symbol);
        }
        repaint();
    }

    /**
     * Entfernt das angegebene Symbol.
     *
     * @param symbol das zu entfernende Symbol
     */
    void Entfernen(GraphenSymbol symbol)
    {
        synchronized (alleSymbole)
        {
            alleSymbole.remove(symbol);
        }
        repaint();
    }
}
