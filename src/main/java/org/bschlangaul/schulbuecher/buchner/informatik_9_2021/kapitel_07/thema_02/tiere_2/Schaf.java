package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_2;

public class Schaf extends Tier
{
    Schaf()
    {
        art = "Schaf";
        futter = "Gras";
    }

    void stelleVor()
    {
        String text = "Määäh";
        DrawingUtil.showText(this, text, 300);
    }
}
