package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_16.fussball;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @version 1.0 vom 08.01.2009
 */
class Fenster extends Frame
{
    // Anfang Attribute
    private Choice choice1 = new Choice();

    private Choice choice2 = new Choice();

    private Label label1 = new Label();

    private Label label2 = new Label();

    private Choice choice3 = new Choice();

    private Label label3 = new Label();

    private Label label4 = new Label();

    private Label label5 = new Label();

    private Button button1 = new Button();

    private TextArea textArea1 = new TextArea("", 1, 1,
            TextArea.SCROLLBARS_NONE);

    private Bundesliga bundesliga;
    // Ende Attribute

    /**
     * Konstruktor erzeugt ein Fenster und eine Bundesliga
     */
    Fenster()
    {

        // Frame-Initialisierung
        super("Bundesligaverwaltung");
        bundesliga = new Bundesliga(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 572;
        int frameHeight = 691;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel cp = new Panel(null);
        add(cp);
        // Anfang Komponenten

        choice1.setBounds(8, 128, 137, 24);
        cp.add(choice1);
        choice2.setBounds(152, 128, 137, 24);
        cp.add(choice2);
        label1.setBounds(8, 104, 89, 16);
        label1.setText("Mannschaft 1:");
        label1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label1);
        label2.setBounds(152, 104, 97, 16);
        label2.setText("Mannschaft 2:");
        label2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label2);
        choice3.setBounds(296, 128, 137, 24);
        choice3.add("Mannschaft 1");
        choice3.add("Mannschaft 2");
        choice3.add("unentschieden");
        cp.add(choice3);
        label3.setBounds(296, 104, 51, 16);
        label3.setText("Sieger:");
        label3.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label3);
        label4.setBounds(8, 80, 126, 16);
        label4.setText("Spiel eintragen:");
        label4.setFont(new Font("MS Sans Serif", Font.BOLD, 13));
        cp.add(label4);
        label5.setBounds(8, 16, 328, 37);
        label5.setText("Bundesligaverwaltung");
        label5.setFont(new Font("MS Sans Serif", Font.PLAIN, 27));
        cp.add(label5);
        textArea1.setBounds(8, 224, 321, 433);
        textArea1.setText(bundesliga.ListeAusgeben());
        cp.add(textArea1);
        button1.setBounds(440, 128, 129, 25);
        button1.setLabel("Spiel aufnehmen");
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                int sieger;
                if (choice3.getSelectedItem() == "Mannschaft 1")
                {
                    sieger = 1;
                }
                else
                {
                    if (choice3.getSelectedItem() == "Mannschaft 2")
                    {
                        sieger = 2;
                    }
                    else
                    {
                        sieger = 0;
                    }
                }
                bundesliga.SpielergebnisAufnehmen(choice1.getSelectedItem(),
                        choice2.getSelectedItem(), sieger);
                textArea1.setText(bundesliga.ListeAusgeben());
            }

        });
        cp.add(button1);
        textArea1.setBounds(8, 224, 321, 433);
        textArea1.setText(bundesliga.ListeAusgeben());
        cp.add(textArea1);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);

    }

    /**
     * Fügt eine neue Mannschaft in beide Aufklappfelder ein.
     */
    void ItemEinfügen(String s)
    {
        choice1.add(s);
        choice2.add(s);
    }
}
