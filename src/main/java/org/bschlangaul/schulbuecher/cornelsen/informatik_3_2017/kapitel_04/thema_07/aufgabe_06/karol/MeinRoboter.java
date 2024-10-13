package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_06.karol;

/**
 * Ein Variante von Karol mit mehr Methoden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MeinRoboter extends Roboter
{
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
    MeinRoboter(Welt inWelt)
    {
        super(inWelt);
    }

    /**
     * Legt ein Quadrat der Seitenlänge 4
     */
    void Quadrat4Legen()
    {
        for (int seite = 1; seite <= 4; seite = seite + 1)
        {
            for (int nummer = 1; nummer <= 3; nummer = nummer + 1)
            {
                Hinlegen();
                Schritt();
            }
            LinksDrehen();
        }
    }

    /**
     * Baut einen Turm aus Quadraten
     */
    void TurmBauen()
    {
        for (int stockwerk = 1; stockwerk <= 10; stockwerk = stockwerk + 1)
        {
            Quadrat4Legen();
        }
    }

    /**
     * Baut einen Turm direkt
     */
    void TurmBauenOhne()
    {
        for (int stockwerk = 1; stockwerk <= 10; stockwerk = stockwerk + 1)
        {
            for (int seite = 1; seite <= 4; seite = seite + 1)
            {
                for (int nummer = 1; nummer <= 3; nummer = nummer + 1)
                {
                    Hinlegen();
                    Schritt();
                }
                LinksDrehen();
            }
        }
    }
}
