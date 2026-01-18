package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_15.klassenliste;

/**
 * Klasse zur Verwaltung eines Schülers
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Schueler implements Datenelement
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
     * Gibt Information zurück
     */
    public String InformationGeben()
    {
        return nachname + "   " + vorname;
    }

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement dvergleich)
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
     *
     * @param gesuchterWert gesuchter Name (Nachname und Vorname)
     *
     * @return wahr, wenn der Name übereinstimmt
     */
    public boolean SchlüsselIstGleich(String gesuchterWert)
    {
        return (gesuchterWert.compareTo(nachname + " " + vorname) == 0);
    }
}
