package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.arzt;

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

    /**
     * Gibt den Namen aus
     *
     * @return Name des Patienten
     */
    private String NameGeben()
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
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        if (name == s)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
