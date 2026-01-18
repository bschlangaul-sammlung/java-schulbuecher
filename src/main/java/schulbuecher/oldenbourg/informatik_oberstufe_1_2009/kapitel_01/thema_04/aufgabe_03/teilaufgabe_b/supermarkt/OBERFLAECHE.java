package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Erzeugt die Bedienelemente und verwaltet das Ausgabefenster.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class OBERFLAECHE
{
    /**
     * Vereinbart die für die Simulation nötigen Standardfarben.
     */
    enum FARBE
    {
        weiss, schwarz, rot, gruen, blau, gelb, magenta, cyan, grau;

        /**
         * Konvertiert die angegebene FARBE in ihr AWT-Pendant.
         *
         * @return die entsprechende AWT-FARBE
         */
        public java.awt.Color AWTFarbe()
        {
            java.awt.Color farbe;
            switch (this)
            {
            case weiss:
                farbe = java.awt.Color.white;
                break;

            case schwarz:
                farbe = java.awt.Color.black;
                break;

            case rot:
                farbe = java.awt.Color.red;
                break;

            case gruen:
                farbe = java.awt.Color.green;
                break;

            case blau:
                farbe = java.awt.Color.blue;
                break;

            case gelb:
                farbe = java.awt.Color.yellow;
                break;

            case magenta:
                farbe = java.awt.Color.magenta;
                break;

            case cyan:
                farbe = java.awt.Color.cyan;
                break;

            case grau:
                farbe = java.awt.Color.gray;
                break;

            default:
                farbe = java.awt.Color.white;
            }
            return farbe;
        }

        private static java.util.Random ran = new java.util.Random();

        /**
         * Erzeugt eine zufällige FARBE
         *
         * @return die erzeugte FARBE
         */
        static FARBE ZufallsFarbeErzeugen()
        {
            FARBE[] alle = FARBE.values();
            return alle[ran.nextInt(alle.length)];
        }
    }

    private static OBERFLAECHE o = null;

    private Frame fenster = null;

    private TextField eingabe;

    private TextField eingabe2;

    private ADAPTER a;

    /**
     * Baut die Bedienoberfläche auf
     */
    private OBERFLAECHE()
    {
        int hoehe, breite;
        Label l;
        Button button;
        hoehe = 550;
        breite = 750;
        a = null;
        fenster = new Frame("Supermarkt");
        fenster.setResizable(false);
        fenster.setVisible(true);
        fenster.setLayout(null);
        fenster.setBackground(Color.white);
        fenster.setSize(breite, hoehe);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
        l = new Label();
        l.setText("Kasse 1");
        l.setLocation(20, hoehe - 90);
        l.setVisible(true);
        l.setSize(100, 20);
        fenster.add(l);
        button = new Button();
        button.setLocation(20, hoehe - 70);
        button.setLabel("\u00D6ffnen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseOeffnen(0);
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(20, hoehe - 40);
        button.setLabel("Schliessen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseSchliessen(0);
            }
        });
        fenster.add(button);
        l = new Label();
        l.setText("Kasse 2");
        l.setLocation(140, hoehe - 90);
        l.setVisible(true);
        l.setSize(100, 20);
        fenster.add(l);
        button = new Button();
        button.setLocation(140, hoehe - 70);
        button.setLabel("\u00D6ffnen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseOeffnen(1);
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(140, hoehe - 40);
        button.setLabel("Schliessen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseSchliessen(1);
            }
        });
        fenster.add(button);
        l = new Label();
        l.setText("Kasse 3");
        l.setLocation(260, hoehe - 90);
        l.setVisible(true);
        l.setSize(100, 20);
        fenster.add(l);
        button = new Button();
        button.setLocation(260, hoehe - 70);
        button.setLabel("\u00D6ffnen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseOeffnen(2);
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(260, hoehe - 40);
        button.setLabel("Schliessen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.KasseSchliessen(2);
            }
        });
        fenster.add(button);
        l = new Label();
        l.setText("Kundenabstand [s]");
        l.setLocation(380, hoehe - 90);
        l.setVisible(true);
        l.setSize(150, 20);
        fenster.add(l);
        eingabe = new TextField();
        eingabe.setLocation(380, hoehe - 65);
        eingabe.setText("20");
        eingabe.setVisible(true);
        eingabe.setSize(80, 20);
        eingabe.setEnabled(true);
        fenster.add(eingabe);
        button = new Button();
        button.setLocation(380, hoehe - 40);
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
                    a.KundenabstandSetzen(Integer.parseInt(eingabe.getText()));
                }
                catch (Exception ex)
                {
                    (Toolkit.getDefaultToolkit()).beep();
                }
            }
        });
        fenster.add(button);
        button = new Button();
        button.setLocation(500, hoehe - 70);
        button.setLabel("Starten");
        button.setVisible(true);
        button.setSize(100, 30);
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
        button.setLocation(500, hoehe - 40);
        button.setLabel("Stoppen");
        button.setVisible(true);
        button.setSize(100, 30);
        button.setEnabled(true);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                a.Anhalten();
            }
        });
        fenster.add(button);
        l = new Label();
        l.setText("Zeitfaktor");
        l.setLocation(620, hoehe - 90);
        l.setVisible(true);
        l.setSize(100, 20);
        fenster.add(l);
        eingabe2 = new TextField();
        eingabe2.setLocation(620, hoehe - 65);
        eingabe2.setText("20");
        eingabe2.setVisible(true);
        eingabe2.setSize(80, 20);
        eingabe2.setEnabled(true);
        fenster.add(eingabe2);
        button = new Button();
        button.setLocation(620, hoehe - 40);
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
