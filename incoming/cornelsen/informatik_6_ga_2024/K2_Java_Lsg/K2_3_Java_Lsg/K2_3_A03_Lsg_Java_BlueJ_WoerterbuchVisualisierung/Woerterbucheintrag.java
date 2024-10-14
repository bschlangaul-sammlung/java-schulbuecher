/**
 * Die Klasse Woerterbucheintrag dient zur Speicherung von
 * Wörterbucheinträgen für ein Englisch-Deutsches
 * Wörterbuch. Dabei kann jedem englischen Wort mehrere
 * deutsche Bedeutungen zugeordnet werden, wobei alle Bedeutungen in
 * einer einzigen Zeichenkette Bedeutung gespeichert werden.
 *
 * @author Peter Brichzin
 * @version 23.05.24
 */
class Woerterbucheintrag
{
    /**
     * Englisches Wort; Schlüssel dieses Datenelements */
    private String wort;
    /**
     * Deutsche Bedeutung; mehrere Bedeutungen werden als eine Zeichenkette zusammengefasst */
    private String bedeutung;

    /**
     * Konstruktor für Objekte der Klasse Woerterbucheintrag
     * @param wortNeu das englische Wort.
     * @param bedeutungNeu die deutsche(n) Bedeutung(en).
     */
    Woerterbucheintrag(String wortNeu, String bedeutungNeu)
    {
        wort = wortNeu;
        bedeutung = bedeutungNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken
     * auf das Terminalfenster aus.
     */
    void InformationAusgeben()
    {
        System.out.println(wort + ": " + bedeutung);
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    boolean IstGleich(Woerterbucheintrag dvergleich)
    {
        if(wort.compareTo(dvergleich.WortGeben()) == 0)
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
     * @param vergleichselement Datenelement mit dem das Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    boolean IstGrößerAls(Woerterbucheintrag dvergleich)
    {
        if(wort.compareTo(dvergleich.WortGeben()) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf Gleichheit.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    boolean SchlüsselIstGleich(String vergleichsSchlüssel)
    {
        if(wort.compareTo(vergleichsSchlüssel) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel)
    {
        if(wort.compareTo(vergleichsSchlüssel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der Ordnungsrelation.
     * @param vergleichsSchluessel Schlüssel  mit dem der Schlüssel des Objekt verglichen wird.
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel
     * hat, als das angegebene Vergleichselement.
     */
    boolean SchlüsselIstKleinerAls(String vergleichsSchlüssel)
    {
        if(wort.compareTo(vergleichsSchlüssel) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gibt den Schlüssel des Datenelements als String aus, auch wenn der Datentyp vom
     * String abweicht. Diese Methode wird beim Entfernen eines Knotens benötigt.
     * @return Schlüssel als String.
     */
    String SchlüsselAlsStringGeben()
    {
        return wort;
    }

    /**
     * Geben-Methode zum Attribut wort
     * @return das englische Wort
     */
    String WortGeben()
    {
        return wort;
    }

    /**
     * Geben-Methode zum Attribut bedeutung
     * @return bedeutung: die deutsche(n) Bedeutung(en) als eine Zeichenkette
     */
    String BedeutungGeben()
    {
        return bedeutung;
    }

    /**
     * Setzen-Methode zum Attribut bedeutung
     * @param bedeutungNeu neue Bedeutung für das englische Wort
     */
    void BedeutungSetzen(String bedeutungNeu)
    {
        bedeutung = bedeutungNeu;
    }
}
