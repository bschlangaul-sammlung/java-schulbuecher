package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_03.aufgabe_03.arzt;

/**
 * Klasse zur Verwaltung von Autos für eine Waschstraße
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Buerger implements Datenelement
{
    /**
     * der Name
     */
    private String name;

    /**
     * die Dienstleistung
     */
    private String dienstleistung;

    /**
     * Konstruktor für Objekte der Klasse Bürger
     */
    Buerger(String nameNeu, String dienstleistungNeu)
    {
        name = nameNeu;
        dienstleistung = dienstleistungNeu;
    }

    /**
     * Gibt Information über den Bürger aus.
     */
    public void InformationAusgeben()
    {
        System.out
                .println("Name: " + name + "Dienstleistung:" + dienstleistung);
    }

    /**
     * Gibt den Namen zurück
     *
     * @return Name
     */
    String NameGeben()
    {
        return name;
    }

}
