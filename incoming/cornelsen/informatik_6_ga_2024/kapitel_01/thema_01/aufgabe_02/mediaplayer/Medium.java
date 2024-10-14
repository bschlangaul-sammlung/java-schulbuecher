package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_01.aufgabe_02.mediaplayer;

/**
 * Beschreibung der Klasse Medium
 *
 * @author Klaus Reinold
 * @version 0.9
 */
 class Medium
{
    /**
     * Dateiname */
    private String name;

    /**
     * Verwaltung des nachfolgenden Mediums in der Warteschlange. */
    private Medium nachfolger;

    /**
    * Konstruktor des Mediums
    * @param s Name des Mediums
    */
     Medium(String s)
    {
        name = "media/"+s;
    }

    /**
    * Nachfolger des Mediums setzen
    * @param nf neuer Nachfolger
    */
     void NachfolgerSetzen(Medium nf)
    {
        nachfolger = nf;
    }

     /**
     * Gibt den Nachfolger des Mediums zurück.
     * @return Nachfolger
     */
     Medium NachfolgerGeben()
    {
        return nachfolger;
    }

     /**
     * Gibt Information über das Medium aus.
     */
     void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen des Mediums zurück
     * @return Name des Mediums
     */
     String NameGeben()
    {
        return name;
    }
}
