package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    private JPanel adressanzeige, beabeitung, neuanlegen, suchen;

    private JComboBox personenMenue1, personenMenue2, personenMenue3,
            personenMenue4, nummernMenue, mailMenue, nummernArten, art3;

    private JLabel status;

    private JLabel name1, vorname1, strasse1, ort1, name5, adresse5;

    private JList telefonliste, emailliste, telefonliste5, emailliste5;

    private JTextField name2, vorname2, strasse2, hausnummer2, plz2, ort2,
            nummer, notiz1, email, notiz2;

    private JTextField name3, vorname3, strasse3, hausnummer3, plz3, ort3,
            nummer3, notiz3, email3, notiz4;

    private JTextField vorname4, strasse4, ort4, nummer4, email4;

    private KONTROLLEURINTERFACE kontrolleur;

    /**
     * Baut die Fensterstruktur auf.
     *
     * @param k der zugeordnete Kontrolleur.
     */
    OBERFLAECHE(KONTROLLEURINTERFACE k)
    {
        String[] arten = { "Festnetz", "Mobilfunk", "VoIP", "Fax", "Sonstige" };
        JPanel content;
        JPanel panel, panel2, panel3;
        JButton button;
        JLabel l;
        kontrolleur = k;
        fenster = new JFrame("Adressverwaltung");
        content = (JPanel) fenster.getContentPane();
        content.setLayout(new BorderLayout());
        auswahl = new JTabbedPane();
        content.add(auswahl, BorderLayout.CENTER);
        adressanzeige = new JPanel();
        auswahl.addTab("Adressen anzeigen", adressanzeige);
        adressanzeige.setLayout(new BorderLayout());
        personenMenue1 = new JComboBox();
        adressanzeige.add(personenMenue1, BorderLayout.NORTH);
        personenMenue1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EintragAuswaehlen(personenMenue1.getSelectedItem());
            }
        });
        panel2 = new JPanel();
        adressanzeige.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(4, 1));
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Name"));
        name1 = new JLabel();
        panel.add(name1);
        vorname1 = new JLabel();
        panel.add(vorname1);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Adresse"));
        panel.setMinimumSize(new Dimension(100, 20));
        strasse1 = new JLabel();
        strasse1.setMinimumSize(new Dimension(100, 20));
        panel.add(strasse1);
        ort1 = new JLabel();
        panel.add(ort1);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Telefonnummern"));
        telefonliste = new JList();
        panel.add(new JScrollPane(telefonliste), BorderLayout.CENTER);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "E-Mail-Adressen"));
        emailliste = new JList();
        panel.add(new JScrollPane(emailliste), BorderLayout.CENTER);
        beabeitung = new JPanel();
        auswahl.addTab("Daten bearbeiten", beabeitung);
        beabeitung.setLayout(new BorderLayout());
        personenMenue2 = new JComboBox();
        beabeitung.add(personenMenue2, BorderLayout.NORTH);
        personenMenue2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EintragAuswaehlenBearbeiten(
                        personenMenue2.getSelectedItem());
            }
        });
        panel2 = new JPanel();
        beabeitung.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(4, 1));
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Name"));
        l = new JLabel("Name ");
        panel.add(l);
        name2 = new JTextField();
        name2.setPreferredSize(new Dimension(100, 20));
        panel.add(name2);
        l = new JLabel("Vorname ");
        panel.add(l);
        vorname2 = new JTextField();
        vorname2.setPreferredSize(new Dimension(100, 20));
        panel.add(vorname2);
        button = new JButton("\u00C4ndern");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.PersonendatenAendern(name2.getText(),
                        vorname2.getText());
            }
        });
        panel.add(button);
        button = new JButton("L\u00F6schen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.PersonLoeschen();
            }
        });
        panel.add(button);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Adresse"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Stra\u00DFe ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        strasse2 = new JTextField();
        strasse2.setPreferredSize(new Dimension(300, 20));
        panel3.add(strasse2);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Hausnummer ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        hausnummer2 = new JTextField();
        hausnummer2.setPreferredSize(new Dimension(300, 20));
        panel3.add(hausnummer2);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Postleitzahl ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        plz2 = new JTextField();
        plz2.setPreferredSize(new Dimension(300, 20));
        panel3.add(plz2);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Ort ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        ort2 = new JTextField();
        ort2.setPreferredSize(new Dimension(100, 20));
        panel3.add(ort2);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(panel3);
        button = new JButton("Neu");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.AdressdatenAnlegen(strasse2.getText(),
                        hausnummer2.getText(), plz2.getText(), ort2.getText());
            }
        });
        panel3.add(button);
        button = new JButton("\u00C4ndern");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.AdressdatenAendern(strasse2.getText(),
                        hausnummer2.getText(), plz2.getText(), ort2.getText());
            }
        });
        panel3.add(button);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        personenMenue3 = new JComboBox();
        panel3.add(personenMenue3);
        button = new JButton("\u00DCbernehmen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.AdressdatenUebernehmen(
                        personenMenue3.getSelectedItem());
            }
        });
        panel3.add(button);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Telefonnummern"));
        nummernMenue = new JComboBox();
        panel.add(nummernMenue, BorderLayout.NORTH);
        nummernMenue.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (nummernMenue.getSelectedIndex() >= 0)
                {
                    kontrolleur.TelefonnummerAuswaehlen(
                            nummernMenue.getSelectedItem());
                }
            }
        });
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3, BorderLayout.CENTER);
        l = new JLabel("Nummer ");
        panel3.add(l);
        nummer = new JTextField();
        nummer.setPreferredSize(new Dimension(150, 20));
        panel3.add(nummer);
        l = new JLabel(" Notiz ");
        panel3.add(l);
        notiz1 = new JTextField();
        notiz1.setPreferredSize(new Dimension(200, 20));
        panel3.add(notiz1);
        nummernArten = new JComboBox(arten);
        panel3.add(nummernArten);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3, BorderLayout.SOUTH);
        button = new JButton("Neu");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.TelefonAnlegen(nummer.getText(),
                        (String) nummernArten.getSelectedItem(),
                        notiz1.getText());
            }
        });
        panel3.add(button);
        button = new JButton("\u00C4ndern");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.TelefonAendern(nummernMenue.getSelectedItem(),
                        nummer.getText(),
                        (String) nummernArten.getSelectedItem(),
                        notiz1.getText());
            }
        });
        panel3.add(button);
        button = new JButton("L\u00F6schen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.TelefonLoeschen(nummernMenue.getSelectedItem());
            }
        });
        panel3.add(button);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new BorderLayout());
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "EMailadressen"));
        mailMenue = new JComboBox();
        panel.add(mailMenue, BorderLayout.NORTH);
        mailMenue.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EmailAuswaehlen(mailMenue.getSelectedItem());
            }
        });
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3, BorderLayout.CENTER);
        l = new JLabel("EMail ");
        panel3.add(l);
        email = new JTextField();
        email.setPreferredSize(new Dimension(350, 20));
        panel3.add(email);
        l = new JLabel(" Notiz ");
        panel3.add(l);
        notiz2 = new JTextField();
        notiz2.setPreferredSize(new Dimension(200, 20));
        panel3.add(notiz2);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3, BorderLayout.SOUTH);
        button = new JButton("Neu");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EmailAnlegen(email.getText(), notiz2.getText());
            }
        });
        panel3.add(button);
        button = new JButton("\u00C4ndern");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EmailAendern(mailMenue.getSelectedItem(),
                        email.getText(), notiz2.getText());
            }
        });
        panel3.add(button);
        button = new JButton("L\u00F6schen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EmailLoeschen(mailMenue.getSelectedItem());
            }
        });
        panel3.add(button);
        neuanlegen = new JPanel();
        auswahl.addTab("Person neu anlegen", neuanlegen);
        neuanlegen.setLayout(new BorderLayout());
        panel2 = new JPanel();
        neuanlegen.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(4, 1));
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(2, 1));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Name"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Name ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        name3 = new JTextField();
        name3.setPreferredSize(new Dimension(300, 20));
        panel3.add(name3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Vorname ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        vorname3 = new JTextField();
        vorname3.setPreferredSize(new Dimension(300, 20));
        panel3.add(vorname3);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(2, 2));
        panel.setBorder(
                new TitledBorder(LineBorder.createGrayLineBorder(), "Adresse"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Stra\u00DFe ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        strasse3 = new JTextField();
        strasse3.setPreferredSize(new Dimension(300, 20));
        panel3.add(strasse3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Hausnummer ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        hausnummer3 = new JTextField();
        hausnummer3.setPreferredSize(new Dimension(300, 20));
        panel3.add(hausnummer3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Postleitzahl ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        plz3 = new JTextField();
        plz3.setPreferredSize(new Dimension(300, 20));
        panel3.add(plz3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Ort ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        ort3 = new JTextField();
        ort3.setPreferredSize(new Dimension(300, 20));
        panel3.add(ort3);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(2, 1));
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Telefonnummer"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Nummer ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        nummer3 = new JTextField();
        nummer3.setPreferredSize(new Dimension(300, 20));
        panel3.add(nummer3);
        art3 = new JComboBox(arten);
        panel3.add(art3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Notiz ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        notiz3 = new JTextField();
        notiz3.setPreferredSize(new Dimension(300, 20));
        panel3.add(notiz3);
        panel = new JPanel();
        panel2.add(panel);
        panel.setLayout(new GridLayout(2, 1));
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Emailadresse"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Adresse ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        email3 = new JTextField();
        email3.setPreferredSize(new Dimension(300, 20));
        panel3.add(email3);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Notiz ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        notiz4 = new JTextField();
        notiz4.setPreferredSize(new Dimension(300, 20));
        panel3.add(notiz4);
        panel = new JPanel();
        neuanlegen.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        button = new JButton("Anlegen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.PersonAnlegen(name3.getText(), vorname3.getText(),
                        strasse3.getText(), hausnummer3.getText(),
                        plz3.getText(), ort3.getText(), nummer3.getText(),
                        (String) art3.getSelectedItem(), notiz3.getText(),
                        email3.getText(), notiz4.getText());
            }
        });
        panel.add(button);
        suchen = new JPanel();
        auswahl.addTab("Personen suchen", suchen);
        suchen.setLayout(new GridLayout(2, 1));
        panel = new JPanel();
        suchen.add(panel);
        panel.setLayout(new GridLayout(4, 1));
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Suchkriterien"));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Vorname ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        vorname4 = new JTextField();
        vorname4.setPreferredSize(new Dimension(300, 20));
        panel3.add(vorname4);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(300, 20));
        panel3.add(l);
        button = new JButton("Suchen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.VornamenSuchen(vorname4.getText());
            }
        });
        panel3.add(button);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Ort ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        ort4 = new JTextField();
        ort4.setPreferredSize(new Dimension(300, 20));
        panel3.add(ort4);
        l = new JLabel("Stra\u00DFe ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        strasse4 = new JTextField();
        strasse4.setPreferredSize(new Dimension(300, 20));
        panel3.add(strasse4);
        button = new JButton("Suchen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.AdresseSuchen(strasse4.getText(), ort4.getText());
            }
        });
        panel3.add(button);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Telefon ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        nummer4 = new JTextField();
        nummer4.setPreferredSize(new Dimension(300, 20));
        panel3.add(nummer4);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(300, 20));
        panel3.add(l);
        button = new JButton("Suchen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.NummerSuchen(nummer4.getText());
            }
        });
        panel3.add(button);
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(panel3);
        l = new JLabel("Email ");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        email4 = new JTextField();
        email4.setPreferredSize(new Dimension(300, 20));
        panel3.add(email4);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(100, 20));
        panel3.add(l);
        l = new JLabel("");
        l.setPreferredSize(new Dimension(300, 20));
        panel3.add(l);
        button = new JButton("Suchen");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EmailSuchen(email4.getText());
            }
        });
        panel3.add(button);
        panel2 = new JPanel();
        suchen.add(panel2);
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),
                "Ergebnisse"));
        personenMenue4 = new JComboBox();
        panel2.add(personenMenue4, BorderLayout.NORTH);
        personenMenue4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.EintragAuswaehlenSuche(
                        personenMenue4.getSelectedItem());
            }
        });
        panel = new JPanel();
        panel2.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1));
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel.add(panel3);
        name5 = new JLabel("");
        panel3.add(name5, BorderLayout.NORTH);
        adresse5 = new JLabel("");
        panel3.add(adresse5, BorderLayout.SOUTH);
        telefonliste5 = new JList();
        panel.add(new JScrollPane(telefonliste5));
        emailliste5 = new JList();
        panel.add(new JScrollPane(emailliste5));
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
        fenster.setSize(1000, 700);
        fenster.setVisible(true);
    }

    /**
     * Besetzt das Auswahlmenü mit Personendaten
     *
     * @param daten Feld mit den Personeninformationen
     */
    public void PersonenSetzen(Object[] daten)
    {
        personenMenue1.removeAllItems();
        personenMenue2.removeAllItems();
        personenMenue3.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            personenMenue1.addItem(daten[i]);
            personenMenue2.addItem(daten[i]);
            personenMenue3.addItem(daten[i]);
        }
    }

    /**
     * Setzt die Auswahl im Personenmenue 1
     */
    public void PersonenAuswahlSetzen1(Object auswahl)
    {
        personenMenue1.setSelectedItem(auswahl);
    }

    /**
     * Setzt die Auswahl im Personenmenue 2 und 3
     */
    public void PersonenAuswahlSetzen2(Object auswahl)
    {
        personenMenue2.setSelectedItem(auswahl);
        personenMenue3.setSelectedItem(auswahl);
    }

    /**
     * Besetzt das Auswahlmenü der Suche mit Personendaten
     *
     * @param daten Feld mit den Personeninformationen
     */
    public void PersonenSetzenSuche(Object[] daten)
    {
        personenMenue4.removeAllItems();
        for (int i = 0; i < daten.length; i++)
        {
            personenMenue4.addItem(daten[i]);
        }
    }

    /**
     * Besetzt die Anzeigeelemente für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    public void PersonenInfoSetzen(String name, String vorname, String strasse,
            String hausnummer, String plz, String ort, Object[] nummern,
            Object[] emails)
    {
        name1.setText(name);
        vorname1.setText(vorname);
        strasse1.setText(strasse + " " + hausnummer);
        ort1.setText(plz + " " + ort);
        telefonliste.setListData(nummern);
        emailliste.setListData(emails);
    }

    /**
     * Besetzt die Anzeigeelemente für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    public void PersonenInfoSetzenBearbeiten(String name, String vorname,
            String strasse, String hausnummer, String plz, String ort,
            Object[] nummern, Object[] emails)
    {
        name2.setText(name);
        vorname2.setText(vorname);
        strasse2.setText(strasse);
        hausnummer2.setText(hausnummer);
        ort2.setText(ort);
        plz2.setText(plz);
        nummernMenue.removeAllItems();
        for (int i = 0; i < nummern.length; i++)
        {
            nummernMenue.addItem(nummern[i]);
        }
        mailMenue.removeAllItems();
        for (int i = 0; i < emails.length; i++)
        {
            mailMenue.addItem(emails[i]);
        }
    }

    /**
     * Besetzt die Anzeigeelemente der Suche für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    public void PersonenInfoSetzenSuche(String name, String vorname,
            String strasse, String hausnummer, String plz, String ort,
            Object[] nummern, Object[] emails)
    {
        name5.setText(vorname + " " + name);
        adresse5.setText(strasse + " " + hausnummer + ", " + plz + " " + ort);
        telefonliste5.setListData(nummern);
        emailliste5.setListData(emails);
    }

    /**
     * Besetzt die Anzeigeelemente für eine Telefonnummer.
     *
     * @param nummer die Telefonnummer
     * @param notiz Notiz zur Nummer
     * @param art Art der Nummer
     */
    public void NummernInfoSetzenBearbeiten(String nummer, String notiz,
            String art)
    {
        this.nummer.setText(nummer);
        notiz1.setText(notiz);
        nummernArten.setSelectedItem(art);
    }

    /**
     * Besetzt die Anzeigeelemente für eine EMailadresse.
     *
     * @param adresse die Emailadresse
     * @param notiz Notiz zur Adresse
     */
    public void EmailInfoSetzenBearbeiten(String adresse, String notiz)
    {
        email.setText(adresse);
        notiz2.setText(notiz);
    }

    /**
     * Meldungen des Kontrolleurs eintragen.
     *
     * @param text Meldungstext.
     */
    public void StatusSetzen(String text)
    {
        status.setText(text);
    }

    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     *
     * @param text Meldungstext.
     */
    public void FehlermeldungEmpfangen(String text)
    {
        JOptionPane.showMessageDialog(null, text, "Fehlermeldung",
                JOptionPane.ERROR_MESSAGE);
    }
}
