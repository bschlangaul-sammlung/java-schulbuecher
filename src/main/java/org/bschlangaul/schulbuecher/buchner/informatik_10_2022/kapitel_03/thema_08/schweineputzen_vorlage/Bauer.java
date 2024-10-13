package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.schweineputzen_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Projekt 3-8_Schweineputzen
 *
 * @author Ulrich Schneider
 *
 * @version 2022-09-12
 */
public class Bauer extends Actor
{
    private int GrasAnzahl = 0;

    private int timer = 0;

    public void act()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            bewege(2, 0);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            bewege(-2, 0);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            bewege(0, -2);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            bewege(0, 2);
        }
        // Aufgabe b: Taste g: Gras sammeln, Taste p: Schwein putzen
        // Aufgabe g: Brunnen Betätigen
        timer++;
    }
    // Die Rümpfe der Methoden ab hier müssen nicht gelesen werden.

    void bewege(int dx, int dy)
    {
        if (istFeldFrei(dx, dy))
        {
            setLocation(getX() + dx, getY() + dy);
        }
    }

    boolean istFeldFrei(int dx, int dy)
    {
        return getOneObjectAtOffset(dx, dy, Matsch.class) == null;
    }

    public void brunnenBetaetigen()
    {
        if (isTouching(Brunnen.class))
        {
            ((SchweineWelt) getWorld()).bodenWaessern();
        }
    }

    public void schweinPutzen()
    {
        // Falls ein dreckiges Schwein vorhanden und genug Gras vorhanden,
        // Schein putzen
        if (isTouching(Schwein.class))
        {
            Schwein schwein = (Schwein) getOneIntersectingObject(Schwein.class);
            // Aufgabe e: Schwein wird nur geputzt, wenn es dreckig ist und
            // genügend Gras vorhanden
            // ist
            if (timer > 100)
            {
                schwein.putzen();
                timer = 0;
                // Aufgabe d: Beim putzen, ein Gras weniger und Zähler
                // aktualisieren
                // Ein Grasbüschel weniger
                // Graszähler aktualisieren
                // Aufgabe d Ende
                // Prüfen, ob alle Schweine geputzt sind
                ((SchweineWelt) getWorld()).sindAlleSchweineSauber();
            }
        }
    }

    public void grasAufsammeln()
    {
        // Aufgabe f: Bauer hat Beutel mit maximal 5 Gras: && GrasAnzahl < 5
        if (isTouching(Gras.class))
        {
            // Aufgabe f Ende
            // Grasbüschel aus der Welt entfernen
            removeTouching(Gras.class);
            // Aufgabe d: Beim Gras sammeln, ein Gras mehr und Zähler
            // aktualisieren
            // Ein Grasbüschel mehr
            // Graszähler aktualisieren
            // Aufgabe d Ende
        }
    }

    // Aktualisiert den in der Schweinewelt angezeigten Gras-Zähler
    public void grasZaehlerAktualisieren()
    {
        getWorld().showText("Gras: " + GrasAnzahl, 50, 20);
    };
}
