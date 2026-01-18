package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.kreuzung;

/**
 * Beschreibt ein allgemeines Fahrzeug.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version V1.0
 */
abstract class FAHRZEUG implements DATENELEMENT
{
    protected FAHRZEUGSYMBOL symbol;

    protected float x;

    protected float y;

    protected float v;

    protected float vmax;

    protected char ausrichtung;

    /**
     * Erzeugt die Anzeige.
     */
    FAHRZEUG()
    {
        symbol = null;
        vmax = 13.89f;
        v = vmax;
        ausrichtung = 'O';
    }

    /**
     * Setzt die Position des Fahrzeugs.
     *
     * @param x x-Position
     * @param y y-Position
     */
    void PositionSetzen(float x, float y)
    {
        this.x = x;
        this.y = y;
        symbol.PositionSetzen(x, y);
    }

    /**
     * Setzt die Ausrichtung des Fahrzeugs.
     *
     * @param ausrichtung neue Ausrichtung
     */
    void AusrichtungSetzen(char ausrichtung)
    {
        this.ausrichtung = ausrichtung;
        symbol.AusrichtungSetzen(ausrichtung);
    }

    /**
     * Fährt das Fahrzeug eine Sekunde nach rechts.
     *
     * @param wegmax maximaler Weg bis zum nächsten Hindernis
     * @param vvorg Geschwindigkeit des Vorgängerfahrzeugs bzw. der Ampel
     */
    abstract void Fahren(float wegmax, float vvorg);

    /**
     * Meldet die x-Koordinate zurück
     *
     * @return x-Koordinate
     */
    float XKoordinateGeben()
    {
        return x;
    }

    /**
     * Meldet die y-Koordinate zurück
     *
     * @return y-Koordinate
     */
    float YKoordinateGeben()
    {
        return y;
    }

    /**
     * Meldet die Länge des Fahrzeugs zurück
     *
     * @return Länge
     */
    abstract float LaengeGeben();

    /**
     * Meldet die Geschwindigkeit zurück
     *
     * @return Geschwindigkeit
     */
    float GeschwindigkeitGeben()
    {
        return v;
    }

    /**
     * Entfernt das Fahrzeug aus der Anzeige
     */
    void Entfernen()
    {
        symbol.Entfernen();
    }

    /**
     * ohne Funktion in diesem Projekt
     */
    public void InformationAusgeben()
    {
    }
}
