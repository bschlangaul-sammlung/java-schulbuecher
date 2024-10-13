package org.bschlangaul.schulbuecher.buchner.informatik_11_2023.kapitel_04.thema_03.qr_code;

import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

public class Output extends Actor
{
    GreenfootImage image;

    Color background = new Color(255, 100, 0, 0);

    Font font = new Font("Courier New", true, false, 12);

    String actualText = "";

    int linesize = 89;

    int fontsize = 18;

    int lines = 8;

    Output(String text)
    {
        image = new GreenfootImage(linesize * 10, lines * (fontsize + 2));
        setText(text);
    }

    public void act()
    {
    }

    public void setText(String text)
    {
        image.clear();
        image.setFont(font);
        // image.drawImage(new GreenfootImage(cutText(text), fontsize,
        // Color.BLACK, background),0,0);
        actualText = cutText(text);
        image.drawString(actualText, 0, 12);
        setImage(image);
    }

    public void addText(String text)
    {
        image.clear();
        image.setFont(font);
        // image.drawImage(new GreenfootImage(cutText(text), fontsize,
        // Color.BLACK, background),0,0);
        actualText += cutText(text);
        image.drawString(actualText, 0, 12);
        setImage(image);
    }

    private String cutText(String text)
    {
        String output = "";
        int i = 0;
        int charPerLine = 0;
        while (i < text.length())
        {
            if (text.substring(i, i + 1).equals("\n") && i != text.length() - 1)
            {
                for (int j = charPerLine + 2; j < linesize; j++)
                    output += " ";
                output += "\n";
                charPerLine = 0;
                i++;
            }
            output += text.charAt(i);
            i++;
            charPerLine++;
            if (charPerLine > linesize)
            {
                output += "\n";
                charPerLine = 0;
            }
        }
        for (int j = charPerLine + 2; j < linesize; j++)
            output += " ";
        output += "\n";
        // debug
        // System.out.println(output);
        return output;
    }
}
