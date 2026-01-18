package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_c.kreuzung;

/**
 * Eine Ampel verwendet zur Anzeige drei Lampen. Die Ampel verwaltet ihre
 * Position als Ganzes, ihre Ausrichtung und auch die nach den Verkehrsregeln
 * möglichen Ampelphasen.
 *
 * @author Peter Cody
 *
 * @version 1.0
 */
class Ampel
{
    /**
     * Der Bezugspunkt für die Position ist die obere linke Ecke der lampeOben.
     */
    private int positionX;

    /**
     * Der Bezugspunkt für die Position ist die obere linke Ecke der lampeOben.
     */
    private int positionY;

    /**
     * Mögliche Werte sind die in Deutschland erlaubten Ampelphasen grün, gelb,
     * rot und rotgelb.
     */
    private String ampelphase;

    /**
     * Eine Ausrichtung ist in die vier Himmelsrichtungen N, W, S, O möglich.
     */
    private char ausrichtung;

    // Referenzattribute
    private Lampe lampeOben;

    private Lampe lampeMitte;

    private Lampe lampeUnten;

    /**
     * Konstruktor für Objekte der Klasse AMPEL.
     */
    public Ampel()
    {
        positionX = 1;
        positionY = 1;
        ampelphase = "rot";
        ausrichtung = 'S';
        lampeOben = new Lampe();
        lampeMitte = new Lampe();
        lampeUnten = new Lampe();
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Konstruktor für Objekte der Klasse AMPEL mit folgenden Eingabewerten.
     *
     * @param xNeu - neue x-Position
     * @param yNeu - neue y-Position
     * @param ausrichtungNeu - neue Ausrichtung
     */
    public Ampel(int xNeu, int yNeu, char ausrichtungNeu)
    {
        lampeOben = new Lampe();
        lampeMitte = new Lampe();
        lampeUnten = new Lampe();
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("schwarz");
        PositionSetzen(xNeu, yNeu);
        ampelphase = "rot";
        AusrichtungSetzen(ausrichtungNeu);
    }

    /**
     * Setzt die Ampel auf grün.
     */
    public void GruenSetzen()
    {
        ampelphase = "gruen";
        lampeOben.FarbeSetzen("schwarz");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("gruen");
        AmpelAnordnen();
    }

    /**
     * Setzt die Ampel auf gelb.
     */
    public void GelbSetzen()
    {
        ampelphase = "gelb";
        lampeOben.FarbeSetzen("schwarz");
        lampeMitte.FarbeSetzen("gelb");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Setzt die Ampel auf rot-gelb.
     */
    public void RotgelbSetzen()
    {
        ampelphase = "rotgelb";
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("gelb");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Setzt die Ampel auf rot.
     */
    public void RotSetzen()
    {
        ampelphase = "rot";
        lampeOben.FarbeSetzen("rot");
        lampeMitte.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Schaltet die Ampelphasen in der Reihenfolge rot, rotgelb, grün, gelb
     */
    public void Weiterschalten()
    {
        if (ampelphase == "rot")
        {
            RotgelbSetzen();
        }
        else
        {
            if (ampelphase == "rotgelb")
            {
                GruenSetzen();
            }
            else
            {
                if (ampelphase == "gruen")
                {
                    GelbSetzen();
                }
                else
                {
                    RotSetzen();
                }
            }
        }
    }

    /**
     * Setzt die Ausrichtung der Ampel auf die möglichen Werte S, W, N, O.
     *
     * @param ausrichtungNeu neue Ausrichtung der Ampel
     */
    public void AusrichtungSetzen(char ausrichtungNeu)
    {
        if ((ausrichtungNeu == 'S') || (ausrichtungNeu == 'W')
                || (ausrichtungNeu == 'N') || (ausrichtungNeu == 'O'))
        {
            ausrichtung = ausrichtungNeu;
            AmpelAnordnen();
        }
    }

    /**
     * Setzt die Position der Ampel. Der Ursprung liegt in der Mitte des
     * Fensters, die y-Achse zeigt nach unten. (x /y) bedeutet das Kästchen
     * rechts unterhalb der Gitterlinien.
     *
     * @param xNeu xNeu-Position
     * @param yNeu yNeu-Position
     */
    public void PositionSetzen(int xNeu, int yNeu)
    {
        if (xNeu <= 7 && xNeu >= -8 && yNeu <= 7 && yNeu >= -8)
        {
            positionX = xNeu;
            positionY = yNeu;
            AmpelAnordnen();
        }
    }

    /**
     * Zeichnet die Ampel im Raster.
     */
    private void AmpelAnordnen()
    {
        switch (ausrichtung)
        {
        case 'S':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeMitte.PositionSetzen(positionX, positionY + 1);
            lampeUnten.PositionSetzen(positionX, positionY + 2);
            break;

        case 'W':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeMitte.PositionSetzen(positionX - 1, positionY);
            lampeUnten.PositionSetzen(positionX - 2, positionY);
            break;

        case 'N':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeMitte.PositionSetzen(positionX, positionY - 1);
            lampeUnten.PositionSetzen(positionX, positionY - 2);
            break;

        case 'O':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeMitte.PositionSetzen(positionX + 1, positionY);
            lampeUnten.PositionSetzen(positionX + 2, positionY);
            break;
        }
    }

    /**
     * Meldet, ob die Ampel auf grün steht.
     *
     * @return true, falls die Ampel grün zeigt.
     */
    boolean IstGruen()
    {
        return ampelphase == "gruen";
    }

    /**
     * Meldet, ob die Ampel auf gelb steht.
     *
     * @return true, falls die Ampel gelb zeigt.
     */
    boolean IstGelb()
    {
        return ampelphase == "gelb";
    }
}
