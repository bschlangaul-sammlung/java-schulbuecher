package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.kreuzung;

/**
 * Beschreibt einen Lastwagen mit Anhänger.
 *
 * @author Ali Chwarizmi, Heidrun Namweiden
 *
 * @version V1.0
 */
class LKWMITANHAENGER extends FAHRZEUG
{
    private float a1;

    private float a2;

    /**
     * Erzeugt die Anzeige.
     */
    public LKWMITANHAENGER()
    {
        super();
        symbol = new LKWMITANHAENGERSYMBOL();
        switch ((new java.util.Random()).nextInt(7))
        {
        case 0:
            symbol.FarbeSetzen("rot");
            break;

        case 1:
            symbol.FarbeSetzen("gruen");
            break;

        case 2:
            symbol.FarbeSetzen("blau");
            break;

        case 3:
            symbol.FarbeSetzen("gelb");
            break;

        case 4:
            symbol.FarbeSetzen("cyan");
            break;

        case 5:
            symbol.FarbeSetzen("magenta");
            break;

        case 6:
            symbol.FarbeSetzen("weiss");
            break;

        default:
            break;
        }
        PositionSetzen(0, 0);
        a1 = 3.0f;
        a2 = 2.0f;
    }

    /**
     * Fährt das Fahrzeug eine Sekunde nach rechts.
     *
     * @param wegmax maximaler Weg bis zum nächsten Hindernis
     * @param vvorg Geschwindigkeit des Vorgängerfahrzeugs bzw. der Ampel
     */
    public void Fahren(float wegmax, float vvorg)
    {
        float weg;
        float vneu;
        weg = 0;
        for (int i = 0; i < 10; i++) // Maximaler Weg
        {
            if (v <= 5.5f)
            {
                vneu = a1 * 0.1f + v;
            }
            else
            {
                vneu = a2 * 0.1f + v;
            }
            if (vneu > vmax)
            {
                vneu = vmax;
            }
            weg = weg + (vneu + v) / 2.0f * 0.1f;
            v = vneu;
        }
        if (wegmax <= 0.0f) // Muss stehen bleiben
        {
            weg = 0.0f;
            v = 0.0f;
        }
        else if (weg >= wegmax) // Kommt zu dicht an den Vorgänger
        {
            weg = wegmax;
            if (v > vvorg) // und ist auch noch zu schnell
            {
                v = vvorg;
            }
        }
        else
        {
            vneu = (wegmax + vvorg * 1.0f - weg) / 1.8f; // Maximale
                                                         // Geschwindigkeit für
                                                         // den
                                                         // Restabstand zum
                                                         // Vorgänger
            if (vneu < v) // Zu schnell für den Abstand
            {
                v = vneu;
            }
        }
        switch (ausrichtung)
        {
        case 'O':
            PositionSetzen(x + weg, y);
            break;

        case 'W':
            PositionSetzen(x - weg, y);
            break;

        case 'N':
            PositionSetzen(x, y - weg);
            break;

        case 'S':
            PositionSetzen(x, y + weg);
            break;
        }
    }

    /**
     * Meldet die Länge des Fahrzeugs zurück
     *
     * @return Länge
     */
    public float LaengeGeben()
    {
        return 13.0f;
    }
}
