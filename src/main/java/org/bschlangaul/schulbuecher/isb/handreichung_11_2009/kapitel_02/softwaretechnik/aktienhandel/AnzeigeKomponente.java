package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class AnzeigeKomponente extends JComponent
{
    private double[] kurse;

    private String aktienname;

    /**
     * Die Arbeit wird weiter oben erledigt.
     */
    AnzeigeKomponente()
    {
        super();
        kurse = null;
    }

    /**
     * Setzt die Anzeigedaten
     *
     * @param kurse die neuen Kurswerte
     * @param name Name der Aktie
     */
    void AnzeigeSetzen(double[] kurse, String name)
    {
        this.kurse = kurse;
        aktienname = name;
    }

    /**
     * Zeichenmethode für die Komponente
     *
     * @param g das Grafikobjekt für die Zeichenoperationen
     */
    protected void paintComponent(Graphics g)
    {
        // Farbe der Diagrammfläche vorbelegen
        Color flaeche = new Color(200, 200, 255);
        // Koordinaten im Fenster
        int xNeu = 0;
        int yNeu = 0;
        int xAlt = 0;
        int yAlt = 0;
        double kursMin = 10000; // minimaler Kurswert
        double kursMax = 0; // maximaler Kurswert
        double kursAkt = 10; // letzter (aktueller) Kurswert
        double deltaKurs = 0;
        int xCal = (int) 200 / Kursanzeige.kursAnzahl;
        for (int i = 0; i < kurse.length; i++)
        {
            if (kurse[i] < kursMin)
            {
                kursMin = kurse[i];
            }
            if (kurse[i] > kursMax)
            {
                kursMax = kurse[i];
            }
        }
        // Falls Extremwerte identisch, dann wähle +/- 5%
        if (kursMin == kursMax)
        {
            kursMin = 0.95 * kursMin;
            kursMax = 1.05 * kursMax;
        }
        deltaKurs = kursMax - kursMin;
        kursMax = (int) (kursMax * 100 + 0.5) / 100.0;
        kursMin = (int) (kursMin * 100 + 0.5) / 100.0;
        kursAkt = (int) (kurse[kurse.length - 1] * 100 + 0.5) / 100.0;
        // Zeichne Achsenkreuz auf farbigem Hintergrund
        setBackground(flaeche);
        g.drawLine(60, 185, 60, 25);
        g.drawLine(55, 180, 260, 180);
        for (int i = 0; i < kurse.length; i++)
        {
            g.drawLine(60 + xCal * i, 183, 60 + xCal * i, 180);
        }
        g.drawLine(55, 30, 60, 30);
        g.drawString("" + kursMin, 10, 185);
        g.drawString("" + kursMax, 10, 35);
        g.drawString("heute", 240, 195);
        // Diagrammüberschrift
        g.drawString(aktienname, 80, 40);
        g.setColor(Color.blue);
        // Linie für Kursverlauf Ziehen
        for (int i = 0; i < kurse.length; i++)
        {
            // Skalieren und Runden auf Integer
            int y = (int) (150 / deltaKurs * (kurse[i] - kursMin));
            yNeu = 180 - y;
            xNeu = 70 + xCal * i;
            g.setColor(Color.blue);
            g.drawOval(xNeu - 2, yNeu - 2, 4, 4);
            g.setColor(Color.red);
            if (i != 0)
            {
                g.drawLine(xAlt, yAlt, xNeu, yNeu);
            }
            // Merken der letzten Koordinaten
            yAlt = yNeu;
            xAlt = xNeu;
        }
        // Aktuellen Kurs markieren
        g.setColor(Color.blue);
        g.drawString("" + kursAkt, 260, yNeu + 5);
        g.drawLine(60, yNeu, 255, yNeu);
    }
}
