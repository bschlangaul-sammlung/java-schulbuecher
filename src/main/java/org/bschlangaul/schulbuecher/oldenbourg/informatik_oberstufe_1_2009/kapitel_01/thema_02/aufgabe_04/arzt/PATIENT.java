package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.arzt;

/**
 * Beschreibung der Klasse PATIENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class PATIENT implements DATENELEMENT
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
    PATIENT(String s)
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
}
