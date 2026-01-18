package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_11.klassenliste;

/**
 * Klasse zur Verwaltung eines Schülers
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Schueler implements DatenElement
{
    /**
     * Nachname
     */
    private String nachname;

    /**
     * Vorname
     */
    private String vorname;

    /**
     * Konstruktor
     *
     * @param n Nachname
     * @param v Vorname
     */
    Schueler(String n, String v)
    {
        NachnameSetzen(n);
        VornameSetzen(v);
    }

    /**
     * Setzt den Nachnamen auf den übergebenen Wert.
     *
     * @param n neuer Nachname
     */
    void NachnameSetzen(String n)
    {
        nachname = n;
    }

    /**
     * Setzt den Vornamen auf den übergebenen Wert.
     *
     * @param v neuer Vorname
     */
    void VornameSetzen(String v)
    {
        vorname = v;
    }

    /**
     * Gibt Information auf der Konsole aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(nachname + "   " + vorname);
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        Schueler svergleich = (Schueler) dvergleich;
        if ((nachname.compareTo(svergleich.nachname) < 0)
                || ((nachname.compareTo(svergleich.nachname) == 0)
                        && (vorname.compareTo(svergleich.vorname) < 0)))
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
     */
    public boolean SchluesselIstGleich(String s)
    {
        return (s.compareTo(nachname + " " + vorname) == 0);
    }
}
