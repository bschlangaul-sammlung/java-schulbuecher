package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Die Bedienoberfläche für einen Angestellten des Reisebüros.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
class OBERFLAECHE implements OBERFLACHENINTERFACE, MELDUNGSBEOBACHTER
{
    private JFrame fenster;

    private JTabbedPane auswahl;

    private JPanel laenderverwaltung, objektverwaltung, kundenverwaltung,
            buchungsverwaltung;

    private JLabel status;

    private JList laenderListe, buchungsListe;

    private JTextField laendername;

    private JComboBox objektmenu, kundenmenu, objektmenubuchungen,
            kundenmenubuchungen;

    private JLabel objektnummer, kundenbenutzer;

    private JTextField objektname, objektgroesse, zimmeranzahl, personenanzahl,
            preis;

    private JTextField kundenname, kundenvorname;

    private JPasswordField pass1, pass2;

    private JComboBox land, art;

    private JCheckBox sperre;

    private JCheckBox[] ausstattung;

    private JButton buchungLoeschen, reservierungBuchen;

    private KONTROLLEURINTERFACE kontrolleur;

    /**
     * Baut die Fensterstruktur auf.
     */
    OBERFLAECHE(KONTROLLEURINTERFACE k)
    {
        JPanel content;
        JPanel panel, panel2;
        JButton button;
        kontrolleur = k;
        fenster = new JFrame("Objektverwaltung");
        content = (JPanel) fenster.getContentPane();
        content.setLayout(new BorderLayout());
        auswahl = new JTabbedPane();
        content.add(auswahl, BorderLayout.CENTER);
        objektverwaltung = new JPanel();
        auswahl.addTab("Objekte bearbeiten", objektverwaltung);
        objektverwaltung.setLayout(new BorderLayout());
        objektmenu = new JComboBox();
        objektverwaltung.add(objektmenu, BorderLayout.NORTH);
        objektmenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.ObjektAuswaehlen(objektmenu.getSelectedItem());
            }
        });
        panel2 = new JPanel();
        objektverwaltung.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new BorderLayout());
        panel = new JPanel();
        panel2.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(9, 2, 10, 5));
        panel.add(new JLabel("Objektnummer"));
        objektnummer = new JLabel("");
        panel.add(objektnummer);
        panel.add(new JLabel("Name des Objekts"));
        objektname = new JTextField("");
        panel.add(objektname);
        panel.add(new JLabel("Gr\u00F6\u00DFe in qm"));
        objektgroesse = new JTextField("");
        panel.add(objektgroesse);
        panel.add(new JLabel("Anzahl der Zimmer"));
        zimmeranzahl = new JTextField("");
        panel.add(zimmeranzahl);
        panel.add(new JLabel("Maximale Anzahl Personen"));
        personenanzahl = new JTextField("");
        panel.add(personenanzahl);
        panel.add(new JLabel("Land"));
        land = new JComboBox();
        panel.add(land);
        panel.add(new JLabel("Art"));
        String[] items = { "Haus", "Wohnung" };
        art = new JComboBox(items);
        panel.add(art);
        panel.add(new JLabel("Preis"));
        preis = new JTextField("");
        panel.add(preis);
        panel.add(new JLabel("Sperre"));
        sperre = new JCheckBox("");
        panel.add(sperre);
        panel = new JPanel();
        panel2.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(2, 3, 5, 5));
        ausstattung = new JCheckBox[6];
        ausstattung[0] = new JCheckBox("Fernseher");
        panel.add(ausstattung[0]);
        ausstattung[1] = new JCheckBox("Waschmaschine");
        panel.add(ausstattung[1]);
        ausstattung[2] = new JCheckBox("Trockner");
        panel.add(ausstattung[2]);
        ausstattung[3] = new JCheckBox("Kühlschrank");
        panel.add(ausstattung[3]);
        ausstattung[4] = new JCheckBox("Gefrierschrank");
        panel.add(ausstattung[4]);
        ausstattung[5] = new JCheckBox("Swimmingpool");
        panel.add(ausstattung[5]);
        panel = new JPanel();
        objektverwaltung.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout());
        button = new JButton("Neu");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean[] aus;
                aus = new boolean[6];
                for (int i = 0; i < ausstattung.length; i++)
                {
                    aus[i] = ausstattung[i].isSelected();
                }
                kontrolleur.NeuesObjektAnlegen(objektname.getText(),
                        Integer.parseInt(objektgroesse.getText()),
                        Integer.parseInt(zimmeranzahl.getText()),
                        Integer.parseInt(personenanzahl.getText()),
                        land.getSelectedItem(), (String) art.getSelectedItem(),
                        Double.parseDouble(preis.getText()),
                        sperre.isSelected(), aus);
            }
        });
        button = new JButton("\u00C4ndern");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean[] aus;
                aus = new boolean[6];
                for (int i = 0; i < ausstattung.length; i++)
                {
                    aus[i] = ausstattung[i].isSelected();
                }
                kontrolleur.ObjektAendern(
                        Integer.parseInt(objektnummer.getText()),
                        objektname.getText(),
                        Integer.parseInt(objektgroesse.getText()),
                        Integer.parseInt(zimmeranzahl.getText()),
                        Integer.parseInt(personenanzahl.getText()),
                        land.getSelectedItem(), (String) art.getSelectedItem(),
                        Double.parseDouble(preis.getText()),
                        sperre.isSelected(), aus);
            }
        });
        button = new JButton("L\u00F6schen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.ObjektLoeschen(
                        Integer.parseInt(objektnummer.getText()));
            }
        });
        laenderverwaltung = new JPanel();
        auswahl.addTab("L\u00E4nder eintragen", laenderverwaltung);
        laenderverwaltung.setLayout(new GridLayout(1, 2, 10, 10));
        laenderListe = new JList();
        laenderverwaltung.add(laenderListe);
        panel = new JPanel();
        laenderverwaltung.add(panel);
        panel.setLayout(new BorderLayout());
        laendername = new JTextField("");
        panel.add(laendername, BorderLayout.NORTH);
        button = new JButton("Eintragen");
        panel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.LandEintragen(laendername.getText());
            }
        });
        kundenverwaltung = new JPanel();
        auswahl.addTab("Kunden bearbeiten", kundenverwaltung);
        kundenverwaltung.setLayout(new BorderLayout(1, 10));
        kundenmenu = new JComboBox();
        kundenverwaltung.add(kundenmenu, BorderLayout.NORTH);
        kundenmenu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.KundeAuswaehlen(kundenmenu.getSelectedItem());
            }
        });
        panel2 = new JPanel();
        kundenverwaltung.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panel = new JPanel();
        panel2.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2, 10, 5));
        panel.add(new JLabel("Benutzername"));
        kundenbenutzer = new JLabel("");
        panel.add(kundenbenutzer);
        panel.add(new JLabel("Name des Kunden"));
        kundenname = new JTextField("");
        panel.add(kundenname);
        panel.add(new JLabel("Vorname des Kunden"));
        kundenvorname = new JTextField("");
        panel.add(kundenvorname);
        panel = new JPanel();
        panel2.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout());
        button = new JButton("Neu");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.NeuenKundenAnlegen(kundenname.getText(),
                        kundenvorname.getText());
            }
        });
        button = new JButton("\u00C4ndern");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.KundenAendern(kundenbenutzer.getText(),
                        kundenname.getText(), kundenvorname.getText());
            }
        });
        button = new JButton("L\u00F6schen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.KundenLoeschen(kundenbenutzer.getText());
            }
        });
        panel2 = new JPanel();
        kundenverwaltung.add(panel2, BorderLayout.SOUTH);
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        panel = new JPanel();
        panel2.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 2, 10, 5));
        panel.add(new JLabel("Passwort"));
        pass1 = new JPasswordField("");
        panel.add(pass1);
        panel.add(new JLabel("Wiederholung"));
        pass2 = new JPasswordField("");
        panel.add(pass2);
        panel = new JPanel();
        panel2.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout());
        button = new JButton("Passwort setzen");
        panel.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String p = new String(pass1.getPassword());
                if (p.equals(new String(pass2.getPassword())))
                {
                    kontrolleur.PasswortSetzen(kundenbenutzer.getText(), p);
                }
            }
        });
        buchungsverwaltung = new JPanel();
        auswahl.addTab("Buchungen bearbeiten", buchungsverwaltung);
        buchungsverwaltung.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        buchungsverwaltung.add(panel, BorderLayout.NORTH);
        objektmenubuchungen = new JComboBox();
        panel.add(objektmenubuchungen);
        objektmenubuchungen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.BuchungenFuerObjektHolen(
                        objektmenubuchungen.getSelectedItem());
            }
        });
        kundenmenubuchungen = new JComboBox();
        panel.add(kundenmenubuchungen);
        kundenmenubuchungen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.BuchungenFuerKundeHolen(
                        kundenmenubuchungen.getSelectedItem());
            }
        });
        buchungsListe = new JList();
        buchungsverwaltung.add(buchungsListe, BorderLayout.CENTER);
        buchungsListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buchungsListe.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                int index;
                index = buchungsListe.getSelectedIndex();
                if (index == -1)
                {
                    buchungLoeschen.setEnabled(false);
                    reservierungBuchen.setEnabled(false);
                }
                else
                {
                    buchungLoeschen.setEnabled(true);
                    reservierungBuchen.setEnabled(true);
                }
            }
        });
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        buchungsverwaltung.add(panel, BorderLayout.SOUTH);
        buchungLoeschen = new JButton("Buchung l\u00F6schen");
        panel.add(buchungLoeschen);
        buchungLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.BuchungLoeschen(buchungsListe.getModel()
                        .getElementAt(buchungsListe.getSelectedIndex()));
            }
        });
        reservierungBuchen = new JButton("Reservierung buchen");
        panel.add(reservierungBuchen);
        reservierungBuchen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.ReservierungBuchen(buchungsListe.getModel()
                        .getElementAt(buchungsListe.getSelectedIndex()));
            }
        });
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        content.add(panel, BorderLayout.SOUTH);
        panel.add(new JLabel("Status: "), BorderLayout.WEST);
        status = new JLabel();
        panel.add(status, BorderLayout.CENTER);
        button = new JButton("Benden");
        panel.add(button, BorderLayout.EAST);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.Beenden();
            }
        });
        auswahl.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                kontrolleur.TabAuswaehlen(
                        auswahl.getTitleAt(auswahl.getSelectedIndex()));
            }
        });
        fenster.setSize(600, 500);
        fenster.setVisible(true);
    }

    /**
     * Besetzt alle Anzeigeelemente mit Länderdaten
     *
     * @param daten Feld mit den Länderinformationen
     */
    public void LaenderSetzen(Object[] daten)
    {
        laenderListe.setListData(daten);
        land.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            land.addItem(daten[i]);
        }
    }

    /**
     * Besetzt die Liste der Buchungen
     *
     * @param daten Feld mit den Buchungsinformationen
     */
    public void BuchungenSetzen(Object[] daten)
    {
        buchungsListe.setListData(daten);
        buchungLoeschen.setEnabled(false);
        reservierungBuchen.setEnabled(false);
    }

    /**
     * Besetzt das Auswahlmenü mit Objektdaten
     *
     * @param daten Feld mit den Objektinformationen
     */
    public void ObjekteSetzen(Object[] daten)
    {
        objektmenu.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            objektmenu.addItem(daten[i]);
        }
        objektmenubuchungen.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            objektmenubuchungen.addItem(daten[i]);
        }
    }

    /**
     * Besetzt die Anzeigeelemente für ein bestimmtes Objekt.
     *
     * @param nummer die Objektnummer
     * @param name Name des Objekts
     * @param groesse Objektgröße in qm
     * @param zimmer Anzahl der Zimmer
     * @param personen Anzahl der Personen
     * @param landinfo Infoobjekt für das Land des Objekts
     * @param a Art des Objekts
     * @param p Preis des Objekts
     * @param sperr Sperrinformation für dieses Objekt
     * @param aus Feld mit der Ausstattunsinformation
     */
    public void ObjektInfoSetzen(int nummer, String name, int groesse,
            int zimmer, int personen, Object landinfo, String a, double p,
            boolean sperr, boolean[] aus)
    {
        objektnummer.setText("" + nummer);
        objektname.setText(name);
        objektgroesse.setText("" + groesse);
        zimmeranzahl.setText("" + zimmer);
        personenanzahl.setText("" + personen);
        land.setSelectedItem(landinfo);
        art.setSelectedItem(a);
        preis.setText("" + p);
        sperre.setSelected(sperr);
        for (int i = 0; i < ausstattung.length; i++)
        {
            ausstattung[i].setSelected(aus[i]);
        }
    }

    /**
     * Besetzt das Auswahlmenü mit Kundendaten
     *
     * @param daten Feld mit den Kundeninformationen
     */
    public void KundenSetzen(Object[] daten)
    {
        kundenmenu.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            kundenmenu.addItem(daten[i]);
        }
        kundenmenubuchungen.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            kundenmenubuchungen.addItem(daten[i]);
        }
    }

    /**
     * Besetzt die Anzeigeelemente für einen bestimmten Kunden.
     *
     * @param benutzername der Benutzername des Kunden
     * @param name Name
     * @param vorname Vorname
     */
    public void KundenInfoSetzen(String benutzername, String name,
            String vorname)
    {
        kundenbenutzer.setText(benutzername);
        kundenname.setText(name);
        kundenvorname.setText(vorname);
    }

    /**
     * Wählt im Objektmenü das angegebene Objekt aus
     *
     * @param obj das auszuwählende Objekt
     */
    public void ObjektWaehlen(Object obj)
    {
        objektmenu.setSelectedItem(obj);
    }

    /**
     * Wählt im Kundenmenü den angegebenen Kunden aus
     *
     * @param kunde der auszuwählende Kunde
     */
    public void KundeWaehlen(Object kunde)
    {
        kundenmenu.setSelectedItem(kunde);
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    public void FehlermeldungEmpfangen(String text)
    {
        JOptionPane.showMessageDialog(null, text, "Fehlermeldung",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Aktionslog für den Ablauf
     */
    public void LogeintragEmpfangen(String text)
    {
        status.setText(text);
    }
}
