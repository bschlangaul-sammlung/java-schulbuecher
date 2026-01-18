package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_05.aufgabe_10.karol;

/**
 * Ein Variante von Karol mit mehr Methoden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MEINROBOTER extends ROBOTER
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
    MEINROBOTER(WELT inWelt)
    {
        super(inWelt);
    }

    /**
     * Der Roboter macht einen Schritt nach vorne
     */
    @Override
    public void Schritt()
    {
        if (!IstWand())
        {
            super.Schritt();
        }
    }

    /**
     * Der Roboter legt vor sich einen roten Ziegel hin
     */
    @Override
    public void Hinlegen()
    {
        if (!IstWand())
        {
            super.Hinlegen();
        }
    }

    /**
     * Der Roboter hebt vor sich einen Ziegel beliebiger Farbe auf
     */
    @Override
    public void Aufheben()
    {
        if (!IstZiegel())
        {
            super.Aufheben();
        }
    }
}
