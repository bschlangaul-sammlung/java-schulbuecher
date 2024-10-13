package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.kreuzung;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Verwaltet das Ausgabefenster.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class OBERFLAECHE
{
    /** Höhe des Anzeigefensters */
    private static final int hoeheFenster = 600;

    /** Breite des Anzeigefensters */
    private static final int breiteFenster = 1000;

    /** Anzeigegröße für eine Lampe */
    private static final int rasterGroesse = 20;

    /** Umrechnung Meter nach Pixel */
    private static final float meter2pixel = 5.0f;

    private static OBERFLAECHE o = null;

    private Frame fenster = null;

    private ADAPTER a;

    private TextField eingabe;

    private TextField eingabe2;

    /**
     * Baut die Bedienoberfläche auf
     */
    private OBERFLAECHE()
    {
        Label l;
        Button button;
        fenster = new Frame("Zeichenfl\u00E4che");
        fenster.setResizable(false);
        fenster.setSize(breiteFenster, hoeheFenster + 100);
        fenster.setVisible(true);
        fenster.setLayout(null);
        fenster.setBackground(Color.white);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
        Canvas hintergrund = new Canvas()
        {
            /**
             * Zeichnet das Hintergrundmuster.
             */
            public void paint(Graphics g)
            {
                g.setColor(Color.lightGray);
                for (int i = 1; i <= hoeheFenster / (rasterGroesse * 2); i++)
                {
                    g.drawLine(0, hoeheFenster / 2 + i * rasterGroesse,
                            breiteFenster - 1,
                            hoeheFenster / 2 + i * rasterGroesse);
                    g.drawLine(0, hoeheFenster / 2 - i * rasterGroesse,
                            breiteFenster - 1,
                            hoeheFenster / 2 - i * rasterGroesse);
                }
                for (int i = 1; i <= breiteFenster / (rasterGroesse * 2); i++)
                {
                    g.drawLine(breiteFenster / 2 + i * rasterGroesse, 0,
                            breiteFenster / 2 + i * rasterGroesse,
                            hoeheFenster - 1);
                    g.drawLine(breiteFenster / 2 - i * rasterGroesse, 0,
                            breiteFenster / 2 - i * rasterGroesse,
                            hoeheFenster - 1);
                }
                g.setColor(Color.black);
                g.drawLine(0, hoeheFenster / 2, breiteFenster - 1,
                        hoeheFenster / 2);
                g.drawLine(breiteFenster / 2, 0, breiteFenster / 2,
                        hoeheFenster - 1);
            }
        };
        hintergrund.setVisible(true);
        hintergrund.setSize(breiteFenster, hoeheFenster);
        hintergrund.setLocation(0, 0);
        fenster.add(hintergrund);
        l = new Label();
        l.setText("Mittlerer Fahrzeugabstand");
        l.setLocation(20, hoeheFenster + 35);
        l.setVisible(true);
        l.setSize(200, 20);
        fenster.add(l);
        eingabe = new TextField();
        eingabe.setLocation(220, hoeheFenster + 35);
        eingabe.setText("6");
        eingabe.setVisible(true);
        eingabe.setSize(60, 20);
        eingabe.setEnabled(true);
        fenster.add(eingabe);
        button = new Button();
        button.setLocation(300, hoeheFenster + 30);
        button.setLabel("Setzen");
        button.setVisible(true);
        button.setSize(80, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    a.FahrzeugabstandSetzen(
                            Integer.parseInt(eingabe.getText()));
                }
                catch (Exception ex)
                {
                    (Toolkit.getDefaultToolkit()).beep();
                }
            }
        });
        fenster.add(button);
        l = new Label();
        l.setText("Taktl\u00E4nge in Millisekunden");
        l.setLocation(400, hoeheFenster + 35);
        l.setVisible(true);
        l.setSize(200, 20);
        fenster.add(l);
        eingabe2 = new TextField();
        eingabe2.setLocation(600, hoeheFenster + 35);
        eingabe2.setText("1000");
        eingabe2.setVisible(true);
        eingabe2.setSize(60, 20);
        eingabe2.setEnabled(true);
        fenster.add(eingabe2);
        button = new Button();
        button.setLocation(680, hoeheFenster + 30);
        button.setLabel("Setzen");
        button.setVisible(true);
        button.setSize(80, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    a.TaktdauerSetzen(Integer.parseInt(eingabe2.getText()));
                }
                catch (Exception ex)
                {
                    (Toolkit.getDefaultToolkit()).beep();
                }
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(800, hoeheFenster + 30);
        button.setLabel("Starten");
        button.setVisible(true);
        button.setSize(80, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.Starten();
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(900, hoeheFenster + 30);
        button.setLabel("Anhalten");
        button.setVisible(true);
        button.setSize(80, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.Anhalten();
            }
        });
        fenster.add(button);
    }

    /**
     * Gibt das Ausgabefenster zurück und erzeugt es gegebenenfalls.
     *
     * @return Ausgabefenster
     */
    public static Frame FensterGeben()
    {
        if (o == null)
        {
            o = new OBERFLAECHE();
        }
        return o.fenster;
    }

    /**
     * Gibt die Rastergröße zurück.
     *
     * @return Ausgabefenster
     */
    public static int RasterGroesseGeben()
    {
        return rasterGroesse;
    }

    /**
     * Gibt die Breite des Fensters zurück.
     *
     * @return Fensterbreite
     */
    public static int FensterBreiteGeben()
    {
        return breiteFenster;
    }

    /**
     * Gibt die Höhe des Fensters zurück.
     *
     * @return Fensterhöhe
     */
    public static int FensterHoeheGeben()
    {
        return hoeheFenster;
    }

    /**
     * Gibt die Höhe des Fensters zurück.
     *
     * @return Fensterhöhe
     */
    public static float MeterAlsPixelGeben()
    {
        return meter2pixel;
    }

    /**
     * Setzt den Adapter für die Aktionen.
     *
     * @param a Adapter
     */
    static void AdapterSetzen(ADAPTER a)
    {
        if (o == null)
        {
            o = new OBERFLAECHE();
        }
        o.a = a;
    }
}
