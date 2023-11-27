package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_a.arzt;

/**
 * Beschreibung der Klasse PATIENT
 */
class PATIENT
{
    /** Name des Patienten */
    private String name;

    /** Verwaltung des nachfolgenden Patienten in der Warteschlange. */
    private PATIENT nachfolger;

    /**
     * Konstruktor des Patienten
     */
    PATIENT(String s)
    {
        name = s;
    }

    /**
     * Nachfolger des Patienten setzen
     *
     * @param nf neuer Nachfolger
     */
    void NachfolgerSetzen(PATIENT nf)
    {
        nachfolger = nf;
    }

    /**
     * Gibt den Nachfolger des Patienten aus.
     *
     * @return Nachfolger
     */
    PATIENT NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    void InformationAusgeben()
    {
        System.out.println(name);
    }
}
