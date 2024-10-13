package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_04.zahlenspirale_a1;

import greenfoot.World;

/**
 * Projekt zu Kap. 6.4. <br>
 *
 * Klasse Ulamspirale <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Ulamspirale extends World
{
    public Ulamspirale()
    {
        super(50, 50, 20);
        erstelleSpirale(50 * 50);
    }

    void erstelleSpirale(int anzahl)
    {
        int nr = 0;
        int runLength = 1;
        int lastDirChange = 0;
        boolean toggle = false;
        Zelle letzteZelle = new Zelle(0, 0, 1);
        fuegeZelleEin(letzteZelle);
        Richtung dir = Richtung.RECHTS;
        while (nr < anzahl - 1)
        {
            if (nr == lastDirChange + runLength)
            {
                if (toggle)
                {
                    runLength = runLength + 1;
                }
                dir = dir.next();
                toggle = !toggle;
                lastDirChange = nr;
            }
            letzteZelle = dir.vonZelle(letzteZelle);
            fuegeZelleEin(letzteZelle);
            nr = nr + 1;
        }
    }

    void fuegeZelleEin(Zelle zelle)
    {
        addObject(zelle, getWidth() / 2 + zelle.x - 1,
                getHeight() / 2 + zelle.y);
        zelle.erstelleBild();
    }

    enum Richtung
    {
        RECHTS, OBEN, LINKS, UNTEN;

        Richtung next()
        {
            switch (this)
            {
            case RECHTS:
                return OBEN;

            case OBEN:
                return LINKS;

            case LINKS:
                return UNTEN;

            case UNTEN:
                return RECHTS;
            }
            return null;
        }

        Zelle vonZelle(Zelle z)
        {
            switch (this)
            {
            case RECHTS:
                return new Zelle(z.x + 1, z.y, z.getNummer() + 1);

            case OBEN:
                return new Zelle(z.x, z.y - 1, z.getNummer() + 1);

            case LINKS:
                return new Zelle(z.x - 1, z.y, z.getNummer() + 1);

            case UNTEN:
                return new Zelle(z.x, z.y + 1, z.getNummer() + 1);
            }
            return null;
        }
    }
}
