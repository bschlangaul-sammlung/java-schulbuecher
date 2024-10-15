package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Klasse zur grafischen Ausgabe der Landkarte mit Orten und kürzestem Weg
 *
 * @version 1.0
 */
class KARTE extends JComponent implements STATUSBEOBACHTER
{
    private Color hintergrundfarbe, vordergrundfarbe, startfarbe, zielfarbe,
            streckenfarbe;

    private ORT[] orte;

    private STRECKE[] strecken;

    private LISTE weg;

    String start, ziel;

    private static final int radius = 5; // Radius des Ortssymbols

    /**
     * Besetzt die Farben für die Darstellung. Erstellt die Felder mit Orten und
     * Strecken.
     *
     * @param o Ortsliste
     * @param s Streckenliste
     */
    KARTE(LISTE o, LISTE s)
    {
        DATENELEMENT[] daten;
        hintergrundfarbe = Color.WHITE;
        vordergrundfarbe = Color.GRAY;
        startfarbe = Color.GREEN;
        zielfarbe = Color.RED;
        streckenfarbe = Color.BLACK;
        daten = o.DatenelementeAlsFeldGeben();
        orte = new ORT[daten.length];
        for (int i = 0; i < daten.length; i++)
        {
            orte[i] = (ORT) daten[i];
        }
        daten = s.DatenelementeAlsFeldGeben();
        strecken = new STRECKE[daten.length];
        for (int i = 0; i < daten.length; i++)
        {
            strecken[i] = (STRECKE) daten[i];
        }
        weg = null;
    }

    /**
     * Empfängt Statusmeldungen
     *
     * @param text Text der Statusmeldungen
     */
    public void StatusSetzen(String text)
    {
        // nix
    }

    /**
     * Empfängt die Vorgängerinformation, Start und Ziel
     *
     * @param vorgaenger Liste mit der Vorgängerinformation
     * @param start Name des Startortes
     * @param ziel Name des Zielortes
     */
    public void WegSetzen(LISTE vorgaenger, String start, String ziel)
    {
        weg = vorgaenger;
        this.start = start;
        this.ziel = ziel;
        invalidate();
        repaint();
    }

    /**
     * Orte als Kreisscheiben und Ortsnamen als Text werden gezeichnet. Falls
     * ein Weg existiert, werden die entsprechenden Strecken gezeichnet.
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(hintergrundfarbe);
        g.fillRect(0, 0, this.getBounds().width, this.getBounds().height);
        // Zeichnet alle Strecken
        g.setColor(vordergrundfarbe);
        for (STRECKE s : strecken)
        {
            g.drawLine(s.StartortGeben().XPosGeben(),
                    s.StartortGeben().YPosGeben(), s.ZielortGeben().XPosGeben(),
                    s.ZielortGeben().YPosGeben());
        }
        // Zeichnet alle Orte und beschrifte sie mit den Ortsnamen
        for (ORT o : orte)
        {
            g.fillOval(o.XPosGeben() - radius, o.YPosGeben() - radius,
                    2 * radius, 2 * radius);
            g.drawString(o.NameGeben(), o.XPosGeben() - radius,
                    o.YPosGeben() - 2 * radius);
        }
        // Falls ein Weg berechnet wurde
        if (weg != null)
        {
            VORGAENGERINFO akt;
            akt = (VORGAENGERINFO) weg.Suchen(ziel);
            // markiere die zu durchfahrenden Orte und zeichne die zu fahrenden
            // Strecken in der
            // streckenfarbe
            g.setColor(streckenfarbe);
            while (true)
            {
                g.fillOval(akt.OrtGeben().XPosGeben() - radius,
                        akt.OrtGeben().YPosGeben() - radius, 2 * radius,
                        2 * radius);
                if (akt.VorgaengerGeben() == null)
                {
                    break;
                }
                g.drawLine(akt.OrtGeben().XPosGeben(),
                        akt.OrtGeben().YPosGeben(),
                        akt.VorgaengerGeben().XPosGeben(),
                        akt.VorgaengerGeben().YPosGeben());
                akt = (VORGAENGERINFO) weg
                        .Suchen(akt.VorgaengerGeben().NameGeben());
            }
            for (ORT o : orte)
            {
                if (start.equals(o.NameGeben()))
                {
                    // markiere den Startort in der Startfarbe
                    g.setColor(startfarbe);
                    g.fillOval(o.XPosGeben() - radius, o.YPosGeben() - radius,
                            2 * radius, 2 * radius);
                }
                if (ziel.equals(o.NameGeben()))
                {
                    // markiere den Zielort in der Zielfarbe
                    g.setColor(zielfarbe);
                    g.fillOval(o.XPosGeben() - radius, o.YPosGeben() - radius,
                            2 * radius, 2 * radius);
                }
            }
        }
    }
}
