package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_02.dont_touch;

/**
 * Verwaltet die Spielfigur
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Spielfigur extends Figur
{
    /** Länge der Bewegung */
    int delta;

    /** Anzeigetext */
    Text t;

    /**
     * Legt das Aussehen der Spielfigur fest
     */
    Spielfigur()
    {
        FigurteilFestlegenEllipse(0, 0, 100, 100, "rot");
        delta = 4;
        t = null;
    }

    /**
     * Tasten werden ignoriert
     *
     * @param taste die gedrückte Taste
     */
    @Override
    void TasteGedrückt(char taste)
    {
    }

    /**
     * Sondertasten werden ausgewertet
     *
     * @param taste die gedrückte Sondertaste
     */
    @Override
    void SonderTasteGedrückt(int taste)
    {
        if (taste == 38)
        {
            if (YPositionGeben() > 0)
            {
                PositionSetzen(XPositionGeben(), YPositionGeben() - delta);
            }
        }
        if (taste == 40)
        {
            if (YPositionGeben() < 500)
            {
                PositionSetzen(XPositionGeben(), YPositionGeben() + delta);
            }
        }
        if (taste == 37)
        {
            if (XPositionGeben() > 0)
            {
                PositionSetzen(XPositionGeben() - delta, YPositionGeben());
            }
        }
        if (taste == 39)
        {
            if (XPositionGeben() < 740)
            {
                PositionSetzen(XPositionGeben() + delta, YPositionGeben());
            }
        }
    }

    /**
     * Bewegt die Figur.
     */
    @Override
    void AktionAusführen()
    {
        if (Berührt())
        {
            if (t != null)
            {
                t.Entfernen();
            }
            t = new Text();
            t.TextSetzen("Don't touch");
        }
        if (t != null)
        {
            t.TextVergrößern();
            t.Verschieben(5, 5);
        }
    }
}
