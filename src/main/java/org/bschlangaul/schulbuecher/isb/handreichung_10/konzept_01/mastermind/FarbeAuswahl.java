package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.mastermind;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Die Klasse FARBAUSWAHL dient zur Auswahl einer vordefinierten Farbe aus dem
 * Farbraum der Klasse Zeichenfenster.
 *
 * @author Heidrich
 *
 * @version 9.9.07
 */
public class FarbeAuswahl extends JPanel
{
    private int anzahl;

    private ButtonGroup gruppe;

    private JRadioButton[] schalter;

    private String[] farben;

    /**
     * Konstruktor für Objekte der Klasse FARBAUSWAHL
     */
    public FarbeAuswahl(int anzahl0)
    {
        if ((anzahl0 <= 8) && (anzahl0 > 0))
            anzahl = anzahl0;
        else
            anzahl = 8;
        gruppe = new ButtonGroup();
        schalter = new JRadioButton[anzahl];
        farben = new String[8];
        setLayout(new GridLayout(anzahl, 1));
        farben[0] = "blau";
        farben[1] = "grün";
        farben[2] = "cyan";
        farben[3] = "rot";
        farben[4] = "magenta";
        farben[5] = "gelb";
        farben[6] = "grau";
        farben[7] = "weiß";
        for (int i = 0; i < anzahl; i++)
        {
            schalter[i] = new JRadioButton(farben[i]);
            gruppe.add(schalter[i]);
            add(schalter[i]);
        }
        schalter[0].setSelected(true);
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Die Methode gibFarbnummer bestimmt die Nummer der ausgewählten Farbe
     *
     * @return Nummer der ausgewählten Farbe
     */
    public int gibFarbnummer()
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (schalter[i].isSelected())
            {
                return i + 1;
            }
        }
        return 0;
    }
}
