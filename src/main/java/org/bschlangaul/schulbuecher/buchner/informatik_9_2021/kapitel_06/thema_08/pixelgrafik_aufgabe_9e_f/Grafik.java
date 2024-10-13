package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.pixelgrafik_aufgabe_9e_f;

import greenfoot.World;

/**
 * Projekt zu 6.8 Aufgabe 9
 * <p>
 * Teilaufgaben a), b), c), d) und e)
 */
public class Grafik extends World
{
    int farbNr = 1;

    public Grafik()
    {
        super(15, 15, 50);
        erstelleGrafik();
    }

    void erstelleGrafik() // ruft eine Methode auf, die die gewüschten Pixel
                          // zeichnet
    {
        zeichneDiagonale();
        // weitere Grafiken
        // 9a
        // zeichneLinie(5, 3, 7, false);
        // 9b
        // zeichneRechteck(2,1,5,8);
        // 9c
        // zeichneSchlangenlinie(7, 4, 15);
    }

    void zeichneDiagonale() // färbt einige Pixel so, dass die zu Beginn des
                            // Aufgabentextes
                            // abgedruckte Diagonale sichtbar wird
    {
        int i = 0;
        while (i < 15)
        {
            zeichnePixel(i, i, farbNr);
            i = i + 1;
        }
    }

    // 9a
    void zeichneLinie(int x, int y, int laenge, boolean istWaagrecht)
    {
        int i = 0;
        if (istWaagrecht == true)
        {
            while (i < laenge)
            {
                zeichnePixel(x + i, y, farbNr);
                i = i + 1;
            }
        }
        else
        {
            while (i < laenge)
            {
                zeichnePixel(x, y + i, farbNr);
                i = i + 1;
            }
        }
    }

    // 9b
    void zeichneRechteck(int x, int y, int breite, int hoehe)
    {
        int i = 0;
        int j = 0;
        while (i <= breite)
        {
            zeichnePixel(x + i, y, farbNr);
            zeichnePixel(x + i, y + hoehe, farbNr);
            i = i + 1;
        }
        while (j <= hoehe)
        {
            zeichnePixel(x, y + j, farbNr);
            zeichnePixel(x + breite, y + j, farbNr);
            j = j + 1;
        }
    }

    // 9c
    void zeichneSchlangenlinie(int x, int y, int laenge)
    {
        while (x < 15 && laenge > 0)
        {
            zeichnePixel(x, y, farbNr);
            x = x + 1;
            laenge = laenge - 1;
            if (x == 15)
            {
                while (laenge > 0)
                {
                    zeichnePixel(x, y, farbNr);
                    y = y + 1;
                    laenge = laenge - 1;
                }
            }
        }
    }

    void zeichnePixel(int x, int y, int farbNr) // färbt die Zelle mit den
                                                // Koordinaten (x|y)
    {
        Zelle zelle = new Zelle(farbNr);
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }
}
