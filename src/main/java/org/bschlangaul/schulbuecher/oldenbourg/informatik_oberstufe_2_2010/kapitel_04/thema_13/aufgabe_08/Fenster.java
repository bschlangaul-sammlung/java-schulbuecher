package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_08;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * Benutzeroberfläche für den Brute-Force-Passwortsucher
 *
 * @version 1.0 vom 26.08.2009
 *
 * @author Klaus Reinold
 */
public class Fenster extends Frame
{
    // Anfang Attribute
    private Label label1 = new Label();

    private TextField textField1 = new TextField();

    private Label label2 = new Label();

    private Choice choice1 = new Choice();

    private Label label3 = new Label();

    private Label label4 = new Label();

    private Choice choice2 = new Choice();

    private Button button1 = new Button();

    private Label label5 = new Label();

    private Label label6 = new Label();

    Controller c;

    Fenster f;
    // Ende Attribute

    public Fenster()
    {
        // Frame-Initialisierung
        super("Laufzeitmessung bei Brute-Force-Attacke");
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 449;
        int frameHeight = 324;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel cp = new Panel(null);
        add(cp);
        f = this;
        // Anfang Komponenten
        label1.setBounds(24, 16, 400, 29);
        label1.setText("Laufzeitmessung Brute-Force-Attacke");
        label1.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
        cp.add(label1);
        textField1.setBounds(24, 88, 145, 24);
        textField1.setText("");
        textField1.setEchoChar('|');
        cp.add(textField1);
        label2.setBounds(24, 64, 118, 16);
        label2.setText("Passwort eingeben:");
        label2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label2);
        choice1.setBounds(24, 152, 201, 24);
        choice1.add("a..z");
        choice1.add("a..z A..Z");
        choice1.add("a..z 0..9");
        choice1.add("a..z A..Z 0..9");
        choice1.add("a..z A..Z 0..9 !" + (new Character((char) 34)).toString()
                + " §$%&/()=?*+#-_.:;,");
        cp.add(choice1);
        label3.setBounds(24, 128, 82, 16);
        label3.setText("Zeichenvorrat");
        label3.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label3);
        label4.setBounds(240, 128, 99, 16);
        label4.setText("maximale Länge");
        label4.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label4);
        choice2.setBounds(240, 152, 105, 24);
        choice2.add("1");
        choice2.add("2");
        choice2.add("3");
        choice2.add("4");
        choice2.add("5");
        choice2.add("6");
        choice2.add("7");
        choice2.add("8");
        choice2.add("9");
        choice2.add("10");
        choice2.add("11");
        choice2.add("12");
        choice2.add("13");
        cp.add(choice2);
        button1.setBounds(24, 192, 321, 33);
        button1.setLabel("Attacke starten!");
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (button1.getLabel().equals("Attacke starten!"))
                {
                    button1.setLabel("Berechnung läuft!");
                    label5.setText("");
                    label6.setText("");
                    c = new Controller(choice1.getSelectedItem(),
                            choice2.getSelectedItem(), textField1.getText(), f);
                }
                else
                {
                    button1.setLabel("Attacke starten!");
                }
            }
        });
        cp.add(button1);
        label5.setBounds(24, 240, 235, 16);
        label5.setVisible(true);
        label5.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label5);
        label6.setBounds(24, 264, 227, 16);
        label6.setVisible(true);
        label6.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(label6);
        // Ende Komponenten
        setResizable(false);
        setVisible(true);
    }

    /**
     * Sorgt für die Anzeige des geknackten Passwortes und der benötigten Zeit.
     *
     * @param sneu geknacktes Passwort
     * @param zeit benötigte Zeit in ns
     */
    void ErgebnisSetzen(String sneu, long zeit)
    {
        label5.setText("Entdecktes Passwort: " + sneu);
        label6.setText("Dauer: " + zeit + " ns");
        System.out.println(zeit);
        button1.setLabel("Attacke starten!");
    }

    public static void main(String[] args)
    {
        new Fenster();
    }
}
