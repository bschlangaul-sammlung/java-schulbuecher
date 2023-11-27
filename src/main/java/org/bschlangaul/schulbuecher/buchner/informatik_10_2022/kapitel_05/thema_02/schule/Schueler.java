package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_02.schule;

/**
 * Klasse zur Darstellung eines Schülers mit Name und Alter
 */
public class Schueler
{
    private String name;

    private int alter;

    public Schueler(String name)
    {
        this.name = name;
        this.alter = alter;
    }

    public Schueler(String name, int alter)
    {
        this.name = name;
        this.alter = alter;
    }

    /**
     * Methode zur Rückgabe des Namens
     *
     * @return Name des Schülers
     */
    public String nenneName()
    {
        return name;
    }
}
