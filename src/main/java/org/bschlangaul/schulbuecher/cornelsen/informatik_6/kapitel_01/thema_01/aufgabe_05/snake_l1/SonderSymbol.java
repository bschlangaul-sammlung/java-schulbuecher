package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_05.snake_l1;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Oberklasse aller Symbole für Sonderfelder. Das Fenster wird bei Bedarf
 * generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class SonderSymbol
{
    /** Das Anzeigefenster. */
    protected JFrame fenster;

    /** Anzeigegröße für das Symbol */
    protected static final int größe = Oberflaeche.RasterGrößeGeben();

    /** Interna */
    protected int x;

    protected int y;

    protected JComponent anzeige;

    /**
     * Standardkonstruktor für Objekte der Klasse SonderSymbol. Das Fenster wird
     * bei Bedarf angelegt.
     */
    SonderSymbol()
    {
        fenster = Oberflaeche.FensterGeben();
        anzeige = null;
    }

    /**
     * Setzt die Position des Symbol.Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten.(x /y) bedeutet das Kästchen
     * rechts unterhalb der Gitterlinien.
     *
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
        if (anzeige != null)
        {
            anzeige.setLocation(
                    Oberflaeche.FensterBreiteGeben() / 2 + x * größe,
                    Oberflaeche.FensterHöheGeben() / 2 + y * größe);
        }
    }

    /**
     * Gibt den X-Wert der Position des Symbols.
     *
     * @return x-Position
     */
    int XPositionGeben()
    {
        return x;
    }

    /**
     * Gibt den Y-Wert der Position des Symbols.
     *
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
