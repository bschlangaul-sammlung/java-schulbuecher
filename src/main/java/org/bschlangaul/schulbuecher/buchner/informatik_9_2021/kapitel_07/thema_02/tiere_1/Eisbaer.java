package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_1;

/**
 * Klasse Eisbaer <br>
 *
 * Kap. 7.2 Arbeitsauftrag 1
 */
class Eisbaer extends Tier
{
    Eisbaer()
    {
        art = "Eisbär";
        futter = "Fisch";
    }

    void jagen()
    {
        String text = "Ich bin ein " + art + " und jage Robben.";
        DrawingUtil.showText(this, text, 300);
    }

    // A3 c)
    void bewegeNachRechts()
    {
        if (istRechtsStein() == false)
        {
            setLocation(getX() + 1, getY());
        }
    }
}
