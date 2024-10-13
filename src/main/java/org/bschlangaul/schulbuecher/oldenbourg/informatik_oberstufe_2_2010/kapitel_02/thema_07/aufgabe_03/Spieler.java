package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Stellt den Pacman dar.
 *
 * @author Albert Wiedemann.
 *
 * @version 1.0
 */
class Spieler extends Figur
{
    /** Bewegungsrichtung */
    private char richtung;

    /** Anzahl der noch zu suchenden Marken */
    private int anzahlMarken;

    /**
     * Positioniert den Roboter in seiner Welt.
     *
     * @param startX X-Koordinate der Startposition
     * @param startY Y-Koordinate der Startposition
     * @param startBlickrichtung Blickrichtung beim Start
     * @param inWelt Welt, in der der Roboter lebt
     */
    Spieler(int startX, int startY, char startBlickrichtung, KarolWelt inWelt)
    {
        super(startX, startY, startBlickrichtung, inWelt);
        richtung = 'O';
    }

    /**
     * Setzt die Anfangsanzahl der Markierungen.
     *
     * @param startAnzahl anzahl der beim Spielstart vorhandenen Marken
     */
    void MarkierungsAnzahlSetzen(int startAnzahl)
    {
        anzahlMarken = startAnzahl;
        for (Beobachter b : beobachter)
        {
            b.MarkenMelden(anzahlMarken);
        }
    }

    /**
     * Bewegt den Roboter gemäß seiner Aufgabe.
     */
    void Bewegen()
    {
        RichtungEinstellen(richtung);
        if (IstWand())
        {
            // (noch) nix
        }
        else if (!IstZiegel())
        {
            if (IstRoboter())
            {
                for (Beobachter b : beobachter)
                {
                    b.VerlorenMelden();
                }
                FigurenThread.EndeSetzen();
            }
            else
            {
                Schritt();
                if (IstMarke())
                {
                    MarkeLoeschen();
                    anzahlMarken -= 1;
                    for (Beobachter b : beobachter)
                    {
                        b.MarkenMelden(anzahlMarken);
                    }
                    if (anzahlMarken == 0)
                    {
                        for (Beobachter b : beobachter)
                        {
                            b.GewonnenMelden();
                        }
                        FigurenThread.EndeSetzen();
                    }
                }
            }
        }
    }

    /**
     * Setzt die Bewegungsrichtng für den Spieler-
     *
     * @param r die (neue) Blickrichtung.
     */
    void RichtungSetzen(char r)
    {
        richtung = r;
    }
}
