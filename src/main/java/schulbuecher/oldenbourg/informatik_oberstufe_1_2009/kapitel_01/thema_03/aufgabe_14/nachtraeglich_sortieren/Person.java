package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_14.nachtraeglich_sortieren;

/**
 * Verwaltung einer Person
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Person implements DatenElement
{
    private String name;

    Person(String nneu)
    {
        name = nneu;
    }

    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    public void InformationAusgeben()
    {
        System.out.println(name);
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        Person pvergleich;
        pvergleich = (Person) dvergleich;
        return name.compareTo(pvergleich.name) < 0;
    }

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s)
    {
        return name.compareTo(s) == 0;
    }
}
