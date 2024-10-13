package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.musikschule_vorlage;

/**
 * Projekt 5-10_Musikschule (ÜuV Aufgabe 14)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Instrument
{
    String name;

    public Instrument(String name)
    {
        this.name = name;
    }

    public String nenneInstrument()
    {
        return this.name;
    }
}
