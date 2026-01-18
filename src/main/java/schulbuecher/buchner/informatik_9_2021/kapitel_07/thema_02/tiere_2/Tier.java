package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_2;

import greenfoot.Actor;

/**
 * Klasse Tier <br>
 *
 * Kap. 7.1 Arbeitsauftrag 1, 2 und 3
 */
public class Tier extends Actor
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
        String text = "Ich bin ein " + art + " und fresse " + futter + ".";
        DrawingUtil.showText(this, text, 300);
    }

    void bewegeNachRechts() // A3 a)
    {
        if (istRechtsWasser() == false)
        {
            if (istRechtsStein() == false)
            {
                setLocation(getX() + 1, getY());
            }
        }
    }

    public void act()
    {
        // A3b)
        bewegeNachRechts();
    }

    /*
     * Diese Methoden können zur Lösung der Arbeitsaufträge und Aufgaben
     * verwendet werden.
     */
    boolean istZelleRechtsFrei() // liefert true, wenn sich in der Zelle rechts
                                 // neben dem Objekt
                                 // kein weiteres Objekt befindet
    {
        return !(istRechtsWasser() || istRechtsGras() || istRechtsStein());
    }

    boolean istRechtsWasser() // liefert true, wenn sich in der Zelle rechts
                              // neben dem Objekt ein
                              // Wasser-Objekt befindet
    {
        return istRechtsObject(Wasser.class);
    }

    boolean istRechtsGras() // liefert true, wenn sich in der Zelle rechts neben
                            // dem Objekt ein
                            // Gras-Objekt befindet
    {
        return istRechtsObject(Gras.class);
    }

    boolean istRechtsStein() // liefert true, wenn sich in der Zelle rechts
                             // neben dem Objekt ein
                             // Stein-Objekt befindet
    {
        return istRechtsObject(Stein.class);
    }

    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    private <T> boolean istRechtsObject(Class<T> objectClass)
    {
        return getWorld().getObjectsAt(getX() + 1, getY(), objectClass)
                .size() > 0;
    }
}
