package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

/**
 * Eine Fußgängerampel verwendet zur Anzeige zwei Lampen. Die Fußgängerampel
 * verwaltet ihre Position als Ganzes, ihre Ausrichtung und auch die nach den
 * Verkehrsregeln möglichen Ampelphasen.
 *
 * @author Peter Cody
 *
 * @version 1.0
 */
class FussgaengerAmpel
{
    private int positionX;

    private int positionY;

    private String ampelphase;

    private char ausrichtung;

    /**
     * Referenzattribute
     */
    private Lampe lampeOben;

    private Lampe lampeUnten;

    /**
     * Konstruktor für Objekte der Klasse FUSSGAENGERAMPEL.
     */
    public FussgaengerAmpel()
    {
        positionX = 1;
        positionY = 1;
        ampelphase = "rot";
        ausrichtung = 'S';
        lampeOben = new Lampe();
        lampeUnten = new Lampe();
        lampeOben.FarbeSetzen("rot");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Konstruktor für Objekte der Klasse FUSSGAENGERAMPEL mit folgenden
     * Eingabewerten.
     *
     * @param xNeu - neue x-Position
     * @param yNeu - neue y-Position
     * @param ausrichtungNeu - neue Ausrichtung
     */
    public FussgaengerAmpel(int xNeu, int yNeu, char ausrichtungNeu)
    {
        lampeOben = new Lampe();
        lampeUnten = new Lampe();
        lampeOben.FarbeSetzen("rot");
        lampeUnten.FarbeSetzen("schwarz");
        PositionSetzen(xNeu, yNeu);
        ampelphase = "rot";
        AusrichtungSetzen(ausrichtungNeu);
    }

    /**
     * Setzt die Fussgängerampel auf grün.
     */
    public void GruenSetzen()
    {
        ampelphase = "gruen";
        lampeOben.FarbeSetzen("schwarz");
        lampeUnten.FarbeSetzen("gruen");
        AmpelAnordnen();
    }

    /**
     * Setzt die Fussgängerampel auf rot.
     */
    public void RotSetzen()
    {
        ampelphase = "rot";
        lampeOben.FarbeSetzen("rot");
        lampeUnten.FarbeSetzen("schwarz");
        AmpelAnordnen();
    }

    /**
     * Schaltet die Ampelphasen in der Reihenfolge von rot auf grün bzw.
     * umgekehrt
     */
    public void Weiterschalten()
    {
        if (ampelphase == "rot")
        {
            GruenSetzen();
        }
        else
        {
            RotSetzen();
        }
    }

    /**
     * Setzt die Ausrichtung der Fussgängerampel auf die möglichen Werte S, W,
     * N, O.
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
     * Setzt die Position der Fussgängerampel. Der Ursprung liegt in der Mitte
     * des Fensters, die y-Achse zeigt nach unten. (x /y) bedeutet das Kästchen
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
     * Zeichnet die Fussgängerampel im Raster.
     */
    private void AmpelAnordnen()
    {
        switch (ausrichtung)
        {
        case 'S':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeUnten.PositionSetzen(positionX, positionY + 1);
            break;

        case 'W':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeUnten.PositionSetzen(positionX - 1, positionY);
            break;

        case 'N':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeUnten.PositionSetzen(positionX, positionY - 1);
            break;

        case 'O':
            lampeOben.PositionSetzen(positionX, positionY);
            lampeUnten.PositionSetzen(positionX + 1, positionY);
            break;
        }
    }
}
