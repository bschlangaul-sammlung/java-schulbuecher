package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.bildanzeige;

/**
 * Beschreibung der Klasse Bild
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Bild
{
    /** Dateiname */
    private String name;

    /** Verwaltung des nachfolgenden Bildes in der Warteschlange. */
    private Bild nachfolger;

    /**
     * Konstruktor des Bildes
     *
     * @param s Name des Bildes
     */
    Bild(String s)
    {
        nachfolger = null;
        name = "Bilder/" + s;
    }

    /**
     * Nachfolger des Bildes setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(Bild nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Bildes zurück.
     *
     * @return Nachfolger
     */
    Bild NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt Information über das Bild aus.
     */
    void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Bildes aus
     *
     * @return Name des Bildes
     */
    String NameGeben()
    {
        return name;
    }
}
