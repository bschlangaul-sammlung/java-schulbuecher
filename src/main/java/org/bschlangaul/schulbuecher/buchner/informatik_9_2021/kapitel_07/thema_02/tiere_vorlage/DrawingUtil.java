package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_vorlage;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

/**
 * Klasse DrawingUtil <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class DrawingUtil
{
    private static final java.awt.Color BACKGROUND = java.awt.Color.LIGHT_GRAY;

    private static final java.awt.Color FOREGROUND = java.awt.Color.BLACK;

    private List<String> lines;

    private int maxWidthLine = 0;

    private java.awt.Font font;

    private FontMetrics fm;

    private final int maxWidth;

    private final String text;

    private boolean inited = false;

    private Actor actor;

    private Actor pseudoActor;

    public DrawingUtil(String text, int maxWidth)
    {
        this.maxWidth = maxWidth;
        this.text = text;
    }

    private void ensureInit(Actor actor)
    {
        if (inited)
        {
            return;
        }
        this.actor = actor;
        // nothing to see here...
        if (actor.getWorld() == null)
        {
            System.err.println(
                    "Cannot draw Bubble for Actor that is not in the world!");
            return;
        }
        font = actor.getWorld().getBackground().getAwtImage().getGraphics()
                .getFont();
        fm = actor.getWorld().getBackground().getAwtImage().createGraphics()
                .getFontMetrics(font);
        initLines(text);
        pseudoActor = new Actor()
        {
        };
        pseudoActor.setImage(createImage());
        inited = true;
    }

    private void initLines(String text)
    {
        lines = new ArrayList<>();
        Queue<String> remaining = new LinkedList<>(
                Arrays.asList(text.split("\\s")));
        String buf = "";
        while (remaining.size() > 0)
        {
            String testNext = buf + " " + remaining.peek();
            int width = fm.stringWidth(testNext);
            if (width > maxWidth)
            {
                lines.add(buf.strip());
                buf = remaining.poll();
            }
            else
            {
                buf += " " + remaining.poll();
            }
        }
        if (buf.isEmpty() == false)
        {
            lines.add(buf);
        }
        for (String line : lines)
        {
            int lineWidth = fm.stringWidth(line);
            if (lineWidth > maxWidthLine)
            {
                maxWidthLine = lineWidth;
            }
        }
        maxWidthLine += fm.getHeight() * 2;
    }

    private GreenfootImage createImage()
    {
        int acHeight = (int) (fm.getHeight() * (lines.size() + 0.5));
        GreenfootImage img = new GreenfootImage(maxWidthLine, acHeight);
        Graphics2D g = (Graphics2D) img.getAwtImage().getGraphics();
        g.setColor(BACKGROUND);
        g.setFont(font);
        g.fillRoundRect(0, 0, maxWidthLine, acHeight, 15, 15);
        int yPos = fm.getHeight();
        g.setColor(FOREGROUND);
        for (String line : lines)
        {
            int actualX = maxWidthLine / 2 - fm.stringWidth(line) / 2;
            g.drawString(line, actualX, yPos);
            yPos += fm.getHeight();
        }
        return img;
    }

    public void show(Actor actor)
    {
        ensureInit(actor);
        actor.getWorld().removeObject(pseudoActor);
        int x = actor.getX();
        int y = actor.getY() - pseudoActor.getImage().getHeight() / 2
                - actor.getImage().getHeight() / 2;
        actor.getWorld().addObject(pseudoActor, x, y);
    }

    public void hide()
    {
        if (actor == null || actor.getWorld() == null)
        {
            return;
        }
        actor.getWorld().removeObject(pseudoActor);
    }

    public static DrawingUtil showText(Actor actor, String text, int maxWidth)
    {
        DrawingUtil du = new DrawingUtil(text, maxWidth);
        du.show(actor);
        return du;
    }
}
