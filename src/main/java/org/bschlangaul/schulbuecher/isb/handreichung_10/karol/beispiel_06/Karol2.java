package org.bschlangaul.schulbuecher.isb.handreichung_10.karol.beispiel_06;

import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.Karol;
import org.bschlangaul.schulbuecher.isb.handreichung_10.karol.KarolWelt;

/**
 * Ergänzt Karol um einige öfter verwendbare Methoden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Karol2 extends Karol
{
    /**
     * Erzeugen eines neuen Roboters mit vorgegebener Startposition
     * <p>
     * Vorher muss ein Objekt der Klasse WELT angelegt werden, in der der
     * Roboter lebt.
     *
     * @param startX Startposition mit 1..WeltBreite
     * @param startY Startposition mit 1..WeltLänge
     * @param startBlickrichtung Startblickrichtung 'S','W','N','O'
     * @param inWelt Referenz auf die Welt in der der Roboter leben soll
     *
     */
    public Karol2(int startX, int startY, char startBlickrichtung,
            KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
    }

    /**
     * Erzeugen eines neuen Roboters aufgrund der Einstellungen in einer
     * Karolwelt-Datei
     * <p>
     * Vorher muss ein Objekt der Klasse WELT angelegt werden, in der der
     * Roboter leben soll. Wenn dieses Weltobjekt aus einer Karolwelt-Datei
     * geladen wurde, dann werden die dortigen Robotereinstellungen verwendet,
     * sonst ein Default-Roboter mit (1,1) und Blickrichtung 'S'
     *
     * @param inWelt Referenz auf die Welt in der der Roboter leben soll
     *
     */
    public Karol2(KarolWelt inWelt)
    {
        super(inWelt);
    }

    /**
     * Der Roboter dreht sich auf der Stelle um.
     */
    void Umdrehen()
    {
        LinksDrehen();
        LinksDrehen();
    }

    /**
     * Der Roboter geht einen Schritt zurück.
     */
    void SchrittZurueck()
    {
        Umdrehen();
        Schritt();
        Umdrehen();
    }

    /**
     * Setzt eine Marke auf dem Feld vor sich.
     */
    void MarkeVorSichSetzen()
    {
        Schritt();
        MarkeSetzen();
        SchrittZurueck();
    }
}
