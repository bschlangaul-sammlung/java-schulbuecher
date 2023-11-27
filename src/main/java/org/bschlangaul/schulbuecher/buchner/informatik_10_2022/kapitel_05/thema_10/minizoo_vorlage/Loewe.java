package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.minizoo_vorlage;

/**
 * Klasse zur Darstellung eines Löwen
 */
public class Loewe
{
    private String name;

    private char geschlecht;

    private boolean hungrig;

    public Loewe(String n, char g)
    {
        name = n;
        geschlecht = g;
    }

    public void fuettern()
    {
        hungrig = false;
    }
}
