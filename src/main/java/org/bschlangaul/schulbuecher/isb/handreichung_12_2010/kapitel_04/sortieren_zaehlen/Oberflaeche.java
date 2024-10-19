package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.sortieren_zaehlen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Die Bedienoberfläche für den Laufzeittest.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Oberflaeche implements OberflaechenInterface
{
    private JFrame fenster;

    private JTextField datenAnzahl;

    private JLabel sortieranzahlAuswahl;

    private JLabel sortieranzahlMischen;

    private JCheckBox auswahlSortieren;

    private JCheckBox mischSortieren;

    private JButton testen;

    private JButton beenden;

    private KontrolleurInterface kontrolleur;

    /**
     * Legt die Oberflächenelemente an und setzt den Kontrolleur.
     *
     * @param kontrolleur der verwaltende Kontrolleur
     */
    Oberflaeche(KontrolleurInterface kontrolleur)
    {
        this.kontrolleur = kontrolleur;
        FensterAufbauen();
    }

    /**
     * Führt den Aufbau der Oberflächenelemente durch.
     */
    private void FensterAufbauen()
    {
        JPanel content;
        JPanel p;
        JLabel l;
        fenster = new JFrame("Suchmethoden testen");
        content = (JPanel) fenster.getContentPane();
        content.setLayout(new BorderLayout());
        p = new JPanel();
        content.add(p, BorderLayout.NORTH);
        p.setLayout(new GridLayout(4, 2));
        l = new JLabel("Anzahl der zu sortierenden Datenelemente");
        p.add(l);
        datenAnzahl = new JTextField();
        p.add(datenAnzahl);
        l = new JLabel(" ");
        p.add(l);
        l = new JLabel(" ");
        p.add(l);
        l = new JLabel(
                "Vergleichsanzahl f\u00FCr Sortieren durch Ausw\u00E4hlen");
        p.add(l);
        sortieranzahlAuswahl = new JLabel("---");
        p.add(sortieranzahlAuswahl);
        l = new JLabel("Vergleichsanzahl f\u00FCr Sortieren durch Mischen");
        p.add(l);
        sortieranzahlMischen = new JLabel("---");
        p.add(sortieranzahlMischen);
        p = new JPanel();
        content.add(p, BorderLayout.SOUTH);
        p.setLayout(new FlowLayout());
        auswahlSortieren = new JCheckBox(
                "Sortieren durch Ausw\u00E4hlen testen", true);
        p.add(auswahlSortieren);
        mischSortieren = new JCheckBox("Sortieren durch Mischen testen", true);
        p.add(mischSortieren);
        testen = new JButton("Test ausf\u00FChren");
        p.add(testen);
        testen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (auswahlSortieren.isSelected()
                        || mischSortieren.isSelected())
                {
                    try
                    {
                        kontrolleur.SortierenAusfuehren(
                                Integer.parseInt(datenAnzahl.getText()),
                                auswahlSortieren.isSelected(),
                                mischSortieren.isSelected());
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(fenster,
                                "Bitte korrekte Zahlenwerte angeben.",
                                "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(fenster,
                            "'Sortieren durch Ausw\u00E4hlen' oder 'Sortieren durch Mischen' muss aktiviert sein.",
                            "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        beenden = new JButton("Beenden");
        p.add(beenden);
        beenden.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                kontrolleur.BeendenAusfuehren();
            }
        });
        fenster.setSize(new Dimension(800, 200));
        fenster.setMinimumSize(new Dimension(300, 200));
        fenster.setPreferredSize(new Dimension(800, 200));
        fenster.setVisible(true);
    }

    /**
     * Trägt die Vergleichsanzahl für Sortieren durch Auswählen ein.
     */
    public void AuswahlSortieranzahlSetzen(String anzahl)
    {
        sortieranzahlAuswahl.setText(anzahl);
    }

    /**
     * Trägt die Vergleichsanzahl für Sortieren durch Mischen ein.
     */
    public void MischSortieranzahlSetzen(String anzahl)
    {
        sortieranzahlMischen.setText(anzahl);
    }
}
