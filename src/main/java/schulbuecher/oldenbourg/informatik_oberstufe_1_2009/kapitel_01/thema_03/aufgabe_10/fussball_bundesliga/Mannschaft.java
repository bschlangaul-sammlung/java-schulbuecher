package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_10.fussball_bundesliga;

/**
 * Verwaltung einer Bundesliga-Mannschaft
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Mannschaft implements DatenElement
{
    /**
     * Name der Mannschaft
     */
    private String name;

    /**
     * Punkte der Mannschaft
     */
    private int punkte;

    /**
     * Anzahl bisheriger Spiele
     */
    private int spiele;

    /**
     * Konstruktor
     *
     * @param nameNeu Name der Mannschaft
     * @param punkteNeu momentaner Punktestand
     */
    Mannschaft(String nameNeu, int punkteNeu, int spieleNeu)
    {
        name = nameNeu;
        punkte = punkteNeu;
        spiele = spieleNeu;
    }

    /**
     * Ausgabe von Name, Punkten und Anzahl der Spiele
     *
     * @return Zeichenkette aus Name, Punkten und Spielezahl
     */
    public String InformationAusgeben()
    {
        String s;
        s = name + ":  " + punkte + "   " + spiele;
        return s;
    }

    /**
     * Erhöht Punkte- und Spielezahl
     *
     * @param p hinzukommende Punkte
     */
    void SpielergebnisAufnehmen(int p)
    {
        punkte = punkte + p;
        spiele = spiele + 1;
    }

    /**
     * Vergleicht den Punktestand zweier Mannschaften
     *
     * @param d Datenelement (Mannschaft)
     *
     * @return Wahrheitswert
     */
    public boolean IstKleinerAls(DatenElement d)
    {
        Mannschaft m;
        m = (Mannschaft) d;
        return (punkte < m.punkte);
    }

    /**
     * Vergleicht die Schlüssel (Namen) zweier Mannschaften
     *
     * @param s gesuchter Name
     *
     * @return gefunden (true) oder nicht (false)
     */
    public boolean SchluesselIstGleich(String s)
    {
        return name == s;
    }
}
