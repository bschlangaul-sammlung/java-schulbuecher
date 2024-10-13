package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.supermarkt.supermarkt_10;

/**
 * Erzeugt die Bedienelemente und verwaltet das Ausgabefenster.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;

class OBERFLAECHE
{
    /**
     * Vereinbart die für die Simulation nötigen Standardfarben.
     *
     * @author Albert Wiedemann
     *
     * @version 1.0
     */
    enum FARBE
    {
        weiss, schwarz, rot, gruen, blau, gelb, magenta, cyan, grau;

        /**
         * Konvertiert die angegebene FARBE in ihr AWT-Pendant.
         *
         * @return die entsprechende AWT-FARBE
         */
        public java.awt.Color AWTFarbe()
        {
            java.awt.Color farbe;
            switch (this)
            {
            case weiss:
                farbe = java.awt.Color.white;
                break;

            case schwarz:
                farbe = java.awt.Color.black;
                break;

            case rot:
                farbe = java.awt.Color.red;
                break;

            case gruen:
                farbe = java.awt.Color.green;
                break;

            case blau:
                farbe = java.awt.Color.blue;
                break;

            case gelb:
                farbe = java.awt.Color.yellow;
                break;

            case magenta:
                farbe = java.awt.Color.magenta;
                break;

            case cyan:
                farbe = java.awt.Color.cyan;
                break;

            case grau:
                farbe = java.awt.Color.gray;
                break;

            default:
                farbe = java.awt.Color.white;
            }
            return farbe;
        }

        private static java.util.Random ran = new java.util.Random();

        /**
         * Erzeugt eine zufällige FARBE
         *
         * @return die erzeugte FARBE
         */
        static FARBE ZufallsFarbeErzeugen()
        {
            FARBE[] alle = FARBE.values();
            return alle[ran.nextInt(alle.length)];
        }
    }

    private static OBERFLAECHE o = null;

    private Frame fenster = null;

    /**
     * Baut die Bedienoberfläche auf
     */
    private OBERFLAECHE()
    {
        int hoehe, breite;
        hoehe = 550;
        breite = 750;
        fenster = new Frame("Supermarkt");
        fenster.setResizable(false);
        fenster.setVisible(true);
        fenster.setLayout(null);
        fenster.setBackground(Color.white);
        fenster.setSize(breite, hoehe);
    }

    /**
     * Gibt das Ausgabefenster zurück und erzeugt es gegebenenfalls.
     *
     * @return Ausgabefenster
     */
    static Frame FensterGeben()
    {
        if (o == null)
        {
            o = new OBERFLAECHE();
        }
        return o.fenster;
    }
}
