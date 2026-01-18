package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_02.aufgabe_09.karol;

/**
 * Ein Variante von Karol mit mehr Methoden.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ROBOTERBESSER extends ROBOTER
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
    ROBOTERBESSER(WELT inWelt)
    {
        super(inWelt);
    }

    /**
     * Karol dreht sich um
     */
    void Umdrehen()
    {
        this.VerzoegerungSetzen(0);
        this.LinksDrehen();
        this.LinksDrehen();
        this.VerzoegerungSetzen(300);
    }

    /**
     * Karol geht einen Schritt zurück
     */
    void SchrittZurück()
    {
        this.VerzoegerungSetzen(0);
        this.Umdrehen();
        this.Schritt();
        this.Umdrehen();
        this.VerzoegerungSetzen(300);
    }

    /**
     * Legt einen roten Ziegel links neben sich
     */
    void ZiegelLinksLegen()
    {
        this.VerzoegerungSetzen(0);
        this.LinksDrehen();
        this.Hinlegen();
        this.RechtsDrehen();
        this.VerzoegerungSetzen(300);
    }

    /**
     * Legt einen Ziegel links neben sich
     */
    void ZiegelLinksLegen(String farbe)
    {
        this.VerzoegerungSetzen(0);
        this.LinksDrehen();
        this.Hinlegen(farbe);
        this.RechtsDrehen();
        this.VerzoegerungSetzen(300);
    }

    /**
     * Legt einen roten Ziegel unter sich
     */
    void ZiegelUnterSichLegen()
    {
        this.VerzoegerungSetzen(0);
        this.SchrittZurück();
        this.Hinlegen();
        this.Schritt();
        this.VerzoegerungSetzen(300);
    }

    /**
     * Legt einen Ziegel unter sich
     */
    void ZiegelUnterSichLegen(String farbe)
    {
        this.VerzoegerungSetzen(0);
        this.SchrittZurück();
        this.Hinlegen(farbe);
        this.Schritt();
        this.VerzoegerungSetzen(300);
    }
}
