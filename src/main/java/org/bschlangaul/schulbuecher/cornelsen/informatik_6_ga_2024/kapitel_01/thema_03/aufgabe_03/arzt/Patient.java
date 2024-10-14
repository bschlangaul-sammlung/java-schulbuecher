package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_03.arzt;

/**
 * Beschreibung der Klasse Patient
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Patient implements Datenelement
{
    /**
     * Name des Patienten
     */
    private String name;

    /**
     * Konstruktor des Patienten
     *
     * @param s Name des Patienten
     */
    Patient(String s)
    {
        name = s;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Patienten aus
     *
     * @return Name des Patienten
     */
    String NameGeben()
    {
        return name;
    }
}
