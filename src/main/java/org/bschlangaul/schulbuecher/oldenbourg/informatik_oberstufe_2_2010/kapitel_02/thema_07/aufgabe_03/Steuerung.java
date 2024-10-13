package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

import java.awt.*;
import java.awt.event.*;

/**
 * Verwaltet das Steuerungsfenster.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Steuerung implements Beobachter
{
    private Frame fenster;

    private Kontroller kontrolleur;

    private Button start, ende;

    private Label anzeige;

    /**
     * Legt die Oberfläche an.
     */
    Steuerung(Kontroller k)
    {
        kontrolleur = k;
        fenster = new Frame();
        fenster.setLocation(10, 550);
        fenster.setSize(200, 90);
        fenster.setLayout(null);
        fenster.setResizable(false);
        anzeige = new Label();
        anzeige.setLocation(10, 25);
        anzeige.setSize(180, 20);
        anzeige.setText("Viel Gl\u00FCck");
        fenster.add(anzeige);
        start = new Button();
        start.setLocation(60, 55);
        start.setSize(80, 30);
        start.setLabel("Start");
        start.setEnabled(true);
        start.setVisible(true);
        fenster.add(start);
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                start.setEnabled(false);
                start.setVisible(false);
                ende.setEnabled(true);
                ende.setVisible(true);
                kontrolleur.Starten();
                fenster.requestFocus();
            }
        });
        ende = new Button();
        ende.setLocation(60, 55);
        ende.setSize(80, 30);
        ende.setLabel("Beenden");
        ende.setEnabled(true);
        ende.setVisible(true);
        fenster.add(ende);
        ende.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                kontrolleur.Beenden();
            }
        });
        fenster.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent ev)
            {
                kontrolleur.ZeichenVerarbeiten(ev.getKeyChar());
            }
        });
        fenster.setFocusable(true);
        fenster.requestFocus();
        fenster.setVisible(true);
    }

    /**
     * Meldet die anzahl der noch zu suchenden Marken.
     *
     * @param anzahl Anzahl der Marken
     */
    public void MarkenMelden(int anzahl)
    {
        anzeige.setText("Restliche Marken: " + anzahl);
    }

    /**
     * Meldet, dass der Spieler gewonnen hat.
     */
    public void GewonnenMelden()
    {
        anzeige.setText("GEWONNEN !!!");
    }

    /**
     * Meldet, dass der Spieler verloren hat.
     */
    public void VerlorenMelden()
    {
        anzeige.setText("Verloren");
    }
}
