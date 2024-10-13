package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_02.hanoi;

import java.awt.Canvas;
import java.awt.Color;
import java.util.Random;

/**
 * Klasse zur Verwaltung einer Scheibe
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class SCHEIBE implements DATENELEMENT
{
    /** Höhe einer Scheibe */
    private int hoehe;

    /** Breite einer Scheibe */
    private int breite;

    /** Leinwand zur Anzeige der Scheibe */
    private Canvas c;

    /** Zufallszahlgenerator für die Farbe der Scheibe */
    private Random zgenerator;

    /**
     * Konstruktor Legt die Maße und Farbe der Scheibe fest und sorgt für die
     * Anzeige
     *
     * @param breiteNeu Breite der Scheibe
     */
    SCHEIBE(int breiteNeu)
    {
        hoehe = 10;
        breite = breiteNeu;
        zgenerator = new Random();
        c = new Canvas();
        c.setBackground(new Color(zgenerator.nextInt(3) * 127,
                zgenerator.nextInt(3) * 127, zgenerator.nextInt(3) * 127));
        (FENSTER.PanelGeben()).add(c, 0);
    }

    /**
     * Setzt die Position der Scheibe auf den übergebenen Wert.
     *
     * @param x x-Position der Scheibenmitte
     * @param y y-Position der Scheibe
     *
     */
    void PositionSetzen(int x, int y)
    {
        c.setBounds(x - breite / 2, y, breite, hoehe);
    }

    /**
     * Ausgabe von Information über ein Ausgabefenster ohne Funktion
     */
    public void InformationAusgeben()
    {
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation ohne
     * Funktion
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DATENELEMENT dvergleich)
    {
        return true;
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels ohne
     * Funktion
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return true;
    }

    /**
     * Entfernt die Scheibe aus der Anzeige
     */
    void Entfernen()
    {
        (FENSTER.PanelGeben()).remove(c);
    }
}
