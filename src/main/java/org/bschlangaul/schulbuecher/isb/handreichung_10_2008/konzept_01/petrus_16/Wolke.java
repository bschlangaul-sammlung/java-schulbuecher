package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_16;

import org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class Wolke
{
    private Niederschlag[] elemente;

    private int anzahl;

    public Wolke()
    {
        anzahl = 0;
        elemente = new Niederschlag[1000];
    }

    public void zeichne()
    {
        ZeichenFenster.gibFenster().loescheAlles();
        for (int i = 0; i < anzahl; i++)
        {
            elemente[i].zeichne();
        }
    }

    public void bewege(double zeit)
    {
        for (int i = 0; i < anzahl; i++)
        {
            elemente[i].bewege(zeit);
        }
    }

    public void fuegeHinzu(Niederschlag elementNeu)
    {
        if (anzahl < 1000)
        {
            elemente[anzahl] = elementNeu;
            anzahl = anzahl + 1;
        }
    }

    public void entferne(Niederschlag elementAlt)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (elementAlt == elemente[i])
            {
                elemente[i] = elemente[anzahl - 1];
                elemente[anzahl - 1] = null;
                anzahl = anzahl - 1;
            }
        }
    }

    public void loescheAlle()
    {
        while (anzahl > 0)
        {
            entferne(elemente[0]);
        }
    }
}
