package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_08.karol;

/**
 * Ein Variante von Karol mit mehr Methoden.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class MEINROBOTER extends ROBOTER
{
    /**
     * Erzeugen eines neuen Roboters aufgrund der Einstellungen in einer
     * Karolwelt-Datei
     *
     * Vorher muss ein Objekt der Klasse WELT angelegt werden, in der der
     * Roboter leben soll. Wenn dieses Weltobjekt aus einer Karolwelt-Datei
     * geladen wurde, dann werden die dortigen Robotereinstellungen verwendet,
     * sonst ein Default-Roboter mit (1,1) und Blickrichtung 'S'
     *
     * @param Referenz auf die Welt in der der Roboter leben soll
     *
     */
    MEINROBOTER(WELT inWelt)
    {
        super(inWelt);
    }

    /**
     * Geht bis zur Wand
     */
    void ZurWandGehen()
    {
        while (!IstWand())
        {
            Schritt();
        }
    }

    /**
     * Hebt alle Ziegel vor ihm auf
     */
    void AlleZiegelAufheben()
    {
        while (IstZiegel())
        {
            Aufheben();
        }
    }

    /**
     * Räumt alle Ziegel bis zur Wand auf
     */
    void Putzen1()
    {
        while (!IstWand())
        {
            AlleZiegelAufheben();
            Schritt();
        }
    }

    /**
     * Räumt alle Ziegel bis zur Wand auf
     */
    void Putzen2()
    {
        while (!IstWand())
        {
            while (IstZiegel())
            {
                Aufheben();
            }
            Schritt();
        }
    }

    /**
     * Räumt die Ziegelschlange auf
     */
    void SchlangeAufräumen()
    {
        while (!IstWand())
        {
            while (!IstZiegel())
            {
                LinksDrehen();
            }
            Aufheben();
            Schritt();
        }
    }

    /**
     * Geht bis zur Wand
     */
    void ZumHindernisGehen()
    {
        while (!IstWand() && !IstZiegel()) // alternativ: !(IstWand() ||
                                           // IstZiegel())
        {
            Schritt();
        }
    }
}
