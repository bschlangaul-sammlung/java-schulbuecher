package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_04.labyrinth;

/**
 * Spielfigur
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Spielfigur extends Figur
{
    int delta;

    /**
     * Legt die Form und die Startposition der Spielfigur fest
     */
    Spielfigur()
    {
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "rot");
        delta = 1;
        PositionSetzen(338, 143);
    }

    /**
     * Bewegt die Figur bis zur nächsten Mauer nach oben
     */
    void NachObenBewegen()
    {
        while (!Berührt("schwarz") && !Berührt("grün"))
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() - 1);
        }
        while (Berührt("schwarz"))
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() + 1);
        }
    }

    /**
     * Bewegt die Figur bis zur nächsten Mauer nach unten
     */
    void NachUntenBewegen()
    {
        while (!Berührt("schwarz") && !Berührt("grün"))
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() + 1);
        }
        while (Berührt("schwarz"))
        {
            PositionSetzen(XPositionGeben(), YPositionGeben() - 1);
        }
    }

    /**
     * Bewegt die Figur bis zur nächsten Mauer nach links
     */
    void NachLinksBewegen()
    {
        while (!Berührt("schwarz") && !Berührt("grün"))
        {
            PositionSetzen(XPositionGeben() - 1, YPositionGeben());
        }
        while (Berührt("schwarz"))
        {
            PositionSetzen(XPositionGeben() + 1, YPositionGeben());
        }
    }

    /**
     * Bewegt die Figur bis zur nächsten Mauer nach rechts
     */
    void NachRechtsBewegen()
    {
        while (!Berührt("schwarz") && !Berührt("grün"))
        {
            PositionSetzen(XPositionGeben() + 1, YPositionGeben());
        }
        while (Berührt("schwarz"))
        {
            PositionSetzen(XPositionGeben() - 1, YPositionGeben());
        }
    }

    /**
     * Wir aufgerufen, wenn eine Sondertaste gedrückt wurde
     *
     * @param taste Nummer der Sondertaste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
        switch (taste)
        {
        case 37:
            NachLinksBewegen();
            break;

        case 38:
            NachObenBewegen();
            break;

        case 39:
            NachRechtsBewegen();
            break;

        case 40:
            NachUntenBewegen();
            break;
        }
    }
}
