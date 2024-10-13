package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Realisiert die Bedienoberfl&auml;che. In dieser Version wird erst nach der Anmeldung zwischen
 * Kunden und Angestellten unterschieden.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;

class OBERFLAECHE implements OBERFLAECHENINTERFACE, MELDUNGSBEOBACHTER
{
    private static final int breite = 700;

    private static final int hoehe = 400;

    private Frame fenster;

    private Panel anmeldePanel;

    private Panel kundeAuswahlPanel;

    private Panel kundeArbeitPanel;

    private Panel angestellterAuswahlPanel;

    private Label l;

    private Button b;

    private Button abmelden, beenden;

    private Button kontoWaehlen, kontoAnlegen, kontoLoeschen, kontoAuszuege;

    private Button angestelltenLoeschen, kundeLoeschen;

    private Choice kontenwahl;

    private Choice kundenwahl;

    private Choice kontenwahl2;

    private Choice angestelltenwahl;

    private TextField anmeldePanel_name, anmeldePanel_pin;

    private TextField angestelltenPanel_name, angestelltenPanel_pin;

    private TextField angestelltenPanel_wert;

    private TextField angestelltenPanel_name2, angestelltenPanel_pin2;

    private TextField pin_neu_1, pin_neu_2;

    private Label aktKontoFuerKunde, kontostandFuerKunde;

    private Label verwendungFuerWert;

    private TextField kundeArbeitPanel_betrag;

    private Label status;

    private Label fehler;

    private Label frage;

    private Label angestellter_kunde;

    private Dialog fehlermeldung;

    private Dialog textanzeige;

    private Dialog nachfrage;

    private Dialog loganzeige;

    private TextArea anzeigetext;

    private TextArea logtext;

    private CheckboxGroup kontoart;

    private Checkbox sparkonto, girokonto;

    private KONTROLLEURINTERFACE kontroller;

    // Antwort auf den Fragendialog
    private boolean antwort;

