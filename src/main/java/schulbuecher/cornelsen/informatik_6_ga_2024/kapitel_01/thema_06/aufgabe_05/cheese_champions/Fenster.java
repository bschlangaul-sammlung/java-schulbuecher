package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_05.cheese_champions;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Klasse zur Erzeugung von Fenster und Spiel
 *
 * @author Klaus Reinold
 */
class Fenster extends Frame
{
    // Anfang Attribute
    private Label titel = new Label();

    private Label beschreibung = new Label();

    private TextField mausnummer = new TextField();

    private Button buttonMausAufnehmen = new Button();

    private TextArea textfeldUrsprung = new TextArea("", 1, 1,
            TextArea.SCROLLBARS_NONE);

    private Label labelUrsprung = new Label();

    private TextArea textfeldSackgasse = new TextArea("", 1, 1,
            TextArea.SCROLLBARS_NONE);

    private Label labelSackgasse = new Label();

    private TextArea texfeldZiel = new TextArea("", 1, 1,
            TextArea.SCROLLBARS_NONE);

    private Label labelZiel = new Label();

    private Button buttonMausBewegen = new Button();

    private Label labelUnzulässigeReihenfolge = new Label();

    private Label labelInfo = new Label();

    private Spiel spiel;

    /**
     * Erzeugt ein Spiel in einem Fenster und die zur Anzeige erforderlichen
     * Komponenten
     */
    Fenster()
    {
        // Frame-Initialisierung
        super("Cheese Champions");
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        int frameWidth = 435;
        int frameHeight = 511;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Panel cp = new Panel(null);
        add(cp);
        spiel = new Spiel();
        // Anfang Komponenten

        titel.setBounds(88, 8, 212, 29);
        titel.setText("Cheese Champions");
        titel.setFont(new Font("MS Sans Serif", Font.PLAIN, 21));
        cp.add(titel);
        beschreibung.setBounds(16, 48, 350, 16);
        beschreibung.setText(
                "Geben Sie die Reihenfolge der Ankunft beim Käse ein:");
        beschreibung.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(beschreibung);
        mausnummer.setBounds(16, 80, 145, 24);
        mausnummer.setText("Nummer der Maus");
        cp.add(mausnummer);
        buttonMausAufnehmen.setBounds(192, 80, 140, 25);
        buttonMausAufnehmen.setLabel("Maus aufnehmen");
        buttonMausAufnehmen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                spiel.Einfügen(
                        new Maus(Integer.parseInt(mausnummer.getText())));
                texfeldZiel.setText(spiel.StapelAusgeben('z'));
            }
        });
        cp.add(buttonMausAufnehmen);
        textfeldUrsprung.setBounds(16, 208, 121, 217);
        textfeldUrsprung.setText("");
        cp.add(textfeldUrsprung);
        labelUrsprung.setBounds(16, 184, 50, 16);
        labelUrsprung.setText("Eingang");
        labelUrsprung.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(labelUrsprung);
        textfeldSackgasse.setBounds(152, 208, 121, 217);
        textfeldSackgasse.setText("");
        cp.add(textfeldSackgasse);
        labelSackgasse.setBounds(152, 184, 55, 16);
        labelSackgasse.setText("Abzweig");
        labelSackgasse.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(labelSackgasse);
        texfeldZiel.setBounds(288, 208, 121, 217);
        texfeldZiel.setText("");
        cp.add(texfeldZiel);
        labelZiel.setBounds(288, 184, 35, 16);
        labelZiel.setText("Ziel");
        labelZiel.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(labelZiel);
        buttonMausBewegen.setBounds(16, 120, 145, 25);
        buttonMausBewegen.setLabel("Maus bewegen");
        buttonMausBewegen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                buttonMausAufnehmen.setVisible(false);
                mausnummer.setVisible(false);

                spiel.Schritt();
                texfeldZiel.setText(spiel.StapelAusgeben('z'));
                textfeldUrsprung.setText(spiel.StapelAusgeben('u'));
                textfeldSackgasse.setText(spiel.StapelAusgeben('s'));
                if (spiel.BeendetGeben())
                {
                    if (!spiel.IstUrsprungsstapelSortiert())
                    {
                        labelInfo.setText("Keine erlaubte Reihenfolge");
                    }
                    buttonMausBewegen.setVisible(false);
                }
            }

        });
        cp.add(buttonMausBewegen);
        labelUnzulässigeReihenfolge.setBounds(16, 448, 300, 16);
        labelUnzulässigeReihenfolge.setText("");
        labelUnzulässigeReihenfolge
                .setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(labelUnzulässigeReihenfolge);
        labelInfo.setBounds(16, 168, 360, 16);
        labelInfo.setText(
                "Ausgabe in der Form Mausnummer | gewonnen | verloren");
        labelInfo.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
        cp.add(labelInfo);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Fenster();
    }
}
