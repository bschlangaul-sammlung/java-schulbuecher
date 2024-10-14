package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_12.bildanzeige;

/**
 * Beschreibung der Klasse Bild
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Bild implements Datenelement
{
    /**
     * Dateiname
     */
    private String name;

    /**
     * Konstruktor des Bildes
     *
     * @param s Name des Bildes
     */
    Bild(String s)
    {
        name = "Bilder/" + s;
    }

    /**
     * Gibt Information über das Bild aus.
     */
    public void InformationAusgeben()
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

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param d Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(Datenelement d)
    {
        return name.compareTo(((Bild) d).name) < 0;
    }

    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     *
     * @param s gesuchter Wert
     *
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist.
     */
    public boolean SchlüsselIstGleich(String s)
    {
        return name == s;
    }
}
