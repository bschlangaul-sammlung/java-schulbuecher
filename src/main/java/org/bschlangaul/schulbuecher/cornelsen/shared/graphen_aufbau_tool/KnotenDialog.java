package org.bschlangaul.schulbuecher.cornelsen.shared.graphen_aufbau_tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Erstellt einen modalen Dialog zum Editieren eines Knotens
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KnotenDialog extends JDialog
{
    /**
     * Das Eingabefeld für die X-Koordinate
     */
    private JTextField xKoordinate;

    /**
     * Das Eingabefeld für die Y-Koordinate
     */
    private JTextField yKoordinate;

    /**
     * Das Eingabefeld für die Beschriftung
     */
    private JTextField beschriftung;

    /**
     * Der Empfänger für die Oberflächenereignisse
     */
    private EreignisEmpfaenger empfänger;

    /**
     * Legt die Oberflächenelemente an.
     *
     * @param fenster das übergeordnete Fenster
     */
    KnotenDialog(JFrame fenster)
    {
        super(fenster, "Knotendaten editieren", ModalityType.APPLICATION_MODAL);
        empfänger = null;
        setLayout(null);
        setSize(300, 190);
        setVisible(false);
        setLocation(fenster.getX() + fenster.getWidth() / 2 - 150,
                fenster.getY());
        JLabel l = new JLabel();
        l.setSize(180, 20);
        l.setLocation(10, 10);
        l.setVisible(true);
        l.setText("x-Koordinate:");
        add(l);
        l = new JLabel();
        l.setSize(180, 20);
        l.setLocation(10, 50);
        l.setVisible(true);
        l.setText("y-Koordinate:");
        add(l);
        l = new JLabel();
        l.setSize(180, 20);
        l.setLocation(10, 90);
        l.setVisible(true);
        l.setText("Beschriftung:");
        add(l);
        xKoordinate = new JTextField();
        xKoordinate.setSize(80, 30);
        xKoordinate.setLocation(200, 5);
        xKoordinate.setVisible(true);
        xKoordinate.setText("");
        add(xKoordinate);
        yKoordinate = new JTextField();
        yKoordinate.setSize(80, 30);
        yKoordinate.setLocation(200, 45);
        yKoordinate.setVisible(true);
        yKoordinate.setText("");
        add(yKoordinate);
        beschriftung = new JTextField();
        beschriftung.setSize(80, 30);
        beschriftung.setLocation(200, 85);
        beschriftung.setVisible(true);
        beschriftung.setText("");
        add(beschriftung);
        JButton b = new JButton("Abbrechen");
        b.setSize(130, 30);
        b.setLocation(10, 130);
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
        b.setLocation(160, 130);
        b.setVisible(true);
        b.setDefaultCapable(true);
        getRootPane().setDefaultButton(b);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int x;
                int y;
                try
                {
                    x = Integer.parseInt(xKoordinate.getText());
                    y = Integer.parseInt(yKoordinate.getText());
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,
                            "Fehler beim Konvertieren der Koordinaten",
                            "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (empfänger.BezeichnerPrüfen(beschriftung.getText()))
                {
                    empfänger.KnotenEditieren(x, y, beschriftung.getText());
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Knotenbezeichner doppelt vergeben",
                            "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(b);
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
        xKoordinate.setText(daten[0]);
        yKoordinate.setText(daten[1]);
        beschriftung.setText(daten[2]);
        beschriftung.requestFocusInWindow();
        setVisible(true);
    }
}
