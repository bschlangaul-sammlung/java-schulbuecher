package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.sortieren;

/**
 * Die Bedienoberfläche für den Laufzeittest.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OBERFLAECHE implements OBERFLAECHENINTERFACE
{
    private JFrame fenster;

    private JTextField datenAnzahl;

    private JLabel sortierzeitAuswahl;

    private JLabel sortierzeitMischen;

    private JCheckBox auswahlSortieren;

    private JCheckBox mischSortieren;

    private JButton testen;

    private JButton beenden;

    private KONTROLLEURINTERFACE kontrolleur;

    /**
     * Legt die Oberflächenelemente an und setzt den Kontrolleur.
     *
     * @param kontrolleur der verwaltende Kontrolleur
     */
    OBERFLAECHE(KONTROLLEURINTERFACE kontrolleur)
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
                "Zeit f\u00FCr Sortieren durch Ausw\u00E4hlen [Nanosekunden]");
        p.add(l);
        sortierzeitAuswahl = new JLabel("---");
        p.add(sortierzeitAuswahl);
        l = new JLabel("Zeit f\u00FCr Sortieren durch Mischen [Nanosekunden]");
        p.add(l);
        sortierzeitMischen = new JLabel("---");
        p.add(sortierzeitMischen);
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
     * Trägt die Suchzeit für Sortieren durch Auswählen ein.
     *
     * @param zeit benötigte Sortierzeit
     */
    public void AuswahlSortierzeitSetzen(String zeit)
    {
        sortierzeitAuswahl.setText(zeit);
    }

    /**
     * Trägt die Suchzeit für Sortieren durch Mischen ein.
     *
     * @param zeit benötigte Sortierzeit
     */
    public void MischSortierzeitSetzen(String zeit)
    {
        sortierzeitMischen.setText(zeit);
    }
}
