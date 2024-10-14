package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_03.bestellsystem;

/**
 * Klasse zur Beschreibung eines Speisekarteneintrags
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Speisekarteneintrag
{
    /**
     * Name des Artikels
     */
    private String name;

    /**
     * Preis des Artikels
     */
    private double preis;

    /**
     * Konstruktor für Objekte der Klasse Speisekarteneintrag
     *
     * @param nameNeu Name des Eintrags
     * @param preisNeu Preis des Eintrags
     */
    Speisekarteneintrag(String nameNeu, double preisNeu)
    {
        name = nameNeu;
        preis = preisNeu;
    }

    /**
     * Methode zur Rückgabe des Namens
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

    /**
     * Methode zur Rückgabe des Preises
     *
     * @return Preis
     */
    double PreisGeben()
    {
        return preis;
    }
}
