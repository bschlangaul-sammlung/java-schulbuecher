package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_05.snake;

/**
 * Verwaltung der Darstellung
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class DARSTELLUNG
{
    /**
     * Fenster für die Darstellung
     */
    private FENSTER oberflaeche;

    /**
     * Leinwand zur Anzeige der Symbole.
     */
    private LEINWAND anzeige;

    /**
     * Größe eines Kästchens
     */
    private int kaestchengroesse;

    /**
     * Anzahl der Kästchen nach rechts
     */
    private int kaestchenzahl_nach_rechts;

    /**
     * Anzahl der Kästchen nach unten
     */
    private int kaestchenzahl_nach_unten;

    /**
     * Objekt zur logischen Verwaltung des Spiels
     */
    private SPIEL spiel;

    /**
     * Konstruktor für Objekte der Klasse DARSTELLUNG. Legt zunächst
     * kaestchengroesse fest und speichert die Kästchenzahl. <br>
     * Danach wird oberflaeche (Fenster) und Leinwand erzeugt.
     *
     * @param sp logische Verwaltung des Spiels
     * @param kaestchen_rechts Kästchenzahl nach rechts.
     * @param kaestchen_unten Kästchenzahl nach unten.
     */
    DARSTELLUNG(SPIEL sp, int kaestchen_rechts, int kaestchen_unten)
    {
        spiel = sp;
        kaestchengroesse = 10;
        kaestchenzahl_nach_rechts = kaestchen_rechts;
        kaestchenzahl_nach_unten = kaestchen_unten;
        oberflaeche = new FENSTER(kaestchengroesse * kaestchenzahl_nach_rechts,
                kaestchengroesse * kaestchenzahl_nach_unten, this);
        anzeige = new LEINWAND(this, kaestchengroesse,
                kaestchenzahl_nach_rechts, kaestchenzahl_nach_unten);
        oberflaeche.add(anzeige, 0);
        anzeige.setLocation(oberflaeche.RandLinksGeben(),
                oberflaeche.RandObenGeben());
        Zeichnen();
    }

    /**
     * Gibt die Anzahl der Kästchen nach rechts aus
     */
    int Kaestchenzahl_rechtsGeben()
    {
        return kaestchenzahl_nach_rechts;
    }

    /**
     * Gibt die Anzahl der Kästchen nach unten aus
     */
    int Kaestchenzahl_untenGeben()
    {
        return kaestchenzahl_nach_unten;
    }

    /**
     * Zeichnet die Leinwand mit den darauf befindlichen Symbolen.
     */
    void Zeichnen()
    {
        anzeige.invalidate();
        anzeige.repaint();
    }

    /**
     * Holt beim Spiel eine Referenz auf das Spielfeld und leitet diese weiter.
     *
     * @return Referenz auf das Spielfeld.
     */
    char[][] SpielfeldGeben()
    {
        return spiel.SpielfeldGeben();
    }

    /**
     * Leitet an das Spiel die Information zu einer Richtungsänderung weiter.
     *
     * @param w weiterzuleitende Richtungsinformation ('l','r')
     */
    void RichtungsAenderungWeiterleiten(char w)
    {
        spiel.RichtungsAenderungWeiterleiten(w);
    }
}
