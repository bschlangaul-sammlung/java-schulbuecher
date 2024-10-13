package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_08.hotel_vorlage;

import greenfoot.*;

/**
 * Projekt 3-8_Hotel
 *
 * @author Wolfgang Riffelmacher
 *
 * @version 2022-09-12
 */
public class Angestellter extends Actor
{
    private String name;

    private String rolle;

    public Angestellter(String name, String rolle)
    {
        this.name = name;
        this.rolle = rolle;
    }

    public void setzeName(String nameNeu)
    {
        name = nameNeu;
    }

    public String nenneName()
    {
        return name;
    }

    public void setzeRolle(String rolleNeu)
    {
        rolle = rolleNeu;
    }

    public String nenneRolle()
    {
        return rolle;
    }
}
