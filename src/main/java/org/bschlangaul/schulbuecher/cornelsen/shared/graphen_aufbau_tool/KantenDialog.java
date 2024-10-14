package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * Erstellt einen modalen Dialog zum Editieren eines Knotens
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KantenDialog extends JDialog
{
    /**
     * Das Eingabefeld für die Gewichtung
     */
    private JTextField gewichtung;

    /**
     * Knopf für die Auswahl von gerichtet / ungerichtet
     */
    private JToggleButton gerichtet;

    /**
     * Der Empfänger für die Oberflächenereignisse
     */
    private EreignisEmpfaenger empfänger;

    /**
     * Legt die Oberflächenelemente an.
     *
     * @param fenster das übergeordnete Fenster
     */
    KantenDialog(JFrame fenster)
    {
        super(fenster, "Kantendaten editieren", ModalityType.APPLICATION_MODAL);
        empfänger = null;
        setLayout(null);
        setSize(300, 160);
        setVisible(false);
        setLocation(fenster.getX() + fenster.getWidth() / 2 - 150,
                fenster.getY());
        JLabel l = new JLabel();
        l.setSize(180, 20);
        l.setLocation(10, 10);
        l.setVisible(true);
        l.setText("Gewichtung:");
        add(l);
        l = new JLabel();
        l.setSize(180, 20);
        l.setLocation(10, 50);
        l.setVisible(true);
        l.setText("Gerichtet:");
        add(l);
        gewichtung = new JTextField();
        gewichtung.setSize(100, 30);
        gewichtung.setLocation(180, 5);
        gewichtung.setVisible(true);
        gewichtung.setText("");
        add(gewichtung);
        gerichtet = new JToggleButton("ungerichtet", false);
        gerichtet.setSize(100, 30);
        gerichtet.setLocation(180, 45);
        gerichtet.setVisible(true);
        gerichtet.setEnabled(true);
        gerichtet.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                TextFürToggleButtonSetzen();
            }
        });
        add(gerichtet);
        JButton b = new JButton("Abbrechen");
        b.setSize(130, 30);
        b.setLocation(10, 100);
        b.setVisible(true);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });
        add(b);
        b = new JButton("OK");
        b.setSize(130, 30);
        b.setLocation(160, 100);
        b.setVisible(true);
        b.setDefaultCapable(true);
        getRootPane().setDefaultButton(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                empfänger.KanteEditieren(gewichtung.getText(),
                        gerichtet.isSelected());
                setVisible(false);
            }
        });
        add(b);
    }

    /**
     * Beschtiftung für den Togglebutton setzen.
     */
    private void TextFürToggleButtonSetzen()
    {
        gerichtet.setText(gerichtet.isSelected() ? "gerichtet" : "ungerichtet");
    }

    /**
     * Zeigt den Dialog und setzt den aktiven Knoten
     *
     * @param daten Daten des zu bearbeitenden Knoten
     * @param e der Ereignisempfänger
     */
    void Anzeigen(String[] daten, EreignisEmpfaenger e)
    {
        empfänger = e;
        gewichtung.setText(daten[0]);
        gewichtung.requestFocusInWindow();
        gerichtet.setSelected(daten[1].equals("true"));
        TextFürToggleButtonSetzen();
        setVisible(true);
    }
}
