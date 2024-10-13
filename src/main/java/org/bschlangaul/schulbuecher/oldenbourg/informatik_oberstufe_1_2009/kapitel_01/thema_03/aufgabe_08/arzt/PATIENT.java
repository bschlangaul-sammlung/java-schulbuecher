package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_08.arzt;

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
     * Name des Arztes
     */
    private String arzt;

    /**
     * Konstruktor des Patienten
     *
     * @param p Name des Patienten
     */
    PATIENT(String p, String a)
    {
        name = p;
        arzt = a;
    }

    /**
     * Gibt Information über den Patienten aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Gibt den Namen aus
     *
     * @return Name des Patienten
     */
    public String NameGeben()
    {
        return name;
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DATENELEMENT dvergleich)
    {
        PATIENT p = (PATIENT) dvergleich;
        if (name.compareTo(p.NameGeben()) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels (Arzt)
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        if ((arzt == s) || (arzt == ""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