    /**
     * Ezeugt alle Bedienelemente
     */
    OBERFLAECHE(KONTROLLEURINTERFACE k)
    {
        kontroller = k;
        kontroller.OberflaecheSetzen(this);
        // Fenster
        fenster = new Frame("Banksimulation");
        fenster.setSize(breite + 20, hoehe);
        fenster.setLocation(50, 50);
        fenster.setResizable(false);
        fenster.setLayout(null);
        fenster.setVisible(true);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                // Nothalt
                kontroller.BeendenAusfuehren();
            }
        });
        status = new Label();
        status.setSize(breite, 20);
        status.setLocation(10, hoehe - 20);
        status.setText("Status: keine Meldung");
        status.setVisible(true);
        fenster.add(status);
        abmelden = new Button();
        abmelden.setSize(80, 30);
        abmelden.setLocation(breite - 90, hoehe - 50);
        abmelden.setLabel("Abmelden");
        abmelden.setVisible(true);
        abmelden.setEnabled(false);
        fenster.add(abmelden);
        abmelden.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontroller.AbmeldenAusfuehren();
            }
        });
        beenden = new Button();
        beenden.setSize(80, 30);
        beenden.setLocation(breite - 180, hoehe - 50);
        beenden.setLabel("Beenden");
        beenden.setVisible(false);
        fenster.add(beenden);
        beenden.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontroller.BeendenAusfuehren();
            }
        });
        AnmeldepanelAufbauen();
        KundenauswahlpanelAufbauen();
        KundenarbeitspanelAufbauen();
        AngestelltenauswahlpanelAufbauen();
        // Fehlerdialog
        fehlermeldung = new Dialog(fenster, "Fehlermeldungen", true);
        fehlermeldung.setSize(400, 150);
        fehlermeldung.setLocation(100, 80);
        fehlermeldung.setResizable(false);
        fehlermeldung.setLayout(null);
        fehlermeldung.setVisible(false);
        fehler = new Label();
        fehler.setSize(400, 20);
        fehler.setLocation(0, 40);
        fehler.setText("");
        fehler.setAlignment(Label.CENTER);
        fehler.setVisible(true);
        fehlermeldung.add(fehler);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(150, 80);
        b.setLabel("Schliessen");
        b.setVisible(true);
        fehlermeldung.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                fehlermeldung.setVisible(false);
            }
        });
        // Nachfrage
        nachfrage = new Dialog(fenster, "", true);
        nachfrage.setSize(400, 150);
        nachfrage.setLocation(100, 80);
        nachfrage.setResizable(false);
        nachfrage.setLayout(null);
        nachfrage.setVisible(false);
        frage = new Label();
        frage.setSize(400, 20);
        frage.setLocation(0, 40);
        frage.setText("");
        frage.setAlignment(Label.CENTER);
        frage.setVisible(true);
        nachfrage.add(frage);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(50, 80);
        b.setLabel("Nein");
        b.setVisible(true);
        nachfrage.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                antwort = false;
                nachfrage.setVisible(false);
            }
        });
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(250, 80);
        b.setLabel("Ja");
        b.setVisible(true);
        nachfrage.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                antwort = true;
                nachfrage.setVisible(false);
            }
        });
        antwort = false;
        // Textfenster
        textanzeige = new Dialog(fenster, "Anzeige", true);
        textanzeige.setSize(600, 400);
        textanzeige.setLocation(100, 80);
        textanzeige.setResizable(false);
        textanzeige.setLayout(null);
        textanzeige.setVisible(false);
        anzeigetext = new TextArea();
        anzeigetext.setLocation(0, 20);
        anzeigetext.setSize(600, 330);
        anzeigetext.setVisible(true);
        anzeigetext.setEditable(false);
        textanzeige.add(anzeigetext);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(250, 360);
        b.setLabel("Schliessen");
        b.setVisible(true);
        textanzeige.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textanzeige.setVisible(false);
            }
        });
        // Logfenster
        loganzeige = new Dialog(fenster, "Log", true);
        loganzeige.setSize(600, 400);
        loganzeige.setLocation(100, 80);
        loganzeige.setResizable(false);
        loganzeige.setLayout(null);
        loganzeige.setVisible(false);
        logtext = new TextArea();
        logtext.setLocation(0, 20);
        logtext.setSize(600, 330);
        logtext.setVisible(true);
        logtext.setEditable(false);
        loganzeige.add(logtext);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(250, 360);
        b.setLabel("Schliessen");
        b.setVisible(true);
        loganzeige.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loganzeige.setVisible(false);
            }
        });
    }

    /**
     * Setzt die Oberfl&auml;che auf den angegebenen Status.
     *
     * @param status der neue Status der Oberfl&auml;che
     */
    public void StatusSetzen(Status status)
    {
        int[] nummern;
        switch (status)
        {
        case anmelden:
            abmelden.setEnabled(false);
            beenden.setVisible(false);
            anmeldePanel_name.setText("");
            anmeldePanel_pin.setText("");
            anmeldePanel.setVisible(true);
            kundeArbeitPanel.setVisible(false);
            kundeAuswahlPanel.setVisible(false);
            angestellterAuswahlPanel.setVisible(false);
            anmeldePanel_name.requestFocus();
            break;

        case kundenkontowahl:
            abmelden.setEnabled(true);
            beenden.setVisible(false);
            anmeldePanel.setVisible(false);
            kundeArbeitPanel.setVisible(false);
            angestellterAuswahlPanel.setVisible(false);
            kontenwahl.removeAll();
            nummern = kontroller.NummerFuerKundenGeben();
            if (nummern != null)
            {
                for (int nummer : nummern)
                {
                    kontenwahl.add("" + nummer);
                }
                kontenwahl.setEnabled(true);
            }
            else
            {
                kontenwahl.add("----");
                kontenwahl.setEnabled(false);
            }
            kundeAuswahlPanel.setVisible(true);
            break;

        case kundenkontoarbeit:
            abmelden.setEnabled(true);
            beenden.setVisible(false);
            anmeldePanel.setVisible(false);
            kundeAuswahlPanel.setVisible(false);
            angestellterAuswahlPanel.setVisible(false);
            kundeArbeitPanel.setVisible(true);
            kundeArbeitPanel_betrag.setText("");
            kontostandFuerKunde
                    .setText("" + kontroller.BetragFuerKundenKontoGeben());
            aktKontoFuerKunde.setText("Das aktuelle Konto hat die Nummer "
                    + kontroller.NummerFuerKundenKontoGeben());
            break;

        case angestelltensicht:
        case angestelltensicht_kunde:
        case angestelltensicht_kundeundkonto:
            abmelden.setEnabled(true);
            beenden.setVisible(true);
            anmeldePanel.setVisible(false);
            kundeAuswahlPanel.setVisible(false);
            kundeArbeitPanel.setVisible(false);
            angestellterAuswahlPanel.setVisible(true);
            angestelltenwahl.removeAll();
            String[] namen = kontroller.AngestelltenNamenGeben();
            if (namen != null)
            {
                for (String name : namen)
                {
                    angestelltenwahl.add(name);
                }
                angestelltenwahl.setEnabled(true);
                angestelltenLoeschen.setEnabled(true);
            }
            else
            {
                angestelltenwahl.add("----");
                angestelltenwahl.setEnabled(false);
                angestelltenLoeschen.setEnabled(false);
            }
            kundenwahl.removeAll();
            namen = kontroller.KundenNamenGeben();
            if (namen != null)
            {
                for (String name : namen)
                {
                    kundenwahl.add(name);
                }
                kundenwahl.setEnabled(true);
            }
            else
            {
                kundenwahl.add("----");
                kundenwahl.setEnabled(false);
            }
            kontenwahl2.removeAll();
            if (status == Status.angestelltensicht)
            {
                angestellter_kunde.setText("Es ist kein Kunde ausgew\u00E4hlt");
                kontoWaehlen.setEnabled(false);
                kontoAnlegen.setEnabled(false);
                kontoAuszuege.setEnabled(false);
                kontoLoeschen.setEnabled(false);
                kundeLoeschen.setEnabled(false);
            }
            else
            {
                angestellter_kunde.setText("Sie arbeiten mit Kunde "
                        + kontroller.NameVonAktkundeGeben() + ".");
                nummern = kontroller.NummerFuerAktKundenGeben();
                kundeLoeschen.setEnabled(true);
                if (nummern != null)
                {
                    for (int nummer : nummern)
                    {
                        kontenwahl2.add("" + nummer);
                    }
                    kontenwahl2.setEnabled(true);
                    kontoWaehlen.setEnabled(true);
                }
                else
                {
                    kontenwahl2.add("----");
                    kontenwahl2.setEnabled(false);
                    kontoWaehlen.setEnabled(false);
                }
                kontoAnlegen.setEnabled(true);
                if (status == Status.angestelltensicht_kundeundkonto)
                {
                    kontoAuszuege.setEnabled(true);
                    kontoLoeschen.setEnabled(true);
                }
                else
                {
                    kontoAuszuege.setEnabled(false);
                    kontoLoeschen.setEnabled(false);
                }
            }
            break;

        default:
            FehlertextZeigen("Unbekannter Status: '" + status + "'.");
            break;
        }
    }

    /**
     * Zeigt einen Fehlertext an. Blockiert, bis das Fenster wieder unsichtbar
     * wird.
     *
     * @param text der anzuzeigende Fehlertext
     */
    private void FehlertextZeigen(String text)
    {
        (Toolkit.getDefaultToolkit()).beep();
        fehler.setText(text);
        fehlermeldung.setVisible(true);
    }

    /**
     * Stellt eine mit Ja oder Nein zu beantwortende Frage. Die Antwort wird im
     * Attribut anwort abgelegt. Blockiert, bis das Fenster wieder unsichtbar
     * wird.
     *
     * @param text die anzuzeigende Frage
     */
    private void FrageStellen(String text)
    {
        frage.setText(text);
        nachfrage.setVisible(true);
    }

    /**
     * Zeigt einen großen Text (logs, Ausz&uuml;ge) an. Blockiert, bis das
     * Fenster wieder unsichtbar wird.
     *
     * @param text der anzuzeigende Fehlertext
     */
    private void AnzeigetextZeigen(String[] text)
    {
        anzeigetext.setText(text[0]);
        for (int i = 1; i < text.length; i++)
        {
            anzeigetext.append("\n" + text[i]);
        }
        anzeigetext.setColumns(160);
        anzeigetext.setRows(text.length);
        textanzeige.setVisible(true);
    }

    /**
     * Erzeugt das Anmeldepanel
     */
    private void AnmeldepanelAufbauen()
    {
        anmeldePanel = new Panel();
        anmeldePanel.setSize(breite, hoehe - 60);
        anmeldePanel.setLocation(10, 0);
        anmeldePanel.setLayout(null);
        anmeldePanel.setVisible(true);
        fenster.add(anmeldePanel);
        l = new Label();
        l.setSize(breite, 20);
        l.setLocation(0, 30);
        l.setAlignment(Label.CENTER);
        l.setText("Bitte anmelden");
        l.setVisible(true);
        anmeldePanel.add(l);
        l = new Label();
        l.setSize(130, 20);
        l.setLocation(breite / 2 - 140, 50);
        l.setAlignment(Label.CENTER);
        l.setText("Name");
        l.setVisible(true);
        anmeldePanel.add(l);
        anmeldePanel_name = new TextField();
        anmeldePanel_name.setSize(130, 20);
        anmeldePanel_name.setLocation(breite / 2 + 10, 50);
        anmeldePanel_name.setVisible(true);
        anmeldePanel.add(anmeldePanel_name);
        l = new Label();
        l.setSize(130, 20);
        l.setLocation(breite / 2 - 140, 80);
        l.setAlignment(Label.CENTER);
        l.setText("PIN");
        l.setVisible(true);
        anmeldePanel.add(l);
        anmeldePanel_pin = new TextField();
        anmeldePanel_pin.setSize(130, 20);
        anmeldePanel_pin.setLocation(breite / 2 + 10, 80);
        anmeldePanel_pin.setVisible(true);
        anmeldePanel.add(anmeldePanel_pin);
        b = new Button();
        b.setSize(130, 30);
        b.setLocation(breite / 2 - 140, 110);
        b.setLabel("als Kunde");
        b.setVisible(true);
        anmeldePanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KundeAnmelden(anmeldePanel_name.getText(),
                            Integer.parseInt(anmeldePanel_pin.getText()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("PIN muss eine ganze Zahl sein.");
                }
            }
        });
        b = new Button();
        b.setSize(130, 30);
        b.setLocation(breite / 2 + 10, 110);
        b.setLabel("als Angestellter");
        b.setVisible(true);
        anmeldePanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.AngestellterAnmelden(anmeldePanel_name.getText(),
                            Integer.parseInt(anmeldePanel_pin.getText()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("PIN muss eine ganze Zahl sein.");
                }
            }
        });
    }

    /**
     * Erzeugt das Auswahlpanel f&uuml;r die Kontenwahl des Kunden
     */
    private void KundenauswahlpanelAufbauen()
    {
        kundeAuswahlPanel = new Panel();
        kundeAuswahlPanel.setSize(breite, hoehe - 60);
        kundeAuswahlPanel.setLocation(10, 0);
        kundeAuswahlPanel.setLayout(null);
        kundeAuswahlPanel.setVisible(false);
        fenster.add(kundeAuswahlPanel);
        l = new Label();
        l.setSize(breite, 20);
        l.setLocation(0, 30);
        l.setAlignment(Label.CENTER);
        l.setText("Bitte Konto ausw\u00E4hlen");
        l.setVisible(true);
        kundeAuswahlPanel.add(l);
        l = new Label();
        l.setSize(100, 20);
        l.setLocation(breite / 2 - 100, 50);
        l.setText("Ihre Konten:");
        l.setVisible(true);
        kundeAuswahlPanel.add(l);
        kontenwahl = new Choice();
        kontenwahl.setSize(100, 30);
        kontenwahl.setLocation(breite / 2, 50);
        kontenwahl.setVisible(true);
        kundeAuswahlPanel.add(kontenwahl);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(breite / 2 - 50, 110);
        b.setLabel("Ok");
        b.setVisible(true);
        kundeAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KundeKontoWaehlen(
                            Integer.parseInt(kontenwahl.getSelectedItem()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("Interner Fehler bei der Kontenwahl.");
                }
            }
        });
        l = new Label();
        l.setSize(100, 20);
        l.setLocation(breite / 2 - 100, 150);
        l.setText("Neue PIN");
        l.setVisible(true);
        kundeAuswahlPanel.add(l);
        pin_neu_1 = new TextField();
        pin_neu_1.setSize(100, 20);
        pin_neu_1.setLocation(breite / 2, 150);
        pin_neu_1.setVisible(true);
        pin_neu_1.setEchoChar('\u2022');
        kundeAuswahlPanel.add(pin_neu_1);
        l = new Label();
        l.setSize(100, 20);
        l.setLocation(breite / 2 - 100, 180);
        l.setText("Bes\u00E4tigung");
        l.setVisible(true);
        kundeAuswahlPanel.add(l);
        pin_neu_2 = new TextField();
        pin_neu_2.setSize(100, 20);
        pin_neu_2.setLocation(breite / 2, 180);
        pin_neu_2.setVisible(true);
        pin_neu_2.setEchoChar('\u2022');
        kundeAuswahlPanel.add(pin_neu_2);
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(breite / 2 - 100, 210);
        b.setLabel("PIN \u00E4ndern");
        b.setVisible(true);
        kundeAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (pin_neu_1.getText().equals(pin_neu_2.getText()))
                {
                    try
                    {
                        kontroller.KundePinAendern(
                                Integer.parseInt(pin_neu_1.getText()));
                        StatusmeldungSetzen("Pin ge\u00E4ndert.");
                    }
                    catch (Exception ex)
                    {
                        FehlertextZeigen("Die PIN muss eine ganze Zahl sein.");
                    }
                }
                else
                {
                    FehlertextZeigen(
                            "Die beiden Angaben f\u00FCr die PIN m\u00FCssen \u00FCbereinstimmen.");
                }
            }
        });
    }

    /**
     * Erzeugt das Arbeitspanel f&uuml;r die Kontenbearbeitung des Kunden
     */
    private void KundenarbeitspanelAufbauen()
    {
        kundeArbeitPanel = new Panel();
        kundeArbeitPanel.setSize(breite, hoehe - 60);
        kundeArbeitPanel.setLocation(10, 0);
        kundeArbeitPanel.setLayout(null);
        kundeArbeitPanel.setVisible(false);
        fenster.add(kundeArbeitPanel);
        aktKontoFuerKunde = new Label();
        aktKontoFuerKunde.setSize(breite, 20);
        aktKontoFuerKunde.setLocation(0, 30);
        aktKontoFuerKunde.setAlignment(Label.CENTER);
        aktKontoFuerKunde.setText("Das aktuelle Konto kat die Nummer ------");
        aktKontoFuerKunde.setVisible(true);
        kundeArbeitPanel.add(aktKontoFuerKunde);
        l = new Label();
        l.setSize(100, 20);
        l.setLocation(0, 50);
        l.setText("Kontostand:");
        l.setVisible(true);
        kundeArbeitPanel.add(l);
        l = new Label();
        l.setSize(100, 20);
        l.setLocation(0, 80);
        l.setText("Betrag:");
        l.setVisible(true);
        kundeArbeitPanel.add(l);
        kontostandFuerKunde = new Label();
        kontostandFuerKunde.setSize(100, 20);
        kontostandFuerKunde.setLocation(110, 50);
        kontostandFuerKunde.setText("");
        kontostandFuerKunde.setVisible(true);
        kundeArbeitPanel.add(kontostandFuerKunde);
        kundeArbeitPanel_betrag = new TextField();
        kundeArbeitPanel_betrag.setSize(100, 20);
        kundeArbeitPanel_betrag.setLocation(110, 80);
        kundeArbeitPanel_betrag.setText("0");
        kundeArbeitPanel_betrag.setVisible(true);
        kundeArbeitPanel.add(kundeArbeitPanel_betrag);
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(110, 110);
        b.setLabel("Abheben");
        b.setVisible(true);
        kundeArbeitPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KundeKontoAbheben(Double
                            .parseDouble(kundeArbeitPanel_betrag.getText()));
                    kontostandFuerKunde.setText(
                            "" + kontroller.BetragFuerKundenKontoGeben());
                }
                catch (Exception ex)
                {
                    StatusmeldungSetzen(
                            "Bitte einen korrekten Betrag eingeben");
                    (Toolkit.getDefaultToolkit()).beep();
                    kundeArbeitPanel_betrag.requestFocus();
                    kundeArbeitPanel_betrag.selectAll();
                }
            }
        });
        b = new Button();
        b.setSize(100, 30);
        b.setLocation(110, 140);
        b.setLabel("Einzahlen");
        b.setVisible(true);
        kundeArbeitPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KundeKontoEinzahlen(Double
                            .parseDouble(kundeArbeitPanel_betrag.getText()));
                    kontostandFuerKunde.setText(
                            "" + kontroller.BetragFuerKundenKontoGeben());
                }
                catch (Exception ex)
                {
                    StatusmeldungSetzen(
                            "Bitte einen korrekten Betrag eingeben");
                    (Toolkit.getDefaultToolkit()).beep();
                    kundeArbeitPanel_betrag.requestFocus();
                    kundeArbeitPanel_betrag.selectAll();
                }
            }
        });
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(110, 200);
        b.setLabel("Kontoausz\u00FCge anzeigen");
        b.setVisible(true);
        kundeArbeitPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AnzeigetextZeigen(kontroller.KundeKontoauszuegeGeben());
            }
        });
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(breite - 220, 200);
        b.setLabel("Neues Konto w\u00E4hlen");
        b.setVisible(true);
        kundeArbeitPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontroller.KundeKontoNeuWaehlen();
            }
        });
    }

    /**
     * Erzeugt das Auswahlpanel f&uuml;r die Arbeitsabl&auml;ufe des
     * Angestellten
     */
    private void AngestelltenauswahlpanelAufbauen()
    {
        angestellterAuswahlPanel = new Panel();
        angestellterAuswahlPanel.setSize(breite, hoehe - 60);
        angestellterAuswahlPanel.setLocation(10, 0);
        angestellterAuswahlPanel.setLayout(null);
        angestellterAuswahlPanel.setVisible(false);
        fenster.add(angestellterAuswahlPanel);
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(0, 30);
        l.setText("Kunden");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        kundenwahl = new Choice();
        kundenwahl.setSize(120, 30);
        kundenwahl.setLocation(80, 30);
        kundenwahl.setVisible(true);
        angestellterAuswahlPanel.add(kundenwahl);
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(0, 60);
        b.setLabel("Kunde w\u00E4hlen");
        b.setVisible(true);
        angestellterAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.AngestellterKundeWaehlen(
                            kundenwahl.getSelectedItem());
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("Interner Fehler bei der Kundenwahl.");
                }
            }
        });
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(0, 150);
        l.setText("Name");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        angestelltenPanel_name = new TextField();
        angestelltenPanel_name.setSize(120, 20);
        angestelltenPanel_name.setLocation(80, 150);
        angestelltenPanel_name.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenPanel_name);
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(0, 180);
        l.setText("PIN");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        angestelltenPanel_pin = new TextField();
        angestelltenPanel_pin.setSize(120, 20);
        angestelltenPanel_pin.setLocation(80, 180);
        angestelltenPanel_pin.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenPanel_pin);
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(0, 210);
        b.setLabel("Neuen Kunden anlegen");
        b.setVisible(true);
        angestellterAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KundeErzeugen(angestelltenPanel_name.getText(),
                            Integer.parseInt(angestelltenPanel_pin.getText()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("PIN muss eine ganze Zahl sein.");
                }
            }
        });
        kundeLoeschen = new Button();
        kundeLoeschen.setSize(200, 30);
        kundeLoeschen.setLocation(0, 270);
        kundeLoeschen.setLabel("Kunden l\u00F6schen");
        kundeLoeschen.setVisible(true);
        kundeLoeschen.setEnabled(false);
        angestellterAuswahlPanel.add(kundeLoeschen);
        kundeLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FrageStellen(
                        "Wollen Sie den aktuellen Kunden wirklich l\u00F6schen?");
                if (antwort)
                {
                    kontroller.KundeLoeschen();
                }
            }
        });
        angestellter_kunde = new Label();
        angestellter_kunde.setSize(200, 20);
        angestellter_kunde.setLocation(250, 30);
        angestellter_kunde.setText("Es ist kein Kunde ausgew\u00E4hlt");
        angestellter_kunde.setAlignment(Label.CENTER);
        angestellter_kunde.setVisible(true);
        angestellterAuswahlPanel.add(angestellter_kunde);
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(250, 70);
        l.setText("Konten");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        kontenwahl2 = new Choice();
        kontenwahl2.setSize(120, 30);
        kontenwahl2.setLocation(330, 70);
        kontenwahl2.setVisible(true);
        angestellterAuswahlPanel.add(kontenwahl2);
        kontoWaehlen = new Button();
        kontoWaehlen.setSize(200, 30);
        kontoWaehlen.setLocation(250, 100);
        kontoWaehlen.setLabel("Konto w\u00E4hlen");
        kontoWaehlen.setVisible(true);
        kontoWaehlen.setEnabled(false);
        angestellterAuswahlPanel.add(kontoWaehlen);
        kontoWaehlen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.KontoFuerAngestelltenSetzen(
                            Integer.parseInt(kontenwahl2.getSelectedItem()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("Interner Fehler bei der Kontenwahl");
                }
            }
        });
        kontoart = new CheckboxGroup();
        sparkonto = new Checkbox("Sparkonto", kontoart, true);
        sparkonto.setSize(100, 30);
        sparkonto.setLocation(250, 150);
        sparkonto.setVisible(true);
        angestellterAuswahlPanel.add(sparkonto);
        sparkonto.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    verwendungFuerWert.setText("Zinssatz");
                    angestelltenPanel_wert.setText("");
                }
            }
        });
        girokonto = new Checkbox("Girokonto", kontoart, false);
        girokonto.setSize(100, 30);
        girokonto.setLocation(350, 150);
        girokonto.setVisible(true);
        angestellterAuswahlPanel.add(girokonto);
        girokonto.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    verwendungFuerWert.setText("Kreditrahmen");
                    angestelltenPanel_wert.setText("");
                }
            }
        });
        verwendungFuerWert = new Label();
        verwendungFuerWert.setSize(100, 20);
        verwendungFuerWert.setLocation(250, 180);
        verwendungFuerWert.setText("Zinssatz");
        verwendungFuerWert.setVisible(true);
        angestellterAuswahlPanel.add(verwendungFuerWert);
        angestelltenPanel_wert = new TextField();
        angestelltenPanel_wert.setSize(100, 20);
        angestelltenPanel_wert.setLocation(350, 180);
        angestelltenPanel_wert.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenPanel_wert);
        kontoAnlegen = new Button();
        kontoAnlegen.setSize(200, 30);
        kontoAnlegen.setLocation(250, 210);
        kontoAnlegen.setLabel("Konto anlegen");
        kontoAnlegen.setVisible(true);
        kontoAnlegen.setEnabled(false);
        angestellterAuswahlPanel.add(kontoAnlegen);
        kontoAnlegen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                double wert;
                try
                {
                    wert = Double.parseDouble(angestelltenPanel_wert.getText());
                    if (sparkonto.getState())
                    {
                        kontroller.SparkontoEinrichten(wert);
                    }
                    else if (girokonto.getState())
                    {
                        kontroller.GirokontoEinrichten(wert);
                    }
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("Bitte einen korrekten Betrag eingeben.");
                    angestelltenPanel_wert.requestFocus();
                    angestelltenPanel_wert.selectAll();
                }
            }
        });
        kontoAuszuege = new Button();
        kontoAuszuege.setSize(200, 30);
        kontoAuszuege.setLocation(250, 270);
        kontoAuszuege.setLabel("Kontoausz\u00FCge erstellen");
        kontoAuszuege.setVisible(true);
        kontoAuszuege.setEnabled(false);
        angestellterAuswahlPanel.add(kontoAuszuege);
        kontoAuszuege.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AnzeigetextZeigen(kontroller.KontoauszuegeGeben());
            }
        });
        kontoLoeschen = new Button();
        kontoLoeschen.setSize(200, 30);
        kontoLoeschen.setLocation(250, 300);
        kontoLoeschen.setLabel("Aktuelles Konto l\u00F6schen");
        kontoLoeschen.setVisible(true);
        kontoLoeschen.setEnabled(false);
        angestellterAuswahlPanel.add(kontoLoeschen);
        kontoLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FrageStellen(
                        "Wollen Sie das aktuelle Konto wirklich l\u00F6schen?");
                if (antwort)
                {
                    kontroller.KontoLoeschen();
                }
            }
        });
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(500, 30);
        l.setText("Angestellte");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        angestelltenwahl = new Choice();
        angestelltenwahl.setSize(120, 30);
        angestelltenwahl.setLocation(580, 30);
        angestelltenwahl.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenwahl);
        angestelltenLoeschen = new Button();
        angestelltenLoeschen.setSize(200, 30);
        angestelltenLoeschen.setLocation(500, 60);
        angestelltenLoeschen.setLabel("Angestellten l\u00F6schen");
        angestelltenLoeschen.setVisible(true);
        angestelltenLoeschen.setEnabled(false);
        angestellterAuswahlPanel.add(angestelltenLoeschen);
        angestelltenLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FrageStellen(
                        "Wollen Sie den Angestellten wirklich l\u00F6schen?");
                if (antwort)
                {
                    kontroller.AngestelltenLoeschen(
                            angestelltenwahl.getSelectedItem());
                }
            }
        });
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(500, 150);
        l.setText("Name");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        angestelltenPanel_name2 = new TextField();
        angestelltenPanel_name2.setSize(120, 20);
        angestelltenPanel_name2.setLocation(580, 150);
        angestelltenPanel_name2.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenPanel_name2);
        l = new Label();
        l.setSize(80, 20);
        l.setLocation(500, 180);
        l.setText("PIN");
        l.setVisible(true);
        angestellterAuswahlPanel.add(l);
        angestelltenPanel_pin2 = new TextField();
        angestelltenPanel_pin2.setSize(120, 20);
        angestelltenPanel_pin2.setLocation(580, 180);
        angestelltenPanel_pin2.setVisible(true);
        angestellterAuswahlPanel.add(angestelltenPanel_pin2);
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(500, 210);
        b.setLabel("Neuen Angestellten anlegen");
        b.setVisible(true);
        angestellterAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    kontroller.AngestellterErzeugen(
                            angestelltenPanel_name2.getText(),
                            Integer.parseInt(angestelltenPanel_pin2.getText()));
                }
                catch (Exception ex)
                {
                    FehlertextZeigen("PIN muss eine ganze Zahl sein.");
                }
            }
        });
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(500, 270);
        b.setLabel("Verzinsen");
        b.setVisible(true);
        angestellterAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontroller.Verzinsen();
            }
        });
        b = new Button();
        b.setSize(200, 30);
        b.setLocation(500, 300);
        b.setLabel("Log anzeigen");
        b.setVisible(true);
        angestellterAuswahlPanel.add(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loganzeige.setVisible(true);
            }
        });
    }

    /**
     * Statusanzeige besetzen
     *
     * @param text anzuzeigender Statustext
     */
    public void StatusmeldungSetzen(String text)
    {
        status.setText("Status: " + text);
    }

    /**
     * Fehlermeldungen beim Ausf&uuml;hren von Aktionen anzeigen
     *
     * @param text anzuzeigende Fehlermeldung
     */
    public void FehlermeldungAnzeigen(String text)
    {
        FehlertextZeigen(text);
    }

    /**
     * Fehlermeldungen beim Ausf&uuml;hren von Aktionen
     */
    public void FehlermeldungEmpfangen(String text)
    {
        FehlermeldungAnzeigen(text);
    }

    /**
     * Aktionslog f&uuml;r den Ablauf
     *
     * @param text der Text des Logeintrags
     */
    public void LogeintragEmpfangen(String text)
    {
        logtext.append(text + "\n");
    }
}
