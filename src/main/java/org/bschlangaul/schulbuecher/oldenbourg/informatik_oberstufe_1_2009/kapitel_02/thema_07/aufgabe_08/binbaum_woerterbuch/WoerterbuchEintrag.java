package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_07.aufgabe_08.binbaum_woerterbuch;

/**
 * Die Klasse WOERTERBUCHEINTRAG dient zur Speicherung von Wörterbucheinträgen
 * für ein Englisch-Deutsches Wörterbuch. Dabei kann jedem englischen Wort
 * mehrere deutsche Bedeutungen zugeordnet werden, wobei alle Bedeutungen in
 * einer einzigen Zeichenkette Bedeutung gespeichert werden.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.07.08)
 */
public class WoerterbuchEintrag implements DatenElement
{
    /**
     * Englisches Wort; Schlüssel dieses Datenelements
     */
    private String wort;

    /**
     * Deutsche Bedeutung; mehrere Bedeutungen werden als eine Zeichenkette
     * zusammengefasst
     */
    private String bedeutung;

    /**
     * Konstruktor für Objekte der Klasse WOERTERBUCHEINTRAG
     *
     * @param wortNeu das englische Wort.
     * @param bedeutungNeu die deutsche(n) Bedeutung(en).
     *
     */
    public WoerterbuchEintrag(String wortNeu, String bedeutungNeu)
    {
        wort = wortNeu;
        bedeutung = bedeutungNeu;
    }

    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken auf das
     * Terminalfenster aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(wort + ": " + bedeutung);
    }

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel hat,
     *     als das angegebene Vergleichselement.
     */
    public boolean IstKleinerAls(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ WOERTERBUCHEINTRAG (WBE) ist
        WoerterbuchEintrag vergleichsWBE;
        vergleichsWBE = (WoerterbuchEintrag) dvergleich;
        if (wort.compareTo(vergleichsWBE.WortGeben()) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    public boolean IstGleich(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ WOERTERBUCHEINTRAG (WBE) ist
        WoerterbuchEintrag vergleichsWBE;
        vergleichsWBE = (WoerterbuchEintrag) dvergleich;
        if (wort == vergleichsWBE.WortGeben())
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
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    public boolean IstGroesserAls(DatenElement dvergleich)
    {
        // überprüfung, ob der Eingabewert vom Typ WOERTERBUCHEINTRAG (WBE) ist
        WoerterbuchEintrag vergleichsWBE;
        vergleichsWBE = (WoerterbuchEintrag) dvergleich;
        if (wort.compareTo(vergleichsWBE.WortGeben()) > 0)
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
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    public boolean SchluesselIstGleich(String vergleichsSchluessel)
    {
        return (wort == vergleichsSchluessel);
    }

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    public boolean SchluesselIstGroesserAls(String vergleichsSchluessel)
    {
        if (wort.compareTo(vergleichsSchluessel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Geben-Methode zum Attribut wort
     *
     * @return das englische Wort
     */
    public String WortGeben()
    {
        return wort;
    }

    /**
     * Geben-Methode zum Attribut bedeutung
     *
     * @return bedeutung: die deutsche(n) Bedeutung(en) als eine Zeichenkette
     */
    public String BedeutungGeben()
    {
        return bedeutung;
    }

    /**
     * Setzen-Methode zum Attribut bedeutung
     *
     * @param bedeutungNeu neue Bedeutung für das englische Wort
     *
     */
    public void BedeutungSetzen(String bedeutungNeu)
    {
        bedeutung = bedeutungNeu;
    }
}
