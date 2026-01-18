package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

/**
 * Beschreibt ein allgemeines Fahrzeug.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version V1.0
 */
abstract class Fahrzeug implements DatenElement
{
    protected FahrzeugSymbol symbol;

    protected float x;

    protected float y;

    protected float v;

    protected float vmax;

    protected char ausrichtung;

    /**
     * Erzeugtein Fahrzeug
     */
    public Fahrzeug()
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
    public void PositionSetzen(float x, float y)
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
    public void AusrichtungSetzen(char ausrichtung)
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
    public abstract void Fahren(float wegmax, float vvorg);

    /**
     * Meldet die x-Koordinate zurück
     *
     * @return x-Koordinate
     */
    public float XKoordinateGeben()
    {
        return x;
    }

    /**
     * Meldet die y-Koordinate zurück
     *
     * @return y-Koordinate
     */
    public float YKoordinateGeben()
    {
        return y;
    }

    /**
     * Meldet die Länge des Fahrzeugs zurück
     *
     * @return Länge
     */
    public abstract float LaengeGeben();

    /**
     * Meldet die Geschwindigkeit zurück
     *
     * @return Geschwindigkeit
     */
    public float GeschwindigkeitGeben()
    {
        return v;
    }

    /**
     * Entfernt das Fahrzeug aus der Anzeige
     */
    public void Entfernen()
    {
        symbol.Entfernen();
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        return true;
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return true;
    }

    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    public void InformationAusgeben()
    {
    }
}
