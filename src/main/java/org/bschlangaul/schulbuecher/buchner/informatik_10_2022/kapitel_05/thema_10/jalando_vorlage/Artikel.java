package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.jalando_vorlage;

/**
 * Klasse zur Darstellung eines Artikels
 */
@SuppressWarnings("unused")
public class Artikel
{
    private String name;

    private double preis;

    public Artikel(String name, double preis)
    {
        this.name = name;
        this.preis = preis;
    }
}
