package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.schatzsuche_aufgabe_8;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

/**
 * Klasse Anzeige <br>
 *
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Anzeige extends Actor
{
    GreenfootImage bild = new GreenfootImage(180, 200);

    int zeit;

    int goldstuecke;

    Anzeige()
    {
        setImage(bild);
        bild.setColor(Color.WHITE);
        bild.setFont(new Font(22));
        bild.drawRect(0, 0, bild.getWidth() - 1, bild.getHeight() - 1);
    }

    void zeigeText()
    {
        bild.clear();
        String text = "Zeit            : " + Integer.toString(zeit)
                + gibLineSeparator() + "Goldstücke: "
                + Integer.toString(goldstuecke);
        bild.drawString(text, 15, 150);
    }

    void zeigeZeitAbgelaufen()
    {
        bild.clear();
        String text = "Die Zeit ist" + gibLineSeparator() + "abgelaufen!";
        bild.drawString(text, 15, 150);
    }

    void zeigeLob(String lob1, String lob2)
    {
        bild.clear();
        String text = lob1 + gibLineSeparator() + lob2;
        bild.drawString(text, 15, 150);
    }

    void setzeGoldstuecke(int g)
    {
        goldstuecke = g;
        zeigeText();
    }

    void setzeZeit(int z)
    {
        zeit = z;
        zeigeText();
    }

    String gibLineSeparator()
    {
        return System.getProperty("line.separator");
    }
}
