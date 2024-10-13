package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.einfache_oberflaeche;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Testoberfläche.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class EINACHEOBERFLAECHE
{
    Frame fenster;

    Label text;

    TextField eingabe;

    Button knopf1, knopf2, knopf3;

    /**
     * Erzeugt die Oberflächenelemente.
     */
    EINACHEOBERFLAECHE()
    {
        fenster = new Frame("Testfenster");
        fenster.setSize(300, 200);
        fenster.setLocation(50, 50);
        fenster.setVisible(true);
        fenster.setLayout(null);
        text = new Label();
        text.setText("Vorbesetzung");
        text.setLocation(10, 30);
        text.setSize(280, 20);
        text.setAlignment(Label.CENTER);
        text.setVisible(true);
        fenster.add(text);
        knopf1 = new Button();
        knopf1.setLocation(10, 60);
        knopf1.setLabel("Knopf 1");
        knopf1.setVisible(true);
        knopf1.setSize(130, 30);
        knopf1.setEnabled(true);
        fenster.add(knopf1);
        knopf2 = new Button();
        knopf2.setLocation(160, 60);
        knopf2.setLabel("Knopf 2");
        knopf2.setVisible(true);
        knopf2.setSize(130, 30);
        knopf2.setEnabled(true);
        fenster.add(knopf2);
        knopf1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text.setText("Knopf 1 gedrueckt");
            }
        });
        knopf2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text.setText("Knopf 2 gedrueckt");
            }
        });
        eingabe = new TextField();
        eingabe.setText("");
        eingabe.setLocation(10, 100);
        eingabe.setSize(280, 30);
        eingabe.setVisible(true);
        fenster.add(eingabe);
        knopf3 = new Button();
        knopf3.setLocation(10, 140);
        knopf3.setLabel("Text uebernehmen");
        knopf3.setVisible(true);
        knopf3.setSize(280, 30);
        knopf3.setEnabled(true);
        fenster.add(knopf3);
        knopf3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text.setText(eingabe.getText());
            }
        });
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
    }
}
