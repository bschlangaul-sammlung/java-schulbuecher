package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_01.plattformer_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Klasse Spielfigur
 */
public class Spielfigur extends Actor
{
    int geschwindigkeit;

    /**
     * Initialisiert die Attribute
     */
    Spielfigur()
    {
        geschwindigkeit = 1;
    }

    public void act()
    {
        // 2. (a)
        move(geschwindigkeit); // 1. (a)
        // 2. (b)
        // 2. (c)
        if (getY() >= 190) // 1. (b)
        {
            spielVerloren();
        }
        if (beruehrtBoden() == false) // 1. (c)
        {
            falle();
        }
    }

    /**
     * Liefert den Text, der bei verlorenen Spiel angezeigt werden soll.
     */
    String generiereVerlorenText()
    {
        // 3.
        String text;
        text = "Leider verloren!";
        return text;
    }

    /**
     * Zeigt einen Text an, wenn das Spiel verloren wurde, und beendet das
     * Programm.
     */
    void spielVerloren()
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

    /**
     * Die folgenden, fertig programmierten Methoden können zur Lösung der
     * Arbeitsaufträge und Aufgaben verwendet werden. Dazu ist es nicht nötig
     * ihre genaue Arbeitsweise zu verstehen.
     * <p>
     * bewegt die Spielfigur um eine Zelle nach oben
     */
    void bewegeNachOben()
    {
        setRotation(270);
        move(1);
        setRotation(0);
    }

    /**
     * Bewegt die Spielfigur um eine Zelle nach unten.
     */
    void bewegeNachUnten()
    {
        setRotation(90);
        move(1);
        setRotation(0);
    }

    /**
     * Zeigt den Text "Gewonnen!" an und stoppt das Programm.
     */
    void spielGewonnen()
    {
        getWorld().showText("Gewonnen!", 500, 10);
        Greenfoot.stop();
    }

    /**
     * Zeigt den Wert des Parameters text an.
     */
    void zeigeText(String text)
    {
        getWorld().showText(text, 500, 10);
    }

    /**
     * sorgt dafür, dass die Spielfigur springt
     */
    void springe()
    {
        if (beruehrtBoden() == true)
        {
            setRotation(270);
            move(40);
            setRotation(0);
        }
    }

    /**
     * Liefert true, wenn die Spielfigur eine Auftriebszone berührt
     */
    boolean beruehrtAuftrieb()
    {
        return isTouching(Auftriebzone.class);
    }

    /**
     * Liefert true, wenn sich die Spielfigur nicht mehr weiter nach rechts
     * bewegen kann.
     */
    boolean istBlockiert()
    {
        return isTouching(Boden.class) && getY() > 155;
    }

    /**
     * Liefert true, wenn die Spielfigur den unteren Rand der Welt berührt.
     */
    boolean beruehrtBoden()
    {
        return isTouching(Boden.class) && getY() <= 155;
    }
}
