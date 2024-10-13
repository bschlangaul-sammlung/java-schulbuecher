package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_05.caesar_vorlage;

import greenfoot.World;

/**
 * Projekt 3-5_Caesar
 *
 * @author André Greubel
 *
 * @version 2022-09-21
 */
public class KryptoWorld extends World
{
    private BuchstabenAnzeige[] buchstaben;

    SchluesselAnzeige sa;

    public KryptoWorld()
    {
        super(600, 200, 1);
        sa = new SchluesselAnzeige(this, 3);
        addObject(sa, 600 - 50, 125);
        createWorld("KLARTEXT");
    }

    void createWorld(String text)
    {
        buchstaben = new BuchstabenAnzeige[text.length()];
        for (int i = 0; i < text.length(); i++)
        {
            buchstaben[i] = new BuchstabenAnzeige(text.charAt(i), sa);
            addObject(buchstaben[i], 10 + 25 + i * 60, 100);
        }
    }

    public void update()
    {
        if (buchstaben == null)
        {
            return;
        }
        for (BuchstabenAnzeige ba : buchstaben)
        {
            if (ba != null)
            {
                ba.update();
            }
        }
    }
}
