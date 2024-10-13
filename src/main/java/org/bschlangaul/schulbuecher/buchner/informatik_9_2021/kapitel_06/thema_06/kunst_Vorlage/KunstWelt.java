package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_06.kunst_Vorlage;

import greenfoot.World;

/**
 * Projekt zu Kap. 6.5
 * <p>
 * Arbeitsaufträge 1 und 2, Aufgabe 1 und 2
 */
public class KunstWelt extends World
{
    public KunstWelt()
    {
        super(15, 15, 50);
        erstelleKunstwerk(); // ruft die Methode auf, die alle Kunstwerke
                             // erstellen soll
    }

    void erstelleKunstwerk()
    {
        // 6.5 A1; A2; Aufgabe 1; 2
        erstelleQuadratAn(7, 7);
    }

    boolean istTeilbarDurch(int a, int b) // liefert true, wenn a durch b
                                          // teilbar ist
    {
        return a % b == 0;
    }

    void erstelleQuadratAn(int x, int y) // zeichnet ein farbiges Quadrat an der
                                         // Stelle (x|y)
    {
        Zelle zelle = new Zelle();
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }
}
