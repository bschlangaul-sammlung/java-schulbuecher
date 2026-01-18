package schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_05.caesar_vorlage;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

/**
 * Projekt 3-5_Caesar
 *
 * @author André Greubel
 *
 * @version 2022-09-21
 */
public class BuchstabenAnzeige extends Actor
{
    char aktuellerBuchstabe;

    private char ausgabeBuchstabe;

    Verschluesselung v = new Verschluesselung();

    SchluesselAnzeige s;

    public BuchstabenAnzeige(char initBuchstabe, SchluesselAnzeige s)
    {
        this.s = s;
        setBuchstabe(initBuchstabe);
        update();
    }

    public void setBuchstabe(char newBuchstabe)
    {
        aktuellerBuchstabe = newBuchstabe;
        update();
    }

    public void update()
    {
        ausgabeBuchstabe = v.codiereBuchstabe(aktuellerBuchstabe,
                s.gibSchluessel());
        setImage(createImage());
    }

    private GreenfootImage createImage()
    {
        GreenfootImage img = new GreenfootImage(50, 150);
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, 50, 50);
        img.fillRect(0, 100, 50, 50);
        img.setFont(new Font("Courier", false, false, 40));
        img.setColor(Color.RED);
        img.drawString(aktuellerBuchstabe + "", 10, 40);
        img.drawString(ausgabeBuchstabe + "", 10, 140);
        img.setColor(Color.GRAY);
        img.drawLine(25, 60, 25, 90);
        img.fillPolygon(new int[] { 20, 30, 25 }, new int[] { 80, 80, 95 }, 3);
        return img;
    }
}
