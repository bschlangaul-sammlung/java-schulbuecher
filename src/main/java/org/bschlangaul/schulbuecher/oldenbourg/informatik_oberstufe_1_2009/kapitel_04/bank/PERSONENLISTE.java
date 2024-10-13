package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Verwaltet Listen von PERSONEN.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class PERSONENLISTE
{
    private LISTENELEMENTP start;

    /**
     * Erzeugt eine leere Liste
     */
    PERSONENLISTE()
    {
        start = new BLATTP();
    }

    /**
     * Fügt die angegebene Person in die Liste ein.
     *
     * @param person die einzufügende Person.
     */
    void Einfuegen(PERSON person)
    {
        start = start.Einfuegen(person);
    }

    /**
     * Sucht die PErson mit dem angegebenen Namen.
     *
     * @param name der Name der zu suchenden Person
     *
     * @return Referenz auf die Person oder null.
     */
    PERSON Suchen(String name)
    {
        return start.Suchen(name);
    }

    /**
     * Löscht die angegebene Person aus der Liste.
     *
     * @param person die zu löschende Person.
     */
    void Loeschen(PERSON person)
    {
        if (person != null)
        {
            start = start.Loeschen(person);
        }
    }

    /**
     * Meldet die Namen aller Pesonen in der Liste.
     *
     * @param derNicht diese Person kommt nicht in die Liste.
     *
     * @return Feld mit den Namen der Personen.
     */
    String[] PersonennamenGeben(PERSON derNicht)
    {
        String[] resultat;
        int anzahl;
        anzahl = start.Zaehlen(derNicht.NameGeben());
        resultat = new String[anzahl];
        start.NamenEintragen(derNicht.NameGeben(), resultat, 0);
        return resultat;
    }
}
