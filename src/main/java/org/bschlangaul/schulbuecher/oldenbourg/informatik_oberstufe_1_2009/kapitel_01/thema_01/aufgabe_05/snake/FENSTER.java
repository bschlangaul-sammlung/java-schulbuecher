package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_05.snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Erzeugt und verwaltet das Ausgabefenster.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class FENSTER extends Frame implements KeyListener
{
    /**
     * Ränder
     */
    private Insets raender;

    /**
     * Verwaltung einer Referenz auf die Darstellung.
     */
    private DARSTELLUNG darstellung;

    /**
     * Erzeugt das Fenster für die Darstellung. <br>
     * Um die Werte für die Ränder zu ermitteln, ist es notwendig, ein Objekt
     * der Klasse Insets zu erzeugen. <br>
     * Insets raender; <br>
     * raender = new Insets(0,0,0,0); <br>
     * Die Werte können mit Hilfe der Methode getInsets() ausgelesen werden.
     * <br>
     * raender = getInsets(); <br>
     * Aus dem Insets-Objekt können die Werte der Ränder ausgelesen werden.
     * Beispiel: <br>
     * raender.left; <br>
     * Registriert einen WindowListener und einen KeyListener
     */
    FENSTER(int breite, int hoehe, DARSTELLUNG d)
    {
        setTitle("Snake");
        setResizable(true);
        setVisible(true);
        setLayout(null);
        setBackground(Color.white);
        setSize(breite, hoehe);
        raender = new Insets(0, 0, 0, 0);
        raender = getInsets();
        setSize(breite + raender.left + raender.right,
                hoehe + raender.top + raender.bottom);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
        darstellung = d;
        addKeyListener(this);
    }

    /**
     * Gibt den linken Rand des Ausgabefensters zurück.
     *
     * @return Linker Rand des Ausgabefensters.
     */
    int RandLinksGeben()
    {
        return raender.left;
    }

    /**
     * Gibt den oberen Rand des Ausgabefensters zurück.
     *
     * @return Oberer Rand des Ausgabefensters.
     */
    int RandObenGeben()
    {
        return raender.top;
    }

    /**
     * Ereignisroutine bei gedrückter Taste. Wird die "Pfeil-nach-links-Taste"
     * (VK_LEFT) gedrückt, so wird an die Darstellung eine Richtungsänderung
     * gemeldet und der Wert 'l' übergeben. Wird die "Pfeil-nach-rechts-Taste"
     * (VK_RIGHT) gedrückt, so wird an die Darstellung eine Richtungsänderung
     * gemeldet und der Wert 'r' übergeben. * @return Oberer Rand des
     * Ausgabefensters.
     */
    public void keyPressed(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_LEFT)
        {
            darstellung.RichtungsAenderungWeiterleiten('l');
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            darstellung.RichtungsAenderungWeiterleiten('r');
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }
}
