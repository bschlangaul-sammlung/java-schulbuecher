package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_03.aufgabe_00.nutzerverwaltung;

/**
 * Die Klasse User dient zur Speicherung von Usern in einem Online-Shop.
 *
 * @author Peter Brichzin
 *
 * @version 23.5.24
 */

class User
{
    /**
     * id - Schlüssel dieses Datenelements
     */
    private int id;

    /**
     * Nachname
     */
    private String nachname;

    /**
     * Vorname
     */
    private String vorname;

    /**
     * Konstruktor für Objekte der Klasse User
     *
     * @param idNeu Identifikationsnummer
     * @param nachnameNeu Nachname
     * @param vornameNeu Vorname
     */
    User(int idNeu, String nachnameNeu, String vornameNeu)
    {
        id = idNeu;
        nachname = nachnameNeu;
        vorname = vornameNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken auf das
     * Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println("Der User " + vorname + " " + nachname
                + " hat die Id " + id + ".");
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     *
     * @param dVergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     *
     *     Hinweis: für den lexikografischen Vergleich wird die Methode
     *     compareTo(String vergleichsZeichenkette) der Klasse String genutzt.
     *     Das Ergebnis ist eine negative ganze Zahl, wenn das ausführende
     *     Zeichenketten-Objekt lexikografisch vor dem Eingabewert liegt. Das
     *     Ergebnis ist eine positive ganze Zahl, das ausführende
     *     Zeichenketten-Objekt lexikografisch hinter dem Eingabewert liegt. Das
     *     Ergebnis ist 0, wenn die Zeichenketten gleich sind;
     *
     */
    boolean IstGleich(User dVergleich)
    {
        if (nachname.compareTo(dVergleich.NachnameGeben()) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dVergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    boolean IstGrößerAls(User dVergleich)
    {
        if (nachname.compareTo(dVergleich.NachnameGeben()) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf
     * Gleichheit.
     *
     * @param vergleichsSchlüssel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    boolean SchlüsselIstGleich(String vergleichsSchlüssel)
    {
        if (nachname.compareTo(vergleichsSchlüssel) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchlüssel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen grö&szlig;eren Schlüssel
     *     hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel)
    {
        if (nachname.compareTo(vergleichsSchlüssel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Geben-Methode zum Attribut nachname
     *
     * @return Nachname
     */
    String NachnameGeben()
    {
        return nachname;
    }

    /**
     * Geben-Methode zum Attribut vorname
     *
     * @return Vorname
     */
    String VornameGeben()
    {
        return vorname;
    }
}
