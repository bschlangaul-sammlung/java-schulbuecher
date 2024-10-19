package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Die Bedienoberfläche für einen Kunden des Reisebüros.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
class OBERFLAECHE implements OBERFLACHENINTERFACE, MELDUNGSBEOBACHTER
{
    private JFrame fenster;

    private CardLayout cards;

    private JTextField benutzername;

    private JPasswordField passwort;

    private JTabbedPane auswahl;

    private JPanel start;

    private JLabel status;

    private JLabel namensZeile, infozeile, ausstattungsZeile, belegtZeile;

    private JComboBox land, art, personenmin, personenmax, zimmermin, zimmermax;

    private JComboBox tagmin, monmin, jahrmin, tagmax, monmax, jahrmax;

    private JComboBox tagminr, monminr, jahrminr, tagmaxr, monmaxr, jahrmaxr;

    private JCheckBox[] ausstattung;

    private JList auswahlListe;

    private JList reservierungsListe;

    private JButton reservierungEintragen, buchen, loeschen;

    private JPasswordField pass1, pass2;

    private SimpleDateFormat konvert;

    private KONTROLLEURINTERFACE kontrolleur;

    /**
     * Baut die Fensterstruktur auf.
     */

    OBERFLAECHE(KONTROLLEURINTERFACE k)
    {
        String[] tage = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31" };
        String[] monate = { "Jan", "Feb", "M\u00E4r", "Apr", "Mai", "Jun",
                "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" };
        String[] jahre = { "2008", "2009", "2010", "2011", "2012" };
        JPanel content;
        JPanel panel, panel2, panel3;
        JButton button;
        kontrolleur = k;
        konvert = new SimpleDateFormat("dd-MM-yyyy");
        // Fenster und Basispanele aufbauen
        fenster = new JFrame("Ferienwohnungen");
        content = (JPanel) fenster.getContentPane();
        content.setLayout(new BorderLayout());
        start = new JPanel();
        content.add(start, BorderLayout.CENTER);
        cards = new CardLayout();
        start.setLayout(cards);
        auswahl = new JTabbedPane();
        // Anmeldekarte aufbauen
        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Anmeldung"));
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Benutzername"));
        benutzername = new JTextField("");
        panel.add(benutzername);
        panel.add(new JLabel("Passwort"));
        passwort = new JPasswordField("");
        panel.add(passwort);
        button = new JButton("Anmelden");
        panel2.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.Anmelden(benutzername.getText(),
                        new String(passwort.getPassword()));
            }
        });
        fenster.getRootPane().setDefaultButton(button);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panel2, BorderLayout.NORTH);
        start.add(panel, "Anmeldung");
        // Benutzerkarte aufbauen
        start.add(auswahl, "Auswahl");
        // Reservierungsauswahl
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4, 10, 0));
        panel.add(new JLabel("Land"));
        panel.add(new JLabel("Art"));
        panel.add(new JLabel("Personen"));
        panel.add(new JLabel("Zimmer"));
        land = new JComboBox();
        panel.add(land);
        String[] items = { "Alles", "Haus", "Wohnung" };
        art = new JComboBox(items);
        panel.add(art);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        String[] items2 = { "1", "2", "3", "4", "5", "6", "7", "8", "9+" };
        personenmin = new JComboBox(items2);
        panel3.add(personenmin);
        panel3.add(new JLabel("bis"));
        personenmax = new JComboBox(items2);
        personenmax.setSelectedIndex(personenmax.getItemCount() - 1);
        panel3.add(personenmax);
        panel.add(panel3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        String[] items3 = { "1", "2", "3", "4", "5", "6", "7+" };
        zimmermin = new JComboBox(items3);
        panel3.add(zimmermin);
        panel3.add(new JLabel("bis"));
        zimmermax = new JComboBox(items3);
        zimmermax.setSelectedIndex(zimmermax.getItemCount() - 1);
        panel3.add(zimmermax);
        panel.add(panel3);
        panel2.add(panel, BorderLayout.NORTH);
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
        ausstattung[3] = new JCheckBox("K\u00FChlschrank");
        panel.add(ausstattung[3]);
        ausstattung[4] = new JCheckBox("Gefrierschrank");
        panel.add(ausstattung[4]);
        ausstattung[5] = new JCheckBox("Swimmingpool");
        panel.add(ausstattung[5]);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panel2, BorderLayout.NORTH);
        button = new JButton("Suchen");
        panel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean[] aus;
                Date start;
                Date ende;
                aus = new boolean[6];
                for (int i = 0; i < ausstattung.length; i++)
                {
                    aus[i] = ausstattung[i].isSelected();
                }
                try
                {
                    start = konvert.parse("0" + (tagmin.getSelectedIndex() + 1)
                            + "-0" + (monmin.getSelectedIndex() + 1) + "-"
                            + ((String) jahrmin.getSelectedItem()));
                    ende = konvert.parse("0" + (tagmax.getSelectedIndex() + 1)
                            + "-0" + (monmax.getSelectedIndex() + 1) + "-"
                            + ((String) jahrmax.getSelectedItem()));
                }
                catch (Exception ex)
                {
                    return;
                }
                kontrolleur.ObjekteSuchen(land.getSelectedItem(),
                        (String) art.getSelectedItem(),
                        personenmin.getSelectedIndex() == personenmin
                                .getItemCount() - 1 ? Integer.MAX_VALUE
                                        : personenmin.getSelectedIndex() + 1,
                        personenmax.getSelectedIndex() == personenmax
                                .getItemCount() - 1 ? Integer.MAX_VALUE
                                        : personenmax.getSelectedIndex() + 1,
                        zimmermin.getSelectedIndex() == zimmermin.getItemCount()
                                - 1 ? Integer.MAX_VALUE
                                        : zimmermin.getSelectedIndex() + 1,
                        zimmermax.getSelectedIndex() == zimmermax.getItemCount()
                                - 1 ? Integer.MAX_VALUE
                                        : zimmermax.getSelectedIndex() + 1,
                        aus, start, ende);
            }
        });
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(panel, BorderLayout.SOUTH);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Zeitraum "));
        panel.add(new JLabel(" von "));
        tagmin = new JComboBox(tage);
        panel.add(tagmin);
        monmin = new JComboBox(monate);
        panel.add(monmin);
        jahrmin = new JComboBox(jahre);
        panel.add(jahrmin);
        panel.add(new JLabel(" bis "));
        tagmax = new JComboBox(tage);
        panel.add(tagmax);
        monmax = new JComboBox(monate);
        panel.add(monmax);
        jahrmax = new JComboBox(jahre);
        panel.add(jahrmax);
        panel2.add(panel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(panel2, BorderLayout.NORTH);
        auswahlListe = new JList();
        auswahlListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        auswahlListe.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                Date start;
                Date ende;
                int index;
                index = auswahlListe.getSelectedIndex();
                if (index == -1)
                {
                    reservierungEintragen.setEnabled(false);
                }
                else
                {
                    try
                    {
                        start = konvert.parse(
                                "0" + (tagmin.getSelectedIndex() + 1) + "-0"
                                        + (monmin.getSelectedIndex() + 1) + "-"
                                        + ((String) jahrmin.getSelectedItem()));
                        ende = konvert.parse(
                                "0" + (tagmax.getSelectedIndex() + 1) + "-0"
                                        + (monmax.getSelectedIndex() + 1) + "-"
                                        + ((String) jahrmax.getSelectedItem()));
                    }
                    catch (Exception ex)
                    {
                        return;
                    }
                    reservierungEintragen.setEnabled(true);
                    kontrolleur.ObjektAnzeigen(
                            auswahlListe.getModel().getElementAt(index), start,
                            ende);
                }
            }
        });
        panel.add(auswahlListe, BorderLayout.CENTER);
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1, 1, 1));
        namensZeile = new JLabel(" ");
        panel2.add(namensZeile);
        infozeile = new JLabel(" ");
        panel2.add(infozeile);
        ausstattungsZeile = new JLabel(" ");
        panel2.add(ausstattungsZeile);
        belegtZeile = new JLabel(" ");
        panel2.add(belegtZeile);
        panel3.add(panel2, BorderLayout.NORTH);
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(new JLabel("Zeitraum "));
        panel2.add(new JLabel(" von "));
        tagminr = new JComboBox(tage);
        panel2.add(tagminr);
        monminr = new JComboBox(monate);
        panel2.add(monminr);
        jahrminr = new JComboBox(jahre);
        panel2.add(jahrminr);
        panel2.add(new JLabel(" bis "));
        tagmaxr = new JComboBox(tage);
        panel2.add(tagmaxr);
        monmaxr = new JComboBox(monate);
        panel2.add(monmaxr);
        jahrmaxr = new JComboBox(jahre);
        panel2.add(jahrmaxr);
        reservierungEintragen = new JButton("Reservieren");
        reservierungEintragen.setEnabled(false);
        reservierungEintragen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date start;
                Date ende;
                try
                {
                    start = konvert.parse("0" + (tagminr.getSelectedIndex() + 1)
                            + "-0" + (monminr.getSelectedIndex() + 1) + "-"
                            + ((String) jahrminr.getSelectedItem()));
                    ende = konvert.parse("0" + (tagmaxr.getSelectedIndex() + 1)
                            + "-0" + (monmaxr.getSelectedIndex() + 1) + "-"
                            + ((String) jahrmaxr.getSelectedItem()));
                }
                catch (Exception ex)
                {
                    return;
                }
                kontrolleur
                        .ObjektReservieren(
                                auswahlListe.getModel().getElementAt(
                                        auswahlListe.getSelectedIndex()),
                                start, ende);
            }
        });
        panel2.add(reservierungEintragen);
        panel3.add(panel2, BorderLayout.SOUTH);
        panel.add(panel3, BorderLayout.SOUTH);
        auswahl.addTab("Objektauswahl und Reservierung", panel);
        // Buchungen erledigen
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        reservierungsListe = new JList();
        reservierungsListe
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reservierungsListe.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                int index;
                index = reservierungsListe.getSelectedIndex();
                if (index == -1)
                {
                    buchen.setEnabled(false);
                    loeschen.setEnabled(false);
                }
                else
                {
                    buchen.setEnabled(true);
                    loeschen.setEnabled(true);
                }
            }
        });
        panel.add(reservierungsListe, BorderLayout.CENTER);
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        buchen = new JButton("Objekt fest buchen");
        buchen.setEnabled(false);
        buchen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.ObjektBuchen(reservierungsListe.getModel()
                        .getElementAt(reservierungsListe.getSelectedIndex()));
            }
        });
        panel2.add(buchen);
        loeschen = new JButton("Reservierung l\u00F6schen");
        loeschen.setEnabled(false);
        loeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.ReservierungLoeschen(reservierungsListe.getModel()
                        .getElementAt(reservierungsListe.getSelectedIndex()));
            }
        });
        panel2.add(loeschen);
        panel.add(panel2, BorderLayout.SOUTH);
        auswahl.addTab("Buchen und Reservierungen bearbeiten", panel);
        // Benutzerprofil bearbeiten
        panel = new JPanel();
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel3 = new JPanel();
        panel2.add(panel3, BorderLayout.NORTH);
        panel3.setLayout(new GridLayout(2, 2, 10, 5));
        panel3.add(new JLabel("Passwort"));
        pass1 = new JPasswordField("");
        panel3.add(pass1);
        panel3.add(new JLabel("Wiederholung"));
        pass2 = new JPasswordField("");
        panel3.add(pass2);
        panel3 = new JPanel();
        panel2.add(panel3, BorderLayout.SOUTH);
        panel3.setLayout(new FlowLayout());
        button = new JButton("Passwort setzen");
        panel3.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String p = new String(pass1.getPassword());
                if (p.equals(new String(pass2.getPassword())))
                {
                    kontrolleur.PasswortSetzen(p);
                }
            }
        });
        panel.add(panel2, BorderLayout.NORTH);
        auswahl.addTab("Eigene Daten", panel);
        // Feststehende Statusanzeig am Fuß des Fensters
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
        fenster.setSize(800, 500);
        fenster.setVisible(true);
        /* %%%%% */
        StatusSetzen(Status.anmleden);
    }

    /**
     * Setzt die Oberfläche auf den angegebenen Status.
     *
     * @param status der zu setzende Status
     */
    public void StatusSetzen(Status status)
    {
        switch (status)
        {
        case anmleden:
            cards.show(start, "Anmeldung");
            break;

        case auswaehlen:
            cards.show(start, "Auswahl");
            fenster.getRootPane().setDefaultButton(null);
            break;

        default:
            // nix
        }
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

    /**
     * Setzen der Statuszeile durch den Kontrolleur
     *
     * @param text der Anzeigetext;
     */
    public void StatuszeileSetzen(String text)
    {
        status.setText(text);
    }

    /**
     * Besetzt das Auswahlmenü mit den Länderdaten
     *
     * @param daten Feld mit den Länderinformationen
     * @param keines Symbol für "keine Angabe"
     */
    public void LaenderSetzen(Object[] daten, Object keines)
    {
        land.removeAllItems();
        land.addItem(keines);
        for (int i = 0; i < daten.length; i++)
        {
            land.addItem(daten[i]);
        }
    }

    /**
     * Besetzt die Liste der gefundenen Objekte
     *
     * @param daten Feld mit den Objektinformationen
     */
    public void AuswahllisteSetzen(Object[] daten)
    {
        if (daten == null)
        {
            auswahlListe.removeAll();
        }
        else
        {
            auswahlListe.setListData(daten);
        }
    }

    /**
     * Besetzt die Liste der reservierten Objekte
     *
     * @param daten Feld mit den Reservierungsinformationen
     */
    public void ReservierungslisteSetzen(Object[] daten)
    {
        if (daten == null)
        {
            reservierungsListe.removeAll();
        }
        else
        {
            reservierungsListe.setListData(daten);
        }
    }

    /**
     * Setzt die Information für das ausgewählte Objekt
     *
     * @param name Name und Land des Objekts
     * @param info Größeninformation
     * @param ausstattungen Ausstattungsinformation
     * @param belegt Buchungen im angegebenen Zeitraum
     */
    public void ObjektinfoSetzen(String name, String info, String ausstattungen,
            String belegt)
    {
        namensZeile.setText(name);
        infozeile.setText(info);
        ausstattungsZeile.setText(ausstattungen);
        belegtZeile.setText(belegt);
    }
}
