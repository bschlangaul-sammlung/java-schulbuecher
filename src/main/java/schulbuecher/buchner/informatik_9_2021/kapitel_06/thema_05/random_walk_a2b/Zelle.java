package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_05.random_walk_a2b;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class Zelle extends Actor
{
    void erstelleBild()
    {
        int cellSize;
        cellSize = getWorld().getCellSize();
        GreenfootImage img = new GreenfootImage(cellSize, cellSize);
        img.setColor(Color.RED);
        img.fillRect(0, 0, cellSize, cellSize);
        setImage(img);
    }
}
