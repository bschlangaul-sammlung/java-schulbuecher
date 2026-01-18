package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_06.kunst_a1b;

import greenfoot.GreenfootImage;
import greenfoot.World;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 *
 * @version (a version number or a date)
 */
public class Kunstwelt extends World
{
    public Kunstwelt()
    {
        super(9, 9, 50);
        Zelle.zaehler = 0;
        erstelleKunstwerk();
    }

    public void erstelleKunstwerk()
    {
        int j = 0;
        for (int i = 0; i < 9; i = i + 1)
        {
            erstelleQuadratAn(i, j);
            j = 1 - j;
        }
    }

    boolean istTeilbarDurch(int a, int b)
    {
        return a % b == 0;
    }

    private void erstelleQuadratAn(int x, int y)
    {
        Zelle zelle = new Zelle();
        addObject(zelle, x, y);
        zelle.erstelleBild();
    }

    public void speichereAufFestplatte(String dateiname)
    {
        GreenfootImage img = new GreenfootImage(getBackground());
        for (Zelle zelle : getObjects(Zelle.class))
        {
            img.setColor(zelle.berechneFarbe());
            int x = zelle.getX();
            int y = zelle.getY();
            System.out.println("pos: (" + x + "|" + y + "), color: "
                    + zelle.berechneFarbe());
            img.fillRect(x * getCellSize(), y * getCellSize(), getCellSize(),
                    getCellSize());
        }
        try
        {
            ImageIO.write(img.getAwtImage(), "PNG",
                    new File(dateiname + ".png"));
        }
        catch (Exception e)
        {
            System.err.println(
                    "Bildname '" + dateiname + ".png ist nicht gültig!");
        }
        // img.getAwtImage()
    }
}
