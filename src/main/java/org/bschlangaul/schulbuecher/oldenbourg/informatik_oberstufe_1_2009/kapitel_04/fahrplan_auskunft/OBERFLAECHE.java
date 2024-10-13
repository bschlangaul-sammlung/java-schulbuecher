package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Bedienoberfläche für die Fahrplanauskunft.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class OBERFLAECHE
{
    private Frame fenster;

    private Choice startWahl, zielWahl;

    private List routenAnzeige;

    private KONTROLLEUR kontrolleur;

    /**
     * Baut das Anzeigefenster auf.
     *
     * @param k Kontrolleur
     * @param namen Namen der Bahnhöfe
     * @param plan Linienplananzeige
     */
    OBERFLAECHE(KONTROLLEUR k, String[] namen, Canvas plan)
    {
        Label l;
        Button b;
        kontrolleur = k;
        fenster = new Frame("Fahrwegauskunft");
        fenster.setLayout(null);
        fenster.setSize(800, 600);
        l = new Label();
        l.setText("Startbahnhof");
        l.setSize(90, 20);
        l.setLocation(510, 105);
        fenster.add(l);
        startWahl = new Choice();
        startWahl.setSize(190, 30);
        startWahl.setLocation(600, 100);
        startWahl.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                kontrolleur.StartbahnhofSetzen(startWahl.getSelectedIndex());
            }
        });
        fenster.add(startWahl);
        l = new Label();
        l.setText("Zielbahnhof");
        l.setSize(90, 20);
        l.setLocation(510, 145);
        fenster.add(l);
        zielWahl = new Choice();
        zielWahl.setSize(190, 30);
        zielWahl.setLocation(600, 140);
        zielWahl.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                kontrolleur.ZielbahnhofSetzen(zielWahl.getSelectedIndex());
            }
        });
        fenster.add(zielWahl);
        b = new Button();
        b.setLabel("Route berechnen");
        b.setSize(280, 30);
        b.setLocation(510, 170);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.RouteBerechnen(startWahl.getSelectedIndex(),
                        zielWahl.getSelectedIndex());
            }
        });
        fenster.add(b);
        l = new Label();
        l.setText("Fahrtstrecke");
        l.setAlignment(Label.CENTER);
        l.setSize(280, 20);
        l.setLocation(510, 270);
        fenster.add(l);
        routenAnzeige = new List(10, false);
        routenAnzeige.setSize(280, 220);
        routenAnzeige.setLocation(510, 300);
        fenster.add(routenAnzeige);
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
        fenster.add(plan);
        BahnhofsnamenSetzen(namen);
        fenster.setVisible(true);
    }

    /**
     * Setzt die Texte für die Auswahlmenüs.
     *
     * @param namen Anzeigetexte
     */
    private void BahnhofsnamenSetzen(String[] namen)
    {
        for (int i = 0; i < namen.length; i++)
        {
            startWahl.add(namen[i]);
            zielWahl.add(namen[i]);
        }
        kontrolleur.StartbahnhofSetzen(0);
        kontrolleur.ZielbahnhofSetzen(0);
    }

    /**
     * Setzt die Texte für die Routenanzeige.
     *
     * @param namen Anzeigetexte
     */
    void FahrtstreckeSetzen(String[] namen)
    {
        routenAnzeige.removeAll();
        for (int i = 0; i < namen.length; i++)
        {
            routenAnzeige.add(namen[i]);
        }
    }
}
