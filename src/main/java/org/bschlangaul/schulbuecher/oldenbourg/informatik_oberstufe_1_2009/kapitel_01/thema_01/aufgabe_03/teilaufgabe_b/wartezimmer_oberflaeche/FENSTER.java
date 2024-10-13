package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_b.wartezimmer_oberflaeche;

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
 * @version 1.0 vom 16.08.2008
 *
 * @author Klaus Reinold
 */
class FENSTER extends Frame
{
    /** überschrift */
    private Label labelUeberschrift = new Label();

    /**
     * Unterüberschrift
     */
    private Label labelUnterueberschrift = new Label();

    /**
     * Schaltfläche zum Aufruf der Methode zum Einfügen eines Patienten, der im
     * Textfeld eingetragen wurde
     */
    private Button knopfEinfuegen = new Button();

    /**
     * Textfeld zum Eintrag eines neuen Patienten
     */
    private TextField textfeld_Einfuegen = new TextField();

    /**
     * Schaltfläche zum Aufruf der Methode zum Entfernen und Anzeigen eines
     * Patienten
     */
    private Button knopf_Entfernen = new Button();

    /**
     * Beschriftung
     */
    private Label labelAufnehmen = new Label();

    /**
     * Beschriftung
     */
    private Label labelEntfernen = new Label();

    /**
     * Label zur Anzeige des nächsten Patienten
     */
    private Label labelNaechster = new Label();

    /**
     * Verwaltete Warteschlange, an die Botschaften über Ereignisse
     * weitergeleitet werden
     */
    WARTESCHLANGE w;
    // Ende Attribute

    /**
     * Konstruktor der Oberfläche Erzeugt ein Fenster mit den zugehörigen
     * Komponenten
     *
     * @param title Fenstertitel
     */
    FENSTER(String title)
    {
        // Frame-Initialisierung
        super(title);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 330;
        int frameHeight = 334;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel fenster = new Panel(null);
        add(fenster);
        final WARTESCHLANGE w;
        w = new WARTESCHLANGE();
        // Anfang Komponenten
        labelUeberschrift.setBounds(8, 8, 289, 24);
        labelUeberschrift.setText("Warteschlangenverwaltung");
        labelUeberschrift.setFont(new Font("MS Sans Serif", Font.PLAIN, 17));
        fenster.add(labelUeberschrift);
        labelUnterueberschrift.setBounds(8, 32, 115, 16);
        labelUnterueberschrift.setText("Praxis Dr. Krankl");
        labelUnterueberschrift
                .setFont(new Font("MS Sans Serif", Font.BOLD, 13));
        fenster.add(labelUnterueberschrift);
        knopfEinfuegen.setBounds(144, 80, 81, 33);
        knopfEinfuegen.setLabel("Einfügen");
        knopfEinfuegen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                w.Einfuegen(new PATIENT(textfeld_Einfuegen.getText()));
            }
        });
        fenster.add(knopfEinfuegen);
        textfeld_Einfuegen.setBounds(8, 80, 121, 24);
        textfeld_Einfuegen.setText("Name eingeben");
        fenster.add(textfeld_Einfuegen);
        knopf_Entfernen.setBounds(144, 128, 81, 33);
        knopf_Entfernen.setLabel("Entfernen");
        knopf_Entfernen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                PATIENT entfernter;
                entfernter = w.Entfernen();
                if (entfernter != null)
                {
                    labelNaechster
                            .setText("Der Nächste: " + entfernter.NameGeben());
                }
                else
                {
                    labelNaechster.setText("Zur Zeit kein Patient ");
                }
                w.Entfernen();
            }
        });
        fenster.add(knopf_Entfernen);
        labelAufnehmen.setBounds(8, 56, 110, 16);
        labelAufnehmen.setText("Patient aufnehmen");
        labelAufnehmen.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelAufnehmen);
        labelEntfernen.setBounds(8, 112, 99, 16);
        labelEntfernen.setText("Patient entfernen");
        labelEntfernen.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelEntfernen);
        labelNaechster.setBounds(8, 136, 246, 16);
        labelNaechster.setText("Zur Zeit kein Patient.");
        labelNaechster.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        fenster.add(labelNaechster);
        // Ende Komponenten
        setResizable(false);
        setVisible(true);
    }
}
