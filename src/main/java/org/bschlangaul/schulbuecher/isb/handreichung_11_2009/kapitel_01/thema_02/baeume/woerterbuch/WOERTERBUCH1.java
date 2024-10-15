package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.woerterbuch;

/**
 * Stellt die speziellen Methoden für ein Wörterbuch zur Verfügung.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class WOERTERBUCH1 extends BAUM
{
    /**
     * keine speziellen Aufgaben
     */
    WOERTERBUCH1()
    {
        super();
    }

    /**
     * Gibt die übersetzung des angegebenen Begriffs auf Konsole aus.
     *
     * @param wort der zu übersetzende Begriff
     */
    void Uebersetzen(String wort)
    {
        WORT daten;
        daten = (WORT) Suchen(new WORT(wort, ""));
        if (daten != null)
        {
            daten.Ausgeben();
        }
        else
        {
            System.out.println("Unbekanntes Wort: " + wort);
        }
    }

    /**
     * Gibt den gesamten Inhalt des Lexions auf Konsole aus.
     */
    void InhaltAusgeben()
    {
        InOrder();
    }

    /**
     * Fügt ein neues Wort in das Wörterbuch ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param englisch der englische Begriff
     * @param deutsch die möglichen deutschen übersetzungen
     */
    void Einfuegen(String englisch, String deutsch)
    {
        Einfuegen(new WORT(englisch, deutsch));
    }
}
