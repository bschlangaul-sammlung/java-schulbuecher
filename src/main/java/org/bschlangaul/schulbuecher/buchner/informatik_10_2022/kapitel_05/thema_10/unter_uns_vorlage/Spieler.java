package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.unter_uns_vorlage;

import java.util.Random;

/**
 * Projekt 5-10_UnterUns (ÜüV Aufgabe 17)
 * <p>
 * Klasse zur Darstellung eines Spielers, der entweder Besatzungsmitglied, oder
 * Verräter ist
 *
 * @author Verena Haller
 *
 * @version 2022-09-12
 */
// Diese Klasse übersetzt nach Download nicht. Das ist gewollt, vgl. Aufgabe 17a!
@SuppressWarnings("unused")
public class Spieler
{
    private String name;

    private String farbe;

    private boolean verraeter;

    private Aufgabe[] aufgaben;

    public Spieler(String name, String farbe)
    {
        this.name = name;
        this.farbe = farbe;
        this.aufgaben = new Aufgabe[5];
    }

    public void setzeVerraeter()
    {
        verraeter = true;
    }

    public void weiseAufgabenZu()
    {
        Random zufall = new Random();
        for (int i = 0; i < aufgaben.length; i++)
        {
            aufgaben[i] = new Aufgabe(gibZufallszahl(10), gibZufallszahl(100));
        }
    }

    public static int gibZufallszahl(int max)
    {
        Random zufall = new Random();
        return zufall.nextInt(max);
    }
}
