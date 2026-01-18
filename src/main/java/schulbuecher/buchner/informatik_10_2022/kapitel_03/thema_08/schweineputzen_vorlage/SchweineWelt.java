package schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.schweineputzen_vorlage;

import java.util.List;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt 3-8_Schweineputzen
 *
 * @author Ulrich Schneider
 *
 * @version 2022-09-12
 */
public class SchweineWelt extends World
{
    private int GrasAnzahl;

    public SchweineWelt()
    {
        super(900, 500, 1);
        prepare();
        String msg = "Gras Sammeln (g), Schwein putzen (p), Brunnen(b)!";
        showText(msg, getWidth() / 2, getHeight() - 10);
        String msg2 = "Gras: 0";
        showText(msg2, 50, 20);
    }
    // der Programmtext ab hier muss nicht gelesen werden

    public void removeObject(Actor actor)
    {
        GrasAnzahl--;
        super.removeObject(actor);
    }

    public boolean sindAlleSchweineSauber()
    {
        // Alle Schwein-Objekte der Klasse holen
        List<Schwein> schweine = getObjects(Schwein.class);
        // Prüfen, ob ein Schwein dreckig ist
        for (Schwein schwein : schweine)
        {
            // Wenn ja, false zurückgeben
            if (schwein.gibDreckig())
            {
                return false;
            }
        }
        // Wenn nein, true zurückgeben und Spiel stoppen
        String msg = "Gewonnen! Sie haben alle Schweine geputzt!";
        showText(msg, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
        return true;
    }

    public void bodenWaessern()
    {
        // Aufgabe h: Auf 10 Grasbüschel auffüllen
        // Aufgabe h Ende
    }

    private void prepare()
    {
        neuesObjektZufaelligPositionieren(new Bauer());
        neuesObjektZufaelligPositionieren(new Brunnen());
        neuesObjektZufaelligPositionieren(new Matsch());
        neuesObjektZufaelligPositionieren(new Matsch());
        neuesObjektZufaelligPositionieren(new Matsch());
        neuesObjektZufaelligPositionieren(new Matsch());
        neuesObjektZufaelligPositionieren(new Matsch());
        neuesObjektZufaelligPositionieren(new Schwein());
        neuesObjektZufaelligPositionieren(new Schwein());
        neuesObjektZufaelligPositionieren(new Schwein());
        neuesObjektZufaelligPositionieren(new Schwein());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        neuesObjektZufaelligPositionieren(new Gras());
        GrasAnzahl = 10;
    }

    public void neuesObjektZufaelligPositionieren(Actor actor)
    {
        addObject(actor, Greenfoot.getRandomNumber(getWidth()),
                Greenfoot.getRandomNumber(getHeight() - 50));
    }
}
