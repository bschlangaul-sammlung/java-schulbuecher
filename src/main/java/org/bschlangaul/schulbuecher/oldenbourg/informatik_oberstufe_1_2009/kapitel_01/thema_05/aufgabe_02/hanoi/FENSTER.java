package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_02.hanoi;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * Fenster zur Darstellung des Spiels
 *
 * @version 1.0 vom 17.01.2009
 *
 * @author
 */
class FENSTER extends Frame
{
    // Anfang Attribute
    private Choice choice1 = new Choice();

    private Label label1 = new Label();

    private Label label2 = new Label();

    private Button button1 = new Button();

    private Canvas canvas1 = new Canvas();

    private Canvas canvas2 = new Canvas();

    private Canvas canvas3 = new Canvas();

    private Canvas canvas4 = new Canvas();

    private Canvas canvas5 = new Canvas();

    private static FENSTER f = null;

    private static Panel cp = new Panel(null);

    private SPIEL s;

    /**
     * Konstruktor Initialisiert und positioniert die Komponenten. Legt
     * Ereignisbehandlung fest.
     */
    private FENSTER()
    {
        // Frame-Initialisierung
        super("T\u00FCrme von Hanoi");
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 372;
        int frameHeight = 354;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        add(cp);
        choice1.setBounds(152, 248, 81, 24);
        choice1.add("1");
        choice1.add("2");
        choice1.add("3");
        choice1.add("4");
        choice1.add("5");
        choice1.add("6");
        choice1.add("7");
        choice1.add("8");
        choice1.add("9");
        cp.add(choice1);
        label1.setBounds(16, 256, 126, 16);
        label1.setText("Anzahl der Scheiben:");
        label1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label1);
        label2.setBounds(110, 8, 150, 24);
        label2.setText("T\u00FCrme von Hanoi");
        label2.setFont(new Font("MS Sans Serif", Font.PLAIN, 19));
        cp.add(label2);
        button1.setBounds(256, 248, 89, 25);
        button1.setLabel("Starten");
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (s != null)
                {
                    s.Loeschen();
                }
                s = new SPIEL(Integer.parseInt(choice1.getSelectedItem()));
            }
        });
        cp.add(button1);
        canvas1.setBounds(40, 200, 300, 10);
        canvas1.setBackground(Color.GRAY);
        cp.add(canvas1);
        canvas2.setBounds(85, 100, 10, 100);
        canvas2.setBackground(Color.GRAY);
        cp.add(canvas2);
        canvas3.setBounds(85, 250, 10, 100);
        cp.add(canvas3);
        canvas4.setBounds(185, 100, 10, 100);
        canvas4.setBackground(Color.GRAY);
        cp.add(canvas4);
        canvas5.setBounds(285, 100, 10, 100);
        canvas5.setBackground(Color.GRAY);
        cp.add(canvas5);
        // Ende Komponenten
        setResizable(false);
        setVisible(true);
    }

    /**
     * Gibt das Panel zur Anzeige zurück und erzeugt ggf. ein Ausgabefenster.
     *
     * @return Ausgabefenster
     */
    public static Panel PanelGeben()
    {
        if (f == null)
        {
            f = new FENSTER();
        }
        return cp;
    }
}
