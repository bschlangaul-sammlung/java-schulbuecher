package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Fenster zur Anzeige eines Aktienkurses.
 *
 * @author
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class KURSANZEIGE
{
    /** Anzahl der angezeigten Kurse */
    static final int kursAnzahl = 20;

    private JFrame fenster;

    private ANZEIGEKOMPONENTE anzeige;

    /**
     * Baut das Anzeigefenster auf
     */
    KURSANZEIGE()
    {
        fenster = new JFrame("Kursverlauf");
        fenster.setSize(600, 400);
        fenster.setVisible(false);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                fenster.setVisible(false);
            }
        });
        anzeige = new ANZEIGEKOMPONENTE();
        fenster.getContentPane().add(anzeige, BorderLayout.CENTER);
    }

    /**
     * Macht das Anzeigefenster sichtbar
     *
     * @param kurse die Kursdaten für die Anzeige.
     * @param name Name der Aktie
     */
    void Anzeigen(double[] kurse, String name)
    {
        anzeige.AnzeigeSetzen(kurse, name);
        fenster.setVisible(true);
    }
}
