package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_16.fussball;

/**
 * Verwaltung einer Bundesliga-Mannschaft
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Mannschaft implements Datenelement
{
    /** Name der Mannschaft */
    private String name;

    /** Punkte der Mannschaft */
    private int punkte;

    /** Anzahl bisheriger Spiele */
    private int spiele;

    /**
     * Konstruktor
     *
     * @param nameNeu Name der Mannschaft
     * @param punkteNeu momentaner Punktestand
     * @param spieleNeu aktuelle Anzahl der Spiele
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
    public String InformationGeben()
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
    public boolean IstKleinerAls(Datenelement d)
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
    public boolean SchlüsselIstGleich(String s)
    {
        return name == s;
    }

    /**
     * Gibt Information auf der Konsole aus.
     */
    public void InformationAusgeben()
    {
        System.out.println(name + ":  " + punkte + "   " + spiele);

    }
}
