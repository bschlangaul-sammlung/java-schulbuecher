package schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Button extends Actor
{
    private GreenfootImage button_1, button_2, button_3;

    private int nr;

    private boolean mouseDown, mouseHold;

    private MyWorld thisWorld;

    private boolean hold = false;

    private boolean picchange = false;

    private boolean on = false;

    private String image1;

    public Button(String _image1, int _nr, MyWorld _thisWorld)
    {
        image1 = _image1;
        button_1 = new GreenfootImage(image1 + ".png");
        button_2 = new GreenfootImage(image1 + "b.png");
        thisWorld = _thisWorld;
        setImage(button_1);
        mouseDown = false;
        nr = _nr;
    }

    public Button(String _image1, int _nr, MyWorld _thisWorld, boolean _hold)
    {
        image1 = _image1;
        button_1 = new GreenfootImage(image1 + ".png");
        button_2 = new GreenfootImage(image1 + "b.png");
        thisWorld = _thisWorld;
        setImage(button_1);
        mouseDown = false;
        nr = _nr;
        hold = _hold;
    }

    public void activedChange()
    {
        picchange = true;
        button_3 = new GreenfootImage(image1 + "c.png");
    }

    public void resetButton()
    {
        if (picchange)
        {
            on = false;
            setImage(button_1);
        }
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            mouseDown = true;
            setImage(button_2);
            if (picchange)
                on = !on;
            if (!hold)
                thisWorld.actionButton(nr);
        }
        else if (Greenfoot.mousePressed(this) && hold)
        {
            mouseHold = true;
            setImage(button_2);
        }
        else if (mouseDown)
        {
            mouseDown = false;
            mouseHold = false;
            if (!on)
                setImage(button_1);
            else
                setImage(button_3);
        }
        else if (mouseHold)
        {
            thisWorld.actionButton(nr);
        }
    }
}
