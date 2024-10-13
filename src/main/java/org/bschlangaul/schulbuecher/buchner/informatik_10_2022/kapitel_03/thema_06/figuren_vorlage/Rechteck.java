package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_06.figuren_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rechteck here.
 *
 * @author Anja Stube
 *
 * @version 05-05-2021
 */
public class Rechteck extends Figur
{
    int laengeA, laengeB;

    GreenfootImage n;

    public void act()
    {
        this.move(10);
        this.getImage().rotate(45);
    }

    Rechteck()
    {
        laengeA = 20;
        laengeB = 30;
        n = new GreenfootImage(100, 200);
        n.setColor(Color.RED);
        n.drawRect(7, 0, laengeA, laengeB);
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

    int UmfangBerechnen()
    {
        return 2 * (laengeA + laengeB);
    }

    double flaecheninhaltBerechnen()
    {
        return laengeA * laengeB;
    }
}
