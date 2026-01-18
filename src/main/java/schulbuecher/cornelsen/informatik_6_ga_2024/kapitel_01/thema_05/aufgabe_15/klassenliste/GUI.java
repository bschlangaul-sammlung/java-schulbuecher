package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_15.klassenliste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Klasse zur Verwaltung der GUI
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class GUI extends JFrame
{
    private JTextField vornameField, nachnameField;

    private JButton hinzufuegenButton, entfernenButton;

    private JTextArea namenTextArea;

    private Klassenliste klassenliste;

    public GUI()
    {
        // GUI initialisieren
        setTitle("Namen Verwaltung");
        setSize(900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Komponenten initialisieren
        JLabel vornameLabel = new JLabel("Vorname:");
        vornameField = new JTextField(20);
        JLabel nachnameLabel = new JLabel("Nachname:");
        nachnameField = new JTextField(20);
        hinzufuegenButton = new JButton("Hinzufügen");
        entfernenButton = new JButton("Entfernen");
        namenTextArea = new JTextArea(10, 30);
        klassenliste = new Klassenliste();

        // Layout einstellen
        JPanel panel = new JPanel();
        panel.add(vornameLabel);
        panel.add(vornameField);
        panel.add(nachnameLabel);
        panel.add(nachnameField);
        panel.add(hinzufuegenButton);
        panel.add(entfernenButton);
        panel.add(new JScrollPane(namenTextArea));
        add(panel);

        // Event Listener hinzufÃ¼gen
        hinzufuegenButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String vorname = vornameField.getText();
                String nachname = nachnameField.getText();
                klassenliste.Einfügen(nachname, vorname);
                updateTextArea();
            }
        });

        entfernenButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String vorname = vornameField.getText();
                String nachname = nachnameField.getText();
                klassenliste.Entfernen(nachname, vorname);
                updateTextArea();
            }

        });
        setVisible(true);
    }

    private void updateTextArea()
    {
        namenTextArea.setText(klassenliste.NamenslisteGeben());

    }

}
