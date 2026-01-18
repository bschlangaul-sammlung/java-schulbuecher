package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_01.aufgabe_05.snake_l1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Der Rand um das Spielfeld. Das Fenster wird bei Bedarf generiert.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
class RandSymbol
{
    /**
     * Das Anzeigefenster.
     */
    private JFrame fenster;

    /**
     * Anzeigegröße für das Rumpfelement
     */
    private static final int größe = Oberflaeche.RasterGrößeGeben();

    /**
     * Interna
     */
    private JComponent anzeige;

    private int xMin, xMax, yMin, yMax;

    private boolean wertGesetzt;

    private int punkte;

    private boolean endemeldungGesetzt;

    private String endeMeldung;

    private boolean sonderanzeigeGesetzt;

    private String sonderAnzeige;

    /**
     * Standardkonstruktor für Objekte der Klasse RandSymbol. Er erzeugt einen
     * grauen Rand um das Spielfeld. Es wird die maximale Spielfeldgröße
     * ermittelt Das Fenster wird bei Bedarf angelegt.
     */
    RandSymbol()
    {
        this(Oberflaeche.FensterBreiteGeben() / größe - 2,
                Oberflaeche.FensterHöheGeben() / größe - 2);
    }

    /**
     * Standardkonstruktor für Objekte der Klasse RandSymbol. Er erzeugt einen
     * grauen Rand um das Spielfeld. Das Fenster wird bei Bedarf angelegt.
     *
     * @param breite gewünschte Breite des Spielfelds
     * @param hoehe gewünschte Höhe des Spielfelds
     */
    RandSymbol(int breite, int hoehe)
    {
        wertGesetzt = false;
        punkte = 0;
        endemeldungGesetzt = false;
        endeMeldung = "";
        sonderanzeigeGesetzt = false;
        sonderAnzeige = "";
        fenster = Oberflaeche.FensterGeben();
        anzeige = new JComponent()
        {
            // Stellt das Rumpfelement auf dem Fenster dar.
            public void paintComponent(Graphics g)
            {
                g.setColor(Color.lightGray);
                int[] xKoord = { 0, getWidth(), getWidth(), 0, 0, größe, größe,
                        getWidth() - größe, getWidth() - größe, größe, 0 };
                int[] yKoord = { 0, 0, getHeight(), getHeight(), 0, größe,
                        getHeight() - größe, getHeight() - größe, größe, größe,
                        0 };
                g.fillPolygon(xKoord, yKoord, xKoord.length);
                if (wertGesetzt)
                {
                    Font font = new Font("Helvetica", Font.BOLD, 14);
                    g.setFont(font);
                    g.setColor(Color.blue);
                    g.drawString("Punkte: " + punkte, 4, 3 * größe / 4);
                }
                if (endemeldungGesetzt)
                {
                    Font font = new Font("Helvetica", Font.BOLD, 24);
                    g.setFont(font);
                    g.setColor(Color.red);
                    g.drawString(endeMeldung, größe * 2, getHeight() / 4);
                }
            }
        };
        anzeige.setVisible(true);
        fenster.add(anzeige, 0);
        GrößeSetzen(breite, hoehe);
    }

    /**
     * Setzt die Breite und Höhe des Randelements. Die Maximalkoordinaten des
     * Spielfelds werden ermittelt.
     *
     * @param breite Spielfeldbreite in Kästchen
     * @param hoehe Spielfeldhöhe in Kästchen
     */
    void GrößeSetzen(int breite, int hoehe)
    {
        xMax = breite / 2 - 1;
        yMax = hoehe / 2 - 1;
        if (breite % 2 == 0)
        {
            xMin = -xMax - 1;
        }
        else
        {
            xMin = -xMax - 2;
        }
        if (hoehe % 2 == 0)
        {
            yMin = -yMax - 1;
        }
        else
        {
            yMin = -yMax - 2;
        }
        anzeige.setSize((breite + 2) * größe, (hoehe + 2) * größe);
        anzeige.setLocation(
                Oberflaeche.FensterBreiteGeben() / 2
                        - (breite / 2 + 1 + breite % 2) * größe,
                Oberflaeche.FensterHöheGeben() / 2
                        - (hoehe / 2 + 1 + hoehe % 2) * größe);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    void Entfernen()
    {
        (Oberflaeche.FensterGeben()).remove(anzeige);
        (Oberflaeche.FensterGeben()).repaint();
    }

    /**
     * Meldet die maximale x-Koordinate des Spielfelds.
     *
     * @return maximale x-Koordinate
     */
    int XMaxGeben()
    {
        return xMax;
    }

    /**
     * Meldet die minimale x-Koordinate des Spielfelds.
     *
     * @return minimale x-Koordinate
     */
    int XMinGeben()
    {
        return xMin;
    }

    /**
     * Meldet die maximale y-Koordinate des Spielfelds.
     *
     * @return maximale y-Koordinate
     */
    int YMaxGeben()
    {
        return yMax;
    }

    /**
     * Meldet die minimale y-Koordinate des Spielfelds.
     *
     * @return minimale y-Koordinate
     */
    int YMinGeben()
    {
        return yMin;
    }

    /**
     * Setzt den Punktestand für die Anzeige
     *
     * @param punkte der anzuzeigende Punktestand
     */
    void PunkteSetzen(int punkte)
    {
        this.punkte = punkte;
        wertGesetzt = true;
        anzeige.invalidate();
    }

    /**
     * Setzt die Endemeldung für die Anzeige
     *
     * @param meldung die anzuzeigende Endemeldung
     */
    void EndemeldungSetzen(String meldung)
    {
        endeMeldung = meldung;
        endemeldungGesetzt = true;
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Setzt die Endemeldung für die Anzeige
     *
     * @param meldung die anzuzeigende Endemeldung
     */
    void SonderanzeigeSetzen(String meldung)
    {
        sonderAnzeige = meldung;
        sonderanzeigeGesetzt = !"".equals(meldung);
        anzeige.invalidate();
    }
}
