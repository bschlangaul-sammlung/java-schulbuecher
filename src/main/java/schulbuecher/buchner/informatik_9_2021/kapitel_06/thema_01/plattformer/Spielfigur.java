package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_01.plattformer;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Spielfigur <br>
 * Kap. 6.1 Arbeitsaufträge 1 und 2, Aufgabe 1
 */
public class Spielfigur extends Actor
{
    int geschwindigkeit;

    int anzahlSpruenge;

    Spielfigur() // initialisiert die Attribute
    {
        geschwindigkeit = 1;
        anzahlSpruenge = 0;
    }

    public void act()
    {
        // A1 b)
        if (istBlockiert() == false)
        {
            move(geschwindigkeit);
        }
        if (Greenfoot.isKeyDown("space"))
        {
            springe();
        }
        if (getX() >= 870)
        {
            spielGewonnen();
        }
        if (getY() >= 190)
        {
            spielVerloren();
        }
        if (beruehrtBoden() == false)
        {
            falle();
        }
    }

    // A2
    String generiereVerlorenText() // liefert den Text, der bei verlorenen Spiel
                                   // angezeigt werden
                                   // soll
    {
        String text;
        if (anzahlSpruenge <= 3)
        {
            text = "Du  musst noch etwas üben!!";
        }
        else
        {
            text = "Das ist doch schon ganz gut!";
        }
        return text;
    }
    /*
     * // Aufgabe 2 // Hier die Auskommentierung entfernen, dafür die Methode zu
     * A2 auskommentioeren. String generiereVerlorenText() { String text; if
     * (anzahlSpruenge <= 3) { text = "Du musst noch etwas üben!"; } else { text
     * = "Das ist doch schon ganz gut!"; } return text; }
     */

    void spielVerloren() // zeigt einen Text an, wenn das Spiel verloren wurde,
                         // und beendet das
                         // Programm
    {
        String text = generiereVerlorenText();
        zeigeText(text);
        Greenfoot.stop();
    }

    void falle()
    {
        if (beruehrtAuftrieb() == true)
        {
            bewegeNachOben();
        }
        else
        {
            bewegeNachUnten();
        }
    }
    /*
     * Die folgenden, fertig programmierten Methoden können zur Lösung der
     * Arbeitsaufträge und Aufgaben verwendet werden. Dazu ist es nicht nötig
     * ihre genaue Arbeitsweise zu verstehen.
     */

    void bewegeNachOben() // bewegt die Spielfigur um eine Zelle nach oben
    {
        setRotation(270);
        move(1);
        setRotation(0);
    }

    void bewegeNachUnten() // bewegt die Spielfigur um eine Zelle nach unten
    {
        setRotation(90);
        move(1);
        setRotation(0);
    }

    void spielGewonnen() // zeigt den Text "Gewonnen!" an und stoppt das
                         // Programm
    {
        getWorld().showText("Gewonnen!", 500, 10);
        Greenfoot.stop();
    }

    void zeigeText(String text) // zeigt den Wert des Parameters text an
    {
        getWorld().showText(text, 500, 10);
    }

    void springe() // sorgt dafür, dass die Spielfigur springt
    {
        if (beruehrtBoden() == true)
        {
            setRotation(270);
            move(40);
            setRotation(0);
            anzahlSpruenge = anzahlSpruenge + 1;
        }
    }

    boolean beruehrtAuftrieb() // liefert true, wenn die Spielfigur eine
                               // Auftriebszone berührt
    {
        return isTouching(Auftriebzone.class);
    }

    boolean istBlockiert() // liefert true, wenn sich die Spielfigur nicht mehr
                           // weiter nach rechts
                           // bewegen kann
    {
        return isTouching(Boden.class) && getY() > 155;
    }

    boolean beruehrtBoden() // liefert ture, wenn die Spielfigur den unteren
                            // Rand der Welt berührt
    {
        return isTouching(Boden.class) && getY() <= 155;
    }
}
