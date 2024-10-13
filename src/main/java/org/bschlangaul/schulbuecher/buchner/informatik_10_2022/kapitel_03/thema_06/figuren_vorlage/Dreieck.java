package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_06.figuren_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class Dreieck here.
 *
 * @author Anja Stube
 *
 * @version 05-05-2021
 */
public class Dreieck extends Figur
{
    int laengeA, laengeB, laengeC;

    GreenfootImage n;

    public void act()
    {
        // Add your action code here.
    }

    Dreieck()
    {
        laengeA = 10;
        laengeB = 20;
        laengeC = 15;
        n = new GreenfootImage(100, 100);
        n.setColor(Color.RED);
        // n.drawPolygon( ;
        setImage(n);
    }

    void setzeA(int a)
    {
        laengeA = a;
    }

    void setzeB(int b)
    {
        laengeB = b;
    }

    void setzeC(int c)
    {
        laengeC = c;
    }

    int UmfangBerechnen()
    {
        return laengeA + laengeB + laengeC;
    }

    double flaecheninhaltBerechnen()
    {
        return 0.5 * laengeA * hoeheBerechnen();
    }
    // Der Programmtext ab hier muss weder gelesen noch verstanden werden.

    private double hoeheBerechnen()
    {
        double s = 0.5 * (laengeA + laengeB + laengeC);
        return Math.sqrt(s * (s - laengeA) * (s - laengeB) * (s - laengeC));
    }
}
