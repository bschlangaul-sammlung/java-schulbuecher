package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 * Verwaltet die graphische Bedienoberfläche.
 *
 * @version 1.0
 */
class OBERFLAECHE implements OBERFLAECHENINTERFACE, STATUSBEOBACHTER
{
    private JFrame fenster;

    private JTextField anzahl, kontostand;

    private JList paketListe, aktienListe;

    private JTextArea status;

    private JComboBox konten;

    private KONTROLLEURINTERFACE kontrolleur;

    /**
     * Besetzt die Attribute und baut das Fenster auf.
     *
     * @param kontrolleur Kontrolleur für die Ereignisbehandlung
     */
    OBERFLAECHE(KONTROLLEURINTERFACE kontrolleur)
    {
        this.kontrolleur = kontrolleur;
        FensterAnlegen();
        KontenSetzen();
        AktienlisteSetzen();
    }

    /**
     * Empfängt Fehlermeldungen
     *
     * @param text Text der Fehlermeldung
     */
    public void FehlerSetzen(String text)
    {
        StatuszeileSetzen(text);
    }

    /**
     * Setzt den Text der Statuszeile
     *
     * @param text Statustext
     */
    public void StatuszeileSetzen(String text)
    {
        status.setText(text);
    }

    /**
     * Setzt den Wert des Kontostandes
     *
     * @param wert Kontostand
     */
    public void KontostandsanzeigeSetzen(double wert)
    {
        kontostand.setText("" + wert);
    }

    /**
     * Setzt die Anzeige der Depoteinträge
     *
     * @param eintraege Listeneinträge
     */
    public void DepotlisteSetzen(String[] eintraege)
    {
        paketListe.setListData(eintraege);
    }

    /**
     * Aufbau des Fensters und seiner Elemente
     */
    private void FensterAnlegen()
    {
        JButton button;
        JLabel label;
        JPanel panel;
        JPanel hauptPanel, aktienPanel, einkaufPanel, anzahlPanel, kontoPanel;
        fenster = new JFrame("Aktienhandel");
        // In dem Panel hauptPanel findet die gesamte Darstellung statt.
        // Die Unterelemente (wieder eigene Panele mit Borderlayout)
        // des Hauptpanels werden in ein Raster
        // eingebunden; bei den aktuell vier Unterlelementen
        // entsteht dadurch ein 2x2-Raster
        hauptPanel = new JPanel();
        hauptPanel.setBackground(new Color(140, 140, 140));
        hauptPanel.setLayout(new GridLayout(2, 2, 10, 10));
        // Panel zur Anzeige der Aktien auf dem Markt aufbauen
        aktienPanel = new JPanel();
        aktienPanel.setLayout(new BorderLayout());
        aktienPanel.setBorder(new TitledBorder("Aktien auf dem Markt"));
        aktienListe = new JList();
        aktienListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        aktienListe.setSelectedIndex(1);
        aktienPanel.add(new JScrollPane(aktienListe));
        panel = new JPanel();
        panel.setBackground(new Color(180, 180, 255));
        panel.setLayout(new FlowLayout());
        button = new JButton("Neue Kurse");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.NeueKurswerteBerechnen();
            }
        });
        panel.add(button);
        button = new JButton("Kursverlauf anzeigen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.KursverlaufAnzeigen(
                        aktienListe.getSelectedIndex() + 1);
            }
        });
        aktienPanel.add(panel, BorderLayout.SOUTH);
        hauptPanel.add(aktienPanel);
        // Panel zum Ein- und Verkaufen der Aktien aufbauen
        einkaufPanel = new JPanel();
        einkaufPanel.setBackground(new Color(220, 220, 255));
        einkaufPanel.setLayout(new BorderLayout(10, 10));
        einkaufPanel.setBorder(new TitledBorder("Aktienhandel"));
        // Bereich für Eingabe der Stückzahl
        panel = new JPanel();
        panel.setBackground(new Color(180, 180, 255));
        panel.setLayout(new GridLayout(1, 2, 10, 10));
        panel.add(new JLabel("St\u00FCckzahl: "));
        anzahl = new JTextField("0", 10);
        panel.add(anzahl);
        einkaufPanel.add(panel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setBackground(new Color(180, 180, 255));
        panel.setLayout(new FlowLayout());
        button = new JButton("Aktie kaufen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.AktienKaufen(aktienListe.getSelectedIndex() + 1,
                        Integer.parseInt(anzahl.getText()));
            }
        });
        button = new JButton("Aktie verkaufen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.AktienVerkaufen(aktienListe.getSelectedIndex() + 1,
                        Integer.parseInt(anzahl.getText()));
            }
        });
        einkaufPanel.add(panel, BorderLayout.SOUTH);
        hauptPanel.add(einkaufPanel);
        // Bereich zum Anzeigen des Aktiendepots als Liste
        paketListe = new JList();
        paketListe.setBorder(new TitledBorder("Aktien im Depot"));
        paketListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        paketListe.setSelectedIndex(1);
        hauptPanel.add(new JScrollPane(paketListe));
        // Bereich zum Anzeigen des Kontostandes des Girokontos
        kontoPanel = new JPanel();
        kontoPanel.setBackground(new Color(220, 220, 255));
        kontoPanel.setLayout(new BorderLayout(10, 10));
        kontoPanel.setBorder(new TitledBorder("Konto"));
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(180, 180, 255));
        panel.add(new JLabel("Kontostand:"));
        kontostand = new JTextField("   ", 10);
        panel.add(kontostand);
        kontoPanel.add(panel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(180, 180, 255));
        panel.add(new JLabel("Gew\u00E4hltes Konto:"));
        konten = new JComboBox();
        panel.add(konten);
        kontoPanel.add(panel, BorderLayout.SOUTH);
        hauptPanel.add(kontoPanel);
        fenster.getContentPane().setLayout(new BorderLayout());
        fenster.getContentPane().add(hauptPanel, BorderLayout.NORTH);
        button = new JButton("Ende");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.Beenden();
            }
        });
        fenster.getContentPane().add(button, BorderLayout.SOUTH);
        status = new JTextArea("");
        fenster.getContentPane().add(new JScrollPane(status),
                BorderLayout.CENTER);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                kontrolleur.Beenden();
            }
        });
        fenster.setSize(800, 500);
        fenster.setVisible(true);
    }

    /**
     * Setzt die Liste für die Aktien.
     */
    private void AktienlisteSetzen()
    {
        aktienListe.setListData(kontrolleur.AktienNamenGeben());
    }

    /**
     * Setzt die Konten.
     */
    private void KontenSetzen()
    {
        int[] nummern;
        nummern = kontrolleur.KontennummernGeben();
        for (int i = 0; i < nummern.length; i++)
        {
            konten.addItem("" + nummern[i]);
        }
        konten.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                kontrolleur.KontoSetzen(
                        Integer.parseInt((String) konten.getSelectedItem()));
            }
        });
    }
}
