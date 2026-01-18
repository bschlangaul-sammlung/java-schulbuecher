package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Ein Kundensymbol (Kreis) auf einem Fenster. Das Fenster wird bei Bedarf
 * generiert.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class KundenSymbol
{
    /**
     * Das Anzeigefenster.
     */
    private Canvas anzeige;

    /**
     * Anzeigegröße für den Kreis
     */
    private int groesse = 20;

    /**
     * Interna
     */
    private Oberflaeche.Farbe aktFarbe;

    /**
     * Standardkonstruktor für Objekte der Klasse KUNDENSYMBOL. Er erzeugt einen
     * scharzen Kreis in der linken oberen Ecke des Fensters. Das Fenster wird
     * bei Bedarf angelegt.
     */
    KundenSymbol()
    {
        anzeige = new Canvas()
        {
            /**
             * Stellt die Figur auf dem Fenster dar.
             */
            public void paint(Graphics g)
            {
                g.setColor(aktFarbe.AWTFarbe());
                g.fillOval(0, 0, groesse - 1, groesse - 1);
                g.setColor(Color.black);
                g.drawOval(0, 0, groesse - 1, groesse - 1);
            }
        };
        aktFarbe = Oberflaeche.Farbe.schwarz;
        anzeige.setVisible(true);
        anzeige.setSize(groesse, groesse);
        anzeige.setLocation(0, 20);
        (Oberflaeche.FensterGeben()).add(anzeige, 0);
    }

    /**
     * Zeichnet die Figur.
     */
    private void Zeichnen()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Setzt die Farbe der Figur.
     *
     * @param neueFarbe die neue Farbe der Figur
     */
    void FarbeSetzen(String neueFarbe)
    {
        if ("zufall".equals(neueFarbe))
        {
            aktFarbe = Oberflaeche.Farbe.ZufallsFarbeErzeugen();
        }
        else
        {
            try
            {
                aktFarbe = Oberflaeche.Farbe
                        .valueOf(aktFarbe.getDeclaringClass(), neueFarbe);
            }
            catch (Exception e)
            {
                aktFarbe = Oberflaeche.Farbe.weiss;
            }
        }
        Zeichnen();
    }

    /**
     * Setzt die Position der Figur.
     *
     * @param kassennummer Nummer der Kasse
     * @param kundennummer Kundennummer Warteposition (-1 für an Kasse stehend)
     */
    void PositionSetzen(int kassennummer, int kundennummer)
    {
        int x = 400 - groesse - kundennummer * 50;
        int y = 100 * kassennummer + 25 - groesse / 2;
        anzeige.setLocation(x, y);
    }

    /**
     * Setzt die Größe der Figur.
     *
     * @param artikelzahl neue Artikelzahl
     */
    void GroesseSetzen(int artikelzahl)
    {
        groesse = 2 * artikelzahl + 2;
        anzeige.setSize(groesse, groesse);
    }

    /**
     * Entfernt die Figur aus der Anzeige
     */
    public void Entfernen()
    {
        (Oberflaeche.FensterGeben()).remove(anzeige);
    }
}
