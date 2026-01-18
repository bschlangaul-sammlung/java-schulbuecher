package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Bedienoberfläche für die Fahrplanwartung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class OBERFLAECHE
{
    private Frame fenster;

    private TextField xBahnhof, yBahnhof, nameBahnhof;

    private Button bahnhofNeu, bahnhofAendern, bahnhofLoeschen, neuerAbschnitt,
            abschnittAendern, abschnittLoeschen, umsteigenSetzen,
            umsteigenLoeschen;

    @SuppressWarnings("unused")
    private TextField x1Abschnitt, y1Abschnitt, x2Abschnitt, y2Abschnitt;

    private Choice linienAuswahl, bahnhofFuerAbschnitt, umsteigenVon,
            umsteigenNach, vorhanden;

    private TextField linienLaenge, linienLaenge2, liniennummer1;

    private KONTROLLEUR kontrolleur;

    /**
     * Baut das Anzeigefenster auf.
     *
     * @param k Kontrolleur
     * @param namen Namen der Bahnhöfe
     * @param plan Oberflächenkomponente zur Anzeige des Linienplans
     */
    OBERFLAECHE(KONTROLLEUR k, String[] namen, Canvas plan)
    {
        Label l;
        Button b;
        kontrolleur = k;
        fenster = new Frame("Fahrplanwartung");
        fenster.setLayout(null);
        fenster.setSize(800, 600);
        l = new Label();
        l.setText("Bahnhof");
        l.setSize(280, 20);
        l.setAlignment(Label.CENTER);
        l.setLocation(510, 55);
        fenster.add(l);
        l = new Label();
        l.setText("x");
        l.setSize(20, 20);
        l.setLocation(510, 80);
        fenster.add(l);
        xBahnhof = new TextField();
        xBahnhof.setText("");
        xBahnhof.setSize(115, 20);
        xBahnhof.setLocation(530, 80);
        fenster.add(xBahnhof);
        l = new Label();
        l.setText("y");
        l.setSize(20, 20);
        l.setLocation(655, 80);
        fenster.add(l);
        yBahnhof = new TextField();
        yBahnhof.setText("");
        yBahnhof.setSize(115, 20);
        yBahnhof.setLocation(675, 80);
        fenster.add(yBahnhof);
        l = new Label();
        l.setText("Name");
        l.setSize(50, 20);
        l.setLocation(510, 110);
        fenster.add(l);
        nameBahnhof = new TextField();
        nameBahnhof.setText("");
        nameBahnhof.setSize(230, 20);
        nameBahnhof.setLocation(560, 110);
        fenster.add(nameBahnhof);
        bahnhofNeu = new Button();
        bahnhofNeu.setLabel("Neu");
        bahnhofNeu.setSize(90, 30);
        bahnhofNeu.setLocation(510, 135);
        bahnhofNeu.setEnabled(true);
        bahnhofNeu.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int x, y;
                    x = Integer.parseInt(xBahnhof.getText());
                    y = Integer.parseInt(yBahnhof.getText());
                    kontrolleur.NeuenBahnhofEinfuegen(nameBahnhof.getText(), x,
                            y);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(bahnhofNeu);
        bahnhofAendern = new Button();
        bahnhofAendern.setLabel("\u00C4ndern");
        bahnhofAendern.setSize(90, 30);
        bahnhofAendern.setLocation(605, 135);
        bahnhofAendern.setEnabled(false);
        bahnhofAendern.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int x, y;
                    x = Integer.parseInt(xBahnhof.getText());
                    y = Integer.parseInt(yBahnhof.getText());
                    kontrolleur.BahnhofAendern(nameBahnhof.getText(), x, y);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(bahnhofAendern);
        bahnhofLoeschen = new Button();
        bahnhofLoeschen.setLabel("L\u00F6schen");
        bahnhofLoeschen.setSize(90, 30);
        bahnhofLoeschen.setLocation(700, 135);
        bahnhofLoeschen.setEnabled(false);
        bahnhofLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.BahnhofLoeschen();
            }
        });
        fenster.add(bahnhofLoeschen);
        neuerAbschnitt = new Button();
        neuerAbschnitt.setLabel("Abschnitt nach");
        neuerAbschnitt.setSize(120, 30);
        neuerAbschnitt.setLocation(510, 175);
        neuerAbschnitt.setEnabled(false);
        neuerAbschnitt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int linie;
                    float laenge;
                    linie = Integer.parseInt(liniennummer1.getText());
                    laenge = Float.parseFloat(linienLaenge2.getText());
                    kontrolleur.NeuenAbschnittAnlegen(linie, laenge);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(neuerAbschnitt);
        bahnhofFuerAbschnitt = new Choice();
        bahnhofFuerAbschnitt.setSize(150, 30);
        bahnhofFuerAbschnitt.setLocation(640, 180);
        bahnhofFuerAbschnitt.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                kontrolleur.ZielbahnhofWaehlen(
                        bahnhofFuerAbschnitt.getSelectedIndex());
            }
        });
        fenster.add(bahnhofFuerAbschnitt);
        l = new Label();
        l.setText("Liniennummer");
        l.setSize(100, 20);
        l.setLocation(510, 220);
        fenster.add(l);
        liniennummer1 = new TextField();
        liniennummer1.setText("");
        liniennummer1.setSize(170, 20);
        liniennummer1.setLocation(620, 220);
        fenster.add(liniennummer1);
        l = new Label();
        l.setText("L\u00E4nge");
        l.setSize(100, 20);
        l.setLocation(510, 250);
        fenster.add(l);
        linienLaenge2 = new TextField();
        linienLaenge2.setText("");
        linienLaenge2.setSize(170, 20);
        linienLaenge2.setLocation(620, 250);
        fenster.add(linienLaenge2);
        l = new Label();
        l.setText("Abschnitt");
        l.setSize(280, 20);
        l.setAlignment(Label.CENTER);
        l.setLocation(510, 300);
        fenster.add(l);
        linienAuswahl = new Choice();
        linienAuswahl.setSize(90, 30);
        linienAuswahl.setLocation(510, 325);
        linienAuswahl.setEnabled(false);
        linienAuswahl.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    kontrolleur.LinienabschnittSetzen(
                            Integer.parseInt(linienAuswahl.getSelectedItem()));
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(linienAuswahl);
        l = new Label();
        l.setText("L\u00E4nge");
        l.setSize(60, 20);
        l.setLocation(610, 330);
        fenster.add(l);
        linienLaenge = new TextField();
        linienLaenge.setText("");
        linienLaenge.setSize(110, 20);
        linienLaenge.setLocation(680, 330);
        fenster.add(linienLaenge);
        abschnittAendern = new Button();
        abschnittAendern.setLabel("\u00C4ndern");
        abschnittAendern.setSize(135, 30);
        abschnittAendern.setLocation(510, 360);
        abschnittAendern.setEnabled(false);
        abschnittAendern.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int linie;
                    float laenge;
                    linie = Integer.parseInt(linienAuswahl.getSelectedItem());
                    laenge = Float.parseFloat(linienLaenge.getText());
                    kontrolleur.AbschnittAendern(linie, laenge);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(abschnittAendern);
        abschnittLoeschen = new Button();
        abschnittLoeschen.setLabel("L\u00F6schen");
        abschnittLoeschen.setSize(135, 30);
        abschnittLoeschen.setLocation(655, 360);
        abschnittLoeschen.setEnabled(false);
        abschnittLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int linie;
                    linie = Integer.parseInt(linienAuswahl.getSelectedItem());
                    kontrolleur.AbschnittLoeschen(linie);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(abschnittLoeschen);
        l = new Label();
        l.setText("Umsteigem\u00F6glichkeiten");
        l.setSize(280, 20);
        l.setAlignment(Label.CENTER);
        l.setLocation(510, 405);
        fenster.add(l);
        l = new Label();
        l.setText("vorhanden");
        l.setSize(100, 20);
        l.setLocation(510, 430);
        fenster.add(l);
        vorhanden = new Choice();
        vorhanden.setSize(170, 30);
        vorhanden.setLocation(620, 430);
        fenster.add(vorhanden);
        l = new Label();
        l.setText("von");
        l.setSize(50, 20);
        l.setLocation(510, 460);
        fenster.add(l);
        umsteigenVon = new Choice();
        umsteigenVon.setSize(85, 30);
        umsteigenVon.setLocation(560, 460);
        fenster.add(umsteigenVon);
        l = new Label();
        l.setText("nach");
        l.setSize(50, 20);
        l.setLocation(655, 460);
        fenster.add(l);
        umsteigenNach = new Choice();
        umsteigenNach.setSize(85, 30);
        umsteigenNach.setLocation(705, 460);
        fenster.add(umsteigenNach);
        umsteigenSetzen = new Button();
        umsteigenSetzen.setLabel("Neu");
        umsteigenSetzen.setSize(135, 30);
        umsteigenSetzen.setLocation(510, 490);
        umsteigenSetzen.setEnabled(false);
        umsteigenSetzen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int linie1, linie2;
                    linie1 = Integer.parseInt(umsteigenVon.getSelectedItem());
                    linie2 = Integer.parseInt(umsteigenNach.getSelectedItem());
                    kontrolleur.UmsteigenEinfuegen(linie1, linie2);
                }
                catch (Exception ex)
                {
                }
            }
        });
        fenster.add(umsteigenSetzen);
        umsteigenLoeschen = new Button();
        umsteigenLoeschen.setLabel("L\u00F6schen");
        umsteigenLoeschen.setSize(135, 30);
        umsteigenLoeschen.setLocation(655, 490);
        umsteigenLoeschen.setEnabled(false);
        umsteigenLoeschen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.UmsteigenLoeschen(vorhanden.getSelectedIndex());
            }
        });
        fenster.add(umsteigenLoeschen);
        b = new Button();
        b.setLabel("Beenden");
        b.setSize(280, 30);
        b.setLocation(510, 550);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.Beenden();
            }
        });
        fenster.add(b);
        plan.setLocation(50, 50);
        plan.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent e)
            {
                if (e.getPropertyName() == "Bahnhof")
                {
                    linienAuswahl.setEnabled(false);
                    abschnittAendern.setEnabled(false);
                    abschnittLoeschen.setEnabled(false);
                    if (e.getNewValue() == null)
                    {
                        xBahnhof.setText("");
                        yBahnhof.setText("");
                        nameBahnhof.setText("");
                        bahnhofAendern.setEnabled(false);
                        bahnhofLoeschen.setEnabled(false);
                        neuerAbschnitt.setEnabled(false);
                        umsteigenLoeschen.setEnabled(false);
                        umsteigenSetzen.setEnabled(false);
                    }
                    else
                    {
                        kontrolleur.BahnhofGewaehlt();
                        bahnhofAendern.setEnabled(true);
                        bahnhofLoeschen.setEnabled(
                                kontrolleur.KannAktbahnhofGeloeschtWerden());
                        neuerAbschnitt.setEnabled(true);
                        umsteigenLoeschen.setEnabled(true);
                        umsteigenSetzen.setEnabled(true);
                    }
                }
                else if (e.getPropertyName() == "Abschnitt")
                {
                    bahnhofAendern.setEnabled(false);
                    bahnhofLoeschen.setEnabled(false);
                    neuerAbschnitt.setEnabled(false);
                    umsteigenLoeschen.setEnabled(false);
                    umsteigenSetzen.setEnabled(false);
                    if (e.getNewValue() == null)
                    {
                        linienAuswahl.setEnabled(false);
                        abschnittAendern.setEnabled(false);
                        abschnittLoeschen.setEnabled(false);
                    }
                    else
                    {
                        kontrolleur.AbschnittGewaehlt();
                        linienAuswahl.setEnabled(true);
                        abschnittAendern.setEnabled(true);
                        abschnittLoeschen.setEnabled(true);
                    }
                }
            }
        });
        fenster.add(plan);
        fenster.setVisible(true);
    }

    /**
     * Setzt die Bahnhofsdaten.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param name Name
     */
    void BahnhofsdatenSetzen(String x, String y, String name)
    {
        xBahnhof.setText(x);
        yBahnhof.setText(y);
        nameBahnhof.setText(name);
    }

    /**
     * Setzt die Bahnhofsnamen für das Anlagen eines neuen Abschnitts.
     *
     * @param werte Auswahleinträge
     */
    void BahnhofsauswahlSetzen(String[] werte)
    {
        bahnhofFuerAbschnitt.removeAll();
        for (int i = 0; i < werte.length; i++)
        {
            bahnhofFuerAbschnitt.add(werte[i]);
        }
        bahnhofFuerAbschnitt.select(0);
        kontrolleur.ZielbahnhofWaehlen(0);
    }

    /**
     * Setzt die Liniennummern für die Linienauswahl.
     *
     * @param werte Auswahleinträge
     */
    void LinienauswahlSetzen(String[] werte)
    {
        linienAuswahl.removeAll();
        for (int i = 0; i < werte.length; i++)
        {
            linienAuswahl.add(werte[i]);
        }
        try
        {
            kontrolleur.LinienabschnittSetzen(Integer.parseInt(werte[0]));
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Setzt die Länge der ausgewählten Linie.
     *
     * @param wert Längenangabe
     */
    void LinienlaengeSetzen(String wert)
    {
        linienLaenge.setText(wert);
    }

    /**
     * Setzt die Liniennummern für die Umsteigeauswahl.
     *
     * @param werte Auswahleinträge
     */
    void LinienauswahlUmsteigenSetzen(String[] werte, String[] wertevorhanden)
    {
        umsteigenVon.removeAll();
        umsteigenNach.removeAll();
        for (int i = 0; i < werte.length; i++)
        {
            umsteigenVon.add(werte[i]);
            umsteigenNach.add(werte[i]);
        }
        vorhanden.removeAll();
        for (int i = 0; i < wertevorhanden.length; i++)
        {
            vorhanden.add(wertevorhanden[i]);
        }
    }
}
