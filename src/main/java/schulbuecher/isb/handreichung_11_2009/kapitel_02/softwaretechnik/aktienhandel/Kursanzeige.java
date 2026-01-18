package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Fenster zur Anzeige eines Aktienkurses.
 *
 * @version 1.0
 */
class Kursanzeige
{
    /**
     * Anzahl der angezeigten Kurse
     */
    static final int kursAnzahl = 20;

    private JFrame fenster;

    private AnzeigeKomponente anzeige;

    /**
     * Baut das Anzeigefenster auf
     */
    Kursanzeige()
    {
        fenster = new JFrame("Kursverlauf");
        fenster.setSize(600, 400);
        fenster.setVisible(false);
        fenster.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                fenster.setVisible(false);
            }
        });
        anzeige = new AnzeigeKomponente();
        fenster.getContentPane().add(anzeige, BorderLayout.CENTER);
    }

    /**
     * Macht das Anzeigefenster sichtbar
     *
     * @param kurse die Kursdaten für die Anzeige.
     * @param name Name der Aktie
     */
    void Anzeigen(double[] kurse, String name)
    {
        anzeige.AnzeigeSetzen(kurse, name);
        fenster.setVisible(true);
    }
}
