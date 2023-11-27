package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_01.tiervorstellung;

import greenfoot.Actor;

/**
 * Klasse Tier <br>
 *
 * Kap. 7.1 Arbeitsauftrag 2
 */
class Tier extends Actor
{
    String art;

    String futter;

    Tier()
    {
        art = "Tier";
        futter = "";
    }

    void stelleVor()
    {
        String text = "Ich bin ein " + art + ", ich fresse gerne " + futter
                + ".";
        DrawingUtil.showText(this, text, 300);
    }
}
