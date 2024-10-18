package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_08.arzt;

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
 * Fenster zur Ausgabe
 *
 * @version 1.0 vom 07.01.2009
 *
 * @author Klaus Reinold
 */
class Fenster extends Frame
{
    // Anfang Attribute
    private Label label1 = new Label();

    private Label label2 = new Label();

    private Label label3 = new Label();

    private Label label4 = new Label();

    /**
     * Textfeld zum Eintrag eines neuen Patienten
     */
    private TextField eingabePatient = new TextField();

    /**
     * Knopf zur Aufnahme des Patienten im Textfeld bei Dr. Linde
     */
    private Button aufnahmeknopfLinde = new Button();

    /**
     * Knopf zur Aufnahme des Patienten im Textfeld bei Dr. Eiche
     */
    private Button aufnahmeknopfEiche = new Button();

    /**
     * Knopf zur Aufnahme des Patienten im Textfeld bei Dr. Buche
     */
    private Button aufnahmeknopfBuche = new Button();

    /**
     * Knopf zur Aufnahme des Patienten im Textfeld bei Dr. Buche
     */
    private Button aufnahmeknopfEgal = new Button();

    private Label label5 = new Label();

    /**
     * Knopf zur Ausgabe des nächste Patienten für Dr. Linde
     */
    private Button ausgabeknopfLinde = new Button();

    /**
     * Knopf zur Ausgabe des nächste Patienten für Dr. Eiche
     */
    private Button ausgabeknopfEiche = new Button();

    /**
     * Knopf zur Ausgabe des nächste Patienten für Dr. Buche
     */
    private Button ausgabeknopfBuche = new Button();

    /**
     * Label zur Ausgabe des nächste Patienten für Dr. Linde
     */
    private Label ausgabeLinde = new Label();

    /**
     * Label zur Ausgabe des nächste Patienten für Dr. Eiche
     */
    private Label ausgabeEiche = new Label();

    /**
     * Knopf zur Ausgabe des nächste Patienten für Dr. Buche
     */
    private Label ausgabeBuche = new Label();

    /**
     * Verwaltete Praxis
     */
    private Gemeinschaftspraxis praxis;
    // Ende Attribute

    /**
     *
     * Erzeugt ein neues Fenster
     *
     * @param g verwaltete Praxis
     */
    Fenster(Gemeinschaftspraxis g)
    {
        // Frame-Initialisierung
        super("Praxisverwaltung");
        praxis = g;
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 336;
        int frameHeight = 369;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel cp = new Panel(null);
        add(cp);
        // Anfang Komponenten
        label1.setBounds(8, 8, 223, 29);
        label1.setText("Gemeinschaftspraxis");
        label1.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
        cp.add(label1);
        label2.setBounds(8, 40, 162, 16);
        label2.setText("Warteschlangenverwaltung");
        label2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label2);
        label3.setBounds(8, 88, 84, 16);
        label3.setText("Name Patient:");
        label3.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label3);
        eingabePatient.setBounds(96, 80, 193, 24);
        eingabePatient.setText("Name eingeben");
        cp.add(eingabePatient);
        label4.setBounds(8, 120, 214, 16);
        label4.setText("Aufnehmen in Warteschlange für Dr.:");
        label4.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label4);
        aufnahmeknopfLinde.setBounds(8, 144, 73, 33);
        aufnahmeknopfLinde.setLabel("Linde");
        aufnahmeknopfLinde.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Patient p;
                p = new Patient(eingabePatient.getText(), "Linde");
                praxis.Aufnehmen(p);
            }
        });
        cp.add(aufnahmeknopfLinde);
        aufnahmeknopfEiche.setBounds(88, 144, 73, 33);
        aufnahmeknopfEiche.setLabel("Eiche");
        aufnahmeknopfEiche.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Patient p;
                p = new Patient(eingabePatient.getText(), "Eiche");
                praxis.Aufnehmen(p);
            }
        });
        cp.add(aufnahmeknopfEiche);
        aufnahmeknopfBuche.setBounds(168, 144, 73, 33);
        aufnahmeknopfBuche.setLabel("Buche");
        aufnahmeknopfBuche.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Patient p;
                p = new Patient(eingabePatient.getText(), "Buche");
                praxis.Aufnehmen(p);
            }
        });
        cp.add(aufnahmeknopfBuche);
        aufnahmeknopfEgal.setBounds(248, 144, 73, 33);
        aufnahmeknopfEgal.setLabel("egal");
        aufnahmeknopfEgal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Patient p;
                p = new Patient(eingabePatient.getText(), "");
                praxis.Aufnehmen(p);
            }
        });
        cp.add(aufnahmeknopfEgal);
        label5.setBounds(8, 192, 138, 16);
        label5.setText("Nächster Patient für Dr.:");
        label5.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label5);
        ausgabeknopfLinde.setBounds(8, 224, 73, 33);
        ausgabeknopfLinde.setLabel("Linde");
        ausgabeknopfLinde.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                ausgabeLinde.setText(praxis.Ausgeben("Linde"));
            }
        });
        cp.add(ausgabeknopfLinde);
        ausgabeknopfEiche.setBounds(8, 264, 73, 33);
        ausgabeknopfEiche.setLabel("Eiche");
        ausgabeknopfEiche.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                ausgabeEiche.setText(praxis.Ausgeben("Eiche"));
            }
        });
        cp.add(ausgabeknopfEiche);
        ausgabeknopfBuche.setBounds(8, 304, 73, 33);
        ausgabeknopfBuche.setLabel("Buche");
        ausgabeknopfBuche.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                ausgabeBuche.setText(praxis.Ausgeben("Buche"));
            }
        });
        cp.add(ausgabeknopfBuche);
        ausgabeLinde.setBounds(96, 232, 135, 16);
        ausgabeLinde.setText("leer");
        ausgabeLinde.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(ausgabeLinde);
        ausgabeEiche.setBounds(96, 272, 135, 16);
        ausgabeEiche.setText("leer");
        ausgabeEiche.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(ausgabeEiche);
        ausgabeBuche.setBounds(96, 312, 135, 16);
        ausgabeBuche.setText("leer");
        ausgabeBuche.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(ausgabeBuche);
        // Ende Komponenten
        setResizable(false);
        setVisible(true);
    }
}
