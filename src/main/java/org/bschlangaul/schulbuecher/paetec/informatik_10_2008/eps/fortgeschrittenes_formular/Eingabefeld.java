package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Diese Klasse implementiert ein simples Eingabefeld, das Benutzereingaben
 * entgegennehmen kann.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class Eingabefeld extends Formulargrafik
{
    private final int maximaleEingabelaenge = 100;

    private final int feldhoehe = 22;

    private JLabel beschriftungslabel;

    private JTextField feld;

    private boolean istGesperrt;

    public Eingabefeld()
    {
        initialisieren("Eingabefeld:", "Vorgabetext");
    }

    public Eingabefeld(Formular formular)
    {
        super(formular);
        initialisieren("Eingabefeld:", "Vorgabetext");
    }

    public Eingabefeld(String beschriftung, String vorgabetext)
    {
        if (beschriftung == null)
            beschriftung = "Eingabefeld:";
        if (vorgabetext == null)
            vorgabetext = "Vorgabetext";
        initialisieren(beschriftung, vorgabetext);
    }

    public Eingabefeld(String beschriftung, String vorgabetext,
            Formular formular)
    {
        super(formular);
        if (beschriftung == null)
            beschriftung = "Eingabefeld:";
        if (vorgabetext == null)
            vorgabetext = "Vorgabetext";
        initialisieren(beschriftung, vorgabetext);
    }

    private void initialisieren(String beschriftung, String vorgabetext)
    {
        Component awtKomponente = new JPanel();
        ((JPanel) awtKomponente).setLayout(null);
        ((JPanel) awtKomponente).setBounds(0, 0, formularGeben().breiteGeben(),
                feldhoehe);// 0, 0
        ((JPanel) awtKomponente).setBackground(Color.white);
        feld = new JTextField(vorgabetext, maximaleEingabelaenge);
        if (istGesperrt)
        {
            feld.setEditable(false);
        }
        feld.setBounds(formularGeben().breiteGeben() / 2, 0,
                formularGeben().breiteGeben() / 2 - 10, feldhoehe);
        beschriftungslabel = new JLabel(beschriftung);
        beschriftungslabel.setBounds(6, 0,
                formularGeben().breiteGeben() / 2 - 10, feldhoehe);// 0,
                                                                   // 0
        ((JPanel) awtKomponente).add(beschriftungslabel);
        ((JPanel) awtKomponente).add(feld);
        awtKomponenteSetzen(awtKomponente);
    }

    /**
     * Liefert die Beschriftung des Feldes.
     *
     * @return die Beschriftung
     */
    public String beschriftungGeben()
    {
        return beschriftungslabel.getText();
    }

    /**
     * Liefert den Inhalt des Feldes.
     *
     * @return der Inhalt
     */
    public String inhaltGeben()
    {
        return feld.getText();
    }

    /**
     * Liefert den Inhalt des Feldes als Integer, falls moeglich. null sonst.
     *
     * @return der Inhalt
     */
    public Integer ganzeZahlGeben()
    {
        try
        {
            Integer i = Integer.parseInt(feld.getText());
            return i;
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    /**
     * Liefert den Inhalt des Feldes als Double, falls m�glich. null sonst.
     *
     * @return der Inhalt
     */
    public Double kommaZahlGeben()
    {
        try
        {
            Double d = Double.parseDouble(feld.getText());
            return d;
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    /**
     * Aendert die Beschriftung des Feldes.
     *
     * @param beschriftung die neue Beschriftung
     */
    public void beschriftungSetzen(String beschriftung)
    {
        beschriftungslabel.setText(beschriftung);
    }

    /**
     * Aendert den Inhalt des Feldes.
     *
     * @param inhalt der neue Inhalt
     */
    public void inhaltSetzen(String inhalt)
    {
        feld.setText(inhalt);
    }

    public void sperren(boolean gesperrt)
    {
        feld.setEditable(!gesperrt);
        istGesperrt = gesperrt;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void formatieren()
    {
        initialisieren(beschriftungslabel.getText(), feld.getText());
    }
}
