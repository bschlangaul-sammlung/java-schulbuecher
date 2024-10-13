package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Beschreibt die Bedienoberfläche.
 *
 * @author
 *
 * @version 1.0
 */
class OBERFLAECHE implements STATUSBEOBACHTER
{
    private JComponent karte;

    private JFrame fenster;

    private JComboBox startOrt;

    private JComboBox zielOrt;

    private JLabel status;

    private JList ortInfos;

    private JList wegInfos;

    private KONTROLLEUR kontrolleur;

    /**
     * Legt die Oberflächenelemente an.
     *
     * @param karte Die Komponente zur Darstellung der Karte.
     * @param orte Feld mit den Orten, nutzt ort. toString ()
     * @param ortInfo Feld mit den Ortsinformationen
     * @param wegInfo Feld mit den Weginformationen
     */
    OBERFLAECHE(JComponent karte, Object[] orte, String[] ortInfo,
            String[] wegInfo, KONTROLLEUR k)
    {
        this.karte = karte;
        kontrolleur = k;
        KomponentenAnlegen(orte, ortInfo, wegInfo);
    }

    /**
     * Vereinbarung der Oberflächenkomponenten.
     *
     * @param orte Feld mit den Orten, nutzt ort. toString ()
     * @param ortInfo Feld mit den Ortsinformationen
     * @param wegInfo Feld mit den Weginformationen
     */
    private void KomponentenAnlegen(Object[] orte, String[] ortInfo,
            String[] wegInfo)
    {
        JPanel content;
        JButton button;
        JLabel l;
        JScrollPane scroll;
        fenster = new JFrame("Fahrradroutenplaner");
        fenster.setResizable(false);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                kontrolleur.Beenden();
            }
        });
        content = (JPanel) fenster.getContentPane();
        content.setLayout(null);
        button = new JButton("Route berechnen");
        content.add(button);
        button.setBounds(300, 35, 160, 30);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.WegBerechnen(startOrt.getSelectedItem(),
                        zielOrt.getSelectedItem());
            }
        });
        button = new JButton("Beenden");
        content.add(button);
        button.setBounds(650, 35, 160, 30);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.Beenden();
            }
        });
        l = new JLabel("Startort:");
        content.add(l);
        l.setBounds(20, 20, 90, 20);
        l = new JLabel("Zielort:");
        content.add(l);
        l.setBounds(20, 60, 90, 20);
        startOrt = new JComboBox(orte);
        content.add(startOrt);
        startOrt.setBackground(new Color(0, 153, 51));
        startOrt.setBounds(120, 15, 150, 30);
        zielOrt = new JComboBox(orte);
        content.add(zielOrt);
        zielOrt.setBackground(new Color(240, 0, 0));
        zielOrt.setBounds(120, 55, 150, 30);
        ortInfos = new JList(ortInfo);
        scroll = new JScrollPane(ortInfos);
        content.add(scroll);
        scroll.setPreferredSize(new Dimension(400, 400));
        scroll.setBounds(420, 310, 400, 200);
        wegInfos = new JList(wegInfo);
        scroll = new JScrollPane(wegInfos);
        content.add(scroll);
        scroll.setPreferredSize(new Dimension(400, 400));
        scroll.setBounds(420, 100, 400, 200);
        status = new JLabel("");
        content.add(status);
        status.setBounds(20, 540, 790, 20);
        content.add(karte);
        karte.setBounds(10, 100, 400, 410);
        fenster.setSize(830, 600);
        fenster.setVisible(true);
    }

    /**
     * Empfängt Statusmeldungen
     *
     * @param text Text der Statusmeldungen
     */
    public void StatusSetzen(String text)
    {
        status.setText(text);
    }

    /**
     * Empfängt die Vorgängerinformation, Start und Ziel
     *
     * @param vorgaenger Liste mit der Vorgängerinformation
     * @param start Name des Startortes
     * @param ziel Name des Zielortes
     */
    public void WegSetzen(LISTE vorgaenger, String start, String ziel)
    {
        // nix
    }
}
