package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_00.warteschlange_ohne_feld;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * Oberfläche zur Verwaltung der Warteschlange Die Klasse wurde mit einer
 * geeigneten Entwicklungsumgebung für grafische Oberflächen erstellt.
 *
 * @version 1.0
 *
 * @author Klaus Reinold
 */

class Fenster extends Frame
{

    /** Überschrift */
    private Label labelÜberschrift;

    /**
     * Unterüberschrift
     */
    private Label labelUnterüberschrift;

    /**
     * Schaltfläche zum Aufruf der Methode zum Einfügen eines Patienten, der im
     * Textfeld eingetragen wurde
     */
    private Button knopfEinfügen;

    /**
     * Textfeld zum Eintrag eines neuen Patienten
     */
    private TextField textfeldEinfügen;

    /**
     * Schaltfläche zum Aufruf der Methode zum Entfernen und Anzeigen eines
     * Patienten
     */
    private Button knopfEntfernen;

    /**
     * Beschriftung
     */
    private Label labelAufnehmen;

    /**
     * Beschriftung
     */
    private Label labelEntfernen;

    /**
     * Label zur Anzeige des nächsten Patienten
     */
    private Label labelNächster;

    /**
     * Verwaltete Warteschlange, an die Botschaften über Ereignisse
     * weitergeleitet werden
     */
    Warteschlange w;

    /**
     * Konstruktor der Oberfläche Erzeugt ein Fenster mit den zugehörigen
     * Komponenten
     */
    Fenster()
    {
        // Frame-Initialisierung
        super("Patientenverwaltung");
        labelÜberschrift = new Label();
        labelUnterüberschrift = new Label();
        knopfEinfügen = new Button();
        textfeldEinfügen = new TextField();
        knopfEntfernen = new Button();
        labelAufnehmen = new Label();
        labelEntfernen = new Label();
        labelNächster = new Label();

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 300;
        int frameHeight = 220;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel fenster = new Panel(null);
        add(fenster);
        w = new Warteschlange();
        // Anfang Komponenten

        labelÜberschrift.setBounds(8, 8, 289, 24);
        labelÜberschrift.setText("Warteschlangenverwaltung");
        labelÜberschrift.setFont(new Font("MS Sans Serif", Font.PLAIN, 17));
        fenster.add(labelÜberschrift);
        labelUnterüberschrift.setBounds(8, 32, 150, 16);
        labelUnterüberschrift.setText("Praxis Dr. Ted Tanus");
        labelUnterüberschrift.setFont(new Font("MS Sans Serif", Font.BOLD, 13));
        fenster.add(labelUnterüberschrift);
        knopfEinfügen.setBounds(180, 75, 81, 33);
        knopfEinfügen.setLabel("Einfügen");
        knopfEinfügen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                w.Einfügen(new Patient(textfeldEinfügen.getText()));
            }
        });
        fenster.add(knopfEinfügen);
        textfeldEinfügen.setBounds(8, 80, 121, 24);
        textfeldEinfügen.setText("Name eingeben");
        fenster.add(textfeldEinfügen);
        knopfEntfernen.setBounds(180, 138, 81, 33);
        knopfEntfernen.setLabel("Entfernen");
        knopfEntfernen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Patient entfernter;
                entfernter = w.Entfernen();
                if (entfernter != null)
                {
                    labelNächster
                            .setText("Beim Arzt: " + entfernter.NameGeben());
                }
                else
                {
                    labelNächster.setText("Zur Zeit kein Patient beim Arzt");
                }
            }
        });
        fenster.add(knopfEntfernen);
        labelAufnehmen.setBounds(8, 56, 240, 16);
        labelAufnehmen.setText("Person in Warteschlange aufnehmen");
        labelAufnehmen.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelAufnehmen);
        labelEntfernen.setBounds(8, 122, 240, 16);
        labelEntfernen.setText("Person aus Warteschlange entfernen");
        labelEntfernen.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelEntfernen);
        labelNächster.setBounds(8, 146, 266, 16);
        labelNächster.setText("Zur Zeit kein beim Arzt");
        labelNächster.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelNächster);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);
    }

}
